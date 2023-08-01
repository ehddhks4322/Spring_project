package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.IT_Chat_MessageVO;

public class IT_Chat_MessageDAO {

	SqlSession sqlSession;

	public IT_Chat_MessageDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public int CheckNumb_rec(String receiver_idx) {
		return sqlSession.selectOne("cm.checkNumb_rec", receiver_idx);
	}

	public List<IT_Chat_MessageVO> my_recBox(String receiver_idx) {
		List<IT_Chat_MessageVO> list = sqlSession.selectList("cm.my_Box_rec", receiver_idx);

		return list;
	}

	public List<IT_Chat_MessageVO> my_sendBox(String sender_idx) {
		List<IT_Chat_MessageVO> list = sqlSession.selectList("cm.my_Box_send", sender_idx);

		return list;
	}

	public int CheckNumb_send(String sender_idx) {
		return sqlSession.selectOne("cm.checkNumb_send", sender_idx);
	}

	public int sendMsg(IT_Chat_MessageVO vo) {
		int res = sqlSession.insert("cm.sendMsg", vo);
		return res;
	}


	public int resend_Msg(int ic_idx) {
		int res = sqlSession.update("cm.resend_msg", ic_idx);

		return res;
	}

}
