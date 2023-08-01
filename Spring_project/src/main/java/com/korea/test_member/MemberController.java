package com.korea.test_member;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import dao.IT_BoardDAO;
import dao.IT_Board_DetailDAO;
import dao.IT_MemberDAO;
import dao.IT_Member_DetailDAO;
import dao.IT_ProductDAO;
import service.CertifiedPhoneNumber;
import util.Common;
import util.Paging;
import vo.IT_BoardVO;
import vo.IT_Board_DetailVO;
import vo.IT_MemberVO;
import vo.IT_Member_DetailVO;
import vo.IT_PhotoVO;
import vo.IT_ProductVO;

@Controller
public class MemberController {

	@Autowired
	HttpServletRequest request;

	@Autowired
	HttpSession session;

	@Autowired
	ServletContext application;

	IT_BoardDAO board_dao;
	IT_Board_DetailDAO board_detail_dao;
	IT_MemberDAO member_dao;
	IT_Member_DetailDAO member_detail_dao;
	IT_ProductDAO product_dao;

	public MemberController(IT_BoardDAO board_dao, IT_Board_DetailDAO board_detail_dao, IT_MemberDAO member_dao,
			IT_Member_DetailDAO member_detail_dao, IT_ProductDAO product_dao) {
		this.board_dao = board_dao;
		this.board_detail_dao = board_detail_dao;
		this.member_dao = member_dao;
		this.member_detail_dao = member_detail_dao;
		this.product_dao = product_dao;
	}

	public static final String VIEW_PATH = "/WEB-INF/views/";

	@RequestMapping(value = { "/", "start.do" })
	public String start_screen() {
		return VIEW_PATH + "StartScreen.jsp";
	}

	@RequestMapping("header.do")
	public String header() {
		return VIEW_PATH + "header.jsp";
	}

	@RequestMapping("insert_first.do")
	public String insert_first() {
		return VIEW_PATH + "/login_insert/insert_2.jsp";
	}

	@RequestMapping("insert_start.do")
	@ResponseBody
	public String insert_start(String tel) {

		System.out.println(tel);
		int res = member_dao.m_check(tel);

		if (res > 0) {
			return "[{'result':'no'}]";
		}
		return "[{\"result\":\"yes\", \"tel\":\"" + tel + "\"}]";
	}

	@RequestMapping("insert_form.do")
	public String insert_form(Model model, String tel_main) {

		model.addAttribute("tel", tel_main);

		return VIEW_PATH + "/login_insert/insert.jsp";
	}

	@RequestMapping("login_form.do")
	public String login_form() {
		return VIEW_PATH + "/login_insert/login_form.jsp";
	}

	@RequestMapping("send_sms.do")
	@ResponseBody
	public String send_sms(String tel, HttpServletRequest request) {

		// 인증번호 생성
		Random rnd = new Random();
		String num = "";
		for (int i = 0; i < 4; i++) {
			String ran = Integer.toString(rnd.nextInt(10));
			num += ran;
		}

		// 인증번호 발송
		CertifiedPhoneNumber certifiedPhoneNumber = new CertifiedPhoneNumber();
		certifiedPhoneNumber.certifiedPhoneNumber(tel, num);

		// num 값을 JSP 파일로 넘기기 위해 request 객체에 저장
		request.setAttribute("num", num);

		// 결과에 따라 JSON 응답 생성
		boolean success = (num != null && num.length() > 0);
		String response;
		if (success) {
			response = "[{\"result\":\"yes\", \"num\":\"" + num + "\"}]";
		} else {
			response = "[{'result':'no'}]";
		}

		return response;
	}

	@RequestMapping("check_id.do")
	@ResponseBody
	public String check_id(String id) {

		int res = member_dao.check_id(id);

		if (res > 0) {
			return "[{'result':'no'}]";
		}
		return "[{'result':'yes'}]";

	}

	// 회원가입
	@RequestMapping("insert.do")
	public String insert(IT_MemberVO vo) {
		// System.out.println("con"+vo.getM_id());
		int res = member_dao.insert(vo);
		System.out.println(vo.getM_id());

		if (res > 0) {
			return VIEW_PATH + "/login_insert/login_form.jsp";
		}
		return null;

	}

