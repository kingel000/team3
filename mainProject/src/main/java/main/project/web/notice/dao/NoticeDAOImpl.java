package main.project.web.notice.dao;

import java.util.HashMap;
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

	@Override
	public int totalNotice() {
		return sqlSesstionTemplate.selectOne("main.project.web.notice.dao.INoticeDAO.totalNotice");
	}

	@Override
	public List<NoticeVO> noticePage(int displayPost, int postNum) throws Exception {
		HashMap<String,Integer> data = new HashMap<String,Integer>();
		data.put("displayPost", displayPost);
		data.put("postNum", postNum);
		return sqlSesstionTemplate.selectList("main.project.web.notice.dao.INoticeDAO.noticePage",data);
	}

}
