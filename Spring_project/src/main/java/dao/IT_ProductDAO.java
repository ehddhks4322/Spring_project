package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.IT_ProductVO;

public class IT_ProductDAO {
	
	SqlSession sqlSession;
	
	public IT_ProductDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<IT_ProductVO> selectList(){
		List<IT_ProductVO> list = sqlSession.selectList("p.product_list");
		return list;
	}
	
	public List<IT_ProductVO> search_selectList(String p_name){
		List<IT_ProductVO> list = sqlSession.selectList("p.product_search_list",p_name);
		return list;
	}
	
	public List<IT_ProductVO> selectCodeList(int p_code){
		List<IT_ProductVO> list = sqlSession.selectList("p.product_code_list",p_code);
		return list;
	}
	
	public IT_ProductVO selectOne(String p_idx) {
		IT_ProductVO vo = sqlSession.selectOne("p.product_selectOne",p_idx);
		return vo;
	}
	
	public int delete(String p_idx) {
		int res = sqlSession.delete("p.product_delete",p_idx);
		return res;
	}
	
	public int update(IT_ProductVO vo) {
		
		System.out.println(vo.getP_price());
		int res = sqlSession.update("p.product_update",vo);
		return res;
	}
	
	public int product_insert(IT_ProductVO pd_vo) {
		int res = sqlSession.insert("p.product_insert",pd_vo);
		return res;
	}
	
	//마이페이지를 위한 조회
	public List<IT_ProductVO> my_selectList(String m_idx){
		List<IT_ProductVO> list = sqlSession.selectList("p.my_product_list",m_idx);
		return list;
	}
}
