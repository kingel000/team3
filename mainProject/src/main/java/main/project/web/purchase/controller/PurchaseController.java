package main.project.web.purchase.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import main.project.web.product.service.IProductService;
import main.project.web.product.vo.ProductVO;
import main.project.web.purchase.Service.IPurchaseService;

@Controller("purchaseCntroller")
@RequestMapping(value = "/purchase")
public class PurchaseController {

		@Autowired
		private IPurchaseService purchaseService;
		@Autowired
		private IProductService productService;
		
		@RequestMapping(value="/addCart.do", method=RequestMethod.GET)
		public String addCart(@RequestParam String num,HttpSession session, Model model) {
			ProductVO product = productService.selectProduct(num);
			List<ProductVO> cartList = (List<ProductVO>) session.getAttribute("cartList");
			if(cartList == null) {
				cartList = new ArrayList<ProductVO>();
			}
			cartList.add(product);
			model.addAttribute("cartList", cartList);
			return null;
		}
		@RequestMapping(value="/myCart.do", method=RequestMethod.GET)
		public String basket() {
			return "purchase/myCart";
		}

		@RequestMapping(value="/checkout.do", method=RequestMethod.GET)
		public String checkout() {
			return "purchase/checkout";
		}
		
}
