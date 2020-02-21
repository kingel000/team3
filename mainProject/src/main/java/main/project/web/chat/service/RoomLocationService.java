package main.project.web.chat.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import main.project.web.chat.dao.IRoomLocationDAO;
import main.project.web.chat.vo.RoomLocationVO;

@Service("roomLocationService")
public class RoomLocationService implements IRoomLocationService {

	@Inject
	private IRoomLocationDAO  roomLocationDAO;
	@Override
	public void startRoom(RoomLocationVO roomLocation) {
		roomLocationDAO.startRoom(roomLocation);
	}

	@Override
	public void moveRoom(RoomLocationVO roomLocation) {
		roomLocationDAO.moveRoom(roomLocation);
	}

	@Override
	public void endRoom(String id) {
		roomLocationDAO.endRoom(id);
	}

}
