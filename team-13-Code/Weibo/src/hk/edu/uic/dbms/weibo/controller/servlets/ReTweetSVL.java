package hk.edu.uic.dbms.weibo.controller.servlets;

import hk.edu.uic.dbms.weibo.model.dao.impl.ITweetDAOImpl;
import hk.edu.uic.dbms.weibo.model.vo.User;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReTweetSVL
 */
public class ReTweetSVL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReTweetSVL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = (User)request.getSession().getAttribute("SigninUser");
		String uid = request.getParameter("uid");
		int tid = Integer.parseInt(request.getParameter("tid"));
		String recontent = request.getParameter("recontent");
		ITweetDAOImpl itdi = new ITweetDAOImpl();
		
		
		if(itdi.reTweet(user.getUID(), recontent, tid)!=null){
			//itdi.updateRetweetCount(tid);
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		}
		
		PrintWriter  out = response.getWriter();
		out.print("<html>");   
		out.print("<script>");
		out.print("alert('ReTweet successfully!');");
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
