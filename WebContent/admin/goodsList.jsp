<%@page import="vo.PageInfo"%>
<%@page import="vo.GoodsBean"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
	int listCount = pageInfo.getListCount();
	int nowPage = pageInfo.getPage();
	int maxPage = pageInfo.getMaxPage();
	int startPage = pageInfo.getStartPage();
	int endPage = pageInfo.getEndPage();
%>
<!DOCTYPE html>
<html>
<head>
<script>
	function checkAll(t){
		if (t.remove.length == undefined) {
			t.remove.checked = t.allCheck.checked;
		} else {
			for(var i=0; i<t.remove.length; i++){
				t.remove[i].checked = t.allCheck.checked
			}
		}
	}
</script>
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
		width : 70%;
		margin : auto;
	}	
	#modify, #delete{
		width : 80px;
		display:inline-block;
	}

</style>
	
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-light-blue.css">
	
</head>
<body>
	
	<h2 align="center">Product Management</h2>
	<p style="float: right; font-size: 12px; margin-right: 100px;"><a href="goodsMainAction.go">홈</a> > 상품관리</p>
	<hr><br>
	
	<form method="post">
		<table class="type10">
		<c:choose>
	    	<c:when test="${pageInfo.listCount>0 }">
		<thead>
		    <tr>
		    	<th><input type="checkbox" id="allCheck" name="allCheck" onclick="checkAll(this.form)"/></th>
		        <th>상품번호</th>
		        <th>상품명</th>
		        <th>가격</th>
		        <th>브랜드</th>
		        <th>기종</th>
		        <th>색상</th>
		        <th>등록일</th>
		        <th>수정/삭제</th>
		    </tr>
	    </thead>
	    
		<c:forEach var="adminGoods" items="${articleList }">	
	  
		<tbody>
		    <tr>
		    	<th>
		    		<input type="checkbox" id="remove" name="remove" value="${adminGoods.goo_id }"/>
		    	</th>
		        <th>
					${adminGoods.goo_id }
				</th>
				<th>
			      	${adminGoods.goo_name }
			    </th>
				<th>
					${adminGoods.goo_price }원
				</th>
				<th>
					${adminGoods.goo_category }
				</th>
				<th>
					${adminGoods.goo_model }
				</th>
				<th>
					${adminGoods.goo_color }
				</th>
				<th>
					${adminGoods.goo_date }
				</th>
				<td>
					<p>
						<button class="w3-button w3-block w3-blue w3-section w3-padding" type="button" id="modify" onclick="location.href='adminGoodsModifyFormAction.ad?goo_id=${adminGoods.goo_id}'">수정</button>
						<button class="w3-button w3-block w3-red w3-section w3-padding" type="button" id="delete" onclick="location.href='adminGoodsRemoveAction.ad?goo_id=${adminGoods.goo_id}'">삭제</button> 
					</p>
				</td>	
			</tr>
		</c:forEach>

			<tr>
				<td colspan="9" > 
				<c:if test="${pageInfo.page>=1 }">
		
					<div class="mt-30">
						<div class="ps-pagination">
							<ul class="pagination">
		
							<c:choose>
								<c:when test="${pageInfo.page<=pageInfo.startPage }"> </c:when>
										
								<c:otherwise>	
									<li><a href="adminGoodsListAction.ad?page=${pageInfo.page-1 }"> <i class="fa fa-angle-left">  </i> </a></li>
								</c:otherwise>
							</c:choose>
							
							<c:forEach var="a" begin="${pageInfo.startPage }" end="${pageInfo.endPage }" step="1">
								<c:choose>
									<c:when test="${a==pageInfo.page }"> 
										<li class="active"><a href="adminGoodsListAction.ad?page=${a }">${a }</a></li> 
									</c:when>
										
									<c:otherwise>
										<li><a href="adminGoodsListAction.ad?page=${a }">  ${a }  </a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						
							<c:choose>
								<c:when test="${pageInfo.page>=pageInfo.maxPage }"> </c:when>							
								<c:otherwise>	
									<li><a href="adminGoodsListAction.ad?page=${pageInfo.page+1 }"> <i class="fa fa-angle-right">  </i> </a></li>
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
					<td colspan="9">등록된 글이 없습니다</td>
				</tr>
			</c:otherwise>
		</c:choose>
		</table>
	</form>
	<br><br>
</body>
</html>