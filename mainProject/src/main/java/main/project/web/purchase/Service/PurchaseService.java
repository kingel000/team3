package main.project.web.purchase.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.project.web.purchase.dao.IPurchaseDAO;
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
	public void deletePurchase(PurchaseVO purchase) {
		purchaseDAO.deletePurchase(purchase);
	}

	@Override
	public PurchaseVO selectPurchase(PurchaseVO purchase) {
		return purchaseDAO.selectPurchase(purchase);
	}

	@Override
	public List<PurchaseVO> selectListPurchase() {
		return purchaseDAO.selectListPurchase();
	}

}
