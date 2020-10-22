<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<style>
	.pop_table {
	    width: 100%;
	    border-collapse: separate;
	    border-spacing: 0;
	    border: none;
	    border-bottom:5px solid #000;
	    color:#000;
	}
	.pop_table th {
	    padding: 15px;
	    border: none;
	    border-bottom: 2px solid #FFF;
	    background: #D1B2FF;
	    font-weight: bold;
	    text-align: center;
	    vertical-align: middle;
	}
	.pop_table td {
	    padding: 15px;
	    border: none;
	    border-bottom: 2px solid #000;
	    text-align: left;
	    vertical-align: baseline;
	}
	.pop_table tr:last-child th,
	.pop_table tr:last-child td {
	    border-bottom: none;
	}
	form{
		width : 70%;
		margin : auto;
		align : center;
	}	
	#goo_name{
		width : 250px;
	}
	#goo_price, #sto_qty{
		width : 150px;
		display:inline-block;
	}
	#goo_category, #goo_model, #goo_color{
		width : 250px;
	}
	#sto_import{
		width : 150px;
	}
	#submit, #back{
			width : 200px;
			display:inline-block;
	}
	#file_add {
		display: none;
	}
</style>

	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-light-blue.css">



<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	type="text/javascript"></script>
<script>
	$(document)
			.ready(
					function() {
						$("#goo_category")
								.change(
										function() {
											var category = $("#goo_category")
													.val();
											var html = "<option value='' selected disabled hidden>-[필수]옵션을 선택해주세요.-</option>";
											var html2 = "<option value='' selected disabled hidden>-[필수]옵션을 선택해주세요.-</option>";
											
											// 모델 셀렉트 박스 값 변경

											if ("애플" == category) {
												html += "<option value='아이폰SE2'>아이폰SE2</option>";
											}

											if ("애플" == category) {
												html += "<option value='아이폰11'>아이폰11</option>";
											}

											if ("애플" == category) {
												html += "<option value='아이폰XS'>아이폰XS</option>";
											}

											if ("애플" == category) {
												html += "<option value='아이폰X'>아이폰X</option>";
											}

											if ("애플" == category) {
												html += "<option value='아이폰XR'>아이폰XR</option>";
											}

											if ("삼성" == category) {
												html += "<option value='갤럭시S20'>갤럭시S20</option>";
											}

											if ("삼성" == category) {
												html += "<option value='갤럭시S10'>갤럭시S10</option>";
											}

											if ("삼성" == category) {
												html += "<option value='갤럭시노트20'>갤럭시노트20</option>";
											}

											if ("삼성" == category) {
												html += "<option value='갤럭시노트10'>갤럭시노트10</option>";
											}

											if ("LG" == category) {
												html += "<option value='벨벳'>벨벳</option>";
											}

											if ("LG" == category) {
												html += "<option value='G8'>G8</option>";
											}

											if ("LG" == category) {
												html += "<option value='V50'>V50</option>";
											}

											if ("폴더폰" == category) {
												html += "<option value='삼성폴더폰'>삼성폴더폰</option>";
											}

											if ("폴더폰" == category) {
												html += "<option value='엘지폴더폰'>엘지폴더폰</option>";
											}

											if ("기타" == category) {
												html += "<option value='베가LTE-A'>베가LTE-A</option>";
											}

											if ("기타" == category) {
												html += "<option value='비와이폰'>비와이폰</option>";
											}

											if ("기타" == category) {
												html += "<option value='P30'>P30</option>";
											}

											if ("필름" == category) {
												html += "<option value='액정필름'>액정필름</option>";
											}
											if ("필름" == category) {
												html2 += "<option value='transparent'>transparent</option>"
											}
											
											$('#goo_model').empty();
											$('#goo_model').append(html);
										});
					});
	
	function checkRegist(c){
		var form = document.registform;
		//상품명
		var name = c.goo_name.value;
		
		if(name.trim() == ""){
			alert("상품명을 입력하세요");
			c.goo_name.focus();
			return false;
		}
		
		var id = c.goo_id.value;
		if(id.trim() == ""){
			alert("상품번호를 입력하세요");
			c.goo_id.focus();
			return false;
		}
		if(isNaN(form.goo_id.value)){
			alert("숫자만 입력하세요");
			c.goo_id.focus();
			return false;
		}
		
		var price = c.goo_price.value;
		if(price.trim() == ""){
			alert("가격을 입력하세요");
			c.goo_price.focus();
			return false;
		}
		if(isNaN(form.goo_price.value)){
			alert("숫자만 입력하세요");
			c.goo_price.focus();
			return false;
		}
		
		var category = c.goo_category.value;
		if(category.trim()==""){
			alert("분류를 선택하세요");
			return false;
		}
		
		var model = c.goo_model.value;
		if(model.trim()==""){
			alert("기종을 선택하세요");
			return false;
		}
		
		var color = c.goo_color.value;
		if(color.trim()==""){
			alert("색상을 선택하세요");
			return false;
		}
		
		var sto_import = c.sto_import.value;
		if(sto_import.trim() == ""){
			alert("입고업체를 입력하세요");
			c.sto_import.focus();
			return false;
		}
		
		var qty = c.sto_qty.value;
		if(qty.trim() == ""){
			alert("입고수량을 입력하세요");
			c.sto_qty.focus();
			return false;
		}
		
		var content = c.goo_content.value;
		if(content.trim() == ""){
			alert("상품설명을  입력하세요");
			c.goo_content.focus();
			return false;
		}
		
		var image = c.goo_image.value;
		if(image.trim() == ""){
			alert("이미지 첨부파일을 선택하세요");
			return false;
		}
	}
