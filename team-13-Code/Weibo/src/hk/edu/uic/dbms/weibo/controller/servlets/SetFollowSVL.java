package hk.edu.uic.dbms.weibo.controller.servlets;

import hk.edu.uic.dbms.weibo.model.dao.impl.IUserRelatioDAOImpl;
import hk.edu.uic.dbms.weibo.model.vo.User;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetFollowSVL
 */
public class SetFollowSVL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetFollowSVL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = (User)request.getSession().getAttribute("SigninUser");
		int followuid =Integer.parseInt(request.getParameter("followuid"));
		
		IUserRelatioDAOImpl iurdi = new IUserRelatioDAOImpl();
		if(iurdi.followAUser(user.getUID(), followuid)){
			iurdi.updateUserFollowerCount(followuid, 1);
			iurdi.updateUserFollowingCount(user.getUID(), 1);
		
			PrintWriter  out = response.getWriter();
			out.print("<html>");   
			out.print("<script>");
			out.print("alert('Follow Successfully!');");
			out.print("self.location='following.jsp?uid="+user.getUID()+"'");
			out.print("</script>");
			out.print("</html>"); 
			out.close();
		}
		else{
			PrintWriter  out = response.getWriter();
			out.print("<html>");   
			out.print("<script>");
			out.print("alert('Follow Fail!');");
			out.print("self.location='following.jsp?uid="+user.getUID()+"'");
			out.print("</script>");
			out.print("</html>");  
			out.close();
				
		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
