<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
	}
	table.type10 thead th {
	    width: 150px;
	    padding: 10px;
	    font-weight: bold;
	    vertical-align: top;
	    color: #fff;
	    background: #D1B2FF;
	    margin: 20px 10px;
	}
	table.type10 tbody th {
	    width: 150px;
	    padding: 10px;
	}
	table.type10 td {
	    width: 350px;
	    padding: 10px;
	    vertical-align: top;
	}
	table.type10 .even {
	    background: #fdf3f5;
	}
	form{
		width : 70%;
		margin : auto;
	}	
</style>

</head>
<body>
	<h2 align="center">Notify List</h2>
	<p style="float: right; font-size: 12px; margin-right: 100px;"><a href="goodsMainAction.go">홈</a> > 공지사항</p>
	<hr><br>
	
	<form>
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
    		<c:forEach var="notifyList" items="${notifyList }">
    	
		<tbody>
			<tr>
		    	<th scope="row">${notifyList.no_id}</th>
		        <td>
					<a href="notifyViewAction.bo?no_id=${notifyList.no_id}&page=${pageInfo.page}">${notifyList.no_title }</a>
				</td>
				<td>${notifyList.mem_name }</td>
				<td>${notifyList.no_date }</td>
				<td>${notifyList.no_hits }</td>
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
										<li><a href="notifyListAction.bo?page=${pageInfo.page-1 }"> <i class="fa fa-angle-left"> &nbsp;&nbsp; </i> </a></li>
									</c:otherwise>
								</c:choose>
								
	
								<c:forEach var="a" begin="${pageInfo.startPage }" end="${pageInfo.endPage }" step="1">
									<c:choose>
										<c:when test="${a==pageInfo.page }"> 
											<li class="active"><a href="notifyListAction.bo?page=${a }">${a }</a></li> 
										</c:when>
									
										<c:otherwise>
											<li><a href="notifyListAction.bo?page=${a }">  ${a }  </a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
					
								<c:choose>
									<c:when test="${pageInfo.page>=pageInfo.maxPage }"> </c:when>
									
									<c:otherwise>	
										<li><a href="notifyListAction.bo?page=${pageInfo.page+1 }"> <i class="fa fa-angle-right">  </i> </a></li>
									</c:otherwise>
								</c:choose>
							
								</ul>
							</div>
						</div>
					</c:if>	
					<section id="commandCellp">	
						<br>
						<c:if test="${id == 'admin' }">
							<div class="ps-subscribe__form">
								<button type="button" onclick="location.href='notifyWrite.bo'">글쓰기</button>
							</div>
						</c:if>
						<br><br><br>			
					</section>
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
</form>

</body>
</html>












