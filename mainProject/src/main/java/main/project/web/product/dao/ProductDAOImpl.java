package main.project.web.product.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import main.project.web.product.vo.ProductVO;

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
	public ProductVO selectProduct(ProductVO product_num) {
		return sqlSessiontemplate.selectOne("main.project.web.product.dao.IProductDAO.selectProduct",product_num);
	}
	@Override
	public List<ProductVO> selectListProduct() {
		return sqlSessiontemplate.selectList("main.project.web.product.dao.IProductDAO.selectiListProduct");
	}
}
