package main.project.web;

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
import org.springframework.web.bind.annotation.ResponseBody;

import main.project.web.product.service.IProductService;
import main.project.web.product.vo.ProductVO;
import main.project.web.banner.service.IBannerService;
import main.project.web.banner.vo.BannerVO;
import main.project.web.member.vo.MemberVO;
import main.project.web.purchase.Service.IPurchaseService;
import main.project.web.purchase.vo.CartVO;

@Controller
public class HomeController {
	@Autowired
	private IPurchaseService purchaseService;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private IProductService productService;
	@Autowired
	private IBannerService bannerService;

	@RequestMapping({ "/","/main/main.do"} )
	public String home(ProductVO product, HttpSession session, Model model) {
		
		List<ProductVO> newProductList = productService.newProductList();
		model.addAttribute("newProductList",newProductList);
		
		//banner
		BannerVO bannerVO = bannerService.selectBanner();
		logger.info("bannerVO"+bannerVO);
		model.addAttribute("bannerVO", bannerVO);
		
		return "main/main.part2";
	}
	
	@RequestMapping(value="/main/headCart.do", method=RequestMethod.POST)
	@ResponseBody
	public Object headCart(HttpSession session) {
		MemberVO member = (MemberVO) session.getAttribute("member");
		logger.info("+++");
		if(member != null) {
			List<CartVO> cartList = purchaseService.selectMyCart(member.getId());
			return cartList;
		}
		return null;
	}

	@RequestMapping(value = "/main/mainFind.do", method = RequestMethod.POST)
	public String mainFindList(@RequestParam String mainFindText, ProductVO product, HttpSession session, Model model) {
		logger.info("메인 상품검색창 검색이동");
		logger.info("검색어: " + mainFindText);
		List<ProductVO> mainFindList = productService.mainFindList(mainFindText);

		model.addAttribute("mainFindList", mainFindList);
		return "main/mainFind.part2";
	}
	

}
