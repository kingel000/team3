package main.project.web.member.dao;

import org.apache.ibatis.annotations.Param;

import main.project.web.member.vo.MemberVO;

public interface IMemberDAO {
	MemberVO checkMemberId(@Param("member_id") String id);
	MemberVO selectMember(MemberVO member);
	void insertMember(MemberVO member);
	void updateMember(MemberVO member);
	void deleteMember(MemberVO member);
	void rankupdate(@Param("member_id") String id);
}

