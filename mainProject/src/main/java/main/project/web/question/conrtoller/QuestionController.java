package main.project.web.question.conrtoller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import main.project.web.question.service.IQuestionService;
import main.project.web.question.service.QuestionService;
import main.project.web.question.vo.QuestionVO;

@Controller("questionController")
@RequestMapping(value="/board")
public class QuestionController {
	
	@Autowired
	private IQuestionService questionService;
	
	@RequestMapping(value="/question.do", method=RequestMethod.GET)
	public String questionMain(Model model, HttpSession session) {
		return "board/questionBoard.part2";
	}
	
	public String questionMain(Model model, HttpSession session, QuestionVO question) {
		System.out.println(question.getBoard_question_title());
		System.out.println(question.getBoard_question_info());
		
		return "board/questionBoard.part2";
	}
	
	@RequestMapping(value = "/question_W.do", method=RequestMethod.GET)
	public String questionWriter() {
		return "board/questionWriter.part2";
	}
	
	@RequestMapping(value="/notice.do", method=RequestMethod.GET)
	public String noticeMain(Model model, HttpSession session) {
		return "board/noticeBoard.part2";
	}
	
	
	
}
