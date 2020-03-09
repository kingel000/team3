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
import main.project.web.purchase.Service.IPurchaseService;
import main.project.web.purchase.vo.CartVO;
import main.project.web.question.service.IQuestionService;
import main.project.web.question.vo.PagingVO;
import main.project.web.question.vo.QuestionVO;


@Controller("questionController")
@RequestMapping(value="/board")
public class QuestionController {

	@Autowired
	private IQuestionService questionService;
	@Autowired
	private IPurchaseService purchaseService;
	
	//���ǻ��� �̵�
	@RequestMapping(value="/question.do", method= RequestMethod.GET)
	public String questionMain( Model model, HttpSession session, QuestionVO question, PagingVO vo,
			@RequestParam(value="nowPage", required=false)String nowPage,
			@RequestParam(value="cntPerPage", required=false)String cntPerPage) {
		System.out.println("���ǻ��װԽ��� �̵�");	

		int total = questionService.selectTotal();
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "5";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "5";
		}
		vo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		model.addAttribute("paging", vo);
		List<QuestionVO> questionList = questionService.selectPage(vo);
		model.addAttribute("questionList", questionList);
		//��ٱ���
		MemberVO member = (MemberVO) session.getAttribute("member");
		if(member != null) {
			List<CartVO> cartList = purchaseService.selectMyCart(member.getId());
			if(cartList != null) {
				model.addAttribute("cartList",cartList);
				if(cartList.size() != 0) {
					model.addAttribute("count",cartList.size());
				}
			}
		}
		return "board/questionBoard.part2";
	}

	//���ǻ��� �۾��� ��ư Ŭ��
	@RequestMapping(value = "/question_W.do", method=RequestMethod.GET)
	public String questionWriter(Model model, HttpSession session) {
		//��ٱ���
		MemberVO member = (MemberVO) session.getAttribute("member");
		if(member != null) {
			List<CartVO> cartList = purchaseService.selectMyCart(member.getId());
			if(cartList != null) {
				model.addAttribute("cartList",cartList);
				if(cartList.size() != 0) {
					model.addAttribute("count",cartList.size());
				}
			}
		}
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
		return "redirect:/board/question.do";
	}

	//�� �ڼ���
	@RequestMapping(value = "/questionView.do", method=RequestMethod.GET)
	public String questionView(@RequestParam Integer num,  QuestionVO question, Model model, HttpSession session) {
		question.setBoard_question_num(num);
		question = questionService.selectQuestion(question);
		model.addAttribute("question", question);

		//��ٱ���
		MemberVO member = (MemberVO) session.getAttribute("member");
		if(member != null) {
			List<CartVO> cartList = purchaseService.selectMyCart(member.getId());
			if(cartList != null) {
				model.addAttribute("cartList",cartList);
				if(cartList.size() != 0) {
					model.addAttribute("count",cartList.size());
				}
			}
		}
		return "board/questionView.part2";
	}


	//�� ����
	@RequestMapping(value = "/deleteQuestion.do", method=RequestMethod.GET)
	public String deleteQuestion(@RequestParam Integer num,QuestionVO question, Model model) {
		System.out.println("���ǻ��� �� ����");
		question.setBoard_question_num(num);
		questionService.deleteQuestion(question);
		return "redirect:/board/question.do";
	}

	

}
