package hk.edu.uic.dbms.weibo.model.dao;


import hk.edu.uic.dbms.weibo.model.vo.User;
import java.util.List;


public interface IUserRelationDAO {

		
			
				
				/** 
				 * @return 
				 * @�����Լ��ķ�˿
				 */
				public abstract List findFollowersByUID(int uid);
				
			

			
				
					
					/** 
					 * @�����Լ���ע��˭
					 */
					public abstract List findFollowingsByUID(int uid);
					
				


				
					
						
							
							/** 
							 * @��עһ���û�
							 */
							public abstract boolean followAUser(int uidA, int uidB);
							
						
					


					
						
							
								
								/** 
								 * @ȡ���עһ���û�
								 */
								public abstract boolean unFollowAUser(int uidA, int uidB);
								
							
						


						
							
								
									
									





										
										/**
										 */
										public abstract boolean isFollowing(int uidA, int uidB);






											
											/**
											 * @return 
											 */
											public abstract boolean updateUserFollowingCount(int uid,int isAdd);






												
												/**
												 * @return 
												 */
												public abstract boolean updateUserFollowerCount(int uid,int isAdd);
												
											
										
									


									
										
										
										
										
									
								
							
						
					
				
			
		

}
