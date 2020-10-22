<%@page import="vo.GoodsBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.PageInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	ArrayList<GoodsBean> articleList = (ArrayList<GoodsBean>)request.getAttribute("articleList");
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
	function openPopup1(goo_name,goo_id){
		var url="admin/goodsImport.jsp?goo_name=" + goo_name + "&goo_id=" + goo_id;
		window.open(url, "import", "top=200, left=200, scrollbars=no, resizable=no, menubar=no, width=400, height=200");
	}
	
	function openPopup2(goo_name,goo_id){
		var url="admin/goodsExport.jsp?goo_name="+goo_name  + "&goo_id=" + goo_id;
		window.open(url, "export", "top=200, scrollbars=no, resizable=no, menubar=no, left=200, width=400, height=200");
	}
</script>
<meta charset="UTF-8">
<title>입출고</title>

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
	#import, #export{
		width : 80px;
		display:inline-block;
	}

</style>

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-light-blue.css">

</head>
<body>
	<h2 align="center">Stock List</h2>
	<p style="float: right; font-size: 12px; margin-right:100px;"><a href="goodsMainAction.go">홈</a> > 입출고관리</p>
	<hr><br>
 
	<form method="post">
		<table class="type10">
		<c:choose>
    	<c:when test="${pageInfo.listCount>0 }">
			<thead>
			    <tr>
			        <th>번호</th>
			        <th>상품명</th>
			        <th>브랜드</th>
			        <th>기종</th>
			        <th>색상</th>
			        <th>수량</th>
			        <th>등록일</th>
			        <th>입출고</th>
				</tr>
			</thead>
    
    		<c:forEach var="list" items="${adminStockList }">
  
		    <tbody>
			    <tr>
			        <th>
			        	${list.goo_id }
			        </th>
			        <th>
			        	${list.goo_name }
			        </th>
					<th>
						${list.goo_category }
					</th>
					<th>
						${list.goo_model }
					</th>
					<th>
						${list.goo_color }
					</th>
					<th>
						<label id="qty">${list.sto_qty }</label>
					</th>
					<th>
						${list.date }
					</th>
					<td>
						<p>
						<button class="w3-button w3-block w3-blue w3-section w3-padding" type="button" id="import" onclick="openPopup1('${list.goo_name}','${list.goo_id }')">입고</button>
						<button class="w3-button w3-block w3-red w3-section w3-padding" type="button" id="export" onclick="openPopup2('${list.goo_name}','${list.goo_id }')">출고</button> 
						</p>
					</td>
				
			    </tr>
		    </c:forEach>
		   
		   		
		   		<tr>
					<td colspan="8" > 
						<c:if test="${pageInfo.page>=1 }">
						<div class="mt-30">
							<div class="ps-pagination">
								<ul class="pagination">
		
								<c:choose>
									<c:when test="${pageInfo.page<=pageInfo.startPage }"> </c:when>
										
									<c:otherwise>	
										<li><a href="adminGoodsStockFormAction.ad?page=${pageInfo.page-1 }"> <i class="fa fa-angle-left"> </i> </a></li>
									</c:otherwise>
								</c:choose>
									
								<c:forEach var="a" begin="${pageInfo.startPage }" end="${pageInfo.endPage }" step="1">
									<c:choose>
										<c:when test="${a==pageInfo.page }"> 
											<li class="active"><a href="adminGoodsStockFormAction.ad?page=${a }">${a }</a></li> 
										</c:when>
										
										<c:otherwise>
											<li><a href="adminGoodsStockFormAction.ad?page=${a }">  ${a }  </a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						
								<c:choose>
									<c:when test="${pageInfo.page>=pageInfo.maxPage }"> </c:when>
										
									<c:otherwise>	
										<li><a href="adminGoodsStockFormAction.ad?page=${pageInfo.page+1 }"> <i class="fa fa-angle-right">  </i> </a></li>
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
				<td colspan="8">등록된 글이 없습니다</td>
			</tr>
		</c:otherwise>

		</c:choose>
		
		</table>

	</form>
	<br><br>
</body>
</html>