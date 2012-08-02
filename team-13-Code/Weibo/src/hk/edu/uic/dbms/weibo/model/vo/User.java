/**
 * 
 */
package hk.edu.uic.dbms.weibo.model.vo;

/** 
 * @author cofthew7
 */
public class User {

	/**
	 * 
	 */
	public User() {
		// TODO Auto-generated constructor stub
	}

	/** 
	 * @uml.property name="UID"
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
	 * @uml.property  name="Email"
	 */
	private String email;

	/**
	 * Getter of the property <tt>Email</tt>
	 * @return  Returns the email.
	 * @uml.property  name="Email"
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter of the property <tt>Email</tt>
	 * @param Email  The email to set.
	 * @uml.property  name="Email"
	 */
	public void setEmail(String email) {
		this.email = email;
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
	 * @uml.property  name="Password"
	 */
	private String password;

	/**
	 * Getter of the property <tt>Password</tt>
	 * @return  Returns the password.
	 * @uml.property  name="Password"
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter of the property <tt>Password</tt>
	 * @param Password  The password to set.
	 * @uml.property  name="Password"
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @uml.property  name="UName"
	 */
	private String uName;

	/**
	 * Getter of the property <tt>UName</tt>
	 * @return  Returns the uName.
	 * @uml.property  name="UName"
	 */
	public String getUName() {
		return uName;
	}

	/**
	 * Setter of the property <tt>UName</tt>
	 * @param UName  The uName to set.
	 * @uml.property  name="UName"
	 */
	public void setUName(String uName) {
		this.uName = uName;
	}

	/**
	 * @uml.property  name="Avatar"
	 */
	private String avatar;

	/**
	 * Getter of the property <tt>Avatar</tt>
	 * @return  Returns the avatar.
	 * @uml.property  name="Avatar"
	 */
	public String getAvatar() {
		return avatar;
	}

	/**
	 * Setter of the property <tt>Avatar</tt>
	 * @param Avatar  The avatar to set.
	 * @uml.property  name="Avatar"
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	/**
	 * @uml.property  name="Gendar"
	 */
	private int gender;

	/**
	 * Getter of the property <tt>Gendar</tt>
	 * @return  Returns the gendar.
	 * @uml.property  name="Gender"
	 */
	public int getGender() {
		return gender;
	}

	/**
	 * Setter of the property <tt>Gendar</tt>
	 * @param Gendar  The gendar to set.
	 * @uml.property  name="Gender"
	 */
	public void setGender(int i) {
		this.gender = i;
	}

	/**
	 * @uml.property  name="City"
	 */
	private String city;

	/**
	 * Getter of the property <tt>City</tt>
	 * @return  Returns the city.
	 * @uml.property  name="City"
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Setter of the property <tt>City</tt>
	 * @param City  The city to set.
	 * @uml.property  name="City"
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @uml.property  name="FollowingCount"
	 */
	private int followingCount;

	/**
	 * Getter of the property <tt>FollowingCount</tt>
	 * @return  Returns the followingCount.
	 * @uml.property  name="FollowingCount"
	 */
	public int getFollowingCount() {
		return followingCount;
	}

	/**
	 * Setter of the property <tt>FollowingCount</tt>
	 * @param FollowingCount  The followingCount to set.
	 * @uml.property  name="FollowingCount"
	 */
	public void setFollowingCount(int followingCount) {
		this.followingCount = followingCount;
	}

	/**
	 * @uml.property  name="FollowerCount"
	 */
	private int followerCount;

	/**
	 * Getter of the property <tt>FollowerCount</tt>
	 * @return  Returns the followerCount.
	 * @uml.property  name="FollowerCount"
	 */
	public int getFollowerCount() {
		return followerCount;
	}

	/**
	 * Setter of the property <tt>FollowerCount</tt>
	 * @param FollowerCount  The followerCount to set.
	 * @uml.property  name="FollowerCount"
	 */
	public void setFollowerCount(int followerCount) {
		this.followerCount = followerCount;
	}

	/**
	 * @uml.property  name="TweetCount"
	 */
	private int tweetCount;

	/**
	 * Getter of the property <tt>TweetCount</tt>
	 * @return  Returns the tweetCount.
	 * @uml.property  name="TweetCount"
	 */
	public int getTweetCount() {
		return tweetCount;
	}

	/**
	 * Setter of the property <tt>TweetCount</tt>
	 * @param TweetCount  The tweetCount to set.
	 * @uml.property  name="TweetCount"
	 */
	public void setTweetCount(int tweetCount) {
		this.tweetCount = tweetCount;
	}

}
