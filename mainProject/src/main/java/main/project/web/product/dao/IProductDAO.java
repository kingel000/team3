package main.project.web.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import main.project.web.member.vo.MemberVO;
import main.project.web.product.vo.ProductVO;

public interface IProductDAO {
	void insertProduct(ProductVO product);
	void deleteProduct(ProductVO product_num);
	void updateProduct(ProductVO product);
	ProductVO selectProduct(@Param("product_num")String product_num);
	List<ProductVO> selectCategory(String category);
	List<ProductVO> selectListProduct(MemberVO sessionId);
	List<ProductVO> selectAllListProduct(ProductVO category);
	MemberVO select_NickName(String expert_id);
	
}