/**
 * 
 */
package hk.edu.uic.dbms.weibo.model.vo;

/** 
 * @author cofthew7
 */
public class Comment {

	/**
	 * 
	 */
	public Comment() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @uml.property  name="CommentsID"
	 */
	private int commentsID;

	/**
	 * Getter of the property <tt>CommentsID</tt>
	 * @return  Returns the commentsID.
	 * @uml.property  name="CommentsID"
	 */
	public int getCommentsID() {
		return commentsID;
	}

	/**
	 * Setter of the property <tt>CommentsID</tt>
	 * @param CommentsID  The commentsID to set.
	 * @uml.property  name="CommentsID"
	 */
	public void setCommentsID(int commentsID) {
		this.commentsID = commentsID;
	}

	/**
	 * @uml.property  name="TweetsID"
	 */
	private int tweetsID;

	/**
	 * Getter of the property <tt>TweetsID</tt>
	 * @return  Returns the tweetsID.
	 * @uml.property  name="TweetsID"
	 */
	public int getTweetsID() {
		return tweetsID;
	}

	/**
	 * Setter of the property <tt>TweetsID</tt>
	 * @param TweetsID  The tweetsID to set.
	 * @uml.property  name="TweetsID"
	 */
	public void setTweetsID(int tweetsID) {
		this.tweetsID = tweetsID;
	}

	/**
	 * @uml.property  name="InsertUID"
	 */
	private int insertUID;

	/**
	 * Getter of the property <tt>InsertUID</tt>
	 * @return  Returns the insertUID.
	 * @uml.property  name="InsertUID"
	 */
	public int getInsertUID() {
		return insertUID;
	}

	/**
	 * Setter of the property <tt>InsertUID</tt>
	 * @param InsertUID  The insertUID to set.
	 * @uml.property  name="InsertUID"
	 */
	public void setInsertUID(int insertUID) {
		this.insertUID = insertUID;
	}

	/**
	 * @uml.property  name="Date"
	 */
	private String date;

	
	
	private int Author;
	public int getAuthor() {
		return Author;
	}
	public void setAuthor(int author) {
		this.Author = author;
	}
	
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

}
