package main.project.web.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.project.web.member.vo.MemberVO;
import main.project.web.product.dao.ProductDAOImpl;
import main.project.web.product.vo.ProductVO;
import main.project.web.product.vo.findVO;

@Service("productService")
public class ProductService implements IProductService{

	@Autowired
	private ProductDAOImpl productDAO;
	
	@Override
	public void insertProduct(ProductVO product) {
		productDAO.insertProduct(product);
	}

	@Override
	public void deleteProduct(ProductVO product_num) {
		productDAO.deleteProduct(product_num);
	}

	@Override
	public void updateProduct(ProductVO product) {
		productDAO.updateProduct(product);
	}

	@Override
	public ProductVO selectProduct(String product_num) {
		return productDAO.selectProduct(product_num);
	}

	@Override
	public List<ProductVO> selectListProduct(MemberVO sessionId) {
		return productDAO.selectListProduct(sessionId);
	}

	@Override
	public List<ProductVO> selectCategory(String category) {
		return productDAO.selectCategory(category);
	}

	@Override
	public MemberVO select_NickName(String expert_id) {
		return productDAO.select_NickName(expert_id);
	}

	@Override
	public List<ProductVO> selectAllListProduct() {
		return productDAO.selectAllListProduct();
	}

	@Override
	public List<ProductVO> selectFindList(findVO find) {
		return productDAO.selectFindList(find);
	}

	@Override
<<<<<<< HEAD
	public MemberVO select_Id(String product_num) {
		return productDAO.select_Id(product_num);

	}

=======
	public List<ProductVO> mainFindList(String mainFindText) {
		return productDAO.mainFindList(mainFindText);
	}

	@Override
	public List<ProductVO> newProductList() {
		return productDAO.newProductList();
	}
>>>>>>> branch 'master' of https://github.com/kingel000/team3

}
