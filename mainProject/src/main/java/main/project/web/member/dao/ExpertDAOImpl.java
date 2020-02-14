package main.project.web.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.project.web.member.vo.ExpertVO;

@Repository("expertDAO")
public class ExpertDAOImpl implements IExpertDAO {

	@Autowired
	private SqlSessionTemplate sqlsessiontemplate;


	@Override
	public void insertExpert(ExpertVO expert) {
		System.out.println("insertExpert()");
		sqlsessiontemplate.insert("main.project.web.member.dao.IExpertDAO.insertExpert",expert);

	}

	@Override
	public void deleteExpert(String id) {
		System.out.println("deleteExpert()");
		sqlsessiontemplate.delete("main.project.web.member.dao.IExpertDAO.deleteExpert",id);

	}

	@Override
	public void updateExpert(ExpertVO expert) {
		System.out.println("updateExpert()");
		sqlsessiontemplate.update("main.project.web.member.dao.IExpertDAO.updateExpert",expert);

	}

	@Override
	public ExpertVO selectExpert(String id) {
		System.out.println("selectExpert()");
		return sqlsessiontemplate.selectOne("main.project.web.member.dao.IExpertDAO.selectExpert",id);

	}

}