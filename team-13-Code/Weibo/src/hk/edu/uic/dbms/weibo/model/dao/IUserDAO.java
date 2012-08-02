/**
 * 
 */
package hk.edu.uic.dbms.weibo.model.dao;


import hk.edu.uic.dbms.weibo.model.vo.User;

/** 
 * @author cofthew7
 */
public interface IUserDAO {

		
			
	public abstract boolean updateTweetCount(int uid);
				
				
				public abstract User findUserByUID(int uid);
				
			

			
				
					
					
					public abstract User insertUser(String email, String password, String userName, String avatarURL, int gender, String city) throws Exception;
					
					
			
		

}
