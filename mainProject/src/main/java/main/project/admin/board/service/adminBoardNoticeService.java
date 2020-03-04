package main.project.admin.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import main.project.admin.board.dao.adminIBoardNoticeDAO;
import main.project.admin.board.vo.AdminBoardNoticeVO;

@Service("adminBoardNoticeService")
public class adminBoardNoticeService implements adminIBoardNoticeService {
	@Inject
	private adminIBoardNoticeDAO adminBoardNoticeDAO;
	
	@Override
	public void insertBoardNotice(AdminBoardNoticeVO abnVO) {
		adminBoardNoticeDAO.insertBoardNotice(abnVO);
	}

	@Override
	public List<AdminBoardNoticeVO> selectListAdminBoardNotice() {
		return adminBoardNoticeDAO.selectListAdminBoardNotice();
	}

}
