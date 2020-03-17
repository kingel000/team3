package main.project.web.product.controller;

import java.util.ArrayList;
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

import main.project.web.member.service.IExpertService;
import main.project.web.member.service.IMemberService;
import main.project.web.member.vo.ExpertVO;
import main.project.web.member.vo.MemberVO;
import main.project.web.product.service.IProductService;
import main.project.web.product.vo.ProductVO;
import main.project.web.purchase.Service.IPurchaseService;
import main.project.web.purchase.vo.CartVO;

@Controller("productController")
@RequestMapping(value="/product")
public class ProductController {
	@Autowired
	private IProductService productService;
	@Autowired
	private IMemberService memberService;
	@Autowired
	private IPurchaseService purchaseService;
	@Autowired
	private IExpertService expertService;
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@RequestMapping(value="/mainProduct.do", method=RequestMethod.GET)
	public String mainProduct(@RequestParam("category") String category, @RequestParam("num") int num, ProductVO product, Model model, HttpSession session) throws Exception {
		logger.info("produdct GET 호출 ");
		if(category.equals("'C1'")) {
			category ="웹 개발";
		}else if(category.equals("'C2'")) {
			category = "모바일앱·웹";
		}else if(category.equals("'C3'")) {
			category = "게임";
		}else if(category.equals("'C4'")) {
			category = "응용프로그래밍";
		}else if(category.equals("'C5'")) {
			category =	"기타";
		}
		// 게시물 총 갯수
		int count = productService.countCategory(category);
		// 한 페이지에 출력할 게시물 갯수
		int postNum = 16;
		// 출력할 게시물
		int displayPost = (num - 1) * postNum + 1;
		// 한번에 표시할 페이징 번호의 갯수
		int pageNum_cnt = 3;

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
		
		List<ProductVO> productCategory = productService.categoryPage(displayPost, postNum * num, category);
		
		List<String> nick = new ArrayList<String>(); 
		if(productCategory.size() != 0) {
			for(ProductVO productVO : productCategory) {
				nick.add(memberService.checkMemberId(productVO.getExpert_id()).getNick_name());
			}
			model.addAttribute("productList",productCategory);
			model.addAttribute("nick",nick);
			model.addAttribute("category",category);
		}
		// 시작 및 끝 번호
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);

		// 이전 및 다음 
		model.addAttribute("prev", prev);
		model.addAttribute("next", next);

