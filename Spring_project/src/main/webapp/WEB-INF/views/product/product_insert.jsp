<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" href="resources/css/product_insert.css">
<script type="text/javascript">
	function categoryChange(v) {
		var selectedCategory = v.value;
		var typeSelect = document.getElementById("type");
		var type_2_Select = document.getElementById("type_2");
		var p_code_Select = document.getElementById("p_code");

		console.log(typeof (selectedCategory));
		// 기존의 option 값들 제거
		while (typeSelect.firstChild) {
			typeSelect.removeChild(typeSelect.firstChild);
		}

		// type_2 select 요소의 option 값들 제거
		while (type_2_Select.firstChild) {
			type_2_Select.removeChild(type_2_Select.firstChild);
		}

		// p_code select 요소의 option 값들 제거
		while (p_code_Select.firstChild) {
			p_code_Select.removeChild(p_code_Select.firstChild);
		}

		switch (selectedCategory) {
		case "1":
			var option1 = document.createElement("option");
			option1.value = "11";
			option1.text = "데스크탑";
			typeSelect.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "12";
			option2.text = "노트북";
			typeSelect.appendChild(option2);

			break;

		case "2":
			var option1 = document.createElement("option");
			option1.value = "21";
			option1.text = "태블릿";
			typeSelect.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "22";
			option2.text = "스마트폰";
			typeSelect.appendChild(option2);

			break;

		case "3":
			var option1 = document.createElement("option");
			option1.value = "31";
			option1.text = "삼성전자";
			typeSelect.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "32";
			option2.text = "Apple";
			typeSelect.appendChild(option2);

			var option3 = document.createElement("option");
			option3.value = "33";
			option3.text = "젠하이저";
			typeSelect.appendChild(option3);

			var option4 = document.createElement("option");
			option4.value = "34";
			option4.text = "JBL";
			typeSelect.appendChild(option4);

			var option5 = document.createElement("option");
			option5.value = "35";
			option5.text = "QCY";
			typeSelect.appendChild(option5);

			var option6 = document.createElement("option");
			option6.value = "36";
			option6.text = "기타브랜드";
			typeSelect.appendChild(option6);

			break;

		case "4":
			var option1 = document.createElement("option");
			option1.value = "41";
			option1.text = "삼성전자";
			typeSelect.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "42";
			option2.text = "Apple";
			typeSelect.appendChild(option2);

			var option3 = document.createElement("option");
			option3.value = "43";
			option3.text = "젠하이저";
			typeSelect.appendChild(option3);

			var option4 = document.createElement("option");
			option4.value = "44";
			option4.text = "JBL";
			typeSelect.appendChild(option4);

			var option5 = document.createElement("option");
			option5.value = "45";
			option5.text = "QCY";
			typeSelect.appendChild(option5);

			var option6 = document.createElement("option");
			option6.value = "46";
			option6.text = "기타브랜드";
			typeSelect.appendChild(option6);

			break;

		default:

			break;

		}

	}

	function typeChange(v) {
		var selectedType = v.value;
		var type_2_Select = document.getElementById("type_2");
		var p_code_Select = document.getElementById("p_code");

		// 기존의 option 값들 제거
		while (type_2_Select.firstChild) {
			type_2_Select.removeChild(type_2_Select.firstChild);
		}

		// p_code select 요소의 option 값들 제거
		while (p_code_Select.firstChild) {
			p_code_Select.removeChild(p_code_Select.firstChild);
		}

		switch (selectedType) {
		case "11":
			var option1 = document.createElement("option");
			option1.value = "101";
			option1.text = "삼성전자";
			type_2_Select.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "102";
			option2.text = "LG전자";
			type_2_Select.appendChild(option2);

			var option3 = document.createElement("option");
			option3.value = "103";
			option3.text = "HP";
			type_2_Select.appendChild(option3);

			var option4 = document.createElement("option");
			option4.value = "104";
			option4.text = "ASUS";
			type_2_Select.appendChild(option4);

			var option5 = document.createElement("option");
			option5.value = "105";
			option5.text = "MSI";
			type_2_Select.appendChild(option5);

			var option6 = document.createElement("option");
			option6.value = "106";
			option6.text = "한성컴퓨터";
			type_2_Select.appendChild(option6);

			var option7 = document.createElement("option");
			option7.value = "107";
			option7.text = "기타브랜드";
			type_2_Select.appendChild(option7);

			break;

		case "12":
			var option1 = document.createElement("option");
			option1.value = "201";
			option1.text = "삼성전자";
			type_2_Select.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "202";
			option2.text = "LG전자";
			type_2_Select.appendChild(option2);

			var option3 = document.createElement("option");
			option3.value = "203";
			option3.text = "HP";
			type_2_Select.appendChild(option3);

			var option4 = document.createElement("option");
			option4.value = "204";
			option4.text = "ASUS";
			type_2_Select.appendChild(option4);

			var option5 = document.createElement("option");
			option5.value = "205";
			option5.text = "MSI";
			type_2_Select.appendChild(option5);

			var option6 = document.createElement("option");
			option6.value = "206";
			option6.text = "한성컴퓨터";
			type_2_Select.appendChild(option6);

			var option7 = document.createElement("option");
			option7.value = "207";
			option7.text = "기타브랜드";
			type_2_Select.appendChild(option7);

			break;

		case "21":
			var option1 = document.createElement("option");
			option1.value = "50";
			option1.text = "갤럭시";
			type_2_Select.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "51";
			option2.text = "Apple";
			type_2_Select.appendChild(option2);

			var option3 = document.createElement("option");
			option3.value = "52";
			option3.text = "기타브랜드";
			type_2_Select.appendChild(option3);

			break;

		case "22":
			var option1 = document.createElement("option");
			option1.value = "60";
			option1.text = "갤럭시";
			type_2_Select.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "61";
			option2.text = "Apple";
			type_2_Select.appendChild(option2);

			var option3 = document.createElement("option");
			option3.value = "62";
			option3.text = "기타브랜드";
			type_2_Select.appendChild(option3);

			break;

		case "31":
			var option1 = document.createElement("option");
			option1.value = "70";
			option1.text = "유선";
			type_2_Select.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "71";
			option2.text = "무선";
			type_2_Select.appendChild(option2);

			break;

		case "32":
			var option1 = document.createElement("option");
			option1.value = "72";
			option1.text = "유선";
			type_2_Select.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "73";
			option2.text = "무선";
			type_2_Select.appendChild(option2);

			break;

		case "33":
			var option1 = document.createElement("option");
			option1.value = "74";
			option1.text = "유선";
			type_2_Select.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "75";
			option2.text = "무선";
			type_2_Select.appendChild(option2);

			break;

		case "34":
			var option1 = document.createElement("option");
			option1.value = "76";
			option1.text = "유선";
			type_2_Select.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "77";
			option2.text = "무선";
			type_2_Select.appendChild(option2);

			break;

		case "35":
			var option1 = document.createElement("option");
			option1.value = "78";
			option1.text = "유선";
			type_2_Select.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "79";
			option2.text = "무선";
			type_2_Select.appendChild(option2);

			break;

		case "36":
			var option1 = document.createElement("option");
			option1.value = "80";
			option1.text = "유선 커널형";
			type_2_Select.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "81";
			option2.text = "무선";
			type_2_Select.appendChild(option2);

			break;

		case "41":
			var option1 = document.createElement("option");
			option1.value = "82";
			option1.text = "유선";
			type_2_Select.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "83";
			option2.text = "무선";
			type_2_Select.appendChild(option2);

			break;

		case "42":
			var option1 = document.createElement("option");
			option1.value = "84";
			option1.text = "유선";
			type_2_Select.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "85";
			option2.text = "무선";
			type_2_Select.appendChild(option2);

			break;

		case "43":
			var option1 = document.createElement("option");
			option1.value = "86";
			option1.text = "유선";
			type_2_Select.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "87";
			option2.text = "무선";
			type_2_Select.appendChild(option2);

			break;

		case "44":
			var option1 = document.createElement("option");
			option1.value = "88";
			option1.text = "유선";
			type_2_Select.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "89";
			option2.text = "무선";
			type_2_Select.appendChild(option2);

			break;

		case "45":
			var option1 = document.createElement("option");
			option1.value = "90";
			option1.text = "유선";
			type_2_Select.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "91";
			option2.text = "무선";
			type_2_Select.appendChild(option2);

			break;

		case "46":
			var option1 = document.createElement("option");
			option1.value = "92";
			option1.text = "유선";
			type_2_Select.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "93";
			option2.text = "무선";
			type_2_Select.appendChild(option2);

			break;
		default:

			break;
		}

	}

	function type_2_change(v) {
		var selectedType2 = v.value;
		var p_code_Select = document.getElementById("p_code");

		// 기존의 option 값들 제거
		while (p_code_Select.firstChild) {
			p_code_Select.removeChild(p_code_Select.firstChild);
		}

		switch (selectedType2) {
		case "50":
			var option1 = document.createElement("option");
			option1.value = "301";
			option1.text = "10인치";
			p_code_Select.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "302";
			option2.text = "11인치";
			p_code_Select.appendChild(option2);

			var option3 = document.createElement("option");
			option3.value = "303";
			option3.text = "12인치";
			p_code_Select.appendChild(option3);

			var option4 = document.createElement("option");
			option4.value = "304";
			option4.text = "11인치";
			p_code_Select.appendChild(option4);

			break;

		case "51":
			var option1 = document.createElement("option");
			option1.value = "305";
			option1.text = "10인치";
			p_code_Select.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "306";
			option2.text = "11인치";
			p_code_Select.appendChild(option2);

			var option3 = document.createElement("option");
			option3.value = "307";
			option3.text = "12인치";
			p_code_Select.appendChild(option3);

			var option4 = document.createElement("option");
			option4.value = "308";
			option4.text = "11인치";
			p_code_Select.appendChild(option4);

			break;

		case "52":
			var option1 = document.createElement("option");
			option1.value = "309";
			option1.text = "10인치";
			p_code_Select.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "310";
			option2.text = "11인치";
			p_code_Select.appendChild(option2);

			var option3 = document.createElement("option");
			option3.value = "311";
			option3.text = "12인치";
			p_code_Select.appendChild(option3);

			var option4 = document.createElement("option");
			option4.value = "312";
			option4.text = "11인치";
			p_code_Select.appendChild(option4);

			break;

		case "60":
			var option1 = document.createElement("option");
			option1.value = "401";
			option1.text = "32GB";
			p_code_Select.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "402";
			option2.text = "64GB";
			p_code_Select.appendChild(option2);

			var option3 = document.createElement("option");
			option3.value = "403";
			option3.text = "128GB";
			p_code_Select.appendChild(option3);

			var option4 = document.createElement("option");
			option4.value = "404";
			option4.text = "256GB";
			p_code_Select.appendChild(option4);

			var option5 = document.createElement("option");
			option5.value = "405";
			option5.text = "512GB";
			p_code_Select.appendChild(option5);

			break;

		case "61":
			var option1 = document.createElement("option");
			option1.value = "406";
			option1.text = "32GB";
			p_code_Select.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "407";
			option2.text = "64GB";
			p_code_Select.appendChild(option2);

			var option3 = document.createElement("option");
			option3.value = "408";
			option3.text = "128GB";
			p_code_Select.appendChild(option3);

			var option4 = document.createElement("option");
			option4.value = "409";
			option4.text = "256GB";
			p_code_Select.appendChild(option4);

			var option5 = document.createElement("option");
			option5.value = "410";
			option5.text = "512GB";
			p_code_Select.appendChild(option5);

			break;

		case "62":
			var option1 = document.createElement("option");
			option1.value = "411";
			option1.text = "32GB";
			p_code_Select.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "412";
			option2.text = "64GB";
			p_code_Select.appendChild(option2);

			var option3 = document.createElement("option");
			option3.value = "413";
			option3.text = "128GB";
			p_code_Select.appendChild(option3);

			var option4 = document.createElement("option");
			option4.value = "414";
			option4.text = "256GB";
			p_code_Select.appendChild(option4);

			var option5 = document.createElement("option");
			option5.value = "415";
			option5.text = "512GB";
			p_code_Select.appendChild(option5);

			break;

		case '70':
			var option1 = document.createElement("option");
			option1.value = "501";
			option1.text = "커널형";
			p_code_Select.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "502";
			option2.text = "오픈형";
			p_code_Select.appendChild(option2);

			break;

		case '71':
			var option1 = document.createElement("option");
			option1.value = "503";
			option1.text = "커널형";
			p_code_Select.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "504";
			option2.text = "오픈형";
			p_code_Select.appendChild(option2);

			break;

		case '72':
			var option1 = document.createElement("option");
			option1.value = "505";
			option1.text = "커널형";
			p_code_Select.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "506";
			option2.text = "오픈형";
			p_code_Select.appendChild(option2);

			break;

		case '73':
			var option1 = document.createElement("option");
			option1.value = "507";
			option1.text = "커널형";
			p_code_Select.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "508";
			option2.text = "오픈형";
			p_code_Select.appendChild(option2);

			break;

		case '74':
			var option1 = document.createElement("option");
			option1.value = "508";
			option1.text = "커널형";
			p_code_Select.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "509";
			option2.text = "오픈형";
			p_code_Select.appendChild(option2);

			break;

		case '75':
			var option1 = document.createElement("option");
			option1.value = "510";
			option1.text = "커널형";
			p_code_Select.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "511";
			option2.text = "오픈형";
			p_code_Select.appendChild(option2);

			break;

		case '76':
			var option1 = document.createElement("option");
			option1.value = "512";
			option1.text = "커널형";
			p_code_Select.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "513";
			option2.text = "오픈형";
			p_code_Select.appendChild(option2);

			break;

		case '77':
			var option1 = document.createElement("option");
			option1.value = "514";
			option1.text = "커널형";
			p_code_Select.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "515";
			option2.text = "오픈형";
			p_code_Select.appendChild(option2);

			break;

		case '78':
			var option1 = document.createElement("option");
			option1.value = "516";
			option1.text = "커널형";
			p_code_Select.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "517";
			option2.text = "오픈형";
			p_code_Select.appendChild(option2);

			break;

		case '79':
			var option1 = document.createElement("option");
			option1.value = "518";
			option1.text = "커널형";
			p_code_Select.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "519";
			option2.text = "오픈형";
			p_code_Select.appendChild(option2);

			break;

		case '80':
			var option1 = document.createElement("option");
			option1.value = "520";
			option1.text = "커널형";
			p_code_Select.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "521";
			option2.text = "오픈형";
			p_code_Select.appendChild(option2);

			break;

		case '81':
			var option1 = document.createElement("option");
			option1.value = "522";
			option1.text = "커널형";
			p_code_Select.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "523";
			option2.text = "오픈형";
			p_code_Select.appendChild(option2);

			break;

		case '82':
			var option1 = document.createElement("option");
			option1.value = "601";
			option1.text = "커널형";
			p_code_Select.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "602";
			option2.text = "오픈형";
			p_code_Select.appendChild(option2);

			break;

		case '83':
			var option1 = document.createElement("option");
			option1.value = "603";
			option1.text = "커널형";
			p_code_Select.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "604";
			option2.text = "오픈형";
			p_code_Select.appendChild(option2);

			break;

		case '84':
			var option1 = document.createElement("option");
			option1.value = "605";
			option1.text = "커널형";
			p_code_Select.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "606";
			option2.text = "오픈형";
			p_code_Select.appendChild(option2);

			break;

		case '85':
			var option1 = document.createElement("option");
			option1.value = "607";
			option1.text = "커널형";
			p_code_Select.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "608";
			option2.text = "오픈형";
			p_code_Select.appendChild(option2);

			break;

		case '86':
			var option1 = document.createElement("option");
			option1.value = "609";
			option1.text = "커널형";
			p_code_Select.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "610";
			option2.text = "오픈형";
			p_code_Select.appendChild(option2);

			break;

		case '87':
			var option1 = document.createElement("option");
			option1.value = "611";
			option1.text = "커널형";
			p_code_Select.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "612";
			option2.text = "오픈형";
			p_code_Select.appendChild(option2);

			break;

		case '88':
			var option1 = document.createElement("option");
			option1.value = "613";
			option1.text = "커널형";
			p_code_Select.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "614";
			option2.text = "오픈형";
			p_code_Select.appendChild(option2);

			break;

		case '89':
			var option1 = document.createElement("option");
			option1.value = "615";
			option1.text = "커널형";
			p_code_Select.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "616";
			option2.text = "오픈형";
			p_code_Select.appendChild(option2);

			break;

		case '90':
			var option1 = document.createElement("option");
			option1.value = "617";
			option1.text = "커널형";
			p_code_Select.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "618";
			option2.text = "오픈형";
			p_code_Select.appendChild(option2);

			break;

		case '91':
			var option1 = document.createElement("option");
			option1.value = "619";
			option1.text = "커널형";
			p_code_Select.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "620";
			option2.text = "오픈형";
			p_code_Select.appendChild(option2);

			break;

		case '92':
			var option1 = document.createElement("option");
			option1.value = "621";
			option1.text = "커널형";
			p_code_Select.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "622";
			option2.text = "오픈형";
			p_code_Select.appendChild(option2);

			break;

		case '93':
			var option1 = document.createElement("option");
			option1.value = "623";
			option1.text = "커널형";
			p_code_Select.appendChild(option1);

			var option2 = document.createElement("option");
			option2.value = "624";
			option2.text = "오픈형";
			p_code_Select.appendChild(option2);

			break;

		default:

			break;
		}

	}

	function send(f) {
		var m_idx = f.m_idx.value;
		var p_name = f.p_name.value;
		var p_code = f.p_code.value;
		var p_price = f.p_price.value;
		var p_img1 = f.p_img1.value;
		var p_img2 = f.p_img2.value;
		var p_img3 = f.p_img3.value;

		if (p_name == '') {
			swal("상품명을 입력하세요!", "", "warning");
			return;
		}
		if (p_price == '') {
			swal("가격을 입력하세요!", "", "warning");
			return;
		}
		if (p_code == '') {
			p_code = f.type_2.value;
			f.p_code.value = p_code;
		}

		console.log(p_code);
		f.action = "product_insert.do";
		f.method = "post";
		f.submit();
	}
