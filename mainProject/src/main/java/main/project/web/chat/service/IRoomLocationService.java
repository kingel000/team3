package main.project.web.chat.service;

import main.project.web.chat.vo.RoomLocationVO;

public interface IRoomLocationService {
	void startRoom(RoomLocationVO roomLocation);//로그인 하고 시작 하는 방.
	void moveRoom(RoomLocationVO roomLocation);//방이동
	void endRoom(String id);// 연결 종료(나가기)
	RoomLocationVO searchLocation(String memberId);
}
