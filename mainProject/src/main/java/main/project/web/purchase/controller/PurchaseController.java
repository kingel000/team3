package main.project.web.purchase.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import main.project.web.member.service.IMemberService;
import main.project.web.product.service.IProductService;
import main.project.web.product.vo.ProductVO;
import main.project.web.purchase.Service.IPurchaseService;
import main.project.web.purchase.vo.PurchaseVO;

@Controller("purchaseCntroller")
@RequestMapping(value = "/purchase")
public class PurchaseController {

		@Autowired
		private IPurchaseService purchaseService;
		@Autowired
		private IProductService productService;
		
	
}