</script>
</head>
<body
	style="background-image: url('resources/img/blue_img.png'); background-size: cover;">
	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

	<div class="container">
		<form enctype="multipart/form-data">
			<input type="hidden" id="m_idx" name="m_idx" value="${id.m_idx}">

			<h1
				style="display: block; font-size: 2em; margin-block-start: 0.67em; padding-bottom: 20px; color: black;">상품
				등록</h1>
			<div class="xbtn" onclick="location.href='main.do'"
				style="cursor: pointer;"></div>

			<table>

				<tr>
					<th style="color: black;">상품명</th>
					<td><input id="p_name" name="p_name"></td>
				</tr>
				<tr>
					<th style="color: black;">카테고리</th>

					<td><select onchange="categoryChange(this)">

							<option value="1">pc</option>
							<option value="2">모바일</option>
							<option value="3">헤드셋</option>
							<option value="4">이어폰</option>
					</select> <select id="type" onchange="typeChange(this)">
							<option></option>

					</select> <select id="type_2" onchange="type_2_change(this)">
							<option></option>

					</select> <select id="p_code" name="p_code">
							<option></option>
					</select></td>
				</tr>

				<tr>
					<th style="color: black;">상품가격</th>
					<td><input placeholder="ex)10000" id="p_price" name="p_price"
						maxlength="10">
					<td>
				</tr>

				<tr>
					<th style="color: black;">상품 설명</th>

					<td id="text"><textarea rows="10" cols="40" id="p_text"
							name="p_text" placeholder="2000자 이내로 작성 부탁드립니다."></textarea></td>
				</tr>

				<tr>
					<th style="color: black;">img1</th>
					<td style="color: black;"><input type="file" id="p_img1"
						name="p_img1"></td>
				</tr>

				<tr>
					<th style="color: black;">img2</th>
					<td style="color: black;"><input type="file" id="p_img2"
						name="p_img2"></td>
				</tr>

				<tr>
					<th style="color: black;">img3</th>
					<td style="color: black;"><input type="file" id="p_img3"
						name="p_img3"></td>
				<tr>
			</table>
			<div
				style="padding-top: 30px; text-align: right; padding-right: 50px;">
				<input type="button" value="상품등록" onclick="send(this.form)"
					class="send_btn">
			</div>

		</form>
	</div>
</body>
</html>