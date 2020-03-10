package main.project.admin;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import main.project.admin.board.service.adminIBoardNoticeService;
import main.project.admin.board.vo.AdminBoardNoticeVO;
import main.project.web.member.service.IExpertService;
import main.project.web.member.service.IMemberService;

import main.project.web.member.vo.ExpertVO;

import main.project.web.member.vo.MemberVO;
import main.project.web.product.service.IProductService;
import main.project.web.product.vo.ProductVO;


import main.project.web.purchase.Service.IPurchaseService;
import main.project.web.purchase.vo.CartVO;
import main.project.web.purchase.vo.PurchaseVO;

import main.project.web.product.vo.findVO;


@Controller("adminController")
@RequestMapping(value="/admin")
public class adminController {

	//* package  -> "main.project.admin
	//localhost:8080/web/admin/*.mdo

	@Autowired
	private IProductService productService;
	@Autowired
	private IMemberService memberService;
	@Autowired
	private IExpertService expertService;
	@Autowired
	private IPurchaseService purchaseService;

	@Autowired
	private adminIBoardNoticeService adminBoardNoticeService;



	@RequestMapping({"/","/admin.mdo"})
	public String home(Locale locale, Model model) {
		System.out.println("ADMIN MAIN MDO 호출");
		return "admin/adminMain";
	}

	//-----------로그인 검증
	@RequestMapping(value = "/adminDetail.mdo" , method = RequestMethod.POST )
	public String adminDetail(MemberVO member,HttpSession session, Model model) {
		System.out.println("ADMIN DETAIL MDO POST 호출");
		System.out.println(member.getId());
		System.out.println(member.getPwd());
		MemberVO check = memberService.selectMember(member);
		System.out.println(check);

		if(check != null) {
			if(check.getPwd().equals(member.getPwd())) {
				if(check.getRank().equals("M")) {
					session.setAttribute("member", check);
					model.addAttribute("member", check);
					return "admin/adminDetail.page2";
				}else {
					String msg = "관리자 아이디가 입니다. 위의 링크를 눌러 메인페이지로 이동하세요";
					model.addAttribute("msg", msg);
				}
			}else {
				String msg = "비밀번호 오류입니다.";
				model.addAttribute("msg", msg);
			}
		}else {
			String msg = "존재하지 않는 아이디 입니다.";
			model.addAttribute("msg", msg);
		}




		return "admin/adminMain";
	}


	//-----------멤버관리
	@RequestMapping(value="/memberManager.mdo",method = RequestMethod.GET)
	public String memberManager(HttpSession session,Model model) {
		System.out.println("memberManager mdo GET 호출 ");
		List<MemberVO> adminmemberList = memberService.selectAllMember();
		model.addAttribute("adminmemberList",adminmemberList);
		return "admin/adminMember.page2";
	}

	@RequestMapping(value = "/adminMemberDelete.mdo", method= RequestMethod.GET)
	public String adminMemberDelete(@RequestParam String id,MemberVO member, HttpSession session , Model model) {
		System.out.println("adminMemeberDelte.mdo GET 호출");
		System.out.println("넘어온 아이디 : " + id);
		member.setId(id);
		System.out.println(member);
		memberService.admindeleteMember(member);
		return "redirect:/admin/memberManager.mdo";
	}

	@RequestMapping(value = "/adminmemberEdit.mdo", method= RequestMethod.GET)
	public String adminmemberEdit(@RequestParam String id,MemberVO member, HttpSession session , Model model) {

		MemberVO memberVO = (MemberVO)memberService.selectMember(member);
		ExpertVO expertVO = (ExpertVO)expertService.selectExpert(id);
		System.out.println("수정하고자 하는 판매자 정보:" + expertVO);
		System.out.println("수정하고자 하는 계정 정보 "  + memberVO);
		model.addAttribute("expert",expertVO);
		model.addAttribute("member",memberVO);
		return "admin/adminMemberDetail.page2";
	}
	@RequestMapping(value = "/adminmemberEdit.mdo", method= RequestMethod.POST)
	public String adminmemberEdit(ExpertVO expert,MemberVO member, Model model , HttpSession session) {
		System.out.println("수정된 멤버 정보 : " + member);
		System.out.println("수정된 판매자 정보 : " + expert);
		if(member.getRank() == null || member.getRank() == "") {
			System.out.println("if 문 들어왔음");
			String rank = memberService.selectMember(member).getRank();
			System.out.println(rank);

			member.setRank(rank);

		}
		if(member.getPwd() == null || member.getPwd() == "") {
			System.out.println("pwd if 문 들어옴");
			String pwd = memberService.selectMember(member).getPwd();
			System.out.println(pwd);

			member.setPwd(pwd);
		}
		System.out.println(member);
		memberService.updateMember(member);
		expertService.updateExpert(expert);

		if( member.getRank() == "N" || member.getRank().equals("N")) {
			System.out.println("변경한 RANK = N 진입");
			expertService.deleteExpert(member.getId());
		}
		return "redirect:/admin/memberManager.mdo";
	}



