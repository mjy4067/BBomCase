<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기 결과</title>
<style>
	#Result{
		margin : auto;
		width : 400px;
		height : 350px;
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
			<h2>${id }</h2>이고
			비밀번호는
			<h2>${pwFindResult }</h2>입니다.
		</div>
		<p>	
		<div>
			<button type="button" onclick="location.href='./memberLogin.me?idFind=${id }'">로그인</button>
		</div>
	</section>
</body>
</html>