package main.project.web.chat.service;

import java.util.List;
import main.project.web.chat.vo.ChatContentVO;

public interface IChatContentService {
	void insertContent(ChatContentVO chatContent); //���� ä�� ���� ����
	List<ChatContentVO> selectContentList(String roomId);//ä�ó��� ��������
}