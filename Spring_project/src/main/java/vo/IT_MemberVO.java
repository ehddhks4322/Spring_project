package vo;

public class IT_MemberVO {

	private String m_idx; //회원번호
	private String m_name; //회원 이름
	private String m_id; //회원 아이디
	private String m_pw; //회원 비밀번호
	private String m_tel; //회원 전화번호
	private String m_email;
	private String m_loc; //회원 주소\
	public String getM_idx() {
		return m_idx;
	}
	public void setM_idx(String m_idx) {
		this.m_idx = m_idx;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		
		this.m_id = m_id;
	}
	public String getM_pw() {
		return m_pw;
	}
	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}
	public String getM_tel() {
		return m_tel;
	}
	public void setM_tel(String m_tel) {
		this.m_tel = m_tel;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	public String getM_loc() {
		return m_loc;
	}
	public void setM_loc(String m_loc) {
		this.m_loc = m_loc;
	}
	
//	public IT_MemberVO(String m_idx, String m_id,String m_name,String m_pw, String m_tel, String m_loc, String m_email) {
//		System.out.println(m_idx);
//		System.out.println(m_id);
//		System.out.println(m_name);
//		System.out.println(m_pw);
//		System.out.println(m_tel);
//		System.out.println(m_email);
//		System.out.println(m_loc);
//	}
		
}
