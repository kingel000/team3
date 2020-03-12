package main.project.web.notice.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import main.project.web.member.vo.MemberVO;
import main.project.web.notice.service.INoticeService;
import main.project.web.notice.vo.NoticeVO;

@Controller("NoticeController")
@RequestMapping(value="/board")
public class NoticeController {

	@Autowired
	private INoticeService noticeService;

	//<!-- *******BeakRyun_20200310 -->
	//-----------AdminBoardNotice_Main_GET
	@RequestMapping(value = "/notice.do", method= RequestMethod.GET)	//Site Address
	public String Notice_Main(@RequestParam("num") int num, HttpSession session, Model model) throws Exception {
		System.out.println("NoticeMain GET Call");
		int count = noticeService.totalNotice();
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
		List<NoticeVO> NoticeList = noticeService.noticePage(displayPost+num1, postNum * num);
		model.addAttribute("NoticeList", NoticeList);
		// 시작 및 끝 번호
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);

		// 이전 및 다음 
		model.addAttribute("prev", prev);
		model.addAttribute("next", next);

		// 현재 페이지
		model.addAttribute("select", num);
		return "board/noticeBoard.part2";								//jsp Address
	}


	//<!-- *******BeakRyun_20200310 -->
	//-----------AdminBoardNotice_Detail_GET	//게시글 보기 GET
	@RequestMapping(value = "/notice_Detail.do", method= RequestMethod.GET)	
	public String Notice_Detail(@RequestParam String num, Model model) {
		System.out.println("Notice_Detail GET Call");

		NoticeVO noticeList = noticeService.Notice_Detail(num);
		System.out.println("NoticeDetail_Num GET : "+ noticeList.getBoard_notice_num());
		
		model.addAttribute("board_notice",noticeList);
		return "board/notice_Detail.part2";
	}
	
	//<!-- *******BeakRyun_20200310 -->
	//-----------AdminBoardNotice_Detail_POST	//게시글 보기 POST
	@RequestMapping(value = "/notice_Detail.do", method= RequestMethod.POST)	
	public String Notice_Detail(NoticeVO noticeVO) {

		Integer noticeNum = noticeService.selectNoticeNumber();
		System.out.println("NoticeDetail_Num1 POST : " + noticeVO.getBoard_notice_num());
		
		noticeVO.setBoard_notice_num(noticeNum);
		System.out.println("NoticeDetail_Num POST : " + noticeVO.getBoard_notice_num());

		noticeService.insertNoticeVO(noticeVO);
		return "board/notice_Detail.part2";
	}


}
