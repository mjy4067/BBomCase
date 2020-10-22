<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function checkRegist(c){
		var form = document.registform;

		var title = c.qna_reply.value;
		if(title.trim() == ""){
			alert("답변을 입력하세요");
			c.qna_reply.focus();
			return false;
		}
	}
</script>
</head>
<body>
	<form name="registform" method="post" action="boardQnaReply.bo" onsubmit="return checkRegist(this)">
		<table>
			<tr>
				<td colspan="2">
					<label>작성일 ${Qna.date }</label>
				</td>
			</tr>
			<tr>
				<td>
					<c:if test="${Qna.image != null}"><img src="images/${Qna.image}"></c:if>
				</td>
				<td>
					<label>${Qna.goo_name }</label>
			<tr>
				<td>
					<label>제목</label>
				</td>
				<td>
					<label>${Qna.title }</label>
				</td>
			</tr>
			<tr>
				<td>
					<label>내용</label>
				</td>
				<td>
					<label>${Qna.content }</label>
				</td>
			</tr>
		</table>
	<hr>
	문의답변
	<hr>
		<table>
			<tr>
				<td>
					<textarea name="qna_reply" id="qna_reply" cols="50" rows="10"></textarea>		
				</td>
			</tr>
			<tr>
				<td>
					<input type="hidden" name="qna_id" value="${Qna.id}">
					<button type="button" onclick="history.back();">돌아가기</button>
					<input type="submit" value="등록">	
				</td>
			</tr>
		</table>
	</form>
</body>
</html>