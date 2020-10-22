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
</head>
<body>
	<h1>주문내역</h1>
	
	<table>
		<h3>주문 정보</h3>
		<tr>
			<td>주문번호 : </td>
			<td>${order.ord_id }</td>
		</tr>
		<tr>
			<td>주문일자 : </td>
			<td>${order.ord_date }</td>
		</tr>
		<tr>
			<td>주문자 : </td>
			<td>${order.mem_id }</td>
		</tr>
		<tr>
			<td>주문현황 : </td>
			<td>${order.ord_state }</td>
		</tr>	
	</table>
	
	<table>
		<h3>배송지 정보</h3>
		<tr>
			<td>받는 사람 : </td>
			<td>${order.receiver }</td>
		</tr>
		<tr>
			<td>연락처 : </td>
			<td>${order.ord_tel }</td>
		</tr>
		<tr>
			<td>주소 : </td>
			<td>${order.zip_code }</td>
			<td>${order.addr1 }</td>
			<td>${order.addr2 }</td>
		</tr>
	
	</table>
	
	<table>
		<h3>주문 상품 정보</h3>
		
		<tr>
			<td>이미지 </td>
			<td>상품이름</td>
			<td>색상</td>
			<td>기종</td>
			<td>수량</td>
			<td>가격</td>
		</tr>
		
		<c:forEach var="orderList" items="${orderList }">
		<tr>
			<td><img src="images/${orderList.goo_image }"></td>
			<td>${orderList.goo_name }</td>
			<td>${orderList.goo_color }</td>
			<td>${orderList.goo_model }</td>
			<td>${orderList.goo_qty }</td>
			<td>${orderList.goo_price }</td>
		</tr>
		</c:forEach>
		
		<tr>
			<td colspan="6">총 결제금액 : ${order.ord_total } 원 </td>
		</tr>
	</table>
</body>
</html>