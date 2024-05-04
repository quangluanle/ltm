package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Database.DBConnect;
import Model.Product;

public class OdersDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public int getSumProductsByMonth(int month) {
		String query = "SELECT SUM(soluong) AS TongSoLuong FROM [Vegefoods].[dbo].[Order_Details] WHERE MONTH(ngaymua) = ?";
		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, month);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public double getSumRevenueByMonth(int month) {
		String query = "SELECT SUM(thanhtien) AS TongSoLuong FROM [Vegefoods].[dbo].[Order_Details] WHERE MONTH(ngaymua) = ?";
		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, month);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int getSumProductsByYear() {
		String query = "SELECT SUM(soluong) AS TongSoSanPham FROM [Vegefoods].[dbo].[Order_Details] WHERE YEAR(ngaymua) = YEAR(GETDATE())";
		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public double getSumRevenueByYear() {
		String query = "SELECT SUM(thanhtien) AS TongDoanhThu FROM [Vegefoods].[dbo].[Order_Details] WHERE YEAR(ngaymua) = YEAR(GETDATE())";
		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int getSumProductsByMonth() {
		String query = "SELECT SUM(soluong) AS TongSoSanPham FROM [Vegefoods].[dbo].[Order_Details] WHERE MONTH(ngaymua) = MONTH(GETDATE()) AND YEAR(ngaymua) = YEAR(GETDATE())";
		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public double getSumRevenueThisMonth() {
		String query = "SELECT SUM(thanhtien) AS TongDoanhThu FROM [Vegefoods].[dbo].[Order_Details] WHERE MONTH(ngaymua) = MONTH(GETDATE()) AND YEAR(ngaymua) = YEAR(GETDATE())";
		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
