package main.project.web.purchase.Service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import main.project.web.product.vo.findVO;
import main.project.web.purchase.vo.CartVO;
import main.project.web.purchase.vo.PurchaseVO;

public interface IPurchaseService {
	@Transactional 
	void insertPurchase(PurchaseVO purchase);
	@Transactional 
	void updatePurchase(PurchaseVO purchase);
	@Transactional 
	void deletePurchase(String purchaseNum);
	
	PurchaseVO selectPurchase(String purchaseNum);
	List<PurchaseVO> selectListPurchase();
	List<PurchaseVO> selectPurchaseList(String memberId);
	List<PurchaseVO> selectMemberOrder(PurchaseVO purchase);
	List<PurchaseVO> selectExpertOrder(PurchaseVO purchase);
	List<PurchaseVO> selectExpertPurchase(String expertId);
	
	@Transactional 
	void addCart(CartVO cart);
	
	List<CartVO> selectMyCart(String memberId);
	CartVO getCart(String cartNum);
	@Transactional 
	void deleteCart(String cartNum);
	@Transactional 
	void checkOut(String memberId);
	List<PurchaseVO> purchaseFindList(findVO find);
	Integer totalPoint();
	Integer totalCountPurchase();
	int countPurchase();
	public List<PurchaseVO> purchasePage(int displayPost, int postNum)throws Exception;
	Integer Id_totalCountPurchase(String id);
	Integer Id_totalPurchasePrice(String id);
	Integer Id_PurchaseCount(String id);
	Integer Id_totalSalesPrice(String id);
	Integer date_totalSales(String findDate);
	Integer productNum_PurchaseCount(String product_num);
}
