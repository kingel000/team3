package main.project.web.member.vo;

public class MemberFindVO {
	
	private String category;
	private String value;
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "MemberFindVO [category=" + category + ", value=" + value + "]";
	}
	
	
	
	

}
