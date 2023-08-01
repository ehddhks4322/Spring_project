package vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class IT_Member_DetailVO {

	private String md_idx;
	private String m_idx;
	private String my_idx;
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
	private String p_heart;
	private String p_hit;
	private String m_loc;
	private String m_id_now;

	public int getP_state() {
		return p_state;
	}

	public void setP_state(int p_state) {
		this.p_state = p_state;
	}

	public String getM_id_now() {
		return m_id_now;
	}

	public void setM_id_now(String m_id_now) {
		this.m_id_now = m_id_now;
	}

	public String getMd_idx() {
		return md_idx;
	}

	public void setMd_idx(String md_idx) {
		this.md_idx = md_idx;
	}

	public String getM_idx() {
		return m_idx;
	}

	public void setM_idx(String m_idx) {
		this.m_idx = m_idx;
	}

	public String getMy_idx() {
		return my_idx;
	}

	public void setMy_idx(String my_idx) {
		this.my_idx = my_idx;
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

	public String getP_heart() {
		return p_heart;
	}

	public void setP_heart(String p_heart) {
		this.p_heart = p_heart;
	}

	public String getP_hit() {
		return p_hit;
	}

	public void setP_hit(String p_hit) {
		this.p_hit = p_hit;
	}

	public String getM_loc() {
		return m_loc;
	}

	public void setM_loc(String m_loc) {
		this.m_loc = m_loc;
	}

}
