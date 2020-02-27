package main.project.web.purchase.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("purchaseController")
@RequestMapping(value="/purchase")
public class PurchaseController {

	@RequestMapping(value="/myCart.do", method=RequestMethod.GET)
	public String basket() {
		return "purchase/myCart";
	}
	
	@RequestMapping(value="/checkout.do", method=RequestMethod.GET)
	public String checkout() {
		return "purchase/checkout";
	}
}
