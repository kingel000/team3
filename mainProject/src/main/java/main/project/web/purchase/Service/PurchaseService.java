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
	public Integer totalPoint() {
		return purchaseDAO.totalPoint();
	}

	@Override
	public Integer totalCountPurchase() {
		return purchaseDAO.totalCountPurchase();
	}

	@Override
	public Integer Id_totalCountPurchase(String id) {
		return purchaseDAO.Id_totalCountPurchase(id);
	}

	@Override
	public Integer Id_totalPurchasePrice(String id) {
		return purchaseDAO.Id_totalPurchasePrice(id);
	}

	@Override
	public Integer Id_PurchaseCount(String id) {
		return purchaseDAO.Id_PurchaseCount(id);
	}

	@Override
	public Integer Id_totalSalesPrice(String id) {
		return purchaseDAO.Id_totalSalesPrice(id);
	}

	@Override
	public Integer date_totalSales(String findDate) {
		return purchaseDAO.date_totalSales(findDate);
	}

	@Override
	public Integer productNum_PurchaseCount(String product_num) {
		return purchaseDAO.productNum_PurchaseCount(product_num);
	}
	
	@Override
	public CartVO getCart(String cartNum) {
		return purchaseDAO.getCart(cartNum);
	}

	@Override
	public List<PurchaseVO> selectPurchaseList(String memberId) {
		return purchaseDAO.selectPurchaseList(memberId);
	}

	@Override
	public List<PurchaseVO> selectMemberOrder(PurchaseVO purchase) {
		return purchaseDAO.selectMemberOrder(purchase);
	}

	@Override
	public List<PurchaseVO> selectExpertPurchase(String expertId) {
		return purchaseDAO.selectExpertPurchase(expertId);
	}

	@Override
	public List<PurchaseVO> selectExpertOrder(PurchaseVO purchase) {
		return purchaseDAO.selectExpertOrder(purchase);
	}

}
