package main.project.web.notice.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String Notice_Main(HttpSession session, Model model) {
		System.out.println("NoticeMain GET Call");

		List<NoticeVO> NoticeList = noticeService.selectListNotice();
		if(NoticeList != null) {
			model.addAttribute("NoticeList", NoticeList);
		}

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
