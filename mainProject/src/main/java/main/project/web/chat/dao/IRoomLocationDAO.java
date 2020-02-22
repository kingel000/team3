package main.project.web.chat.dao;

import org.apache.ibatis.annotations.Param;

import main.project.web.chat.vo.RoomLocationVO;

public interface IRoomLocationDAO {
	void startRoom(RoomLocationVO roomLocation);//�α��� �ϰ� ���� �ϴ� ��.
	void moveRoom(RoomLocationVO roomLocation);//���̵�
	void endRoom(@Param("id")String id);// ���� ����(������)
	RoomLocationVO searchLocation(@Param("memberId")String memberId);
}
