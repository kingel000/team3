package main.project.admin;

import java.util.ArrayList;
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
<<<<<<< HEAD
=======



>>>>>>> branch 'master' of https://github.com/kingel000/team3
import main.project.web.member.vo.ExpertVO;

import main.project.web.member.vo.MemberVO;
import main.project.web.product.service.IProductService;
import main.project.web.product.vo.ProductVO;
<<<<<<< HEAD
=======

import main.project.web.purchase.Service.IPurchaseService;

import main.project.web.purchase.vo.PurchaseVO;

import main.project.web.product.vo.findVO;

>>>>>>> branch 'master' of https://github.com/kingel000/team3

@Controller("adminController")
@RequestMapping(value="/admin")
public class adminController {
<<<<<<< HEAD
	//* package  -> "main.project.admin
	//localhost:8080/web/admin/*.mdo

	@Autowired
	private IProductService productService;
	@Autowired
	private IMemberService memberService;

	@Autowired
	private IExpertService expertService;
=======
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
>>>>>>> branch 'master' of https://github.com/kingel000/team3

	@Autowired
	private adminIBoardNoticeService adminBoardNoticeService;


   
   @RequestMapping({"/","/admin.mdo"})
   public String home(Locale locale, Model model) {
      System.out.println("ADMIN MAIN MDO í˜¸ì¶œ");
      return "admin/adminMain";
   }
   
