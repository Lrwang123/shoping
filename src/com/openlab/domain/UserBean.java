package com.openlab.domain;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UserBean {

	private int userId;
	@NotNull
	private String username;
	@NotNull
	private String name;
	@NotNull
	private String password;
	private String city;
	private String address;
	private String idNum;//身份证号
	private int grade;//会员积分
	private double account;//账户余额
	@NotNull
	private String tel;
	@NotNull
	@Pattern(regexp = "^([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)*@"
			+ "([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)+[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?$",
			message="邮件格式错误")
	private String email;
	private List<OrderBean> orders;//订单
	
	public UserBean() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public double getAccount() {
		return account;
	}

	public void setAccount(double account) {
		this.account = account;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<OrderBean> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderBean> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "UserBean [userId=" + userId + ", username=" + username
				+ ", name=" + name + ", password=" + password + ", city="
				+ city + ", address=" + address + ", idNum=" + idNum
				+ ", grade=" + grade + ", account=" + account + ", tel=" + tel
				+ ", email=" + email + ", orders=" + orders + "]";
	}

	
	
}
