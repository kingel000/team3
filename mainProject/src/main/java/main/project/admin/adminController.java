package main.project.admin;

import java.util.List;
import java.util.Locale;

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

@Controller("adminController")
@RequestMapping(value="/admin")
public class adminController {
	//* package  -> "main.project.admin
	//localhost:8080/web/admin/*.mdo
	
	@Autowired
	private IProductService productService;
	@Autowired
	private IMemberService memberService;
	
	
	@RequestMapping({"/","/admin.mdo"})
	public String home(Locale locale, Model model) {
		System.out.println("ADMIN MAIN MDO 호출");
		return "admin/adminMain";
	}
	
	@RequestMapping(value = "/adminDetail.mdo" , method = RequestMethod.POST )
	public String adminDetail() {
		System.out.println("ADMIN DETAIL MDO POST 호출");
		return "admin/adminDetail.page2";
	}
	
	
	//-----------멤버관리
	@RequestMapping(value="/memberManager.mdo",method = RequestMethod.GET)
	public String memberManager(HttpSession session,Model model) {
		System.out.println("memberManager mdo GET 호출 ");
		List<MemberVO> adminmemberList = memberService.selectAllMember();
		model.addAttribute("adminmemberList",adminmemberList);
		return "admin/adminMember.page2";
	}
	
	@RequestMapping(value = "/adminMemberDelete.mdo", method= RequestMethod.GET)
	public String adminMemberDelete(@RequestParam String id,MemberVO member, HttpSession session , Model model) {
		System.out.println("adminMemeberDelte.mdo GET 호출");
		System.out.println("넘어온 아이디 : " + id);
		member.setId(id);
		System.out.println(member);
		memberService.admindeleteMember(member);
		return "redirect:/admin/memberManager.mdo";
	}

	
	
	//-----------상품관리
	@RequestMapping(value = "/adminProduct.mdo", method= RequestMethod.GET )
	public String ProductManager( HttpSession session , Model model) {
		List<ProductVO> adminproductList = productService.selectA11ListProduct2();
		model.addAttribute("adminproductList", adminproductList);
		
		return "admin/adminProduct.page2";
	}
	
	@RequestMapping(value = "/adminProductDelete.mdo", method= RequestMethod.GET)
	public String adminProductDelete(@RequestParam String num,ProductVO product, HttpSession session , Model model) {
		product.setProduct_num(num);
		productService.deleteProduct(product);
		return "redirect:/admin/adminProduct.mdo";
	}
	
	//-----------홈페이지 관리
	@RequestMapping(value = "/adminHomePage.mdo", method= RequestMethod.GET)
	public String adminHomePageManager() {
		
		return "admin/adminHomePage.page2";
	}

	
	
}
