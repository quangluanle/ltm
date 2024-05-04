package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Database.DBConnect;
import Model.Category;

public class CategoryDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<Category> findAllCategory() {
		String query = "SELECT * FROM Categories";
		List<Category> categories;
		try {
			categories = new ArrayList<>();
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				categories.add(new Category(rs.getInt(1), rs.getString(2)));
			}

			return categories;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