	@RequestMapping(value = "/memberfind.mdo", method= RequestMethod.POST)
	public String memberfind(@RequestParam String category, @RequestParam String findText,
			MemberVO member, findVO find,HttpSession session , Model model) {
		if(category.equals("이메일") || category == "이메일") {

			find.setCategory("id");
		}else {
			find.setCategory("nick_name");
		}
		find.setFindText(findText);
		System.out.println(find);

		List<MemberVO> adminmemberList = memberService.selectFindList(find);
		System.out.println(adminmemberList);

		model.addAttribute("adminmemberList",adminmemberList);
		return "admin/adminMember.page2";
	}








	//-----------상품관리
	@RequestMapping(value = "/adminProduct.mdo", method= RequestMethod.GET )
	public String ProductManager( HttpSession session , Model model) {
		List<ProductVO> adminproductList = productService.selectAllListProduct();
		model.addAttribute("adminproductList", adminproductList);

		return "admin/adminProduct.page2";
	}

	//관리자모드에서 상품삭제
	@RequestMapping(value = "/adminProductDelete.mdo", method= RequestMethod.GET)
	public String adminProductDelete(@RequestParam String num,ProductVO product, HttpSession session , Model model) {
		product.setProduct_num(num);
		productService.deleteProduct(product);
		return "redirect:/admin/adminProduct.mdo";
	}

	@RequestMapping(value = "/adminDetailProduct.mdo", method= RequestMethod.GET)
	public String adminDetailProduct(@RequestParam String num,ProductVO product, HttpSession session , Model model) {
		System.out.println("선택한 상품 번호 : " + num);
		product = productService.selectProduct(num);
		model.addAttribute("product", product);

		MemberVO nick_name = new MemberVO();
		nick_name = productService.select_NickName(product.getExpert_id());
		model.addAttribute("nick_name",nick_name);

		System.out.println(nick_name);
		System.out.println(product);

		return "admin/adminDetailProduct.page2";
	}

	@RequestMapping(value = "/find.mdo", method = RequestMethod.POST)
	public String find(@RequestParam String category, @RequestParam String findText,
			ProductVO product, findVO find,HttpSession session , Model model) {
		if(category.equals("카테고리") || category == "카테고리") {

			find.setCategory("category");
		}else {
			find.setCategory("expert_id");
		}
		find.setFindText(findText);
		List<ProductVO> adminproductList = productService.selectFindList(find);

		model.addAttribute("adminproductList",adminproductList);
		return "admin/adminProduct.page2";
	}


	/*

	//
	@RequestMapping(value = "/adminProductDelete.mdo", method= RequestMethod.GET)
	public String adminProductDelete(@RequestParam String num,ProductVO product, HttpSession session , Model model) {
		product.setProduct_num(num);
		productService.deleteProduct(product);
		return "redirect:/admin/adminProduct.mdo";
	}

	@RequestMapping(value = "/adminDetailProduct.mdo", method= RequestMethod.GET)
	public String adminDetailProduct(@RequestParam String num,ProductVO product, HttpSession session , Model model) {
		System.out.println("������ ��ǰ ��ȣ : " + num);
		product = productService.selectProduct(num);
		model.addAttribute("product", product);

		MemberVO nick_name = new MemberVO();
		nick_name = productService.select_NickName(product.getExpert_id());
		model.addAttribute("nick_name",nick_name);

		System.out.println(nick_name);
		System.out.println(product);

		return "admin/adminDetailProduct.page2";
	}
	 */


	//-----------홈페이지 관리
	@RequestMapping(value = "/adminHomePage.mdo", method= RequestMethod.GET)
	public String adminHomePageManager() {

		return "admin/adminHomePage.page2";
	}


