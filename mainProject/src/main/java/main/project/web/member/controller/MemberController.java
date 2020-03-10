package main.project.web.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import main.project.web.mail.MailUtils;
import main.project.web.mail.TempKey;
import main.project.web.member.service.IExpertService;
import main.project.web.member.service.IMemberService;
import main.project.web.member.vo.ExpertVO;
import main.project.web.member.vo.MemberVO;
import main.project.web.product.service.IProductService;
@Controller("memberController")
@RequestMapping(value="/member")
public class MemberController {
	@Autowired
	private IMemberService memberService;
	@Autowired
	private IExpertService expertService;
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private IProductService productService;

	@RequestMapping(value="/login.do", method = RequestMethod.GET)
	public String memberLogin(Model model) {
		return "member/login";
	}

	@RequestMapping(value="/login.do", method = RequestMethod.POST)
	public String memberLogin(MemberVO member,HttpSession session, Model model) {
		System.out.println("로그인 시도 계정 정보 " + member);
		System.out.println(member.getId());
		System.out.println(member.getPwd());
		MemberVO check = memberService.selectMember(member);
		System.out.println(check);


		if(check != null) {
			if(check.getPwd().equals(member.getPwd())) {
				session.setAttribute("member", check);
				model.addAttribute("member", check);
				String msg = check.getNick_name()+" 님 환영합니다";
				System.out.println(msg);
				model.addAttribute("msg",msg);
				return "redirect:/main/main.do";
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
		return "member/login";
	}

	@RequestMapping(value="/regiser.do",method=RequestMethod.GET)
	public String memberRegiser(Model model) {
		return "member/regiser_f";
	}

	@RequestMapping(value="/regiser.do",method=RequestMethod.POST)
	public String memberRegiser(MemberVO member, Model model, HttpSession session) {
		memberService.insertMember(member);
		return "member/login";
	}

	@RequestMapping(value="/auth.do", method=RequestMethod.POST)
	public String memberAuth(MemberVO member, Model model,HttpServletResponse response) {
		MemberVO check = memberService.checkMemberId(member.getId());
		if(check == null) {
			String authKey = new TempKey().getKey(8, false);
			try {
				// mail 작성 관련기능
				MailUtils sendMail = new MailUtils(mailSender);
				StringBuffer stb = new StringBuffer();
				stb.append("<h1>[이메일 인증]</h1>");
				stb.append("<p>안녕하세요 회원님 저희 홈페이지를 찾아주셔서 감사합니다.</p>");
				stb.append("인증번호는 ");
				stb.append(authKey);
				stb.append(" 입니다.");

				sendMail.setSubject("회원가입 이메일 인증");
				sendMail.setText(stb.toString());
				sendMail.setFrom("item2881@gmail.com ", "Item");
				sendMail.setTo(member.getId());
				sendMail.send();
			} catch (MessagingException e1) {
				e1.printStackTrace();
			}catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			try {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter  out_email = response.getWriter();
				out_email.println("<script>alert('이메일이 발송되었습니다. 인증번호를 입력해주세요.');</script>");
				out_email.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			model.addAttribute("authKey", authKey);
			model.addAttribute("member", member);
		}else {
			try {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter  out_email = response.getWriter();
				out_email.println("<script>alert('입력한 아이디가 중복입니다. 아이디를 다시 입력해주세요.');</script>");
				out_email.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
			}
		}
		return "member/regiser_f";
	}

	@RequestMapping(value="/authKey.do", method=RequestMethod.POST)
	public String memberAuthKey(MemberVO member,String key, String authKey, Model model) {
		if(authKey.equals(key)) {
			model.addAttribute("member",member);
			return "member/regiser_s";
		}
		return "member/regiser_f";
	}

	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	public String memberLogout(HttpSession session, Model model) {
		session.invalidate();
		return "redirect:/main/main.do";
	}

	@RequestMapping(value="/mypage.do", method = RequestMethod.GET)
	public String memberMyPage(HttpSession session,Model model) {
		System.out.println("mypage GET 호출");
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		model.addAttribute("member",memberVO);
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
		System.out.println("수정하는 전문가 정보 : "  + expert);
		model.addAttribute("expert", expert) ;
		return "member/editExpert.page";
	}

	@RequestMapping(value="/editExpert.do", method=RequestMethod.POST)
	public String editExpert(ExpertVO expert, Model model) {
		System.out.println(expert);
		expertService.updateExpert(expert);
		return "member/mypage.page";
	}

	@RequestMapping(value="/withdrawal.do", method= RequestMethod.GET)
	public String Withdrawal(MemberVO member, Model model) {
		System.out.println("회원 탈퇴 GET 호출");
		
		
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
					productService.deleteProductId(check.getId());
				}
				String msg = "회원탈퇴 되었습니다.";
				model.addAttribute("msg",msg);
				return "redirect:/main/main.do";
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

		return "redirect:main/main.do";
	}

	@RequestMapping(value="/masterPage.do", method = RequestMethod.GET)
	public String masterPage(Model model , HttpSession session) {
		System.out.println("masterPage GET 호출");
		return "member/masterPage";
	}

	@RequestMapping(value="/masterPage.do", method = RequestMethod.POST)
	public String masterPage(MemberVO member, Model model , HttpSession session) {
		System.out.println("masterPage POST 호출");
		return "member/masterDetail.page2";



	}
}