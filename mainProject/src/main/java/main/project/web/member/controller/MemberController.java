package main.project.web.member.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import main.project.web.chat.service.IChatContentService;
import main.project.web.chat.service.IRoomListService;
import main.project.web.chat.vo.ChatContentVO;
import main.project.web.chat.vo.RoomListVO;
import main.project.web.mail.MailUtils;
import main.project.web.mail.TempKey;
import main.project.web.member.service.IExpertService;
import main.project.web.member.service.IMemberService;
import main.project.web.member.vo.ExpertVO;
import main.project.web.member.vo.MemberVO;
import main.project.web.point.service.IPointService;
import main.project.web.point.vo.PointVO;
import main.project.web.product.service.IProductService;
import main.project.web.product.vo.ProductVO;
import main.project.web.purchase.Service.IPurchaseService;
import main.project.web.purchase.vo.PurchaseVO;

@Controller("memberController")
@RequestMapping(value="/member")
public class MemberController {
	@Autowired
	private IMemberService memberService;
	@Autowired
	private IExpertService expertService;
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private IProductService productService;
	@Autowired
	private IPurchaseService purchaseService;
	@Autowired
	private IPointService pointService;
	@Autowired
	private IChatContentService chatContentService;
	@Autowired
	private IRoomListService roomListService;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping(value="/login.do", method = RequestMethod.GET)
	public String memberLogin(Model model) {
		return "member/login";
	}

	@RequestMapping(value="/login.do", method = RequestMethod.POST)
	public String memberLogin(MemberVO member,HttpSession session, Model model) {
		logger.info("�α��� �õ� ���� ����:" + member);
		MemberVO check = memberService.selectMember(member.getEmail());
		logger.info("�α��� ����� ����:"+check);

		if(check != null) {
			if(check.getPwd().equals(member.getPwd())) {
				session.setAttribute("member", check);
				model.addAttribute("member", check);
				String msg = check.getNick_name()+" �� ȯ���մϴ�";
				model.addAttribute("msg",msg);
				return "redirect:/main/main.do";
			}else {
				String msg = "��й�ȣ ����";
				model.addAttribute("msg", msg);
			}
		}else {
			String msg = "���̵� ����";
			model.addAttribute("msg", msg);
		}
		return "member/login";
	}

	@RequestMapping(value="/regiser.do",method=RequestMethod.GET)
	public String memberRegiser(Model model) {
		return "member/regiser_f";
	}

	@RequestMapping(value="/regiser.do",method=RequestMethod.POST)
	public String memberRegiser(MemberVO member, Model model, HttpSession session) {
		member.setId("ID"+(new SimpleDateFormat("yyyyMMdd")).format(new Date())+"_"+memberService.totalMember());
		memberService.insertMember(member);
		return "member/login";
	}

