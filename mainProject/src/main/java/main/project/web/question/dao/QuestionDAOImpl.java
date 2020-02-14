package main.project.web.question.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import main.project.web.question.vo.QuestionVO;

@Repository("questionDAO")
public class QuestionDAOImpl implements IQuestionDAO {
	
	@Inject
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void insertQuestion(QuestionVO question) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateQuestion(QuestionVO question) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteQuestion(QuestionVO question) {
		// TODO Auto-generated method stub

	}

	@Override
	public QuestionVO selectQuestion(QuestionVO question) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<QuestionVO> selectListQuetion(QuestionVO question) {
		// TODO Auto-generated method stub
		return null;
	}

}
