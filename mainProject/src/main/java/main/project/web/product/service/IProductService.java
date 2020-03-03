package main.project.web.product.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import main.project.web.member.vo.MemberVO;
import main.project.web.product.vo.ProductVO;

public interface IProductService {
	void insertProduct(ProductVO product);
	void deleteProduct(ProductVO product_num);
	void updateProduct(ProductVO product);
	ProductVO selectProduct(String product_num);
	List<ProductVO> selectCategory(String category);
	List<ProductVO> selectListProduct(MemberVO sessionId);
	List<ProductVO> selectAllListProduct();
	MemberVO select_NickName(String expert_id);
}
