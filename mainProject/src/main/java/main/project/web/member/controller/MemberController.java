package main.project.web.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import main.project.web.member.service.IExpertService;
import main.project.web.member.service.IMemberService;
import main.project.web.member.vo.ExpertVO;
import main.project.web.member.vo.MemberVO;

@Controller("memberController")
@RequestMapping(value="/member")
public class MemberController {
	@Autowired
	private IMemberService memberService;
	@Autowired
	private IExpertService expertService;


	@RequestMapping(value="/login.do", method = RequestMethod.GET)
	public String memberLogin(Model model) {
		return "member/login";
	}

	@RequestMapping(value="/login.do", method = RequestMethod.POST)
	public String memberLogin(MemberVO member,HttpSession session, Model model) {
		System.out.println(member.getId());
		System.out.println(member.getPwd());
		MemberVO check = memberService.selectMember(member);
		if(check != null) {
			if(check.getPwd().equals(member.getPwd())) {
				session.setAttribute("member", check);
				model.addAttribute("member", check);
				return "main/main.part2";
			}else {
				String msg = "비밀번호 오류";
				System.out.println(msg);
				model.addAttribute("msg", msg);
			}
		}else {
			String msg = "아이디 없음";
			System.out.println("아이디 없음");
			model.addAttribute("msg", msg);
		}
		String msg = "회원가입 되었습니다.";
		model.addAttribute("msg",msg);
		return "member/login";
	}

	@RequestMapping(value="/regiser.do",method=RequestMethod.GET)
	public String memberRegiser(Model model) {
		return "member/regiser";
	}

	@RequestMapping(value="/regiser.do",method=RequestMethod.POST)
	public String memberRegiser(MemberVO member, Model model) {
		System.out.println(member.getRank());
		memberService.insertMember(member);
		return "member/login";
	}

	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	public String memberLogout(HttpSession session, Model model) {
		session.invalidate();
		return "main/main.part2";
	}

	@RequestMapping(value="/mypage.do", method = RequestMethod.GET)
	public String memberMyPage() {
		return "member/mypage.page";
	}

	@RequestMapping(value="/editMember.do", method=RequestMethod.GET)
	public String editMember(HttpSession session, Model model) {
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		model.addAttribute("member", memberVO);
		return "member/editMember.page";
	}
	
	@RequestMapping(value="/editMember.do", method=RequestMethod.POST)
	public String editMember(String password, MemberVO member,HttpSession session,Model model) {
		MemberVO  check = (MemberVO) session.getAttribute("member");
		if(check.getPwd().equals(password)) {
			memberService.updateMember(member);
			session.setAttribute("member", member);
			model.addAttribute("member",member);
			String msg = "회원정보 변경완료";
			model.addAttribute("msg",msg);
			return "member/editMember.page";
		}
		String msg = "비밀번호 다시 확인";
		model.addAttribute("msg",msg);
		return "member/editMember.page";
	}
	@RequestMapping(value="/rankUp.do", method = RequestMethod.GET)
	public String rankUpPage() {
		return "member/rankUp.page";
	}

	@RequestMapping(value="/rankUp.do", method = RequestMethod.POST)
	public String rankUpPage(ExpertVO expert , Model model , HttpSession session) {
		MemberVO member = (MemberVO)session.getAttribute("member");
		String sessionId =member.getId();
		expert.setId(sessionId);
		System.out.println(expert);
		expertService.insertExpert(expert);
		memberService.rankupdate(sessionId);
		member.setRank("E");
		session.setAttribute("member", member);
		return "member/mypage.page";
	}
	
	@RequestMapping(value="/editExpert.do",method=RequestMethod.GET)
	public String editExpert(HttpSession session,Model model) {
		ExpertVO expert = expertService.selectExpert(((MemberVO)session.getAttribute("member")).getId());
		model.addAttribute("expert", expert);
		return "member/editExpert.page";
	}
	
	@RequestMapping(value="/editExpert.do", method=RequestMethod.POST)
	public String editExpert(ExpertVO expert, Model model) {
		expertService.updateExpert(expert);
		return "member/mypage.page";
	}

	@RequestMapping(value="/withdrawal.do", method= RequestMethod.GET)
	public String Withdrawal() {
		return "member/withdrawal.page";
	}

	@RequestMapping(value="/withdrawal.do", method= RequestMethod.POST)
	public String Withdrawal(String password ,Model model, HttpSession session) {
		MemberVO  check = (MemberVO) session.getAttribute("member");

		System.out.println("check : " + check);
		System.out.println("password : " + password);
		if(password != null) {
			if(check.getPwd().equals(password)) {
				session.invalidate();
				memberService.deleteMember(check);
				if(check.getRank().equals("E")) {
					expertService.deleteExpert(check.getId());
				}
				String msg = "회원탈퇴 되었습니다.";
				model.addAttribute("msg",msg);
				return "main/main.part2";
			}
		}
		String msg = "비밀번호 다시 확인";
		model.addAttribute("msg",msg);
		return "member/mypage.page";
	}
	
	   @RequestMapping(value="/boardManager.do", method = RequestMethod.GET)
	   public String editBoard(ExpertVO expert, HttpSession session , Model model) {
	      String sessionId = ((MemberVO)session.getAttribute("member")).getId();
	      expert.setId(sessionId);
	      System.out.println(expert);
	      session.setAttribute("expert",expert);
	      return "member/boardManager.page";
	   }

	   @RequestMapping(value="/boardManager.do", method = RequestMethod.POST)
	   public String editBoard(ExpertVO expert , Model model , HttpSession session) {

	      return "main/main.part2";
	   }
}
