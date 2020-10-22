<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="vo.MemberBean" %>
<%@ page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
	#modify, #delete{
		width : 20%;
		display:inline-block;
	}
	
</style>

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-light-blue.css">

<script>

</script>
</head>
<body>
	<h2 align="center">Member List</h2>
	<p style="float: right; font-size: 12px; margin-right: 100px;"><a href="goodsMainAction.go">홈</a> > 회원관리</p>
	<hr><br>

	<form name="listForm" method="post">
		<table class="type10">
    		<thead>
			    <tr>
			        <th>아이디</th>
			        <th>회원이름</th>
			        <th>회원등급</th>
			        <th>가입일자</th>
			        <th>회원 정보</th>
			    </tr>
			</thead>
    
     <c:forEach var="member" items="${memberList }">
  
		    <tbody>
			    <tr>
			        <th>
			        	<a href="memberInfoAction.me?id=${member.mem_id }">${member.mem_id }</a>
			        </th>
			        <th>
			        	<a href="memberInfoAction.me?id=${member.mem_id }">${member.mem_name }</a>
			        </th>
					<th>
						<a href="memberInfoAction.me?id=${member.mem_id }">${member.mem_grade }</a>
					</th>
					<th>
						<a href="memberInfoAction.me?id=${member.mem_id }">${member.mem_date }</a>
					</th>
					<td>
						<p>
							<button class="w3-button w3-block w3-blue w3-section w3-padding" type="button" id="modify" onclick="location.href='memberModifyFormAction.me?id=${member.mem_id}'">수정</button>&nbsp; / &nbsp; 
							<button class="w3-button w3-block w3-red w3-section w3-padding" type="button" id="delete" onclick="location.href='memberDeleteAction.me?id=${member.mem_id}'">삭제</button> 
						</p>
					</td>
			    </tr>
	</c:forEach>
		   
			</tbody>

		</table>
	</form>

<br><br>

</body>
</html>