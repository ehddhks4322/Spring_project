package com.korea.test_member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.IT_ChatDAO;
import dao.IT_Chat_MessageDAO;
import dao.IT_MemberDAO;
import vo.IT_Chat_MessageVO;
import vo.IT_MemberVO;

@Controller
public class ChatController {

	@Autowired
	HttpServletRequest request;

	@Autowired
	HttpSession session;

	@Autowired
	HttpServletRequest req;

	IT_ChatDAO chat_dao;
	IT_Chat_MessageDAO message_dao;
	IT_MemberDAO member_dao;

	public ChatController(IT_ChatDAO chat_dao, IT_Chat_MessageDAO message_dao, IT_MemberDAO member_dao) {
		this.chat_dao = chat_dao;
		this.member_dao = member_dao;
		this.message_dao = message_dao;
	}

	public static final String VIEW_PATH = "/WEB-INF/views/chat/";

	@RequestMapping("send_msg.do")
	public String send_msg(String subject, String content, String receiver_id) {
		IT_MemberVO receiver_vo = member_dao.member_info_view_id(receiver_id);
		IT_MemberVO sender_vo = (IT_MemberVO)session.getAttribute("id"); 
		
		IT_Chat_MessageVO send = new IT_Chat_MessageVO();
		send.setSubject(subject);
		send.setContent(content);
		send.setReceiver_idx(receiver_vo.getM_idx());
		send.setReceiver_name(receiver_vo.getM_name());
		send.setReceiver_id(receiver_vo.getM_id());
		send.setSender_idx(sender_vo.getM_idx());
		send.setSender_name(sender_vo.getM_name());
		send.setSender_id(sender_vo.getM_id());
		send.setIs_read("읽지않음");
		
		
		int res = message_dao.sendMsg(send);

		if (res > 0) {
			return "redirect:message.do";
		}

		return null;

	}

	@RequestMapping("message_insert_form.do")
	public String chat_insert_form() {
		return VIEW_PATH + "message_insert.jsp";
	}


	@RequestMapping("message.do")
	public String my_msg(Model model) {

		IT_MemberVO vo = (IT_MemberVO) session.getAttribute("id");

		List<IT_Chat_MessageVO> rec = message_dao.my_recBox(vo.getM_idx());
		List<IT_Chat_MessageVO> send = message_dao.my_sendBox(vo.getM_idx());

		model.addAttribute("rec", rec);
		model.addAttribute("send", send);

		return VIEW_PATH + "message_list.jsp";
	}


}