	@RequestMapping(value="/auth.do", method=RequestMethod.POST)
	public String memberAuth(MemberVO member, Model model,HttpServletResponse response) {
		MemberVO check = memberService.selectMember(member.getEmail());
		System.out.println(check);
		if(check == null) {
			String authKey = new TempKey().getKey(8, false);
			try {
				// mail �ۼ� ���ñ��
				MailUtils sendMail = new MailUtils(mailSender);
				StringBuffer stb = new StringBuffer();
				stb.append("<h1>[�̸��� ����]</h1>");
				stb.append("<p>�ȳ��ϼ��� ȸ���� ���� Ȩ�������� ã���ּż� �����մϴ�.</p>");
				stb.append("������ȣ�� ");
				stb.append(authKey);
				stb.append(" �Դϴ�.");

				sendMail.setSubject("ȸ������ �̸��� ����");
				sendMail.setText(stb.toString());
				sendMail.setFrom("item2881@gmail.com ", "Item");
				sendMail.setTo(member.getEmail());
				sendMail.send();
			} catch (MessagingException e1) {
				e1.printStackTrace();
			}catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			try {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter  out_email = response.getWriter();
				out_email.println("<script>alert('�̸����� �߼۵Ǿ����ϴ�. ������ȣ�� �Է����ּ���.');</script>");
				out_email.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			model.addAttribute("authKey", authKey);
			model.addAttribute("member", member);
		}else {
			try {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter  out_email = response.getWriter();
				out_email.println("<script>alert('�Է��� ���̵� �ߺ��Դϴ�. ���̵� �ٽ� �Է����ּ���.');</script>");
				out_email.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
			}
		}
		return "member/regiser_f";
	}

	@RequestMapping(value="/authKey.do", method=RequestMethod.POST)
	public String memberAuthKey(MemberVO member,String key, String authKey, Model model) {
		if(authKey.equals(key)) {
			model.addAttribute("member",member);
			return "member/regiser_s";
		}
		return "member/regiser_f";
	}

	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	public String memberLogout(HttpSession session, Model model) {
		session.invalidate();
		return "redirect:/main/main.do";
	}

	@RequestMapping(value="/mypage.do", method = RequestMethod.GET)
	public String memberMyPage(HttpSession session,Model model) {
		logger.info("mypage GET ȣ��");
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		if(memberVO == null) {
			return "redirect:/main/main.do";
		}
		ExpertVO exeprtVO = expertService.selectExpert(memberVO.getId());
		logger.info("MYPAGE ���� ���� expertVO : " + exeprtVO);
		logger.info("MYPAGE ���� ���� memberVO : " + memberVO);
		model.addAttribute("expert",exeprtVO);
		model.addAttribute("member",memberVO);
				
		
		List<RoomListVO> rl = roomListService.getRoomList(memberVO.getId());
		Integer rc = 0;
		if(rl.size() != 0) {
			for(RoomListVO r : rl) {
				Integer n = chatContentService.selectReceiveRoomCount(new ChatContentVO(r.getRoom_id(),r.getMember_id(),"no"));
				if(rc != null) {
					rc += n;
				}
			}
			
			model.addAttribute("mrCount", rc);
			
		}else {
			model.addAttribute("mrCount", 0);
		}
		
		if(memberVO.getRank().equals("E")) {			
			List<RoomListVO> roomList = roomListService.getMemberList(memberVO.getId());
			Integer receiveCountList = 0;
			if(roomList.size() != 0) {
				for(RoomListVO r : roomList) {
					Integer n = chatContentService.selectReceiveRoomCount(new ChatContentVO(r.getRoom_id(),r.getExpert_id(),"no"));
					if(n != null) {
						receiveCountList += n;	
					}
							
				}
				model.addAttribute("erCount", receiveCountList);
				
			}else {
				model.addAttribute("erCount", 0);
			}
			
			List<PurchaseVO> purchaseList = purchaseService.selectExpertPurchase(memberVO.getId());
			int count = 0;
			if(purchaseList.size()>0) {
				for(PurchaseVO purchase:purchaseList) {
					if(purchase.getPurchase_state().equals("Waiting")) {
						count++;
					}
				}
				model.addAttribute("wCount", count);
			}
		}
		return "member/mypage.page";
	}
	
	@RequestMapping(value="/point.do", method = RequestMethod.POST)
	public String point(ExpertVO expert,Integer point,HttpSession session,Model model) {
		logger.info("point.do POST ȣ��");
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		if(memberVO == null) {
			return "redirect:/main/main.do";
		}
		ExpertVO expertVO = expertService.selectExpert(memberVO.getId());
		logger.info("��� ���ϴ� ����� ���� ����Ʈ : " + expertVO.getPoint() );
		logger.info("��� ���ϴ� ����Ʈ : " + point);
		Integer Point = expertVO.getPoint() - point ;
		logger.info("������Ʈ �ؾ� �� ����Ʈ : "  + Point);
		expertVO.setPoint(Point);
		expertService.updatePointExpert(expertVO);
		PointVO p = new PointVO(pointService.selectCount()+1,expertVO.getId(),point,"�����");
		pointService.insertPoint(p);
		return "redirect:/member/pointManager.do";
	}
	
	@RequestMapping(value="/pointManager.do", method = RequestMethod.GET)
	public String pointManager(HttpSession session,Model model) {
		logger.info("pointManager GET ȣ��");
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		List<PointVO> pointList = pointService.selectPointId(memberVO.getId());
		model.addAttribute("pointList",pointList);
		return "member/pointManager.page";
	}
	

	@RequestMapping(value="/editMember.do", method=RequestMethod.GET)
	public String editMember(HttpSession session, Model model) {
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		model.addAttribute("member", memberVO);
		return "member/editMember.page";
	}

	@RequestMapping(value="/editMember.do", method=RequestMethod.POST)
	public String editMember(String password, MemberVO member,HttpSession session,Model model) {
		MemberVO  check = (MemberVO) session.getAttribute("member");
		if(check.getPwd().equals(password)) {
			memberService.updateMember(member);
			session.setAttribute("member", member);
			model.addAttribute("member",member);
			String msg = "ȸ������ ����Ϸ�";
			model.addAttribute("msg",msg);
			return "member/editMember.page";
		}
		String msg = "��й�ȣ �ٽ� Ȯ��";
		model.addAttribute("msg",msg);
		return "member/editMember.page";
	}
	@RequestMapping(value="/rankUp.do", method = RequestMethod.GET)
	public String rankUpPage() {
		return "member/rankUp.page";
	}

	@RequestMapping(value="/rankUp.do", method = RequestMethod.POST)
	public String rankUpPage(ExpertVO expert , Model model , HttpSession session) {
		MemberVO member = (MemberVO)session.getAttribute("member");
		String sessionId =member.getId();
		expert.setId(sessionId);
		logger.info("�Է��� �Ǹ��� ����:"+expert);
		expertService.insertExpert(expert);
		memberService.rankupdate(sessionId);
		member.setRank("E");
		session.setAttribute("member", member);
		return "member/mypage.page";
	}

	@RequestMapping(value="/editExpert.do",method=RequestMethod.GET)
	public String editExpert(HttpSession session,Model model) {
		ExpertVO expert = expertService.selectExpert(((MemberVO)session.getAttribute("member")).getId());
		logger.info("�����ϴ� ������ ���� : "  + expert);
		model.addAttribute("expert", expert) ;
		return "member/editExpert.page";
	}

	@RequestMapping(value="/editExpert.do", method=RequestMethod.POST)
	public String editExpert(ExpertVO expert, Model model) {
		logger.info("editExpert.do POST expert:"+expert);
		expertService.updateExpert(expert);
		return "member/mypage.page";
	}

	@RequestMapping(value="/withdrawal.do", method= RequestMethod.GET)
	public String Withdrawal(MemberVO member, Model model) {
		logger.info("ȸ�� Ż�� GET ȣ��");	
		return "member/withdrawal.page";
	}

	@RequestMapping(value="/withdrawal.do", method= RequestMethod.POST)
	public String Withdrawal(String password ,Model model, HttpSession session) {
		MemberVO  check = (MemberVO) session.getAttribute("member");

		logger.info("check : " + check);
		logger.info("password : " + password);
		if(password != null) {
			if(check.getPwd().equals(password)) {
				session.invalidate();
				memberService.deleteMember(check);
				if(check.getRank().equals("E")) {
					//expertService.deleteExpert(check.getId());
					productService.deleteProductId(check.getId());
				}
				String msg = "ȸ��Ż�� �Ǿ����ϴ�.";
				model.addAttribute("msg",msg);
				return "redirect:/main/main.do";
			}
		}
		String msg = "��й�ȣ �ٽ� Ȯ��";
		model.addAttribute("msg",msg);
		
		return "member/mypage.page";
	}

	@RequestMapping(value="/boardManager.do", method = RequestMethod.GET)
	public String editBoard(ExpertVO expert, HttpSession session , Model model) {
		String sessionId = ((MemberVO)session.getAttribute("member")).getId();
		expert.setId(sessionId);
		session.setAttribute("expert",expert);
		return "member/boardManager.page";
	}

	@RequestMapping(value="/boardManager.do", method = RequestMethod.POST)
	public String editBoard(ExpertVO expert , Model model , HttpSession session) {
		return "redirect:main/main.do";
	}

	@RequestMapping(value="/masterPage.do", method = RequestMethod.GET)
	public String masterPage(Model model , HttpSession session) {
		logger.info("masterPage GET ȣ��");
		return "member/masterPage";
	}

	@RequestMapping(value="/masterPage.do", method = RequestMethod.POST)
	public String masterPage(MemberVO member, Model model , HttpSession session) {
		logger.info("masterPage POST ȣ��");
		return "member/masterDetail.page2";
	}
	
	
}