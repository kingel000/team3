package main.project.web.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.project.web.product.dao.ProductDAOImpl;
import main.project.web.product.vo.ProductVO;

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
	public ProductVO selectProduct(ProductVO product_num) {
		return productDAO.selectProduct(product_num);
	}

	@Override
	public List<ProductVO> selectListProduct() {
		return productDAO.selectListProduct();
	}

}
