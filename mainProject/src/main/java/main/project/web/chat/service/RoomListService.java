package main.project.web.chat.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import main.project.web.chat.dao.IRoomListDAO;
import main.project.web.chat.vo.RoomListVO;

@Service("roomListService")
public class RoomListService implements IRoomListService {
	@Inject
	private IRoomListDAO roomListDAO;
	@Override
	public void createChatRoom(RoomListVO roomList) {
		roomListDAO.createChatRoom(roomList);
	}

	@Override
	public List<RoomListVO> getRoomList(String memberId) {
		return roomListDAO.getRoomList(memberId);
	}

	@Override
	public List<RoomListVO> getMemberList(String expertId) {
		return roomListDAO.getRoomList(expertId);
	}

	@Override
	public Integer selectNumCount() {
		return roomListDAO.selectNumCount();
	}

}