   //-----------ë¡œê·¸ì¸ ê²€ì¦
   @RequestMapping(value = "/adminDetail.mdo" , method = RequestMethod.POST )
   public String adminDetail(MemberVO member,HttpSession session, Model model) {
      System.out.println("ADMIN DETAIL MDO POST í˜¸ì¶œ");
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
               String msg = "ê´€ë¦¬ì ì•„ì´ë””ê°€ ì…ë‹ˆë‹¤. ìœ„ì˜ ë§í¬ë¥¼ ëˆŒëŸ¬ ë©”ì¸í˜ì´ì§€ë¡œ ì´ë™í•˜ì„¸ìš”";
               model.addAttribute("msg", msg);
            }
         }else {
            String msg = "ë¹„ë°€ë²ˆí˜¸ ì˜¤ë¥˜ì…ë‹ˆë‹¤.";
            model.addAttribute("msg", msg);
         }
      }else {
         String msg = "ì¡´ì¬í•˜ì§€ ì•ŠëŠ” ì•„ì´ë”” ì…ë‹ˆë‹¤.";
         model.addAttribute("msg", msg);
      }

      
      return "admin/adminMain";
   }
   
   
   //-----------ë©¤ë²„ê´€ë¦¬
   @RequestMapping(value="/memberManager.mdo",method = RequestMethod.GET)
   public String memberManager(HttpSession session,Model model) {
      System.out.println("memberManager mdo GET í˜¸ì¶œ ");
      List<MemberVO> adminmemberList = memberService.selectAllMember();
      model.addAttribute("adminmemberList",adminmemberList);
      return "admin/adminMember.page2";
   }
   
   @RequestMapping(value = "/adminMemberDelete.mdo", method= RequestMethod.GET)
   public String adminMemberDelete(@RequestParam String id,MemberVO member, HttpSession session , Model model) {
      System.out.println("adminMemeberDelte.mdo GET í˜¸ì¶œ");
      System.out.println("ë„˜ì–´ì˜¨ ì•„ì´ë”” : " + id);
      member.setId(id);
      System.out.println(member);
      memberService.admindeleteMember(member);
      return "redirect:/admin/memberManager.mdo";
   }
   
   @RequestMapping(value = "/adminmemberEdit.mdo", method= RequestMethod.GET)
   public String adminmemberEdit(@RequestParam String id,MemberVO member, HttpSession session , Model model) {
      
      MemberVO memberVO = (MemberVO)memberService.selectMember(member);
      ExpertVO expertVO = (ExpertVO)expertService.selectExpert(id);
      System.out.println("ìˆ˜ì •í•˜ê³ ì í•˜ëŠ” íŒë§¤ì ì •ë³´:" + expertVO);
      System.out.println("ìˆ˜ì •í•˜ê³ ì í•˜ëŠ” ê³„ì • ì •ë³´ "  + memberVO);
      model.addAttribute("expert",expertVO);
      model.addAttribute("member",memberVO);
      return "admin/adminMemberDetail.page2";
   }
   @RequestMapping(value = "/adminmemberEdit.mdo", method= RequestMethod.POST)
   public String adminmemberEdit(ExpertVO expert,MemberVO member, Model model , HttpSession session) {
      System.out.println("ìˆ˜ì •ëœ ë©¤ë²„ ì •ë³´ : " + member);
      System.out.println("ìˆ˜ì •ëœ íŒë§¤ì ì •ë³´ : " + expert);
      if(member.getRank() == null || member.getRank() == "") {
         System.out.println("if ë¬¸ ë“¤ì–´ì™”ìŒ");
         String rank = memberService.selectMember(member).getRank();
         System.out.println(rank);
         
         member.setRank(rank);
         
      }
      if(member.getPwd() == null || member.getPwd() == "") {
         System.out.println("pwd if ë¬¸ ë“¤ì–´ì˜´");
         String pwd = memberService.selectMember(member).getPwd();
         System.out.println(pwd);
         
         member.setPwd(pwd);
      }
      System.out.println(member);
      memberService.updateMember(member);
      expertService.updateExpert(expert);
      
      if( member.getRank() == "N" || member.getRank().equals("N")) {
          System.out.println("ë³€ê²½í•œ RANK = N ì§„ì…");
         expertService.deleteExpert(member.getId());
       }
      return "redirect:/admin/memberManager.mdo";
   }
   
   
   
   @RequestMapping(value = "/memberfind.mdo", method= RequestMethod.POST)
	public String memberfind(@RequestParam String category, @RequestParam String findText,
						MemberVO member, findVO find,HttpSession session , Model model) {
		if(category.equals("ì´ë©”ì¼") || category == "ì´ë©”ì¼") {
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
   
   
   
   

   
   
   //-----------ìƒí’ˆê´€ë¦¬
   @RequestMapping(value = "/adminProduct.mdo", method= RequestMethod.GET )
   public String ProductManager( HttpSession session , Model model) {
      List<ProductVO> adminproductList = productService.selectAllListProduct();
      model.addAttribute("adminproductList", adminproductList);
      
      return "admin/adminProduct.page2";
   }
   
   @RequestMapping(value = "/adminProductDelete.mdo", method= RequestMethod.GET)
   public String adminProductDelete(@RequestParam String num,ProductVO product, HttpSession session , Model model) {
      product.setProduct_num(num);
      productService.deleteProduct(product);
      return "redirect:/admin/adminProduct.mdo";
   }
   
   @RequestMapping(value = "/adminDetailProduct.mdo", method= RequestMethod.GET)
   public String adminDetailProduct(@RequestParam String num,ProductVO product, HttpSession session , Model model) {
      System.out.println("ì„ íƒí•œ ìƒí’ˆ ë²ˆí˜¸ : " + num);
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
		if(category.equals("ì¹´í…Œê³ ë¦¬") || category == "ì¹´í…Œê³ ë¦¬") {
			find.setCategory("category");
		}else {
			find.setCategory("expert_id");
		}
		find.setFindText(findText);
		List<ProductVO> adminproductList = productService.selectFindList(find);

		model.addAttribute("adminproductList",adminproductList);
		return "admin/adminProduct.page2";
<<<<<<< HEAD
	}
	//
	@RequestMapping(value = "/adminProductDelete.mdo", method= RequestMethod.GET)
	public String adminProductDelete(@RequestParam String num,ProductVO product, HttpSession session , Model model) {
		product.setProduct_num(num);
		productService.deleteProduct(product);
		return "redirect:/admin/adminProduct.mdo";
	}
	
	@RequestMapping(value = "/adminDetailProduct.mdo", method= RequestMethod.GET)
	public String adminDetailProduct(@RequestParam String num,ProductVO product, HttpSession session , Model model) {
		System.out.println("¼±ÅÃÇÑ »óÇ° ¹øÈ£ : " + num);
		product = productService.selectProduct(num);
		model.addAttribute("product", product);
		
		MemberVO nick_name = new MemberVO();
		nick_name = productService.select_NickName(product.getExpert_id());
		model.addAttribute("nick_name",nick_name);
		
		System.out.println(nick_name);
		System.out.println(product);
		
		return "admin/adminDetailProduct.page2";
	}
	
	//-----------È¨ÆäÀÌÁö °ü¸®
	@RequestMapping(value = "/adminHomePage.mdo", method= RequestMethod.GET)
	public String adminHomePageManager() {
		
		return "admin/adminHomePage.page2";
	}
	
=======
   }
   
   //-----------í™ˆí˜ì´ì§€ ê´€ë¦¬
   @RequestMapping(value = "/adminHomePage.mdo", method= RequestMethod.GET)
   public String adminHomePageManager() {
      
      return "admin/adminHomePage.page2";
   }
   
   //---------- ê±°ë˜ ë‚´ì—­
   
   @RequestMapping(value = "/adminpurchase.mdo", method= RequestMethod.GET)
   public String adminpurchase(PurchaseVO purchase , ProductVO product, Model model , HttpSession session) {
	   System.out.println("admin Purchase GET í˜¸ì¶œ ");
	   ArrayList<String>ExpertidList = new ArrayList<>();
	   ArrayList<String>ProducttitleList = new ArrayList<>();
	   //ArrayList<ProductVO>ExpertidList = new ArrayList<>();
	  
	   try {
	   List<PurchaseVO> purchaseList = purchaseService.selectListPurchase();
	   System.out.println("ê±°ë˜ë‚´ì—­ ì‚¬ì´ì¦ˆ : " + purchaseList.size());
	   for(PurchaseVO purchaseVO : purchaseList) {
			System.out.println("DB ì €ì¥ëœ ê±°ë˜ ë‚´ì—­ ë¦¬ìŠ¤íŠ¸ !!! : " + purchaseVO);
			String Expert_id =  productService.selectProduct(purchaseVO.getProduct_num()).getExpert_id();
			String Product_title = productService.selectProduct(purchaseVO.getProduct_num()).getProduct_title();
			System.out.println("ë¦¬ìŠ¤íŠ¸ì— ë“¤ì–´ê°€ëŠ” íŒë§¤ì ì•„ì´ë”” : " + Expert_id);
			ExpertidList.add(Expert_id);
			ProducttitleList.add(Product_title);
>>>>>>> branch 'master' of https://github.com/kingel000/team3

<<<<<<< HEAD
	 //<!-- *******20200229 -->
	//-----------°Ô½ÃÆÇ(°øÁö»çÇ×) ¸ñ·Ï
	@RequestMapping(value = "/adminBoardNotice.mdo", method= RequestMethod.GET)	//ÀÓÀÇÀÇÁÖ¼Ò°ª
	public String adminBoardNotice(HttpSession session, Model model) {
		System.out.println("adminBoardNotice GET ¸ñ·Ï È£Ãâ");

		List<AdminBoardNoticeVO> adminBoardNoticeList = adminBoardNoticeService.selectListAdminBoardNotice();
		if(adminBoardNoticeList != null) {
			for(AdminBoardNoticeVO adminBoardNotice : adminBoardNoticeList) {
				System.out.println(adminBoardNotice);
			}
			model.addAttribute("adminBoardNoticeList", adminBoardNoticeList);
		}
		
		return "admin/adminBoard_Notice.page2";								//jsp ¼³Á¤.
	}
	
	
	 //<!-- *******20200303 -->
	//-----------°Ô½ÃÆÇ(°øÁö»çÇ×) ±Ûµî·Ï_GET
	@RequestMapping(value = "/adminBoard_Notice_Insert.mdo", method= RequestMethod.GET)	
	public String adminBoardNotice_Insert() {
		System.out.println("adminBoardNotice_Insert GETÈ£Ãâ");

		return "admin/adminBoard_Notice_Insert.page2";								
	}
	 //<!-- *******20200303 -->
	//-----------°Ô½ÃÆÇ(°øÁö»çÇ×) ±Ûµî·Ï_Post
	@RequestMapping(value = "/adminBoard_Notice_Insert.mdo", method= RequestMethod.POST)	
	public String adminBoardNotice_Insert(AdminBoardNoticeVO abnVO, HttpSession session, Model model) {
		System.out.println("adminBoardNotice_Insert POST È£Ãâ");

//		MemberVO member = (MemberVO) session.getAttribute("member");
//		System.out.println(member.getId());
//		
//		String sessionId = member.getId();
//		abnVO.setBoard_notice_title(sessionId);
//		System.out.println(abnVO);
		
		
		
		//³»¿ëÀÌ ¾÷¼º¾ßÇÑ´Ù.
		System.out.println("ÀÔ·ÂµÈ abnVO num : "+abnVO.getBoard_notice_num());
		System.out.println("ÀÔ·ÂµÈ abnVO title : "+abnVO.getBoard_notice_title()); 
		System.out.println("ÀÔ·ÂµÈ abnVO info : "+abnVO.getBoard_notice_info());
		System.out.println("ÀÔ·ÂµÈ abnVO date : "+abnVO.getBoard_notice_date());
		//ÀúÀåµÉ ¹øÈ£.
		//ÀúÀåµÉ ³¯Â¥.
		
		adminBoardNoticeService.insertBoardNotice(abnVO);
		
//		List<AdminBoardNoticeVO> adminBoardNoticeList = adminBoardNoticeService.selectListAdminBoardNotice();		
//		model.addAttribute("adminBoardNoticeList", adminBoardNoticeList);
		
		return "admin/adminBoard_Notice.page2";								
	}
	
	/*
	 
	 
	 //<!-- *******20200229 -->
	//-----------°Ô½ÃÆÇ(°øÁö»çÇ×) ±Û¼öÁ¤_GET
	@RequestMapping(value = "/adminBoard_Notice_Update.mdo", method= RequestMethod.GET)	
	public String adminBoardNotice_Update() {
		System.out.println("GET adminBoardNotice_Update È£Ãâ");
		return "admin/adminBoard_Notice_Update.page2";								
	}
	
	 //<!-- *******20200229 -->
		//-----------°Ô½ÃÆÇ(°øÁö»çÇ×) ±Û¼öÁ¤_POST
	@RequestMapping(value = "/adminBoard_Notice_Update.mdo", method= RequestMethod.POST)	
	public String adminBoardNotice_Update(NoticeVO notice) {
		System.out.println("GET adminBoardNotice_Update POST È£Ãâ");
		System.out.println(notice);
		return "admin/adminBoard_Notice.page2";								
	}
*/	 
=======
			
		}
	   
>>>>>>> branch 'master' of https://github.com/kingel000/team3

<<<<<<< HEAD
}
=======
	   model.addAttribute("purchaseList",purchaseList);
	   model.addAttribute("expertidList",ExpertidList);
	   model.addAttribute("producttitleList",ProducttitleList);
	   }catch(Exception e) {
		   e.printStackTrace();
	   }

      return "admin/adminPurchase.page2";
   
   }
   
   @RequestMapping(value = "/purchase.mdo", method= RequestMethod.POST)
  	public String purchasefind(@RequestParam String category, @RequestParam String findText,
  						PurchaseVO purchase, findVO find,HttpSession session , Model model) {
  		if(category.equals("ìƒí’ˆë²ˆí˜¸") || category == "ìƒí’ˆë²ˆí˜¸") {
  			find.setCategory("product_num");
  		}else {
			find.setCategory("member_id");
		}
  		
  		find.setFindText(findText);
  		System.out.println("ê²€ìƒ‰ì–´====="+find);
  		
  		List<PurchaseVO> purchaseList = purchaseService.purchaseFindList(find);
  		System.out.println(purchaseList);
  		
  		model.addAttribute("purchaseList",purchaseList);
  		return "admin/adminPurchase.page2";
   }

   
   
}
>>>>>>> branch 'master' of https://github.com/kingel000/team3
