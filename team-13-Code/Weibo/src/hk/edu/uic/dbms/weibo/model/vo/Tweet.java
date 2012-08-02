/**
 * 
 */
package hk.edu.uic.dbms.weibo.model.vo;

/** 
 * @author cofthew7
 */
public class Tweet {

	/**
	 * 
	 */
	public Tweet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @uml.property  name="TweetID"
	 */
	private int tweetID;
	private int RetweetID;
	public int getRtTweetID() {
		return RetweetID;
	}
	public void setRtTweetID(int re) {
		this.RetweetID = re;
	}


	
	
	
	/**
	 * Getter of the property <tt>TweetID</tt>
	 * @return  Returns the tweetID.
	 * @uml.property  name="TweetID"
	 */
	public int getTweetID() {
		return tweetID;
	}

	/**
	 * Setter of the property <tt>TweetID</tt>
	 * @param TweetID  The tweetID to set.
	 * @uml.property  name="TweetID"
	 */
	public void setTweetID(int tweetID) {
		this.tweetID = tweetID;
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
	 * @uml.property  name="Date"
	 */
	private String date;

	/**
	 * Getter of the property <tt>Date</tt>
	 * @return  Returns the date.
	 * @uml.property  name="Date"
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Setter of the property <tt>Date</tt>
	 * @param Date  The date to set.
	 * @uml.property  name="Date"
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @uml.property  name="Content"
	 */
	private String content;

	/**
	 * Getter of the property <tt>Content</tt>
	 * @return  Returns the content.
	 * @uml.property  name="Content"
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Setter of the property <tt>Content</tt>
	 * @param Content  The content to set.
	 * @uml.property  name="Content"
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @uml.property  name="IsRetweet"
	 */
	private boolean isRetweet;

	/**
	 * Getter of the property <tt>IsRetweet</tt>
	 * @return  Returns the isRetweet.
	 * @uml.property  name="IsRetweet"
	 */
	public boolean isIsRetweet() {
		return isRetweet;
	}

	/**
	 * Setter of the property <tt>IsRetweet</tt>
	 * @param IsRetweet  The isRetweet to set.
	 * @uml.property  name="IsRetweet"
	 */
	public void setIsRetweet(boolean isRetweet) {
		this.isRetweet = isRetweet;
	}

	/**
	 * @uml.property  name="HadPic"
	 */
	private boolean hadPic;

	/**
	 * Getter of the property <tt>HadPic</tt>
	 * @return  Returns the hadPic.
	 * @uml.property  name="HadPic"
	 */
	public boolean isHadPic() {
		return hadPic;
	}

	/**
	 * Setter of the property <tt>HadPic</tt>
	 * @param HadPic  The hadPic to set.
	 * @uml.property  name="HadPic"
	 */
	public void setHadPic(boolean hadPic) {
		this.hadPic = hadPic;
	}

	/**
	 * @uml.property  name="PicURL"
	 */
	private String picURL;

	/**
	 * Getter of the property <tt>PicURL</tt>
	 * @return  Returns the picURL.
	 * @uml.property  name="PicURL"
	 */
	public String getPicURL() {
		return picURL;
	}

	/**
	 * Setter of the property <tt>PicURL</tt>
	 * @param PicURL  The picURL to set.
	 * @uml.property  name="PicURL"
	 */
	public void setPicURL(String picURL) {
		this.picURL = picURL;
	}

	/**
	 * @uml.property  name="RetweetCount"
	 */
	private int retweetCount;

	/**
	 * Getter of the property <tt>RetweetCount</tt>
	 * @return  Returns the retweetCount.
	 * @uml.property  name="RetweetCount"
	 */
	public int getRetweetCount() {
		return retweetCount;
	}

	/**
	 * Setter of the property <tt>RetweetCount</tt>
	 * @param RetweetCount  The retweetCount to set.
	 * @uml.property  name="RetweetCount"
	 */
	public void setRetweetCount(int retweetCount) {
		this.retweetCount = retweetCount;
	}

	/**
	 * @uml.property  name="CommentCount"
	 */
	private int commentCount;

	/**
	 * Getter of the property <tt>CommentCount</tt>
	 * @return  Returns the commentCount.
	 * @uml.property  name="CommentCount"
	 */
	public int getCommentCount() {
		return commentCount;
	}

	/**
	 * Setter of the property <tt>CommentCount</tt>
	 * @param CommentCount  The commentCount to set.
	 * @uml.property  name="CommentCount"
	 */
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

}
