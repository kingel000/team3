package main.project.web.chat.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import main.project.web.chat.service.IChatContentService;
import main.project.web.chat.service.IRoomListService;
import main.project.web.chat.service.IRoomLocationService;
import main.project.web.chat.vo.RoomListVO;
import main.project.web.member.vo.MemberVO;

@Controller("chatController")
@RequestMapping(value="/chat")
public class ChatController {
	@Autowired
	private IChatContentService chatContentService;
	@Autowired
	private IRoomListService roomListService;
	@Autowired
	private IRoomLocationService roomLocationService;
	
	@RequestMapping(value="/chat.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String chat (Model model,HttpSession session,HttpServletRequest req) throws Exception{
		MemberVO member = (MemberVO)session.getAttribute("member");
		if(member == null) {
			return "main/main.part2";
		}
		/*
		RoomListVO roomList = new RoomListVO("room"+roomListService.selectNumCount(),"asdf@asdf",member.getId());
		roomListService.createChatRoom(roomList);
		System.out.println("nickName:"+member.getNick_name());
		model.addAttribute("expertName","asdf");
		*/
		model.addAttribute("nickName",member.getNick_name());
		model.addAttribute("startDate",new SimpleDateFormat("yyyy.MM.dd").format(new Date()));
		return "chat/chat.part2";
	}
	
}
