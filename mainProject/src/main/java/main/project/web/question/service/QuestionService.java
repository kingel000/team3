package main.project.web.question.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import main.project.web.question.dao.IQuestionDAO;
import main.project.web.question.vo.QuestionVO;

@Service("questionService")
public class QuestionService implements IQuestionDAO {
	
	@Inject
	private IQuestionDAO questionDAO;

	@Override
	public void insertQuestion(QuestionVO question) {
		questionDAO.insertQuestion(question);
	}

	@Override
	public void deleteQuestion(QuestionVO question) {
		questionDAO.deleteQuestion(question);

	}

	@Override
	public QuestionVO selectQuestion(QuestionVO question) {
		return questionDAO.selectQuestion(question);
	}

	@Override
	public List<QuestionVO> selectListQuetion() {
		return questionDAO.selectListQuetion();
	}

}
