package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ShoppingCart;
import Model.Users;

@WebServlet("/cart")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Users user = (Users) session.getAttribute("user");
		if (user == null) {
		    response.sendRedirect("login");
		    return;
		}

		String cartKey = "cart_" + user.getUser_id(); 
		Map<Integer, ShoppingCart> carts = (Map<Integer, ShoppingCart>) session.getAttribute(cartKey);

		double totalPrice = 0;
		if (carts == null) {
		    request.setAttribute("cartEmpty", "Your cart is empty!");
		    carts = new HashMap<>();
		    session.setAttribute(cartKey, carts);
		} else {
			Set<Integer> set = carts.keySet();
			
			for (Integer item : set) {
				totalPrice += carts.get(item).getProduct().getPrice() * carts.get(item).getQuantity();
			}

			request.setAttribute("totalItem", carts.size());
		    request.setAttribute("totalPrice", totalPrice);
		    request.setAttribute("cart", carts);
		}
		int totalItem = carts.size();

		session.setAttribute("totalItem", totalItem);

		request.getRequestDispatcher("cart.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
