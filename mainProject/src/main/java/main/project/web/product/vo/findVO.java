package main.project.web.product.vo;

public class findVO {
	private String category;
	private String findText;
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getFindText() {
		return findText;
	}
	public void setFindText(String findText) {
		this.findText = findText;
	}
	@Override
	public String toString() {
		return "findVO [category=" + category + ", findText=" + findText + "]";
	}
	
	
}
