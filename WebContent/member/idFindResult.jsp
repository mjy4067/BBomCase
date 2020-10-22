<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기 결과</title>
<style>
	#Result{
		margin : auto;
		width : 400px;
		height : 250px;
		border : 2px double red;
		border-radius : 10px;
		text-align: center;
	}

</style>
</head>
<body>
	<section id="Result">
		<div>
			<h2>${name }</h2>님의 아이디는 
			<h2>${idFindResult }</h2>입니다.
		</div>
		<p>
		<div>
			<button type="button" onclick="location.href='./memberLogin.me?idFind=${idFindResult }'">로그인</button>
			<button type="button" onclick="location.href='./memberPassFind.me?idFind=${idFindResult }'">비밀번호 찾기</button>
		</div>
		
	</section>
</body>
</html>