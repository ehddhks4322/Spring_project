package vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IT_Board_DetailVO {

	private int bd_idx, b_idx, step, depth;
	private String bd_content, m_idx, bd_ip, bd_regdate, m_id;

	public int getBd_idx() {
		return bd_idx;
	}

	public void setBd_idx(int bd_idx) {
		this.bd_idx = bd_idx;
	}

	public String getM_idx() {
		return m_idx;
	}

	public void setM_idx(String m_idx) {
		this.m_idx = m_idx;
	}

	public int getB_idx() {
		return b_idx;
	}

	public void setB_idx(int b_idx) {
		this.b_idx = b_idx;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public String getBd_content() {
		return bd_content;
	}

	public void setBd_content(String bd_content) {
		this.bd_content = bd_content;
	}

	public String getBd_ip() {
		return bd_ip;
	}

	public void setBd_ip(String bd_ip) {
		this.bd_ip = bd_ip;
	}

	public String getBd_regdate() {
		return bd_regdate;
	}

	public void setBd_regdate(String bd_regdate) {
		this.bd_regdate = bd_regdate;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

}
