package hk.edu.uic.dbms.weibo.model.dao.impl;

import java.util.LinkedList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
//import java.util.Date;
import java.text.SimpleDateFormat;

import com.mysql.jdbc.PreparedStatement;

import hk.edu.uic.dbms.weibo.model.dao.ITweetDAO;
import hk.edu.uic.dbms.weibo.model.dbc.DatabaseConnection;
import hk.edu.uic.dbms.weibo.model.vo.News;
import hk.edu.uic.dbms.weibo.model.vo.Tweet;

public class ITweetDAOImpl implements ITweetDAO {

	@Override
	public List<Tweet> getTweetsByInsertUID(int insertUID) {
		
		List<Tweet> getTweets = new LinkedList<Tweet>();
		String sql_2 = "select* from Tweets where InsertUID = '"+insertUID+"'" +"ORDER BY  `TweetsID` DESC";
		try{
			DatabaseConnection dc = new DatabaseConnection();
			Connection conn = dc.getConnection();
			Statement stat = conn.createStatement();
			ResultSet res = stat.executeQuery(sql_2);
			while(res.next()){
				Tweet t = new Tweet();
				
				t.setContent(res.getString("Content"));
				t.setDate(res.getString("Date"));
				t.setUID(res.getInt("InsertUID"));
				t.setCommentCount(res.getInt("CommentCount"));
				t.setRetweetCount(res.getInt("RetweetCount"));
				t.setTweetID(res.getInt("TweetsID"));
				t.setRtTweetID(res.getInt("RetweetID"));
				getTweets.add(t);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		if(getTweets !=null){
			for(int i=0;i<getTweets.size();i++){
				System.out.println(getTweets.get(i).getTweetID());
				System.out.println(getTweets.get(i).getContent());
				System.out.println(getTweets.get(i).getCommentCount());
			
				
			}
			
		}
		return getTweets;
	}

	@Override
	public boolean isRetweet(int TID) {
		DatabaseConnection dbc;	
		try {
			dbc = new DatabaseConnection();
			Connection conn = dbc.getConnection();
			Statement stmt1=conn.createStatement();
			//System.out.println(uidA+"::::::::"+uidB);
			String sql1="select isretweet from tweets where tweetsid="+TID;
			ResultSet rs1=stmt1.executeQuery(sql1);
			int isRT;
			if(rs1.next()){
				//System.out.println("isFollowing====true");
				isRT = rs1.getInt("IsRetweet");
				if(isRT==1){
					rs1.close();
					stmt1.close();
					conn.close();
					System.out.println("isRT====True");
					return true;
				}else 
				rs1.close();
				stmt1.close();
				conn.close();
				System.out.println("isRT====false");
				return false;
			}
			
			
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//System.out.println("isFollowing====false");
	return false;
		
		/*boolean isretweet;
		Tweet t = new Tweet();
		String sql_3 = "select isRetweet from Tweets where TID = '"+TID+"'";
		try{
			DatabaseConnection dc = new DatabaseConnection();
			Connection conn = dc.getConnection();
			Statement stat = conn.createStatement();
			ResultSet res = stat.executeQuery(sql_3);
			if(res.next()){
				isretweet = true;
				t.setIsRetweet(isretweet);//if true and then??
				updateRetweetCount(TID);
			}
			
			else
			{
				isretweet = false;
				t.setIsRetweet(isretweet);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return t.isIsRetweet();*/
	}

	@Override
	public boolean postTweet(int insertUID, String content) {
		boolean posttweet = false;
		Tweet t = new Tweet();
		//int tweetID = t.getTweetID();
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datetime = tempDate.format(new java.util.Date());
		int i;
		//怎么令TweetID自动增加？？
			
		String sql_1 = "insert into Tweets(TweetsID,Date,Content,InsertUID,RetweetCount,CommentCount) values (NULL ,'"+datetime+"','"+content+"', '"+insertUID+"','0','0')";
		try{
		    DatabaseConnection dc = new DatabaseConnection();
			Connection conn = dc.getConnection();
			Statement stat = conn.createStatement();
			i = stat.executeUpdate(sql_1);
			if(i!= 0){
				posttweet = true;
			}
			else{
				posttweet = false;
			}
			//ResultSet res = stat.executeQuery(sql_1);
				
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
			
		
		// TODO Auto-generated method stub
		return posttweet;
	}

	@Override
	public Tweet reTweet(int insertUID, String content, int retweetTID) {//confuse!
		Tweet t = new Tweet();
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datetime = tempDate.format(new java.util.Date());
		int i ;
		String sql = "insert into Tweets(TweetsID,InsertUID, Content,IsRetweet, RetweetID, Date, RetweetCount, CommentCount) values (NUll, '"+insertUID+"', '"+content+"',1, '"+retweetTID+"', '"+datetime+"', '0', '0')";
		String sql_1 = "select * from Tweets where Content = '"+content+"' and Date = '"+datetime+"'";
		try{
			DatabaseConnection dc = new DatabaseConnection();
			Connection conn = dc.getConnection();
			
			//PreparedStatement stat = null;
			Statement stat = conn.createStatement();
			Statement stat_1 = conn.createStatement();
			i = stat.executeUpdate(sql);
			if(i !=0){
			//String sql_1 = "select * from Tweets where Content = '"+content+"' ";
			ResultSet res = stat_1.executeQuery(sql_1);
			if(res.next()){
				t.setContent(res.getString("Content"));
				t.setDate(res.getString("Date"));
				t.setUID(res.getInt("InsertUID"));
				t.setCommentCount(res.getInt("CommentCount"));
				t.setRetweetCount(res.getInt("RetweetCount"));
				t.setTweetID(res.getInt("TweetsID"));
				t.setIsRetweet(true);
				updateRetweetCount(retweetTID);
			}
			}
			//updateRetweetCount(retweetTID);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public Tweet getTweetByTid(int tid) {
		Tweet t = new Tweet();
		
		String sql_2 = "select* from Tweets where TweetsID = '"+tid+"'";
		try{
			DatabaseConnection dc = new DatabaseConnection();
			Connection conn = dc.getConnection();
			Statement stat = conn.createStatement();
			ResultSet res = stat.executeQuery(sql_2);
			while(res.next()){
				t.setContent(res.getString("Content"));
				t.setDate(res.getString("Date"));
				t.setUID(res.getInt("InsertUID"));
				t.setCommentCount(res.getInt("CommentCount"));
				t.setRetweetCount(res.getInt("RetweetCount"));
				t.setTweetID(res.getInt("TweetsID"));
				
				
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return t;
	}

	@Override
	public void updateRetweetCount(int rtTID) {
		
		String sql = "update tweets set ReTweetCount=ReTweetCount+1 where TweetsID="+rtTID;
		try{
			DatabaseConnection dc = new DatabaseConnection();
			Connection conn = dc.getConnection();
			Statement stat = conn.createStatement();
			int i = stat.executeUpdate(sql);
			if(i!=0){
				
				System.out.println("updateRTcount succccccccccccccccccccccc");
			}else{
				System.out.println("updateRTcount fail");
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return;
		
		
		/*int retweetCount;//why it says retweetConut is never read??????
		int i;
		Tweet t = new Tweet();
		
		try{
			DatabaseConnection dc = new DatabaseConnection();
			Connection conn = dc.getConnection();
			Statement stat = conn.createStatement();
			Statement stat_1 = conn.createStatement();
			
			String sql = "select * from Tweets where RetweetID = '"+rtTID+"'";
			ResultSet res = stat.executeQuery(sql);
			retweetCount = res.getInt("RetweetCount");
			retweetCount++;
			String sql_2="update Tweets set RetweetCount="+retweetCount+" where RetweetID='"+rtTID+"'";
			i =  stat_1.executeUpdate(sql_2);
			ResultSet res_1 = stat_1.executeQuery(sql);
			t.setRetweetCount(Integer.parseInt(res_1.getString("RetweetCount")));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		// TODO Auto-generated method stub*/

	}

	public List<News> findNewsByUIDs(int[] uidArray) throws Exception{
		// TODO Auto-generated method stub
		
		// 声明变量用于存取结果
		List<News> newsList = new LinkedList<News>();
		
		StringBuffer temp = new StringBuffer();
		temp.append(" where tweets.InsertUID in (");
		
		
		
		for (int i = 0; i < uidArray.length; i++) {
			System.out.println(uidArray[i]+"---------->uidArray");
			temp.append(uidArray[i] + ",");
		}
		temp.append("0) ");
		
		String query="select user.uid, TweetsID, Avatar, tweets.Date, content, uname, CommentCount, RetweetCount,IsRetweet,RetweetID from user, tweets " +
				temp + "and tweets.InsertUID = user.uid order by Date desc";
		
		try{
			// 执行搜索
			DatabaseConnection dc = new DatabaseConnection();
			Connection conn = dc.getConnection();
			Statement stat = conn.createStatement();
			
			
			
				//pStatement.setInt(1, uidArray[i]);
				ResultSet rs = stat.executeQuery(query);
				while(rs.next()) {
					News news = new News();
					news.setUid(rs.getInt("uid"));
					news.setTid(rs.getInt("TweetsID"));
					news.setUserName(rs.getString("UName"));
					news.setContent(rs.getString("content"));
					news.setAvatarUrl(rs.getString("Avatar"));
					news.setDate(rs.getString("Date"));
					news.setCmtCount(rs.getInt("CommentCount"));
					news.setRTCount(rs.getInt("RetweetCount"));
					news.setCmtCount(rs.getInt("CommentCount"));
					news.setRTCount(rs.getInt("RetweetCount"));
					news.setIsRetweet(rs.getInt("IsRetweet"));
					news.setRetweetID(rs.getInt("RetweetID"));
				
					newsList.add(news);
				}
			
			// 判断是否为空
			if (newsList.size()!=0) {
				System.out.println("Successful!");
				for(int i=0;i<newsList.size();i++){
					System.out.println(newsList.get(i).getUserName()+"------->newsList.get(i).getUserName()");
				}
			} else {
				System.out.println("No record satisfied!");
				newsList = null;
			}
			// 关闭连接，返回结果
			//rs.close();	
              dc.close();			
			return newsList;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

}
