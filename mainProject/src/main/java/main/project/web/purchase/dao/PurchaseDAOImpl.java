package main.project.web.purchase.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import main.project.web.product.vo.findVO;
import main.project.web.purchase.vo.CartVO;
import main.project.web.purchase.vo.PurchaseVO;

@Repository("purchaseDAO")
public class PurchaseDAOImpl implements IPurchaseDAO {
	
	@Inject
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void insertPurchase(PurchaseVO purchase) {
		sqlSessionTemplate.insert("main.project.web.purchase.dao.IPurchaseDAO.insertPurchase", purchase);
	}

	@Override
	public void updatePurchase(PurchaseVO purchase) {
		sqlSessionTemplate.update("main.project.web.purchase.dao.IPurchaseDAO.updatePurchase", purchase);

	}

	@Override
	public void deletePurchase(String purchaseNum) {
		sqlSessionTemplate.delete("main.project.web.purchase.dao.IPurchaseDAO.deletePurchase", purchaseNum);
	}

	@Override
	public PurchaseVO selectPurchase(String purchaseNum) {
		return sqlSessionTemplate.selectOne("main.project.web.purchase.dao.IPurchaseDAO.selectPurchase", purchaseNum);
	}

	@Override
	public List<PurchaseVO> selectListPurchase() {
		return sqlSessionTemplate.selectList("main.project.web.purchase.dao.IPurchaseDAO.selectListPurchase");
	}

	@Override
	public void addCart(CartVO cart) {
		sqlSessionTemplate.insert("main.project.web.purchase.dao.IPurchaseDAO.addCart",cart);
	}

	@Override
	public List<CartVO> selectMyCart(String memberId) {
		return sqlSessionTemplate.selectList("main.project.web.purchase.dao.IPurchaseDAO.selectMyCart", memberId);
	}

	@Override
	public void deleteCart(String cartNum) {
		sqlSessionTemplate.delete("main.project.web.purchase.dao.IPurchaseDAO.deleteCart", cartNum);
	}

	@Override
	public void checkOut(String memberId) {
		sqlSessionTemplate.delete("main.project.web.purchase.dao.IPurchaseDAO.checkOut", memberId);
	}

	@Override
	public List<PurchaseVO> purchaseFindList(findVO find) {
		return sqlSessionTemplate.selectList("main.project.web.purchase.dao.IPurchaseDAO.purchaseFindList", find);
	}

	@Override
	public CartVO getCart(String cartNum) {
		return sqlSessionTemplate.selectOne("main.project.web.purchase.dao.IPurchaseDAO.getCart", cartNum);
	}


}
