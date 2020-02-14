package main.project.web.question.service;

import java.util.List;

import main.project.web.question.vo.QuestionVO;

public interface IQuestionService {
	void insertQuestion(QuestionVO question);
	void deleteQuestion(QuestionVO question);
	QuestionVO selectQuestion(QuestionVO question);
	List<QuestionVO> selectListQuetion();

}
