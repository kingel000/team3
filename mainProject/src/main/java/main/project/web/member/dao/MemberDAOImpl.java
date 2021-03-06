package main.project.web.member.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import main.project.web.member.vo.MemberFindVO;
import main.project.web.member.vo.MemberVO;
import main.project.web.product.vo.findVO;

@Repository("memberDAO")
public class MemberDAOImpl implements IMemberDAO {

	@Inject
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static String namespace = "main.project.web.member.dao.IMemberDAO";
	@Override
	public MemberVO checkMemberId(String id) {

		return sqlSessionTemplate.selectOne("main.project.web.member.dao.IMemberDAO.checkMemberId",id);
	}

	@Override
	public MemberVO selectMember(String email) {
		return sqlSessionTemplate.selectOne("main.project.web.member.dao.IMemberDAO.selectMember", email);
	}

	@Override
	public void insertMember(MemberVO member) {
		sqlSessionTemplate.insert("main.project.web.member.dao.IMemberDAO.insertMember", member);
	}

	@Override
	public void updateMember(MemberVO member) {
		sqlSessionTemplate.update("main.project.web.member.dao.IMemberDAO.updateMember", member);
	}

	@Override
	public void rankupdate(String id) {
		sqlSessionTemplate.update("main.project.web.member.dao.IMemberDAO.rankupdate",id);
	}

	@Override
	public void deleteMember(MemberVO member) {
		sqlSessionTemplate.update("main.project.web.member.dao.IMemberDAO.deleteMember", member);
	}

	@Override
	public List<MemberVO> selectAllMember() {
		return sqlSessionTemplate.selectList("main.project.web.member.dao.IMemberDAO.selectAllMember");
		
	}

	@Override
	public void admindeleteMember(MemberVO member) {
		 sqlSessionTemplate.delete("main.project.web.member.dao.IMemberDAO.admindeleteMember",member);
	}

	@Override
	public List<MemberVO> selectFindList(findVO find) {
		return sqlSessionTemplate.selectList("main.project.web.member.dao.IMemberDAO.selectFindList",find);
	}

	@Override
	public Integer totalMember() {
		return sqlSessionTemplate.selectOne("main.project.web.member.dao.IMemberDAO.totalMember");
	}

	@Override
	public List<MemberVO> memberPage(int displayPost, int postNum) throws Exception {
		HashMap data = new HashMap();
		data.put("displayPost", displayPost);
		data.put("postNum", postNum);
		return sqlSessionTemplate.selectList(namespace + ".memberPage", data);
	}

}
