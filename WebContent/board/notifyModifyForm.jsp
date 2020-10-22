<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function checkModify(m){
		var form = document.notifymodifyform;
		var title = m.no_title.value;
		var content = m.no_content.value;
		
		if(title.trim() == ""){
			alert("제목을 입력하세요");
			m.no_title.focus();
			return false;
		}
		if(content.trim() == ""){
			alert("내용을 입력하세요");
			m.no_content.focus();
			return false;
		}
	}

</script>

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
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
	<p style="float: right; font-size: 12px; margin-right: 100px;"><a href="goodsMainAction.go">홈</a> > <a href="notifyListAction.bo">공지사항</a> > <a href="notifyViewAction.bo?no_id=${notify.no_id}"> ${notify.no_title}</a> > 수정</p>
	<hr><br>
	
	<section id="FormArea">
		<form action="notifyModifyAction.bo?no_id=${notify.no_id}&page=${page } " class="w3-container w3-card-4 w3-light-grey w3-text-blue w3-margin"  method="post" enctype="multipart/form-data" name="notifywriteform" onsubmit="return checkModify(this)" >
	
			<div class="w3-row w3-section">
			  <div class="w3-col" style="width:50px"></div>
			    <div class="w3-rest">
			      <input class="w3-input w3-border" name="no_title" type="text" value="${notify.no_title }" placeholder="제목">
			    </div>
			</div>

			<div class="w3-row w3-section">
			  <div class="w3-col" style="width:50px"></div>
			    <div class="w3-rest">
			    	<textarea class="w3-input w3-border" name="no_content"  placeholder="내용"> ${notify.no_content }</textarea>
			    </div>
			</div>
	
			<div class="w3-row w3-section">
			  <div class="w3-col" style="width:50px"></div>
			    <div class="w3-rest">
			      <input class="w3-input w3-border" name="no_image" type="file" >
			      <input type="hidden" name="oldImage" value="${notify.no_image }">
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