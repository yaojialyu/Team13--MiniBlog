package hk.edu.uic.dbms.weibo.model.dao;

import hk.edu.uic.dbms.weibo.model.vo.Comment;

//import java.sql.ResultSet;
import java.util.List;


public interface ICommentDAO {

		
			
			
			//public abstract List<Comment> findByTID(int tweetsID);
			

			
			/**
			 */
			//public abstract Comment postComment(int tweetsID, int insertID, String cotent);



				
				/**
				 */
				public abstract List<Comment> findCommentsByTID(int tid);



					
					/**
					 */
					public abstract List<Comment> findCommentsForMeByUID(int uid);



						
						/**
						 */
						public abstract boolean postComment(int tid, int insertUID,String date, String content, int tweetAuthorUID);
						
					
				
			
		

}
