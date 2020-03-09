package main.project.web.purchase.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import main.project.web.product.vo.findVO;
import main.project.web.purchase.vo.CartVO;
import main.project.web.purchase.vo.PurchaseVO;


public interface IPurchaseDAO {
	void insertPurchase(PurchaseVO purchase);
	void updatePurchase(PurchaseVO purchase);
	void deletePurchase(@Param("purchaseNum") String purchaseNum);
	PurchaseVO selectPurchase(@Param("purchaseNum") String purchaseNum);
	List<PurchaseVO> selectListPurchase();
	List<PurchaseVO> selectPurchaseList(@Param("memberId")String memberId);
	List<PurchaseVO> selectMemberOrder(PurchaseVO purchase);
	List<PurchaseVO> selectExpertOrder(PurchaseVO purchase);
	List<PurchaseVO> selectExpertPurchase(@Param("expertId")String expertId);
	
	void addCart(CartVO cart);
	List<CartVO> selectMyCart(@Param("memberId") String memberId);
	CartVO getCart(@Param("cartNum")String cartNum);
	void deleteCart(@Param("cartNum") String cartNum);
	void checkOut(@Param("memberId") String memberId);
	List<PurchaseVO> purchaseFindList(findVO find);
}
