package main.project.web.question.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import main.project.web.question.vo.PagingVO;
import main.project.web.question.vo.QuestionVO;


@Repository("questionDAO")
public class QuestionDAOImpl implements IQuestionDAO {
	
	@Inject
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void insertQuestion(QuestionVO question) {
		sqlSessionTemplate.insert("main.project.web.question.dao.IQuestionDAO.insertQuestion", question);
	}

	@Override
	public void deleteQuestion(QuestionVO question) {
		sqlSessionTemplate.delete("main.project.web.question.dao.IQuestionDAO.deleteQuestion", question);
	}

	@Override
	public QuestionVO selectQuestion(QuestionVO question) {
		return sqlSessionTemplate.selectOne("main.project.web.question.dao.IQuestionDAO.selectQuestion", question);
	}

	@Override
	public List<QuestionVO> selectListQuestion() {
		return sqlSessionTemplate.selectList("main.project.web.question.dao.IQuestionDAO.selectListQuestion");
	}

	@Override
	public Integer selectNumQuestion() {
		return sqlSessionTemplate.selectOne("main.project.web.question.dao.IQuestionDAO.selectNumQuestion");
	}


	@Override
	public Integer selectTotal() {
		return sqlSessionTemplate.selectOne("main.project.web.question.dao.IQuestionDAO.selectTotal");
	}

	@Override
	public List<QuestionVO> questionPage(int displayPost, int postNum) throws Exception {
		HashMap data = new HashMap();
		data.put("displayPost", displayPost);
		data.put("postNum", postNum);
		return sqlSessionTemplate.selectList("main.project.web.question.dao.IQuestionDAO.questionPage", data);
	}
	@Override
	public List<QuestionVO> questionPageM(int displayPost, int postNum) throws Exception {
		HashMap data = new HashMap();
		data.put("displayPost", displayPost);
		data.put("postNum", postNum);
		return sqlSessionTemplate.selectList("main.project.web.question.dao.IQuestionDAO.questionPageM", data);
	}
	@Override
	public void rejoinderQuestion(QuestionVO question) {
		sqlSessionTemplate.update("main.project.web.question.dao.IQuestionDAO.rejoinderQuestion", question);
	}

	@Override
	public Integer selectStateTotal() {
		return sqlSessionTemplate.selectOne("main.project.web.question.dao.IQuestionDAO.selectStateTotal");
	}

}
