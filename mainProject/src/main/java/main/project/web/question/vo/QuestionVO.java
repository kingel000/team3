package main.project.web.question.vo;

import java.util.Date;

public class QuestionVO {
	private String board_question_num;
	private String category;
	private String board_question_title;
	private String board_question_info;
	private String board_question_file;
	private Date board_question_date;
	private String board_question_writer;
	
	public String getBoard_question_num() {
		return board_question_num;
	}
	public void setBoard_question_num(String board_question_num) {
		this.board_question_num = board_question_num;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBoard_question_title() {
		return board_question_title;
	}
	public void setBoard_question_title(String board_question_title) {
		this.board_question_title = board_question_title;
	}
	public String getBoard_question_info() {
		return board_question_info;
	}
	public void setBoard_question_info(String board_question_info) {
		this.board_question_info = board_question_info;
	}
	public String getBoard_question_file() {
		return board_question_file;
	}
	public void setBoard_question_file(String board_question_file) {
		this.board_question_file = board_question_file;
	}
	public Date getBoard_question_date() {
		return board_question_date;
	}
	public void setBoard_question_date(Date board_question_date) {
		this.board_question_date = board_question_date;
	}
	public String getBoard_question_writer() {
		return board_question_writer;
	}
	public void setBoard_question_writer(String board_question_writer) {
		this.board_question_writer = board_question_writer;
	}
	
	@Override
	public String toString() {
		return "QuestionVO [board_question_num=" + board_question_num + ", category=" + category
				+ ", board_question_title=" + board_question_title + ", board_question_info=" + board_question_info
				+ ", board_question_file=" + board_question_file + ", board_question_date=" + board_question_date
				+ ", board_question_writer=" + board_question_writer + "]";
	}
}
