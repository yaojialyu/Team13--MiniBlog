package hk.edu.uic.dbms.weibo.controller.servlets;

import hk.edu.uic.dbms.weibo.model.dao.*;
import hk.edu.uic.dbms.weibo.model.dao.impl.IUserDAOImpl;
import hk.edu.uic.dbms.weibo.model.vo.*;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SigninSVL
 */
public class SigninSVL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SigninSVL() {
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
		
		System.out.println("Test:Email + Password: "+ email+" + "+ password);
		
		User signinUser = new User();
		IUserDAOImpl udi = new IUserDAOImpl();
		// 匹配数据库，返回User对象
		try {
			signinUser = udi.signin(email, password);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (signinUser == null) {
			PrintWriter out = response.getWriter();
			out.println("<html><center><h1>Signin faild! please check your email and password!</h1></center>");
			out.println("<center><h2>Redirecting to index page ~~ </h2></center></html>");
			response.setHeader("Refresh","4;URL=./index.jsp");
			return;
		}
		
		request.getSession().setAttribute("SigninUser", signinUser);
        response.sendRedirect("home.jsp");
		//response.sendRedirect("ShowProjectListSVL");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
