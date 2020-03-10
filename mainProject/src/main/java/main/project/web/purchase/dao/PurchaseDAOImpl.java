package main.project.web.purchase.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import main.project.web.product.vo.ProductVO;
import main.project.web.product.vo.findVO;
import main.project.web.purchase.vo.CartVO;
import main.project.web.purchase.vo.PurchaseVO;

@Repository("purchaseDAO")
public class PurchaseDAOImpl implements IPurchaseDAO {
	
	@Inject
	private SqlSessionTemplate sqlSessionTemplate;

	private static String namespace = "main.project.web.purchase.dao.IPurchaseDAO";
	
	@Override
	public void insertPurchase(PurchaseVO purchase) {
		sqlSessionTemplate.insert("main.project.web.purchase.dao.IPurchaseDAO.insertPurchase", purchase);
	}

	@Override
	public void updatePurchase(PurchaseVO purchase) {
		sqlSessionTemplate.update("main.project.web.purchase.dao.IPurchaseDAO.updatePurchase", purchase);

	}

	@Override
	public void deletePurchase(String purchaseNum) {
		sqlSessionTemplate.delete("main.project.web.purchase.dao.IPurchaseDAO.deletePurchase", purchaseNum);
	}

	@Override
	public List<PurchaseVO> selectListPurchase() {
		return sqlSessionTemplate.selectList("main.project.web.purchase.dao.IPurchaseDAO.selectListPurchase");
	}

	@Override
	public PurchaseVO selectPurchase(String purchaseNum) {
		return sqlSessionTemplate.selectOne("main.project.web.purchase.dao.IPurchaseDAO.selectPurchase", purchaseNum);
	}

	@Override
	public void addCart(CartVO cart) {
		sqlSessionTemplate.insert("main.project.web.purchase.dao.IPurchaseDAO.addCart",cart);
	}

	@Override
	public List<CartVO> selectMyCart(String memberId) {
		return sqlSessionTemplate.selectList("main.project.web.purchase.dao.IPurchaseDAO.selectMyCart", memberId);
	}

	@Override
	public void deleteCart(String cartNum) {
		sqlSessionTemplate.delete("main.project.web.purchase.dao.IPurchaseDAO.deleteCart", cartNum);
	}

	@Override
	public void checkOut(String memberId) {
		sqlSessionTemplate.delete("main.project.web.purchase.dao.IPurchaseDAO.checkOut", memberId);
	}

	@Override
	public List<PurchaseVO> purchaseFindList(findVO find) {
		return sqlSessionTemplate.selectList("main.project.web.purchase.dao.IPurchaseDAO.purchaseFindList", find);
	}

	@Override
	public Integer totalPoint() {
		return sqlSessionTemplate.selectOne("main.project.web.purchase.dao.IPurchaseDAO.totalPoint");
	}

	@Override
	public Integer totalCountPurchase() {
		return sqlSessionTemplate.selectOne("main.project.web.purchase.dao.IPurchaseDAO.totalCountPurchase");
	}
	@Override
	public int countPurchase() {
		return sqlSessionTemplate.selectOne("main.project.web.purchase.dao.IPurchaseDAO.countPurchase");
	}
	@Override
	public List<PurchaseVO> purchasePage(int displayPost, int postNum)throws Exception {
		HashMap data = new HashMap();
		data.put("displayPost", displayPost);
		data.put("postNum", postNum);
		return sqlSessionTemplate.selectList(namespace + ".purchasePage", data);
	}
	
	@Override
	public Integer Id_totalCountPurchase(String id) {
		return sqlSessionTemplate.selectOne("main.project.web.purchase.dao.IPurchaseDAO.Id_totalCountPurchase", id);
	}

	@Override
	public Integer Id_totalPurchasePrice(String id) {
		return sqlSessionTemplate.selectOne("main.project.web.purchase.dao.IPurchaseDAO.Id_totalPurchasePrice", id);
	}

	@Override
	public Integer Id_PurchaseCount(String id) {
		return sqlSessionTemplate.selectOne("main.project.web.purchase.dao.IPurchaseDAO.Id_PurchaseCount", id);
	}

	@Override
	public Integer Id_totalSalesPrice(String id) {
		return sqlSessionTemplate.selectOne("main.project.web.purchase.dao.IPurchaseDAO.Id_totalSalesPrice", id);
	}

	@Override
	public Integer date_totalSales(String findDate) {
		return sqlSessionTemplate.selectOne("main.project.web.purchase.dao.IPurchaseDAO.date_totalSales", findDate);
	}

	@Override
	public Integer productNum_PurchaseCount(String product_num) {
		return sqlSessionTemplate.selectOne("main.project.web.purchase.dao.IPurchaseDAO.productNum_PurchaseCount", product_num);
	}

	
	public CartVO getCart(String cartNum) {
		return sqlSessionTemplate.selectOne("main.project.web.purchase.dao.IPurchaseDAO.getCart", cartNum);
	}

	@Override
	public List<PurchaseVO> selectPurchaseList(String memberId) {
		return sqlSessionTemplate.selectList("main.project.web.purchase.dao.IPurchaseDAO.selectPurchaseList", memberId);
	}

	@Override
	public List<PurchaseVO> selectMemberOrder(PurchaseVO purchase) {
		return sqlSessionTemplate.selectList("main.project.web.purchase.dao.IPurchaseDAO.selectMemberOrder", purchase);
	}

	@Override
	public List<PurchaseVO> selectExpertPurchase(String expertId) {
		return sqlSessionTemplate.selectList("main.project.web.purchase.dao.IPurchaseDAO.selectExpertPurchase", expertId);
	}

	@Override
	public List<PurchaseVO> selectExpertOrder(PurchaseVO purchase) {
		return sqlSessionTemplate.selectList("main.project.web.purchase.dao.IPurchaseDAO.selectExpertOrder", purchase);
	}

}
