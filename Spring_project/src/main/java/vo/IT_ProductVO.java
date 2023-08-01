package vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class IT_ProductVO {

	private String p_idx;
	private String p_name;
	private int p_code;
	private int p_price;
	private int p_state;
	private String p_text;
	private String p_img1;
	private String p_img2;
	private String p_img3;
	private String p_date;
	private int p_heart;
	private String p_hit;
	private String m_idx;
	private String m_id;
	private String m_loc;
	
	public String getM_loc() {
		return m_loc;
	}
	public void setM_loc(String m_loc) {
		this.m_loc = m_loc;
	}
	public String getP_idx() {
		return p_idx;
	}
	public void setP_idx(String p_idx) {
		this.p_idx = p_idx;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public int getP_code() {
		return p_code;
	}
	public void setP_code(int p_code) {
		this.p_code = p_code;
	}
	public int getP_price() {
		return p_price;
	}
	public void setP_price(int p_price) {
		this.p_price = p_price;
	}
	public String getP_text() {
		return p_text;
	}
	public void setP_text(String p_text) {
		this.p_text = p_text;
	}
	public String getP_img1() {
		return p_img1;
	}
	public void setP_img1(String p_img1) {
		this.p_img1 = p_img1;
	}
	public String getP_img2() {
		return p_img2;
	}
	public void setP_img2(String p_img2) {
		this.p_img2 = p_img2;
	}
	public String getP_img3() {
		return p_img3;
	}
	public void setP_img3(String p_img3) {
		this.p_img3 = p_img3;
	}
	public String getP_date() {
		return p_date;
	}
	public void setP_date(String p_date) {
		this.p_date = p_date;
	}
	public int getP_heart() {
		return p_heart;
	}
	public void setP_heart(int p_heart) {
		this.p_heart = p_heart;
	}
	public String getP_hit() {
		return p_hit;
	}
	public void setP_hit(String p_hit) {
		this.p_hit = p_hit;
	}
	public String getM_idx() {
		return m_idx;
	}
	public void setM_idx(String m_idx) {
		this.m_idx = m_idx;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public int getP_state() {
		return p_state;
	}
	public void setP_state(int p_state) {
		this.p_state = p_state;
	}
	
	
}
