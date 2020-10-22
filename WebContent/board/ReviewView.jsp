<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

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

</head>
<body>

	<h2 align="center">Review </h2><p style="float: right; font-size: 12px; margin-right:100px;"><a href="goodsMainAction.go">홈</a> > <a href="boardReviewList.bo">상품후기</a> > ${Review.title }</p>
	<hr><br>
	


	<form method="post">
	<table class="type10">
	    <thead>
		    <tr>
		        <th><h3>${Review.title }</h3></th>
		    </tr>
			<tr>
		        <th>상품 : ${Review.goo_name }</th>
		    </tr>
		    <tr>
		    	 <th><span class="w3-opacity" id="sub">작성자 : ${Review.mem_id } | 작성일 : ${Review.date } </span></th>
		    </tr>
	    </thead>
	    
	    <tbody class="content">
		    <tr>
		    	<td>
		    		<c:if test="${Review.image != null }">
						<p><img src="images/${Review.image }" style="width:80%"  /></p>
					</c:if>
		    	</td>
			</tr>
			<tr>
				<td>${Review.content } </td>
			</tr>
			<tr>
				<td>					
					<p class="w3-left"><button class="w3-button w3-white w3-border" type="button" onclick="history.back();" ><b><i class="ps-icon-back"></i> 돌아가기</b></button></p>
						
					 <c:if test="${id == 'admin' || id == Review.mem_id }">
					 
	          			<input type="hidden" name="rev_id" value="${Review.id}">
	         		 	<p class="w3-right"><input class="w3-button w3-black" type="submit" value="삭제" formaction="boardReviewRemove.bo" id="myBtn" ></p>
	     		  	 </c:if>

				</td>
			</tr>
		</tbody>
	</table>		
	</form>
<br><br><br>
</body>
</html>