package main.project.web.chat.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import main.project.web.chat.service.IChatContentService;
import main.project.web.chat.service.IRoomListService;
import main.project.web.chat.vo.ChatContentVO;
import main.project.web.chat.vo.RoomListVO;
import main.project.web.member.vo.MemberVO;
import main.project.web.product.vo.ProductVO;
import main.project.web.purchase.Service.IPurchaseService;
import main.project.web.purchase.vo.CartVO;

@Controller("chatController")
@RequestMapping(value="/chat")
public class ChatController {
	@Autowired
	private IChatContentService chatContentService;
	@Autowired
	private IRoomListService roomListService;
	@Autowired
	private IPurchaseService purchaseService;

	@RequestMapping(value="/expertChat.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String expertChat (Model model,HttpSession session) throws Exception{
		MemberVO member = (MemberVO)session.getAttribute("member");
		if(member == null) {
			return "redirect:/main/main.do";
		}
		model.addAttribute("memberName",member.getNick_name());
		List<RoomListVO> roomList = roomListService.getMemberList(member.getId());
		model.addAttribute("roomList",roomList);
		
		//장바구니
		List<CartVO> cartList = purchaseService.selectMyCart(member.getId());
		if(cartList != null) {
			model.addAttribute("cartList",cartList);
			if(cartList.size() != 0) {
				model.addAttribute("count",cartList.size());
			}
		}
		return "chat/expertChat.part2";
	}

	@RequestMapping(value="/memberChat.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String memberChat (Model model,HttpSession session) throws Exception{
		MemberVO member = (MemberVO)session.getAttribute("member");
		if(member == null) {
			return "redirect:/main/main.do";
		}
		model.addAttribute("memberName",member.getNick_name());
		List<RoomListVO> roomList = roomListService.getRoomList(member.getId());
		model.addAttribute("roomList",roomList);
		
		//장바구니
		List<CartVO> cartList = purchaseService.selectMyCart(member.getId());
		if(cartList != null) {
			model.addAttribute("cartList",cartList);
			if(cartList.size() != 0) {
				model.addAttribute("count",cartList.size());
			}
		}
		return "chat/memberChat.part2";
	}
	
	@RequestMapping(value="/moveERoom.do", method =RequestMethod.GET)
	public String moveERoom(HttpSession session, Model model, @RequestParam String roomId) {
		MemberVO member = (MemberVO)session.getAttribute("member");
		RoomListVO roomChange = (RoomListVO)session.getAttribute("room");
		if(member == null) {
			return "redirect:/main/main.do";
		}
		model.addAttribute("memberName",member.getNick_name());
		
		if(roomChange != null) {
			if(!roomChange.getRoom_id().equals(roomId)) {
				RoomListVO room = roomListService.getRoom(roomId);
				roomChange.setRoomListVO(room);
			}
		}else {
			roomChange = roomListService.getRoom(roomId);
		}
		model.addAttribute("room",roomChange);
		session.setAttribute("room", roomChange);
		
		List<RoomListVO> roomList = roomListService.getMemberList(member.getId());
		model.addAttribute("roomList",roomList);
		
		List<ChatContentVO> chatContent = chatContentService.selectContentList(roomId);
		if(chatContent != null) {
			model.addAttribute("chatContents",chatContent);
		}
		
		//장바구니
		List<CartVO> cartList = purchaseService.selectMyCart(member.getId());
		if(cartList != null) {
			model.addAttribute("cartList",cartList);
			if(cartList.size() != 0) {
				model.addAttribute("count",cartList.size());
			}
		}
		return "chat/expertChat.part2";
	}
	@RequestMapping(value="/createChat.do", method =RequestMethod.GET)
	public String createChat(Model model, HttpSession session, ProductVO product, String expertName)throws Exception{
		MemberVO member = (MemberVO)session.getAttribute("member");
		if(member == null) {
			return "redirect:/main/main.do";
		}
		model.addAttribute("memberName",member.getNick_name());

		RoomListVO roomListVO = new RoomListVO(member.getId(),product.getProduct_num());
		System.out.println("roomListVO:"+roomListVO);
		RoomListVO roomCheck = roomListService.checkRoom(roomListVO);
		System.out.println("roomCheck:"+roomCheck);
		String roomId = null;
		if(roomCheck == null) {
			Integer num = roomListService.selectNumCount()+1;
			System.out.println("room"+num);
			RoomListVO room = new RoomListVO("room"+num,product.getProduct_title(),product.getExpert_id(),member.getId(),product.getProduct_num());
			roomListService.createChatRoom(room);
			roomId = room.getRoom_id();
			model.addAttribute("room",room);
			session.setAttribute("room", room);
			
		}else {
			roomListService.updateRoom(roomCheck);
			roomId = roomCheck.getRoom_id();
			model.addAttribute("room",roomCheck);
			session.setAttribute("room", roomCheck);
		}
		List<RoomListVO> roomList = roomListService.getRoomList(member.getId());
		model.addAttribute("roomList",roomList);
		
		List<ChatContentVO> chatContent = chatContentService.selectContentList(roomId);
		if(chatContent != null) {
			model.addAttribute("chatContents",chatContent);
		}

		//장바구니
		List<CartVO> cartList = purchaseService.selectMyCart(member.getId());
		if(cartList != null) {
			model.addAttribute("cartList",cartList);
			if(cartList.size() != 0) {
				model.addAttribute("count",cartList.size());
			}
		}
		return "chat/memberChat.part2";
	}

	@RequestMapping(value="/moveMRoom.do", method =RequestMethod.GET)
	public String moveRoom(HttpSession session, Model model, @RequestParam String roomId) {
		MemberVO member = (MemberVO)session.getAttribute("member");
		RoomListVO roomChange = (RoomListVO)session.getAttribute("room");
		if(member == null) {
			return "redirect:/main/main.do";
		}
		model.addAttribute("memberName",member.getNick_name());
		
		System.out.println(roomId);
		if(roomChange != null) {
			if(!roomChange.getRoom_id().equals(roomId)) {
				RoomListVO room = roomListService.getRoom(roomId);
				roomChange.setRoomListVO(room);
			}
		}else {
			roomChange = roomListService.getRoom(roomId);
		}
		model.addAttribute("room",roomChange);
		session.setAttribute("room", roomChange);
		
		List<RoomListVO> roomList = roomListService.getMemberList(member.getId());
		model.addAttribute("roomList",roomList);
		
		List<ChatContentVO> chatContent = chatContentService.selectContentList(roomId);
		if(chatContent != null) {
			model.addAttribute("chatContents",chatContent);
		}
		
		//장바구니
		List<CartVO> cartList = purchaseService.selectMyCart(member.getId());
		if(cartList != null) {
			model.addAttribute("cartList",cartList);
			if(cartList.size() != 0) {
				model.addAttribute("count",cartList.size());
			}
		}
		return "chat/memberChat.part2";
	}
}