	// 로그인
	@RequestMapping("login.do")
	@ResponseBody
	public String login(String id, String pw, HttpSession session) {

		IT_MemberVO vo = member_dao.login_check(id);
		// 아이디 존재X
		if (vo == null) {
			return "[{'result':'no_id'}]";
		}
		// 비밀번호 일치X
		if (!vo.getM_pw().equals(pw)) {
			return "[{'result':'no_pw'}]";
		}

		session.setAttribute("id", vo);
		session.setAttribute("m_idx", vo.getM_idx());

		return "[{'result':'clear'}]";

	}

	// 로그아웃
	@RequestMapping("logout.do")
	public String logout() {
		session.removeAttribute("id");

		// 세션에 들어있는 모든 속성을 제거한다.
		// session.invalidate();

		return "redirect:start.do";
	}

	// 아이디 찾기로 이동
	@RequestMapping("find_id.do")
	public String find_id() {
		return VIEW_PATH + "/login_insert/find_id.jsp";
	}

	// 아이디 찾기
	@RequestMapping("result_id.do")
	@ResponseBody
	public String result_id(String name, String tel) {

		Map<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("tel", tel);

		IT_MemberVO vo = member_dao.result_id(map);

		if (vo == null) {
			return "[{'result':'no'}]";
		} else {
			return "[{\"result\":\"yes\", \"id\":\"" + vo.getM_id() + "\"}]";
		}

	}

	// 비밀번호 찾기로 이동
	@RequestMapping("find_pw.do")
	public String find_pw() {
		return VIEW_PATH + "/login_insert/find_pw.jsp";
	}

	// 비밀번호 찾기
	@RequestMapping("result_pw.do")
	@ResponseBody
	public String result_pw(String name, String id) {
		System.out.println(name);
		System.out.println(id);
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("id", id);

		IT_MemberVO vo = member_dao.result_pw(map);

		if (vo == null) {
			return "[{'result':'no'}]";
		} else {
			return "[{\"result\":\"yes\", \"pw\":\"" + vo.getM_pw() + "\"}]";
		}

	}

	@RequestMapping("board_list.do")
	public String list(Model model, String page) {
		int nowPage = 1;

		if (page != null && !page.isEmpty()) {
			nowPage = Integer.parseInt(page);
		}

		// 한 페이지에 표시될 게시물의 시작과 끝번호를 계산
		int start = (nowPage - 1) * Common.Board.BLOCKLIST + 1;
		int end = start + Common.Board.BLOCKLIST - 1;

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("end", end);

		// 페이지번호에 따른 전체 게시글 조회
		List<IT_BoardVO> list = board_dao.select(map);

		// 전체 게시물 수 조회
		int rowTotal = board_dao.getRowTotal();

		// 페이지 메뉴 생성하기
		String pageMenu = Paging.getPaging("board_list.do", nowPage, rowTotal, Common.Board.BLOCKLIST,
				Common.Board.BLOCKPAGE);

		request.getSession().removeAttribute("show");

		model.addAttribute("list", list);
		model.addAttribute("pageMenu", pageMenu);

		return VIEW_PATH + "/board/board_list.jsp?page=" + nowPage;
	}

	@RequestMapping("board_insert_form.do")
	public String board_insert_form() {
		return VIEW_PATH + "/board/board_insert.jsp";
	}

	@RequestMapping("board_insert.do")
	public String board_insert(int b_head, String subject, String content, String m_idx) {
		IT_BoardVO vo = new IT_BoardVO();

		String ip = request.getRemoteAddr();
		vo.setIp(ip);
		vo.setB_head(b_head);
		vo.setM_idx(m_idx);
		vo.setSubject(subject);
		vo.setContent(content);

		System.out.println(vo.getB_head());
		System.out.println(vo.getM_idx());
		System.out.println(vo.getContent());

		int res = board_dao.insert(vo);

		if (res > 0) {
			return "redirect:board_list.do";
		}

		return null;
	}

