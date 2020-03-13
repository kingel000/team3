package main.project.web.chat.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import main.project.web.chat.vo.ChatContentVO;

public interface IChatContentDAO {
	void insertContent(ChatContentVO chatContent); //한줄 채팅 내용 저장
	List<ChatContentVO> selectContentList(@Param("roomId") String roomId);//채팅내용 가져오기
	Integer selectNumCount();
	Integer selectReceiveCount(@Param("id")String id);
	Integer selectReceiveRoomCount(ChatContentVO chatContent);
	void updateRead(ChatContentVO chatContent);
}
