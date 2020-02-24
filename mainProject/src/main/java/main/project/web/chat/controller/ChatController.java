package main.project.web.chat.controller;


import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import main.project.web.chat.service.IRoomListService;
import main.project.web.chat.vo.RoomListVO;
import main.project.web.member.vo.MemberVO;
import main.project.web.product.vo.ProductVO;

@Controller("chatController")
@RequestMapping(value="/chat")
public class ChatController {

	@Autowired
	private IRoomListService roomListService;

	@RequestMapping(value="/chat.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String chat (Model model,HttpSession session) throws Exception{
		MemberVO member = (MemberVO)session.getAttribute("member");
		if(member == null) {
			return "main/main.part2";
		}
		model.addAttribute("memberName",member.getNick_name());
		List<RoomListVO> roomList = roomListService.getMemberList(member.getId());
		model.addAttribute("roomList",roomList);
		return "chat/chat.part2";
	}

	@RequestMapping(value="/createChat.do", method =RequestMethod.GET)
	public String createChat(Model model, HttpSession session, ProductVO product, String expertName)throws Exception{
		MemberVO member = (MemberVO)session.getAttribute("member");
		if(member == null) {
			return "main/main.part2";
		}
		model.addAttribute("memberName",member.getNick_name());

		RoomListVO roomListVO = new RoomListVO(member.getId(),product.getProduct_num());
		System.out.println("roomListVO:"+roomListVO);
		RoomListVO roomCheck = roomListService.checkRoom(roomListVO);
		System.out.println("roomCheck:"+roomCheck);
		if(roomCheck == null) {
			Integer num = roomListService.selectNumCount()+1;
			System.out.println("room"+num);
			RoomListVO room = new RoomListVO("room"+num,product.getProduct_title(),product.getExpert_id(),member.getId(),product.getProduct_num());
			roomListService.createChatRoom(room);

			model.addAttribute("room",room);
			session.setAttribute("room", room);
			
		}else {
			roomListService.updateRoom(roomCheck);
			model.addAttribute("room",roomCheck);
			session.setAttribute("room", roomCheck);
		}
		List<RoomListVO> roomList = roomListService.getRoomList(member.getId());
		model.addAttribute("roomList",roomList);
		return "chat/chat.part2";
	}

	@RequestMapping(value="/moveRoom.do", method =RequestMethod.GET)
	public String moveRoom(HttpSession session, Model model, @RequestParam String roomId) {
		MemberVO member = (MemberVO)session.getAttribute("member");
		if(member == null) {
			return "main/main.part2";
		}
		model.addAttribute("memberName",member.getNick_name());
		
		System.out.println(roomId);
		RoomListVO room = roomListService.getRoom(roomId);
		model.addAttribute("room",room);
		session.setAttribute("room", room);
		
		List<RoomListVO> roomList = roomListService.getMemberList(member.getId());
		model.addAttribute("roomList",roomList);
		return "chat/chat.part2";
	}
}
