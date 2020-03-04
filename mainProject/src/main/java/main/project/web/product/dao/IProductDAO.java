package main.project.web.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import main.project.web.member.vo.MemberVO;
import main.project.web.product.vo.ProductVO;
import main.project.web.product.vo.findVO;

public interface IProductDAO {
	void insertProduct(ProductVO product);
	void deleteProduct(ProductVO product_num);
	void deleteProductId(String Id);
	void updateProduct(ProductVO product);
	ProductVO selectProduct(@Param("product_num")String product_num);
	List<ProductVO> selectCategory(String category);
	List<ProductVO> selectListProduct(MemberVO sessionId);
	List<ProductVO> selectAllListProduct();
	MemberVO select_NickName(String expert_id);
	MemberVO select_Id(@Param("product_num")String product_num);
	List<ProductVO> selectFindList(findVO find);
	List<ProductVO> mainFindList(String mainFindText);
	List<ProductVO> newProductList();
	
	
}
