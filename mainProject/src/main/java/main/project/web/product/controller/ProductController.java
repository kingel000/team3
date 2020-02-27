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

@Controller("productController")
@RequestMapping(value="/product")
public class ProductController {
	@Autowired
	private IProductService productService;
	@Autowired
	private IMemberService memberService;
	
	@RequestMapping(value="/mainProduct.do", method=RequestMethod.GET)
	public String mainProduct(@RequestParam String category,ProductVO product, Model model, HttpSession session) {
		System.out.println("produdct GET 호출 ");

		if(category.equals("'C1'")) {
			category ="웹 개발";
		}else if(category.equals("'C2'")) {
			category = "모바일앱·웹";
		}else if(category.equals("'C3'")) {
			category = "게임";
		}else if(category.equals("'C4'")) {
			category = "응용프로그래밍";
		}else if(category.equals("'C5'")) {
			category =	"기타";
		}
		System.out.println("선택한 카테고리 : " + category);
		List<ProductVO> productCategory = productService.selectCategory(category);
		List<String> nick = new ArrayList<String>(); 
		System.out.println("----");
		for(ProductVO productVO : productCategory) {
			System.out.println("DB 저장 카테고리별 상품 리스트 " + productVO);
			nick.add(memberService.checkMemberId(productVO.getExpert_id()).getNick_name());
		}
		model.addAttribute("productList",productCategory);
		model.addAttribute("nick",nick);
		
		return "product/mainProduct.part2";
	}
	
	@RequestMapping(value="/insertProduct.do", method=RequestMethod.GET)
	public String insertProduct(Model model) {
		System.out.println("produdct insert GET 호출 ");
		return "product/insertProduct.page";
	}
	@RequestMapping(value="/insertProduct.do", method=RequestMethod.POST)
	public String insertProduct(ProductVO product,HttpSession session ,Model model) {
		System.out.println("produdct insert POST 호출 ");
		
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
		System.out.println("수정하는 게시물의 정보 : "+ product);
	
		model.addAttribute("product", product);
		return "product/updateProduct.page";
	}

	@RequestMapping(value="/updateProduct.do", method = RequestMethod.POST)
	public String updateProduct(ProductVO product, Model model , HttpSession session) {
		System.out.println("updateProduct.do POST 받음 ");
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
		System.out.println("detailProduct GET 받음 ");
		System.out.println("선택한 상품 넘버 : " + num);
		ProductVO numProduct = productService.selectProduct(num);
		System.out.println("선택한 상품 정보 " + numProduct);
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
	
	//------------------------------장바구니-------------------------------------------

	@RequestMapping(value = "/cart.do", method = RequestMethod.GET)
	public String cartPage() {

		return "/product/cart.page";
	}
}
