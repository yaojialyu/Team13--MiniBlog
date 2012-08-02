<%
if (session.getAttribute("SigninUser") != null) {
	response.setHeader("Refresh","0;URL=home.jsp");
	return;
}
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>TEAM 13</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />

</head>

<body>
<div id="right_top"><a href="register.jsp">Sign up</a></div>
<div id="login">
<div class="cloud"></div>
<h1>TEAM 13 - A Copyleft MiniBlog</h1>
<form method="post" action="SigninSVL">
	<table>
		<tr>
			<td ><a style="font-size:15px">Email</a></td>
			<td ><a style="font-size:15px">Psssword</a></td>
		</tr>
		<tr>
			<td>
				<input class="textbox" value="admin@admin.com" name="email"type="text" />
			</td>
			<td>
				<input class="textbox" name="password" value="admin" style="width: 180px" type="password" />
			</td>
			<td ><input class="button" name="Login" type="submit" value="Login" />
			</td>
		</tr>
		<tr>
			<td>
				<input name="RememberMe" type="checkbox" /> <a>Remember Me</a></td>
			<td>
				<a>Froget Password</a>
			</td>
		</tr>
	</table>
	</form>
</div>

</body>

</html>
