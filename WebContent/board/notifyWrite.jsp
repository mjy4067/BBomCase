z<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	

<script>
	function checkWrite(w){
		var form = document.notifywriteform;
		var title = w.no_title.value;
		var content = w.no_content.value;
		
		if(title.trim() == ""){
			alert("제목을 입력하세요");
			w.no_title.focus();
			return false;
		}
		if(content.trim() == ""){
			alert("내용을 입력하세요");
			w.no_content.focus();
			return false;
		}
	}

</script>

<style>
	#FormArea{
		margin : auto;
		border-radius : 10px;
		text-align : center;
	}
	form{
		display: inline-block;
		width:50%;
	}
	
	
</style>
</head>
<body>
	<h2 align="center">Notify</h2>
	<p style="float: right; font-size: 12px; margin-right:100px;"><a href="goodsMainAction.go">홈</a> > <a href="notifyListAction.bo">공지사항</a> > 글쓰기</p>
	<hr><br>
		
	<section id="FormArea">
		<form action="notifyWriteAction.bo" class="w3-container w3-card-4 w3-light-grey w3-text-blue w3-margin"  method="post" enctype="multipart/form-data" name="notifywriteform" onsubmit="return checkWrite(this)" >
	
			<div class="w3-row w3-section">
			  <div class="w3-col" style="width:50px"></div>
			    <div class="w3-rest">
			      <input class="w3-input w3-border" name="no_title" type="text" placeholder="제목">
			    </div>
			</div>
	
			<div class="w3-row w3-section">
			  <div class="w3-col" style="width:50px"></div>
			    <div class="w3-rest">
			    	<textarea class="w3-input w3-border" name="no_content" placeholder="내용"></textarea>
			    </div>
			</div>
	
			<div class="w3-row w3-section">
			  <div class="w3-col" style="width:50px"></div>
			    <div class="w3-rest">
			      <input class="w3-input w3-border" name="no_image" type="file" placeholder="파일">
			    </div>
			</div>
			
			<p class="w3-center">
				<button type="submit" onclick="checkWrite(w)" class="w3-button w3-section w3-blue w3-ripple">등록하기</button>
				<button type="button" onclick="history.back()" class="w3-button w3-section w3-blue w3-ripple">뒤로가기</button>
			</p>
		</form>
	</section>

</body>
</html>