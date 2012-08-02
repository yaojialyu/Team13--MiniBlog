package hk.edu.uic.dbms.weibo.model.dao.impl;
import hk.edu.uic.dbms.weibo.model.dao.IUserRelationDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import hk.edu.uic.dbms.weibo.model.dao.IUserRelationDAO;
import hk.edu.uic.dbms.weibo.model.dbc.DatabaseConnection;
import hk.edu.uic.dbms.weibo.model.vo.User;

public class IUserRelatioDAOImpl implements IUserRelationDAO {

	@Override
	public List<User> findFollowersByUID(int uid) {
		// TODO Auto-generated method stub
		DatabaseConnection dbc;
		List<User> followingsList=new LinkedList<User>();
		try {
			dbc = new DatabaseConnection();
			Connection conn = dbc.getConnection();
			Statement stmt=conn.createStatement();
			String sql = "select * from UserRelation where FollowingUID='"+uid+"'";
			ResultSet rs1= stmt.executeQuery(sql);
			
			while(rs1.next())
				{
				IUserDAOImpl UDI=new IUserDAOImpl();
				User u =new User();
				u=UDI.findUserByUID(rs1.getInt("UID"));
				followingsList.add(u);
				}
			rs1.close();
			conn.close();
			stmt.close();
				
		} catch (Exception e) {
			// TODO Auto-generated wcatch block
			e.printStackTrace();
		}
		return followingsList;
	}

	@Override
	public List<User> findFollowingsByUID(int uid) {
		DatabaseConnection dbc;
		List<User> followersList=new LinkedList<User>();
		try {
			dbc = new DatabaseConnection();
			Connection conn = dbc.getConnection();
			Statement stmt=conn.createStatement();
			String sql = "select * from userrelation where UID='"+uid+"'";
			ResultSet rs= stmt.executeQuery(sql);
			
			while(rs.next())
				{
				IUserDAOImpl UDI=new IUserDAOImpl();
				User u =new User();
				u=UDI.findUserByUID(rs.getInt("FollowingUID"));
				followersList.add(u);
				}
			rs.close();
			conn.close();
			stmt.close();
				
		} catch (Exception e) {
			// TODO Auto-generated wcatch block
			e.printStackTrace();
		}
		return followersList;
		
		
	}

	@Override
	public boolean followAUser(int uidA, int uidB) {
		// TODO Auto-generated method stub
		 DatabaseConnection dbc;	
			try {
				dbc = new DatabaseConnection();
				Connection conn = dbc.getConnection();
				Statement stmt1=conn.createStatement();
				String sql1="insert into userrelation(uid,followinguid) values("+uidA+","+uidB+")";
				int i = stmt1.executeUpdate(sql1);
				if(i!=0){
					stmt1.close();
					conn.close();
					return true;
				}
				else{
					stmt1.close();
					conn.close();
					return false;
				}
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return false;
	}

	@Override
	public boolean unFollowAUser(int uidA, int uidB) {
		// TODO Auto-generated method stub
		DatabaseConnection dbc;	
		try {
			dbc = new DatabaseConnection();
			Connection conn = dbc.getConnection();
			Statement stmt1=conn.createStatement();
			
			String sql1="delete from userrelation where UID="+uidA+" and FollowingUID="+uidB;
			stmt1.executeUpdate(sql1);
			stmt1.close();
			conn.close();
			return true;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return false;
	}



	@Override
	public boolean isFollowing(int uidA, int uidB) {
		// TODO Auto-generated method stub
		DatabaseConnection dbc;	
		try {
			dbc = new DatabaseConnection();
			Connection conn = dbc.getConnection();
			Statement stmt1=conn.createStatement();
			System.out.println(uidA+"::::::::"+uidB);
			String sql1="select * from userrelation where UID="+uidA+" and FollowingUID="+uidB;
			ResultSet rs1=stmt1.executeQuery(sql1);
			if(rs1.next()){
				//System.out.println("isFollowing====true");
				return true;
			}
			
			rs1.close();
			stmt1.close();
			conn.close();
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//System.out.println("isFollowing====false");
	return false;
	}

	@Override
	public boolean updateUserFollowingCount(int uid,int isAdd) {
		// TODO Auto-generated method stub
		String sql = null;
		if(isAdd==1){
		sql = "update User set FollowingCount=FollowingCount+1 where UID='"+uid+"'";
		}
		else{
		sql = "update User set FollowingCount=FollowingCount-1 where UID='"+uid+"'";
		}
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

	@Override
	public boolean updateUserFollowerCount(int uid,int isAdd) {
		String sql = null;
		if(isAdd==1){
		sql = "update User set FollowerCount=FollowerCount+1 where UID='"+uid+"'";
		}
		else{
		sql = "update User set FollowerCount=FollowerCount-1 where UID='"+uid+"'";	
		}
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
		
		

	public int[] findFollowing(int uid) throws Exception {
			// TODO Auto-generated method stub
			DatabaseConnection dbc = new DatabaseConnection();
			Connection conn = dbc.getConnection();
			PreparedStatement pStatement = null;
			// 连接数据库
			int[] uidArray;
			// 新建数组
			String query="select FollowingUID from userrelation where UID=" + uid;
	        //数据库执行语句
			try{
				// 执行数据库语句
				pStatement = conn.prepareStatement(query);
				ResultSet rs = pStatement.executeQuery();			
				
				rs.last();
				uidArray = new int[rs.getRow()];
				rs.beforeFirst();
				/*while(rs.next()) {
					int i = 0;
					uidArray[i] = rs.getInt("uid");
					i++;
				}*/
				for (int i = 0; rs.next(); i++) {
					uidArray[i] = rs.getInt("FollowingUID");
					System.out.println(uidArray[i]+"uidArray********");
				}
				// 判断是否为空
				if (uidArray.length != 0) {
					System.out.println("Successful!");
				} else {
					System.out.println("No record satisfied!");
					uidArray = null;
				}
				// 关闭			// rs.close();	
				dbc.close();
				return uidArray;
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
}
	

