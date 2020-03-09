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
	Integer totalPoint();	//�� ����Ʈ
	Integer totalCountPurchase(); //�� ���� ����
	Integer Id_totalCountPurchase(String id); //���̵� ���� ����
	Integer Id_totalPurchasePrice(String id); //���̵� �� ���� ����
	Integer Id_PurchaseCount(String id); //���̵� �ǸŰ���
	Integer Id_totalSalesPrice(String id); //���̵� �� �Ǹűݾ�
	Integer date_totalSales(String findDate); //���� �Ǹż�
	Integer productNum_PurchaseCount(String product_num);//��ǰ��ȣ�� �ǸŰ���
}
