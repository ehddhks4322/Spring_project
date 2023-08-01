package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.IT_Member_DetailVO;

public class IT_Member_DetailDAO {
	
	SqlSession sqlSession;
	
	public IT_Member_DetailDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<IT_Member_DetailVO> my_selectList(String m_idx) {
		List<IT_Member_DetailVO> list = sqlSession.selectList("md.my_selectList",m_idx);
		return list;
	}

	public IT_Member_DetailVO get_wishlist(Map<String, String> map) {
		IT_Member_DetailVO vo = sqlSession.selectOne("md.get_wishlist",map);
		return vo;
	}
	
	public int insert(IT_Member_DetailVO vo) {
		int res = sqlSession.insert("md.insert_wishlist",vo);
		return res;
	}
	
	public int delete(IT_Member_DetailVO vo) {
		int res = sqlSession.delete("md.delete_wishlist",vo);
		return res;
	}
	
	public int delete(String p_idx) {
		int res = sqlSession.delete("md.delete_wishlist_2",p_idx);
		return res;
	}
	
	public int getNowHeart(Map<String, String> map2) {
		int heart_now = sqlSession.selectOne("md.search_heart",map2);
		return heart_now;
	}
}
