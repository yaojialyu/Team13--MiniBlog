	<img src="<%=signinUser.getAvatar()%>" alt="5555" style="height:48px;width:48px; margin-top:10px; margin-left:10px" />
	<div style="position:relative;top: -45px; width:116px; left: 70px;"><a name="UserName" href="mypage.jsp?uid=<%=signinUser.getUID()%>" ><%=signinUser.getUName()%></a></div>		
	<div style="position:relative;top: -40px; width:116px; left: 70px; visibility: visible;"><a name="UserName" >City: <%=signinUser.getCity()%></a></div>	
	<div style="width:190px;height:60px; margin:-70px 0 0 0px;; background:url('images/counts.png'); background-repeat:no-repeat">
		<ul style="width:200px; margin:40px 0 5px -40px; text-align:center">
			<li class="lll"><a href="following.jsp?uid=<%=signinUser.getUID() %>"><%=signinUser.getFollowingCount() %></a></li>
			<li class="lll"><a href="follower.jsp?uid=<%=signinUser.getUID() %>"><%=signinUser.getFollowerCount() %></a></li>
			<li class="lll"><a href="mypage.jsp?uid=<%=signinUser.getUID() %>"><%=signinUser.getTweetCount() %></a></li>
		</ul>
	</div>	