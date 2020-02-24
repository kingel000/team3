package main.project.web.chat.service;

import java.util.List;
import main.project.web.chat.vo.RoomListVO;

public interface IRoomListService {
	void createChatRoom(RoomListVO roomList); //�� ����
	List<RoomListVO> getRoomList(String memberId);// �� ����Ʈ ��������(ä���� ����� ���)
	List<RoomListVO> getMemberList(String expertId);//�Ǹ��� :  �� ����Ʈ ��������(ä���� ����� ���)
	Integer selectNumCount();
	RoomListVO checkRoom(RoomListVO roomList);
	void updateRoom(RoomListVO roomList);
	RoomListVO getRoom(String roomId);
}
