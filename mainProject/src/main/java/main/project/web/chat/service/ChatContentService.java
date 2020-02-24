package main.project.web.chat.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import main.project.web.chat.dao.IChatContentDAO;
import main.project.web.chat.vo.ChatContentVO;

@Service("chatContentService")
public class ChatContentService implements IChatContentService {
	@Inject
	private IChatContentDAO chatContentDAO;
	
	@Override
	public void insertContent(ChatContentVO chatContent) {
		chatContentDAO.insertContent(chatContent);
	}

	@Override
	public List<ChatContentVO> selectContentList(String roomId) {
		return chatContentDAO.selectContentList(roomId);
	}

}