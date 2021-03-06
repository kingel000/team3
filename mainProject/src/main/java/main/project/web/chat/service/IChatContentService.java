package main.project.web.chat.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import main.project.web.chat.vo.ChatContentVO;

public interface IChatContentService {
	
	@Transactional 
	void insertContent(ChatContentVO chatContent); //한줄 채팅 내용 저장
	
	List<ChatContentVO> selectContentList(String roomId);//채팅내용 가져오기
	Integer selectNumCount();
	Integer selectReceiveCount(String id);
	Integer selectReceiveRoomCount(ChatContentVO chatContent);
	@Transactional 
	void updateRead(ChatContentVO chatContent);
}
