/**
 * 
 */
package hk.edu.uic.dbms.weibo.model.vo;

/** 
 * @author cofthew7
 */
public class PrivateMessage {

	/**
	 * 
	 */
	public PrivateMessage() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @uml.property  name="PMID"
	 */
	private int pmid;

	/**
	 * Getter of the property <tt>PMID</tt>
	 * @return  Returns the pmid.
	 * @uml.property  name="PMID"
	 */
	public int getPMID() {
		return pmid;
	}

	/**
	 * Setter of the property <tt>PMID</tt>
	 * @param PMID  The pmid to set.
	 * @uml.property  name="PMID"
	 */
	public void setPMID(int pmid) {
		this.pmid = pmid;
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
	 * @uml.property  name="ReceiverUID"
	 */
	private int receiverUID;

	/**
	 * Getter of the property <tt>ReceiverUID</tt>
	 * @return  Returns the receiverUID.
	 * @uml.property  name="ReceiverUID"
	 */
	public int getReceiverUID() {
		return receiverUID;
	}

	/**
	 * Setter of the property <tt>ReceiverUID</tt>
	 * @param ReceiverUID  The receiverUID to set.
	 * @uml.property  name="ReceiverUID"
	 */
	public void setReceiverUID(int receiverUID) {
		this.receiverUID = receiverUID;
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

	

}
