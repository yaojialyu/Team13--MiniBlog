<%@include file="inc.jsp" %>



<%@include file="header.jsp" %>

<div id="main">
	<div class="Home_main_l" style="height:2000px;">
		

	


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
			<a href="follower.jsp?uid=<%=signinUser.getUID() %>"><img src="images/followers.png" alt="" /></a>
			
			</div>
			
		</div>	
	
	</div>
	
</div>


</body>

</html>
