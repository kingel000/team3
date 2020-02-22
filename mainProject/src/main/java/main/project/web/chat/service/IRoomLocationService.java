package main.project.web.chat.service;

import main.project.web.chat.vo.RoomLocationVO;

public interface IRoomLocationService {
	void startRoom(RoomLocationVO roomLocation);//�α��� �ϰ� ���� �ϴ� ��.
	void moveRoom(RoomLocationVO roomLocation);//���̵�
	void endRoom(String id);// ���� ����(������)
	RoomLocationVO searchLocation(String memberId);
}
