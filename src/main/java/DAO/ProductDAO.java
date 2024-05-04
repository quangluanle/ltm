package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Database.DBConnect;
import Model.Product;

public class ProductDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Statement st = null;

	public List<Product> findTop8product() {
		String query = "SELECT TOP (8) * FROM Products";
		List<Product> products;
		try {
			products = new ArrayList<>();
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);

			rs = ps.executeQuery();

			while (rs.next()) {
				products.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4),
						rs.getString(5), rs.getInt(6), rs.getBoolean(7), rs.getBoolean(8)));
			}

			return products;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Product> findAllproduct() {
		String query = "SELECT * FROM Products";
		List<Product> products;
		try {
			products = new ArrayList<>();
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);

			rs = ps.executeQuery();

			while (rs.next()) {
				products.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4),
						rs.getString(5), rs.getInt(6), rs.getBoolean(7), rs.getBoolean(8)));
			}

			return products;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Product getByProductId(int id) {
		String query = "SELECT * FROM Products WHERE product_id = ?";

		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getString(5),
						rs.getInt(6), rs.getBoolean(7), rs.getBoolean(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Product> getRelatedProductById(int cate_id) {
		String query = "SELECT * FROM Products WHERE cate_id = ?";
		List<Product> products;
		try {
			products = new ArrayList<>();
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, cate_id);
			rs = ps.executeQuery();

			while (rs.next()) {
				products.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4),
						rs.getString(5), rs.getInt(6), rs.getBoolean(7), rs.getBoolean(8)));
			}

			return products;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean saveProduct(Product product) {
		String query = "INSERT [dbo].[Products] ([name], [description], [price], [image], [cate_id], [isWish], [state]) VALUES (?,?, ?, ?, ?, 0,1)";

		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, product.getName());
			ps.setString(2, product.getDescription());
			ps.setDouble(3, product.getPrice());
			ps.setString(4, product.getImage());
			ps.setInt(5, product.getCate_id());

			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean updateProduct(Product product) {
		String query = "UPDATE [dbo].[Products] SET [name] = ?,[description]= ?, [price]= ?,"
				+ "[image]= ?, [cate_id]=?, [isWish]=0, [state]=1 WHERE [product_id]= ?";
		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, product.getName());
			ps.setString(2, product.getDescription());
			ps.setDouble(3, product.getPrice());
			ps.setString(4, product.getImage());
			ps.setInt(5, product.getCate_id());
			ps.setInt(6, product.getProduct_id());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
//	public boolean updateProduct(Product product) {
//		String query = "UPDATE [dbo].[Products] SET [name] = N'" + product.getName() + "'," + "[description] = N'"
//				+ product.getDescription() + "'," + "[price] = " + product.getPrice() + "," + "[image] = N'"
//				+ product.getImage() + "'," + "[cate_id] = " + product.getCate_id() + "," + "[isWish] = 0,"
//				+ "[state] = 1 WHERE [product_id] = " + product.getProduct_id();
//		System.out.println("query = " + query);
//		try {
//			new DBConnect();
//			conn = DBConnect.getConnection();
//			st = conn.createStatement();
//			st.executeUpdate(query);
//			return true;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return false;
//	}

	public boolean deleteProduct(String id) {
		String query = "UPDATE [dbo].[Products] SET [state]=0 WHERE [product_id]= ?";
		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public int countFromProducts() {
		String query = "SELECT COUNT(*) FROM Products";

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

	public List<Product> search(String keyword) {
		List<Product> products = new ArrayList<>();
		String query = "SELECT * FROM Products WHERE description like ? or name like ?";

		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, "%" + keyword + "%");
			ps.setString(2, "%" + keyword + "%");
			rs = ps.executeQuery();

			while (rs.next()) {
				products.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4),
						rs.getString(5), rs.getInt(6), rs.getBoolean(7), rs.getBoolean(8)));
			}

			return products;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Product> paging(int index) {
		List<Product> products = new ArrayList<>();
		String query = "  SELECT * FROM Products\r\n" + "				 ORDER BY product_id\r\n"
				+ "				 OFFSET ? ROW FETCH NEXT 8 ROWS ONLY";

		try {
			new DBConnect();
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, (index - 1) * 8);
			rs = ps.executeQuery();

			while (rs.next()) {
				products.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4),
						rs.getString(5), rs.getInt(6), rs.getBoolean(7), rs.getBoolean(8)));
			}

			return products;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
//	public static void main(String[] args) {
//		ProductDAO dao = new ProductDAO();
//		Product product =  dao.getByProductId(1032);
//		System.out.println(product);
//		
//	}
}
