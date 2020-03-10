package main.project.web.notice.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import main.project.web.notice.vo.NoticeVO;

@Repository("NoticeDAO")
public class NoticeDAOImpl implements INoticeDAO{

	@Inject
	private SqlSessionTemplate sqlSesstionTemplate;
	
	@Override
	public void insertNoticeVO(NoticeVO noticeVO) {
		sqlSesstionTemplate.insert("main.project.web.notice.dao.INoticeDAO.insertNoticeVO",noticeVO);
	}
	
	@Override
	public List<NoticeVO> selectListNotice() {
		return sqlSesstionTemplate.selectList("main.project.web.notice.dao.INoticeDAO.selectListNotice");
	}

	@Override
	public Integer selectNoticeNumber() {
		return sqlSesstionTemplate.selectOne("main.project.web.notice.dao.INoticeDAO.selectNoticeNumber");
	}

	@Override
	public NoticeVO Notice_Detail(String noticeNum) {
		return sqlSesstionTemplate.selectOne("main.project.web.notice.dao.INoticeDAO.Notice_Detail",noticeNum);
	}

}
