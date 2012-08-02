package hk.edu.uic.dbms.weibo.controller.servlets;

import hk.edu.uic.dbms.weibo.model.dao.impl.*;
import hk.edu.uic.dbms.weibo.model.vo.User;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostTweetSVL
 */
public class PostTweetSVL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostTweetSVL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = (User)request.getSession().getAttribute("SigninUser");
		String content = request.getParameter("Tweet_Content");
		ITweetDAOImpl itdi = new ITweetDAOImpl();
		
		try {
			if (itdi.postTweet(user.getUID(), content) == false) {
				PrintWriter out = response.getWriter();
				out.println("<html><center><h1>Post Announcement faild!</h1></center>");
				out.println("<center><h2>Redirecting to home page ~~ </h2></center></html>");
				response.setHeader("Refresh","4;URL=home.jsp");
				return;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		IUserDAOImpl idi = new IUserDAOImpl();
		
		idi.updateTweetCount(user.getUID());
		
		response.sendRedirect("home.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
