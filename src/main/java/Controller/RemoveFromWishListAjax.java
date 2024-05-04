package Controller;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/remove-wishlist")
public class RemoveFromWishListAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		
		String wishlistkey = "wishlist_" + user.getUser_id();
		
		Map<Integer, Product> wishlists = (Map<Integer, Product>) session.getAttribute(wishlistkey);
		wishlists.remove(product_id);
		
		PrintWriter out = response.getWriter();
		
		for (Integer key : wishlists.keySet()) {
			out.println("<tr class=\"text-center\">\r\n"
					+ "		<td class=\"image-prod\"><div class=\"img\"\r\n"
					+ "			style=\"background-image: url(images/"+wishlists.get(key).getImage()+");\"></div></td>\r\n"
					+ "	\r\n"
					+ "		<td class=\"product-name\">\r\n"
					+ "			<h3>\r\n"
					+ "				<a href=\"product-detail?id="+wishlists.get(key).getProduct_id()+"\">"+wishlists.get(key).getName()+"</a>\r\n"
					+ "			</h3>\r\n"
					+ "				<p>"+wishlists.get(key).getDescription()+"</p>\r\n"
					+ "		</td>\r\n"
					+ "	\r\n"
					+ "		<td class=\"price\">$"+wishlists.get(key).getPrice()+"</td>\r\n"
					+ "	\r\n"
					+ "		<td class=\"product-remove\"><a style=\"cursor: pointer;\" onclick=\"removeFromWishlist("+wishlists.get(key).getProduct_id()+")\"><span\r\n"
					+ "			class=\"ion-ios-close\"></span></a></td>\r\n"
					+ "\r\n"
					+ "	</tr>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
