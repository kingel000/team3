package main.project.web.chat.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import main.project.web.chat.service.IChatContentService;
import main.project.web.chat.service.IRoomListService;
import main.project.web.chat.vo.ChatContentVO;
import main.project.web.chat.vo.RoomListVO;
import main.project.web.member.vo.MemberVO;
import main.project.web.product.vo.ProductVO;
import main.project.web.purchase.vo.CartVO;

@Controller("chatController")
@RequestMapping(value="/chat")
public class ChatController {
	@Autowired
	private IChatContentService chatContentService;
	@Autowired
	private IRoomListService roomListService;
	
	private static final Logger logger = LoggerFactory.getLogger(ChatController.class);
	
	@RequestMapping(value="/expertChat.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String expertChat (RoomListVO room,Model model,HttpSession session) throws Exception{
		MemberVO member = (MemberVO)session.getAttribute("member");
		if(member == null) {
			return "redirect:/main/main.do";
		}
		model.addAttribute("memberName",member.getNick_name());
		RoomListVO check = roomListService.checkRoom(room);
		model.addAttribute("room",check);
		session.setAttribute("room", check);
		
		List<ChatContentVO> chatContent = chatContentService.selectContentList(check.getRoom_id());
		if(chatContent.size() != 0) {
			chatContentService.updateRead(new ChatContentVO(check.getRoom_id(),member.getId(),"yes"));
			model.addAttribute("chatContents",chatContent);
		}
		
		return "chat/expertChat.part2";
	}
	
	@RequestMapping(value="/memberChat.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String memberChat (RoomListVO room, Model model,HttpSession session) throws Exception{
		MemberVO member = (MemberVO)session.getAttribute("member");
		if(member == null) {
			return "redirect:/main/main.do";
		}
		model.addAttribute("memberName",member.getNick_name());
		RoomListVO check = roomListService.checkRoom(room);
		model.addAttribute("room",check);
		session.setAttribute("room", check);
		
		List<ChatContentVO> chatContent = chatContentService.selectContentList(check.getRoom_id());
		if(chatContent.size() != 0) {
			chatContentService.updateRead(new ChatContentVO(check.getRoom_id(),member.getId(),"yes"));
			model.addAttribute("chatContents",chatContent);
		}
		

		return "chat/memberChat.part2";
	}
	
	@RequestMapping(value="/createChat.do", method =RequestMethod.GET)
	public String createChat(Model model, HttpSession session, ProductVO product, String expertName)throws Exception{
		MemberVO member = (MemberVO)session.getAttribute("member");
		if(member == null || member.getId().equals(product.getExpert_id())) {
			return "redirect:/main/main.do";
		}
		model.addAttribute("memberName",member.getNick_name());

		RoomListVO roomListVO = new RoomListVO(member.getId(),product.getProduct_num());
		RoomListVO roomCheck = roomListService.checkRoom(roomListVO);
		
		String roomId = null;
		if(roomCheck == null) {
			Integer num = roomListService.selectNumCount()+1;
			logger.info("room"+num);
			RoomListVO room = new RoomListVO("room"+num,product.getProduct_title(),product.getExpert_id(),member.getId(),product.getProduct_num());
			roomListService.createChatRoom(room);
			roomId = room.getRoom_id();
			model.addAttribute("room",room);
			session.setAttribute("room", room);
			
		}else {
			//날짜 새로 변경
			roomListService.updateRoom(roomCheck);
			roomId = roomCheck.getRoom_id();
			model.addAttribute("room",roomCheck);
			session.setAttribute("room", roomCheck);
		}
		
		List<ChatContentVO> chatContent = chatContentService.selectContentList(roomId);
		if(chatContent.size() != 0) {
			chatContentService.updateRead(new ChatContentVO(roomCheck.getRoom_id(),member.getId(),"yes"));
			model.addAttribute("chatContents",chatContent);
		}

		return "chat/memberChat.part2";
	}
	
	@RequestMapping(value="/memberRoomList.do", method =RequestMethod.GET)
	public String memberRoomList(HttpSession session, Model model) {
		MemberVO member = (MemberVO)session.getAttribute("member");
		if(member == null) {
			return "redirect:/main/main.do";
		}
		
		List<RoomListVO> roomList = roomListService.getRoomList(member.getId());
		List<Integer> receiveCountList = new ArrayList<Integer>();
		if(roomList.size() != 0) {
			for(RoomListVO r : roomList) {
				receiveCountList.add(chatContentService.selectReceiveRoomCount(new ChatContentVO(r.getRoom_id(),r.getMember_id(),"no")));				
			}
		}
		model.addAttribute("roomList",roomList);
		model.addAttribute("receiveCountList", receiveCountList);
		return "chat/memberRoomList.page";
	}
	
	@RequestMapping(value="/expertRoomList.do", method=RequestMethod.GET)
	public String expertRoomList(HttpSession session, Model model) {
		MemberVO member = (MemberVO)session.getAttribute("member");
		if(member == null) {
			return "redirect:/main/main.do";
		}
		List<RoomListVO> roomList = roomListService.getMemberList(member.getId());
		List<Integer> receiveCountList = new ArrayList<Integer>();
		if(roomList.size() != 0) {
			for(RoomListVO r : roomList) {
				receiveCountList.add(chatContentService.selectReceiveRoomCount(new ChatContentVO(r.getRoom_id(),r.getExpert_id(),"no")));				
			}
		}
		model.addAttribute("roomList",roomList);
		model.addAttribute("receiveCountList", receiveCountList);
		return "chat/expertRoomList.page";
	}
	
	@RequestMapping(value="/receiveCount.do", method=RequestMethod.POST)
	@ResponseBody
	public Object headCart(HttpSession session) {
		MemberVO member = (MemberVO)session.getAttribute("member");
		if(member != null) {
			return chatContentService.selectReceiveCount(member.getId());
		}		
		return null;
	}
}
