package main.project.web.question.conrtoller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import main.project.web.member.vo.MemberVO;
import main.project.web.question.service.IQuestionService;
import main.project.web.question.vo.QuestionVO;


@Controller("questionController")
@RequestMapping(value="/board")
public class QuestionController {
	
	@Autowired
	private IQuestionService questionService;
	
	//문의사항 이동
	@RequestMapping(value="/question.do", method= RequestMethod.GET)
	public String questionMain(Model model, HttpSession session, QuestionVO question) {
		System.out.println("문의사항게시판 이동");
		List<QuestionVO> questionList = questionService.selectListQuestion();
		model.addAttribute("questionList", questionList);
		return "board/questionBoard.part2";
	}
	
	//문의사항 글쓰기 버튼 클릭
	@RequestMapping(value = "/question_W.do", method=RequestMethod.GET)
	public String questionWriter(Model model, HttpSession session) {	
		return "board/questionWriter.part2";
	}
	
	//문의사항 등록 버튼 클릭
	@RequestMapping(value = "/question.do", method = RequestMethod.POST)
	public String questionMain1(Model model, HttpSession session, QuestionVO question) {
		System.out.println("문의 글 등록");
		MemberVO member = (MemberVO)session.getAttribute("member");
		String id = member.getId();
		question.setBoard_question_writer(id);	
		int questionNum = questionService.selectNumQuestion();
		int num = questionNum;
		
		question.setBoard_question_writer(id);	
		question.setBoard_question_num(num);
		question.setState("접수 중");
		
		questionService.insertQuestion(question);
		return "redirect:/board/question.do";
	}
	
	//글 자세히
	@RequestMapping(value = "/questionView.do", method=RequestMethod.GET)
	public String questionView(@RequestParam Integer num,  QuestionVO question, Model model, HttpSession session) {
		question.setBoard_question_num(num);
		question = questionService.selectQuestion(question);
		model.addAttribute("question", question);
		return "board/questionView.part2";
	}
	
	
	//글 삭제
	@RequestMapping(value = "/deleteQuestion.do", method=RequestMethod.GET)
	public String deleteQuestion(@RequestParam Integer num,QuestionVO question, Model model) {
		System.out.println("문의사항 글 삭제");
		question.setBoard_question_num(num);
		questionService.deleteQuestion(question);
		return "redirect:/board/question.do";
	}
	
	//공지사항 이동	
	@RequestMapping(value="/notice.do", method=RequestMethod.GET)
	public String noticeMain(Model model, HttpSession session) {
		return "board/noticeBoard.part2";
	}
	

}
