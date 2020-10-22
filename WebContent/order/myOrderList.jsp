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

<style>
	table.type10 {
    border-collapse: collapse;
    text-align: left;
    line-height: 1.5;
    border-top: 1px solid #ccc;
    border-bottom: 1px solid #ccc;
    margin: auto;
    text-align : center;
	}
	table.type10 thead th {
	    width: 100px;
	    padding: 10px;
	    font-weight: bold;
	    vertical-align: top;
	    color: #fff;
	    background: #D1B2FF;
	    margin: 20px 10px;
	    text-align : center;
	}
	table.type10 tbody th {
	    width: 150px;
	    padding: 10px;
	    text-align : center;

	}
	table.type10 td {
	    width: 350px;
	    padding: 10px;
	    vertical-align: top;
	    
	    
	}
	form{
		width : 75%;
		margin : auto;
	}	
	table{
		text-align : center;
	}
	#view{
		width : 100px;
		display:inline-block;
	}

</style>

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-light-blue.css">


</head>
<body>


 <h2 align="center">My Order</h2><p style="float: right; font-size: 12px; margin-right:100px;"><a href="goodsMainAction.go">홈</a> > 주문배송</p>
	<hr><br>

	<form name="orderlist" method="post">
		
		<table class="type10">
		<c:choose>
    	<c:when test="${pageInfo.listCount>0 }">
    <thead>
    <tr>
        <th>주문번호</th>
        <th>주문일자</th>
        <th>결제금액</th>
        <th>주문현황</th>
        <th>조회</th>
    </tr>
    </thead>
  
	<tbody>
		<c:forEach var="orderList" items="${orderList }">
		<tr>
			<th>
		    	${orderList.ord_id }
			</th>
			<th>
				${orderList.ord_date }
			</th>
			<th>
				${orderList.ord_total }원
			</th>
			<th>
				${orderList.ord_state }
			</th>
			<td>
				<button class="w3-button w3-block w3-blue w3-section w3-padding" type="button" id="view" onclick="location.href='myOrderView.od?ord_id=${orderList.ord_id}'">조회</button> 
			</td>	
		</tr>
	 	</c:forEach>
		
		<tr>
			<td colspan="7">
				<c:if test="${pageInfo.page>=1 }">
				<div class="mt-30">
					<div class="ps-pagination">
						<ul class="pagination">
	
							<c:choose>
								<c:when test="${pageInfo.page<=pageInfo.startPage }"> </c:when>
								
								<c:otherwise>	
									<li><a href="myOrderList.od?page=${pageInfo.page-1 }"> <i class="fa fa-angle-left"> </i> </a></li>
								</c:otherwise>
							</c:choose>
								
							<c:forEach var="a" begin="${pageInfo.startPage }" end="${pageInfo.endPage }" step="1">
							<c:choose>
								<c:when test="${a==pageInfo.page }"> 
									<li class="active"><a href="myOrderList.od?page=${a }">${a }</a></li> 
								</c:when>
									
								<c:otherwise>
									<li><a href="myOrderList.od?page=${a }">  ${a }  </a></li>
								</c:otherwise>
							
							</c:choose>
							</c:forEach>
					
							<c:choose>
								<c:when test="${pageInfo.page>=pageInfo.maxPage }"> </c:when>
									
								<c:otherwise>	
									<li><a href="myOrderList.od?page=${pageInfo.page+1 }"> <i class="fa fa-angle-right">  </i> </a></li>
								</c:otherwise>
							</c:choose>
							
						</ul>
					</div>
				</div>
				</c:if>	
				
			</td>
		</tr>
				
		</tbody>
	</c:when>
	
		<c:otherwise>
			<tr>
				<td colspan="5">조회 가능한 주문이 없습니다.</td>
			</tr>
		</c:otherwise>
	</c:choose>

</table>

</form>

<br><br>	

</body>
</html>