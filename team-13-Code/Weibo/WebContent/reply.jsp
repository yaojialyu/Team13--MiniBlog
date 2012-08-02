<%@include file="inc.jsp" %>

<%

int tid = Integer.parseInt(request.getParameter("tid"));
int uid = Integer.parseInt(request.getParameter("uid"));
IUserDAOImpl i = new IUserDAOImpl();
User user = i.findUserByUID(uid);
ITweetDAOImpl t = new ITweetDAOImpl();
Tweet tweet = t.getTweetByTid(tid);



%>


<%@include file="header.jsp" %>
<div id="main">
	<div class="Home_main_l" style="height:2000px;">
	<div class="singleTweet">

		<div class="tweetAvatar">
				<img src="<%=user.getAvatar() %>" width="48px" alt="" /><br />
				<a style="color:red;font-size:15px;"><%=user.getUName() %></a>
		</div>
		<div class="tweetContent">
			<p class="tweetAuthor" >
			<input name="tid" value="tid" type="hidden" />
			<textarea name="rtcontent" style="width:420px; height: 99px; margin-left:10px; background-color:white;" disabled="disabled"><%=tweet.getContent() %></textarea>
			
			</p>
		</div>				
	</div>
	<hr />
	
	<form method="post" action="ReplyTweetSVL">
	<div class="singleTweet" style="text-align:center">
	<input name="tid" value="<%=tid %>" type="hidden" />
	<input name="uid" value="<%=uid %>" type="hidden" />
	<textarea name="content" style="width: 588px; height: 125px">Reply</textarea>
	<input name="Submit1" type="submit" value="Reply" />
	</div>
	
	
	
	
	</form>
	


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
