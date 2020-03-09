package main.project.web.member.service;

import java.util.List;


import main.project.web.member.vo.MemberFindVO;
import main.project.web.member.vo.MemberVO;
import main.project.web.product.vo.findVO;

public interface IMemberService {
	MemberVO checkMemberId(String id);
	MemberVO selectMember(MemberVO member);
	void insertMember(MemberVO member);
	void updateMember(MemberVO member);
	void deleteMember(MemberVO member);
	void admindeleteMember(MemberVO member);
	void rankupdate(String id);
	List<MemberVO> selectAllMember();
	//List<MemberVO> selectOneMember(MemberFindVO find);
	List<MemberVO> selectFindList(findVO find);
	Integer totalMember();

	
}
