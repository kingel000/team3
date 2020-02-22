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

import main.project.web.chat.service.IRoomListService;
import main.project.web.chat.service.IRoomLocationService;
import main.project.web.chat.vo.RoomListVO;
import main.project.web.chat.vo.RoomLocationVO;
import main.project.web.member.vo.MemberVO;
import main.project.web.product.vo.ProductVO;

@Controller("chatController")
@RequestMapping(value="/chat")
public class ChatController {

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
		model.addAttribute("nickName",member.getNick_name());
		model.addAttribute("startDate",new SimpleDateFormat("yyyy.MM.dd").format(new Date()));
		return "chat/chat.part2";
	}

	@RequestMapping(value="/createChat.do", method =RequestMethod.GET)
	public String createChat(Model model, HttpSession session, ProductVO product, String expertName)throws Exception{
		MemberVO member = (MemberVO)session.getAttribute("member");
		RoomListVO roomListVO = new RoomListVO(member.getId(),product.getProduct_num());
		System.out.println(roomListVO);
		RoomListVO roomCheck = roomListService.checkRoom(roomListVO);
		System.out.println(roomCheck);
		if(roomCheck == null) {
			Integer num = roomListService.selectNumCount()+1;
			System.out.println("room"+num);
			RoomListVO room = new RoomListVO("room"+num,product.getProduct_title(),product.getExpert_id(),member.getId(),product.getProduct_num());
			roomListService.createChatRoom(room);
			//방 시작 위치
			roomLocationService.startRoom(new RoomLocationVO(room.getMember_id(),room.getRoom_id()));
			model.addAttribute("room",room);
			//model.addAttribute("roomList",);
			
		}else {
			roomListService.updateRoom(roomCheck);
			roomLocationService.startRoom(new RoomLocationVO(roomCheck.getMember_id(),roomCheck.getRoom_id()));
			model.addAttribute("room",roomCheck);
		}
		model.addAttribute("expertName",expertName);
		model.addAttribute("startDate",new SimpleDateFormat("yyyy.MM.dd").format(new Date()));
		return "chat/chat.part2";
	}

}
