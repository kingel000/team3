package main.project.web.chat.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import main.project.web.chat.vo.RoomListVO;

public interface IRoomListDAO {
	void createChatRoom(RoomListVO roomList); //�� ����
	List<RoomListVO> getRoomList(@Param("memberId")String memberId);//������ :  �� ����Ʈ ��������(ä���� ����� ���)
	List<RoomListVO> getMemberList(@Param("expertId")String expertId);//�Ǹ��� :  �� ����Ʈ ��������(ä���� ����� ���)
	Integer selectNumCount();
	RoomListVO checkRoom(RoomListVO roomList);
	void updateRoom(RoomListVO roomList);
	RoomListVO getRoom(@Param("roomId") String roomId);
}
