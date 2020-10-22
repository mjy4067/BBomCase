<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>

	table.type09 {
    border-collapse: collapse;
    text-align: left;
    line-height: 1.5;
	text-align : center;
	}
	table.type09 thead th {
	    padding: 10px;
	    font-weight: bold;
	    vertical-align: top;
	    color: #369;
	    border-bottom: 3px solid #036;
	     text-align : center;
	}
	table.type09 tbody th {
	    width: 150px;
	    padding: 10px;
	    font-weight: bold;
	    vertical-align: top;
	    border-bottom: 1px solid #ccc;
	    background: #f3f6f7;
	     text-align : center;
	}
	table.type09 td {
	    width: 350px;
	    padding: 10px;
	    vertical-align: top;
	    border-bottom: 1px solid #ccc;
	     text-align : center;
	}
	
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
	#ord_tel{
		width : 80px;
		display:inline-block;
	}
	#ord_email{
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
	#submit, #back{
		width : 200px;
		display:inline-block;
	}
	form{
		width : 60%;
		margin : auto;
	}
	img{
		width : 50%;
	}
	
	
</style>


<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-light-blue.css">


</head>
<body>

	<form action="order.od" method="post">

		<h3>주문 상품 정보</h3>
		<table class="type09">
		    <thead>
			    <tr>
			        <th>이미지</th>
			        <th>상품명</th>
			        <th>색상</th>
			        <th>가격</th>
			        <th>수량</th>
			        <th>결제금액</th>
			    </tr>
		    </thead>
		    
		    <tbody>
		    	<c:forEach var="order" items="${orderList }" >
		    	<tr>
		  	 	
		  	 	<c:choose>
		  	 		<c:when test ="${order.name != null }" >
		  	 		
		  	 		<input type="hidden" name="goo_id" value="${order.item_code}"/>
					<input type="hidden" name="ord_price" value="${order.price * order.qty }"/>
					<input type="hidden" name="ord_qty" value="${order.qty }"/>
		  	 		
		  	 		<td><img src="images/${order.image }"></td>
			        <td>${order.name }</td>
			        <td>${order.color }</td>
			        <th>${order.price }원</th>
			        <th>${order.qty }개</th>
			        <th>${order.price * order.qty }원</th>
		  	 		
		  	 		</c:when>
			    	
			    	<c:otherwise>
			    	
			    	<input type="hidden" name="goo_id" value="${order.goo_id}"/>
					<input type="hidden" name="ord_price" value="${order.goo_price * order.goo_qty }"/>
					<input type="hidden" name="ord_qty" value="${order.goo_qty }"/>
					
			        <td><img src="images/${order.goo_image }"></td>
			        <td>${order.goo_name }</td>
			        <td>${order.goo_color }</td>
			        <th>${order.goo_price }원</th>
			        <th>${order.goo_qty }개</th>
			        <th>${order.goo_price * order.goo_qty}원</th>
			 		
			 		</c:otherwise>
			 		
				</c:choose>
			   
			    </tr>
			  	
			  	 </c:forEach>
			  	 
			  	<c:choose>
			  	<c:when test="${totalCart != 0 }">
			    <tr>
					<td colspan="6" style="font-size:30px;">총 결제금액 : ${totalCart } 원 입니다.</td>
					<input type="hidden" name="totalPrice" value="${totalCart }">
				</tr>
				</c:when>
				
				<c:otherwise>
				<c:forEach var="order" items="${orderList }"  >
				<tr>
					<td colspan="6" style="font-size:30px;">총 결제금액 : ${order.goo_price * order.goo_qty } 원 입니다.</td>
					<input type="hidden" name="totalPrice" value="${order.goo_price * order.goo_qty }">
				</tr>
				</c:forEach>
				</c:otherwise>
				
				</c:choose>
			</tbody>
		</table>	

	<h2>회원 정보</h2>
		<table class="simple_table">
		    <tbody>
		        <tr>
		        	<th>아이디</th>
		        	<td><input class="w3-input w3-border w3-margin-bottom" type="text" name="mem_id" id="mem_id" value="${memberInfoResult.mem_id}" readonly>  </td>
		        </tr>
		        
		        <tr>
		            <th>받는사람</th>
		            <td><input class="w3-input w3-border w3-margin-bottom" type="text" name="receiver" id="receiver" value="${memberInfoResult.mem_name}"></td>
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
						<input class="w3-input w3-border w3-margin-bottom" type="text" name="ord_tel1" id="ord_tel" value="${tel2 }" maxlength="4"/>-
						<input class="w3-input w3-border w3-margin-bottom" type="text" name="ord_tel2" id="ord_tel" value="${tel3 }" maxlength="4"/>
					</td>
		        </tr>
		     
		         <tr>
		            <th >이메일</th>
		            <td><input class="w3-input w3-border w3-margin-bottom" type="text" name="ord_email" id="ord_email" value="${email1 }"/>@
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
		            	<input class="w3-input w3-border w3-margin-bottom" type="text" name="zip_code" id="zip_code" value="${memberInfoResult.zip_code }" readonly>          
			<button class="w3-button w3-block w3-green w3-section w3-padding" type="button" id="zip" onclick="sample6_execDaumPostcode()">주소검색</button>                 
 			
 			<input class="w3-input w3-border w3-margin-bottom" type="text" name="addr1" id="addr1" value="${memberInfoResult.addr1 }" readonly>  
 
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
		        	<th >결제방법</th>
		        	<td>
		        		<input  type="radio" name="payment" value="계좌이체" checked="checked"> 계좌이체  &nbsp;&nbsp; &nbsp;&nbsp;
		        		<input  type="radio" name="payment" value="무통장입금" > 무통장임금  &nbsp;&nbsp;  &nbsp;&nbsp;
		        		<input  type="radio" name="payment" value="신용카드" > 신용카드
		        		
		        	</td>
		        </tr>
		 
		     	<tr>
		     	<td colspan = "2" style="text-align:center;">
					<button class="w3-button w3-block w3-theme-l3 w3-section w3-padding" type="submit" id="submit">결제하기</button> 
					<button class="w3-button w3-block w3-theme-l3 w3-section w3-padding" type="button" id="back" onclick="history.back()">뒤로가기</button>

				</td>
		     	</tr>
		     	
		    
		    </tbody>
			
		</table>

</form>

</body>
</html>