package main.project.admin.board.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import main.project.admin.board.vo.AdminBoardNoticeVO;

public interface adminIBoardNoticeService {

	@Transactional 
	void insertAbnVO(AdminBoardNoticeVO abnVO);
	
	List<AdminBoardNoticeVO> selectListAdminBoardNotice(int displayPost, int postNum) throws Exception;
	List<AdminBoardNoticeVO> selectListAdminBoardNotice();
	Integer selectBoardNoticeNumber();
	AdminBoardNoticeVO adminBoardNotice_Detail(String boardNum);
	@Transactional 
	void updateBoardNotice(AdminBoardNoticeVO abnVO);
	@Transactional 
	void deleteBoardNotice(String boardNum);
}
