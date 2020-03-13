package main.project.web.question.dao;

import java.util.List;

import main.project.web.question.vo.QuestionVO;

public interface IQuestionDAO {
	void insertQuestion(QuestionVO question);
	void deleteQuestion(QuestionVO question);
	QuestionVO selectQuestion(QuestionVO question);
	List<QuestionVO> selectListQuestion();
	Integer selectNumQuestion(); //���Ǳ� ��ȣ
	Integer selectTotal(); // ��ü ������ ����
	List<QuestionVO> questionPage(int displayPost, int postNum) throws Exception;
	List<QuestionVO> questionPageM(int displayPost, int postNum) throws Exception;
	void rejoinderQuestion(QuestionVO question);
	Integer selectStateTotal();
}
