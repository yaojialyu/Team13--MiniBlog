package hk.edu.uic.dbms.weibo.controller.servlets;

import hk.edu.uic.dbms.weibo.model.dao.impl.IUserRelatioDAOImpl;
import hk.edu.uic.dbms.weibo.model.vo.User;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.generic.IREM;

/**
 * Servlet implementation class SetUnFollowSVL
 */
public class SetUnFollowSVL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetUnFollowSVL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = (User)request.getSession().getAttribute("SigninUser");
		int unfollowuid =Integer.parseInt(request.getParameter("unfollowuid"));
		
		IUserRelatioDAOImpl iurdi = new IUserRelatioDAOImpl();
		if(iurdi.unFollowAUser(user.getUID(), unfollowuid)){
			iurdi.updateUserFollowerCount(unfollowuid, 0);
			iurdi.updateUserFollowingCount(user.getUID(), 0);
			
			PrintWriter  out = response.getWriter();
			out.print("<html>");   
			out.print("<script>");
			out.print("alert('Unfollow Successfully!');");
			out.print("self.location='following.jsp?uid="+user.getUID()+"'");
			out.print("</script>");
			out.print("</html>"); 
			out.close();
		}
		else{
			PrintWriter  out = response.getWriter();
			out.print("<html>");   
			out.print("<script>");
			out.print("alert('Unfollow Fail!');");
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
