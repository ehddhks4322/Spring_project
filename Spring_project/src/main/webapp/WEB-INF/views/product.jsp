<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript">
		function categoryChange(e) {
			  var selectedCategory = e.value;
			  var typeSelect = document.getElementById("type");
			  var type_2_Select = document.getElementById("type_2");
			  
			  // 기존의 option 값들 제거
			  while (typeSelect.firstChild) {
			    typeSelect.removeChild(typeSelect.firstChild);
			  }

			  // type_2 select 요소의 option 값들 제거
			  while (type_2_Select.firstChild) {
			    type_2_Select.removeChild(type_2_Select.firstChild);
			  }
			  
			  if (selectedCategory == "a") {
			    // pc
			    var option1 = document.createElement("option");
			    option1.value = "pc_option1_value";
			    option1.text = "데스크탑";
			    typeSelect.appendChild(option1);

			    var option2 = document.createElement("option");
			    option2.value = "pc_option2_value";
			    option2.text = "노트북";
			    typeSelect.appendChild(option2);
			    
			  } 
			  
			  	else if (selectedCategory == "b") {
			    // 모바일
		  		var option1 = document.createElement("option");
			    option1.value = "mb_option1_value";
			    option1.text = "태블릿";
			    typeSelect.appendChild(option1);

			    var option2 = document.createElement("option");
			    option2.value = "mb_option2_value";
			    option2.text = "스마트폰";
			    typeSelect.appendChild(option2);
			  }
			  	
			  	else if (selectedCategory == "c") {
			    // 헤드셋
		  		var option1 = document.createElement("option");
			    option1.value = "hdp_option1_value";
			    option1.text = "삼성전자";
			    typeSelect.appendChild(option1);

			    var option2 = document.createElement("option");
			    option2.value = "hdp_option2_value";
			    option2.text = "Apple";
			    typeSelect.appendChild(option2);
			    
			    var option3 = document.createElement("option");
			    option3.value = "hdp_option3_value";
			    option3.text = "젠하이저";
			    typeSelect.appendChild(option3);
			    
			    var option4 = document.createElement("option");
			    option4.value = "hdp_option4_value";
			    option4.text = "JBL";
			    typeSelect.appendChild(option4);
			    
			    var option5 = document.createElement("option");
			    option5.value = "hdp_option5_value";
			    option5.text = "QCY";
			    typeSelect.appendChild(option5);
			    
			    var option6 = document.createElement("option");
			    option6.value = "hdp_option6_value";
			    option6.text = "기타브랜드";
			    typeSelect.appendChild(option6);
			  }
			  	
			  	else if (selectedCategory == "d") {
			    // 이어폰
			    
			  }
			}

			function typeChange(e) {
			  var selectedType = e.value;
			  var type_2_Select = document.getElementById("type_2");
			  
			  // 기존의 option 값들 제거
			  while (type_2_Select.firstChild) {
			    type_2_Select.removeChild(type_2_Select.firstChild);
			  }
			  
			  if (selectedType == "pc_option1_value" || selectedType == "pc_option2_value") {
			    // pc
			    
			    var option1 = document.createElement("option");
			    option1.value = "pc_type1_value";
			    option1.text = "삼성전자";
			    type_2_Select.appendChild(option1);
			    
			    var option2 = document.createElement("option");
			    option2.value = "pc_type2_value";
			    option2.text = "LG전자";
			    type_2_Select.appendChild(option2);
			    
			    var option3 = document.createElement("option");
			    option3.value = "pc_type3_value";
			    option3.text = "HP";
			    type_2_Select.appendChild(option3);
			    
			    var option4 = document.createElement("option");
			    option4.value = "pc_type4_value";
			    option4.text = "ASUS";
			    type_2_Select.appendChild(option4);
			    
			    var option5 = document.createElement("option");
			    option5.value = "pc_type5_value";
			    option5.text = "MSI";
			    type_2_Select.appendChild(option5);
			    
			    var option6 = document.createElement("option");
			    option6.value = "pc_type6_value";
			    option6.text = "한성컴퓨터";
			    type_2_Select.appendChild(option6);
			    
			    var option7 = document.createElement("option");
			    option7.value = "pc_type7_value";
			    option7.text = "기타브랜드";
			    type_2_Select.appendChild(option7);
			    } 	
			  
			  	else if (selectedType == "mb_option1_value" || selectedType == "mb_option2_value") {
			    // 모바일
				  	var option1 = document.createElement("option");
				    option1.value = "mb_type1_value";
				    option1.text = "갤럭시";
				    type_2_Select.appendChild(option1);
				    
				    var option2 = document.createElement("option");
				    option2.value = "mb_type2_value";
				    option2.text = "Apple";
				    type_2_Select.appendChild(option2);
				    
				    var option3 = document.createElement("option");
				    option3.value = "mb_type3_value";
				    option3.text = "기타브랜드";
				    type_2_Select.appendChild(option3);
			  	}		
			  
			  	else if (selectedType == "hdp_option1_value") {
			    // 헤드셋
			  		var option1 = document.createElement("option");
				    option1.value = "hdp_type1_value";
				    option1.text = "유선 커널형";
				    type_2_Select.appendChild(option1);
				    
				    var option2 = document.createElement("option");
				    option2.value = "hdp_type1_value";
				    option2.text = "유선 오픈형";
				    type_2_Select.appendChild(option2);
			  }
			}
		</script>
	</head>
	<body>
		<form>
			<h1>상품 등록</h1>
			<div>
				<input type="hidden" value="${id.m_idx}">
			</div>
			<div>
				상품명 <input>
			</div>
			<div>
				카테고리 <select onchange="categoryChange(this)">
						
						<option value="a">pc</option>
						<option value="b">모바일</option>
						<option value="c">헤드셋</option>
						<option value="d">이어폰</option>
					   </select>
					   <select id="type" onchange="typeChange(this)">
					   	<option></option>
					   
					   </select>
					   <select id="type_2">
					   	<option></option>
					   
					   </select>
			</div>
			<div>
				상품가격 <input>
			</div>
			<div>상품 설명</div>
			<div>
				<textarea rows="5" cols="40"></textarea>
			</div>
			<div>
				사진  <input type="file" name="photo"><br>
					  <input type="button" value="전송" onclick="send(this.form)">
			</div>
		</form>
	</body>
</html>