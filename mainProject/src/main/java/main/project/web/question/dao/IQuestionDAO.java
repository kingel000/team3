package main.project.web.question.dao;

import java.util.List;

import main.project.web.question.vo.QuestionVO;

public interface IQuestionDAO {
	void insertQuestion(QuestionVO question);
	void deleteQuestion(QuestionVO question);
	QuestionVO selectQuestion(QuestionVO question);
	List<QuestionVO> selectListQuestion();
	Integer selectNumQuestion(); //문의글 번호


}
