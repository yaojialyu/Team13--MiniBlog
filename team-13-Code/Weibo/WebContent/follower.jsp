<%@include file="inc.jsp" %>

<%

int uid = Integer.parseInt(request.getParameter("uid"));
IUserDAOImpl iudi = new IUserDAOImpl();
User user = iudi.findUserByUID(uid);
IUserRelatioDAOImpl iurdi = new IUserRelatioDAOImpl();
List<User> followerList = iurdi.findFollowersByUID(uid);

%>


<%@include file="header.jsp" %>
<div id="main">
	<div class="Home_main_l" style="height:2000px;">
	&nbsp; &nbsp;<a style="font-size:30px;color:teal"><%=user.getUName() %>'s Follower List</a>
	<%
		if(followerList !=null){
			for(int i=0;i<followerList.size();i++){
			%>
		<div class="follow">
			
			<div class="followAvatar">
				<img  src="<%=followerList.get(i).getAvatar() %>" /><br />
				<a href="mypage.jsp?uid=<%=followerList.get(i).getUID() %>" class="name"><%=followerList.get(i).getUName() %></a>
			</div>
			<div class="followContent">
				<div class="followinfo">
				<a >
				<%
				if(followerList.get(i).getGender()==0){
					out.println("Male");
				}
				else{
					out.println("Female");
				}
				%>
				</a> &nbsp;&nbsp;
				<a>&nbsp;&nbsp;City: &nbsp <%=followerList.get(i).getCity() %></a>
				<%
				//System.out.println(signinUser.getUID()+"::::::::::::");
				//System.out.println(followerList.get(i).getUID());
				if(iurdi.isFollowing(signinUser.getUID(),followerList.get(i).getUID())){
					%>
					<a href="SetUnFollowSVL?unfollowuid=<%=followerList.get(i).getUID() %>"><img class="ffollow" src="images/uunfollow.png" /></a>
					<%
				}else{ %>
					<a href="SetFollowSVL?followuid=<%=followerList.get(i).getUID() %>"><img class="ffollow" src="images/ffollow.png" /></a>
					<%
				}
				%>
				

				</div>
				<div class="followcount" >
				<a href="following.jsp?uid=<%=followerList.get(i).getUID() %>" style="margin-left:100px;"><%=followerList.get(i).getFollowingCount() %></a>
				<a href="follower.jsp?uid=<%=followerList.get(i).getUID() %>" style="margin-left:140px;"><%=followerList.get(i).getFollowerCount() %></a>
				<a href="mypage.jsp?uid=<%=followerList.get(i).getUID() %>" style="margin-left:120px;"><%=followerList.get(i).getTweetCount() %></a>
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
			<a href="following.jsp?uid=<%=signinUser.getUID() %>"><img src="images/followings.png" alt="" /></a>
			<a href="follower.jsp?uid=<%=signinUser.getUID() %>"><img src="images/followers2.png" alt="" /></a>
			
			
			</div>
			
		</div>	
	
	</div>
	
</div>


</body>

</html>
