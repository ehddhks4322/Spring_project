package vo;

import java.sql.Date;

public class IT_Chat_MessageVO {
	private int ic_idx;
	private String receiver_idx;
	private String sender_idx;
	private String receiver_name;
	private String sender_name;
	private String receiver_id;
	private String sender_id;
	private String content;
	private Date send_time;
	private String is_read;
	private String subject;

	public int getIc_idx() {
		return ic_idx;
	}

	public void setIc_idx(int ic_idx) {
		this.ic_idx = ic_idx;
	}

	public String getReceiver_idx() {
		return receiver_idx;
	}

	public void setReceiver_idx(String receiver_idx) {
		this.receiver_idx = receiver_idx;
	}

	public String getSender_idx() {
		return sender_idx;
	}

	public void setSender_idx(String sender_idx) {
		this.sender_idx = sender_idx;
	}

	public String getReceiver_name() {
		return receiver_name;
	}

	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}

	public String getSender_name() {
		return sender_name;
	}

	public void setSender_name(String sender_name) {
		this.sender_name = sender_name;
	}

	public String getReceiver_id() {
		return receiver_id;
	}

	public void setReceiver_id(String receiver_id) {
		this.receiver_id = receiver_id;
	}

	public String getSender_id() {
		return sender_id;
	}

	public void setSender_id(String sender_id) {
		this.sender_id = sender_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getSend_time() {
		return send_time;
	}

	public void setSend_time(Date send_time) {
		this.send_time = send_time;
	}

	public String getIs_read() {
		return is_read;
	}

	public void setIs_read(String is_read) {
		this.is_read = is_read;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
