package com.zensar.order.processing.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.zensar.order.processing.beans.Order;
import com.zensar.order.processing.exceptions.OrderNotFoundException;
import com.zensar.order.processing.jdbc.ConnectionProvider;

public class OrderRepositoryJDBCImpl implements OrderRepository {
	static int orderId = 100;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Connection con = ConnectionProvider.getConnection();

	@Override
	public int createOrder(Order order) {
		Random rand = new Random();
		int random = rand.nextInt(50);
		order.setOrderId(random);
		try {
			pstmt = con.prepareStatement("insert into orders values(?,?,?,?,?)");
			pstmt.setInt(1, order.getOrderId());
			pstmt.setString(2, order.getOrderName());
			pstmt.setDouble(3, order.getOrderPrice());
			pstmt.setInt(4, order.getOrderQuantity());
			pstmt.setString(5, order.getOrderDate());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return order.getOrderId();

	}

	@Override
	public Order[] displayAllOrders() {
		List<Order> list = new ArrayList<Order>();

		try {
			pstmt = con.prepareStatement("select * from orders");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Order(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Order[] order = new Order[list.size()];
		order = list.toArray(order);
		return order;
	}

	@Override
	public Order getOrder(int orderId) throws OrderNotFoundException {
		Order order = null;
		try {
			pstmt = con.prepareStatement("select * from orders where orderId=?");
			pstmt.setInt(1, orderId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				order = new Order(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5));
				return order;
			} else {
				throw new OrderNotFoundException("Order Not Found");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order;
	}

	@Override
	public Order updateOrder(int orderId) throws OrderNotFoundException {
		Scanner sc = new Scanner(System.in);
		Order order = null;
		try {
			pstmt = con.prepareStatement("select orderId from orders where orderId=?");
			pstmt.setInt(1, orderId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("Please Enter new Price of an Order:");
				double orderPrice = sc.nextDouble();
				System.out.println("Please Enter new Quantity of an Order:");
				int orderQuantity = sc.nextInt();
				try {
					pstmt = con.prepareStatement("update orders set orderPrice=?,orderQuantity=? where orderId=?");
					pstmt.setDouble(1, orderPrice);
					pstmt.setInt(2, orderQuantity);
					pstmt.setInt(3, orderId);
					int ch = pstmt.executeUpdate();
					if (ch > 0) {
						pstmt = con.prepareStatement("select * from orders where orderId=?");
						pstmt.setInt(1, orderId);
						rs = pstmt.executeQuery();
						if (rs.next()) {
							order = new Order(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4),
									rs.getString(5));
							return order;
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {
				throw new OrderNotFoundException("Order Not Found");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return order;
	}

	@Override
	public boolean deleteOrder(int orderId) throws OrderNotFoundException {

		try {
			pstmt = con.prepareStatement("delete from orders where orderId=?");
			pstmt.setInt(1, orderId);
			int ch = pstmt.executeUpdate();
			if (ch > 0) {
				return true;
			} else {
				throw new OrderNotFoundException("Order Not Found");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	protected void finalize() throws Throwable {

		super.finalize();
		if (rs != null) {
			rs.close();
		}
		if (pstmt != null) {
			pstmt.close();
		}
		if (con != null) {
			con.close();
		}
	}

}