	@RequestMapping("board_search.do")
	public String board_search(Model model, int selectOption, String text, String page) {

		int nowPage = 1;

		if (page != null && !page.isEmpty()) {
			nowPage = Integer.parseInt(page);
		}

		// 한 페이지에 표시될 게시물의 시작과 끝번호를 계산
		int start = (nowPage - 1) * Common.Board.BLOCKLIST + 1;
		int end = start + Common.Board.BLOCKLIST - 1;

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("text", text);
		map.put("selectOption", selectOption);
		map.put("start", start);
		map.put("end", end);

		// 검색 게시물 수 조회
		int rowTotal = board_dao.getSearchRowTotal(map);

		// 페이지 메뉴 생성하기
		String pageMenu = Paging.getPaging("board_search.do", nowPage, rowTotal, Common.Board.BLOCKLIST,
				Common.Board.BLOCKPAGE);

		List<IT_BoardVO> list = board_dao.searchList(map);

		request.getSession().removeAttribute("show");

		model.addAttribute("list", list);
		model.addAttribute("pageMenu", pageMenu);

		return VIEW_PATH + "/board/board_list.jsp?page=" + nowPage;
	}

	@RequestMapping("board_inside.do")
	public String board_inside(Model model, int b_idx, int page) {

		IT_BoardVO vo = board_dao.selectOne(b_idx);
		int comment = board_detail_dao.getCommentTotal(b_idx);

		List<IT_Board_DetailVO> list = board_detail_dao.select(b_idx);

		// 한번 클릭할때마다 조회수가 1씩 증가(F5연타해서 조회수 증가를 막아야 함)
		// 조회수 증가
		HttpSession session = request.getSession();
		String show = (String) session.getAttribute("show");

		if (show == null) {
			int res = board_dao.update_readhit(b_idx);
			session.setAttribute("show", "0");
		}

		model.addAttribute("vo", vo);
		model.addAttribute("comment", comment);
		model.addAttribute("list", list);

		return VIEW_PATH + "/board/board_inside.jsp";
	}

	// 글 삭제
	@RequestMapping("b_del.do")
	@ResponseBody
	public String del(int b_idx) {

		int res = board_dao.delete(b_idx);

		if (res > 0) {
			return "[{'result':'yes'}]";
		}
		return "[{'result':'no'}]";

	}

	// 댓글 등록
	@RequestMapping("bd_insert.do")
	@ResponseBody
	public String bd_insert(String bd_content, int b_idx, String m_idx) {
		IT_Board_DetailVO vo = new IT_Board_DetailVO();
		String ip = request.getRemoteAddr();
		vo.setBd_ip(ip);
		vo.setBd_content(bd_content);
		vo.setB_idx(b_idx);
		vo.setM_idx(m_idx);

		int res2 = board_detail_dao.updateStep(vo.getB_idx());
		int res = board_detail_dao.insert(vo);

		if (res > 0) {
			return "[{'result':'yes'}]";
		}
		return "[{'result':'no'}]";
	}

	// 댓글 등록2
	@RequestMapping("bd_insert2.do")
	@ResponseBody
	public String bd_insert2(String bd_content, int b_idx, String m_idx) {
		IT_Board_DetailVO vo = new IT_Board_DetailVO();
		String ip = request.getRemoteAddr();
		vo.setBd_ip(ip);
		vo.setBd_content(bd_content);
		vo.setB_idx(b_idx);
		vo.setM_idx(m_idx);

		int res2 = board_detail_dao.updateStep(vo.getB_idx());
		int res = board_detail_dao.insert2(vo);

		if (res > 0) {
			return "[{'result':'yes'}]";
		}
		return "[{'result':'no'}]";
	}

	// 댓글 삭제
	@RequestMapping("bd_del.do")
	@ResponseBody
	public String delete(int bd_idx) {

		int res = board_detail_dao.delete(bd_idx);

		if (res > 0) {
			return "[{'result':'yes'}]";
		}
		return "[{'result':'no'}]";

	}