	/*

   //---------- 거래 내역

   @RequestMapping(value = "/adminpurchase.mdo", method= RequestMethod.GET)
   public String adminpurchase(PurchaseVO purchase , ProductVO product, Model model , HttpSession session) {
	   System.out.println("admin Purchase GET 호출 ");
	   ArrayList<String>ExpertidList = new ArrayList<>();
	   ArrayList<String>ProducttitleList = new ArrayList<>();
	   //ArrayList<ProductVO>ExpertidList = new ArrayList<>();

	   try {
	   List<PurchaseVO> purchaseList = purchaseService.selectListPurchase();
	   System.out.println("거래내역 사이즈 : " + purchaseList.size());
	   for(PurchaseVO purchaseVO : purchaseList) {
			System.out.println("DB 저장된 거래 내역 리스트 !!! : " + purchaseVO);
			String Expert_id =  productService.selectProduct(purchaseVO.getProduct_num()).getExpert_id();
			String Product_title = productService.selectProduct(purchaseVO.getProduct_num()).getProduct_title();
			System.out.println("리스트에 들어가는 판매자 아이디 : " + Expert_id);
			ExpertidList.add(Expert_id);
			ProducttitleList.add(Product_title);
	 */


	//<!-- *******BeakRyun_20200305 -->
	//-----------AdminBoardNotice_Main_GET
	@RequestMapping(value = "/adminBoardNotice.mdo", method= RequestMethod.GET)	//Site Address
	public String adminBoardNotice(HttpSession session, Model model) {
		System.out.println("adminBoardNotice GET Call");

		List<AdminBoardNoticeVO> adminBoardNoticeList = adminBoardNoticeService.selectListAdminBoardNotice();
		if(adminBoardNoticeList != null) {
			//			for(AdminBoardNoticeVO adminBoardNotice : adminBoardNoticeList) {
			//				System.out.println(adminBoardNotice);
			//			}
			//System.out.println("NoticeNum : " +adminBoardNoticeService.selectListAdminBoardNotice().get(0).getBoard_notice_num());

			model.addAttribute("adminBoardNoticeList", adminBoardNoticeList);
		}

		return "admin/adminBoard_Notice.page2";								//jsp Address
	}


	//<!-- *******BeakRyun_20200305 -->
	//-----------AdminBoardNotice_Insert_GET	//등록
	@RequestMapping(value = "/adminBoard_Notice_Insert.mdo", method= RequestMethod.GET)	
	public String adminBoardNotice_Insert() {
		System.out.println("adminBoardNotice_Insert GET Call");

		return "admin/adminBoard_Notice_Insert.page2";								
	}

	//<!-- *******BeakRyun_20200305 -->
	//-----------AdminBoardNotice_Insert_Post
	@RequestMapping(value = "/adminBoard_Notice_Insert.mdo", method= RequestMethod.POST)	
	public String adminBoardNotice_Insert(AdminBoardNoticeVO abnVO, Model model) {
		System.out.println("adminBoardNotice_Insert POST Call");

		// +Notice_Next_Number
		Integer noticeNum = Integer.valueOf(adminBoardNoticeService.selectListAdminBoardNotice().get(0).getBoard_notice_num());
		noticeNum +=1;

		//System.out.println("InsertNotice_Num : " +noticeNum);
		abnVO.setBoard_notice_num(String.valueOf(noticeNum));

		adminBoardNoticeService.insertAbnVO(abnVO);

		return "redirect:/admin/adminBoardNotice.mdo";								
	}

	//<!-- *******BeakRyun_20200306 -->
	//-----------AdminBoardNotice_Detail_GET	//게시글 보기
	@RequestMapping(value = "/adminBoard_Notice_Detail.mdo", method= RequestMethod.GET)	
	public String adminBoardNotice_Detail(@RequestParam String num, Model model) {
		System.out.println("adminBoardNotice_Detail GET Call");

		//System.out.println("DetailNotice_Num GET: " + num);
		AdminBoardNoticeVO board = adminBoardNoticeService.adminBoardNotice_Detail(num);

		model.addAttribute("board_notice",board);	

		return "admin/adminBoard_Notice_Detail.page2";				
	}
	

	//<!-- *******BeakRyun_20200306 -->
	//-----------AdminBoardNotice_Detail_POST	//게시글 보기
	@RequestMapping(value = "/adminBoard_Notice_Detail.mdo", method= RequestMethod.POST)	
	public String adminBoardNotice_Detail(AdminBoardNoticeVO abnVO) {

		Integer noticeNum = adminBoardNoticeService.selectBoardNoticeNumber();
		abnVO.setBoard_notice_num(String.valueOf(noticeNum));

		//System.out.println("UpdateNotice_Num POST : " + abnVO.getBoard_notice_num());
		adminBoardNoticeService.insertAbnVO(abnVO);
		return "admin/adminBoard_Notice_Detail.page2";				
	}


