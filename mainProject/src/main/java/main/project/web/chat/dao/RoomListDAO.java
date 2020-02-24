package main.project.web.chat.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import main.project.web.chat.vo.RoomListVO;

@Repository("roomListDAO")
public class RoomListDAO implements IRoomListDAO {

	@Inject
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public void createChatRoom(RoomListVO roomList) {
		sqlSessionTemplate.insert("main.project.web.chat.dao.IRoomListDAO.createChatRoom",roomList);
	}

	@Override
	public List<RoomListVO> getRoomList(String memberId) {
		return sqlSessionTemplate.selectList("main.project.web.chat.dao.IRoomListDAO.getRoomList", memberId);
	}

	@Override
	public List<RoomListVO> getMemberList(String expertId) {
		return sqlSessionTemplate.selectList("main.project.web.chat.dao.IRoomListDAO.getMemberList", expertId);
	}

	@Override
	public Integer selectNumCount() {
		return sqlSessionTemplate.selectOne("main.project.web.chat.dao.IRoomListDAO.selectNumCount");
	}

	@Override
	public RoomListVO checkRoom(RoomListVO roomList) {
		return sqlSessionTemplate.selectOne("main.project.web.chat.dao.IRoomListDAO.checkRoom", roomList);
	}

	@Override
	public void updateRoom(RoomListVO roomList) {
		sqlSessionTemplate.update("main.project.web.chat.dao.IRoomListDAO.updateRoom", roomList);
	}

	@Override
	public RoomListVO getRoom(String roomId) {
		return sqlSessionTemplate.selectOne("main.project.web.chat.dao.IRoomListDAO.getRoom", roomId);
	}

}
