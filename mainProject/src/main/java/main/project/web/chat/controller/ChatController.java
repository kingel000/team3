package main.project.web.chat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import main.project.web.member.vo.MemberVO;

@Controller("chatController")
@RequestMapping(value="/chat")
public class ChatController {
	
	@RequestMapping(value="/chat.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String chat (Model model,HttpSession session,HttpServletRequest req) throws Exception{
		//MemberVO member = (MemberVO)session.getAttribute("member");
		//System.out.println("memberId:"+member.getId());
		return "chat/chat";
	}
	
}
