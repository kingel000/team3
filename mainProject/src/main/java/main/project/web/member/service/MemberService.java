package main.project.web.member.service;

import javax.inject.Inject;
import org.springframework.stereotype.Service;

import main.project.web.member.dao.IMemberDAO;
import main.project.web.member.vo.MemberVO;

@Service("memberService")
public class MemberService implements IMemberService{
	@Inject
	private IMemberDAO memberDAO;

	@Override
	public MemberVO checkMemberId(String id) {
		return memberDAO.checkMemberId(id);
	}

	@Override
	public MemberVO selectMember(MemberVO member) {
		return memberDAO.selectMember(member);
	}

	@Override
	public void insertMember(MemberVO member) {
		memberDAO.insertMember(member);
	}

	@Override
	public void updateMember(MemberVO member) {
		memberDAO.updateMember(member);
	}

	@Override
	public void rankupdate(String id) {
		memberDAO.rankupdate(id);
	}

	@Override
	public void deleteMember(MemberVO member) {
		memberDAO.deleteMember(member);
	}



}