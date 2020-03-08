package main.project.web.purchase.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.project.web.product.vo.findVO;
import main.project.web.purchase.dao.IPurchaseDAO;
import main.project.web.purchase.vo.CartVO;
import main.project.web.purchase.vo.PurchaseVO;

@Service("purchaseService")
public class PurchaseService implements IPurchaseService{

	@Autowired
	private IPurchaseDAO purchaseDAO;
	
	@Override
	public void insertPurchase(PurchaseVO purchase) {
		purchaseDAO.insertPurchase(purchase);
	}

	@Override
	public void updatePurchase(PurchaseVO purchase) {
		purchaseDAO.updatePurchase(purchase);
	}

	@Override
	public void deletePurchase(String purchaseNum) {
		purchaseDAO.deletePurchase(purchaseNum);
	}

	@Override
	public PurchaseVO selectPurchase(String purchaseNum) {
		return purchaseDAO.selectPurchase(purchaseNum);
	}

	@Override
	public List<PurchaseVO> selectListPurchase() {
		return purchaseDAO.selectListPurchase();
	}

	@Override
	public void addCart(CartVO cart) {
		purchaseDAO.addCart(cart);
	}

	@Override
	public List<CartVO> selectMyCart(String memberId) {
		return purchaseDAO.selectMyCart(memberId);
	}

	@Override
	public void deleteCart(String cartNum) {
		purchaseDAO.deleteCart(cartNum);
	}

	@Override
	public void checkOut(String memberId) {
		purchaseDAO.checkOut(memberId);
	}

	@Override
	public List<PurchaseVO> purchaseFindList(findVO find) {
		return purchaseDAO.purchaseFindList(find);
	}

	@Override
	public CartVO getCart(String cartNum) {
		return purchaseDAO.getCart(cartNum);
	}

}
