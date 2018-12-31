package com.openlab.domain;

public class CategoryDetailBean {

	private int categoryDetailId;
	private int categoryId;
	private String name;
	private CategoryBean category;
	
	public CategoryDetailBean() {
		super();
	}

	public int getCategoryDetailId() {
		return categoryDetailId;
	}

	public void setCategoryDetailId(int categoryDetailId) {
		this.categoryDetailId = categoryDetailId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CategoryBean getCategory() {
		return category;
	}

	public void setCategory(CategoryBean category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "CategoryDetailBean [categoryDetailId=" + categoryDetailId
				+ ", categoryId=" + categoryId + ", name=" + name + "]";
	}
	
	
	
}