	@RequestMapping("main.do")
	public String main(HttpSession session, Model model) {
		IT_MemberVO vo = (IT_MemberVO) session.getAttribute("id");
		if (vo == null) {
			return VIEW_PATH + "/login_insert/login_form.jsp";
		}
		List<IT_ProductVO> list = product_dao.selectList();

		model.addAttribute("list", list);
		return VIEW_PATH + "MainScreen.jsp";
	}

	@RequestMapping("main_code.do")
	public String main_code(Model model, int p_code) {
		List<IT_ProductVO> list = product_dao.selectCodeList(p_code);

		model.addAttribute("list", list);
		return VIEW_PATH + "MainScreen.jsp";
	}

	@RequestMapping("my_page.do")
	public String my_page(Model model) {
		String m_idx = (String) session.getAttribute("m_idx");
		System.out.println(m_idx);
		// String my_idx = (String) session.getAttribute("my_idx");
		System.out.println(m_idx);

		List<IT_ProductVO> list = product_dao.my_selectList(m_idx);

		List<IT_Member_DetailVO> md_list = member_detail_dao.my_selectList(m_idx);
		// System.out.println(list);
		model.addAttribute("list", list);
		model.addAttribute("md_list", md_list);
		// System.out.println(md_list);
		return VIEW_PATH + "my_page.jsp";
	}

	@RequestMapping("loc_guide.do")
	public String loc_guide() {
		return VIEW_PATH + "loc_guide.jsp";
	}

	// 상품 추가 페이지 이동
	@RequestMapping("product.do")
	public String product() {
		return VIEW_PATH + "/product/product_insert.jsp";
	}

	@RequestMapping("product_view.do")
	public String product_view(Model model, String p_idx) {
		IT_ProductVO vo = product_dao.selectOne(p_idx);

		model.addAttribute("vo", vo);
		return VIEW_PATH + "/product/product_view.jsp";
	}

	@RequestMapping("product_update_view.do")
	public String product_update_view(Model model, String p_idx) {
		IT_ProductVO vo = product_dao.selectOne(p_idx);

		model.addAttribute("vo", vo);
		return VIEW_PATH + "/product/product_update.jsp";
	}

	@RequestMapping("product_delete.do")
	@ResponseBody
	public String product_delete(String p_idx) {
		int res2 = member_detail_dao.delete(p_idx);
		int res = product_dao.delete(p_idx);

		if (res > 0) {
			return "[{'result':'yes'}]";
		}
		return "[{'result':'no'}]";
	}

	@RequestMapping("product_update.do")
	@ResponseBody
	public String product_update(String p_name, int p_price, String p_text, String p_idx, int p_state) {

		IT_ProductVO vo = new IT_ProductVO();

		vo.setP_name(p_name);
		vo.setP_price(p_price);
		vo.setP_text(p_text);
		vo.setP_idx(p_idx);
		vo.setP_state(p_state);

		int res = product_dao.update(vo);

		if (res > 0) {
			return "[{'result':'yes'}]";
		}
		return "[{'result':'no'}]";
	}

