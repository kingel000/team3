package main.project.web.notice.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import main.project.web.notice.vo.NoticeVO;

public interface INoticeService {
	void insertNoticeVO(NoticeVO noticeVO);
	List<NoticeVO> selectListNotice();
	Integer selectNoticeNumber();
	NoticeVO Notice_Detail(String noticeNum);
	int totalNotice();
	List<NoticeVO> noticePage(int displayPost, int postNum) throws Exception;
}
