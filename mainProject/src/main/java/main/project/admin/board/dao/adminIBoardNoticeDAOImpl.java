package main.project.admin.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import main.project.admin.board.vo.AdminBoardNoticeVO;
import main.project.web.member.vo.MemberVO;

@Repository("adminIBoardNoticeDAO")
public class adminIBoardNoticeDAOImpl implements adminIBoardNoticeDAO {
	
	@Inject
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void insertBoardNotice(AdminBoardNoticeVO abnVO) {
		sqlSessionTemplate.insert("main.project.admin.board.dao.adminIBoardNoticeDAO.insertAbnVO",abnVO);
		
	}

	@Override
	public List<AdminBoardNoticeVO> selectListAdminBoardNotice() {
		return sqlSessionTemplate.selectList("main.project.admin.board.dao.adminIBoardNoticeDAO.selectListAdminBoardNotice");
	}



}
