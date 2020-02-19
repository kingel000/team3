package main.project.web.question.conrtoller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import main.project.web.member.vo.MemberVO;
import main.project.web.question.service.IQuestionService;
import main.project.web.question.vo.QuestionVO;


@Controller("questionController")
@RequestMapping(value="/board")
public class QuestionController {
	
	@Autowired
	private IQuestionService questionService;
	
	//���ǻ��� �̵�
	@RequestMapping(value="/question.do", method=RequestMethod.GET)
	public String questionMain(Model model, HttpSession session, QuestionVO question) {
		System.out.println("���ǻ��װԽ��� �̵�");
		List<QuestionVO> questionList = questionService.selectListQuestion();
		model.addAttribute("questionList", questionList);
		return "board/questionBoard.part2";
	}
	
	//���ǻ��� �۾��� ��ư Ŭ��
	@RequestMapping(value = "/question_W.do", method=RequestMethod.GET)
	public String questionWriter(Model model, HttpSession session) {	
	return "board/questionWriter.part2";
	}
	
	//���ǻ��� ��� ��ư Ŭ��
	@RequestMapping(value = "/question.do", method = RequestMethod.POST)
	public String questionMain1(Model model, HttpSession session, QuestionVO question) {
		System.out.println("���� �� ���");
		MemberVO member = (MemberVO)session.getAttribute("member");
		String id = member.getId();
		question.setBoard_question_writer(id);	
		
		int questionNum = questionService.selectNumQuestion();
		int num = questionNum;

		question.setBoard_question_num(num);
		System.out.println(question);
		
		//questionService.insertQuestion(question);
		return "board/questionBoard.part2";
	}
	
	//�������� �̵�	
	@RequestMapping(value="/notice.do", method=RequestMethod.GET)
	public String noticeMain(Model model, HttpSession session) {
		return "board/noticeBoard.part2";
	}
	
}
