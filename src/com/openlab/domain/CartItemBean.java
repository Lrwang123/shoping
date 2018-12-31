package com.openlab.domain;

public class CartItemBean {
	
	private ProductBean product;
	private int num;
	public CartItemBean() {
		super();
	}
	public ProductBean getProduct() {
		return product;
	}
	public void setProduct(ProductBean product) {
		this.product = product;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "CartItemBean [productBean=" + product + ", num=" + num
				+ "]";
	}
	
	
	
}
