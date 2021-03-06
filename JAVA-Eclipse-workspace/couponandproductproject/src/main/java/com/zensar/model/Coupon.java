package com.zensar.model;

import java.math.BigDecimal;

public class Coupon {
	private int couponId;
	private String couponCode;
	private BigDecimal couponDiscount;
	private String couponEXPDate;

	public Coupon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Coupon(int couponId, String couponCode, BigDecimal couponDiscount, String couponEXPDate) {
		super();
		this.couponId = couponId;
		this.couponCode = couponCode;
		this.couponDiscount = couponDiscount;
		this.couponEXPDate = couponEXPDate;
	}

	public int getCouponId() {
		return couponId;
	}

	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public BigDecimal getCouponDiscount() {
		return couponDiscount;
	}

	public void setCouponDiscount(BigDecimal couponDiscount) {
		this.couponDiscount = couponDiscount;
	}

	public String getCouponEXPDate() {
		return couponEXPDate;
	}

	public void setCouponEXPDate(String couponEXPDate) {
		this.couponEXPDate = couponEXPDate;
	}

	@Override
	public String toString() {
		return "<h2>Coupon Details</h2>"+"Coupon couponId=" + couponId + "<br> couponCode=" + couponCode + "<br> couponDiscount=" + couponDiscount
				+ "<br> couponEXPDate=" + couponEXPDate ;
	}

}
