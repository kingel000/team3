package main.project.admin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.mail.Multipart;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import main.project.admin.board.service.adminIBoardNoticeService;
import main.project.admin.board.vo.AdminBoardNoticeVO;
import main.project.web.banner.service.IBannerService;
import main.project.web.banner.vo.BannerVO;
import main.project.web.member.service.IExpertService;
import main.project.web.member.service.IMemberService;
import main.project.web.member.vo.ExpertVO;
import main.project.web.member.vo.MemberVO;
import main.project.web.product.service.IProductService;
import main.project.web.product.vo.ProductVO;
import main.project.web.product.vo.findVO;
import main.project.web.purchase.PaymentCheck;
import main.project.web.purchase.Service.IPurchaseService;
import main.project.web.purchase.vo.PurchaseVO;

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
	private IBannerService bannerService;

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
	public String memberManager(@RequestParam("num") int num, HttpSession session,Model model) throws Exception {
		System.out.println("memberManager mdo GET 호출 ");
		// 게시물 총 갯수
		int count = memberService.totalMember();
		System.out.println(count);
		// 한 페이지에 출력할 게시물 갯수
		int postNum = 5;
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
		List<MemberVO> adminmemberList = memberService.memberPage(displayPost+num1, postNum * num);
		model.addAttribute("adminmemberList",adminmemberList);

		// 시작 및 끝 번호
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);

		// 이전 및 다음 
		model.addAttribute("prev", prev);
		model.addAttribute("next", next);

		// 현재 페이지
		model.addAttribute("select", num);

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
	public String ProductManager(@RequestParam("num") int num, HttpSession session , Model model) throws Exception {
		// 게시물 총 갯수
		int count = productService.totalProduct();
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

		List<ProductVO> adminproductList = productService.productPage(displayPost+num1, (postNum * num));
		model.addAttribute("adminproductList", adminproductList);
		// 시작 및 끝 번호
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);

		// 이전 및 다음 
		model.addAttribute("prev", prev);
		model.addAttribute("next", next);

		// 현재 페이지
		model.addAttribute("select", num);
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

	//---------- 거래 내역
	@RequestMapping(value = "/adminpurchase.mdo", method= RequestMethod.GET)
	public String adminpurchase(@RequestParam("num") int num, Model model , HttpSession session) throws Exception {
		System.out.println("admin Purchase GET 호출 ");
		// 게시물 총 갯수
		int count = purchaseService.countPurchase();
		System.out.println(count);
		// 한 페이지에 출력할 게시물 갯수
		int postNum = 5;
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

		ArrayList<String>ProducttitleList = new ArrayList<>();

		List<PurchaseVO> purchaseList = purchaseService.purchasePage(displayPost+num1, postNum * num);
		System.out.println("거래내역 사이즈 : " + purchaseList.size());

		for(PurchaseVO purchaseVO : purchaseList) {
			System.out.println("DB 저장된 거래 내역 리스트 !!! : " + purchaseVO);
			//String Expert_id =  productService.selectProduct(purchaseVO.getProduct_num()).getExpert_id();
			ProductVO p = productService.selectProduct(purchaseVO.getProduct_num());
			if(p != null) {
				System.out.println(p.getProduct_title());
				ProducttitleList.add(p.getProduct_title());
			}else {
				System.out.println("null!!!");
				String Product_title = "상품이 삭제되었습니다!";
				ProducttitleList.add(Product_title);
			}
			//ExpertidList.add(Expert_id);
		}
		model.addAttribute("purchaseList",purchaseList);
		model.addAttribute("producttileList",ProducttitleList);
		// 시작 및 끝 번호
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);

		// 이전 및 다음 
		model.addAttribute("prev", prev);
		model.addAttribute("next", next);

		// 현재 페이지
		model.addAttribute("select", num);

		return "admin/adminPurchase.page2";
	}

	@RequestMapping(value = "/purchaseCancel.mdo", method= RequestMethod.POST)
	public String purchaseCancel(PurchaseVO purchase) {
		PaymentCheck pay = new PaymentCheck();
		purchase.setPurchase_state("Cancel");
		purchaseService.updatePurchase(purchase);
		pay.cancelPayment(pay.getImportToken(),purchase.getPurchase_num(),"Master Cancel");
		return "redirect:/admin/adminpurchase.mdo";
	}

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

		return "admin/adminBoard_Notice.page2";	//jsp Address
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
   
	//--------홈페이지 관리
    @Resource(name="uploadPath")
    String uploadPath;
    
	@RequestMapping(value = "/homePageManagement.mdo", method = RequestMethod.GET)
	public String homePageManagement( HttpSession session , Model model){
		BannerVO bannerVO = bannerService.selectBanner();
		model.addAttribute("bannerVO", bannerVO);
		
		return "admin/homePageManagement.page2";
	}
	
	@RequestMapping(value = "/homePageManagement1.mdo", method = RequestMethod.POST)
	public String homePageManagement1(@RequestParam("file1")MultipartFile file,BannerVO bannerVO,
										HttpSession session , Model model)throws IOException{
		bannerVO.setBanner1_text1(bannerVO.getBanner1_text1());
		bannerVO.setBanner1_text1(bannerVO.getBanner1_text2());
		bannerVO.setBanner1_text1(bannerVO.getBanner1_text3());
		bannerVO.setBanner1_text1(bannerVO.getBanner1_text4());
		
		System.out.println("파일명: "+ file.getOriginalFilename());
		 
		 
		 //db저장
		 if(file.getOriginalFilename().equals(null) || file.getOriginalFilename().equals("")) {
			 System.out.println("이미지 없음");
			 bannerService.updateBannerText(bannerVO);
		 }else {
			System.out.println("이미지 있음");
			File target = new File(uploadPath+"/home/", file.getOriginalFilename());
	        FileCopyUtils.copy(file.getBytes(), target);
			bannerVO.setBanner1_img("/home/"+file.getOriginalFilename());
			bannerService.updateBanner(bannerVO);
		}

		 
		 return "redirect:/admin//homePageManagement.mdo";
	}
	
	@RequestMapping(value = "/homePageManagement2.mdo", method = RequestMethod.POST)
	public String homePageManagement2(@RequestParam("file1")MultipartFile file,BannerVO bannerVO,
										HttpSession session , Model model)throws IOException{
		bannerVO.setBanner2_text1(bannerVO.getBanner2_text1());
		bannerVO.setBanner2_text2(bannerVO.getBanner2_text2());
		bannerVO.setBanner2_text3(bannerVO.getBanner2_text3());
		bannerVO.setBanner2_text4(bannerVO.getBanner2_text4());
		
		System.out.println("파일명: "+ file.getOriginalFilename());
		
		//db 저장
		if(file.getOriginalFilename().equals(null) || file.getOriginalFilename().equals("")) {
			 System.out.println("이미지 없음");
			 bannerService.updateBannerText2(bannerVO);
		 }else {
			System.out.println("이미지 있음");
			File target = new File(uploadPath+"/home/", file.getOriginalFilename());
	        FileCopyUtils.copy(file.getBytes(), target);
			bannerVO.setBanner2_img("/home/"+file.getOriginalFilename());
			bannerService.updateBanner2(bannerVO);
		}

		return "redirect:/admin//homePageManagement.mdo";
	}

	//--------통계
	@RequestMapping(value = "/chartMain.mdo", method = RequestMethod.GET)
	public String adminChart(HttpSession session , Model model) {
		Integer totalPoint = purchaseService.totalPoint(); //총금액
		Integer totalCountPurchase = purchaseService.totalCountPurchase();
		Integer totalProduct = productService.totalProduct();
		Integer totalMember = memberService.totalMember();

		model.addAttribute("totalPoint", totalPoint);
		model.addAttribute("totalCountPurchase", totalCountPurchase);
		model.addAttribute("totalProduct",totalProduct);
		model.addAttribute("totalMember",totalMember);
		return "chart/chartMain";
	}

	@RequestMapping(value = "/tables1.mdo", method = RequestMethod.GET)
	public String admintables1(HttpSession session , Model model) {
		ArrayList<String> expertIdList = new ArrayList<>();
		ArrayList<String> productTitleList = new ArrayList<>();
		try {
			List<PurchaseVO> T1purchase = purchaseService.selectListPurchase();
			for(PurchaseVO purchaseVO: T1purchase) {
				//			   String productTitle = productService.selectProduct(purchaseVO.getProduct_num()).getProduct_title();
				ProductVO productList = productService.selectProduct(purchaseVO.getProduct_num());
				String productTitle;
				if(productList != null) {
					productTitle = productList.getProduct_title();
				}else {
					productTitle = "삭제된 게시물입니다";
				}
				productTitleList.add(productTitle);
			}
			model.addAttribute("T1purchase", T1purchase); 
			model.addAttribute("productTitleList", productTitleList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "chart/tables1";
	}

	@RequestMapping(value = "/tables2.mdo", method = RequestMethod.GET)
	public String admintables2(HttpSession session , Model model) {
		ArrayList<Integer> Id_totalCountPurchaseList = new ArrayList<>();
		ArrayList<Integer> Id_totalPurchasePriceList = new ArrayList<>();
		ArrayList<Integer> Id_totalCountSalesList = new ArrayList<>();
		ArrayList<Integer> Id_totalSalesPriceList = new ArrayList<>();

		try {
			List<MemberVO> T2member = memberService.selectAllMember();
			for(MemberVO memberVO : T2member) {
				Integer Id_totalCountPurchase = purchaseService.Id_totalCountPurchase(memberVO.getId());
				Integer Id_totalPurchasePrice = purchaseService.Id_totalPurchasePrice(memberVO.getId());
				Integer Id_totalCountSales = purchaseService.Id_PurchaseCount(memberVO.getId());
				Integer Id_totalSalesPrice = purchaseService.Id_totalSalesPrice(memberVO.getId());
				Id_totalCountPurchaseList.add(Id_totalCountPurchase);
				Id_totalPurchasePriceList.add(Id_totalPurchasePrice);
				Id_totalCountSalesList.add(Id_totalCountSales);
				Id_totalSalesPriceList.add(Id_totalSalesPrice);

			}
			model.addAttribute("T2member",T2member);
			model.addAttribute("Id_totalCountPurchaseList",Id_totalCountPurchaseList);
			model.addAttribute("Id_totalPurchasePriceList",Id_totalPurchasePriceList);
			model.addAttribute("Id_totalCountSalesList",Id_totalCountSalesList);
			model.addAttribute("Id_totalSalesPriceList",Id_totalSalesPriceList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "chart/tables2";
	}

	@RequestMapping(value = "/charts1.mdo", method = RequestMethod.GET)
	public String admincharts1(HttpSession session , Model model) {
		//회원통계
		Integer expertMemberCount = expertService.totalMember_expert();
		Integer nomalMemberCount = memberService.totalMember() - expertMemberCount -1;
		model.addAttribute("nomalMemberCount",nomalMemberCount);
		model.addAttribute("expertMemberCount",expertMemberCount);

		//월별 매출통계
		String[] year = {"20/01","20/02","20/03","20/04","20/05","20/06","20/07","20/08","20/09","20/10","20/11","20/12"};
		int[] year_totalSalesList = {1,2,3,4,5,6,7,8,9,10,11,12};
		for(int i=0;i<year.length;i++) {
			year_totalSalesList[i] = purchaseService.date_totalSales(year[i]);
		}
		model.addAttribute("M1",year_totalSalesList[0]);
		model.addAttribute("M2",year_totalSalesList[1]);
		model.addAttribute("M3",year_totalSalesList[2]);
		model.addAttribute("M4",year_totalSalesList[3]);
		model.addAttribute("M5",year_totalSalesList[4]);
		model.addAttribute("M6",year_totalSalesList[5]);
		model.addAttribute("M7",year_totalSalesList[6]);
		model.addAttribute("M8",year_totalSalesList[7]);
		model.addAttribute("M9",year_totalSalesList[8]);
		model.addAttribute("M10",year_totalSalesList[9]);
		model.addAttribute("M11",year_totalSalesList[10]);
		model.addAttribute("M12",year_totalSalesList[11]);

		//카테고리별 판매통계
		List<ProductVO> category_product_num;
		Integer category_totalSales1=0, category_totalSales2=0, category_totalSales3=0, category_totalSales4=0;
		String[] category = {"웹 개발", "모바일앱·웹", "게임", "응용프로그래밍"};
		for(String c : category) {
			if(c == "웹 개발") {
				category_product_num = productService.category_product_num(c);
				for(ProductVO p : category_product_num) {
					category_totalSales1 += purchaseService.productNum_PurchaseCount(p.getProduct_num());
				}
			}else if (c == "모바일앱·웹") {
				category_product_num = productService.category_product_num(c);
				for(ProductVO p : category_product_num) {
					category_totalSales2 += purchaseService.productNum_PurchaseCount(p.getProduct_num());
				}
			}else if (c == "게임") {
				category_product_num = productService.category_product_num(c);
				for(ProductVO p : category_product_num) {
					category_totalSales3 += purchaseService.productNum_PurchaseCount(p.getProduct_num());
				}
			}else if (c == "응용프로그래밍") {
				category_product_num = productService.category_product_num(c);
				for(ProductVO p : category_product_num) {
					category_totalSales4 += purchaseService.productNum_PurchaseCount(p.getProduct_num());
				}
			} 
		}
		model.addAttribute("category_totalSales1", category_totalSales1);
		model.addAttribute("category_totalSales2", category_totalSales2);
		model.addAttribute("category_totalSales3", category_totalSales3);
		model.addAttribute("category_totalSales4", category_totalSales4);
		return "chart/charts1";
	}


}



