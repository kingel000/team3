package main.project.web.chat.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import main.project.web.chat.vo.ChatContentVO;

public interface IChatContentDAO {
	void insertContent(ChatContentVO chatContent); //���� ä�� ���� ����
	List<ChatContentVO> selectContentList(@Param("roomId") String roomId);//ä�ó��� ��������
	Integer selectNumCount();
	Integer selectReceiveCount(@Param("id")String id);
	Integer selectReceiveRoomCount(ChatContentVO chatContent);
	void updateRead(ChatContentVO chatContent);
}
