package main.project.web.chat.vo;

import java.util.Date;

public class ChatContentVO {
	private Integer chat_seq;
	private String room_id;
	private String send;
	private String receive;
	private String content;
	private Integer line;
	private Date chat_date;
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
	public Integer getLine() {
		return line;
	}
	public void setLine(Integer line) {
		this.line = line;
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
				+ receive + ", content=" + content + ", line=" + line + ", chat_date=" + chat_date + "]";
	}
	
	
}