</script>
</head>
<body>
	
	<h2 align="center">Product Registration</h2>
	<p style="float: right; font-size: 12px; margin-right: 100px;"><a href="goodsMainAction.go">홈</a> > 상품등록</p>
	<hr><br>
			
	<form action="goodsRegistAction.ad" name="registform" method="post" enctype="multipart/form-data" name="regist" onsubmit="return checkRegist(this)">	
		<table class="pop_table">
			<tbody>
				<tr>
					<th>상품명</th>
					<td colspan="3"> 
						<input class="w3-input w3-border w3-margin-bottom" type="text" name="goo_name" id="goo_name"> 
						<input type="hidden" name="goo_id" id="goo_id" value="1">
					</td>
				
				</tr>
			
				<tr>
					<th>가격</th>
		            <td><input class="w3-input w3-border w3-margin-bottom" type="text" name="goo_price" id="goo_price">원</td>
					<th>브랜드</th>
					<td>
						<select class="w3-input w3-border w3-margin-bottom" name="goo_category" id="goo_category">
							<option value="" selected disabled hidden>-[필수]옵션을 선택해주세요.-</option>
							<option value="애플">애플</option>
							<option value="삼성">삼성</option>
							<option value="LG">LG</option>
							<option value="기타">기타</option>
							<option value="폴더폰">폴더폰</option>
						</select>
					</td>
		        </tr>
	        
		        <tr>
					<th>기종</th>
					<td>
						<select class="w3-input w3-border w3-margin-bottom" name="goo_model" id="goo_model">
							<option value="" selected disabled hidden>-[필수]옵션을 선택해주세요.-</option>
						</select>
					</td>
					<th>색상</th>
					<td>
						<select class="w3-input w3-border w3-margin-bottom" name="goo_color" id="goo_color">
							<option value="" selected disabled hidden>-[필수]옵션을 선택해주세요.-</option>
							<option value="white">white</option>
							<option value="black">black</option>
							<option value="red">red</option>
							<option value="blue">blue</option>
							<option value="pink">pink</option>
							<option value="yellow">yellow</option>
							<option value="purple">purple</option>
							<option value="green">green</option>
							<option value="green">brown</option>	
							<option value="green">gray</option>						
						</select>
					</td>
				</tr>
			
		        <tr>
					<th>입고업체</th>
					<td><input class="w3-input w3-border w3-margin-bottom" type="text" name="sto_import" id="sto_import"></td>
					<th>입고수량</th>
					<td><input class="w3-input w3-border w3-margin-bottom" type="text" name="sto_qty" id="sto_qty">개</td>
				</tr>
			
				<tr>
					<th>상품 설명</th>
					<td colspan="3">
						<textarea class="w3-input w3-border w3-margin-bottom" name="goo_content" id="goo_content" cols="50" rows="10"></textarea>
					</td>	  
				</tr>
				
				<tr>
					<th>파일첨부</th>
					<td colspan="3"><input class="w3-input w3-border w3-margin-bottom" type="file" name="goo_image" id="goo_image"></td>
				</tr>
			
				<tr>
					<td colspan="4" style="text-align:center;">
						<button class="w3-button w3-block w3-blue w3-section w3-padding" type="submit" id="submit">상품등록</button>
						<button class="w3-button w3-block w3-red w3-section w3-padding" type="button" id="back" onclick="history.back()">뒤로가기</button>
					</td>
				</tr>
	    	</tbody>
		</table>
	
	</form>
	<br><br>


</body>
</html>