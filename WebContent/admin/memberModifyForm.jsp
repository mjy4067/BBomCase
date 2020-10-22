<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	.w3-container{
		width: 800px;
		align: center;
		margin: auto;
	}
	.simple_table {
	    width: 100%;
	    border: none;
	    border-collapse: separate;
	    border-spacing: 2px;
	}
	 
	.simple_table th {
	    padding: 15px;
	    border: none;
	    border-left: 5px solid #C03;
	    border-bottom: 1px solid #DDD;
	    background: #FCF0F3;
	    font-weight: normal;
	    text-align:center;
	    text-shadow: 0 1px #FFF;
	    vertical-align: middle;
	}
	 
	.simple_table td {
	    padding: 15px;
	    border: none;
	    border-bottom: 1px solid #DDD;
	    text-align: left;
	    vertical-align: baseline;
	}

	#telArea{
		width : 70px;
		display:inline-block;
	}
	#mem_tel{
		width : 80px;
		display:inline-block;
	}
	#mem_email{
		width : 110px;
		display:inline-block;
	}
	#emailArea{
		width : 150px;
		display:inline-block;
	}
	#zip_code{
		width : 90px;
		display:inline-block;
	}
	#zip{
		width: 90px;
		display:inline-block;
	}
	#modify{
		width : 200px;
		display:inline-block;
	}
	#delete{
		width : 200px;
		display:inline-block;
	}
	#back{
		width : 200px;
		display:inline-block;
	}
	
	
</style>


<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-light-blue.css">

