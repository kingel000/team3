package main.project.web.purchase.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import main.project.web.product.vo.findVO;
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
	List<PurchaseVO> purchaseFindList(findVO find);
	Integer totalPoint();	//총 포인트
	Integer totalCountPurchase(); //총 구매 개수
	Integer Id_totalCountPurchase(String id); //아이디별 구매 개수
	Integer Id_totalPurchasePrice(String id); //아이디별 총 구매 가격
	Integer Id_PurchaseCount(String id); //아이디별 판매개수
	Integer Id_totalSalesPrice(String id); //아이디별 총 판매금액
	Integer date_totalSales(String findDate); //월별 판매수
	Integer productNum_PurchaseCount(String product_num);//상품번호별 판매개수
}
