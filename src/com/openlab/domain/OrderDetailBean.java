package com.openlab.domain;

public class OrderDetailBean {

	private int orderDetailId;
	private long orderId;
	private int productId;
	private double price;
	private int num;//数量
	private ProductBean product;
	
	public OrderDetailBean() {
		super();
	}

	public int getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public ProductBean getProduct() {
		return product;
	}

	public void setProduct(ProductBean product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "OrderDetailBean [orderDetailId=" + orderDetailId + ", orderId="
				+ orderId + ", productId=" + productId + ", price=" + price
				+ ", num=" + num + ", product=" + product + "]";
	}
	
	
	
}
