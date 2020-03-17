package main.project.web.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import main.project.web.member.vo.MemberFindVO;
import main.project.web.member.vo.MemberVO;
import main.project.web.product.vo.ProductVO;
import main.project.web.product.vo.findVO;

public interface IMemberDAO {
	MemberVO checkMemberId(@Param("member_id") String id);
	MemberVO selectMember(@Param("email")String email);
	void insertMember(MemberVO member);
	void updateMember(MemberVO member);
	void deleteMember(MemberVO member);
	void admindeleteMember(MemberVO member);
	void rankupdate(@Param("member_id") String id);
	List<MemberVO> selectAllMember();
	List<MemberVO> selectFindList(findVO find);
	Integer totalMember();
	List<MemberVO> memberPage(int displayPost, int postNum) throws Exception;

}

