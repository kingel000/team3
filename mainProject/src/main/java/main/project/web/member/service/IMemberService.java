package main.project.web.member.service;

import main.project.web.member.vo.MemberVO;

public interface IMemberService {
	MemberVO checkMemberId(String id);
	MemberVO selectMember(MemberVO member);
	void insertMember(MemberVO member);
	void updateMember(MemberVO member);
	void deleteMember(MemberVO member);
	void rankupdate(String id);
}
