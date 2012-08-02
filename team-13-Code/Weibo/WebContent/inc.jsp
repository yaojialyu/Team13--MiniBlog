

<%@ page contentType="text/html;charset=gb2312" %>
<% request.setCharacterEncoding("gb2312");%>


<%@page import="java.util.*,
hk.edu.uic.dbms.weibo.controller.*,
hk.edu.uic.dbms.weibo.model.dao.*,
hk.edu.uic.dbms.weibo.model.dao.impl.*,
hk.edu.uic.dbms.weibo.model.vo.*"%>

<%
User signinUser =(User) session.getAttribute("SigninUser"); 

if (signinUser == null) {
	out.println("<html><center><h1>Please signin!</h1></center>");
	out.println("<center><h2>Redirecting to index page ~~ </h2></center></html>");
	response.setHeader("Refresh","2;URL=./index.jsp");
	return;
	
	
}

IUserDAOImpl udi = new IUserDAOImpl();
signinUser = udi.signin(signinUser.getEmail(), signinUser.getPassword());

%>

