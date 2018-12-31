package com.openlab.domain;

public class CategoryBean {

	private int categoryId;
	private String name;
	
	public CategoryBean() {
		super();
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

	@Override
	public String toString() {
		return "CategoryBean [categoryId=" + categoryId + ", name=" + name
				+ "]";
	}
	
	
	
}
