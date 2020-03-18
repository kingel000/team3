package main.project.web.chat.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import main.project.web.chat.vo.ChatContentVO;

public interface IChatContentService {
	
	@Transactional 
	void insertContent(ChatContentVO chatContent); //���� ä�� ���� ����
	
	List<ChatContentVO> selectContentList(String roomId);//ä�ó��� ��������
	Integer selectNumCount();
	Integer selectReceiveCount(String id);
	Integer selectReceiveRoomCount(ChatContentVO chatContent);
	@Transactional 
	void updateRead(ChatContentVO chatContent);
}
