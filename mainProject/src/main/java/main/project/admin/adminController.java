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

import main.project.web.member.service.IExpertService;
import main.project.web.member.service.IMemberService;

import main.project.web.member.vo.ExpertVO;

import main.project.web.member.vo.MemberVO;
import main.project.web.product.service.IProductService;
import main.project.web.product.service.ProductService;
import main.project.web.product.vo.ProductVO;

import main.project.web.purchase.Service.IPurchaseService;

import main.project.web.purchase.vo.PurchaseVO;

import main.project.web.product.vo.findVO;

@Controller("adminController")
@RequestMapping(value = "/admin")
public class adminController {
	// * package -> "main.project.admin
	// localhost:8080/web/admin/*.mdo

	@Autowired
	private IProductService productService;
	@Autowired
	private IMemberService memberService;
	@Autowired
	private IExpertService expertService;
	@Autowired
	private IPurchaseService purchaseService;

	@RequestMapping({ "/", "/admin.mdo" })
	public String home(Locale locale, Model model) {
		System.out.println("ADMIN MAIN MDO 호출");
		return "admin/adminMain";
	}

	// -----------로그인 검증
	@RequestMapping(value = "/adminDetail.mdo", method = RequestMethod.POST)
	public String adminDetail(MemberVO member, HttpSession session, Model model) {
		System.out.println("ADMIN DETAIL MDO POST 호출");
		System.out.println(member.getId());
		System.out.println(member.getPwd());
		MemberVO check = memberService.selectMember(member);
		System.out.println(check);

		if (check != null) {
			if (check.getPwd().equals(member.getPwd())) {
				if (check.getRank().equals("M")) {
					session.setAttribute("member", check);
					model.addAttribute("member", check);
					return "admin/adminDetail.page2";
				} else {
					String msg = "관리자 아이디가 입니다. 위의 링크를 눌러 메인페이지로 이동하세요";
					model.addAttribute("msg", msg);
				}
			} else {
				String msg = "비밀번호 오류입니다.";
				model.addAttribute("msg", msg);
			}
		} else {
			String msg = "존재하지 않는 아이디 입니다.";
			model.addAttribute("msg", msg);
		}

		return "admin/adminMain";
	}

	// -----------멤버관리
	@RequestMapping(value = "/memberManager.mdo", method = RequestMethod.GET)
	public String memberManager(HttpSession session, Model model) {
		System.out.println("memberManager mdo GET 호출 ");
		List<MemberVO> adminmemberList = memberService.selectAllMember();
		model.addAttribute("adminmemberList", adminmemberList);
		return "admin/adminMember.page2";
	}

	@RequestMapping(value = "/adminMemberDelete.mdo", method = RequestMethod.GET)
	public String adminMemberDelete(@RequestParam String id, MemberVO member, HttpSession session, Model model) {
		System.out.println("adminMemeberDelte.mdo GET 호출");
		System.out.println("넘어온 아이디 : " + id);
		member.setId(id);
		System.out.println(member);
		productService.deleteProductId(member.getId());
		memberService.admindeleteMember(member);
		return "redirect:/admin/memberManager.mdo";
	}

	@RequestMapping(value = "/adminmemberEdit.mdo", method = RequestMethod.GET)
	public String adminmemberEdit(@RequestParam String id, MemberVO member, HttpSession session, Model model) {

		MemberVO memberVO = (MemberVO) memberService.selectMember(member);
		ExpertVO expertVO = (ExpertVO) expertService.selectExpert(id);
		model.addAttribute("expert", expertVO);
		model.addAttribute("member", memberVO);
		return "admin/adminMemberDetail.page2";
	}

	@RequestMapping(value = "/adminmemberEdit.mdo", method = RequestMethod.POST)
	public String adminmemberEdit(ExpertVO expert, MemberVO member, Model model, HttpSession session) {

		// 패스워드 검증
		if (member.getPwd() == null || member.getPwd() == "") {
			System.out.println("pwd if 문 들어옴");
			String pwd = memberService.selectMember(member).getPwd();
			System.out.println(pwd);

			member.setPwd(pwd);
		}
		memberService.updateMember(member);
		System.out.println(member);
		System.out.println("수정된 판매자 랭크 : " + member.getRank());
		// 랭크 변경사항 검증
		if (member.getRank() == null || member.getRank() == "") {
			System.out.println("if 문 들어왔음");
			String rank = memberService.selectMember(member).getRank();
			System.out.println(rank);

			member.setRank(rank);

		}

		if (member.getRank() == "N" || member.getRank().equals("N")) {
			System.out.println("변경한 RANK = N 진입");
			productService.deleteProductId(member.getId());
			expertService.deleteExpert(member.getId());

		}

		if (member.getRank() == "E" || member.getRank().equals("E")) {
			System.out.println("변경한 RANK = E 진입");
			System.out.println("랭크 수정할 아이디 : " + member.getId());
			if (expertService.selectExpert(member.getId()) == null) {
				System.out.println("--- Expert TABLE " + member.getId() + "가 없음  ---");
				expertService.insertRankExpert(member.getId());

			}
		}

		return "redirect:/admin/memberManager.mdo";
	}

