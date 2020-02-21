package main.project.web.chat.dao;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import main.project.web.chat.vo.RoomLocationVO;
@Repository("roomLocationDAO")
public class RoomLocationDAO implements IRoomLocationDAO {

	@Inject
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public void startRoom(RoomLocationVO roomLocation) {
		sqlSessionTemplate.insert("main.project.web.chat.dao.IRoomLocationDAO.startRoom",roomLocation);
	}

	@Override
	public void moveRoom(RoomLocationVO roomLocation) {
		sqlSessionTemplate.update("main.project.web.chat.dao.IRoomLocationDAO.moveRoom", roomLocation);
	}

	@Override
	public void endRoom(String id) {
		sqlSessionTemplate.delete("main.project.web.chat.dao.IRoomLocationDAO.endRoom", id);
	}

}
