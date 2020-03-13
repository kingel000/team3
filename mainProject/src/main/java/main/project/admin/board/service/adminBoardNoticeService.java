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
	public void insertAbnVO(AdminBoardNoticeVO abnVO) {
		adminBoardNoticeDAO.insertAbnVO(abnVO);
	}
	@Override
	public List<AdminBoardNoticeVO> selectListAdminBoardNotice(int displayPost, int postNum) throws Exception {
		return adminBoardNoticeDAO.selectListAdminBoardNotice(displayPost, postNum);
	}
	@Override
	public List<AdminBoardNoticeVO> selectListAdminBoardNotice() {
		return adminBoardNoticeDAO.selectListAdminBoardNotice();
	}
	@Override
	public Integer selectBoardNoticeNumber() {
		return adminBoardNoticeDAO.selectBoardNoticeNumber();
	}
	@Override
	public AdminBoardNoticeVO adminBoardNotice_Detail(String boardNum) {
		return adminBoardNoticeDAO.adminBoardNotice_Detail(boardNum);
	}

	@Override
	public void updateBoardNotice(AdminBoardNoticeVO abnVO) {
		adminBoardNoticeDAO.updateBoardNotice(abnVO);
	}

	@Override
	public void deleteBoardNotice(String boardNum) {
		adminBoardNoticeDAO.deleteBoardNotice(boardNum);
	}

}
