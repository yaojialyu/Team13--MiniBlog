package hk.edu.uic.dbms.weibo.model.dao;


import hk.edu.uic.dbms.weibo.model.vo.Tweet;
import java.util.List;


public interface ITweetDAO {

	

			
			


					
						
							
							/** 
							 * 
							 */
							public abstract List<Tweet> getTweetsByInsertUID(int insertUID);
							
						



						
							
							/** 
							 * @�ж��Ƿ���ת��
							 */
							public abstract boolean isRetweet(int TID);
							



							
						



								
									
									
									public abstract boolean postTweet(int insertUID, String content);



									

											
											/**
											 */
											public abstract Tweet getTweetByTid(int tid);



												
													
													
													public abstract void updateRetweetCount(int rtTID);







													Tweet reTweet(
															int insertUID,
															String content,
															int retweetTID);
													
												
											
										
									
								
							
						
					
				
			
		

}
