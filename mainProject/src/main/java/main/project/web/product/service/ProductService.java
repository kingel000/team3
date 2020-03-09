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

	public MemberVO select_Id(String product_num) {
		return productDAO.select_Id(product_num);

	}


	public List<ProductVO> mainFindList(String mainFindText) {
		return productDAO.mainFindList(mainFindText);
	}

	@Override
	public List<ProductVO> newProductList() {
		return productDAO.newProductList();
	}

	@Override

	public List<ProductVO> newAlignmentList(String category) {
		return productDAO.newAlignmentList(category);
	}

	@Override
	public List<ProductVO> nameAlignmentList(String category) {
		return productDAO.nameAlignmentList(category);
	}
	public void deleteProductId(String Id) {
		productDAO.deleteProductId(Id);

	}

	@Override
	public Integer totalProduct() {
		return productDAO.totalProduct();
	}

	@Override
	public List<ProductVO> expertProductList(String member_id) {
		return productDAO.expertProductList(member_id);
	}

	@Override
	public List<ProductVO> category_product_num(String category) {
		return productDAO.category_product_num(category);
	}

	//������ ��ǰ��
	@Override
	public int countProduct(String id) throws Exception {
		return productDAO.countProduct(id);
	}
	//���� �Խù� ��� + ����¡
	@Override
	public List<ProductVO> listPage(int displayPost, int postNum, String id) throws Exception {
		return productDAO.listPage(displayPost, postNum, id);
	}
	//ī�װ��� ��ǰ��
	@Override
	public int countCategory(String category) throws Exception {
		return productDAO.countCategory(category);
	}
	//ī�װ��� ��� + ����¡
	@Override
	public List<ProductVO> categoryPage(int displayPost, int postNum, String category) throws Exception {
		return productDAO.categoryPage(displayPost, postNum, category);
	}

}
