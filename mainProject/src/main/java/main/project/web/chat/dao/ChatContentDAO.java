package main.project.web.chat.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import main.project.web.chat.vo.ChatContentVO;
@Repository("chatContentDAO")
public class ChatContentDAO implements IChatContentDAO {

	@Inject
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public void insertContent(ChatContentVO chatContent) {
		sqlSessionTemplate.insert("main.project.web.chat.dao.IChatContentDAO.insertContent",chatContent);

	}

	@Override
	public List<ChatContentVO> selectContentList(String roomId) {
		return sqlSessionTemplate.selectList("main.project.web.chat.dao.IChatContentDAO.selectContentList", roomId);
	}

	@Override
	public Integer selectNumCount() {
		return sqlSessionTemplate.selectOne("main.project.web.chat.dao.IChatContentDAO.selectNumCount");
	}

	@Override
	public Integer selectReceiveCount(String id) {
		return sqlSessionTemplate.selectOne("main.project.web.chat.dao.IChatContentDAO.selectReceiveCount",id);
	}

	@Override
	public Integer selectReceiveRoomCount(ChatContentVO chatContent) {
		return sqlSessionTemplate.selectOne("main.project.web.chat.dao.IChatContentDAO.selectReceiveRoomCount",chatContent);
	}

	@Override
	public void updateRead(ChatContentVO chatContent) {
		sqlSessionTemplate.update("main.project.web.chat.dao.IChatContentDAO.updateRead", chatContent);
	}

}
