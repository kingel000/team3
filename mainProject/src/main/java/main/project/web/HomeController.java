package main.project.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import main.project.web.member.vo.MemberVO;
import main.project.web.purchase.Service.IPurchaseService;
import main.project.web.purchase.vo.CartVO;

@Controller
public class HomeController {
	@Autowired
	private IPurchaseService purchaseService;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping({ "/","/main/main.do"} )
	public String home(HttpSession session, Model model) {
		MemberVO member = (MemberVO) session.getAttribute("member");
		if(member != null) {
			List<CartVO> cartList = purchaseService.selectMyCart(member.getId());
			if(cartList != null) {
				model.addAttribute("cartList",cartList);
				if(cartList.size() != 0) {
					model.addAttribute("count",cartList.size());
				}
			}
		}
		
		return "main/main.part2";
	}
	
}