	@RequestMapping(value = "/memberfind.mdo", method = RequestMethod.POST)
	public String memberfind(@RequestParam String category, @RequestParam String findText, MemberVO member, findVO find,
			HttpSession session, Model model) {
		if (category.equals("이메일") || category == "이메일") {
			find.setCategory("id");
		} else {
			find.setCategory("nick_name");
		}
		find.setFindText(findText);
		System.out.println(find);

		List<MemberVO> adminmemberList = memberService.selectFindList(find);
		System.out.println(adminmemberList);

		model.addAttribute("adminmemberList", adminmemberList);
		return "admin/adminMember.page2";
	}

	// -----------상품관리
	@RequestMapping(value = "/adminProduct.mdo", method = RequestMethod.GET)
	public String ProductManager(HttpSession session, Model model) {
		List<ProductVO> adminproductList = productService.selectAllListProduct();
		model.addAttribute("adminproductList", adminproductList);

		return "admin/adminProduct.page2";
	}

	@RequestMapping(value = "/adminProductDelete.mdo", method = RequestMethod.GET)
	public String adminProductDelete(@RequestParam String num, ProductVO product, HttpSession session, Model model) {
		product.setProduct_num(num);
		productService.deleteProduct(product);
		return "redirect:/admin/adminProduct.mdo";
	}

	@RequestMapping(value = "/adminDetailProduct.mdo", method = RequestMethod.GET)
	public String adminDetailProduct(@RequestParam String num, ProductVO product, HttpSession session, Model model) {
		System.out.println("선택한 상품 번호 : " + num);
		product = productService.selectProduct(num);
		model.addAttribute("product", product);

		MemberVO nick_name = new MemberVO();
		nick_name = productService.select_NickName(product.getExpert_id());
		model.addAttribute("nick_name", nick_name);

		System.out.println(nick_name);
		System.out.println(product);

		return "admin/adminDetailProduct.page2";
	}

	@RequestMapping(value = "/find.mdo", method = RequestMethod.POST)
	public String find(@RequestParam String category, @RequestParam String findText, ProductVO product, findVO find,
			HttpSession session, Model model) {
		if (category.equals("카테고리") || category == "카테고리") {
			find.setCategory("category");
		} else {
			find.setCategory("expert_id");
		}
		find.setFindText(findText);
		List<ProductVO> adminproductList = productService.selectFindList(find);

		model.addAttribute("adminproductList", adminproductList);
		return "admin/adminProduct.page2";
	}

	// -----------홈페이지 관리
	@RequestMapping(value = "/adminHomePage.mdo", method = RequestMethod.GET)
	public String adminHomePageManager() {

		return "admin/adminHomePage.page2";
	}

	// ---------- 거래 내역

	@RequestMapping(value = "/adminpurchase.mdo", method = RequestMethod.GET)
	public String adminpurchase(PurchaseVO purchase, ProductVO product, Model model, HttpSession session) {
		System.out.println("admin Purchase GET 호출 ");
		ArrayList<String> ExpertidList = new ArrayList<>();
		ArrayList<String> ProducttitleList = new ArrayList<>();
		// ArrayList<ProductVO>ExpertidList = new ArrayList<>();

		try {
			List<PurchaseVO> purchaseList = purchaseService.selectListPurchase();
			System.out.println("거래내역 사이즈 : " + purchaseList.size());
			for (PurchaseVO purchaseVO : purchaseList) {
				System.out.println("DB 저장된 거래 내역 리스트 !!! : " + purchaseVO);
				String Expert_id = productService.selectProduct(purchaseVO.getProduct_num()).getExpert_id();
				String Product_title = productService.selectProduct(purchaseVO.getProduct_num()).getProduct_title();
				System.out.println("리스트에 들어가는 판매자 아이디 : " + Expert_id);
				ExpertidList.add(Expert_id);
				ProducttitleList.add(Product_title);

			}

			model.addAttribute("purchaseList", purchaseList);
			model.addAttribute("expertidList", ExpertidList);
			model.addAttribute("producttitleList", ProducttitleList);
		} catch (Exception e) {
			e.printStackTrace();
		}
      return "admin/adminPurchase.page2";
   
   }
   
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