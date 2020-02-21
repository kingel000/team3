package main.project.web.chat.vo;

public class RoomLocationVO {
	private String member_id;
	private String room_id;
	private String location_date;
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getRoom_id() {
		return room_id;
	}
	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}
	public String getLocation_date() {
		return location_date;
	}
	public void setLocation_date(String location_date) {
		this.location_date = location_date;
	}
	
	@Override
	public String toString() {
		return "RoomLocation [member_id=" + member_id + ", room_id=" + room_id + ", location_date=" + location_date
				+ "]";
	}
	
	
}
