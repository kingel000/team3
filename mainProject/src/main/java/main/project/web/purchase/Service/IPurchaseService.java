package main.project.web.purchase.Service;

import java.util.List;

import main.project.web.product.vo.findVO;
import main.project.web.purchase.vo.CartVO;
import main.project.web.purchase.vo.PurchaseVO;

public interface IPurchaseService {
	void insertPurchase(PurchaseVO purchase);
	void updatePurchase(PurchaseVO purchase);
	void deletePurchase(String purchaseNum);
	PurchaseVO selectPurchase(String purchaseNum);
	List<PurchaseVO> selectListPurchase();
	
	void addCart(CartVO cart);
	List<CartVO> selectMyCart(String memberId);
	void deleteCart(String cartNum);
	void checkOut(String memberId);
	List<PurchaseVO> purchaseFindList(findVO find);
}
