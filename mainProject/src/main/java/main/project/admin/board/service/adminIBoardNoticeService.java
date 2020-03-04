package main.project.admin.board.service;

import java.util.List;

import main.project.admin.board.vo.AdminBoardNoticeVO;

public interface adminIBoardNoticeService {

	void insertBoardNotice(AdminBoardNoticeVO abnVO);
	List<AdminBoardNoticeVO> selectListAdminBoardNotice();
}
