package main.project.web.question.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.project.web.member.vo.MemberVO;
import main.project.web.question.dao.IQuestionDAO;
import main.project.web.question.vo.PagingVO;
import main.project.web.question.vo.QuestionVO;

@Service("questionService")
public class QuestionService implements IQuestionService {
	
	@Autowired
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
	public List<QuestionVO> selectListQuestion() {
		return questionDAO.selectListQuestion();
	}

	@Override
	public Integer selectNumQuestion() {
		return questionDAO.selectNumQuestion();
	}

	@Override
	public Integer selectTotal() {
		return questionDAO.selectTotal();
	}
	
	@Override
	public List<QuestionVO> questionPage(int displayPost, int postNum) throws Exception {
		return questionDAO.questionPage(displayPost, postNum);
	}
	
	@Override
	public void rejoinderQuestion(QuestionVO question) {
		questionDAO.rejoinderQuestion(question);
	}
}
