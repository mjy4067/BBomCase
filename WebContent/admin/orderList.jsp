<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function checkAll(theForm){
		if(theForm.icheck.length == undefined){
			theForm.icheck.checked = theForm.allCheck.checked;
		} else{
			for(var i=0; i<theForm.icheck.length; i++){
				theForm.icheck[i].checked = theForm.allCheck.checked;
			}
		}
	}
	
	function goto_url(act) {
		var od_state = document.getElementById("ord_state").options[document.getElementById("ord_state").selectedIndex].value
		if(od_state!=null){
			var flag = confirm('변경 하시겠습니까?');
			if(flag){
				document.orderlist.action = encodeURI(act);
				document.orderlist.submit();
			}
		}
	}
</script>

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
	#ord_state, #ord_state_button{
		width : 150px;
		display : inline-block;
	}

</style>

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-light-blue.css">



</head>
<body>

	<h2 align="center">Order Management</h2>
	<p style="float: right; font-size: 12px; margin-right:100px;"><a href="goodsMainAction.go">홈</a> > 주문관리</p>
	<hr><br>

	<form name="orderlist" method="post">	
		<table class="type10">
		<c:choose>
    		<c:when test="${pageInfo.listCount>0 }">
   			<thead>
    			<tr>
			    	<th><input type="checkbox" name="allCheck" onClick="checkAll(this.form)" ></th>
			        <th>주문번호</th>
			        <th>주문일자</th>
			        <th>아이디</th>
			        <th>결제금액</th>
			        <th>주문현황</th>
			        <th>조회</th>
			    </tr>
			</thead>

					<c:forEach var="orderList" items="${orderList }">
  
		    <tbody>
		    <tr>
		        <th>
		        	<input type="checkbox" name="icheck" value="${orderList.ord_id }">
		        </th>
		        <th>
		        	${orderList.ord_id }
		        </th>
				<th>
					${orderList.ord_date }
				</th>
				<th>
					<c:if test="${orderList.mem_id == null }"> 탈퇴 회원</c:if>
					${orderList.mem_id }	
				</th>
				<th>
					${orderList.ord_total }원
				</th>
				<th>
					${orderList.ord_state }
				</th>
				
				<td>
					<p>
						<button class="w3-button w3-block w3-blue w3-section w3-padding" type="button" id="view" onclick="location.href='orderView.od?ord_id=${orderList.ord_id}'">조회</button> 
					</p>
				</td>
		    </tr>
		    </c:forEach>
		    <tr>
		    	<td colspan="7" style="text-align:left">
		    		<span>
						<select class="w3-input w3-border w3-margin-bottom" name="ord_state" id="ord_state" >
							<option value="주문완료">주문완료</option>
							<option value="결제완료">결제완료</option>
							<option value="배송중">배송중</option>
							<option value="배송완료">배송완료</option>
						</select>
						<button class="w3-button w3-block w3-theme-l3 w3-section w3-padding" id="ord_state_button" type="button" onclick="goto_url('orderState.od');">주문현황변경</button>
						
						
					</span>
					
					
		    	</td>
		  <tr>
						<td colspan="7">
							<p class="w3-left"><button class="w3-button w3-white w3-border" type="button" onclick="location.href='orderList.od'" ><b><i class="ps-icon-search"></i> 전체보기</b></button></p>
							<p class="w3-left"><button class="w3-button w3-white w3-border" type="button" onclick="location.href='orderList.od?page=${pageInfo.page}&state=주문완료'" ><b><i class="ps-icon-shopping-cart"></i> 주문완료</b></button></p>
							<p class="w3-left"><button class="w3-button w3-white w3-border" type="button" onclick="location.href='orderList.od?page=${pageInfo.page}&state=결제완료'" ><b><i class="ps-icon-money"></i> 결제완료</b></button></p>
							<p class="w3-left"><button class="w3-button w3-white w3-border" type="button" onclick="location.href='orderList.od?page=${pageInfo.page}&state=배송중'" ><b><i class="ps-icon-delivery"></i> 배송중</b></button></p>
							<p class="w3-left"><button class="w3-button w3-white w3-border" type="button" onclick="location.href='orderList.od?page=${pageInfo.page}&state=배송완료'" ><b><i class="ps-icon-heart"></i> 배송완료</b></button></p>	
						</td>
					</tr>
					
		   <tr>
						<td colspan="7">
									<c:if test="${pageInfo.page>=1 }">
	
						<div class="mt-30">
							<div class="ps-pagination">
								<ul class="pagination">
	
								<c:choose>
									<c:when test="${pageInfo.page<=pageInfo.startPage }"> </c:when>
									
									<c:otherwise>	
										<li><a href="orderList.od?page=${pageInfo.page-1 }<c:out value="${state !=null ? '&state=':'' }"/>${state}"> <i class="fa fa-angle-left"> </i> </a></li>
									</c:otherwise>
								</c:choose>
								
	
								<c:forEach var="a" begin="${pageInfo.startPage }" end="${pageInfo.endPage }" step="1">
									<c:choose>
										<c:when test="${a==pageInfo.page }"> 
											<li class="active"><a href="orderList.od?page=${a }<c:out value="${state !=null ? '&state=':'' }"/>${state}">${a }</a></li> 
										</c:when>
									
										<c:otherwise>
											<li><a href="orderList.od?page=${a }<c:out value="${state !=null ? '&state=':'' }"/>${state}">  ${a }  </a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
					
								<c:choose>
									<c:when test="${pageInfo.page>=pageInfo.maxPage }"> </c:when>
									
									<c:otherwise>	
										<li><a href="orderList.od?page=${pageInfo.page+1 }<c:out value="${state !=null ? '&state=':'' }"/>${state}"> <i class="fa fa-angle-right">  </i> </a></li>
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
					<tr><td colspan="7">조회 가능한 주문이 없습니다.</td></tr>
				</c:otherwise>
	</c:choose>

</table>

</form>

<br><br>


</body>
</html>