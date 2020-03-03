package main.project.web;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import main.project.web.product.service.IProductService;
import main.project.web.product.service.ProductService;
import main.project.web.product.vo.ProductVO;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	 @Autowired
	   private IProductService productService;
	
	@RequestMapping({ "/","/main/main.do"} )
	public String home(Locale locale, Model model) {
		
		
		return "main/main.part2";
	}
	
	@RequestMapping(value = "/main/mainFind.do", method = RequestMethod.POST)
	public String mainFindList(@RequestParam String mainFindText, ProductVO product, HttpSession session, Model model) {
		System.out.println("메인 상품검색창 검색이동");
		System.out.println("검색어: " + mainFindText);
		List<ProductVO> mainFindList = productService.mainFindList(mainFindText);
		System.out.println(mainFindList);
		
		model.addAttribute("mainFindList", mainFindList);
		return "main/mainFind.part2";
	}
	
}
