package hk.edu.uic.dbms.weibo.model.dao.impl;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

import hk.edu.uic.dbms.weibo.model.dao.ICommentDAO;
import hk.edu.uic.dbms.weibo.model.dbc.DatabaseConnection;
import hk.edu.uic.dbms.weibo.model.vo.Comment;



public class ICommentDAOImpl implements ICommentDAO {

	

	@Override
	public List<Comment> findCommentsByTID(int tid) { 
		Comment c = new Comment();
		List<Comment> findComments = new LinkedList<Comment>();
		String sql = "select * from Comments where TweetsID = '"+tid+"'";
		try{
			DatabaseConnection dc = new DatabaseConnection();
			Connection conn = dc.getConnection();
			
			Statement stat = conn.createStatement();
			ResultSet res = stat.executeQuery(sql);
			while(res.next()){
				c.setInsertUID(Integer.parseInt(res.getString("InsertUID")));
				c.setDate(res.getString("Date"));
				c.setContent(res.getString("Content"));
				c.setCommentsID(Integer.parseInt(res.getString("CommentsID")));
				findComments.add(c);
				//c1.setTweetsID(TID);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return findComments;
	}

	@Override
	public List<Comment> findCommentsForMeByUID(int uid) {
		List<Comment> findComments = new LinkedList<Comment>();
		Comment c = new Comment();
		String sql = "select* from Comments where InsertUID = '"+uid+"'";
		try{
			DatabaseConnection dc = new DatabaseConnection();
			Connection conn = dc.getConnection();
			Statement stat = conn.createStatement();
			ResultSet res = stat.executeQuery(sql);
			while(res.next()){
				c.setInsertUID(Integer.parseInt(res.getString("InsertUID")));
				c.setDate(res.getString("Date"));
				c.setContent(res.getString("Content"));
				c.setCommentsID(Integer.parseInt(res.getString("CommentsID")));
				findComments.add(c);
				
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return findComments;
	}

	@Override
	public boolean postComment(int tid, int insertUID,String date, String content, int tweetAuthorUID) {
		int i;
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datetime = tempDate.format(new java.util.Date());
		//Comment c = new Comment();
		boolean postcomment = false;
		String sql = "insert into Comments(TweetsID,InsertUID,Date,Content,TweetAuthorUID) values('"+tid+"', '"+insertUID+"','"+datetime+"', '"+content+"', '"+tweetAuthorUID+"')";
		try{
			DatabaseConnection dc = new DatabaseConnection();
			Connection conn = dc.getConnection();
			Statement stat = conn.createStatement();
			//ResultSet res = stat.executeQuery(sql);
			i = stat.executeUpdate(sql);
			if(i !=0){
				postcomment = true;
			}
			else{
				postcomment = false;
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		return postcomment;
	}

}
