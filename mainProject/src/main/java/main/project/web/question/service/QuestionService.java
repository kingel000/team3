package main.project.web.question.service;

import java.util.List;

import org.springframework.stereotype.Service;

import main.project.web.question.dao.IQuestionDAO;
import main.project.web.question.vo.QuestionVO;

@Service("questionService")
public class QuestionService implements IQuestionDAO {
	
	private IQuestionDAO QuestionDAO;

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
