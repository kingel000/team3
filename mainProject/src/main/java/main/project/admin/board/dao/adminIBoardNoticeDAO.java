package main.project.admin.board.dao;

import java.util.List;

import main.project.admin.board.vo.AdminBoardNoticeVO;

public interface adminIBoardNoticeDAO {
	
	void insertBoardNotice(AdminBoardNoticeVO abnVO);
	List<AdminBoardNoticeVO> selectListAdminBoardNotice();
}