	// 상품 추가
	@RequestMapping("product_insert.do")
	public String product_insert(String m_idx, String p_name, int p_price, String p_text, int p_code,
			MultipartFile p_img1, MultipartFile p_img2, MultipartFile p_img3) {
		IT_ProductVO pd_vo = new IT_ProductVO();
		IT_PhotoVO ph_vo = new IT_PhotoVO();

		String webPath = "resources/upload";
		String savePath = application.getRealPath(webPath);
		System.out.println(savePath);

		String filename1 = "no_file";
		String filename2 = "no_file";
		String filename3 = "no_file";

		if (!p_img1.isEmpty()) {
			// getOriginalFilename() : 업로드된 실제 파일명
			filename1 = p_img1.getOriginalFilename();

			// 파일을 저장할 경로를 설정
			File saveFile = new File(savePath, filename1);

			if (!saveFile.exists()) {// 경로가 없다면
				// 폴더를 만들어라
				saveFile.mkdirs();
			} else {
				// 동일한 이름의 파일일 경우 폴더형태로 변환이 불가하므로
				// 업로드한 시간을 붙여서 이름이 중복되는것을 방지

				// 자바가 만들어진 1970년부터 2023년 현재까지의 시간을 1000분의 1초로 저장을한다.
				long time = System.currentTimeMillis();
				filename1 = String.format("%d_%s", time, filename1);
				saveFile = new File(savePath, filename1);
			}

			try {
				p_img1.transferTo(saveFile);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ph_vo.setFilename1(filename1);
			pd_vo.setP_img1(filename1);
		}

		if (!p_img2.isEmpty()) {
			// getOriginalFilename() : 업로드된 실제 파일명
			filename2 = p_img2.getOriginalFilename();

			// 파일을 저장할 경로를 설정
			File saveFile = new File(savePath, filename2);

			if (!saveFile.exists()) {// 경로가 없다면
				// 폴더를 만들어라
				saveFile.mkdirs();
			} else {
				// 동일한 이름의 파일일 경우 폴더형태로 변환이 불가하므로
				// 업로드한 시간을 붙여서 이름이 중복되는것을 방지

				// 자바가 만들어진 1970년부터 2023년 현재까지의 시간을 1000분의 1초로 저장을한다.
				long time = System.currentTimeMillis();
				filename2 = String.format("%d_%s", time, filename2);
				saveFile = new File(savePath, filename2);
			}

			try {
				p_img2.transferTo(saveFile);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ph_vo.setFilename2(filename2);
			pd_vo.setP_img2(filename2);
		}

		if (!p_img3.isEmpty()) {
			// getOriginalFilename() : 업로드된 실제 파일명
			filename3 = p_img3.getOriginalFilename();

			// 파일을 저장할 경로를 설정
			File saveFile = new File(savePath, filename3);

			if (!saveFile.exists()) {// 경로가 없다면
				// 폴더를 만들어라
				saveFile.mkdirs();
			} else {
				// 동일한 이름의 파일일 경우 폴더형태로 변환이 불가하므로
				// 업로드한 시간을 붙여서 이름이 중복되는것을 방지

				// 자바가 만들어진 1970년부터 2023년 현재까지의 시간을 1000분의 1초로 저장을한다.
				long time = System.currentTimeMillis();
				filename3 = String.format("%d_%s", time, filename3);
				saveFile = new File(savePath, filename3);
			}

			try {
				p_img3.transferTo(saveFile);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ph_vo.setFilename3(filename3);
			pd_vo.setP_img3(filename3);
		}

		pd_vo.setM_idx(m_idx);
		pd_vo.setP_name(p_name);
		pd_vo.setP_price(p_price);
		pd_vo.setP_text(p_text);
		pd_vo.setP_code(p_code);

		int res = product_dao.product_insert(pd_vo);

		if (res > 0) {
			return "redirect:main.do";

		}

		return null;
	}

	// 찜 기능
	@RequestMapping("add_heart.do")
	@ResponseBody
	public String add_heart(String m_idx, String p_idx, String my_idx, String m_idx_now) {
		// session.setAttribute("my_idx", my_idx);

		Map<String, String> map = new HashMap<>();
		map.put("m_idx", m_idx);
		map.put("my_idx", my_idx);
		map.put("p_idx", p_idx);

		IT_Member_DetailVO vo = member_detail_dao.get_wishlist(map);

		boolean whish = (vo != null);

		if (whish) {
			// 찜 목록에 이미 등록된 상태라면 삭제
			int res = member_detail_dao.delete(vo);

			if (res > 0) {
				return "[{'result':'removed'}]";
			} else {
				return "[{'result':'failure'}]";
			}
		} else {
			// 찜 목록에 등록되어 있지 않은 상태라면 추가
			vo = new IT_Member_DetailVO();
			vo.setM_idx(m_idx);
			vo.setMy_idx(my_idx);
			vo.setP_idx(p_idx);
			int res = member_detail_dao.insert(vo);

			if (res > 0) {
				return "[{'result':'added'}]";
			} else {
				return "[{'result':'failure2'}]";
			}
		}
	}

	@RequestMapping("product_search.do")
	public String product_search(Model model, String p_name) {
		List<IT_ProductVO> list = product_dao.search_selectList(p_name);

		model.addAttribute("list", list);
		return VIEW_PATH + "MainScreen.jsp";
	}

}
