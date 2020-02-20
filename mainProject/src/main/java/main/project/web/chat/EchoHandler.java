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
	List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();//�޼����� �����ֱ����� ���������� ����
	private List<String> userList = new ArrayList<String>(); //������ ����� �����κ��� �ѷ��ֱ����� ������ �Ϲݸ���Ʈ
	private Map<WebSocketSession, String> mapList = new HashMap<>(); //����session�� ���̵�����, web��������
	
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
		
	}

	//������ Ŭ���̾�Ʈ�κ��� �޽����� �޾�����
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

	//��� ���������������
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("afterConnectionClosed:" + session + ":" + status);
		sessionList.remove(session);
	}

}
