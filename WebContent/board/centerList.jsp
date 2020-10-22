<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
	function viewmycs(){
		if(document.getElementById("my").checked){
			location.href="centerListAction.bo?std=my";
		}else{
			location.href="centerListAction.bo";
		}
	}
	
	function viewnonreply(){
		if(document.getElementById("nonreply").checked){
			location.href="centerListAction.bo?std=reply";
		}else{
			location.href="centerListAction.bo";
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
<%
	String id = (String) session.getAttribute("id");
%>
	<h2 align="center">Customer Service List</h2>
	<p style="float: right; font-size: 12px; margin-right: 100px;"><a href="goodsMainAction.go">홈</a> > 고객센터</p>
	<hr><br>
	
	<form>
	<table class="type10">
		<thead>
			<tr>
				<th>번호</th>
		        <th>제목</th>
		        <th>작성자</th>
		        <th>날짜</th>
		        <th>답변</th>
		        
			</tr>
		</thead>

		<c:choose>
			<c:when test="${pageInfo.listCount>0 }">	
				<c:set var="num" value="${pageInfo.listCount-(pageInfo.page-1)*10 }"/>
				<c:forEach var="center" items="${centerList }">
		<tbody>	
			<tr>
				<th scope="row">
					${num} 
					
					<c:if test="${center.cc_secret == 'hide'}">&nbsp; <img src="./images/lock.png"> </c:if>	
				</th>		
						<c:set var="num" value="${num-1 }"/>
				<td>
					<c:choose>
						<c:when test="${center.cc_secret == 'hide'}">
						
							<c:if test="${id == 'admin' || center.mem_id == id}">
								<a href="centerViewAction.bo?cc_id=${center.cc_id }&page=${pageInfo.page}">${center.cc_title }</a>
							</c:if>
							<c:if test="${id != 'admin' && center.mem_id != id}">
							숨김글입니다.
							</c:if>
						</c:when>
						<c:otherwise>
							<a href="centerViewAction.bo?cc_id=${center.cc_id }&page=${pageInfo.page}">${center.cc_title }</a>
						</c:otherwise>
					</c:choose>
				</td>
				<td> ${center.mem_id }</td>
				<td> ${center.cc_date }</td>
	
				<td>
						<c:if test="${center.has_re == 1 }"> 답변완료 </c:if>	
				</td>
			</tr>
				</c:forEach>
				
				
			<tr>
				<td colspan="6">
					<c:if test="${pageInfo.page>=1 }">
					
					<div class="mt-30">
						<div class="ps-pagination">
							<ul class="pagination">
									
							<c:choose>
								<c:when test="${pageInfo.page<=pageInfo.startPage }"> </c:when>
									
								<c:otherwise>	
									<li><a href="centerListAction.bo?page=${pageInfo.page-1 }<c:out value="${std !=null ? '&std=':'' }"/>${std}"> <i class="fa fa-angle-left"> </i> </a></li>
								</c:otherwise>
							</c:choose>
				
							<c:forEach var="a" begin="${pageInfo.startPage }" end="${pageInfo.endPage }" step="1">
								<c:choose>
									<c:when test="${a==pageInfo.page }"> 
										<li class="active"><a href="centerListAction.bo?page=${a }<c:out value="${std !=null ? '&std=':'' }"/>${std}">${a }</a></li>
									</c:when>
										
									<c:otherwise>
								 		<li><a href="centerListAction.bo?page=${a}<c:out value="${std !=null ? '&std=':'' }"/>${std} "> ${a } </a> </li>
									</c:otherwise>
								</c:choose>	
							</c:forEach>
								
							<c:choose>
								<c:when test="${pageInfo.page>=pageInfo.maxPage }"> </c:when>
								
								<c:otherwise>
									<li><a href="centerListAction.bo?page=${pageInfo.page+1}<c:out value="${std !=null ? '&std=':'' }"/>${std} "> <i class="fa fa-angle-right"> </i> </a></li>
								</c:otherwise>
							</c:choose>
				
				
							</ul>
						</div>
					</div>
					<div align="right">
						<c:choose>
							<c:when test="${id eq 'admin' }">
								<span id="pcheck">&nbsp;<input type="checkbox" id="nonreply" name="nonreply" onchange="viewnonreply()" <c:out value="${std == 'reply' ? 'checked' : '' }"/>> <label for="nonreply">미답변글 보기</label>&nbsp;</span>
							</c:when>
							<c:when test="${id != null }">
								<span id="pcheck" style="text-align:right;">&nbsp;<input type="checkbox" id="my" name="my" style="text-align:right;" onchange="viewmycs()" <c:out value="${std == 'my' ? 'checked' : '' }"/>> <label for="my" style="text-align:right;">내가 쓴 글 보기</label>&nbsp;</span>
							</c:when>
						</c:choose>
						
						<section>
							<br>
							<div class="ps-subscribe__form">
								<button type="button" onclick="location.href='centerWrite.bo'"> 글쓰기 </button>
							</div>
							<br><br><br>
						</section>
					</div>

					</c:if>			
				</td>	
		
			</tr>
		</tbody>
			</c:when>	
			
			<c:otherwise>
				<tr>
					<td colspan="6">등록된 글이 없습니다.</td>
				</tr>
			</c:otherwise>
		</c:choose>

	</table>
	</form>
	
</body>
</html>