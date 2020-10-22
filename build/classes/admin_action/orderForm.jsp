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
	#orderFormArea{
		margin : auto;
		width : 900px;
		height : auto;
		border : 2px double red;
		border-radius : 10px;
		text-align : center;
	}
	table{
		width : 900px;
		margin : auto;
	}
	.td_left{
		width : 250px;
	}
	.td_right{
		width : 500px;
	}
	td, tr{
	border: 1px solid #ddd;
}
</style>
</head>
<body>
	<section id="orderFormArea">
		<h1>주문 정보</h1>
		<form action="order.od" method="post">
		
		
		
			<table>
				<tr>
					<td>이미지</td>
					<td>상품명</td>
					<td>색상</td>
					<td>가격</td>
					<td>수량</td>
					<td>결제금액</td>
				</tr>
				<c:forEach var="order" items="${orderList }" varStatus="status" >
				<tr>
				
					<c:choose>
					
					<c:when test ="${order.name != null }" >
				
						<input type="hidden" name="goo_id" value="${order.item_code}"/>
						<input type="hidden" name="ord_price" value="${order.price * order.qty }"/>
						<input type="hidden" name="ord_qty" value="${order.qty }"/>
						
						
						
					
					
						<td><img src="images/${order.image }"></td>
						<td>${order.name }</td>
						<td>${order.color }</td>
						<td>${order.price }원</td>
						<td>${order.qty }개</td>
						<td>${order.price * order.qty }원</td>
					</c:when>
					
					<c:otherwise>
						
						<input type="hidden" name="goo_id" value="${order.goo_id}"/>
						<input type="hidden" name="ord_price" value="${order.goo_price * order.goo_qty }"/>
						<input type="hidden" name="ord_qty" value="${order.goo_qty }"/>
						
					
						
						<td><img src="images/${order.goo_image }"></td>
						<td>${order.goo_name }</td>
						<td>${order.goo_color }</td>
						<td>${order.goo_price }원</td>
						<td>${order.goo_qty }개</td>
						<td>${order.goo_price * order.goo_qty }원</td>
					</c:otherwise>
					</c:choose>
					
				</tr>
				</c:forEach>
				<c:choose>
					<c:when test="${totalCart != 0 }">
						<tr>
							<td colspan="6">총 결제금액 : ${totalCart }원 입니다.</td>
							<input type="hidden" name="totalPrice" value="${totalCart }">
						</tr>
					</c:when>
					
					<c:otherwise>
						<c:forEach var="order" items="${orderList }" varStatus="status" >
						<tr>
							<td colspan="6">총 결제금액 : ${order.goo_price * order.goo_qty }원 입니다.</td>
							<input type="hidden" name="totalPrice" value="${order.goo_price * order.goo_qty }">
						</tr>
						</c:forEach>
					</c:otherwise>
				
				</c:choose>
				
			</table>
			<br><br><br>
			<h1>주문자 정보</h1>
			
		
			<table>
				<tr>	
					<td class="td_left"><label for="mem_id">주문자 아이디: </label></td>
					<td class="td_right"><input type="text" name="mem_id" id="mem_id" value="${memberInfoResult.mem_id}" readonly/></td>
				</tr>
				<tr>
					<td class="td_left"><label for="receiver">받는사람 이름 :</label></td>
					<td class="td_right"><input type="text" name="receiver" id="receiver" value="${memberInfoResult.mem_name }"></td>
				</tr>
				<tr>
					<td class="td_left"><label for="ord_tel">연락처 :</label></td>
					<td class="td_right">
						<select name="telArea" id="telArea">
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
						<input type="text" name="ord_tel1" id="ord_tel" value="${tel2 }" maxlength="4"/>-
						<input type="text" name="ord_tel2" id="ord_tel" value="${tel3 }" maxlength="4"/>
					</td>
					
				</tr>
				
				<tr>
					<td class="td_left"><label for="ord_email">이메일 :</label></td>
					<td class="td_right"><input type="text" name="ord_email" id="ord_email" value="${email1 }"/>@
						<span id="emailform">
							<select name="emailArea" id="emailArea">
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
					<td class="td_left"><label for="addr">주소 : </label></td>
					<td class="td_right">
						<input type="text" name="zip_code" id="zip_code" value="${memberInfoResult.zip_code }" readonly/>
						<button type="button" onclick="sample6_execDaumPostcode()">주소검색</button> <br>
						<input type="text" name="addr1" id="addr1" value="${memberInfoResult.addr1 }" readonly/><br>
						<input type="text" name="addr2" id="addr2" value="${memberInfoResult.addr2 }"/>
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
					<td class="td_left"><label for="payment">결제방법 : </label></td>
					<td>
						<input type="radio" name="payment" value="계좌이체" checked="checked" id="payment"/>계좌이체
						<input type="radio" name="payment" value="무통장입금">&nbsp;무통장입금
						<input type="radio" name="payment" value="신용카드">&nbsp;신용카드
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="submit">결제하기</button>
						<button type="button" onclick="history.back();">취소하기</button>
					</td>
				</tr>
			</table>
		
		</form>
	</section>
</body>
</html>