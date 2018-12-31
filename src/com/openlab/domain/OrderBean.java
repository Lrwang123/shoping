package com.openlab.domain;

import java.sql.Timestamp;
import java.util.List;

public class OrderBean {

	private int orderId;
	private int categoryNum;
	private String username;
	private String consignee;//收件人
	private String consigneeAddress;
	private String tel;
	private Timestamp createDate;
	private String comment;//备注
	private List<OrderDetailBean> orderDetails;
	
	public OrderBean() {
		super();
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCategoryNum() {
		return categoryNum;
	}

	public void setCategoryNum(int categoryNum) {
		this.categoryNum = categoryNum;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getConsigneeAddress() {
		return consigneeAddress;
	}

	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public List<OrderDetailBean> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetailBean> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@Override
	public String toString() {
		return "OrderBean [orderId=" + orderId + ", categoryNum=" + categoryNum
				+ ", username=" + username + ", consignee=" + consignee
				+ ", consigneeAddress=" + consigneeAddress + ", tel=" + tel
				+ ", createDate=" + createDate + ", comment=" + comment
				+ ", orderDetails=" + orderDetails + "]";
	}
	
	
	
}
