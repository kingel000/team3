package main.project.admin.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import main.project.admin.board.vo.AdminBoardNoticeVO;

public interface adminIBoardNoticeDAO {
	
	void insertAbnVO(AdminBoardNoticeVO abnVO);
	List<AdminBoardNoticeVO> selectListAdminBoardNotice(int displayPost, int postNum) throws Exception;
	List<AdminBoardNoticeVO> selectListAdminBoardNotice();
	Integer selectBoardNoticeNumber();
	AdminBoardNoticeVO adminBoardNotice_Detail(@Param("boardNum")String boardNum);
	void updateBoardNotice(AdminBoardNoticeVO abnVO);
	void deleteBoardNotice(@Param("boardNum")String boardNum);
}
