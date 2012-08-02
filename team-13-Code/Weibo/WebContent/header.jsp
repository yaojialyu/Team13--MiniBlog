
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>TEAM 13</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>

<body>
<div class="cloud"></div>
<div id="header">
	<div class="top_menu">
		<a href="mypage.jsp?uid=<%=signinUser.getUID() %>"><%=signinUser.getUName() %></a>&nbsp;&nbsp;&nbsp;
		<a href="setting.jsp">Setting</a>&nbsp;&nbsp;&nbsp;
		<a href="SignoutSVL">Logout</a>
	</div>
	<hr />
	<div class="menu">	
		<form method="get" action="search.jsp">
			<a href="home.jsp">Home</a>
			<a href="mypage.jsp?uid=<%=signinUser.getUID() %>">My Page</a>
			<a href="following.jsp?uid=<%=signinUser.getUID() %>">Following</a>
			<a href="follower.jsp?uid=<%=signinUser.getUID() %>">Follower</a>
			<input name="search" type="text" style="width: 90px;margin-left:10px" />
			<input name="Search_button" type="submit" value="Search" />	
		</form>
	<img class="logo" src="images/login-logo.png" width="200px" style="margin-top:-24px;" />
	
	</div>
	
</div>