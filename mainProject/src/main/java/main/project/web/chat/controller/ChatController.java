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
	public String expertChat (RoomListVO room,Model model,HttpSession session) throws Exception{
		MemberVO member = (MemberVO)session.getAttribute("member");
		if(member == null) {
			return "redirect:/main/main.do";
		}
		model.addAttribute("memberName",member.getNick_name());
		RoomListVO check = roomListService.checkRoom(room);
		model.addAttribute("room",check);
		session.setAttribute("room", check);
		//장바구니
		List<CartVO> cartList = purchaseService.selectMyCart(member.getId());
		if(cartList.size() != 0) {
			model.addAttribute("cartList",cartList);
			model.addAttribute("count",cartList.size());
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
			model.addAttribute("chatContents",chatContent);
		}
		
		//장바구니
		List<CartVO> cartList = purchaseService.selectMyCart(member.getId());
		if(cartList.size() != 0) {
			model.addAttribute("cartList",cartList);
			model.addAttribute("count",cartList.size());
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
			System.out.println("room"+num);
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
			model.addAttribute("chatContents",chatContent);
		}

		//장바구니
		List<CartVO> cartList = purchaseService.selectMyCart(member.getId());
		if(cartList.size() != 0) {
			model.addAttribute("cartList",cartList);
			model.addAttribute("count",cartList.size());
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
		model.addAttribute("roomList",roomList);
		return "chat/memberRoomList.page";
	}
	
	@RequestMapping(value="/expertRoomList.do", method=RequestMethod.GET)
	public String expertRoomList(HttpSession session, Model model) {
		MemberVO member = (MemberVO)session.getAttribute("member");
		if(member == null) {
			return "redirect:/main/main.do";
		}
		List<RoomListVO> roomList = roomListService.getMemberList(member.getId());
		model.addAttribute("roomList",roomList);
		return "chat/expertRoomList.page";
	}
}
