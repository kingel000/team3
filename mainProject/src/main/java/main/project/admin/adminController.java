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
import main.project.web.product.service.IProductService;
import main.project.web.product.vo.ProductVO;
<<<<<<< HEAD
=======
import main.project.web.product.vo.findVO;
import main.project.web.question.vo.QuestionVO;
>>>>>>> branch 'master' of https://github.com/kingel000/team3


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
<<<<<<< HEAD
      System.out.println("ADMIN MAIN MDO »£√‚");
=======
      System.out.println("ADMIN MAIN MDO ÔøΩÏÉáÁï∞ÔøΩ");
>>>>>>> branch 'master' of https://github.com/kingel000/team3
      return "admin/adminMain";
   }
   
<<<<<<< HEAD
   //-----------∑Œ±◊¿Œ ∞À¡ı
=======
   //-----------Êø°ÏíìÎ†áÔøΩÏî§ ÂØÉÔøΩÔßùÔøΩ
>>>>>>> branch 'master' of https://github.com/kingel000/team3
   @RequestMapping(value = "/adminDetail.mdo" , method = RequestMethod.POST )
   public String adminDetail(MemberVO member,HttpSession session, Model model) {
<<<<<<< HEAD
      System.out.println("ADMIN DETAIL MDO POST »£√‚");
=======
      System.out.println("ADMIN DETAIL MDO POST ÔøΩÏÉáÁï∞ÔøΩ");
>>>>>>> branch 'master' of https://github.com/kingel000/team3
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
<<<<<<< HEAD
               String msg = "∞¸∏Æ¿⁄ æ∆¿Ãµ∞° ¿‘¥œ¥Ÿ. ¿ß¿« ∏µ≈©∏¶ ¥≠∑Ø ∏ﬁ¿Œ∆‰¿Ã¡ˆ∑Œ ¿Ãµø«œººø‰";
=======
               String msg = "ÊÑøÔøΩÁî±—äÏòÑ ÔøΩÎ∏òÔøΩÏî†ÔøΩÎµíÂ™õÔøΩ ÔøΩÏóØÔøΩÎï≤ÔøΩÎñé. ÔøΩÏêûÔøΩÏìΩ ÔßçÍ≥πÍ≤ïÁëúÔøΩ ÔøΩÎãÉÔøΩÏú≠ ÔßéÎ∂øÏî§ÔøΩÎüπÔøΩÏî†ÔßûÔøΩÊø°ÔøΩ ÔøΩÏî†ÔøΩÎ£ûÔøΩÎ∏ØÔøΩÍΩ≠ÔøΩÏäÇ";
>>>>>>> branch 'master' of https://github.com/kingel000/team3
               model.addAttribute("msg", msg);
            }
         }else {
<<<<<<< HEAD
            String msg = "∫Òπ–π¯»£ ø¿∑˘¿‘¥œ¥Ÿ.";
=======
            String msg = "ÈçÆÍæ®ÔøΩË∏∞ÎçäÏÉá ÔøΩÏÇ§ÁëúÏÑèÏóØÔøΩÎï≤ÔøΩÎñé.";
>>>>>>> branch 'master' of https://github.com/kingel000/team3
            model.addAttribute("msg", msg);
         }
      }else {
<<<<<<< HEAD
         String msg = "¡∏¿Á«œ¡ˆ æ ¥¬ æ∆¿Ãµ ¿‘¥œ¥Ÿ.";
=======
         String msg = "Ë≠∞ÎåÅÏò±ÔøΩÎ∏ØÔßûÔøΩ ÔøΩÎ∏°ÔøΩÎíó ÔøΩÎ∏òÔøΩÏî†ÔøΩÎµí ÔøΩÏóØÔøΩÎï≤ÔøΩÎñé.";
>>>>>>> branch 'master' of https://github.com/kingel000/team3
         model.addAttribute("msg", msg);
      }

      
      return "admin/adminMain";
   }
   
   
<<<<<<< HEAD
   //-----------∏‚πˆ∞¸∏Æ
=======
   //-----------Ôßé„ÖªÏæ≠ÊÑøÔøΩÁî±ÔøΩ
