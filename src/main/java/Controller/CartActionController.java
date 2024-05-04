package Controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ShoppingCart;
import Model.Users;

@WebServlet("/cart-action")
public class CartActionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int product_id = Integer.parseInt(request.getParameter("id"));
		String action = request.getParameter("action");

		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		String cartKey = "cart_" + user.getUser_id();
		Map<Integer, ShoppingCart> carts = (Map<Integer, ShoppingCart>) session.getAttribute(cartKey);

		if (action.equals("delete")) {
			carts.remove(product_id);
		} else if (action.equals("update")) {
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			carts.get(product_id).setQuantity(quantity);
		}

		session.setAttribute(cartKey, carts);
		response.sendRedirect("cart");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
