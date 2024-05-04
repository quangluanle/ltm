package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ProductDAO;
import Model.Product;
import Model.ShoppingCart;
import Model.Users;

@WebServlet("/add-to-cart")
public class AddToCartController extends HttpServlet {
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
		String cartKey = "cart_" + user.getUser_id();

		Map<Integer, ShoppingCart> carts = (Map<Integer, ShoppingCart>) session.getAttribute(cartKey);

		if (carts == null) {
			carts = new HashMap<>();
		}

		int productId = Integer.parseInt(request.getParameter("id"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));

		Product product = dao.getByProductId(productId);
		if (product != null) {
			ShoppingCart cartItem = carts.get(productId);
			if (cartItem != null) {
				cartItem.setQuantity(cartItem.getQuantity() + quantity);
			} else {
				carts.put(productId, new ShoppingCart(product, quantity));
			}
		}
		int totalItem = carts.size();

		session.setAttribute("totalItem", totalItem);
		session.setAttribute(cartKey, carts);

		request.setAttribute("success", "Added product to cart");
		request.getRequestDispatcher("product-detail?id=" + productId).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
