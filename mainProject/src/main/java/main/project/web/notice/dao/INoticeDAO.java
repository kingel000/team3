package main.project.web.notice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import main.project.web.member.vo.MemberVO;
import main.project.web.notice.vo.NoticeVO;

public interface INoticeDAO {
	List<NoticeVO> selectListNotice();
	Integer selectNoticeNumber();
	NoticeVO Notice_Detail(@Param("NoticeNum")String noticeNum);
	int totalNotice();
	List<NoticeVO> noticePage(int displayPost, int postNum) throws Exception;
}
