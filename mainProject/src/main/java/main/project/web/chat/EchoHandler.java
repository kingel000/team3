package main.project.web.chat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class EchoHandler extends TextWebSocketHandler {
	private static final Logger logger = LoggerFactory.getLogger(EchoHandler.class);
	List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();//메세지를 날려주기위한 웹소켓전용 세션
	private List<String> userList = new ArrayList<String>(); //접속자 명단을 개개인별로 뿌려주기위해 선언한 일반리스트
	private Map<WebSocketSession, String> mapList = new HashMap<>(); //실제session의 아이디정보, web소켓정보
	
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
		
	}

	//서버가 클라이언트로부터 메시지를 받았을때
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println("handleTextMessage:" + session + " : " + message);
		String senderId = session.getId();
		for (WebSocketSession sess: sessionList) {
			if(!sess.equals(session)) {
				sess.sendMessage(new TextMessage(message.getPayload()));
			}
			
		}
		
	}

	//통신 연결끊었을때실행
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("afterConnectionClosed:" + session + ":" + status);
		sessionList.remove(session);
	}

}
