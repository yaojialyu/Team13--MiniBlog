/**
 * 
 */
package hk.edu.uic.dbms.weibo.model.vo;

/** 
 * @author cofthew7
 */
public class UserRelation {

	/**
	 * 
	 */
	public UserRelation() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @uml.property  name="UID"
	 */
	private int uid;

	/**
	 * Getter of the property <tt>UID</tt>
	 * @return  Returns the uid.
	 * @uml.property  name="UID"
	 */
	public int getUID() {
		return uid;
	}

	/**
	 * Setter of the property <tt>UID</tt>
	 * @param UID  The uid to set.
	 * @uml.property  name="UID"
	 */
	public void setUID(int uid) {
		this.uid = uid;
	}

	/**
	 * @uml.property  name="FollowingUID"
	 */
	private int followingUID;

	/**
	 * Getter of the property <tt>FollowingUID</tt>
	 * @return  Returns the followingUID.
	 * @uml.property  name="FollowingUID"
	 */
	public int getFollowingUID() {
		return followingUID;
	}

	/**
	 * Setter of the property <tt>FollowingUID</tt>
	 * @param FollowingUID  The followingUID to set.
	 * @uml.property  name="FollowingUID"
	 */
	public void setFollowingUID(int followingUID) {
		this.followingUID = followingUID;
	}

}
