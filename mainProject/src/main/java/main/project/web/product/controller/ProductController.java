package main.project.web.product.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import main.project.web.member.vo.ExpertVO;
import main.project.web.member.vo.MemberVO;
import main.project.web.product.service.IProductService;
import main.project.web.product.vo.ProductVO;

@Controller("productController")
@RequestMapping(value="/product")
public class ProductController {
	@Autowired
	private IProductService productService;

	@RequestMapping(value="/mainProduct.do", method=RequestMethod.GET)
	public String mainProduct(Model model, HttpSession session) {
		System.out.println("produdct GET 호출 ");
		return "product/mainProduct.part2";
	}
	@RequestMapping(value="/updateProduct.do", method=RequestMethod.GET)
	public String updateProduct(Model model) {
		System.out.println("produdct update GET 호출 ");
		return "product/updateProduct.page";
	}

	@RequestMapping(value="/updateProduct.do", method=RequestMethod.POST)
	public String updateProduct(ProductVO product,Model model,HttpSession session) {
		System.out.println("produdct update POST 호출 ");
		return "product/updateProduct.page";
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
		session.setAttribute("productList",productList);
		return "product/boardManager.page";
	}

	@RequestMapping(value="/boardManager.do", method = RequestMethod.POST)
	public String editBoard(ExpertVO expert , Model model , HttpSession session) {

		return "main/main.part2";
	}
}
