<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="stylesheet" href="resources/css/message_list.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	var drop_val = 0;

	$(document).ready(function() {
		$(".default_option").click(function() {
			$(".dropdown ul").addClass("active");
		});

		$(".dropdown ul li").click(function() {
			var text = $(this).text();
			if ($('.dropdown ul').children().hasClass('selected')) {
				$('.dropdown ul').children().removeClass('selected');
				$(this).addClass('selected');
			} else {
				$(this).addClass('selected');
			}
			$(".default_option").text(text);
			$(".dropdown ul").removeClass("active");
		});
		$(".dropdown-menu").on("click", "li", function() {

			drop_val = $(this).attr('value');

		});
	});
</script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	<div class="container">
		<div class="c_list">
			<table width="1100">
				<tr>
					<th align="left">받은쪽지</th>
					<th align="left">제목</th>
					<th align="left">내용</th>
					<th align="left">보낸사람</th>
				</tr>
				<c:forEach var="rec" items="${rec}">
					<tr>
						<td>${rec.ic_idx}</td>
						<td>${rec.subject}</td>
						<td>${rec.content}</td>
						<td>${rec.sender_name}</td>
					</tr>
				</c:forEach>
				<td><input class="message_input" type="button" value="쪽지 쓰기"
					onclick="location.href='message_insert_form.do'"></td>
			</table>
		</div>

		<div class="d_list">
			<table width="1100">
				<tr>
					<th align="left">보낸쪽지</th>
					<th align="left">제목</th>
					<th align="left">내용</th>
					<th align="left">받은사람</th>
				</tr>
				<c:forEach var="send" items="${send}">
					<tr>
						<td>${send.ic_idx}</td>
						<td>${send.subject}</td>
						<td>${send.content}</td>
						<td>${send.receiver_name}</td>
					</tr>
				</c:forEach>
			</table>
		</div>


	</div>
</body>
</html>