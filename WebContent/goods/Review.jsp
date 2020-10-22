<%@page import="vo.PageInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	PageInfo pageInfo = (PageInfo) request.getAttribute("r_pageInfo");
int listCount = pageInfo.getListCount();
int nowPage = pageInfo.getPage();
int maxPage = pageInfo.getMaxPage();
int startPage = pageInfo.getStartPage();
int endPage = pageInfo.getEndPage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="margin-left:8.9%; width:82%;">
	<h3 align="center">Review</h3>
	<hr><br>
	</div>
	<c:choose>
	<c:when test="${reviewList != null}">
	<button style="margin-left:82.5%; margin-bottom:10px;" type="button" id="wbutton" onclick="window.open('./board/ReviewWriteForm.jsp?goo_id=${goods.goo_id}','','width=500, height=400')">문의하기</button>
	</c:when>
	<c:otherwise>
	<button style="margin-left:67%; margin-bottom:10px;" type="button" id="wbutton" onclick="window.open('./board/ReviewWriteForm.jsp?goo_id=${goods.goo_id}','','width=500, height=400')">문의하기</button>
	</c:otherwise>
	</c:choose>
	<table class="type10">
    <thead>
    <tr>
        <th scope="cols">번호</th>
        <th scope="cols">제목</th>
        <th scope="cols">작성자</th>
        <th scope="cols">날짜</th>
        <th scope="cols">조회수</th>
    </tr>
    </thead>
    
       <c:choose>
    	<c:when test="${r_pageInfo.listCount>0 }">
    		<c:forEach var="list" items="${reviewList }" varStatus="status">
		    	<tbody>
		    <tr>
		        <th scope="row">${status.index+1}</th>
		        <td><a href="boardReviewView.bo?review_id=${list.id}&page=${pageInfo.page}">${list.title} <c:if test="${list.reply != null}"> [1] </c:if></a></td>
				<td>${list.mem_id}***</td>
				<td>${list.date}</td>
				<td>${list.hits}</td>
		    </tr>
		    </c:forEach>
		</tbody>
		</c:when>
    	<c:otherwise>
			<tr>
				<td colspan="5">상품후기가 없습니다.</td>
			</tr>
		</c:otherwise>
    </c:choose>
</table><br><br><br>
</body>
</html>