package main.project.web.question.conrtoller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

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
	public String questionMain(@RequestParam(value="num")int num, Model model, 
			HttpSession session, QuestionVO question) throws Exception {
		System.out.println("문의사항게시판 이동");	
		int count = questionService.selectTotal();
		System.out.println(count);
		// 한 페이지에 출력할 게시물 갯수
		int postNum = 10;
		// 출력할 게시물
		int displayPost = (num - 1) * postNum;
		// 한번에 표시할 페이징 번호의 갯수
		int pageNum_cnt = 5;

		// 표시되는 페이지 번호 중 마지막 번호
		int endPageNum = (int)(Math.ceil((double)num / (double)pageNum_cnt) * pageNum_cnt);

		// 표시되는 페이지 번호 중 첫번째 번호
		int startPageNum = endPageNum - (pageNum_cnt - 1);

		// 마지막 번호 재계산
		int endPageNum_tmp = (int)(Math.ceil((double)count / (double)postNum));

		if(endPageNum > endPageNum_tmp) {
			endPageNum = endPageNum_tmp;
		}
		boolean prev = startPageNum == 1 ? false : true;
		boolean next = endPageNum * postNum >= count ? false : true;
		int num1 = num==1 ? 0 : 1;
		List<QuestionVO> questionList = questionService.questionPage(displayPost+num1, postNum * num);
		model.addAttribute("questionList",questionList);

		// 시작 및 끝 번호
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);

		// 이전 및 다음 
		model.addAttribute("prev", prev);
		model.addAttribute("next", next);

		// 현재 페이지
		model.addAttribute("select", num);

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
		return "redirect:/board/question.do?num=1";
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
		return "redirect:/board/question.do?num=1";
	}

	

}
