<%@include file="inc.jsp" %>


<%

int uid = Integer.parseInt(request.getParameter("uid"));
IUserDAOImpl iudi = new IUserDAOImpl();
User user = iudi.findUserByUID(uid);
IUserRelatioDAOImpl iurdi = new IUserRelatioDAOImpl();
List<User> followingList = iurdi.findFollowingsByUID(uid);

%>

<%@include file="header.jsp" %>
<div id="main">
	<div class="Home_main_l" style="height:2000px;">
		&nbsp; &nbsp;<a style="font-size:30px;color:teal"><%=user.getUName() %>'s Following List</a><br />
	<%
		if(followingList !=null){
			for(int i=0;i<followingList.size();i++){
			%>
		<div class="follow">
			<div class="followAvatar">
				<img src="<%=followingList.get(i).getAvatar() %>" /><br />
				<a href="mypage.jsp?uid=<%=followingList.get(i).getUID() %>" class="name"><%=followingList.get(i).getUName() %></a>
			</div>
			<div class="followContent">
				<div class="followinfo">
				<a >
				<%
				if(followingList.get(i).getGender()==0){
					out.println("Male");
				}
				else{
					out.println("Female");
				}
				%>
				</a> &nbsp;&nbsp;
				<a>&nbsp;&nbsp;City: &nbsp <%=followingList.get(i).getCity() %></a>
				<a href="SetUnFollowSVL?unfollowuid=<%=followingList.get(i).getUID() %>"><img class="ffollow" src="images/uunfollow.png" /></a>

				</div>
				<div class="followcount" >
				<a href="following.jsp?uid=<%=followingList.get(i).getUID() %>" style="margin-left:100px;"><%=followingList.get(i).getFollowingCount() %></a>
				<a href="follower.jsp?uid=<%=followingList.get(i).getUID() %>" style="margin-left:140px;"><%=followingList.get(i).getFollowerCount() %></a>
				<a href="mypage.jsp?uid=<%=followingList.get(i).getUID() %>" style="margin-left:120px;"><%=followingList.get(i).getTweetCount() %></a>
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
