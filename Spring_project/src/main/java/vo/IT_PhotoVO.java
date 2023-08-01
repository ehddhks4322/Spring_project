package vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class IT_PhotoVO {
	
	
	private String filename1;
	private String filename2;
	private String filename3;//실제 파일 제목
	
	public String getFilename1() {
		return filename1;
	}
	public void setFilename1(String filename1) {
		this.filename1 = filename1;
	}
	public String getFilename2() {
		return filename2;
	}
	public void setFilename2(String filename2) {
		this.filename2 = filename2;
	}
	public String getFilename3() {
		return filename3;
	}
	public void setFilename3(String filename3) {
		this.filename3 = filename3;
	}
	
	
}
