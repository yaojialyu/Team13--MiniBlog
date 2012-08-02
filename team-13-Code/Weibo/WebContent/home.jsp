<%@include file="inc.jsp" %>
<%
// 取得我关注的用户的ID和我自己的ID，并成一个数组
IUserRelatioDAOImpl rdi = new IUserRelatioDAOImpl();
IUserDAOImpl iudi = new IUserDAOImpl();
ITweetDAOImpl ndi = new ITweetDAOImpl();
int[] followingIDs;
List<News> newsList = null;
try {
	 followingIDs = rdi.findFollowing(signinUser.getUID());
	
	if (followingIDs != null) {
		int[] allIDs = new int[followingIDs.length + 1];
		System.out.println(followingIDs.length+"---->followingIDs.length");
		for (int i = 0; i < followingIDs.length; i++) {
			allIDs[i] = followingIDs[i];
		}
		allIDs[allIDs.length - 1] = signinUser.getUID();
		newsList = ndi.findNewsByUIDs(allIDs);
	} else {
		int[] myUID = new int[1];
		myUID[0] = signinUser.getUID();
		newsList = ndi.findNewsByUIDs(myUID);
	}
	
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}


%>


<%@include file="header.jsp" %>
<div id="main">
	<div class="Home_main_l" style="height:2000px;">
		<div class="Tinput">
			<img  alt=""src="images/wrudoing.png" />
			<form method="post" action="PostTweetSVL">
			<textarea class="TinputArea"  name="Tweet_Content" cols="20" rows="2"></textarea>
			<input name="PostTweet" type="submit" value="Post" style=" position:relative;bottom:45px; left: -3px; height: 100px; width: 65px;" />
			</form>
		</div>
		<hr />
		
	<%
		if(newsList !=null){
			
			for(int i=0;i<newsList.size();i++){
				System.out.println(newsList.get(i).getUserName());
			%>
		<%
		 
			if(ndi.isRetweet(newsList.get(i).getTid())) {
				out.println("<div class=\"singleTweetRT\">");
			}else{
				out.println("<div class=\"singleTweet\">");
			}
		
		
		%>			
		

			<div class="tweetAvatar">
				<img src="<%=newsList.get(i).getAvatarUrl() %>" width="48px" alt="" /><br />
				<a style="color:red;font-size:15px;"><%=newsList.get(i).getUserName() %></a>
			</div>
			<div class="tweetContent">
				<p class="tweetAuthor" >
				
				<textarea name="TextArea1" style="width:420px; height: 99px; margin-left:10px; background-color:white;" disabled="disabled"><%=newsList.get(i).getContent() %></textarea>
				
				</p>
			</div>
			
			<%
			if(ndi.isRetweet(newsList.get(i).getTid())) {
				%>
			<div class="retweet">

					<img src="images/rt.png" class="pic" />

					<p class="tweetAuthor" >

						<a class="name">
						
						
						</a>

						<textarea name="TextArea1" style="width:420px; height: 99px; margin-left:10px;border:0px; background-color:white;" disabled="disabled"><%
						int tid = newsList.get(i).getRetweetID();
						System.out.println(tid);
						Tweet t = ndi.getTweetByTid(tid);
						System.out.println(t.getUID()+"get retweet TID successfully");
						out.println(iudi.findUserByUID(t.getUID()).getUName()+":");
						%><%=t.getContent() %></textarea>

					</p>

				</div>	

			
				
				
			<%}%>
				<div class="Tcount">
				<a ><%=newsList.get(i).getDate() %> &nbsp &nbsp</a>
				<a href="retweet.jsp?tid=<%=newsList.get(i).getTid() %>&uid=<%=newsList.get(i).getUid() %>">Retweet</a>(<a href=""><%=newsList.get(i).getRTCount() %></a>)
				<a href="reply.jsp?tid=<%=newsList.get(i).getTid() %>&uid=<%=newsList.get(i).getUid() %>">Comment</a>(<a href=""><%=newsList.get(i).getCmtCount() %></a>)
			</div>
		
		</div>
		<hr />
		<%}
			}%>

	

	
	
	</div>
	
	
	<div class="Home_main_r" style="height:2000px;">
		<div class="info">
		
			<%@include file="myinfo.jsp" %>
				
			<hr />
			<div style="margin-top:48px;">
			<a href="home.jsp"><img src="images/homepage2.png" alt="" /></a>
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
