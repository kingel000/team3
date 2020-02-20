package main.project.web.product.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import main.project.web.member.service.IMemberService;
import main.project.web.member.vo.ExpertVO;
import main.project.web.member.vo.MemberVO;
import main.project.web.product.service.IProductService;
import main.project.web.product.vo.ProductVO;

@Controller("productController")
@RequestMapping(value="/product")
public class ProductController {
	@Autowired
	private IProductService productService;
	@Autowired
	private IMemberService memberService;
	
	@RequestMapping(value="/mainProduct.do", method=RequestMethod.GET)
	public String mainProduct(@RequestParam String category,ProductVO product, Model model, HttpSession session) {
		System.out.println("produdct GET ȣ�� ");

		if(category.equals("'C1'")) {
			category ="�� ����";
		}else if(category.equals("'C2'")) {
			category = "����Ͼۡ���";
		}else if(category.equals("'C3'")) {
			category = "����";
		}else if(category.equals("'C4'")) {
			category = "�������α׷���";
		}else if(category.equals("'C5'")) {
			category =	"��Ÿ";
		}
		System.out.println("������ ī�װ� : " + category);
		List<ProductVO> productCategory = productService.selectCategory(category);
		List<String> nick = new ArrayList<String>(); 
		System.out.println("----");
		for(ProductVO productVO : productCategory) {
			System.out.println("DB ���� ī�װ��� ��ǰ ����Ʈ " + productVO);
			nick.add(memberService.checkMemberId(productVO.getExpert_id()).getNick_name());
		}
		model.addAttribute("productList",productCategory);
		model.addAttribute("nick",nick);
		
		//productService.selectAllListProduct();
		return "product/mainProduct.part2";
	}
	
	@RequestMapping(value="/insertProduct.do", method=RequestMethod.GET)
	public String insertProduct(Model model) {
		System.out.println("produdct insert GET ȣ�� ");
		return "product/insertProduct.page";
	}
	@RequestMapping(value="/insertProduct.do", method=RequestMethod.POST)
	public String insertProduct(ProductVO product,HttpSession session ,Model model, MultipartFile uploadfile , MultipartHttpServletRequest request ) {
		System.out.println("produdct insert POST ȣ�� ");
		
		MemberVO member = (MemberVO)(session.getAttribute("member"));
		System.out.println(member.getId());

		product.setExpert_id(member.getId());
		session.setAttribute("product", product);
		System.out.println(product);

		String rootUploadDir = "C:"+File.separator+"Upload"; // C:/Upload

		File dir = new File(rootUploadDir + File.separator + "testfile"); 

		if(!dir.exists()) { //���ε� ���丮�� �������� ������ ����
			dir.mkdirs();
		}

		Iterator<String> iterator = request.getFileNames(); //���ε�� �������� ����(2�� - file1,file2)

		int fileLoop = 0;
		String uploadFileName;
		MultipartFile mFile = null;
		String orgFileName = ""; //��¥ ���ϸ�
		String sysFileName = ""; //��ȯ�� ���ϸ�

		ArrayList<String> list = new ArrayList<String>();

		while(iterator.hasNext()) {
			fileLoop++;

			uploadFileName = iterator.next();
			mFile = request.getFile(uploadFileName);

			orgFileName = mFile.getOriginalFilename();    
			System.out.println(orgFileName);

			if(orgFileName != null && orgFileName.length() != 0) { //sysFileName ����
				System.out.println("if�� ����");
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMDDHHmmss-" + fileLoop);
				Calendar calendar = Calendar.getInstance();
				sysFileName = simpleDateFormat.format(calendar.getTime()); //sysFileName: ��¥-fileLoop��ȣ


				try {
					System.out.println("try ����");
					mFile.transferTo(new File(dir + File.separator + sysFileName)); // C:/Upload/testfile/sysFileName
					list.add("�������ϸ�: " + orgFileName + ", �ý������ϸ�: " + sysFileName);

				}catch(Exception e){
					list.add("���� ���ε� �� �����߻�!!!");
				}
			}//if
		}//while
		
		model.addAttribute("list", list);



		return "product/insertProduct.page";
	}

	@RequestMapping(value="/boardManager.do", method = RequestMethod.GET)
	public String editBoard(ExpertVO expert, HttpSession session , Model model) {
		MemberVO sessionId = (MemberVO)session.getAttribute("member");
		expert.setId(sessionId.getId());
		System.out.println(expert);
		session.setAttribute("expert",expert);
		List<ProductVO> productList = productService.selectListProduct(sessionId);
		for(ProductVO product : productList) {
			System.out.println(product);
		}
		model.addAttribute("productList",productList);
		return "product/boardManager.page";
	}

	@RequestMapping(value="/boardManager.do", method = RequestMethod.POST)
	public String editBoard(ExpertVO expert , Model model , HttpSession session) {

		return "main/main.part2";
	}
	
	@RequestMapping(value="/updateProduct.do", method = RequestMethod.GET)
	public String updateProduct(@RequestParam String num, HttpSession session , Model model) {
		ProductVO product = productService.selectProduct(num);
		System.out.println("�����ϴ� �Խù��� ���� : "+ product);
	
		model.addAttribute("product", product);
		return "product/updateProduct.page";
	}

	@RequestMapping(value="/updateProduct.do", method = RequestMethod.POST)
	public String updateProduct(ProductVO product, Model model , HttpSession session) {
		System.out.println("updateProduct.do POST ���� ");
		System.out.println(product);
		productService.updateProduct(product);
		return "/product/boardManager.page";
	}
}
