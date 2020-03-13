package main.project.web.chat;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import main.project.web.chat.service.IChatContentService;
import main.project.web.chat.vo.ChatContentVO;
import main.project.web.chat.vo.RoomListVO;
import main.project.web.member.service.IMemberService;
import main.project.web.member.vo.MemberVO;

public class EchoHandler extends TextWebSocketHandler {
	@Autowired
	private IChatContentService chatContentService;
	@Autowired
	private IMemberService memberService;
	
	private static final Logger logger = LoggerFactory.getLogger(EchoHandler.class);
	//서버에 연결된 사용자들을 저장하기위해 선언
	List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();//메세지를 날려주기위한 웹소켓전용 세션
	private Map<WebSocketSession, RoomListVO> roomList = new HashMap<WebSocketSession,RoomListVO>(); //접속자 명단을 개개인별로 뿌려주기위해 선언한 일반리스트
	private Map<WebSocketSession, MemberVO> mapList = new HashMap<WebSocketSession,MemberVO>(); //키: web소켓정보; 값: member정보 
	
	//연결되었을때
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("afterConnectionEstablished:" + session);
		sessionList.add(session);
		MemberVO member = (MemberVO) session.getAttributes().get("member");
		RoomListVO room = (RoomListVO) session.getAttributes().get("room");
		mapList.put(session,member);
		if(room != null) {
			roomList.put(session, room);
			System.out.println("chat room: "+room);
			Iterator<WebSocketSession> sessions = roomList.keySet().iterator();
			while(sessions.hasNext()) {
				WebSocketSession sess = sessions.next();
				if(room.getRoom_id().equals(roomList.get(sess).getRoom_id())) {
					sess.sendMessage(new TextMessage(JsonDataOpen(member.getNick_name())));
				}
			}
		}

		//chatContentService ->채팅내용 저장
	}

	//서버가 클라이언트로부터 메시지를 받았을때
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println("handleTextMessage:" + session + " : " + message);
		MemberVO member = (MemberVO) session.getAttributes().get("member");
		RoomListVO room = (RoomListVO) session.getAttributes().get("room");
		
		String word= message.getPayload();
		String[] words = word.split("!%/");
		System.out.println(words[1]+":"+words[2]+":"+words[3]);
		
		if(room != null) {
			Iterator<WebSocketSession> sessions = roomList.keySet().iterator();
			while(sessions.hasNext()) {
				WebSocketSession sess = sessions.next();
				System.out.println(roomList.get(sess));
				if(words[3].equals(roomList.get(sess).getRoom_id())) {
					if(!sess.equals(session)) {
						sess.sendMessage(new TextMessage(JsonData(words[1],words[2])));
					}
				}
			}
			switch(words[0]) {
			case "310":
				Integer num1 = chatContentService.selectNumCount()+1;
				MemberVO m1 = memberService.checkMemberId(room.getExpert_id());
				chatContentService.insertContent(new ChatContentVO(num1,words[3], words[1], m1.getNick_name(), words[2],"no",member.getId(),m1.getId()));
				break;
			case "320":
				Integer num2 = chatContentService.selectNumCount()+1;
				MemberVO m2 = memberService.checkMemberId(room.getMember_id());
				chatContentService.insertContent(new ChatContentVO(num2,words[3], words[1], m2.getNick_name(), words[2],"no",member.getId(),m2.getId()));
				break;
			}
		}
		//chatContentService ->채팅내용 저장
	}

	//통신 연결끊었을때실행
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("afterConnectionClosed:" + session + ":" + status);
		MemberVO member = (MemberVO) session.getAttributes().get("member");
		RoomListVO room = (RoomListVO) session.getAttributes().get("room");
		
		mapList.remove(session);
		sessionList.remove(session);
		
		
		if(room != null) {
			roomList.remove(session);
			Iterator<WebSocketSession> sessions = roomList.keySet().iterator();
			while(sessions.hasNext()) {
				WebSocketSession sess = sessions.next();
				if(room.getRoom_id().equals(roomList.get(sess).getRoom_id())) {
					sess.sendMessage(new TextMessage(JsonDataClose(member.getNick_name())));
				}
			}	
		}
	}
	
	public String JsonDataOpen(String name) {
		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("protocol", "100");
		job.add("message", "<p>[" + 
				name + "]님이 접속하셨습니다. </p><span class='time_date'>  Admin </span></div></div></div>");
		JsonObject jsonObject = job.build();
		StringWriter write = new StringWriter();
		
		try(JsonWriter jsonWriter = Json.createWriter(write)) {
			jsonWriter.write(jsonObject);
		};
		return write.toString();
	}

	public String JsonData(String name, Object msg) {
		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("protocol", "300");
		job.add("message", "<p>" + 
				msg + "</p><span class='time_date'>"+  name +"</span></div></div></div>");
		JsonObject jsonObject = job.build();
		StringWriter write = new StringWriter();
		
		try(JsonWriter jsonWriter = Json.createWriter(write)) {
			jsonWriter.write(jsonObject);
		};
		return write.toString();
	}
	
	public String JsonChatContent(String roomId) {
		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("protocol", "400");
		job.add("message", "");
		JsonObject jsonObject = job.build();
		StringWriter write = new StringWriter();
		
		try(JsonWriter jsonWriter = Json.createWriter(write)) {
			jsonWriter.write(jsonObject);
		};
		return write.toString();
	}
	
	public String JsonDataClose(String name) {
		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("protocol", "200");
		job.add("message", "<p>[" + 
				name + "]님이 퇴장 하셨습니다. </p><span class='time_date'>  Admin </span></div></div></div>");
		JsonObject jsonObject = job.build();
		StringWriter write = new StringWriter();
		
		try(JsonWriter jsonWriter = Json.createWriter(write)) {
			jsonWriter.write(jsonObject);
		};
		return write.toString();
	}
	
}
