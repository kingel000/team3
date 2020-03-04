package main.project.web.product.dao;

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

	
	
}
