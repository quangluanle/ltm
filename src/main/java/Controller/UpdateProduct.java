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
 * Servlet implementation class UpdateProduct
 */
@WebServlet("/UpdateProduct")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateProduct() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductDAO dao = new ProductDAO();
		CategoryDAO categoryDAO = new CategoryDAO();
		List<Product> products = dao.findAllproduct();
		List<Category> categories = categoryDAO.findAllCategory();
		Product pro = dao.getByProductId(Integer.parseInt(request.getParameter("id")));

		request.setAttribute("categories", categories);
		request.setAttribute("product", pro);
		request.setAttribute("products", products);
		request.getRequestDispatcher("updateproduct.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductDAO dao = new ProductDAO();
		CategoryDAO categoryDAO = new CategoryDAO();
		List<Category> categories = categoryDAO.findAllCategory();
		List<Product> products = dao.findAllproduct();
		ServletContext context = request.getServletContext();
		String realpath = context.getRealPath("/images");
		MultipartRequest multi = new MultipartRequest(request, realpath);
		String name = null;
		String description = null;
		double price = 0;
		String image = null;
		int cate_id = 0, product_id = 0;
		try {
			name = multi.getParameter("name");
			description = multi.getParameter("description");
			price = Double.parseDouble(multi.getParameter("price"));
			image = multi.getFilesystemName("image");
			cate_id = Integer.parseInt(multi.getParameter("category"));
			System.out.println("Hello CÀ CHUA  Quả cà chua: " + name + " , , " + description);
			product_id = Integer.parseInt(multi.getParameter("product_id"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		Product product = new Product(product_id, name, description, price, image, cate_id, false, true);
		if (dao.updateProduct(product)) {
			request.setAttribute("success", "Updated successfully!");
			request.setAttribute("products", products);
			request.getRequestDispatcher("ProductsController").forward(request, response);
		} else {
			request.setAttribute("error", "Failed to update product!");
			request.getRequestDispatcher("updateproduct.jsp").forward(request, response);
		}
	}

}
