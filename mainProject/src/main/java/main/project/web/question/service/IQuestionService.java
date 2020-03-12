package main.project.web.question.service;

import java.util.List;

import main.project.web.question.vo.PagingVO;
import main.project.web.question.vo.QuestionVO;

public interface IQuestionService {
	void insertQuestion(QuestionVO question);
	void deleteQuestion(QuestionVO question);
	QuestionVO selectQuestion(QuestionVO question);
	List<QuestionVO> selectListQuestion();
	Integer selectNumQuestion();
	Integer selectTotal();
	List<QuestionVO> questionPage(int displayPost, int postNum) throws Exception;
	List<QuestionVO> questionPageM(int displayPost, int postNum) throws Exception;
	void rejoinderQuestion(QuestionVO question);
	Integer selectStateTotal();
}
