package com.openlab.domain;

import java.sql.Timestamp;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ProductBean {

	private int productId;
	@NotNull
	@Min(1)
	private int categoryDetailId;
	@NotNull
	private String name;
	@NotNull
	private String info;
	@NotNull
	@Min(0)
	private double price;//原价998
	@NotNull
	@Min(0)
	private double priceNow;//现价只要88
	private String image;
	private Timestamp createDate;
	@NotNull
	private int isNew;
	@NotNull
	private int isPromotion;
	private int hit;//点击量
	private CategoryDetailBean categoryDetail;
	
	public ProductBean() {
		super();
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCategoryDetailId() {
		return categoryDetailId;
	}

	public void setCategoryDetailId(int categoryDetailId) {
		this.categoryDetailId = categoryDetailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPriceNow() {
		return priceNow;
	}

	public void setPriceNow(double priceNow) {
		this.priceNow = priceNow;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public int getIsNew() {
		return isNew;
	}

	public void setIsNew(int isNew) {
		this.isNew = isNew;
	}

	public int getIsPromotion() {
		return isPromotion;
	}

	public void setIsPromotion(int isPromotion) {
		this.isPromotion = isPromotion;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public CategoryDetailBean getCategoryDetail() {
		return categoryDetail;
	}

	public void setCategoryDetail(CategoryDetailBean categoryDetail) {
		this.categoryDetail = categoryDetail;
	}

	@Override
	public String toString() {
		return "ProductBean [productId=" + productId + ", categoryDetailId="
				+ categoryDetailId + ", name=" + name + ", info=" + info
				+ ", price=" + price + ", priceNow=" + priceNow + ", image="
				+ image + ", createDate=" + createDate + ", isNew=" + isNew
				+ ", isPromotion=" + isPromotion + ", hit=" + hit + "]";
	}
	
	
	
	
}
