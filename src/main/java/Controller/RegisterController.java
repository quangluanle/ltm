package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UsersDAO;
import Model.Users;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String phoneNumber = request.getParameter("phoneNumber");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String email = request.getParameter("email");

		if (!(password.equals(repassword))) {
			request.setAttribute("error", "Password and repassword are not same!");
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		}

		UsersDAO dao = new UsersDAO();
		Users user = dao.checkAccountExist(phoneNumber);

		if (user == null) {
			dao.register(new Users(phoneNumber, password, email, 2, true));
		} else {
			request.setAttribute("error", "Your phone number has been registered before!");
		}
		request.getRequestDispatcher("signup.jsp").forward(request, response);
	}

}
