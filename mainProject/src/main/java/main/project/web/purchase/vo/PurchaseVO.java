package main.project.web.purchase.vo;

import java.util.Date;

public class PurchaseVO {
	private String purchase_num;
	private String product_num;
	private Date purchase_date;
	private String purchase_state;
	private String member_id;
	private Integer purchase_price;
	
	public PurchaseVO() {}
	
	public PurchaseVO(String purchase_num, String product_num, String purchase_state, String member_id, Integer purchase_price) {
		this.purchase_num = purchase_num;
		this.product_num = product_num;
		this.purchase_state = purchase_state;
		this.member_id = member_id;
		this.purchase_price = purchase_price;
	}



	public String getPurchase_num() {
		return purchase_num;
	}
	public void setPurchase_num(String purchase_num) {
		this.purchase_num = purchase_num;
	}
	public String getProduct_num() {
		return product_num;
	}
	public void setProduct_num(String product_num) {
		this.product_num = product_num;
	}
	public Date getPurchase_date() {
		return purchase_date;
	}
	public void setPurchase_date(Date purchase_date) {
		this.purchase_date = purchase_date;
	}
	public String getPurchase_state() {
		return purchase_state;
	}
	public void setPurchase_state(String purchase_state) {
		this.purchase_state = purchase_state;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public Integer getPurchase_price() {
		return purchase_price;
	}
	public void setPurchase_price(Integer purchase_price) {
		this.purchase_price = purchase_price;
	}
	@Override
	public String toString() {
		return "PurchaseVO [purchase_num=" + purchase_num + ", product_num=" + product_num + ", purchase_date="
				+ purchase_date + ", purchase_state=" + purchase_state + ", member_id=" + member_id
				+ ", purchase_price=" + purchase_price + "]";
	}
	
	
}
