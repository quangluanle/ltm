package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProductDAO;
import Model.Product;

@WebServlet("/paginate")
public class PaginationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductDAO dao = new ProductDAO();

		int amount = Integer.parseInt(request.getParameter("index"));
		List<Product> products = dao.paging(amount);

		PrintWriter out = response.getWriter();

		for (Product p : products) {
			out.println("				<div class=\"col-md-6 col-lg-3 fadeInUp ftco-animate ftco-animated\">\r\n"
					+ "						<div class=\"product\">\r\n"
					+ "							<a href=\"product-detail?id=" + p.getProduct_id()
					+ "\" class=\"img-prod\"><img\r\n"
					+ "								class=\"img-fluid\" src=\"images/" + p.getImage() + "\"\r\n"
					+ "								alt=\"Colorlib Template\"> <span class=\"status\">20%</span>\r\n"
					+ "								<div class=\"overlay\"></div> </a>\r\n"
					+ "							<div class=\"text py-3 pb-4 px-3 text-center\">\r\n"
					+ "								<h3>\r\n"
					+ "									<a href=\"product-detail?id=" + p.getProduct_id() + "\">"
					+ p.getName() + "</a>\r\n" + "								</h3>\r\n"
					+ "								<div class=\"d-flex\">\r\n"
					+ "									<div class=\"pricing\">\r\n"
					+ "										<p class=\"price\">\r\n"
					+ "											<span class=\"mr-2 price-dc\">$" + p.getPrice() / 0.8
					+ "</span><span\r\n" + "												class=\"price-sale\">$"
					+ p.getPrice() + "</span>\r\n" + "										</p>\r\n"
					+ "									</div>\r\n" + "								</div>\r\n"
					+ "								<div class=\"bottom-area d-flex px-3\">\r\n"
					+ "									<div class=\"m-auto d-flex\">\r\n"
					+ "										<a href=\"#\"\r\n"
					+ "											class=\"add-to-cart d-flex justify-content-center align-items-center text-center\">\r\n"
					+ "											<span><i class=\"ion-ios-menu\"></i></span>\r\n"
					+ "										</a> <a href=\"add-to-cart?id=" + p.getProduct_id()
					+ "&quantity=1\"\r\n"
					+ "											class=\"buy-now d-flex justify-content-center align-items-center mx-1\">\r\n"
					+ "											<span><i class=\"ion-ios-cart\"></i></span>\r\n"
					+ "										</a> <a href=\"add-to-wishlist?id=" + p.getProduct_id()
					+ "\"\r\n"
					+ "											class=\"heart d-flex justify-content-center align-items-center \">\r\n"
					+ "											<span><i class=\"ion-ios-heart\"></i></span>\r\n"
					+ "										</a>\r\n" + "									</div>\r\n"
					+ "								</div>\r\n" + "							</div>\r\n"
					+ "						</div>\r\n" + "					</div>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
