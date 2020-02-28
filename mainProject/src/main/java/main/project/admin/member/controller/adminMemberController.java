package main.project.admin.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import main.project.web.member.service.IMemberService;
import main.project.web.member.vo.MemberVO;



@Controller("adminMemberController")
@RequestMapping(value="/admin")
public class adminMemberController {

	
	@RequestMapping(value="/memberManager.mdo",method = RequestMethod.GET)
	public String memberManager(HttpSession session,Model model) {
		System.out.println("memberManager mdo GET »£√‚ ");

		return "admin/adminMember.page2";
	}

}
