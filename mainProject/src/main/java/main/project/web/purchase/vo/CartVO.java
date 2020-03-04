package main.project.web.purchase.vo;

public class CartVO {
	private String num;
	private String member_id;
	private String product_num;
	private String product_title;
	private Integer price;
	
	public CartVO() {}
	
	
	public CartVO(String num, String member_id, String product_num, String product_title, Integer price) {
		this.num = num;
		this.member_id = member_id;
		this.product_num = product_num;
		this.product_title = product_title;
		this.price = price;
	}


	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getProduct_num() {
		return product_num;
	}
	public void setProduct_num(String product_num) {
		this.product_num = product_num;
	}
	public String getProduct_title() {
		return product_title;
	}
	public void setProduct_title(String product_title) {
		this.product_title = product_title;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "CartVO [num=" + num + ", member_id=" + member_id + ", product_num=" + product_num + ", product_title="
				+ product_title + ", price=" + price + "]";
	}
	
	
}