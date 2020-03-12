package main.project.web.product.vo;

import java.util.Date;

public class ProductVO {
	private String product_num;
	private String category;
	private String product_title;
	private String expert_id;
	private String product_info;
	private Date product_date;
	private String thumbnail;

	public String getProduct_num() {
		return product_num;
	}

	public void setProduct_num(String product_num) {
		this.product_num = product_num;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getProduct_title() {
		return product_title;
	}

	public void setProduct_title(String product_title) {
		this.product_title = product_title;
	}

	public String getExpert_id() {
		return expert_id;
	}

	public void setExpert_id(String expert_id) {
		this.expert_id = expert_id;
	}

	public String getProduct_info() {
		return product_info;
	}

	public void setProduct_info(String product_info) {
		this.product_info = product_info;
	}

	public Date getProduct_date() {
		return product_date;
	}

	public void setProduct_date(Date product_date) {
		this.product_date = product_date;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	@Override
	public String toString() {
		return "ProductVO [product_num=" + product_num + ", category=" + category + ", product_title=" + product_title
				+ ", expert_id=" + expert_id + ", product_info=" + product_info + ", product_date=" + product_date + ", thumbnail =" + thumbnail + "]";
	
	}
	

}
