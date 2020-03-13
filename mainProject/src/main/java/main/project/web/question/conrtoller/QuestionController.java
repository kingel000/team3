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
	
	//���ǻ��� �̵�
	@RequestMapping(value="/question.do", method= RequestMethod.GET)
	public String questionMain(@RequestParam(value="num")int num, Model model, 
			HttpSession session, QuestionVO question) throws Exception {
		System.out.println("���ǻ��װԽ��� �̵�");	
		int count = questionService.selectTotal();
		System.out.println(count);
		// �� �������� ����� �Խù� ����
		int postNum = 10;
		// ����� �Խù�
		int displayPost = (num - 1) * postNum;
		// �ѹ��� ǥ���� ����¡ ��ȣ�� ����
		int pageNum_cnt = 5;

		// ǥ�õǴ� ������ ��ȣ �� ������ ��ȣ
		int endPageNum = (int)(Math.ceil((double)num / (double)pageNum_cnt) * pageNum_cnt);

		// ǥ�õǴ� ������ ��ȣ �� ù��° ��ȣ
		int startPageNum = endPageNum - (pageNum_cnt - 1);

		// ������ ��ȣ ����
		int endPageNum_tmp = (int)(Math.ceil((double)count / (double)postNum));

		if(endPageNum > endPageNum_tmp) {
			endPageNum = endPageNum_tmp;
		}
		boolean prev = startPageNum == 1 ? false : true;
		boolean next = endPageNum * postNum >= count ? false : true;
		int num1 = num==1 ? 0 : 1;
		List<QuestionVO> questionList = questionService.questionPage(displayPost+num1, postNum * num);
		model.addAttribute("questionList",questionList);

		// ���� �� �� ��ȣ
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);

		// ���� �� ���� 
		model.addAttribute("prev", prev);
		model.addAttribute("next", next);

		// ���� ������
		model.addAttribute("select", num);

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

		question.setBoard_question_writer(id);	
		question.setBoard_question_num(num);
		question.setState("���� ��");

		questionService.insertQuestion(question);
		return "redirect:/board/question.do?num=1";
	}

	//�� �ڼ���
	@RequestMapping(value = "/questionView.do", method=RequestMethod.GET)
	public String questionView(@RequestParam Integer num,  QuestionVO question, Model model, HttpSession session) {
		question.setBoard_question_num(num);
		question = questionService.selectQuestion(question);
		model.addAttribute("question", question);

		return "board/questionView.part2";
	}


	//�� ����
	@RequestMapping(value = "/deleteQuestion.do", method=RequestMethod.GET)
	public String deleteQuestion(@RequestParam Integer num,QuestionVO question, Model model) {
		System.out.println("���ǻ��� �� ����");
		question.setBoard_question_num(num);
		questionService.deleteQuestion(question);
		return "redirect:/board/question.do?num=1";
	}

	

}
