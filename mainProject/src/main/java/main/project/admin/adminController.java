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

import main.project.web.member.service.IExpertService;
import main.project.web.member.service.IMemberService;

import main.project.web.member.service.MemberService;

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
	@Autowired
	private IExpertService expertService;

	
	@RequestMapping({"/","/admin.mdo"})
	public String home(Locale locale, Model model) {
		System.out.println("ADMIN MAIN MDO 호출");
		return "admin/adminMain";
	}
	
	@RequestMapping(value = "/adminDetail.mdo" , method = RequestMethod.POST )
	public String adminDetail(MemberVO member,HttpSession session, Model model) {
		System.out.println("ADMIN DETAIL MDO POST 호출");
		System.out.println(member.getId());
		System.out.println(member.getPwd());
		MemberVO check = memberService.selectMember(member);
		System.out.println(check);
		
		if(check != null) {
			if(check.getPwd().equals(member.getPwd())) {
				if(check.getRank().equals("M")) {
					session.setAttribute("member", check);
					model.addAttribute("member", check);
					return "admin/adminDetail.page2";
				}else {
					String msg = "관리자 아이디가 입니다. 위의 링크를 눌러 메인페이지로 이동하세요";
					model.addAttribute("msg", msg);
				}
			}else {
				String msg = "비밀번호 오류입니다.";
				model.addAttribute("msg", msg);
			}
		}else {
			String msg = "존재하지 않는 아이디 입니다.";
			model.addAttribute("msg", msg);
		}

		
		return "admin/adminMain";
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
	
	@RequestMapping(value = "/adminmemberEdit.mdo", method= RequestMethod.GET)
	public String adminmemberEdit(@RequestParam String id,MemberVO member, HttpSession session , Model model) {
		
		MemberVO memberVO = (MemberVO)memberService.selectMember(member);
		ExpertVO expertVO = (ExpertVO)expertService.selectExpert(id);
		System.out.println("수정하고자 하는 판매자 정보:" + expertVO);
		System.out.println("수정하고자 하는 계정 정보 "  + memberVO);
		model.addAttribute("expert",expertVO);
		model.addAttribute("member",memberVO);
		return "admin/adminMemberDetail.page2";
	}
	@RequestMapping(value = "/adminmemberEdit.mdo", method= RequestMethod.POST)
	public String adminmemberEdit(ExpertVO expert,MemberVO member, Model model , HttpSession session) {
		System.out.println("수정된 멤버 정보 : " + member);
		System.out.println("수정된 판매자 정보 : " + expert);
		if(member.getRank() == null || member.getRank() == "") {
			System.out.println("if 문 들어왔음");
			String rank = memberService.selectMember(member).getRank();
			System.out.println(rank);
			
			member.setRank(rank);
			
		}
		if(member.getPwd() == null || member.getPwd() == "") {
			System.out.println("pwd if 문 들어옴");
			String pwd = memberService.selectMember(member).getPwd();
			System.out.println(pwd);
			
			member.setPwd(pwd);
		}
		System.out.println(member);
		memberService.updateMember(member);
		expertService.updateExpert(expert);
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
