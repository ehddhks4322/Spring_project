<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/my_page.css">
<script type="text/javascript">
	function showProfile() {
		document.getElementById('profile').style.display = 'block';
		document.getElementById('wishlist').style.display = 'none';
		document.getElementById('postlist').style.display = 'none';
	}

	function showWishlist() {
		document.getElementById('profile').style.display = 'none';
		document.getElementById('wishlist').style.display = 'block';
		document.getElementById('postlist').style.display = 'none';
	}

	function showPostlist() {
		document.getElementById('profile').style.display = 'none';
		document.getElementById('wishlist').style.display = 'none';
		document.getElementById('postlist').style.display = 'block';
	}
</script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	<div>
		<ul class="menu">
			<li><a href="#" onclick="showProfile()">회원정보</a></li>
			<li><a href="#" onclick="showWishlist()">찜 목록</a></li>
			<li><a href="#" onclick="showPostlist()">글 목록</a></li>
		</ul>
	</div>

	<div class="profile" id="profile">
		<!-- 프로필 내용 -->
		<h1
			style="display: block; font-size: 2em; margin-block-start: 0.67em; padding-bottom: 20px;">Member
			Info</h1>

		<div style="margin-bottom: 10px;">
			<h5>
				이름 <span>*</span>
			</h5>
			<input id="m_name" value="${id.m_name}" disabled>
		</div>
		<div style="margin-bottom: 10px;">
			<h5>
				아이디 <span>*</span>
			</h5>
			<input id="m_name" value="${id.m_id}" disabled>
		</div>
		<div style="margin-bottom: 10px;">
			<h5>
				이메일 <span>*</span>
			</h5>
			<input id="m_name" value="${id.m_email}" disabled>
		</div>
		<div style="margin-bottom: 10px;">
			<h5>
				전화번호 <span>*</span>
			</h5>
			<input id="m_name" value="${id.m_tel}" disabled>
		</div>
		<div style="margin-bottom: 10px;">
			<h5>
				주소 <span>*</span>
			</h5>
			<input id="m_name" value="${id.m_loc}" disabled>
		</div>
	</div>

	<%-- 		<br>
		<p>이름 : ${id.m_name}</p>
		<p>아이디 : ${id.m_id}</p>
		<p>이메일 : ${id.m_email}</p>
		<p>전화번호 : ${id.m_tel}</p>
		<p>주소 : ${id.m_loc}</p> --%>

	<div id="wishlist" style="display: none;">
		<!-- 위시리스트 내용 -->

		<div class="grid">
			<div class="palettes">

				<c:forEach var="md" items="${md_list}">
					<figure class="palette">
						<div class="aspect-ratio">
							<div class="see"></div>
						</div>
						<figcaption class="palette_caption">
							<div style="width: 294px; height: 294px; position: relative;"
								class="jb-wrap">
								<c:if test="${md.p_state eq 0}">
									<img
										onclick="location.href='product_view.do?p_idx=${md.p_idx}'"
										src="${pageContext.request.contextPath}/resources/upload/${md.p_img1}"
										width="294px;" height="294px"
										style="cursor: pointer; box-shadow: rgba(99, 99, 99, 0.1) 0px 2px 8px 0px; object-fit: cover; border-radius: 12px;">
								</c:if>
								<c:if test="${md.p_state eq 1}">
									<img
										onclick="location.href='product_view.do?p_idx=${md.p_idx}'"
										src="${pageContext.request.contextPath}/resources/upload/${md.p_img1}"
										width="294px;" height="294px"
										style="cursor: pointer; box-shadow: rgba(99, 99, 99, 0.1) 0px 2px 8px 0px; object-fit: cover; border-radius: 12px;">
									<p class="jb-text">거래중</p>
								</c:if>
								<c:if test="${md.p_state eq 2}">
									<img
										onclick="location.href='product_view.do?p_idx=${md.p_idx}'"
										src="${pageContext.request.contextPath}/resources/upload/${md.p_img1}"
										width="294px;" height="294px"
										style="filter: brightness(80%); cursor: pointer; box-shadow: rgba(99, 99, 99, 0.1) 0px 2px 8px 0px; object-fit: cover; border-radius: 12px;">
									<p class="jb-text">SOLD OUT</p>
								</c:if>
							</div>
							<div
								style="display: flex; width: 290px; justify-content: space-between;">
								<h4 style="font-size: 16px; font-weight: 500;">${md.p_name}</h4>
								<!-- <input type="button" value="찜버튼" > -->
								<img src="resources/img/heart_red.png" width="20px"
									height="20px" id="heart" style="padding-top: 5px;"
									onclick="add_heart('${md.m_idx}', '${md.p_idx}')">
							</div>
							<p style="font-weight: bold; font-size: 15px;">${md.p_price}원</p>
							<p style="font-weight: 300; font-size: 13px;">${md.m_loc.substring(0, 10)}</p>
						</figcaption>
					</figure>
				</c:forEach>
			</div>
		</div>


	</div>

	<div id="postlist" style="display: none;">
		<div class="grid">
			<div class="palettes">

				<!-- 포스트 목록 내용 -->
				<c:forEach var="vo" items="${list}">
					<figure class="palette">
						<div class="aspect-ratio">
							<div class="see"></div>
						</div>
						<figcaption class="palette_caption">
							<div style="width: 294px; height: 294px; position: relative;"
								class="jb-wrap">
								<c:if test="${vo.p_state eq 0}">
									<img
										onclick="location.href='product_view.do?p_idx=${vo.p_idx}'"
										src="${pageContext.request.contextPath}/resources/upload/${vo.p_img1}"
										width="294px;" height="294px"
										style="cursor: pointer; box-shadow: rgba(99, 99, 99, 0.1) 0px 2px 8px 0px; object-fit: cover; border-radius: 12px;">
								</c:if>
								<c:if test="${vo.p_state eq 1}">
									<img
										onclick="location.href='product_view.do?p_idx=${vo.p_idx}'"
										src="${pageContext.request.contextPath}/resources/upload/${vo.p_img1}"
										width="294px;" height="294px"
										style="cursor: pointer; box-shadow: rgba(99, 99, 99, 0.1) 0px 2px 8px 0px; object-fit: cover; border-radius: 12px;">
									<p class="jb-text">거래중</p>
								</c:if>
								<c:if test="${vo.p_state eq 2}">
									<img
										onclick="location.href='product_view.do?p_idx=${vo.p_idx}'"
										src="${pageContext.request.contextPath}/resources/upload/${vo.p_img1}"
										width="294px;" height="294px"
										style="filter: brightness(80%); cursor: pointer; box-shadow: rgba(99, 99, 99, 0.1) 0px 2px 8px 0px; object-fit: cover; border-radius: 12px;">
									<p class="jb-text">SOLD OUT</p>
								</c:if>
							</div>
							<div
								style="display: flex; width: 290px; justify-content: space-between;">
								<h4 style="font-size: 16px; font-weight: 500;">${vo.p_name}</h4>
								<!-- <input type="button" value="찜버튼" > -->
								<img src="resources/img/heart_white.png" width="20px"
									height="20px" id="heart" style="padding-top: 5px;"
									onclick="add_heart('${vo.m_idx}', '${vo.p_idx}')">
							</div>
							<p style="font-weight: bold; font-size: 15px;">${vo.p_price}원</p>
							<p style="font-weight: 300; font-size: 13px;">${vo.m_loc.substring(0, 10)}</p>
						</figcaption>
					</figure>
				</c:forEach>
			</div>
		</div>
	</div>




</body>
</html>