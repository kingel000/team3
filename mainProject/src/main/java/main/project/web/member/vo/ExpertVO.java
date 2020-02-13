package main.project.web.member.vo;

public class ExpertVO {
	private String id;
	private String name;
	private String tel;
	private String career;
	private int point;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	@Override
	public String toString() {
		return "ExpertVO [id=" + id + ", name=" + name + ", tel=" + tel + ", career=" + career + ", point=" + point
				+ "]";
	}
	
}
