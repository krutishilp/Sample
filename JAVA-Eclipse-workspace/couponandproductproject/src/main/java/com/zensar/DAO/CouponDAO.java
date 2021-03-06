package com.zensar.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zensar.model.Coupon;
import com.zensar.util.ConnectionProvider;

public class CouponDAO {
	private Connection con=ConnectionProvider.getConnection();
	public Coupon createCoupon(Coupon coupon) {
		try {
			PreparedStatement preparedStatement = con.prepareStatement("insert into coupons(couponName,couponDiscount,couponEXPDate) values(?,?,?)");
			preparedStatement.setString(1,coupon.getCouponCode());
			preparedStatement.setBigDecimal(2, coupon.getCouponDiscount());
			preparedStatement.setString(3, coupon.getCouponEXPDate());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return coupon;
		
	}
	
	public Coupon findCoupon(String couponCode) {
		Coupon coupon=null;
		try {
			PreparedStatement preparedStatement = con.prepareStatement("select * from coupons where couponName=?");
			preparedStatement.setString(1, couponCode);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				coupon=new Coupon(resultSet.getInt(1), resultSet.getString(2), resultSet.getBigDecimal(3), resultSet.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return coupon;
		
	}
}
