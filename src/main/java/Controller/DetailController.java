package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProductDAO;
import Model.Product;

@WebServlet("/product-detail")
public class DetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ProductDAO dao = new ProductDAO();
		Product product = dao.getByProductId(id);
		List<Product> relatedProducts = dao.getRelatedProductById(product.getCate_id());
		
		request.setAttribute("product", product);
		request.setAttribute("relatedProducts", relatedProducts);
		request.getRequestDispatcher("product-detail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