		// 현재 페이지
		model.addAttribute("select", num);
		return "product/mainProduct.part2";
	}
	
	@RequestMapping(value = "/alignmentProduct.do", method = RequestMethod.POST)
	   public String alignmentProduct(@RequestParam String alignment,ProductVO product, Model model, HttpSession session) {
		
	      String category = product.getCategory();
	      if(alignment == "최신등록순" || alignment.equals("최신등록순")) {
	    	 logger.info("최신등록순");
	         List<ProductVO> productList = productService.newAlignmentList(category);
	         List<String> nick = new ArrayList<String>(); 

	 		if(productList.size() != 0) {
	 			for(ProductVO productVO : productList) {
	 				nick.add(memberService.checkMemberId(productVO.getExpert_id()).getNick_name());
	 			}
	 		model.addAttribute("nick",nick);
	 		model.addAttribute("productList",productList);
	      }
	      }else {
	    	 logger.info("이름");
	         List<ProductVO> productList = productService.nameAlignmentList(category);
	         List<String> nick = new ArrayList<String>(); 

		 		if(productList.size() != 0) {
		 			for(ProductVO productVO : productList) {
		 				nick.add(memberService.checkMemberId(productVO.getExpert_id()).getNick_name());
		 			}
		 			model.addAttribute("nick",nick);
		 			model.addAttribute("productList",productList);
		 		}
	      }
	      return "product/mainProduct.part2";
	 }
	
	@RequestMapping(value="/insertProduct.do", method=RequestMethod.GET)
	public String insertProduct(Model model) {
		logger.info("produdct insert GET 호출 ");
		return "product/insertProduct.page";
	}
	@RequestMapping(value="/insertProduct.do", method=RequestMethod.POST)
	public String insertProduct(ProductVO product,HttpSession session ,Model model,@RequestParam("fileName")String fileName) {
		logger.info("produdct insert POST 호출 ");
		logger.info("file 실제 경로 :"+fileName);
		MemberVO member = (MemberVO) session.getAttribute("member");
		logger.info(member.getId());
		
		String sessionId = member.getId();
		product.setExpert_id(sessionId);
		product.setThumbnail(fileName);
		logger.info("등록하는 상품의 정보 : " + product);
		productService.insertProduct(product);
				
		return "redirect:/member/mypage.do";
	}
	
	// 게시물 목록 + 페이징 추가
	@RequestMapping(value="/boardManager.do", method = RequestMethod.GET)
	public String editBoard(@RequestParam("num") int num, ExpertVO expert, HttpSession session , Model model) throws Exception {
		MemberVO sessionId = (MemberVO)session.getAttribute("member");
		List<ProductVO> productList = null; 
		// 게시물 총 갯수
		int count = productService.countProduct(sessionId.getId());
		// 한 페이지에 출력할 게시물 갯수
		int postNum = 10;
		// 하단 페이징 번호 ([ 게시물 총 갯수 ÷ 한 페이지에 출력할 갯수 ]의 올림)
		int pageNum = (int)Math.ceil((double)count/postNum);
		// 출력할 게시물
		int displayPost = (num - 1) * postNum + 1;
		// 한번에 표시할 페이징 번호의 갯수
		int pageNum_cnt = 3;

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
		expert.setId(sessionId.getId());
		session.setAttribute("expert",expert);
		productList = productService.listPage(displayPost, postNum * num, sessionId.getId());
		model.addAttribute("productList", productList);
		model.addAttribute("pageNum", pageNum);

		// 시작 및 끝 번호
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);

		// 이전 및 다음 
		model.addAttribute("prev", prev);
		model.addAttribute("next", next);

		// 현재 페이지
		model.addAttribute("select", num);
		return "product/boardManager.page";
	}
	
	@RequestMapping(value="/boardManager.do", method = RequestMethod.POST)
	public String editBoard(ExpertVO expert , Model model , HttpSession session) {

		return "redirect:/main/main.do";
	}
	
	@RequestMapping(value="/updateProduct.do", method = RequestMethod.GET)
	public String updateProduct(@RequestParam String num, HttpSession session , Model model) {
		ProductVO product = productService.selectProduct(num);
		logger.info("수정하는 게시물의 정보 : "+ product);
	
		model.addAttribute("product", product);
		return "product/updateProduct.page";
	}

	@RequestMapping(value="/updateProduct.do", method = RequestMethod.POST)
	public String updateProduct(ProductVO product, Model model , HttpSession session,@RequestParam("fileName")String fileName) {
		logger.info("updateProduct.do POST 받음 ");
		product.setThumbnail(fileName);
		productService.updateProduct(product);
		return "redirect:/product/boardManager.do?num=1";
	}
	
	@RequestMapping(value="/deleteProduct.do", method = RequestMethod.GET)
	public String deleteProduct(@RequestParam String num, HttpSession session , Model model) {
		logger.info("deleteProduct.do GET 받음");
		ProductVO product = productService.selectProduct(num);
		productService.deleteProduct(product);
		return "redirect:/product/boardManager.do?num=1";
	}

	@RequestMapping(value="/detailProduct.do", method = RequestMethod.GET)
	public String detailProduct(@RequestParam String num,ProductVO product,ExpertVO expert, Model model , HttpSession session) {
		logger.info("detailProduct GET 받음 ");

		ProductVO numProduct = productService.selectProduct(num);
		logger.info("상세페이지 : " + numProduct);
		
		model.addAttribute("numProduct",numProduct);
		MemberVO nick_name = new MemberVO();
		nick_name = productService.select_NickName(numProduct.getExpert_id());
		expert = expertService.selectExpert(numProduct.getExpert_id());
		model.addAttribute("exper_id",numProduct.getExpert_id());
		model.addAttribute("nick_name",nick_name);
		model.addAttribute("expert",expert);
		
		return "/product/detailProduct.part2";
	}
	
	@RequestMapping(value="/detailP.do", method = RequestMethod.GET)
	public String detailP(@RequestParam String num,@RequestParam String msg,ProductVO product,ExpertVO expert, Model model , HttpSession session) {
		logger.info("detailProduct GET 받음 ");

		ProductVO numProduct = productService.selectProduct(num);
		model.addAttribute("numProduct",numProduct);
		MemberVO nick_name = new MemberVO();
		nick_name = productService.select_NickName(numProduct.getExpert_id());
		expert = expertService.selectExpert(numProduct.getExpert_id());
		model.addAttribute("exper_id",numProduct.getExpert_id());
		model.addAttribute("nick_name",nick_name);
		model.addAttribute("expert",expert);
		
		logger.info(msg);
		model.addAttribute("msg", msg);
		return "/product/detailProduct.part2";
	}
	
	@RequestMapping(value="/detailProduct.do", method = RequestMethod.POST)
	public String detailProduct(ProductVO product, Model model , HttpSession session) {
		return "/product/boardManager.page";
	}
	
}