</head>
<body>

	<h2 align="center">Member Modify</h2>
	<p style="float: right; font-size: 12px; margin-right: 100px;"><a href="goodsMainAction.go">홈</a> > <a href="memberListAction.me">회원관리</a> > 수정</p>
	<hr><br>
	
	<form class="w3-container" action="memberModifyAction.me?id=${memberInfoResult.mem_id }" method="post" name="modifyform">
		
		<table class="simple_table">
		    <tbody>
		        <tr>
		        	<th >아이디</th>
		        	<td> <input class="w3-input w3-border w3-margin-bottom" type="text" name="mem_id" id="mem_id" value="${memberInfoResult.mem_id}" readonly>  </td>
		        </tr>
		        
		        <tr>
		            <th >비밀번호</th>
		            <td><input class="w3-input w3-border w3-margin-bottom" type="text" name="mem_pass" id="mem_pass" value="${memberInfoResult.mem_pass}"></td>
		        </tr>
		        <tr>
		            <th >이름</th>
		            <td><input class="w3-input w3-border w3-margin-bottom" type="text" name="mem_name" id="mem_name" value="${memberInfoResult.mem_name }"></td>
		        </tr>
		         <tr>
		            <th >생년월일</th>
		            <td><input class="w3-input w3-border w3-margin-bottom" type="date" name="mem_birth" id="mem_birth" value="${memberInfoResult.mem_birth }"></td>
		        </tr>
		         <tr>
		            <th >연락처</th>
		            <td><select class="w3-input w3-border w3-margin-bottom" name="telArea" id="telArea">
							<c:choose>
								<c:when test="${tel1 == '010' }">
									<option value="010" selected="selected">010</option>
									<option value="011">011</option>
									<option value="016">016</option>
									<option value="018">018</option>
								</c:when>
								<c:when test="${tel1 == '011' }">
									<option value="010">010</option>
									<option value="011" selected="selected">011</option>
									<option value="016">016</option>
									<option value="018">018</option>
								</c:when>
								<c:when test="${tel1 == '016' }">
									<option value="010">010</option>
									<option value="011">011</option>
									<option value="016" selected="selected">016</option>
									<option value="018">018</option>
								</c:when>
								<c:when test="${tel1 == '018' }">
									<option value="010">010</option>
									<option value="011">011</option>
									<option value="016">016</option>
									<option value="018" selected="selected">018</option>
								</c:when>
							</c:choose>
						</select> -
						<input class="w3-input w3-border w3-margin-bottom" type="text" name="mem_tel1" id="mem_tel" value="${tel2 }" maxlength="4"/>-
						<input class="w3-input w3-border w3-margin-bottom" type="text" name="mem_tel2" id="mem_tel" value="${tel3 }" maxlength="4"/>
					</td>
		        </tr>
				<tr>
		            <th >이메일</th>
		            <td><input class="w3-input w3-border w3-margin-bottom" type="text" name="mem_email" id="mem_email" value="${email1 }"/>@
						<span id="emailform">
							<select class="w3-input w3-border w3-margin-bottom" name="emailArea" id="emailArea">
								<c:choose>
									<c:when test="${email2 == 'gmail.com' }">
										<option value="gmail.com" selected="selected">gmail.com</option>
										<option value="naver.com">naver.com</option>
										<option value="daum.net">daum.net</option>
										<option value="null">직접입력</option>
									</c:when>
									<c:when test="${email2 == 'naver.com' }">
										<option value="gmail.com">gmail.com</option>
										<option value="naver.com" selected="selected">naver.com</option>
										<option value="daum.net">daum.net</option>
										<option value="null">직접입력</option>
									</c:when>
									<c:when test="${email2 == 'daum.net' }">
										<option value="gmail.com">gmail.com</option>
										<option value="naver.com">naver.com</option>
										<option value="daum.net" selected="selected">daum.net</option>
										<option value="null">직접입력</option>
									</c:when>
									<c:otherwise>
										<input type="text" name="emailArea" id="emailArea"/>
									</c:otherwise>
								</c:choose>
							</select>
						</span>
					</td>
		        </tr>

		         <tr>
		            <th >주소</th>
		            <td>
		            	<input class="w3-input w3-border w3-margin-bottom" type="text" name="zip_code" id="zip_code" placeholder="우편번호" value="${memberInfoResult.zip_code }">          
						<button class="w3-button w3-block w3-green w3-section w3-padding" type="button" id="zip" onclick="sample6_execDaumPostcode()">주소검색</button>                 
			 			<input class="w3-input w3-border w3-margin-bottom" type="text" name="addr1" id="addr1" placeholder="주소" value="${memberInfoResult.addr1 }">  
						<input class="w3-input w3-border w3-margin-bottom" type="text" name="addr2" id="addr2" placeholder="상세주소" value="${memberInfoResult.addr2 }">  
			            <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
						<script>
						    function sample6_execDaumPostcode() {
						        new daum.Postcode({
						            oncomplete: function(data) {
						                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
						
						                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
						                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						                var fullAddr = ''; // 최종 주소 변수
						                var extraAddr = ''; // 조합형 주소 변수
						
						                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
						                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
						                    fullAddr = data.roadAddress;
						
						                } else { // 사용자가 지번 주소를 선택했을 경우(J)
						                    fullAddr = data.jibunAddress;
						                }
						
						                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
						                if(data.userSelectedType === 'R'){
						                    //법정동명이 있을 경우 추가한다.
						                    if(data.bname !== ''){
						                        extraAddr += data.bname;
						                    }
						                    // 건물명이 있을 경우 추가한다.
						                    if(data.buildingName !== ''){
						                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
						                    }
						                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
						                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
						                }
						                // 우편번호와 주소 정보를 해당 필드에 넣는다.
						                document.getElementById('zip_code').value = data.zonecode; //5자리 새우편번호 사용
						                document.getElementById('addr1').value = fullAddr;
			
						                // 커서를 상세주소 필드로 이동한다.
						                document.getElementById('addr2').focus();
						            }
						        }).open();
						    }
						</script>
					</td>
		        </tr>
		        <tr>
		        	<th >등급</th>
		        	<td> <input class="w3-input w3-border w3-margin-bottom" type="text" name="mem_grade" id="mem_grade" value="${memberInfoResult.mem_grade}">  </td>
		        </tr>
		         <tr>
		            <th >가입일자</th>
		            <td>${memberInfoResult.mem_date }</td>
		        </tr>
		     	<tr>
			     	<td colspan = "2" style="text-align:center;">
						<button class="w3-button w3-block w3-theme-l3 w3-section w3-padding" type="submit" id="modify">수정하기</button>  &nbsp;&nbsp;&nbsp;&nbsp;
						<button class="w3-button w3-block w3-theme-l3 w3-section w3-padding" type="button" id="delete" onclick="location.href='memberDeleteAction.me?id=${memberInfoResult.mem_id}'">삭제하기</button>   &nbsp;&nbsp;&nbsp;&nbsp;
						<button class="w3-button w3-block w3-theme-l3 w3-section w3-padding" type="button" id="back" onclick="history.back()">뒤로가기</button>
					</td>
		     	</tr>
     	
		    </tbody>			
		</table>
	</form>
	<br><br>

	
</body>
</html>