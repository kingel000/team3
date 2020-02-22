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
	List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();//�޼����� �����ֱ����� ���������� ����
	private Map<WebSocketSession, String> roomList = new HashMap<WebSocketSession,String>(); //������ ����� �����κ��� �ѷ��ֱ����� ������ �Ϲݸ���Ʈ
	private Map<WebSocketSession, Object> mapList = new HashMap<WebSocketSession,Object>(); //����session�� ���̵�����, web��������
	
	/*
	 * //������ ����� ����ڵ��� �����ϱ����� ����
	private List<WebSocketSession> sessionList = new ArrayList<>(); //�޼����� �����ֱ����� ���������� ����
	private Map<WebSocketSession, String> mapList = new HashMap<>(); //����session�� ���̵�����, web��������
	private Map<WebSocketSession,String> roomList = new HashMap<>(); //���� session�� ���̵�����,  room����

	private List<String> userList = new ArrayList<>(); //������ ����� �����κ��� �ѷ��ֱ����� ������ �Ϲݸ���Ʈ
	 */
	
	//����Ǿ�����
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("afterConnectionEstablished:" + session);
		sessionList.add(session);
		Map<String, Object> map = session.getAttributes();
		MemberVO member = (MemberVO) map.get("member");
		String userId = member.getId();
		System.out.println("userId:"+userId);
		
		//����� ����ġ ��������
		RoomLocationVO roomLocation = roomLocationService.searchLocation(userId);
		roomList.put(session, roomLocation.getRoom_id());
		
		mapList.put(session, userId);
		
		for(WebSocketSession sess : sessionList) {
			if(roomLocation.getRoom_id().equals(roomList.get(sess))) {
				sess.sendMessage(new TextMessage(200+"%^&"+member.getNick_name()+"%^&"+""));
			}
		}
		//chatContentService ->ä�ó��� ����
	}

	//������ Ŭ���̾�Ʈ�κ��� �޽����� �޾�����
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
		//chatContentService ->ä�ó��� ����
	}

	//��� ���������������
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
