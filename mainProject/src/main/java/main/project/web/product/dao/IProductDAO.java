package main.project.web.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import main.project.web.product.vo.ProductVO;
import main.project.web.question.vo.QuestionVO;

public interface IProductDAO {
	void insertProduct(ProductVO product);
	void deleteProduct(ProductVO product_num);
	void updateProduct(ProductVO product);
	ProductVO selectProduct(ProductVO product_num);
	List<ProductVO> selectListProduct();

}
