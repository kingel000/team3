package main.project.admin.Board.vo;

import java.util.Date;

public class adminBoardNoticeVO {
	private Integer board_notice_num;	//���� ��ȣ
	private String board_notice_title;	//���� ����
	private String board_notice_info;	//���� ����
	private String board_notice_file;	//���� ÷������
	private Date board_notice_date;		//���� ��ϳ�¥
	public Integer getBoard_notice_num() {
		return board_notice_num;
	}
	public void setBoard_notice_num(Integer board_notice_num) {
		this.board_notice_num = board_notice_num;
	}
	public String getBoard_notice_title() {
		return board_notice_title;
	}
	public void setBoard_notice_title(String board_notice_title) {
		this.board_notice_title = board_notice_title;
	}
	public String getBoard_notice_info() {
		return board_notice_info;
	}
	public void setBoard_notice_info(String board_notice_info) {
		this.board_notice_info = board_notice_info;
	}
	public String getBoard_notice_file() {
		return board_notice_file;
	}
	public void setBoard_notice_file(String board_notice_file) {
		this.board_notice_file = board_notice_file;
	}
	public Date getBoard_notice_date() {
		return board_notice_date;
	}
	public void setBoard_notice_date(Date board_notice_date) {
		this.board_notice_date = board_notice_date;
	}
	@Override
	public String toString() {
		return "adminBoardNoticeVO [board_notice_num=" + board_notice_num + ", board_notice_title=" + board_notice_title
				+ ", board_notice_info=" + board_notice_info + ", board_notice_file=" + board_notice_file
				+ ", board_notice_date=" + board_notice_date + "]";
	}
	
	
	
	
	
}

