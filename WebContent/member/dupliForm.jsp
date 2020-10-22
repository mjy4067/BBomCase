<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	request.setCharacterEncoding("utf-8");
	String openInit="false";
	if(request.getParameter("openInit")!=null){
		openInit = "true";
	}
	String id = request.getParameter("id");
	
	if(id==null){
		id="";
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 창</title>
<style>
	table{
		margin : auto;
	}
	div{
		text-align : center;
	}


</style>

<script>
	function joinform(){  // joinForm.jsp에서 값 가져오기
		 document.getElementById("id").value = opener.document.joinform.mem_id.value;   
    }

	function init(){
		if(<%=openInit%>){
			document.getElementById("id").value =
			opener.document.getElementById("mem_id").value;
		}
	}
	
	function use(u){
		opener.document.getElementById("mem_id").value = u;
		opener.chkId = true;
		window.close();
	}
	
	function chkForm(c){
		
		var id = c.id.value;
		var reg_id = /^[a-zA-Z0-9]*$/;
		
		if(c.id.value.trim()==""){
			alert("아이디를 입력하세요");
			c.id.focus();
			return false;
		}
		if(!reg_id.test(id)){
			alert("아이디는 영문자 또는 영문자 + 숫자 만 입력하세요");
			c.mem_id.focus();
			return false;
		}
		document.idCheck.submit();
	}
	

</script>


</head>
<body onload="joinform()"> <!-- 값 가져오기 적용 -->
	
	<form name = "idCheck" action ="memberIdTestAction.me" method="post" onsubmit="return chkForm(this)">
		<table>
			<tr>
				<td><input type="text" name="id" id="id" placeholder="중복체크 할 아이디"/></td>
				<td> <button type="submit">중복체크</button> </td>
			</tr>
		</table>
	</form>
	
	<div>
		<c:if test="${idTestresult != null }">
			<c:choose>
				<c:when test="${idTestresult == 'true' }">
					<h2>${id}</h2> 사용가능한 아이디 입니다. 
					<h4><a href="#" onclick="use('${id}')">사용하기</a></h4>
				</c:when>
				<c:otherwise>
					중복된 아이디
				</c:otherwise>
			</c:choose>
		</c:if>
	
	</div>
</body>
</html>