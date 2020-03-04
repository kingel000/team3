package main.project.web.purchase.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import main.project.web.member.vo.MemberVO;
import main.project.web.product.service.IProductService;
import main.project.web.product.vo.ProductVO;
import main.project.web.purchase.Service.IPurchaseService;
import main.project.web.purchase.vo.CartVO;

@Controller("purchaseCntroller")
@RequestMapping(value = "/purchase")
public class PurchaseController {

	@Autowired
	private IPurchaseService purchaseService;
	@Autowired
	private IProductService productService;

	@RequestMapping(value="/addCart.do", method=RequestMethod.POST)
	public String addCart(String price,ProductVO product,HttpSession session, Model model) {		
		if(price == null) {
			return "redirect:/product/detailProduct.do?num="+product.getProduct_num();
		}
		MemberVO member = (MemberVO)session.getAttribute("member");
		String date = (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
		String expertNick = productService.select_NickName(product.getExpert_id()).getNick_name();
		System.out.println("expertNick: "+expertNick);
		CartVO cart = new CartVO(date,member.getId(),product.getProduct_num(),product.getProduct_title(),Integer.parseInt(price),expertNick);
		purchaseService.addCart(cart);
		return "redirect:/main/main.do";
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
		return "purchase/myCart";
	}

	@RequestMapping(value="/checkout.do", method=RequestMethod.GET)
	public String checkout() {
		return "purchase/checkout";
	}

}
