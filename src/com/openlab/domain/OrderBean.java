package com.openlab.domain;

import java.sql.Timestamp;
import java.util.List;

public class OrderBean {

	private long orderId;
	private int categoryNum;
	private String username;
	private String consignee;//收件人
	private String consigneeAddress;
	private String tel;
	private Timestamp createDate;
	private String comment;//备注
	private List<OrderDetailBean> orderDetails;
	
	
	
	/**
	 * @return the orderId
	 */
	public long getOrderId() {
		return orderId;
	}



	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}



	/**
	 * @return the categoryNum
	 */
	public int getCategoryNum() {
		return categoryNum;
	}



	/**
	 * @param categoryNum the categoryNum to set
	 */
	public void setCategoryNum(int categoryNum) {
		this.categoryNum = categoryNum;
	}



	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}



	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}



	/**
	 * @return the consignee
	 */
	public String getConsignee() {
		return consignee;
	}



	/**
	 * @param consignee the consignee to set
	 */
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}



	/**
	 * @return the consigneeAddress
	 */
	public String getConsigneeAddress() {
		return consigneeAddress;
	}



	/**
	 * @param consigneeAddress the consigneeAddress to set
	 */
	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}



	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}



	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}



	/**
	 * @return the createDate
	 */
	public Timestamp getCreateDate() {
		return createDate;
	}



	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}



	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}



	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}



	/**
	 * @return the orderDetails
	 */
	public List<OrderDetailBean> getOrderDetails() {
		return orderDetails;
	}



	/**
	 * @param orderDetails the orderDetails to set
	 */
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
