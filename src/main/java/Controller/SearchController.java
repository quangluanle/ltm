package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CategoryDAO;
import DAO.ProductDAO;
import Model.Category;
import Model.Product;

@WebServlet("/search")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAO dao = new ProductDAO();
		CategoryDAO categoryDAO = new CategoryDAO();
		String keyword = request.getParameter("keyword");
		List<Product> products = dao.search(keyword);
		List<Category> categories = categoryDAO.findAllCategory();
		
		request.setAttribute("keyword", keyword);
		request.setAttribute("categories", categories);
		request.setAttribute("products", products);
		
		request.getRequestDispatcher("shop.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
