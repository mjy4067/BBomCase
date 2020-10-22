<%@page import="vo.PageInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
	int listCount = pageInfo.getListCount();
	int nowPage = pageInfo.getPage();
	int maxPage = pageInfo.getMaxPage();
	int startPage = pageInfo.getStartPage();
	int endPage = pageInfo.getEndPage();
	String id = (String)session.getAttribute("id");
%>
<!DOCTYPE html>
<html>
<head>
<style>
	table.type10 {
	    border-collapse: collapse;
	    text-align: left;
	    line-height: 1.5;
	    border-top: 1px solid #ccc;
	    border-bottom: 1px solid #ccc;
	    margin: auto;
	}
	table.type10 thead th {
	    width: 125px;
	    padding: 10px;
	    font-weight: bold;
	    vertical-align: top;
	    color: #fff;
	    background: #D1B2FF;
	    margin: 20px 10px;
	}
	table.type10 tbody th {
	    width: 125px;
	    padding: 10px;
	}
	table.type10 td {
	    width: 235px;
	    padding: 10px;
	    vertical-align: top;
	}
	table.type10 .even {
	    background: #fdf3f5;
	}
	img{
		width: 30%;
	}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">QnA List</h2>
<p style="float: right; font-size: 12px; margin-right: 100px;"><a href="goodsMainAction.go">홈</a> > 상품문의</p>
<hr><br>
<table class="type10">
    <thead>
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>날짜</th>
        <th>조회수</th>
    </tr>
    </thead>
    
       <c:choose>
		<c:when test="${pageInfo.listCount>0 }">
    		<c:forEach var="list" items="${articleList }" varStatus="status">
 
		    	<tbody>
		    <tr>
		        <th scope="row">${status.index+1}</th>
		        <td><a href="boardQnaView.bo?qna_id=${list.id}&page=${pageInfo.page}">${list.title} <c:if test="${list.reply != null}"> [1] </c:if></a></td>
				<td>${list.mem_id}</td>
				<td>${list.date}</td>
				<td>${list.hits}</td>
		    </tr>
		    </c:forEach>

		    <tr>
				<td colspan="5" > 
					<c:if test="${pageInfo.page>=1 }">
	
						<div class="mt-30">
							<div class="ps-pagination">
								<ul class="pagination">
	
								<c:choose>
									<c:when test="${pageInfo.page<=pageInfo.startPage }"> </c:when>
									
									<c:otherwise>	
										<li><a href="boardQnaList.bo?page=${pageInfo.page-1 }"> <i class="fa fa-angle-left"> &nbsp;&nbsp; </i> </a></li>
									</c:otherwise>
								</c:choose>
								
	
								<c:forEach var="a" begin="${pageInfo.startPage }" end="${pageInfo.endPage }" step="1">
									<c:choose>
										<c:when test="${a==pageInfo.page }"> 
											<li class="active"><a href="boardQnaList.bo?page=${a }">${a }</a></li> 
										</c:when>
									
										<c:otherwise>
											<li><a href="boardQnaList.bo?page=${a }">  ${a }  </a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
					
								<c:choose>
									<c:when test="${pageInfo.page>=pageInfo.maxPage }"> </c:when>
									
									<c:otherwise>	
										<li><a href="boardQnaList.bo?page=${pageInfo.page+1 }"> <i class="fa fa-angle-right">  </i> </a></li>
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
				<td colspan="5">등록된 글이 없습니다</td>
			</tr>
		</c:otherwise>
    </c:choose>
</table>
</body>
</html>