package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.IT_BoardVO;

public class IT_BoardDAO {

	SqlSession sqlSession;

	public IT_BoardDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	// 페이지별 게시글 조회
	public List<IT_BoardVO> select(HashMap<String, Integer> map) {
		List<IT_BoardVO> list = sqlSession.selectList("b.board_list", map);
		return list;
	}

	// 전체 게시물 수 조회
	public int getRowTotal() {
		int res = sqlSession.selectOne("b.board_count");
		return res;
	}

	/*
	 * public List<IT_BoardVO> searchList() { List<IT_BoardVO> list =
	 * sqlSession.selectList("b.search_list"); return list; }
	 */

	// 게시글 검색
	public List<IT_BoardVO> searchList(HashMap<String, Object> map) {
		List<IT_BoardVO> list = sqlSession.selectList("b.search_list", map);
		return list;

	}
	
	// 검색 게시물 수 조회
	public int getSearchRowTotal(HashMap<String, Object> map) {
		int res = sqlSession.selectOne("b.search_board_count", map);
		return res;
	}

	// 게시글 추가
	public int insert(IT_BoardVO vo) {
		int res = sqlSession.insert("b.board_insert", vo);
		return res;
	}
	
	// 게시글 들어가기
	public IT_BoardVO selectOne(int b_idx) {
		IT_BoardVO vo = sqlSession.selectOne("b.board_selectOne",b_idx);
		return vo;
	}
	
	//조회수 증가
	public int update_readhit(int b_idx) {
		int res = sqlSession.update("b.update_readhit",b_idx);
		return res;
	}
	
	// 게시글 삭제
	public int delete(int b_idx) {
		int res = sqlSession.delete("b.board_delete",b_idx);
		return res;
	}

}
