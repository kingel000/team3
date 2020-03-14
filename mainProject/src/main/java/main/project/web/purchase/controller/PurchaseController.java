package main.project.web.purchase.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import main.project.web.chat.service.IRoomListService;
import main.project.web.chat.vo.RoomListVO;
import main.project.web.member.service.ExpertService;
import main.project.web.member.service.IExpertService;
import main.project.web.member.vo.ExpertVO;
import main.project.web.member.vo.MemberVO;
import main.project.web.product.service.IProductService;
import main.project.web.product.vo.ProductVO;
import main.project.web.purchase.PaymentCheck;
import main.project.web.purchase.Service.IPurchaseService;
import main.project.web.purchase.vo.CartVO;
import main.project.web.purchase.vo.PurchaseVO;

@Controller("purchaseCntroller")
@RequestMapping(value = "/purchase")
public class PurchaseController {

	@Autowired
	private IPurchaseService purchaseService;
	@Autowired
	private IProductService productService;
	@Autowired
	private IRoomListService roomListService;
	@Autowired
	private IExpertService expertService;

	private static final Logger logger = LoggerFactory.getLogger(PurchaseController.class);
	
	@RequestMapping(value="/addCart.do", method=RequestMethod.POST)
	public String addCart(String price,ProductVO product,HttpSession session, Model model) {	
		MemberVO member = (MemberVO)session.getAttribute("member");
		RoomListVO roomListVO = new RoomListVO(member.getId(),product.getProduct_num());
		RoomListVO roomCheck = roomListService.checkRoom(roomListVO);
		if(price == null || roomCheck == null) {
			String msg = "Expert";
			return "redirect:/product/detailP.do?num="+product.getProduct_num()+"&&msg="+msg;
		}
		String date = (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
		String expertNick = productService.select_NickName(product.getExpert_id()).getNick_name();
		ProductVO productVO = productService.selectThumbnail(product.getProduct_num());
		String Thumbnail = productVO.getThumbnail();
		logger.info(product.getProduct_num() + "번호에 대한 썸네일 링크 : " + Thumbnail);
		logger.info("select 한 상품 정보 " + productVO);
		CartVO cart = new CartVO(date,member.getId(),product.getProduct_num(),product.getProduct_title(),Integer.parseInt(price),expertNick,Thumbnail);
		logger.info("장바구니에 추가하는 상품의 정보 : " + cart);
		purchaseService.addCart(cart);
		return "redirect:/purchase/myCart.do";
	}

	@RequestMapping(value="/deleteCart", method=RequestMethod.GET)
	public String deleteCart(@RequestParam String num, HttpSession session, Model model) {
		purchaseService.deleteCart(num);
		return "redirect:/main/main.do";
	}

	@RequestMapping(value="/myCart.do", method=RequestMethod.GET)
	public String myCart(HttpSession session, Model model) {
		MemberVO member = (MemberVO) session.getAttribute("member");
		List<CartVO> cartList = purchaseService.selectMyCart(member.getId());
		if(cartList != null) {

			model.addAttribute("cartList",cartList);
		}
		return "purchase/myCart.page";
	}

	@RequestMapping(value="/success.do")
	public String success(@RequestParam String cartNum,@RequestParam String mid, HttpSession session, Model model) {
		CartVO cart = purchaseService.getCart(cartNum);
		ProductVO product = productService.selectProduct(cart.getProduct_num());
		PurchaseVO purchase = new PurchaseVO(mid, cart.getProduct_num(), "Waiting", cart.getMember_id(), cart.getPrice(),product.getExpert_id());
		purchaseService.insertPurchase(purchase);
		purchaseService.deleteCart(cartNum);
		MemberVO member = (MemberVO) session.getAttribute("member");
		List<CartVO> cartList = purchaseService.selectMyCart(member.getId());
		if(cartList != null) {
			model.addAttribute("cartList",cartList);
		}

		return "purchase/myCart.page";
	}

	@RequestMapping(value="/checkout.do", method=RequestMethod.POST)
	public String checkout(CartVO cart, HttpSession session, Model model) {
		MemberVO member = (MemberVO)session.getAttribute("member");
		String mid = "mid" + (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
		model.addAttribute("mid", mid);
		model.addAttribute("cart", cart);
		model.addAttribute("memberName", member.getNick_name());

		return "purchase/checkout";
	}

	@RequestMapping(value="/orderList.do", method = RequestMethod.GET)
	public String orderListProduct(HttpSession session, Model model) {
		MemberVO member = (MemberVO) session.getAttribute("member");
		List<PurchaseVO> purchaseList = purchaseService.selectPurchaseList(member.getId());
		List<ProductVO> productList = new ArrayList<ProductVO>();
		int[] count = {0,0,0,0};
		if(purchaseList.size()>0) {
			for(PurchaseVO purchase:purchaseList) {
				switch(purchase.getPurchase_state()) {
				case "Waiting":
					count[0]++;
					break;
				case "Running":
					count[1]++;
					break;
				case "Success":
					count[2]++;
					break;
				case "Cancel":
					count[3]++;
					break;
				}
				productList.add(productService.selectProduct(purchase.getProduct_num()));
			}
			model.addAttribute("productList", productList);
			model.addAttribute("countList", count);
		}
		model.addAttribute("purchaseList", purchaseList);
		return "purchase/orderList.page";
	}

	@RequestMapping(value="/selectMemberOrder.do",method=RequestMethod.GET)
	public String selectMemberOrder(@RequestParam String status,HttpSession session, Model model) {
		MemberVO member = (MemberVO) session.getAttribute("member");
		List<PurchaseVO> purchaseList = purchaseService.selectPurchaseList(member.getId());
		int[] count = {0,0,0,0};
		if(purchaseList.size()>0) {
			for(PurchaseVO purchase:purchaseList) {
				switch(purchase.getPurchase_state()) {
				case "Waiting":
					count[0]++;
					break;
				case "Running":
					count[1]++;
					break;
				case "Success":
					count[2]++;
					break;
				case "Cancel":
					count[3]++;
					break;
				}
			}
			model.addAttribute("countList", count);
			List<ProductVO> productList = new ArrayList<ProductVO>();
			List<PurchaseVO> orderList = purchaseService.selectMemberOrder(new PurchaseVO(status,member.getId()));
			for(PurchaseVO purchase: orderList) {
				productList.add(productService.selectProduct(purchase.getProduct_num()));
			}
			model.addAttribute("productList", productList);
			model.addAttribute("purchaseList", orderList);
		}	
		return "purchase/orderList.page";
	}

	@RequestMapping(value="/successOrder.do", method = RequestMethod.POST)
	public String successOrder(PurchaseVO purchase) {
		logger.info("+++ 최종 구매 확정 버튼 클릭 +++");
		purchase.setPurchase_state("Success");
		PurchaseVO purchaseVO = purchaseService.selectPurchase(purchase.getPurchase_num());
		ExpertVO expertVO = expertService.selectExpert(purchaseVO.getExpert_id());
		Integer point = expertVO.getPoint();
		Integer UpPoint = point + purchaseVO.getPurchase_price();
		ExpertVO expert = new ExpertVO();
		expert.setId(purchaseVO.getExpert_id());
		expert.setPoint(UpPoint);
		expertService.updatePointExpert(expert);
		purchaseService.updatePurchase(purchase);
		return "redirect:/purchase/orderList.do";
	}
	
	@RequestMapping(value="/salesList.do", method = RequestMethod.GET)
	public String salesListProduct(HttpSession session,Model model) {
		MemberVO member = (MemberVO) session.getAttribute("member");
		List<PurchaseVO> purchaseList = purchaseService.selectExpertPurchase(member.getId());
		List<ProductVO> productList = new ArrayList<ProductVO>();
		int[] count = {0,0,0,0};
		if(purchaseList.size()>0) {
			for(PurchaseVO purchase:purchaseList) {
				switch(purchase.getPurchase_state()) {
				case "Waiting":
					count[0]++;
					break;
				case "Running":
					count[1]++;
					break;
				case "Success":
					count[2]++;
					break;
				case "Cancel":
					count[3]++;
					break;
				}
				productList.add(productService.selectProduct(purchase.getProduct_num()));
			}
			model.addAttribute("productList", productList);
			model.addAttribute("countList", count);
		}
		model.addAttribute("purchaseList", purchaseList);
		return "purchase/salesList.page";
	}
	
	@RequestMapping(value="/selectExpertOrder.do",method=RequestMethod.GET)
	public String selectExpertOrder(@RequestParam String status,HttpSession session, Model model) {
		MemberVO member = (MemberVO) session.getAttribute("member");
		List<PurchaseVO> purchaseList = purchaseService.selectExpertPurchase(member.getId());
		int[] count = {0,0,0,0};
		if(purchaseList.size()>0) {
			for(PurchaseVO purchase:purchaseList) {
				switch(purchase.getPurchase_state()) {
				case "Waiting":
					count[0]++;
					break;
				case "Running":
					count[1]++;
					break;
				case "Success":
					count[2]++;
					break;
				case "Cancel":
					count[3]++;
					break;
				}
			}
			model.addAttribute("countList", count);
			List<ProductVO> productList = new ArrayList<ProductVO>();
			PurchaseVO p = new PurchaseVO();
			p.setExpert_id(member.getId());
			p.setPurchase_state(status);
			List<PurchaseVO> orderList = purchaseService.selectExpertOrder(p);
			for(PurchaseVO purchase: orderList) {
				productList.add(productService.selectProduct(purchase.getProduct_num()));
			}
			model.addAttribute("productList", productList);
			model.addAttribute("purchaseList", orderList);
		}	
		return "purchase/salesList.page";
	}

	@RequestMapping(value="/workStart.do",method=RequestMethod.POST)
	public String workStart(PurchaseVO purchase) {
		purchase.setPurchase_state("Running");
		purchaseService.updatePurchase(purchase);
		return "redirect:/purchase/salesList.do";
	}
	
	@RequestMapping(value="/paymentCancel.do",method=RequestMethod.POST)
	public String PaymentCancel(PurchaseVO purchase) {
		PaymentCheck pay = new PaymentCheck();
		purchase.setPurchase_state("Cancel");
		purchaseService.updatePurchase(purchase);
		pay.cancelPayment(pay.getImportToken(),purchase.getPurchase_num(),"Cancel payment");
		return "redirect:/purchase/salesList.do";
	}
	
}
