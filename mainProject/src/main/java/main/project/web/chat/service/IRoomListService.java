package main.project.web.chat.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import main.project.web.chat.vo.RoomListVO;

public interface IRoomListService {
	@Transactional 
	void createChatRoom(RoomListVO roomList); //�� ����
	
	List<RoomListVO> getRoomList(String memberId);// �� ����Ʈ ��������(ä���� ����� ���)
	List<RoomListVO> getMemberList(String expertId);//�Ǹ��� :  �� ����Ʈ ��������(ä���� ����� ���)
	Integer selectNumCount();
	RoomListVO checkRoom(RoomListVO roomList);
	@Transactional 
	void updateRoom(RoomListVO roomList);
	RoomListVO getRoom(String roomId);
}
