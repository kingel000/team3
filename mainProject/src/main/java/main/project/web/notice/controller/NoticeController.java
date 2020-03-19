package main.project.web.notice.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	//<!-- *******BeakRyun_20200310 -->
	//-----------AdminBoardNotice_Main_GET
	@RequestMapping(value = "/notice.do", method= RequestMethod.GET)	//Site Address
	public String Notice_Main(@RequestParam("num") int num, HttpSession session, Model model) throws Exception {
		logger.info("NoticeMain GET Call");
		int count = noticeService.totalNotice();
		logger.info("����� ���"+count);
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
		
		List<NoticeVO> NoticeList = noticeService.noticePage(displayPost+1, postNum * num);

		model.addAttribute("NoticeList", NoticeList);
		// ���� �� �� ��ȣ
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);

		// ���� �� ���� 
		model.addAttribute("prev", prev);
		model.addAttribute("next", next);

		// ���� ������
		model.addAttribute("select", num);
		return "board/noticeBoard.part2";								//jsp Address
	}


	//<!-- *******BeakRyun_20200310 -->
	//-----------AdminBoardNotice_Detail_GET	//�Խñ� ���� GET
	@RequestMapping(value = "/notice_Detail.do", method= RequestMethod.GET)	
	public String Notice_Detail(@RequestParam String num, Model model) {
		logger.info("Notice_Detail GET Call");

		NoticeVO noticeList = noticeService.Notice_Detail(num);
		logger.info("NoticeDetail_Num GET : "+ noticeList.getBoard_notice_num());
		
		model.addAttribute("board_notice",noticeList);
		return "board/notice_Detail.part2";
	}

}
