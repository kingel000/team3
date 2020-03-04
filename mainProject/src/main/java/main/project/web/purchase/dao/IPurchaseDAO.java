package main.project.web.purchase.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import main.project.web.purchase.vo.CartVO;
import main.project.web.purchase.vo.PurchaseVO;


public interface IPurchaseDAO {
	void insertPurchase(PurchaseVO purchase);
	void updatePurchase(PurchaseVO purchase);
	void deletePurchase(PurchaseVO purchase);
	PurchaseVO selectPurchase(PurchaseVO purchase);
	List<PurchaseVO> selectListPurchase();
	
	void addCart(CartVO cart);
	List<CartVO> selectMyCart(@Param("memberId") String memberId);
	void deleteCart(@Param("cartNum") String cartNum);
	void checkOut(@Param("memberId") String memberId);
}
