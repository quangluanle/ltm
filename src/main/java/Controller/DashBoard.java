package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.OdersDAO;

@WebServlet("/dashboard")
public class DashBoard extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OdersDAO dao = new OdersDAO();
		req.setAttribute("T1", dao.getSumProductsByMonth(1));
		req.setAttribute("T2", dao.getSumProductsByMonth(2));
		req.setAttribute("T3", dao.getSumProductsByMonth(3));
		req.setAttribute("T4", dao.getSumProductsByMonth(4));
		req.setAttribute("T5", dao.getSumProductsByMonth(5));
		req.setAttribute("T6", dao.getSumProductsByMonth(6));
		req.setAttribute("T7", dao.getSumProductsByMonth(7));
		req.setAttribute("T8", dao.getSumProductsByMonth(8));
		req.setAttribute("T9", dao.getSumProductsByMonth(9));
		req.setAttribute("T10", dao.getSumProductsByMonth(10));
		req.setAttribute("T11", dao.getSumProductsByMonth(11));
		req.setAttribute("T12", dao.getSumProductsByMonth(12));
		
		req.setAttribute("rT1", dao.getSumRevenueByMonth(1));
		req.setAttribute("rT2", dao.getSumRevenueByMonth(2));
		req.setAttribute("rT3", dao.getSumRevenueByMonth(3));
		req.setAttribute("rT4", dao.getSumRevenueByMonth(4));
		req.setAttribute("rT5", dao.getSumRevenueByMonth(5));
		req.setAttribute("rT6", dao.getSumRevenueByMonth(6));
		req.setAttribute("rT7", dao.getSumRevenueByMonth(7));
		req.setAttribute("rT8", dao.getSumRevenueByMonth(8));
		req.setAttribute("rT9", dao.getSumRevenueByMonth(9));
		req.setAttribute("rT10", dao.getSumRevenueByMonth(10));
		req.setAttribute("rT11", dao.getSumRevenueByMonth(11));
		req.setAttribute("rT12", dao.getSumRevenueByMonth(12));

		req.setAttribute("sumProductsOfYear", dao.getSumProductsByYear());
		req.setAttribute("sumRevenueOfYear", dao.getSumRevenueByYear());
		req.setAttribute("sumProductsOfMonth", dao.getSumProductsByMonth());
		req.setAttribute("sumRevenueOfMonth", dao.getSumRevenueThisMonth());

		req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

}