>>>>>>> branch 'master' of https://github.com/kingel000/team3
   @RequestMapping(value="/memberManager.mdo",method = RequestMethod.GET)
   public String memberManager(HttpSession session,Model model) {
<<<<<<< HEAD
      System.out.println("memberManager mdo GET »£√‚ ");
=======
      System.out.println("memberManager mdo GET ÔøΩÏÉáÁï∞ÔøΩ ");
>>>>>>> branch 'master' of https://github.com/kingel000/team3
      List<MemberVO> adminmemberList = memberService.selectAllMember();
      model.addAttribute("adminmemberList",adminmemberList);
      return "admin/adminMember.page2";
   }
   
   @RequestMapping(value = "/adminMemberDelete.mdo", method= RequestMethod.GET)
   public String adminMemberDelete(@RequestParam String id,MemberVO member, HttpSession session , Model model) {
<<<<<<< HEAD
      System.out.println("adminMemeberDelte.mdo GET »£√‚");
      System.out.println("≥—æÓø¬ æ∆¿Ãµ : " + id);
=======
      System.out.println("adminMemeberDelte.mdo GET ÔøΩÏÉáÁï∞ÔøΩ");
      System.out.println("ÔøΩÍΩÜÔøΩÎº±ÔøΩÏÇ© ÔøΩÎ∏òÔøΩÏî†ÔøΩÎµí : " + id);
>>>>>>> branch 'master' of https://github.com/kingel000/team3
      member.setId(id);
      System.out.println(member);
      memberService.admindeleteMember(member);
      return "redirect:/admin/memberManager.mdo";
   }
   
   @RequestMapping(value = "/adminmemberEdit.mdo", method= RequestMethod.GET)
   public String adminmemberEdit(@RequestParam String id,MemberVO member, HttpSession session , Model model) {
      
      MemberVO memberVO = (MemberVO)memberService.selectMember(member);
      ExpertVO expertVO = (ExpertVO)expertService.selectExpert(id);
<<<<<<< HEAD
      System.out.println("ºˆ¡§«œ∞Ì¿⁄ «œ¥¬ ∆«∏≈¿⁄ ¡§∫∏:" + expertVO);
      System.out.println("ºˆ¡§«œ∞Ì¿⁄ «œ¥¬ ∞Ë¡§ ¡§∫∏ "  + memberVO);
=======
      System.out.println("ÔøΩÎãîÔøΩÏ†ôÔøΩÎ∏ØÊÄ®Ï¢éÏòÑ ÔøΩÎ∏ØÔøΩÎíó ÔøΩÎôãÔßç„ÖºÏòÑ ÔøΩÏ†ôËπÇÔøΩ:" + expertVO);
      System.out.println("ÔøΩÎãîÔøΩÏ†ôÔøΩÎ∏ØÊÄ®Ï¢éÏòÑ ÔøΩÎ∏ØÔøΩÎíó ÊÄ®Íæ©Ï†ô ÔøΩÏ†ôËπÇÔøΩ "  + memberVO);
>>>>>>> branch 'master' of https://github.com/kingel000/team3
      model.addAttribute("expert",expertVO);
      model.addAttribute("member",memberVO);
      return "admin/adminMemberDetail.page2";
   }
   @RequestMapping(value = "/adminmemberEdit.mdo", method= RequestMethod.POST)
   public String adminmemberEdit(ExpertVO expert,MemberVO member, Model model , HttpSession session) {
<<<<<<< HEAD
      System.out.println("ºˆ¡§µ» ∏‚πˆ ¡§∫∏ : " + member);
      System.out.println("ºˆ¡§µ» ∆«∏≈¿⁄ ¡§∫∏ : " + expert);
=======
      System.out.println("ÔøΩÎãîÔøΩÏ†ôÔøΩÎßÇ Ôßé„ÖªÏæ≠ ÔøΩÏ†ôËπÇÔøΩ : " + member);
      System.out.println("ÔøΩÎãîÔøΩÏ†ôÔøΩÎßÇ ÔøΩÎôãÔßç„ÖºÏòÑ ÔøΩÏ†ôËπÇÔøΩ : " + expert);
>>>>>>> branch 'master' of https://github.com/kingel000/team3
      if(member.getRank() == null || member.getRank() == "") {
<<<<<<< HEAD
         System.out.println("if πÆ µÈæÓø‘¿Ω");
=======
         System.out.println("if ËáæÔøΩ ÔøΩÎ±æÔøΩÎº±ÔøΩÏÜïÔøΩÏì¨");
>>>>>>> branch 'master' of https://github.com/kingel000/team3
         String rank = memberService.selectMember(member).getRank();
         System.out.println(rank);
         
         member.setRank(rank);
         
      }
      if(member.getPwd() == null || member.getPwd() == "") {
<<<<<<< HEAD
         System.out.println("pwd if πÆ µÈæÓø»");
=======
         System.out.println("pwd if ËáæÔøΩ ÔøΩÎ±æÔøΩÎº±ÔøΩÏÉÇ");
>>>>>>> branch 'master' of https://github.com/kingel000/team3
         String pwd = memberService.selectMember(member).getPwd();
         System.out.println(pwd);
         
         member.setPwd(pwd);
      }
      System.out.println(member);
      if( member.getRank() == "N" || member.getRank().equals("N")) {
    	  System.out.println("∫Ø∞Ê«— ∑©≈©∞°  N ¿” ");
    	 expertService.deleteExpert(member.getId());
      }
      
      memberService.updateMember(member);
      expertService.updateExpert(expert);
      return "redirect:/admin/memberManager.mdo";
   }
   
   
   
   @RequestMapping(value = "/memberfind.mdo", method= RequestMethod.POST)
   public String memberfind(@RequestParam String category , @RequestParam String value , MemberFindVO find , MemberVO member) {
      
      find.setCategory(category);
      find.setValue(value);
<<<<<<< HEAD
      System.out.println("º±≈√«— ƒ´≈◊∞Ì∏Æ π◊ ∞™ " +  find );
=======
      System.out.println("ÔøΩÍΩëÔøΩÍπÆÔøΩÎ∏≥ ÁßªÎåÑÎÄíÊÄ®Ï¢ä‚îÅ Ë´õÔøΩ Â™õÔøΩ " +  find );
>>>>>>> branch 'master' of https://github.com/kingel000/team3
      
      return "redirect:/admin/memberManager.mdo";
   }
   
   
