<%@page import="vo.PageInfo"%>
<%@page import="vo.GoodsBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js" type="text/javascript"> </script>
<script>
	function file_modify() {
		$('#file_add').show();
		$('#file_info').hide();
	};
	
	$(document)
			.ready(
					function() {
						$("#mod_category")
								.change(
										function() {
											var category = $("#mod_category")
													.val();
											var html = "<option value='none' selected disabled hidden>-[필수]옵션을 선택해주세요.-</option>";

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
												html += "<option value='P30'>액정필름</option>";
											}
											
											$('#mod_model').empty();
											$('#mod_model').append(html);
										});
					});
</script>
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
	#mod_name{
		width : 250px;
	}
	#mod_price{
		width : 150px;
		display:inline-block;
	}
	#mod_category, #mod_model, #mod_color{
		width : 250px;
	}
	#submit, #back{
		width : 200px;
		display:inline-block;
		}
	#image_modify{
		width : 100px;
	}
	#file_add {
		display : none; 
	}
</style>
	
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-light-blue.css">

</head>
<body>

	<h2 align="center">Product Modify</h2>
	<p style="float: right; font-size: 12px; margin-right: 100px;"><a href="goodsMainAction.go">홈</a> > <a href="adminGoodsListAction.ad">상품관리</a> > 수정</p>
	<hr><br>
	
	<form method="post" enctype="multipart/form-data">	
	
	<c:set var="adminGoods" value="${modify }"/>
	<input type="hidden" name="mod_id" value="${adminGoods.goo_id}"/>
	
	<table class="pop_table">
		<tbody>
			<tr>
				<th>상품명</th>
				<td colspan="3"> 
					<input class="w3-input w3-border w3-margin-bottom" type="text" name="mod_name" id="mod_name" value="${adminGoods.goo_name}"> 
				</td>
			</tr>
			
			<tr>
				<th>가격</th>
	            <td><input class="w3-input w3-border w3-margin-bottom" type="text" name="mod_price" id="mod_price"  value="${adminGoods.goo_price }">원</td>
				<th>브랜드</th>
				<td>
					<c:if test="${adminGoods.goo_category == '애플'}">
					<select name="mod_category" id="mod_category">
						<option value="애플" selected>애플</option>
						<option value="삼성">삼성</option>
						<option value="LG">LG</option>
						<option value="기타">기타</option>
						<option value="폴더폰">폴더폰</option>
					</select>
					</c:if>
					<c:if test="${adminGoods.goo_category == '삼성'}">
					<select name="mod_category" id="mod_category">
						<option value="애플">애플</option>
						<option value="삼성" selected>삼성</option>
						<option value="LG">LG</option>
						<option value="기타">기타</option>
						<option value="폴더폰">폴더폰</option>
					</select>
					</c:if>
					<c:if test="${adminGoods.goo_category == 'LG'}">
					<select name="mod_category" id="mod_category">
						<option value="애플">애플</option>
						<option value="삼성">삼성</option>
						<option value="LG" selected>LG</option>
						<option value="기타">기타</option>
						<option value="폴더폰">폴더폰</option>
					</select>
					</c:if>
					<c:if test="${adminGoods.goo_category == '기타'}">
					<select name="mod_category" id="mod_category">
						<option value="애플">애플</option>
						<option value="삼성">삼성</option>
						<option value="LG">LG</option>
						<option value="기타" selected>기타</option>
						<option value="폴더폰">폴더폰</option>
					</select>
					</c:if>
					<c:if test="${adminGoods.goo_category == '폴더폰'}">
					<select name="mod_category" id="mod_category">
						<option value="애플">애플</option>
						<option value="삼성">삼성</option>
						<option value="LG">LG</option>
						<option value="기타">기타</option>
						<option value="폴더폰" selected>폴더폰</option>
					</select>
					</c:if>
				</td>
	        </tr>
	        
	        <tr>
				<th>기종</th>
				<td>
					<c:if test="${adminGoods.goo_category == '애플'}">
						<c:if test="${adminGoods.goo_model == '아이폰SE2' }">
						<select name="mod_model" id="mod_model">
							<option value="아이폰SE2" selected>아이폰SE2</option>
							<option value="아이폰11">아이폰11</option>
							<option value="아이폰XS">아이폰X</option>	
							<option value="아이폰X">아이폰X</option>
							<option value="아이폰XR">아이폰XR</option>
						</select>
						</c:if>
						<c:if test="${adminGoods.goo_model == '아이폰11' }">
						<select name="mod_model" id="mod_model">
							<option value="아이폰SE2">아이폰SE2</option>
							<option value="아이폰11" selected>아이폰11</option>
							<option value="아이폰XS">아이폰X</option>	
							<option value="아이폰X">아이폰X</option>
							<option value="아이폰XR">아이폰XR</option>
						</select>
						</c:if>
						<c:if test="${adminGoods.goo_model == '아이폰XS' }">
						<select name="mod_model" id="mod_model">
							<option value="아이폰SE2">아이폰SE2</option>
							<option value="아이폰11">아이폰11</option>
							<option value="아이폰XS" selected>아이폰X</option>	
							<option value="아이폰X">아이폰X</option>
							<option value="아이폰XR">아이폰XR</option>
						</select>
						</c:if>
						<c:if test="${adminGoods.goo_model == '아이폰X' }">
						<select name="mod_model" id="mod_model">
							<option value="아이폰SE2">아이폰SE2</option>
							<option value="아이폰11">아이폰11</option>
							<option value="아이폰XS">아이폰X</option>	
							<option value="아이폰X" selected>아이폰X</option>
							<option value="아이폰XR">아이폰XR</option>
						</select>
						</c:if>
						<c:if test="${adminGoods.goo_model == '아이폰XR' }">
						<select name="mod_model" id="mod_model">
							<option value="아이폰SE2">아이폰SE2</option>
							<option value="아이폰11">아이폰11</option>
							<option value="아이폰XS">아이폰X</option>	
							<option value="아이폰X">아이폰X</option>
							<option value="아이폰XR" selected>아이폰XR</option>
						</select>
						</c:if>
					</c:if>
					<c:if test="${adminGoods.goo_category == '삼성'}">				
						<c:if test="${adminGoods.goo_model == '갤럭시S20' }">
						<select name="mod_model" id="mod_model">
							<option value="갤럭시S20" selected>갤럭시S20</option>
							<option value="갤럭시S10">갤럭시S10</option>
							<option value="갤럭시노트20">갤럭시노트20</option>
							<option value="갤럭시노트10">갤럭시노트10</option>
						</select>
						</c:if>
						<c:if test="${adminGoods.goo_model == '갤럭시S10' }">
						<select name="mod_model" id="mod_model">
							<option value="갤럭시S20">갤럭시S20</option>
							<option value="갤럭시S10" selected>갤럭시S10</option>
							<option value="갤럭시노트20">갤럭시노트20</option>
							<option value="갤럭시노트10">갤럭시노트10</option>
						</select>
						</c:if>
						<c:if test="${adminGoods.goo_model == '갤럭시노트20' }">
						<select name="mod_model" id="mod_model">
							<option value="갤럭시S20">갤럭시S20</option>
							<option value="갤럭시S10">갤럭시S10</option>
							<option value="갤럭시노트20" selected>갤럭시노트20</option>
							<option value="갤럭시노트10">갤럭시노트10</option>
						</select>
						</c:if>
						<c:if test="${adminGoods.goo_model == '갤럭시노트10' }">
						<select name="mod_model" id="mod_model">
							<option value="갤럭시S20">갤럭시S20</option>
							<option value="갤럭시S10">갤럭시S10</option>
							<option value="갤럭시노트20">갤럭시노트20</option>
							<option value="갤럭시노트10" selected>갤럭시노트10</option>
						</select>
						</c:if>
					</c:if>
					<c:if test="${adminGoods.goo_category == 'LG'}">				
						<c:if test="${adminGoods.goo_model == '벨벳' }">
						<select name="mod_model" id="mod_model">
							<option value="벨벳" selected>벨벳</option>
							<option value="V50">V50</option>
							<option value="G8">G8</option>
						</select>
						</c:if>
						<c:if test="${adminGoods.goo_model == 'V50' }">
						<select name="mod_model" id="mod_model">
							<option value="벨벳">벨벳</option>
							<option value="V50" selected>V50</option>
							<option value="G8">G8</option>
						</select>
						</c:if>
						<c:if test="${adminGoods.goo_model == 'G8' }">
						<select name="mod_model" id="mod_model">
							<option value="벨벳">벨벳</option>
							<option value="V50">V50</option>
							<option value="G8" selected>G8</option>
						</select>
						</c:if>
					</c:if>
					<c:if test="${adminGoods.goo_category == '기타'}">				
						<c:if test="${adminGoods.goo_model == '베가LGT-A' }">
						<select name="mod_model" id="mod_model">
							<option value="베가LTA-A" selected>베가LTA-A</option>
							<option value="P30">P30</option>
							<option value="비와이폰">비와이폰</option>
						</select>
						</c:if>
						<c:if test="${adminGoods.goo_model == 'P30' }">
						<select name="mod_model" id="mod_model">
							<option value="베가LTA-A">베가LTA-A</option>
							<option value="P30" selected>P30</option>
							<option value="비와이폰">비와이폰</option>
						</select>
						</c:if>
						<c:if test="${adminGoods.goo_model == '비와이폰' }">
						<select name="mod_model" id="mod_model">
							<option value="베가LTA-A">베가LTA-A</option>
							<option value="P30">P30</option>
							<option value="비와이폰" selected>비와이폰</option>
						</select>
						</c:if>
					</c:if>
					<c:if test="${adminGoods.goo_category == '폴더폰'}">				
						<c:if test="${adminGoods.goo_model == '삼성폴더폰' }">
						<select name="mod_model" id="mod_model">
							<option value="삼성폴더폰" selected>삼성폴더폰</option>
							<option value="엘지폴더폰">엘지폴더폰</option>
						</select>
						</c:if>
						<c:if test="${adminGoods.goo_model == '엘지폴더폰' }">
						<select name="mod_model" id="mod_model">
							<option value="삼성폴더폰">삼성폴더폰</option>
							<option value="엘지폴더폰" selected>엘지폴더폰</option>
						</select>
						</c:if>
					</c:if>
				</td>
				<th>색상</th>
				<td>
					<c:if test="${adminGoods.goo_color == 'white'}">
					<select name="mod_color" id="mod_color">
						<option value="white" selected>white</option>
						<option value="black">black</option>
						<option value="red">red</option>
						<option value="blue">blue</option>
						<option value="pink">pink</option>
						<option value="yellow">yellow</option>
						<option value="purple">purple</option>
						<option value="green">green</option>
						<option value="brown">brown</option>
						<option value="gray">gray</option>
					</select>
					</c:if>
					<c:if test="${adminGoods.goo_color == 'black'}">
						<select name="mod_color" id="mod_color">
							<option value="white">white</option>
							<option value="black" selected>black</option>
							<option value="red">red</option>
							<option value="blue">blue</option>
							<option value="pink">pink</option>
							<option value="yellow">yellow</option>
							<option value="purple">purple</option>
							<option value="green">green</option>
							<option value="brown">brown</option>
							<option value="gray">gray</option>
						</select>
					</c:if>
					<c:if test="${adminGoods.goo_color == 'red'}">
						<select name="mod_color" id="mod_color">
							<option value="white">white</option>
							<option value="black">black</option>
							<option value="red" selected>red</option>
							<option value="blue">blue</option>
							<option value="pink">pink</option>
							<option value="yellow">yellow</option>
							<option value="purple">purple</option>
							<option value="green">green</option>
							<option value="brown">brown</option>
							<option value="gray">gray</option>
						</select>
					</c:if>
					<c:if test="${adminGoods.goo_color == 'blue'}">
						<select name="mod_color" id="mod_color">
							<option value="white">white</option>
							<option value="black">black</option>
							<option value="red">red</option>
							<option value="blue" selected>blue</option>
							<option value="pink">pink</option>
							<option value="yellow">yellow</option>
							<option value="purple">purple</option>
							<option value="green">green</option>
							<option value="brown">brown</option>
							<option value="gray">gray</option>
						</select>
					</c:if>
					<c:if test="${adminGoods.goo_color == 'pink'}">
						<select name="mod_color" id="mod_color">
							<option value="white">white</option>
							<option value="black">black</option>
							<option value="red">red</option>
							<option value="blue">blue</option>
							<option value="pink" selected>pink</option>
							<option value="yellow">yellow</option>
							<option value="purple">purple</option>
							<option value="green">green</option>
							<option value="brown">brown</option>
							<option value="gray">gray</option>
						</select>
					</c:if>
					<c:if test="${adminGoods.goo_color == 'yellow'}">
						<select name="mod_color" id="mod_color">
							<option value="white">white</option>
							<option value="black">black</option>
							<option value="red">red</option>
							<option value="blue">blue</option>
							<option value="pink">pink</option>
							<option value="yellow" selected>yellow</option>
							<option value="purple">purple</option>
							<option value="green">green</option>
							<option value="brown">brown</option>
							<option value="gray">gray</option>
						</select>
					</c:if>
					<c:if test="${adminGoods.goo_color == 'purple'}">
						<select name="mod_color" id="mod_color">
							<option value="white">white</option>
							<option value="black">black</option>
							<option value="red">red</option>
							<option value="blue">blue</option>
							<option value="pink">pink</option>
							<option value="yellow">yellow</option>
							<option value="purple" selected>purple</option>
							<option value="green">green</option>
							<option value="brown">brown</option>
							<option value="gray">gray</option>
						</select>
					</c:if>
					<c:if test="${adminGoods.goo_color == 'green'}">
						<select name="mod_color" id="mod_color">
							<option value="white">white</option>
							<option value="black">black</option>
							<option value="red">red</option>
							<option value="blue">blue</option>
							<option value="pink">pink</option>
							<option value="yellow">yellow</option>
							<option value="purple">purple</option>
							<option value="green" selected>green</option>
							<option value="brown">brown</option>
							<option value="gray">gray</option>
						</select>
					</c:if>
					<c:if test="${adminGoods.goo_color == 'brown'}">
						<select name="mod_color" id="mod_color">
							<option value="white">white</option>
							<option value="black">black</option>
							<option value="red">red</option>
							<option value="blue">blue</option>
							<option value="pink">pink</option>
							<option value="yellow">yellow</option>
							<option value="purple">purple</option>
							<option value="green">green</option>
							<option value="brown" selected>brown</option>
							<option value="gray">gray</option>
						</select>
					</c:if>
					<c:if test="${adminGoods.goo_color == 'gray'}">
						<select name="mod_color" id="mod_color">
							<option value="white">white</option>
							<option value="black">black</option>
							<option value="red">red</option>
							<option value="blue">blue</option>
							<option value="pink">pink</option>
							<option value="yellow">yellow</option>
							<option value="purple">purple</option>
							<option value="green">green</option>
							<option value="brown">brown</option>
							<option value="gray"> selected>gray</option>
						</select>
					</c:if>
					<c:if test="${adminGoods.goo_color == 'transparent'}">
						<select name="mod_color" id="mod_color">
							<option value="transparent" selected>transparenty</option>
						</select>
					</c:if>	
				</td>
			</tr>
			
			<tr>
				<th>상품 설명</th>
				<td colspan="3">
					<textarea class="w3-input w3-border w3-margin-bottom" name="mod_content" id="mod_content" cols="50" rows="10">${adminGoods.goo_content }</textarea>
				</td>	  
			</tr>
			
			<tr>
				<th>파일첨부</th>
				<td colspan="3">
					<p id="file_info">${adminGoods.goo_image }
						<input type="hidden" name="goo_image" value="${adminGoods.goo_image }"/>
						<input class="w3-input w3-border w3-margin-bottom" type="button" id="image_modify" value="수정" onclick="file_modify()"/>
					</p>
					
					<p id="file_add">
						<input type="file" name="mod_image" id="mod_image" accept="image/gif, image/jpeg, image/png"/>
					</p>
				</td>
			</tr>
			<tr>
				<td colspan="4" style="text-align:center;">
					<button class="w3-button w3-block w3-blue w3-section w3-padding" type="submit" id="submit" formaction="adminGoodsModifyAction.ad">수정하기</button>
					<button class="w3-button w3-block w3-red w3-section w3-padding" type="button" id="back" onclick="history.back()">뒤로가기</button>
	
				</td>
			</tr>
	    </tbody>
	</table>
	
</form>
<br><br>

</body>
</html>