package main.project.web.purchase.vo;

public class CartVO {
	private String num;
	private String member_id;
	private String product_num;
	private String product_title;
	private Integer price;
	private String expert_nick;
	private String thumbnail;
	public CartVO() {}
	
	
	public CartVO(String num, String member_id, String product_num, String product_title, Integer price, String expert_nick,String Thumbnail) {
		this.num = num;
		this.member_id = member_id;
		this.product_num = product_num;
		this.product_title = product_title;
		this.price = price;
		this.expert_nick = expert_nick;
		this.thumbnail = Thumbnail;
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
	public String getExpert_nick() {
		return expert_nick;
	}
	public void setExpert_nick(String expert_nick) {
		this.expert_nick = expert_nick;
	}
	

	public String getThumbnail() {
		return thumbnail;
	}


	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}	

	@Override
	public String toString() {
		return "CartVO [num=" + num + ", member_id=" + member_id + ", product_num=" + product_num + ", product_title="
				+ product_title + ", price=" + price + ", expert_nick=" + expert_nick + ", thumbnail=" +  thumbnail +"]";
	}


	
}
