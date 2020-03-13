package main.project.admin.board.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import main.project.admin.board.vo.AdminBoardNoticeVO;

@Repository("adminIBoardNoticeDAO")
public class adminIBoardNoticeDAOImpl implements adminIBoardNoticeDAO {
	
	@Inject
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void insertAbnVO(AdminBoardNoticeVO abnVO) {
		sqlSessionTemplate.insert("main.project.admin.board.dao.adminIBoardNoticeDAO.insertAbnVO",abnVO);
	}
	@Override
	public List<AdminBoardNoticeVO> selectListAdminBoardNotice(int displayPost, int postNum) throws Exception {
		HashMap<String, Integer> data = new HashMap<String, Integer>();
		data.put("displayPost", displayPost);
		data.put("postNum", postNum);
		return sqlSessionTemplate.selectList("main.project.admin.board.dao.adminIBoardNoticeDAO.selectListAdminBoardNotice", data);
	}
	@Override
	public List<AdminBoardNoticeVO> selectListAdminBoardNotice() {
		return sqlSessionTemplate.selectList("main.project.web.notice.dao.INoticeDAO.noticePage");
	}
	@Override
	public Integer selectBoardNoticeNumber() {
		return sqlSessionTemplate.selectOne("main.project.admin.board.dao.adminIBoardNoticeDAO.selectBoardNoticeNumber");
	}

	@Override
	public AdminBoardNoticeVO adminBoardNotice_Detail(String boardNum) {
		return sqlSessionTemplate.selectOne("main.project.admin.board.dao.adminIBoardNoticeDAO.adminBoardNotice_Detail",boardNum);
	}

	@Override
	public void updateBoardNotice(AdminBoardNoticeVO abnVO) {
		sqlSessionTemplate.update("main.project.admin.board.dao.adminIBoardNoticeDAO.updateBoardNotice", abnVO);
	}

	@Override
	public void deleteBoardNotice(String boardNum) {
		sqlSessionTemplate.delete("main.project.admin.board.dao.adminIBoardNoticeDAO.deleteBoardNotice", boardNum);
	}

}
