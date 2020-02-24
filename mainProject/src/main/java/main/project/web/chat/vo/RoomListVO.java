package main.project.web.chat.vo;

import java.util.Date;

public class RoomListVO {
	private String room_id;
	private String room_title;
	private String expert_id;
	private String member_id;
	private String product_id;
	private Date room_date;
	
	public RoomListVO() {}
	
	public RoomListVO(String member_id, String product_id) {
		this.member_id = member_id;
		this.product_id = product_id;
	}
	public RoomListVO(String room_id,String room_title, String expert_id, String member_id, String product_id) {
		this.room_id = room_id;
		this.room_title = room_title;
		this.expert_id = expert_id;
		this.member_id = member_id;
		this.product_id = product_id;
	}
	public String getRoom_id() {
		return room_id;
	}
	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}
	public String getRoom_title() {
		return room_title;
	}
	public void setRoom_title(String room_title) {
		this.room_title = room_title;
	}
	public String getExpert_id() {
		return expert_id;
	}
	public void setExpert_id(String expert_id) {
		this.expert_id = expert_id;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public Date getRoom_date() {
		return room_date;
	}
	public void setRoom_date(Date room_date) {
		this.room_date = room_date;
	}

	@Override
	public String toString() {
		return "RoomListVO [room_id=" + room_id + ", room_title=" + room_title + ", expert_id=" + expert_id
				+ ", member_id=" + member_id + ", product_id=" + product_id + ", room_date=" + room_date + "]";
	}
	
	
	

	
	
}
