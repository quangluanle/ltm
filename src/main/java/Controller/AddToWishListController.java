package Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ProductDAO;
import Model.Product;
import Model.Users;

@WebServlet("/add-to-wishlist")
public class AddToWishListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductDAO dao = new ProductDAO();
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		if (user == null) {
			response.sendRedirect("login");
			return;
		}
		String wishlistkey = "wishlist_" + user.getUser_id();

		Map<Integer, Product> wishlists = (Map<Integer, Product>) session.getAttribute(wishlistkey);
		if (wishlists == null) {
			wishlists = new HashMap<>();
		}
		int product_id = Integer.parseInt(request.getParameter("id"));
		Product product = dao.getByProductId(product_id);
		product.setWish(true);
		wishlists.put(product_id, product);

		session.setAttribute(wishlistkey, wishlists);
		response.sendRedirect("product-detail?id=" + product_id);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
