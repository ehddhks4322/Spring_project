package util;

public class Common {
	//여러가지 기능들을 편리하게 관리하기 위해서 설정용 클래스를
	//따로 만듦
	
	public static final String VIWE_PATH = "/WEB-INF/views/board/";
	
	//일반게시판용
	public static class Board{
		
		//한 페이지에 보여줄 게시물 개수
		public final static int BLOCKLIST = 12;
		
		//페이지 메뉴 개수
		public final static int BLOCKPAGE = 3;
		
		//Commmon.Board.BLOCKLIST;-> 10
		
	}
	
}
