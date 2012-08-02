<%@include file="inc.jsp" %>

<%

int uid = Integer.parseInt(request.getParameter("uid"));
ITweetDAOImpl itdi = new ITweetDAOImpl();
IUserDAOImpl iudi = new IUserDAOImpl();
IUserRelatioDAOImpl iurdi = new IUserRelatioDAOImpl();
List <Tweet> myTweetList = itdi.getTweetsByInsertUID(uid);
User user = iudi.findUserByUID(uid);

%>

<%@include file="header.jsp" %>
<div id="main">
	<div class="Home_main_l" style="height:2000px;">
		<div style="height:170px;">
			<div class="mypage_head">
			 	<img class="mypage_avatar" src="<%=user.getAvatar() %>" />
			</div>
			<div class="profile" >
				<p style="margin-top:20px;"><a style="color:red;font-size:20px;"><%=user.getUName() %></a></p>
				<p><a href="mypage.jsp?uid=<%=user.getUID() %>">Team13 Miniblog 第<%=user.getUID()%>号用户</a><br />
				<a>
				<%
				if(user.getGender()==0){
					out.println("Male");
				}
				else{
					out.println("Female");
				}
				%>
				</a><br />
				<a>From  <%=user.getCity() %></a></p>
			</div>
			<div class="followbutton">
				<% 
				if(uid!=signinUser.getUID()){
				
					//System.out.println(signinUser.getUID()+"::::::::::::");
					//System.out.println(followerList.get(i).getUID());
					if(iurdi.isFollowing(signinUser.getUID(),uid)){	%>
						<a href="SetUnFollowSVL?unfollowuid=<%=user.getUID() %>"><img class="followbutton" src="images/uunfollow.png" /></a>
						<%
						}else{ %>
						<a href="SetFollowSVL?followuid=<%=user.getUID() %>"><img class="followbutton" src="images/ffollow.png" /></a>
						<%
					}
				}
					%>
					
					
				
				
				
			</div>
		</div>
		<hr />
		<div>
		
		
		<%
		if(myTweetList !=null){  
			
			
			for(int i=0;i<myTweetList.size();i++){
			%>
		<%
		 
			if(itdi.isRetweet(myTweetList.get(i).getTweetID())) {
				out.println("<div class=\"singleTweetRT\">");
			}else{
				out.println("<div class=\"singleTweet\">");
			}
		
		%>			
		

			<div class="tweetAvatar">
				<img src="<%=user.getAvatar() %>" width="48px" alt="" /><br />
				<a style="color:red;font-size:15px;"><%=user.getUName() %></a>
			</div>
			<div class="tweetContent">
				<p class="tweetAuthor" >
				
				<textarea name="TextArea1" style="width:420px; height: 99px; margin-left:10px; background-color:white;" disabled="disabled"><%=myTweetList.get(i).getContent() %></textarea>
				
				</p>
			</div>
			
			<%
			if(itdi.isRetweet(myTweetList.get(i).getTweetID())) {
				%>
			<div class="retweet">

					<img src="images/rt.png" class="pic" />

					<p class="tweetAuthor" >

						<a class="name">
						
						
						</a>

						<textarea name="TextArea1" style="width:420px; height: 99px; margin-left:10px;border:0px; background-color:white;" disabled="disabled"><%
						int tid = myTweetList.get(i).getRtTweetID();
						System.out.println(tid);
						Tweet t = itdi.getTweetByTid(tid);
						System.out.println(t.getUID()+"222");
						out.println(iudi.findUserByUID(t.getUID()).getUName()+":");
						%><%=t.getContent() %></textarea>

					</p>

				</div>	

			
				
				
			<%}%>
				<div class="Tcount">
				<a ><%=myTweetList.get(i).getDate() %> &nbsp &nbsp</a>
				<a href="retweet.jsp?tid=<%=myTweetList.get(i).getTweetID() %>&uid=<%=uid %>">Retweet</a>(<a href=""><%=myTweetList.get(i).getRetweetCount() %></a>)
				<a href="reply.jsp?tid=<%=myTweetList.get(i).getTweetID() %>&uid=<%=uid %>">Comment</a>(<a href=""><%=myTweetList.get(i).getCommentCount() %></a>)
			</div>
		
		</div>
		<hr />
		<%}
			}%>

	</div>
	
</div>
	
	
	<div class="Home_main_r" style="height:2000px;">
		<div class="info">
			<%@include file="myinfo.jsp" %>	
			<hr />
			<div style="margin-top:48px;">
			<a href="home.jsp"><img src="images/homepage.png" alt="" /></a>
			<a href="mypage.jsp?uid=<%=signinUser.getUID() %>"><img src="images/mypage2.png" alt="" /></a>
			<a href="mycomments.jsp"><img src="images/mycomments.png" alt="" /></a>
			<a href="following.jsp?uid=<%=signinUser.getUID() %>"><img src="images/followings.png" alt="" /></a>
			<a href="follower.jsp?uid=<%=signinUser.getUID() %>"><img src="images/followers.png" alt="" /></a>
			
			
			</div>
			
		</div>
	
	
		
		


		</div>
		
		
	</div>


</body>

</html>
