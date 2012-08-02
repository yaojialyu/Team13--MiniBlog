<%@include file="inc.jsp" %>


<%

String username = request.getParameter("search");
IUserDAOImpl iudi = new IUserDAOImpl();
User user = signinUser;
List<User> userList = iudi.findByUserName(username);

%>

<%@include file="header.jsp" %>
<div id="main">
	<div class="Home_main_l" style="height:2000px;">
	
	<%
		if(userList !=null){
			for(int i=0;i<userList.size();i++){
			%>
		<div class="follow">
			<div class="followAvatar">
				<img src="<%=userList.get(i).getAvatar() %>" /><br />
				<a href="mypage.jsp?uid=<%=userList.get(i).getUID() %>" class="name"><%=userList.get(i).getUName() %></a>
			</div>
			<div class="followContent">
				<div class="followinfo">
				<a >
				<%
				if(userList.get(i).getGender()==0){
					out.println("Male");
				}
				else{
					out.println("Female");
				}
				%>
				</a> &nbsp;&nbsp;
				<a>&nbsp;&nbsp;City: &nbsp <%=userList.get(i).getCity() %></a>
				

				</div>
				<div class="followcount" >
				<a href="following.jsp?uid=<%=userList.get(i).getUID() %>" style="margin-left:100px;"><%=userList.get(i).getFollowingCount() %></a>
				<a href="follower.jsp?uid=<%=userList.get(i).getUID() %>" style="margin-left:140px;"><%=userList.get(i).getFollowerCount() %></a>
				<a href="mypage.jsp?uid=<%=userList.get(i).getUID() %>" style="margin-left:120px;"><%=userList.get(i).getTweetCount() %></a>
				</div>
			</div>
		</div>
		<%}
			}%>


	</div>
	
	
	<div class="Home_main_r" style="height:2000px;">
		<div class="info">
			<%@include file="myinfo.jsp" %>	
			<hr />
			<div style="margin-top:48px;">
			<a href="home.jsp"><img src="images/homepage.png" alt="" /></a>
			<a href="mypage.jsp?uid=<%=signinUser.getUID() %>"><img src="images/mypage.png" alt="" /></a>
			<a href="mycomments.jsp"><img src="images/mycomments.png" alt="" /></a>
			<a href="following.jsp?uid=<%=signinUser.getUID() %>"><img src="images/followings2.png" alt="" /></a>
			<a href="follower.jsp?uid=<%=signinUser.getUID() %>"><img src="images/followers.png" alt="" /></a>
			
			</div>
			
		</div>	
	
	</div>
	
</div>


</body>

</html>