<<<<<<< HEAD
   

   
   
   //-----------ªÛ«∞∞¸∏Æ
   @RequestMapping(value = "/adminProduct.mdo", method= RequestMethod.GET )
   public String ProductManager( HttpSession session , Model model) {
      List<ProductVO> adminproductList = productService.selectA11ListProduct2();
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
      System.out.println("º±≈√«— ªÛ«∞ π¯»£ : " + num);
      product = productService.selectProduct(num);
      model.addAttribute("product", product);
      
      MemberVO nick_name = new MemberVO();
      nick_name = productService.select_NickName(product.getExpert_id());
      model.addAttribute("nick_name",nick_name);
      
      System.out.println(nick_name);
      System.out.println(product);
      
      return "admin/adminDetailProduct.page2";
   }
   
   //-----------»®∆‰¿Ã¡ˆ ∞¸∏Æ
=======
   //-----------ÔøΩÏÜÉÔøΩÎüπÔøΩÏî†ÔßûÔøΩ ÊÑøÔøΩÁî±ÔøΩ
>>>>>>> branch 'master' of https://github.com/kingel000/team3
   @RequestMapping(value = "/adminHomePage.mdo", method= RequestMethod.GET)
   public String adminHomePageManager() {
      
      return "admin/adminHomePage.page2";
   }
   

<<<<<<< HEAD
=======
	 //<!-- *******20200229 -->
	//-----------Í≤åÏãúÌåê(Í≥µÏßÄÏÇ¨Ìï≠) Í¥ÄÎ¶¨
	@RequestMapping(value = "/adminBoardNotice.mdo", method= RequestMethod.GET)	//ÏûÑÏùòÏùòÏ£ºÏÜåÍ∞í
	public String adminBoardNotice() {
		System.out.println("GET adminBoardNotice Ìò∏Ï∂ú");
		return "admin/adminBoard_Notice.page2";								//jsp ÏÑ§Ï†ï.
	}
	
	 //<!-- *******20200229 -->
	//-----------Í≤åÏãúÌåê(Í≥µÏßÄÏÇ¨Ìï≠) Í∏ÄÎì±Î°ù_GET
	@RequestMapping(value = "/adminBoard_Notice_Update.mdo", method= RequestMethod.GET)	
	public String adminBoardNotice_Update() {
		System.out.println("GET adminBoardNotice_Update Ìò∏Ï∂ú");
		return "admin/adminBoard_Notice_Update.page2";								
	}
	
	 //<!-- *******20200229 -->
		//-----------Í≤åÏãúÌåê(Í≥µÏßÄÏÇ¨Ìï≠) Í∏ÄÎì±Î°ù_POST
	@RequestMapping(value = "/adminBoard_Notice_Update.mdo", method= RequestMethod.POST)	
	public String adminBoardNotice_Update(NoticeVO notice) {
		System.out.println("GET adminBoardNotice_Update POST Ìò∏Ï∂ú");
		System.out.println(notice);
		return "admin/adminBoard_Notice.page2";								
	}

>>>>>>> branch 'master' of https://github.com/kingel000/team3

	
	
	//-----------ÏÉÅÌíàÍ¥ÄÎ¶¨
	
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
		System.out.println("ÏÑ†ÌÉùÌïú ÏÉÅÌíà Î≤àÌò∏ : " + num);
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
		if(category.equals("Ïπ¥ÌÖåÍ≥†Î¶¨") || category == "Ïπ¥ÌÖåÍ≥†Î¶¨") {
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
