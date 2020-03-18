package main.project.web.member.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import main.project.web.member.vo.MemberFindVO;
import main.project.web.member.vo.MemberVO;
import main.project.web.product.vo.findVO;

public interface IMemberService {
	MemberVO checkMemberId(String id);
	MemberVO selectMember(String email);
	@Transactional 
	void insertMember(MemberVO member);
	void updateMember(MemberVO member);
	@Transactional
	void deleteMember(MemberVO member);
	void admindeleteMember(MemberVO member);
	void rankupdate(String id);
	List<MemberVO> selectAllMember();
	//List<MemberVO> selectOneMember(MemberFindVO find);
	List<MemberVO> selectFindList(findVO find);
	Integer totalMember();
	//계정 게시물 목록 + 페이징
	public List<MemberVO> memberPage(int displayPost, int postNum) throws Exception;
	
}
