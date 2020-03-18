package main.project.web.chat.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import main.project.web.chat.vo.RoomListVO;

public interface IRoomListService {
	@Transactional 
	void createChatRoom(RoomListVO roomList); //방 생성
	
	List<RoomListVO> getRoomList(String memberId);// 방 리스트 가져오기(채팅한 사용자 목록)
	List<RoomListVO> getMemberList(String expertId);//판매자 :  방 리스트 가져오기(채팅한 사용자 목록)
	Integer selectNumCount();
	RoomListVO checkRoom(RoomListVO roomList);
	@Transactional 
	void updateRoom(RoomListVO roomList);
	RoomListVO getRoom(String roomId);
}
