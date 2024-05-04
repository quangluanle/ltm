package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UsersDAO;
import Model.Users;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie[] = request.getCookies();
		if(cookie != null) {
			for(Cookie o : cookie) {
				if(o.getName().equals("phoneNumber")) {
					request.setAttribute("phoneNumber", o.getValue());
				}
				if(o.getName().equals("password")) {
					request.setAttribute("password", o.getValue());
				}
			}
		}
		request.getRequestDispatcher("signup.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phoneNumber = request.getParameter("name");
		String password = request.getParameter("pass");
		String remember = request.getParameter("remember");
		
		UsersDAO dao = new UsersDAO();
		Users user = dao.checkLogin(phoneNumber, password);
		
		if(user == null) {
			request.setAttribute("message", "Phone number or passowrd is invalid!");
			request.setAttribute("phoneNumber", phoneNumber);
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		} else {
			
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			session.setAttribute("message", "Welcome back, " + user.getEmail());;

			Cookie u = new Cookie("phoneNumber", phoneNumber);
			Cookie p = new Cookie("password", password);
			
			u.setMaxAge(1000);
			if(remember != null) {
				p.setMaxAge(1000);
			} else {
				p.setMaxAge(0);
			}
			
			response.addCookie(u);
			response.addCookie(p);
			
			response.sendRedirect("home");
		}
	}

}
