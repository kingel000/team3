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

}
