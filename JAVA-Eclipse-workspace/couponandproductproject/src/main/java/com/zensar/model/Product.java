package com.zensar.model;

import java.math.BigDecimal;
import java.text.Bidi;

public class Product {
	private int productId;
	private String productName;
	private String productDescription;
	private BigDecimal productPrice;
	private String couponCode;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int productId, String productName, String productDescription, BigDecimal productPrice,
			String couponCode) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.couponCode = couponCode;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	@Override
	public String toString() {
		return "<h2>Product Details</h2>"+"productName=" + productName + "<br> productDescription="
				+ productDescription + "<br> productPrice=" + productPrice + "<br> couponCode=" + couponCode;
	}

}
