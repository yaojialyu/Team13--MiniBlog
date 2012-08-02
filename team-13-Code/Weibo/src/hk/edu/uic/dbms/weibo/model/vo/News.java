package hk.edu.uic.dbms.weibo.model.vo;

/** 
 * @author cofthew7
 */
public class News {

	/**
	 * 
	 */
	public News() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @uml.property  name="uid"
	 */
	private int uid;
	
	private int IsRetweet;
	private int RetweetID;
	
	public int getIsRetweet() {
		return IsRetweet;
	}
	
	public int getRetweetID() {
		return RetweetID;
	}
	public void setIsRetweet(int uid) {
		this.IsRetweet = uid;
	}
	public void setRetweetID(int uid) {
		this.RetweetID = uid;
	}

	/**
	 * Getter of the property <tt>uid</tt>
	 * @return  Returns the uid.
	 * @uml.property  name="uid"
	 */
	public int getUid() {
		return uid;
	}

	/**
	 * Setter of the property <tt>uid</tt>
	 * @param uid  The uid to set.
	 * @uml.property  name="uid"
	 */
	public void setUid(int uid) {
		this.uid = uid;
	}

	/**
	 * @uml.property  name="tid"
	 */
	private int tid;

	/**
	 * Getter of the property <tt>tid</tt>
	 * @return  Returns the tid.
	 * @uml.property  name="tid"
	 */
	public int getTid() {
		return tid;
	}

	/**
	 * Setter of the property <tt>tid</tt>
	 * @param tid  The tid to set.
	 * @uml.property  name="tid"
	 */
	public void setTid(int tid) {
		this.tid = tid;
	}

	/**
	 * @uml.property  name="avatarUrl"
	 */
	private String avatarUrl;

	/**
	 * Getter of the property <tt>avatarUrl</tt>
	 * @return  Returns the avatarUrl.
	 * @uml.property  name="avatarUrl"
	 */
	public String getAvatarUrl() {
		return avatarUrl;
	}

	/**
	 * Setter of the property <tt>avatarUrl</tt>
	 * @param avatarUrl  The avatarUrl to set.
	 * @uml.property  name="avatarUrl"
	 */
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	/**
	 * @uml.property  name="date"
	 */
	private String date;

	/**
	 * Getter of the property <tt>date</tt>
	 * @return  Returns the date.
	 * @uml.property  name="date"
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Setter of the property <tt>date</tt>
	 * @param date  The date to set.
	 * @uml.property  name="date"
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @uml.property  name="content"
	 */
	private String content;

	/**
	 * Getter of the property <tt>content</tt>
	 * @return  Returns the content.
	 * @uml.property  name="content"
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Setter of the property <tt>content</tt>
	 * @param content  The content to set.
	 * @uml.property  name="content"
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @uml.property  name="userName"
	 */
	private String userName;

	/**
	 * Getter of the property <tt>userName</tt>
	 * @return  Returns the userName.
	 * @uml.property  name="userName"
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Setter of the property <tt>userName</tt>
	 * @param userName  The userName to set.
	 * @uml.property  name="userName"
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @uml.property  name="RTCount"
	 */
	private int rtCount;

	/**
	 * Getter of the property <tt>RTCount</tt>
	 * @return  Returns the rtCount.
	 * @uml.property  name="RTCount"
	 */
	public int getRTCount() {
		return rtCount;
	}

	/**
	 * Setter of the property <tt>RTCount</tt>
	 * @param RTCount  The rtCount to set.
	 * @uml.property  name="RTCount"
	 */
	public void setRTCount(int rtCount) {
		this.rtCount = rtCount;
	}

	/**
	 * @uml.property  name="cmtCount"
	 */
	private int cmtCount;

	/**
	 * Getter of the property <tt>cmtCount</tt>
	 * @return  Returns the cmtCount.
	 * @uml.property  name="cmtCount"
	 */
	public int getCmtCount() {
		return cmtCount;
	}

	/**
	 * Setter of the property <tt>cmtCount</tt>
	 * @param cmtCount  The cmtCount to set.
	 * @uml.property  name="cmtCount"
	 */
	public void setCmtCount(int cmtCount) {
		this.cmtCount = cmtCount;
	}

	/**
	 * @uml.property  name="facCount"
	 */
	private int facCount;

	/**
	 * Getter of the property <tt>facCount</tt>
	 * @return  Returns the facCount.
	 * @uml.property  name="facCount"
	 */
	public int getFacCount() {
		return facCount;
	}

	/**
	 * Setter of the property <tt>facCount</tt>
	 * @param facCount  The facCount to set.
	 * @uml.property  name="facCount"
	 */
	public void setFacCount(int facCount) {
		this.facCount = facCount;
	}

}