<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function checkRegist(c){
		var form = document.registform;

		var title = c.rev_title.value;
		if(title.trim() == ""){
			alert("제목을 입력하세요");
			c.rev_title.focus();
			return false;
		}
		
		var content = c.rev_content.value;
		if(content.trim() == ""){
			alert("내용을 입력하세요");
			c.rev_content.focus();
			return false;
		}
		function close(f){
			opener.location.reload();
			window.close();
		}
	}
</script>
</head>
<body>
	<h3>상품후기 등록</h3>
	<hr>
	<%
	int goo_id = Integer.parseInt(request.getParameter("goo_id"));
	pageContext.setAttribute("goo_id", goo_id);
	%>
		<form action="boardReviewWrite.bo" method="post" name="registform" enctype="multipart/form-data" onsubmit="return checkRegist(this)">
			<table>
				<tr>
					<td>
						<label>제목</label>
					</td>
					<td>
						<input type="text" name="rev_title" id="rev_title">
					</td>
				</tr>
				<tr>
					<td>
						<label>내용</label>
					</td>
					<td colspan="2">
						<textarea name="rev_content" id="rev_content" cols="50" rows="10"></textarea>		
					</td>
				</tr>
				<tr>
					<td>
						<label>사진</label>
					</td>
					<td>
						<input type="file" name="rev_image" id="rev_image">
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