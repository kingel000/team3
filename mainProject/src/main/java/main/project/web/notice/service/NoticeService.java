package main.project.web.notice.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import main.project.web.notice.dao.INoticeDAO;
import main.project.web.notice.vo.NoticeVO;

@Service("INoticeService")
public class NoticeService implements INoticeService{

	@Inject
	private INoticeDAO noticeDAO;
	
	@Override
	public void insertNoticeVO(NoticeVO noticeVO) {
		noticeDAO.insertNoticeVO(noticeVO);
	}
	
	@Override
	public List<NoticeVO> selectListNotice() {
		return noticeDAO.selectListNotice();
	}

	@Override
	public Integer selectNoticeNumber() {
		return noticeDAO.selectNoticeNumber();
	}

	@Override
	public NoticeVO Notice_Detail(String noticeNum) {
		return noticeDAO.Notice_Detail(noticeNum);
	}
	
	
}
