package main.project.web.point.vo;

import java.sql.Date;

public class PointVO {
	
	private Integer p_num;
	private String expert_id;
	private Integer p_point;
	private Date p_date;
	private String p_state;
	private Integer rNum;
	public PointVO() {}

	
	public PointVO(Integer p_num, String expert_id, Integer p_point, String p_state) {
		super();
		this.p_num = p_num;
		this.expert_id = expert_id;
		this.p_point = p_point;
		this.p_state = p_state;
	}


	public Integer getP_num() {
		return p_num;
	}
	public void setP_num(Integer p_num) {
		this.p_num = p_num;
	}
	public String getExpert_id() {
		return expert_id;
	}
	public void setExpert_id(String expert_id) {
		this.expert_id = expert_id;
	}
	public Integer getP_point() {
		return p_point;
	}
	public void setP_point(Integer p_point) {
		this.p_point = p_point;
	}
	public Date getP_date() {
		return p_date;
	}
	public void setP_date(Date p_date) {
		this.p_date = p_date;
	}
	public String getP_state() {
		return p_state;
	}
	public void setP_state(String p_state) {
		this.p_state = p_state;
	}
	public Integer getrNum() {
		return rNum;
	}
	public void setrNum(Integer rNum) {
		this.rNum = rNum;
	}

	@Override
	public String toString() {
		return "PointVO [p_num=" + p_num + ", expert_id=" + expert_id + ", p_point=" + p_point + ", p_date=" + p_date
				+ ", p_state=" + p_state + "]";
	}

	
	
	
	

}
