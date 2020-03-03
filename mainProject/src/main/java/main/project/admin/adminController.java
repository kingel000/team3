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

import main.project.web.member.service.IExpertService;
import main.project.web.member.service.IMemberService;

import main.project.web.member.service.MemberService;

import main.project.web.member.vo.ExpertVO;
import main.project.web.member.vo.MemberFindVO;
import main.project.web.member.vo.MemberVO;
import main.project.web.notice.vo.NoticeVO;
import main.project.web.product.service.IProductService;
import main.project.web.product.vo.ProductVO;
import main.project.web.product.vo.findVO;
import main.project.web.question.vo.QuestionVO;


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


   
   @RequestMapping({"/","/admin.mdo"})
   public String home(Locale locale, Model model) {
      System.out.println("ADMIN MAIN MDO �샇異�");
      return "admin/adminMain";
   }
   
   //-----------濡쒓렇�씤 寃�利�
   @RequestMapping(value = "/adminDetail.mdo" , method = RequestMethod.POST )
   public String adminDetail(MemberVO member,HttpSession session, Model model) {
      System.out.println("ADMIN DETAIL MDO POST �샇異�");
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
               String msg = "愿�由ъ옄 �븘�씠�뵒媛� �엯�땲�떎. �쐞�쓽 留곹겕瑜� �닃�윭 硫붿씤�럹�씠吏�濡� �씠�룞�븯�꽭�슂";
               model.addAttribute("msg", msg);
            }
         }else {
            String msg = "鍮꾨�踰덊샇 �삤瑜섏엯�땲�떎.";
            model.addAttribute("msg", msg);
         }
      }else {
         String msg = "議댁옱�븯吏� �븡�뒗 �븘�씠�뵒 �엯�땲�떎.";
         model.addAttribute("msg", msg);
      }

      
      return "admin/adminMain";
   }
   
   
   //-----------硫ㅻ쾭愿�由�
   @RequestMapping(value="/memberManager.mdo",method = RequestMethod.GET)
   public String memberManager(HttpSession session,Model model) {
      System.out.println("memberManager mdo GET �샇異� ");
      List<MemberVO> adminmemberList = memberService.selectAllMember();
      model.addAttribute("adminmemberList",adminmemberList);
      return "admin/adminMember.page2";
   }
   
   @RequestMapping(value = "/adminMemberDelete.mdo", method= RequestMethod.GET)
   public String adminMemberDelete(@RequestParam String id,MemberVO member, HttpSession session , Model model) {
      System.out.println("adminMemeberDelte.mdo GET �샇異�");
      System.out.println("�꽆�뼱�삩 �븘�씠�뵒 : " + id);
      member.setId(id);
      System.out.println(member);
      memberService.admindeleteMember(member);
      return "redirect:/admin/memberManager.mdo";
   }
   
   @RequestMapping(value = "/adminmemberEdit.mdo", method= RequestMethod.GET)
   public String adminmemberEdit(@RequestParam String id,MemberVO member, HttpSession session , Model model) {
      
      MemberVO memberVO = (MemberVO)memberService.selectMember(member);
      ExpertVO expertVO = (ExpertVO)expertService.selectExpert(id);
      System.out.println("�닔�젙�븯怨좎옄 �븯�뒗 �뙋留ㅼ옄 �젙蹂�:" + expertVO);
      System.out.println("�닔�젙�븯怨좎옄 �븯�뒗 怨꾩젙 �젙蹂� "  + memberVO);
      model.addAttribute("expert",expertVO);
      model.addAttribute("member",memberVO);
      return "admin/adminMemberDetail.page2";
   }
   @RequestMapping(value = "/adminmemberEdit.mdo", method= RequestMethod.POST)
   public String adminmemberEdit(ExpertVO expert,MemberVO member, Model model , HttpSession session) {
      System.out.println("�닔�젙�맂 硫ㅻ쾭 �젙蹂� : " + member);
      System.out.println("�닔�젙�맂 �뙋留ㅼ옄 �젙蹂� : " + expert);
      if(member.getRank() == null || member.getRank() == "") {
         System.out.println("if 臾� �뱾�뼱�솕�쓬");
         String rank = memberService.selectMember(member).getRank();
         System.out.println(rank);
         
         member.setRank(rank);
         
      }
      if(member.getPwd() == null || member.getPwd() == "") {
         System.out.println("pwd if 臾� �뱾�뼱�샂");
         String pwd = memberService.selectMember(member).getPwd();
         System.out.println(pwd);
         
         member.setPwd(pwd);
      }
      System.out.println(member);
      memberService.updateMember(member);
      expertService.updateExpert(expert);
      return "redirect:/admin/memberManager.mdo";
   }
   
   
   
   @RequestMapping(value = "/memberfind.mdo", method= RequestMethod.POST)
   public String memberfind(@RequestParam String category , @RequestParam String value , MemberFindVO find , MemberVO member) {
      
      find.setCategory(category);
      find.setValue(value);
      System.out.println("�꽑�깮�븳 移댄뀒怨좊━ 諛� 媛� " +  find );
      
      return "redirect:/admin/memberManager.mdo";
   }
   
   
   //-----------�솃�럹�씠吏� 愿�由�
   @RequestMapping(value = "/adminHomePage.mdo", method= RequestMethod.GET)
   public String adminHomePageManager() {
      
      return "admin/adminHomePage.page2";
   }
   

	 //<!-- *******20200229 -->
	//-----------게시판(공지사항) 관리
	@RequestMapping(value = "/adminBoardNotice.mdo", method= RequestMethod.GET)	//임의의주소값
	public String adminBoardNotice() {
		System.out.println("GET adminBoardNotice 호출");
		return "admin/adminBoard_Notice.page2";								//jsp 설정.
	}
	
	 //<!-- *******20200229 -->
	//-----------게시판(공지사항) 글등록_GET
	@RequestMapping(value = "/adminBoard_Notice_Update.mdo", method= RequestMethod.GET)	
	public String adminBoardNotice_Update() {
		System.out.println("GET adminBoardNotice_Update 호출");
		return "admin/adminBoard_Notice_Update.page2";								
	}
	
	 //<!-- *******20200229 -->
		//-----------게시판(공지사항) 글등록_POST
	@RequestMapping(value = "/adminBoard_Notice_Update.mdo", method= RequestMethod.POST)	
	public String adminBoardNotice_Update(NoticeVO notice) {
		System.out.println("GET adminBoardNotice_Update POST 호출");
		System.out.println(notice);
		return "admin/adminBoard_Notice.page2";								
	}


	
	
	//-----------상품관리
	
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

}
