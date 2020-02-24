package main.project.web.question.dao;

import java.util.List;

import main.project.web.question.vo.PagingVO;
import main.project.web.question.vo.QuestionVO;

public interface IQuestionDAO {
	void insertQuestion(QuestionVO question);
	void deleteQuestion(QuestionVO question);
	QuestionVO selectQuestion(QuestionVO question);
	List<QuestionVO> selectListQuestion();
	Integer selectNumQuestion(); //���Ǳ� ��ȣ
	List<QuestionVO> selectPage(PagingVO vo); 
	Integer selectTotal(); // ��ü ������ ����

}
