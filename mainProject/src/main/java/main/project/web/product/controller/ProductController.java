package main.project.web.product.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import main.project.web.member.service.IMemberService;
import main.project.web.member.vo.ExpertVO;
import main.project.web.member.vo.MemberVO;
import main.project.web.product.service.IProductService;
import main.project.web.product.vo.ProductVO;
import main.project.web.purchase.vo.PurchaseVO;

@Controller("productController")
@RequestMapping(value="/product")
public class ProductController {
	@Autowired
	private IProductService productService;
	@Autowired
	private IMemberService memberService;
	
	@RequestMapping(value="/mainProduct.do", method=RequestMethod.GET)
	public String mainProduct(@RequestParam String category,ProductVO product, Model model, HttpSession session) {
		System.out.println("produdct GET �샇異� ");

		if(category.equals("'C1'")) {
			category ="�쎒 媛쒕컻";
		}else if(category.equals("'C2'")) {
			category = "紐⑤컮�씪�빋쨌�쎒";
		}else if(category.equals("'C3'")) {
			category = "寃뚯엫";
		}else if(category.equals("'C4'")) {
			category = "�쓳�슜�봽濡쒓렇�옒諛�";
		}else if(category.equals("'C5'")) {
			category =	"湲고�";
		}
		System.out.println("�꽑�깮�븳 移댄뀒怨좊━ : " + category);
		List<ProductVO> productCategory = productService.selectCategory(category);
		List<String> nick = new ArrayList<String>(); 
		System.out.println("----");
		for(ProductVO productVO : productCategory) {
			System.out.println("DB ���옣 移댄뀒怨좊━蹂� �긽�뭹 由ъ뒪�듃 " + productVO);
			nick.add(memberService.checkMemberId(productVO.getExpert_id()).getNick_name());
		}
		model.addAttribute("productList",productCategory);
		model.addAttribute("nick",nick);
		
		return "product/mainProduct.part2";
	}
	
	@RequestMapping(value="/insertProduct.do", method=RequestMethod.GET)
	public String insertProduct(Model model) {
		System.out.println("produdct insert GET �샇異� ");
		return "product/insertProduct.page";
	}
	@RequestMapping(value="/insertProduct.do", method=RequestMethod.POST)
	public String insertProduct(ProductVO product,HttpSession session ,Model model) {
		System.out.println("produdct insert POST �샇異� ");
		
		MemberVO member = (MemberVO) session.getAttribute("member");
		System.out.println(member.getId());
		
		String sessionId = member.getId();
		product.setExpert_id(sessionId);
		product.setProduct_num("A012");
		System.out.println(product);
		productService.insertProduct(product);
//		session.setAttribute("member", member);
		
		return "product/insertProduct.page";
	}

	@RequestMapping(value="/boardManager.do", method = RequestMethod.GET)
	public String editBoard(ExpertVO expert, HttpSession session , Model model) {
		MemberVO sessionId = (MemberVO)session.getAttribute("member");
		expert.setId(sessionId.getId());
		System.out.println(expert);
		session.setAttribute("expert",expert);
		List<ProductVO> productList = productService.selectListProduct(sessionId);
		for(ProductVO product : productList) {
			System.out.println(product);
		}
		model.addAttribute("productList",productList);
		return "product/boardManager.page";
	}

	@RequestMapping(value="/boardManager.do", method = RequestMethod.POST)
	public String editBoard(ExpertVO expert , Model model , HttpSession session) {

		return "main/main.part2";
	}
	
	@RequestMapping(value="/updateProduct.do", method = RequestMethod.GET)
	public String updateProduct(@RequestParam String num, HttpSession session , Model model) {
		ProductVO product = productService.selectProduct(num);
		System.out.println("�닔�젙�븯�뒗 寃뚯떆臾쇱쓽 �젙蹂� : "+ product);
	
		model.addAttribute("product", product);
		return "product/updateProduct.page";
	}

	@RequestMapping(value="/updateProduct.do", method = RequestMethod.POST)
	public String updateProduct(ProductVO product, Model model , HttpSession session) {
		System.out.println("updateProduct.do POST 諛쏆쓬 ");
		System.out.println(product);
		productService.updateProduct(product);
		return "/product/boardManager.page";
	}
	
	@RequestMapping(value="/deleteProduct.do", method = RequestMethod.GET)
	public String deleteProduct(@RequestParam String num, HttpSession session , Model model) {
		ProductVO product = productService.selectProduct(num);
		System.out.println("product : "+ product);
		productService.deleteProduct(product);
		return "redirect:/product/boardManager.do";
	}

	@RequestMapping(value="/detailProduct.do", method = RequestMethod.GET)
	public String detailProduct(@RequestParam String num,ProductVO product, Model model , HttpSession session, MemberVO member) {
		System.out.println("detailProduct GET 諛쏆쓬 ");
		System.out.println("�꽑�깮�븳 �긽�뭹 �꽆踰� : " + num);
		ProductVO numProduct = productService.selectProduct(num);
		System.out.println("�꽑�깮�븳 �긽�뭹 �젙蹂� " + numProduct);
		model.addAttribute("numProduct",numProduct);
		
		MemberVO nick_name = new MemberVO();
		nick_name = productService.select_NickName(numProduct.getExpert_id());
		model.addAttribute("exper_id",numProduct.getExpert_id());
		model.addAttribute("nick_name",nick_name);
	
		
		return "/product/detailProduct.part2";
	}
	
	@RequestMapping(value="/detailProduct.do", method = RequestMethod.POST)
	public String detailProduct(ProductVO product, Model model , HttpSession session) {

		return "/product/boardManager.page";
	}
	

	// 장바구니
	@RequestMapping(value = "/cart.do", method = RequestMethod.GET)
	public String cartPage(ProductVO product, Model model , HttpSession session) {
		
		String num = product.getProduct_num();
		
		System.out.println(num);
		
		return "/product/cart.page";
	}
	
	
}
