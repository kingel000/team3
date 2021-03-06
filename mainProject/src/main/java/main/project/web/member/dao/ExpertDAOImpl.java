package main.project.web.member.dao;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import main.project.web.member.vo.ExpertVO;

@Repository("expertDAO")
public class ExpertDAOImpl implements IExpertDAO {

	@Inject
	private SqlSessionTemplate sqlSessiontemplate;


	@Override
	public void insertExpert(ExpertVO expert) {
		System.out.println("insertExpert()");
		sqlSessiontemplate.insert("main.project.web.member.dao.IExpertDAO.insertExpert",expert);

	}

	@Override
	public void deleteExpert(String id) {
		System.out.println("deleteExpert()");
		sqlSessiontemplate.delete("main.project.web.member.dao.IExpertDAO.deleteExpert",id);

	}

	@Override
	public void updateExpert(ExpertVO expert) {
		System.out.println("updateExpert()");
		sqlSessiontemplate.update("main.project.web.member.dao.IExpertDAO.updateExpert",expert);

	}

	@Override
	public ExpertVO selectExpert(String id) {
		System.out.println("selectExpert()");
		return sqlSessiontemplate.selectOne("main.project.web.member.dao.IExpertDAO.selectExpert",id);

	}

	@Override
	public void updateRankExpert(String id) {
		 sqlSessiontemplate.update("main.project.web.member.dao.IExpertDAO.updateRankExpert",id);

		
	}
	
	@Override
	public void updatePointExpert(ExpertVO expert) {
		 sqlSessiontemplate.update("main.project.web.member.dao.IExpertDAO.updatePointExpert",expert);

		
	}

	@Override
	public void insertRankExpert(String id) {
		sqlSessiontemplate.insert("main.project.web.member.dao.IExpertDAO.insertRankExpert",id);

		
	}

	@Override
	public Integer totalMember_expert() {
		return sqlSessiontemplate.selectOne("main.project.web.member.dao.IExpertDAO.totalMember_expert");
	}

	


		


}