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

	@Override
	public Integer selectNumCount(String roomId) {
		return chatContentDAO.selectNumCount(roomId);
	}

	@Override
	public Integer selectReceiveCount(String id) {
		return chatContentDAO.selectReceiveCount(id);
	}

	@Override
	public Integer selectReceiveRoomCount(ChatContentVO chatContent) {
		return chatContentDAO.selectReceiveRoomCount(chatContent);
	}

	@Override
	public void updateRead(ChatContentVO chatContent) {
		chatContentDAO.updateRead(chatContent);
	}

}
