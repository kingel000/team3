package main.project.web.product.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import main.project.web.member.vo.MemberVO;
import main.project.web.product.vo.ProductVO;
import main.project.web.product.vo.findVO;

@Repository("productDAO")
public class ProductDAOImpl implements IProductDAO {

	@Inject
	private SqlSessionTemplate sqlSessiontemplate;

	private static String namespace = "main.project.web.product.dao.IProductDAO";
	
	@Override
	public void insertProduct(ProductVO product) {
		sqlSessiontemplate.insert("main.project.web.product.dao.IProductDAO.insertProduct",product);
	}
	@Override
	public void deleteProduct(ProductVO product_num) {
		sqlSessiontemplate.delete("main.project.web.product.dao.IProductDAO.deleteProduct",product_num);
	}
	@Override
	public void updateProduct(ProductVO product) {
		sqlSessiontemplate.update("main.project.web.product.dao.IProductDAO.updateProduct",product);
	}
	@Override
	public ProductVO selectProduct(String product_num) {
		return sqlSessiontemplate.selectOne("main.project.web.product.dao.IProductDAO.selectProduct",product_num);
	}
	@Override
	public List<ProductVO> selectListProduct(MemberVO sessionId) {
		return sqlSessiontemplate.selectList("main.project.web.product.dao.IProductDAO.selectListProduct", sessionId);
	}
	
	@Override
	public List<ProductVO> selectAllListProduct() {
		return sqlSessiontemplate.selectList("main.project.web.product.dao.IProductDAO.selectAllListProduct");
	}
	@Override
	public List<ProductVO> selectCategory(String category) {
		return sqlSessiontemplate.selectList("main.project.web.product.dao.IProductDAO.selectCategory",category);

	}
	@Override
	public MemberVO select_NickName(String expert_id) {
		return sqlSessiontemplate.selectOne("main.project.web.product.dao.IProductDAO.select_NickName",expert_id);
	}

	@Override
	public List<ProductVO> selectFindList(findVO find) {
		return sqlSessiontemplate.selectList("main.project.web.product.dao.IProductDAO.selectFindList", find);
	}
	
	@Override
	public MemberVO select_Id(String product_num) {
		return sqlSessiontemplate.selectOne("main.project.web.product.dao.IProductDAO.select_Id",product_num);


	}
	public List<ProductVO> mainFindList(String mainFindText) {
		return sqlSessiontemplate.selectList("main.project.web.product.dao.IProductDAO.mainFindList", mainFindText);
	}
	@Override
	public List<ProductVO> newProductList() {
		return sqlSessiontemplate.selectList("main.project.web.product.dao.IProductDAO.newProductList");

	}
	@Override

	public List<ProductVO> newAlignmentList(String category) {
		return sqlSessiontemplate.selectList("main.project.web.product.dao.IProductDAO.newAlignmentList",category);
	}
	@Override
	public List<ProductVO> nameAlignmentList(String category) {
		return sqlSessiontemplate.selectList("main.project.web.product.dao.IProductDAO.nameAlignmentList",category);
	}
	public void deleteProductId(String Id) {
		sqlSessiontemplate.delete("main.project.web.product.dao.IProductDAO.deleteProductId",Id);
	}

	//목록
	@Override
	public int count(String id) throws Exception {
		return sqlSessiontemplate.selectOne(namespace + ".count", id);
	}
	
	// 게시물 목록 + 페이징
	@Override
	public List<ProductVO> listPage(int displayPost, int postNum, String id) throws Exception {
		HashMap data = new HashMap();
		data.put("displayPost", displayPost);
		data.put("postNum", postNum);
		data.put("id", id);
		return sqlSessiontemplate.selectList(namespace + ".listPage", data);
	}

}
