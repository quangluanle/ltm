package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import DAO.CategoryDAO;
import DAO.ProductDAO;
import Model.Category;
import Model.Product;

/**
 * Servlet implementation class DeleteProductController
 */
@WebServlet("/DeleteProduct")
public class DeleteProductController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductDAO dao = new ProductDAO();
		CategoryDAO categoryDAO = new CategoryDAO();
		List<Product> products = dao.findAllproduct();
		List<Category> categories = categoryDAO.findAllCategory();
		Product pro = dao.getByProductId(Integer.parseInt(request.getParameter("id")));

		request.setAttribute("categories", categories);
		request.setAttribute("product", pro);
		request.setAttribute("products", products);
		request.getRequestDispatcher("deleteproduct.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductDAO dao = new ProductDAO();
		CategoryDAO categoryDAO = new CategoryDAO();
		List<Category> categories = categoryDAO.findAllCategory();
		List<Product> products = dao.findAllproduct();
		ServletContext context = request.getServletContext();
		String realpath = context.getRealPath("/images");
		MultipartRequest multi = new MultipartRequest(request, realpath);
		String product_id = "";
		try {
			product_id = multi.getParameter("product_id");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (dao.deleteProduct(product_id)) {
			request.setAttribute("success", "Deleted successfully!");
			request.setAttribute("products", products);
			request.getRequestDispatcher("ProductsController").forward(request, response);
		} else {
			request.setAttribute("error", "Failed to update product!");
			request.getRequestDispatcher("deleteproduct.jsp").forward(request, response);
		}
	}

}
