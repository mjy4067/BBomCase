<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	table.type10 {
	    border-collapse: collapse;
	    text-align: left;
	    line-height: 1.5;
	    border-top: 1px solid #ccc;
	    border-bottom: 1px solid #ccc;
	    width: 1000px;
	    margin: auto;
	}
	table.type10 thead th {
	    width: 150px;
	    padding: 10px;
	    font-weight: bold;
	    vertical-align: top;
	    color: #fff;
	    background: #D1B2FF;
	    margin: 20px 10px;
	}
	table.type10 tbody th {
	    width: 150px;
	    padding: 10px;
	}
	table.type10 td {
	    width: 350px;
	    padding: 10px;
	    vertical-align: top;
	}
	table.type10 .even {
	    background: #fdf3f5;
	}
	h3{
		text-align:center;
	}
	
	.content{
		background-color: #EAEAEA;
	}
	td{
		text-align:center;
	}
	
	#sub{
		font-size:10px;
		color:#747474;
		align:right;
	}
	.w3-center{
		background-color: #E8D9FF;
	}
	.w3-container{
		background-color: #EAEAEA;
		font-size:30px;
	}
</style>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">	
<title>Insert title here</title>
</head>
<body>

	<h2 align="center">QnA</h2><p style="float: right; font-size: 12px; margin-right:100px;"><a href="goodsMainAction.go">홈</a> > <a href="boardQnaList.bo">상품문의</a> > ${Qna.title }</p>
	<hr><br>

	<form method="post">
	<table class="type10">
	    <thead>
		    <tr>
		        <th><h3>${Qna.title }</h3></th>
	    	</tr>
	   		<tr>
	     	   <th>상품 : ${Qna.goo_name }</th>
	   		</tr>
		    <tr>
		    	 <th>
		    	 	<span class="w3-opacity" id="sub">작성자 : ${Qna.mem_id } | 작성일 : ${Qna.date } |
		    	  	답변상태 :
		    	 	<c:choose>
						<c:when test="${Qna.reply != null}">
									답변완료
						</c:when>
						<c:otherwise>
									미답변
						</c:otherwise>
					</c:choose>
					</span>
				</th>
			</tr>
    	</thead>
    
    	<tbody class="content">
		    <tr>
		    	<td>
		    		<c:if test="${Qna.image != null }">
						<p><img src="images/${Qna.image }" style="width:80%"  /></p>
					</c:if>
		    	
		    	</td>
			</tr>
			<tr>
				<td>${Qna.content } </td>
			</tr>
			<tr>
				<td>					
					<p class="w3-left"><button class="w3-button w3-white w3-border" type="button" onclick="history.back();" ><b><i class="ps-icon-back"></i> 돌아가기</b></button></p>
						
					<c:if test="${id == 'admin' && Qna.reply == null}">
						<p class="w3-right"><input class="w3-button w3-black" type="submit" value="답변" formaction="boardQnaReplyForm.bo" id="myBtn"></p>
					</c:if>	
					<c:if test="${id == 'admin' || id == Qna.mem_id }">	 
	          			<input type="hidden" name="rev_id" value="${Review.id}">
	         		 	<p class="w3-right"><input class="w3-button w3-black" type="submit" value="삭제" formaction="boardQnaRemove.bo" id="myBtn" ></p>
	     		  	</c:if>
				</td>
			</tr>
		</tbody>
	
	<c:if test="${Qna.reply != null }">
		<thead>
			 <tr>
	     	   <th>
	     	   	    <h3>답변</h3>
	     	   </th>
	   		 </tr>
		</thead>
		<tbody class="content">
			<tr>
				<td>${Qna.reply } </td>
			</tr>
		</tbody>
	</c:if>
	</table>		
	</form>
<br><br><br>
</body>
</html>