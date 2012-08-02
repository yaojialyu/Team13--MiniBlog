package hk.edu.uic.dbms.weibo.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


import hk.edu.uic.dbms.weibo.model.dbc.DatabaseConnection;
import hk.edu.uic.dbms.weibo.model.vo.*;

public class IUserDAOImpl implements hk.edu.uic.dbms.weibo.model.dao.IUserDAO {

	@Override
	public User findUserByUID(int uid) {
		// TODO Auto-generated method stub
		
		DatabaseConnection dbc;	
		 User u=new User();
		 String sql1="select * from User where UID='"+uid+"'";
			try {
				dbc = new DatabaseConnection();
				Connection conn = dbc.getConnection();
				Statement stmt1=conn.createStatement();
    			//String sql1="select * from user where UID='"+uid+"'";
				ResultSet rs1= stmt1.executeQuery(sql1);
				if(rs1.next()){
				u.setUID(uid);
				u.setEmail(rs1.getString("Email"));
				u.setPassword(rs1.getString("Password"));
				u.setUName(rs1.getString("UName"));
				u.setAvatar(rs1.getString("Avatar"));
				u.setGender(rs1.getInt("Gender"));
				u.setCity(rs1.getString("City"));
				u.setFollowingCount(rs1.getInt("FollowingCount"));
				u.setFollowerCount(rs1.getInt("FollowerCount"));
				u.setTweetCount(rs1.getInt("TweetCount"));
				}
				stmt1.close();
				conn.close();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return u;
		
	}

	@Override
	public User insertUser(String email, String password, String userName, String avatarURL, int gender, String city) throws Exception {
		    
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 结果
		User u = new User();
		// 搜索语句
		String query="insert into User (UID, Email, Password, Uname, Avatar, Gender,City,FollowingCount,FollowerCount,TweetCount) " +
				"values(Null,?,?,?,?,?,?,0,0,0)";
		String result="select * from user where email=?";
		if (isUserExisted(email)) {
			return null;
		} else {
			try{
			
				// 执行插入
				pStatement = conn.prepareStatement(query);
				pStatement.setString(1, email);
				pStatement.setString(2, password);
				pStatement.setString(3, userName);
				pStatement.setString(4, avatarURL);
				pStatement.setInt(5, gender);
				pStatement.setString(6,city);
	
				int row = pStatement.executeUpdate();
				// 判断是否为空
				if (row > 0) {
					// 若不为空，返回刚插入的对象
					System.out.println("Signup Successful!");
					pStatement = conn.prepareStatement(result);
					pStatement.setString(1, email);
					ResultSet rs = pStatement.executeQuery();
					if (rs.next()) {
						u.setUID(rs.getInt("UID"));
						u.setEmail(rs.getString("Email"));
						u.setPassword(rs.getString("Password"));
						u.setUName(rs.getString("UName"));
						u.setAvatar(rs.getString("Avatar"));
						u.setGender(rs.getInt("Gender"));
						u.setCity(rs.getString("City"));
						u.setFollowingCount(rs.getInt("FollowingCount"));
						u.setFollowerCount(rs.getInt("FollowerCount"));
						u.setTweetCount(rs.getInt("TweetCount"));
					}
				} else {
					System.out.println("Signup faild!");
					u= null;
				}
				// 关闭连接，返回结果
				//rs.close();
				dbc.close();
				return u;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
		
		
		
		
		/*DatabaseConnection dbc;
		     User u=new User();
			try {
				dbc = new DatabaseConnection();
				
				
				Connection conn = dbc.getConnection();
				Statement stmt=conn.createStatement();
				if (isUserExisted(email)) {
					return null;
				}else{
					
				
				
				String sql="insert into User (UID, Email, Password, Uname, Avatar, Gender,City,FollowingCount,FollowerCount,TweetCount) values(Null,'"+email+"','"+password+"','"+userName+"','"+avatarURL+"','"+gender+"','"+city+"',0,0,0)";
				//set the FollowingCount, FollowerCount, TweetCount to 0 when register
				stmt.executeQuery(sql);
				
				Statement stmt1=conn.createStatement();
				String sql1="select * from user where Email='"+email+"' and UName='"+userName+"'";
				ResultSet rs1=stmt1.executeQuery(sql1);
				u.setUID(rs1.getInt("UID)"));
				u.setEmail(rs1.getString("Email"));
				u.setPassword(rs1.getString("Password"));
				u.setUName(rs1.getString("UName"));
				u.setAvatar(rs1.getString("Avatar"));
				u.setGender(rs1.getInt("Gender"));
				u.setCity(rs1.getString("City"));
				u.setFollowingCount(rs1.getInt("FollowingCount"));
				u.setFollowerCount(rs1.getInt("FollowerCount"));
				u.setTweetCount(rs1.getInt("TweetCount"));
				
				stmt.close();
				conn.close();
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return u;
			
		// TODO Auto-generated method stub*/
	}
	
	
	public User signin(String email, String password) throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 声明变量用于存取结果
		User user= new User();
		// 搜索语句
		String query="select * from user where email= ? and password= ?";
		
		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			pStatement.setString(1, email);
			pStatement.setString(2, password);
			ResultSet rs = pStatement.executeQuery();
		
			while(rs.next()) {	
				user.setUID(rs.getInt("UID"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setUName(rs.getString("UName"));
				user.setAvatar(rs.getString("Avatar"));
				user.setGender(rs.getInt("Gender"));
				user.setCity(rs.getString("City"));
				user.setFollowingCount(rs.getInt("FollowingCount"));
				user.setFollowerCount(rs.getInt("FollowerCount"));
				user.setTweetCount(rs.getInt("TweetCount"));
			}
			
			
			
			// 判断是否为空
			if (user.getUID() != 0) {
				//System.out.println("Signin Successfully!");
			} else {
				//System.out.println("Signin Faild!");
				user = null;
			}
			// 关闭连接，返回结果
			// rs.close();	
			dbc.close();
			return user;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean isUserExisted(String email) throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 声明变量用于存取结果
		boolean isExisted = false;
		// 搜索语句
		String query = "select * from user where email=\'" + email + "\'";
		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			ResultSet rs = pStatement.executeQuery();
			
			// 判断是否为空
			if (!rs.next()) {
				System.out.println("Not Existed!");
				isExisted = false;
			} else {
				System.out.println("Existed!");
				isExisted = true;
			}
			// 关闭连接，返回结果
			// rs.close();	
			dbc.close();
			return isExisted;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isExisted;
	}

	@Override
	public boolean updateTweetCount(int uid) {
		String sql = "update User set TweetCount=TweetCount+1 where UID='"+uid+"'";
		try{
			DatabaseConnection dc = new DatabaseConnection();
			Connection conn = dc.getConnection();
			Statement stat = conn.createStatement();
			int i = stat.executeUpdate(sql);
			if(i!=0){
				return true;
			}else{
				return false;
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	
	public List<User> findByUserName(String username) throws Exception {
		// TODO Auto-generated method stub
		// 连接数据库
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pStatement = null;
		// 声明变量用于存取结果
		List<User> userList = new LinkedList<User>();
		// 搜索语句
		String query="select * from user where UName LIKE '%" + username + "%'";
		try{
			// 执行搜索
			pStatement = conn.prepareStatement(query);
			ResultSet rs = pStatement.executeQuery();
		
			while(rs.next()) {
				User user = new User();
				user.setUID(rs.getInt("UID"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setUName(rs.getString("UName"));
				user.setAvatar(rs.getString("Avatar"));
				user.setGender(rs.getInt("Gender"));
				user.setCity(rs.getString("City"));
				user.setFollowingCount(rs.getInt("FollowingCount"));
				user.setFollowerCount(rs.getInt("FollowerCount"));
				user.setTweetCount(rs.getInt("TweetCount"));
				
				userList.add(user);
			}
			// 判断是否为空
			if (userList.size()!=0) {
				System.out.println("findByProjectName Successful!");
			} else {
				System.out.println("findByProjectName No record satisfied!");
				userList = null;
			}
			// 关闭连接，返回结果
			// rs.close();	
			dbc.close();
			return userList;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
