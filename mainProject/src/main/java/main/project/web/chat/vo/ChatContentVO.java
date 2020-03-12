package main.project.web.chat.vo;

import java.util.Date;

public class ChatContentVO {
	private Integer chat_seq;
	private String room_id;
	private String send;
	private String receive;
	private String content;
	private Date chat_date;
	private String read_state;
	private String s_id;
	private String r_id;
	
	public ChatContentVO(){}
		
	public ChatContentVO(String room_id, String r_id,String read_state) {
		this.room_id = room_id;
		this.r_id = r_id;
		this.read_state = read_state;
	}

	public ChatContentVO(Integer chat_seq, String room_id, String send, String receive, String content,
			String read_state, String s_id, String r_id) {
		this.chat_seq = chat_seq;
		this.room_id = room_id;
		this.send = send;
		this.receive = receive;
		this.content = content;
		this.read_state = read_state;
		this.s_id = s_id;
		this.r_id = r_id;
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
	public String getRead_state() {
		return read_state;
	}
	public void setRead_state(String read_state) {
		this.read_state = read_state;
	}
	public String getS_id() {
		return s_id;
	}

	public void setS_id(String s_id) {
		this.s_id = s_id;
	}

	public String getR_id() {
		return r_id;
	}

	public void setR_id(String r_id) {
		this.r_id = r_id;
	}

	@Override
	public String toString() {
		return "ChatContentVO [chat_seq=" + chat_seq + ", room_id=" + room_id + ", send=" + send + ", receive="
				+ receive + ", content=" + content + ", chat_date=" + chat_date + ", read_state=" + read_state
				+ ", s_id=" + s_id + ", r_id=" + r_id + "]";
	}

	
}
