package Controller;

import java.io.IOException;
import java.util.List;
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

@WebServlet("/wishlist")
public class WishListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAO dao = new ProductDAO();
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		if(user == null) {
			response.sendRedirect("login");
			return;
		}
		String wishlistkey = "wishlist_" + user.getUser_id();
		Map<Integer, Product> wishlists = (Map<Integer, Product>) session.getAttribute(wishlistkey);
		
		request.setAttribute("products", wishlists);
		request.getRequestDispatcher("wishlist.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
