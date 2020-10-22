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
	.mono_table {
	    width: 100%;
	    border-collapse: separate;
	    border-spacing: 2px;
	    border: none;
	    color: #000;
	}
	
	.mono_table th {
	    padding: 15px;
	    background: url(http://nanati.me/img/monoptn.gif);
	    border: none;
	    font-weight: bold;
	    text-align: center;
	    vertical-align: middle;
	    text-shadow: 0 1px #FFF;
	    
	}
	 
	.mono_table td {
	    padding: 15px;
	    border: none;
	    border-bottom: 1px solid #000;
	    text-align: left;
	    vertical-align: baseline;
	}
	
	
	form{
		width : 60%;
		margin : auto;
	}
	img{
		width : 50%;
	}
	#od_state{
		width : 100px;
		display:inline-block;
	}
	#ord_state_button{
		width : 150px;
	}
	
	
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
</style>

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-light-blue.css">


</head>
<body>

 <h2 align="center">My Order Detail</h2><p style="float: right; font-size: 12px; margin-right:100px;"><a href="goodsMainAction.go">홈</a> > <a href="myOrderList.od">주문배송</a> > 조회</p>
	<hr><br>

	<form name="orderview" method="post">

	<h3>주문 정보</h3>
	<table class="mono_table">
    <tbody>
        <tr>
            <th>주문번호</th>
            <td>${order.ord_id }</td>
        </tr>
        <tr>
            <th>주문일자</th>
            <td>${order.ord_date }</td>
        </tr>
        <tr>
            <th>주문자</th>
            <td>${order.mem_id }</td>
        </tr>
		<tr>
            <th>주문현황</th>
            <td>${order.ord_state }</td>
        </tr>
    </tbody>
</table>
	
	<br>
	<h3>배송지 정보</h3>
	<table class="mono_table">
	    <tbody>
	        <tr>
	            <th>받는사람</th>
	            <td colspan="3">${order.receiver }</td>
	        </tr>
	        <tr>
	            <th>연락처</th>
	            <td colspan="3">${order.ord_tel }</td>
	        </tr>
	        <tr>
	            <th>주소</th>
	            <td>${order.zip_code }</td>
				<td>${order.addr1 }</td>
				<td>${order.addr2 }</td>
	        
	    </tbody>
	</table>
	
	<br>
	<h3>주문 상품 정보</h3>
	<table class="type09">
    <thead>
	    <tr>
	        <th>이미지</th>
	        <th>상품이름</th>
	        <th>색상</th>
	        <th>기종</th>
	        <th>수량</th>
	        <th>가격</th>
	    </tr>
    </thead>
    
    <tbody>
   		<c:forEach var="orderList" items="${orderList }">
	    <tr>
	        <td><img src="images/${orderList.goo_image }"></td>
	        <td>${orderList.goo_name }</td>
	        <td>${orderList.goo_color }</td>
	        <td>${orderList.goo_model }</td>
	        <th>${orderList.goo_qty }개</th>
	        <th>${orderList.goo_price }원</th>
	 	</tr>
	    </c:forEach>
	    
	    <tr>
			<td colspan="6" style="font-size:30px;">총 결제금액 : ${order.ord_total } 원 </td>
		</tr>
		
		<tr>
			<td>
				<p class="w3-left"><button class="w3-button w3-white w3-border" type="button" onclick="location.href='myOrderList.od'" ><b><i class="ps-icon-back"></i> 돌아가기</b></button></p>
			</td>
		</tr>
	</tbody>
</table>
</form>
</body>
</html>