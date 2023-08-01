package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.IT_Board_DetailVO;

public class IT_Board_DetailDAO {

	SqlSession sqlSession;

	public IT_Board_DetailDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	// 댓글 조회
	public List<IT_Board_DetailVO> select(int b_idx) {
		List<IT_Board_DetailVO> list = sqlSession.selectList("bd.bd_list", b_idx);
		return list;
	}
	
	// 해당 게시물의 전체 댓글 수 조회
	public int getCommentTotal(int b_idx) {
		int res = sqlSession.selectOne("bd.bd_count",b_idx);
		return res;
	}
	
	// 댓글 등록
	public int insert(IT_Board_DetailVO vo) {
		int res = sqlSession.insert("bd.bd_insert",vo);
		return res;
	}
	
	// 댓글 등록2
	public int insert2(IT_Board_DetailVO vo) {
		int res = sqlSession.insert("bd.bd_insert2",vo);
		return res;
	}
	
	
	public int updateStep(int b_idx) {
		int res = sqlSession.update("bd.bd_updateStep",b_idx);
		
		return res;
	}
	
	public int delete(int bd_idx) {
		int res = sqlSession.delete("bd.bd_delete",bd_idx);
		
		return res;
	}

}
