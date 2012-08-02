<%@include file="inc.jsp" %>
<%
ICommentDAOImpl icdi = new ICommentDAOImpl();
List<Comment> l = null;
l = icdi.findCommentsForMeByUID(signinUser.getUID()); 
IUserDAOImpl iudi = new IUserDAOImpl();

%>

<%@include file="header.jsp" %>

<div id="main">
	<div class="Home_main_l" style="height:2000px;">
	
		<%
		if(l !=null){
			
			for(int i=0;i<l.size();i++){
			%>

		<div class="singleTweetRT">

			<div class="tweetAvatar">
				<img src="images/a.jpg" width="48px" alt=""/>
			</div>
			<div class="tweetContent">
				<p class="tweetAuthor" >
				<a class="name"><%=signinUser.getUName() %> </a>
				<a><%=l.get(i).getContent() %></a>
				</p>
			</div>
				<div class="retweet">
					<img src="images/comment.png" class="pic" />
					<p class="tweetAuthor" >
						<a class="name">
						test
						</a>
						<a>no time !!!!!!!!!!!!!!!!!!</a>
					</p>
				</div>	
			<div class="Tcount">
				<a >$Time</a>
				<a href="#">Retweet</a>(<a href="#">$N</a>)
				<a href="#">Comment</a>(<a href="#">$N</a>)
			</div>
		
		</div>
		<hr />
		<%}
			}%>
		
		
		</div>
		<hr />


		

	</div>
	
	
	<div class="Home_main_r" style="height:2000px;">
		<div class="info">
			<%@include file="myinfo.jsp" %>	
			<hr />
			<div style="margin-top:48px;">
			<a href="home.jsp"><img src="images/homepage.png" alt="" /></a>
			<a href="mypage.jsp?uid=<%=signinUser.getUID() %>"><img src="images/mypage.png" alt="" /></a>
			<a href="mycomments.jsp"><img src="images/mycomments2.png" alt="" /></a>
			<a href="following.jsp?uid=<%=signinUser.getUID() %>"><img src="images/followings.png" alt="" /></a>
			<a href="follower.jsp?uid=<%=signinUser.getUID() %>"><img src="images/followers.png" alt="" /></a>
			
			</div>
			
		</div>	
	
	</div>
</div>	

</body>

</html>
