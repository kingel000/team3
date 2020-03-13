package main.project.admin.board.service;

import java.util.List;
import main.project.admin.board.vo.AdminBoardNoticeVO;

public interface adminIBoardNoticeService {

	void insertAbnVO(AdminBoardNoticeVO abnVO);
	List<AdminBoardNoticeVO> selectListAdminBoardNotice(int displayPost, int postNum) throws Exception;
	List<AdminBoardNoticeVO> selectListAdminBoardNotice();
	Integer selectBoardNoticeNumber();
	AdminBoardNoticeVO adminBoardNotice_Detail(String boardNum);
	void updateBoardNotice(AdminBoardNoticeVO abnVO);
	void deleteBoardNotice(String boardNum);
}
