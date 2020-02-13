package main.project.web.member.dao;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import main.project.web.member.vo.MemberVO;

@Repository("memberDAO")
public class MemberDAOImpl implements IMemberDAO {

	@Inject
	private SqlSessionTemplate sqlSessionTemplate;
	@Override
	public MemberVO checkMemberId(String id) {

		return sqlSessionTemplate.selectOne("member.memberDAO.checkMemberId",id);
	}

	@Override
	public MemberVO selectMember(MemberVO member) {
		return sqlSessionTemplate.selectOne("member.memberDAO.selectMember", member);
	}

	@Override
	public void insertMember(MemberVO member) {
		sqlSessionTemplate.insert("member.memberDAO.insertMember", member);
	}

	@Override
	public void updateMember(MemberVO member) {
		sqlSessionTemplate.update("member.memberDAO.updateMember", member);
	}

	@Override
	public void rankupdate(String id) {
		sqlSessionTemplate.update("member.memberDAO.rankupdate",id);
	}

	@Override
	public void deleteMember(MemberVO member) {
		sqlSessionTemplate.delete("member.memberDAO.deleteMember", member);
	}

}
