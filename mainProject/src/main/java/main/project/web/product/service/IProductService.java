package main.project.web.product.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import main.project.web.member.vo.MemberVO;
import main.project.web.product.vo.ProductVO;
import main.project.web.product.vo.findVO;

public interface IProductService {
	@Transactional 
	void insertProduct(ProductVO product);

	void deleteProduct(ProductVO product_num);
	@Transactional 
	void deleteProductId(String Id);
	@Transactional 
	void updateProduct(ProductVO product);
	ProductVO selectProduct(String product_num);
	MemberVO select_NickName(String expert_id);
	ProductVO selectThumbnail(String product_num);
	MemberVO select_Id(String product_num);
	List<ProductVO> selectFindList(findVO find);
	List<ProductVO> mainFindList(String mainFindText);
	List<ProductVO> newProductList();
	List<ProductVO> newAlignmentList(String category);
	List<ProductVO> nameAlignmentList(String category);
	Integer totalProduct();
	List<ProductVO> productPage(int displayPost, int postNum)throws Exception;
	List<ProductVO> expertProductList(String member_id);
	List<ProductVO> category_product_num(String category);

	
	//카테고리별 상품수
	public int countProduct(String id) throws Exception;
	//계정 게시물 목록 + 페이징
	public List<ProductVO> listPage(int displayPost, int postNum, String id) throws Exception;
	//카테고리별 상품수
	public int countCategory(String category) throws Exception;
	//카테고리별 목록 + 페이징
	public List<ProductVO> categoryPage(int displayPost, int postNum, String category) throws Exception;
}
