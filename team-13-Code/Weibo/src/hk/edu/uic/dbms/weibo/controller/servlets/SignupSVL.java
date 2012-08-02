package hk.edu.uic.dbms.weibo.controller.servlets;


import hk.edu.uic.dbms.weibo.model.vo.User;
import hk.edu.uic.dbms.weibo.model.dao.impl.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignupSVL
 */
public class SignupSVL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupSVL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String username = request.getParameter("Nickname");
		String city = request.getParameter("city");
		int gender = Integer.parseInt(request.getParameter("gender"));
		String avatar = request.getParameter("avatar");
		User user = null;
		IUserDAOImpl udi = new IUserDAOImpl();
		try {
			user = udi.insertUser(email, password, username, avatar, gender, city);
			if (user == null) {
				PrintWriter out = response.getWriter();
				out.println("<html><center><h1>Signup Failed</h1></center>");
				out.println("<center><h2>Redirecting to index page ~~ </h2></center></html>");
				response.setHeader("Refresh","4;URL=./index.jsp");
				return;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.getSession().setAttribute("SigninUser", user);
        request.getRequestDispatcher("home.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
