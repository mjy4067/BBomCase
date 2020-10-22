<%@page import="vo.PageInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	PageInfo pageInfo = (PageInfo) request.getAttribute("q_pageInfo");
int listCount = pageInfo.getListCount();
int nowPage = pageInfo.getPage();
int maxPage = pageInfo.getMaxPage();
int startPage = pageInfo.getStartPage();
int endPage = pageInfo.getEndPage();
%>
<!DOCTYPE html>
<html>
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
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="margin-left:8.9%; width:82%;">
	<h3 align="center">QnA</h3>
	<hr><br>
	</div>
	<c:choose>
	<c:when test="${qnaList != null}">
	<button style="margin-left:82.5%; margin-bottom:10px;" type="button" id="wbutton" onclick="window.open('./board/QnaWriteForm.jsp?goo_id=${goods.goo_id}','','width=500, height=400')">문의하기</button>
	</c:when>
	<c:otherwise>
	<button style="margin-left:67%; margin-bottom:10px;" type="button" id="wbutton" onclick="window.open('./board/QnaWriteForm.jsp?goo_id=${goods.goo_id}','','width=500, height=400')">문의하기</button>
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
    	<c:when test="${q_pageInfo.listCount>0 }">
    		<c:forEach var="list" items="${qnaList }" varStatus="status">
		    	<tbody>
		    <tr>
		        <th scope="row">${status.index+1} <c:if test="${list.secret == 1}">&nbsp;<img src="./images/lock.png" style="width:15px;"></c:if></th>
		        <c:choose>
		        	<c:when test="${list.secret == 1}">
		        		<c:if test="${id == 'admin' || list.mem_id == id}">
		        			<td><a href="boardQnaView.bo?qna_id=${list.id}&page=${pageInfo.page}">${list.title} <c:if test="${list.reply != null}"> [1] </c:if></a></td>
		        		</c:if>
		        		<c:if test="${id != 'admin' && list.mem_id != id}">
		        		<td>숨김글입니다.</td>
		        		</c:if>
		        	</c:when>
		        	<c:otherwise>
		        		<td><a href="boardQnaView.bo?qna_id=${list.id}&page=${pageInfo.page}">${list.title} <c:if test="${list.reply != null}"> [1] </c:if></a></td>
		        	</c:otherwise>
		        </c:choose>
				<td>${list.mem_id}***</td>
				<td>${list.date}</td>
				<td>${list.hits}</td>
		    </tr>
		    </c:forEach>
		</tbody>
		</c:when>
    	<c:otherwise>
			<tr>
				<td colspan="5">상품문의가 없습니다.</td>
			</tr>
		</c:otherwise>
    </c:choose>
</table>
</body>
</html>