package dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.IT_MemberVO;

public class IT_MemberDAO {

	SqlSession sqlSession;

	public IT_MemberDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	// 회원가입 전 이름과 전화번호를 비교해 계정이있는지 확인
	public int m_check(String tel) {
		int res = sqlSession.selectOne("m.check", tel);
		return res;
	}

	// 뷰형태의 회원정보 한명 받아오기
	public IT_MemberVO member_info_view(String m_idx) {
		IT_MemberVO vo = sqlSession.selectOne("m.member_info", m_idx);
		return vo;
	}
	
	// 뷰형태의 회원정보 한명 받아오기 (회원 M_id 기준)
	public IT_MemberVO member_info_view_id(String m_id) {
		IT_MemberVO vo = sqlSession.selectOne("m.member_info_id",m_id);
		return vo;
	}

	public int check_id(String id) {
		int res = sqlSession.selectOne("m.check_id", id);
		return res;
	}

	public int insert(IT_MemberVO vo) {
		// System.out.println(vo);
		int res = sqlSession.insert("m.member_insert", vo);
		return res;
	}

	public IT_MemberVO login_check(String id) {
		IT_MemberVO vo = sqlSession.selectOne("m.login_check", id);
		return vo;
	}

	public IT_MemberVO result_id(Map<String, String> map) {
		IT_MemberVO vo = sqlSession.selectOne("m.result_id", map);
		return vo;
	}

	public IT_MemberVO result_pw(Map<String, String> map) {
		IT_MemberVO vo = sqlSession.selectOne("m.result_pw", map);
		return vo;
	}

}
