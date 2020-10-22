<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<c:choose>
				<c:when test="${pageInfo.listCount>0 }">
		<tr>
			<td>주문번호</td>
			<td>주문일자</td>
			<td>총금액</td>
			<td>주문상태</td>
			<td>조회</td>
		</tr>
			<c:forEach var="orderList" items="${orderList }">
		<tr>
			
			
			<td>${orderList.ord_id }</td>
			<td>${orderList.ord_date }</td>
			<td>${orderList.ord_total }</td>
			<td>${orderList.ord_state }</td>
			<td><button type="button" onclick="location.href='myOrderView.od?ord_id=${orderList.ord_id}'">조회</button></td>
		</tr>
			</c:forEach>
		<tr>
			<td colspan="5">
				<c:if test="${pageInfo.page<=1 }"/>
						
				<c:if test="${pageInfo.page>1 }">
					<a href="myOrderList.od?page=${pageInfo.page-1}"> < </a>
				</c:if>
				<c:forEach var="a" begin="${pageInfo.startPage }" end="${pageInfo.endPage }" step="1">
						<c:choose>
							<c:when test="${a==pageInfo.page }">
								<span id="nowpage">${a }</span>
							</c:when>
							<c:otherwise>
								<a href="myOrderList.od?page=${a }">&nbsp;${a }&nbsp;</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:choose>
						<c:when test="${pageInfo.page>=pageInfo.maxPage }">
							
						</c:when>
						<c:otherwise>
							<a href="myOrderList.od?page=${pageInfo.page+1 }"> > </a>
						</c:otherwise>
					</c:choose>
					</td>
			</tr>
			</c:when>
			<c:otherwise>
				<tr><td colspan="6">조회 가능한 주문이 없습니다.</td></tr>
			</c:otherwise>
			</c:choose>
	</table>
</body>
</html>