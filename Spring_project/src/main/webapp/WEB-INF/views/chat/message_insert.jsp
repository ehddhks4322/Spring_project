<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/message_insert.css">
<script>
function send_check(f) {

	var subject = f.subject.value;
	var receiver_id = f.receiver_id.value;
	var content = f.content.value;

	if (subject == '') {
		alert("제목을 입력해주세요.")
		return;
	}

	if (receiver_id == '') {
		alert("상대방 아이디를 입력해주세요")
		return;
	}

	if (content == '') {
		alert("내용을 작성해주세요.")
		return;
	}

	f.method = "post";
	f.action = "send_msg.do";
	f.submit();
}
</script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	<div class="container">
		<form name="f">
			<table style="width: 1000px; height: 650px;">
				<h2 class="new_h1">새글 작성</h2>

				<div class="xbtn" onclick="location.href='message.do'"
					style="cursor: pointer;"></div>

				<div class="gray_box">
					<p>New Mail</p>
				</div>
				<tr style="height: 100px;">
					<th>제목<span>*</span></th>
					<td><input name="subject" class="subject"></td>
				</tr>
				<tr style="height: 100px;">
					<th>받는사람<span>*</span></th>
					<td><input name="receiver_id" class="receiver_id"></td>
				</tr>
				<tr style="height: 350px;">
					<th>내용<span>*</span></th>
					<td><textarea name="content" rows="10" cols="50"
							style="resize: none;"></textarea></td>
				</tr>
			</table>
			<div class="btn_wrapper">
				<input type="button" value="보내기" class="btn"
					onclick="send_check(this.form);"
					style="cursor: pointer; border: none; background-color: #2775DF;">
			</div>
		</form>
	</div>
</body>
</html>