package main.project.web.product.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import main.project.web.product.service.IProductService;

@Controller("productController")
@RequestMapping(value="/product")
public class ProductController {
	@Autowired
	private IProductService productService;

	@RequestMapping(value="/mainProduct.do", method=RequestMethod.GET)
	public String mainProduct(Model model, HttpSession session) {
		System.out.println("produdct GET »£√‚ ");
		return "product/mainProduct.part2";
	}
}
