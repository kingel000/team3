package main.project.web.chat.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import main.project.web.chat.vo.RoomListVO;

public interface IRoomListDAO {
	void createChatRoom(RoomListVO roomList); //방 생성
	List<RoomListVO> getRoomList(@Param("memberId")String memberId);//구매자 :  방 리스트 가져오기(채팅한 사용자 목록)
	List<RoomListVO> getMemberList(@Param("expertId")String expertId);//판매자 :  방 리스트 가져오기(채팅한 사용자 목록)
	Integer selectNumCount();
	RoomListVO checkRoom(RoomListVO roomList);
	void updateRoom(RoomListVO roomList);
	RoomListVO getRoom(@Param("roomId") String roomId);
}
