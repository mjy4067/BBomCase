<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
<script>
function checkRegist(c){
	var form = document.registform;

	var title = c.qna_title.value;
	if(title.trim() == ""){
		alert("제목을 입력하세요");
		c.qna_title.focus();
		return false;
	}
	
	var content = c.rev_content.value;
	if(content.trim() == ""){
		alert("내용을 입력하세요");
		c.qna_content.focus();
		return false;
	}
	function close(f){
		opener.location.reload();
		window.close();
	}
}
</script>
<body>
	<h3>상품문의</h3>
	<hr>
		<%
		int goo_id = Integer.parseInt(request.getParameter("goo_id"));
		pageContext.setAttribute("goo_id", goo_id);
		%>
		<form action="boardQnaWrite.bo" enctype="multipart/form-data" method="post">
			<table>
				<tr>
					<td>
						<label>제목</label>
					</td>
					<td>
						<input type="text" name="qna_title" id="qna_title">
					</td>
					<td>
						<label>숨김</label>&nbsp;
						<input type="checkbox" name="secret" id="secret" value="1">
					</td>
				</tr>
				<tr>
					<td>
						<label>내용</label>
					</td>
					<td colspan="2">
						<textarea name="qna_content" id="qna_content" cols="50" rows="10"></textarea>		
					</td>
				</tr>
				<tr>
					<td>
						<label>사진</label>
					</td>
					<td>
						<input type="file" name="qna_image" id="qna_image">
					</td>
				</tr>
				<tr>
					<td>
						<input type="hidden" name="goo_id" id="goo_id" value="${goo_id}">
						<input type="submit" value="등록">
						<button type="button" onclick="fclose(this)" id="wbutton">닫기</button>										
					</td>
				</tr>
			</table>
		</form>
</body>
</html>