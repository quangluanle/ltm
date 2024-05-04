package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.GenericServlet;
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

@WebServlet("/add-product")
public class AddProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CategoryDAO categoryDAO = new CategoryDAO();
		List<Category> categories = categoryDAO.findAllCategory();

		request.setAttribute("categories", categories);
		request.getRequestDispatcher("addproduct.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductDAO dao = new ProductDAO();
		CategoryDAO categoryDAO = new CategoryDAO();
		List<Category> categories = categoryDAO.findAllCategory();
		ServletContext context = request.getServletContext();
		String realpath = context.getRealPath("/images");
		MultipartRequest multi = new MultipartRequest(request, realpath);
		String name = null;
		String description = null;
		double price = 0;
		String image = null;
		int cate_id = 0;

		try {
			name = multi.getParameter("name");
			description = multi.getParameter("description");
			price = Double.parseDouble(multi.getParameter("price"));
			image = multi.getFilesystemName("image");
			cate_id = Integer.parseInt(multi.getParameter("category"));
		} catch (Exception e) {
			request.setAttribute("error", "Failed to add product!");
		}
		Product product = new Product(name, description, price, image, cate_id, false, true);
		request.setAttribute("categories", categories);
		if (dao.saveProduct(product)) {
			request.setAttribute("success", "Added successfully!");
			request.getRequestDispatcher("ProductsController").forward(request, response);

		} else {
			request.setAttribute("error", "Failed to add product!");
			request.getRequestDispatcher("addproduct.jsp").forward(request, response);
		}

	}

}
