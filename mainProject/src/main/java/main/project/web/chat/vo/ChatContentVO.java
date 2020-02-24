package main.project.web.chat.vo;

import java.util.Date;

public class ChatContentVO {
	private Integer chat_seq;
	private String room_id;
	private String send;
	private String receive;
	private String content;
	private Date chat_date;
	
	public ChatContentVO(){}
	
	public ChatContentVO(Integer chat_seq,String room_id, String send, String receive, String content) {
		this.chat_seq = chat_seq;
		this.room_id = room_id;
		this.send = send;
		this.receive = receive;
		this.content = content;
	}
	
	public Integer getChat_seq() {
		return chat_seq;
	}
	public void setChat_seq(Integer chat_seq) {
		this.chat_seq = chat_seq;
	}
	public String getRoom_id() {
		return room_id;
	}
	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}
	public String getSend() {
		return send;
	}
	public void setSend(String send) {
		this.send = send;
	}
	public String getReceive() {
		return receive;
	}
	public void setReceive(String receive) {
		this.receive = receive;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getChat_date() {
		return chat_date;
	}
	public void setChat_date(Date chat_date) {
		this.chat_date = chat_date;
	}

	@Override
	public String toString() {
		return "ChatContentVO [chat_seq=" + chat_seq + ", room_id=" + room_id + ", send=" + send + ", receive="
				+ receive + ", content=" + content + ", chat_date=" + chat_date + "]";
	}
	
	
	
}