	//<!-- *******BeakRyun_20200306 -->
	//-----------AdminBoardNotice_Update_GET	//수정
	@RequestMapping(value = "/adminBoard_Notice_Update.mdo", method= RequestMethod.GET)	
	public String adminBoardNotice_Update(@RequestParam String num, Model model) {
		System.out.println("adminBoardNotice_Update GET Call");

		//System.out.println("UpdateNotice_Num : " + num);		
		AdminBoardNoticeVO board = adminBoardNoticeService.adminBoardNotice_Detail(num);

		//System.out.println("board : "+board);		
		model.addAttribute("board_notice",board);		

		return "admin/adminBoard_Notice_Update.page2";
	}

	//<!-- *******BeakRyun_20200306 -->
	//-----------AdminBoardNotice_Update_POST	//수정
	@RequestMapping(value = "/adminBoard_Notice_Update.mdo", method= RequestMethod.POST)	
	public String adminBoardNotice_Update(AdminBoardNoticeVO abnVO) {
		System.out.println("adminBoardNotice_Update POST  Call");

		//System.out.println("abnVO : "+abnVO);
		adminBoardNoticeService.updateBoardNotice(abnVO);

		return "redirect:/admin/adminBoardNotice.mdo";								
	}


	//<!-- *******BeakRyun_20200306 -->
	//-----------AdminBoardNotice_Delete_GET	//삭제
	@RequestMapping(value = "/adminBoard_Notice_Delete.mdo", method=RequestMethod.GET)
	public String adminBoardNotice_Delete(@RequestParam String num, Model model) {
		System.out.println("adminBoardNotice_Delete GET  Call");		

		//System.out.println("DeleteNotice_Num : " + num);		
		adminBoardNoticeService.deleteBoardNotice(num);

		return "redirect:/admin/adminBoardNotice.mdo";	
	}

//	
//	//<!-- *******BeakRyun_20200308 -->
//	//-----------Member_Notice_Main_GET		//공지사항 리스트 보기
//	@RequestMapping(value="/notice.mdo", method=RequestMethod.GET)
//	public String noticeMain(Model model, HttpSession session) {
//		System.out.println("MemberNotice_Main GET Call");
//	
//		List<AdminBoardNoticeVO> adminBoardNoticeList = adminBoardNoticeService.selectListAdminBoardNotice();
//		if(adminBoardNoticeList.size() != 0) {
//			//System.out.println("MemberNotice_Main (size != 0) Call");
//			model.addAttribute("adminBoardNoticeList", adminBoardNoticeList);
//		}
//
//		//장바구니
//		MemberVO member = (MemberVO) session.getAttribute("member");
//		if(member != null) {
//			List<CartVO> cartList = purchaseService.selectMyCart(member.getId());
//			if(cartList != null) {
//				model.addAttribute("cartList",cartList);
//				if(cartList.size() != 0) {
//					model.addAttribute("count",cartList.size());
//				}
//			}
//		}
//		return "board/noticeBoard.part2";
//	}
//
//	//<!-- *******BeakRyun_20200308 -->
//	//-----------Member_Notice_Detail_GET	//공지사항 자세히 보기
//	@RequestMapping(value = "/notice_Detail.mdo", method= RequestMethod.GET)	
//	public String boardNotice_Detail(@RequestParam String num, Model model) {
//		System.out.println("MemberNotice_Detail GET Call");
//		
//		//System.out.println("DetailNotice_Num GET: " + num);
//		AdminBoardNoticeVO board = adminBoardNoticeService.adminBoardNotice_Detail(num);
//		
//		model.addAttribute("board_notice",board);	
//		
//		return "board/notice_Detail.part2";
//	}
//	
	

	//	//<!-- *******BeakRyun_20200306 -->
	//	//-----------AdminBoardNotice_Delete_POST	
	//	@RequestMapping(value = "/adminBoard_Notice_Delete.mdo", method=RequestMethod.POST)
	//	public String adminBoardNotice_Delete(AdminBoardNoticeVO abnVO) {
	//		System.out.println("adminBoardNotice_Delete POST  Call");
	//		
	//		return "admin/adminBoard_Notice_Detail.page2";
	//	}



	@RequestMapping(value = "/purchase.mdo", method= RequestMethod.POST)
	public String purchasefind(@RequestParam String category, @RequestParam String findText,
			PurchaseVO purchase, findVO find,HttpSession session , Model model) {
		if(category.equals("상품번호") || category == "상품번호") {
			find.setCategory("product_num");
		}else {
			find.setCategory("member_id");
		}

		find.setFindText(findText);
		System.out.println("검색어====="+find);

		List<PurchaseVO> purchaseList = purchaseService.purchaseFindList(find);
		System.out.println(purchaseList);

		model.addAttribute("purchaseList",purchaseList);
		return "admin/adminPurchase.page2";
	}



}
