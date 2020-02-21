package main.project.web.chat.vo;

import java.util.Date;

public class RoomListVO {
	private String room_id;
	private String expert_id;
	private String member_id;
	private Date room_date;
	
	public RoomListVO(String room_id, String expert_id, String member_id) {
		this.room_id = room_id;
		this.expert_id = expert_id;
		this.member_id = member_id;
	}
	public String getRoom_id() {
		return room_id;
	}
	public void setRoom_id(String room_id) {
		this.room_id = room_id;
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
	public Date getRoom_date() {
		return room_date;
	}
	public void setRoom_date(Date room_date) {
		this.room_date = room_date;
	}
	
	@Override
	public String toString() {
		return "RoomListVO [room_id=" + room_id + ", expert_id=" + expert_id + ", member_id=" + member_id
				+ ", room_date=" + room_date + "]";
	}
	
	
}
