package main.project.web.chat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import main.project.web.chat.service.IChatContentService;
import main.project.web.chat.service.IRoomLocationService;
import main.project.web.chat.vo.RoomLocationVO;
import main.project.web.member.vo.MemberVO;

public class EchoHandler extends TextWebSocketHandler {
	@Autowired
	private IChatContentService chatContentService;
	@Autowired
	private IRoomLocationService roomLocationService;
	
	private static final Logger logger = LoggerFactory.getLogger(EchoHandler.class);
	List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();//메세지를 날려주기위한 웹소켓전용 세션
	private Map<WebSocketSession, String> roomList = new HashMap<WebSocketSession,String>(); //접속자 명단을 개개인별로 뿌려주기위해 선언한 일반리스트
	private Map<WebSocketSession, Object> mapList = new HashMap<WebSocketSession,Object>(); //실제session의 아이디정보, web소켓정보
	
	/*
	 * //서버에 연결된 사용자들을 저장하기위해 선언
	private List<WebSocketSession> sessionList = new ArrayList<>(); //메세지를 날려주기위한 웹소켓전용 세션
	private Map<WebSocketSession, String> mapList = new HashMap<>(); //실제session의 아이디정보, web소켓정보
	private Map<WebSocketSession,String> roomList = new HashMap<>(); //실제 session의 아이디정보,  room정보

	private List<String> userList = new ArrayList<>(); //접속자 명단을 개개인별로 뿌려주기위해 선언한 일반리스트
	 */
	
	//연결되었을때
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("afterConnectionEstablished:" + session);
		sessionList.add(session);
		Map<String, Object> map = session.getAttributes();
		MemberVO member = (MemberVO) map.get("member");
		String userId = member.getId();
		System.out.println("userId:"+userId);
		
		//사용자 방위치 가져오기
		RoomLocationVO roomLocation = roomLocationService.searchLocation(userId);
		roomList.put(session, roomLocation.getRoom_id());
		
		mapList.put(session, userId);
		
		for(WebSocketSession sess : sessionList) {
			if(roomLocation.getRoom_id().equals(roomList.get(sess))) {
				sess.sendMessage(new TextMessage(200+"%^&"+member.getNick_name()+"%^&"+""));
			}
		}
		//chatContentService ->채팅내용 저장
	}

	//서버가 클라이언트로부터 메시지를 받았을때
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println("handleTextMessage:" + session + " : " + message);
		Map<String, Object> map = session.getAttributes();
		MemberVO member = (MemberVO) map.get("member");
		String userId = member.getId();
		System.out.println(message.getPayload());
		String[] words = message.getPayload().split("%^&");
		for (WebSocketSession sess: sessionList) {
			if(words[2].equals(mapList.get(sess))) {
				sess.sendMessage(new TextMessage("%^&"));
			}
			
		}
		//chatContentService ->채팅내용 저장
	}

	//통신 연결끊었을때실행
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("afterConnectionClosed:" + session + ":" + status);
		Map<String, Object> map = session.getAttributes();
		MemberVO member = (MemberVO) map.get("member");
		String userId = member.getId();
		String roomId = roomList.get(session);
		roomLocationService.endRoom(userId);
		roomList.remove(session);
		mapList.remove(session);
		sessionList.remove(session);
		
		Iterator<WebSocketSession> roomIds = roomList.keySet().iterator();
		
		while(roomIds.hasNext()) {
			WebSocketSession sess = roomIds.next();
			if(roomId.equals(roomList.get(sess))){
				sess.sendMessage(new TextMessage(400+"%^&"+userId+"%^&"+""));
			}
		}
	}

}
