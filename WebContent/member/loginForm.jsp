<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String idFind = request.getParameter("idFind")==null ? "" : request.getParameter("idFind");
%>    
<c:set var="idFind" scope="request" value="<%=idFind %>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style>
.w3-container{
	width: 400px;
	align: center;
	margin: auto;
}
h2{
	text-align: center;
}
</style>
<script>
	function chkLogin(c){
		
		if(c.mem_id.value.trim() == ""){
			alert("아이디를 입력하세요.");
			c.mem_id.focus();
			return false;
		}
		if(c.mem_pass.value.trim() == ""){
			alert("비밀번호를 입력하세요.");
			c.mem_pass.focus();
			return false;
		}
		
		
	}



</script>

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-light-blue.css">

</head>
<body>
	
	
<div class="w3-container">
  		<a href="goodsMainAction.go"><img src="./images/logo.jpg"></a>

      <form class="w3-container" action="memberLoginAction.me" method="post" name="loginform" onsubmit="return chkLogin(this)">
        <div class="w3-section">
          <label><b>아이디</b></label>
          <input class="w3-input w3-border w3-margin-bottom" type="text" placeholder="ID" name="mem_id" id="mem_id" value="${idFind }" required>
         
          <label><b>비밀번호</b></label>
          <input class="w3-input w3-border" type="password" placeholder="PASSWORD" name="mem_pass" id="mem_pass" required>
          
          <button class="w3-button w3-block w3-green w3-section w3-padding" type="submit">로그인</button>
          
          <button class="w3-button w3-block w3-theme-l3 w3-section w3-padding" type="button" onclick="location.href='memberJoin.me'">회원가입</button>          
        </div>
      </form>
	
      <div class="w3-container w3-border-top w3-padding-16 w3-light-grey">
        <button onclick="history.back()" type="button" class="w3-button w3-red">뒤로가기</button>
        
        <span class="w3-right w3-padding w3-hide-small"><a href="memberPassFind.me">비밀번호찾기</a></span>
        <span class="w3-right w3-padding w3-hide-small"><a href="memberIdFind.me">아이디찾기</a></span>
      </div>

    </div>
	
</body>
</html>