package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.IT_ChatVO;

public class IT_ChatDAO {

	SqlSession sqlSession;

	public IT_ChatDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	// 페이지별 채팅 조회
	public List<IT_ChatVO> select(HashMap<String, Integer> map) {
		List<IT_ChatVO> list = sqlSession.selectList("c.chat_list", map);
		return list;
	}

	// 전체 채팅룸 수 조회
	public int getRowTotal() {
		int res = sqlSession.selectOne("c.chat_count");
		return res;
	}
	


	// 채팅글 추가
	public int insert(IT_ChatVO vo) {
		int res = sqlSession.insert("c.chat_insert", vo);
		return res;
	}
	public IT_ChatVO selectOne(int c_idx) {
		IT_ChatVO vo = sqlSession.selectOne("c.chat_selectOne",c_idx);
		return vo;
	}
}
