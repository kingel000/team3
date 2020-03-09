package main.project.web.purchase.Service;

import java.util.List;

import main.project.web.product.vo.findVO;
import main.project.web.purchase.vo.CartVO;
import main.project.web.purchase.vo.PurchaseVO;

public interface IPurchaseService {
	void insertPurchase(PurchaseVO purchase);
	void updatePurchase(PurchaseVO purchase);
	void deletePurchase(PurchaseVO purchase);
	PurchaseVO selectPurchase(PurchaseVO purchase);
	List<PurchaseVO> selectListPurchase();
	
	void addCart(CartVO cart);
	List<CartVO> selectMyCart(String memberId);
	void deleteCart(String cartNum);
	void checkOut(String memberId);
	List<PurchaseVO> purchaseFindList(findVO find);
	Integer totalPoint();
	Integer totalCountPurchase();
	Integer Id_totalCountPurchase(String id);
	Integer Id_totalPurchasePrice(String id);
	Integer Id_PurchaseCount(String id);
	Integer Id_totalSalesPrice(String id);
	Integer date_totalSales(String findDate);
	Integer productNum_PurchaseCount(String product_num);
}
