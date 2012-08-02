package hk.edu.uic.dbms.weibo.controller.servlets;

import hk.edu.uic.dbms.weibo.model.dao.impl.ICommentDAOImpl;
import hk.edu.uic.dbms.weibo.model.vo.User;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReplyTweetSVL
 */
public class ReplyTweetSVL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyTweetSVL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int tid = Integer.parseInt(request.getParameter("tid"));
		int uid = Integer.parseInt(request.getParameter("uid"));
		User user = (User)request.getSession().getAttribute("SigninUser");
		ICommentDAOImpl icdi = new ICommentDAOImpl();
		String content = request.getParameter("content");
		
		icdi.postComment(tid, user.getUID(), "date", content, uid);
		
		PrintWriter  out = response.getWriter();
		out.print("<html>");   
		out.print("<script>");
		out.print("alert('Reply successfully!');");
		out.print("self.location='home.jsp'");
		out.print("</script>");
		out.print("</html>"); 
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
