<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function goto_url(act) {
		document.ad_view.action = encodeURI(act);
		document.ad_view.submit();

	}
	function remove(id, page){
		 var flag = confirm('삭제하시겠습니까??');
		 if(flag){
			 document.centerview.action = "centerDeleteAction.bo?cc_id="+id+"&page="+page ;
			 document.centerview.submit();
		 }
	 }
	

</script>

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
#sub{
	font-size:10px;
	color:#747474;
	align:right;
}
#FormArea{
	margin : auto;
	border-radius : 10px;
	text-align : center;
}
form{
	
	width:50%;
	margin : auto;
}

</style>

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	

</head>
<body>


<body >

	<h2 align="center">Customer Service</h2><p style="float: right; font-size: 12px; margin-right:100px;"><a href="goodsMainAction.go">홈</a> > <a href="centerListAction.bo">고객센터</a> > ${center.cc_title }</p>
	<hr><br>
	
	<form name="centerview" method="post">
	<table class="type10">
    	<thead>
    		<tr>
      			<th><h3>${center.cc_title }</h3></th>
    		</tr>
    		<tr>
    	 		<th>
    	 			<span class="w3-opacity" id="sub">작성자 : ${center.mem_id } | 작성일 : ${center.cc_date } |
    	 			답변상태 :
    	 			<c:choose>
						<c:when test="${center.has_re == 1 }">
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
		    		<c:if test="${center.cc_image != null }">
						<p><img src="images/${center.cc_image }" style="width:80%"  /></p>
					</c:if>
		    	
		    	</td>
			</tr>
			<tr>
				<td>${center.cc_content } </td>
			</tr>
			<tr>
				<td>
					<p class="w3-left"><button class="w3-button w3-white w3-border" type="button" onclick="history.back();" ><b><i class="ps-icon-back"></i>돌아가기</b></button></p>
				
					 <c:if test="${id == 'admin' }">
	         		 	<p class="w3-right"><button class="w3-button w3-black" type="button" onclick="remove('${center.cc_id}', '${page }')"><b> 삭제 </b> </button></p>
	     		  	 </c:if>
				</td>
			</tr>
		</tbody>
		
		<c:if test="${center.has_re == 1 }">
		<thead>
			<tr>
	        	<th><h3>답변</h3></th>
	   		</tr>
			<tr>
	    		<th><span class="w3-opacity" id="sub">작성자 ${centerReply.mem_id }| 작성일${centerReply.cc_date } </span></th>
	    	</tr>
		</thead>
	
		<tbody class="content">
			<tr>
				<td>${centerReply.cc_content } </td>
			</tr>
		</tbody>
		
		</c:if>
	</table>	
	</form>

	<c:if test="${center.has_re == 0 && id == 'admin' }">
	<br><br><br>
	
		
			<form class="w3-container w3-card-4 w3-light-grey w3-text-blue" name="ad_view"  method="post" >
				<h2 class="w3-center">답변</h2>
	
				<div class="w3-row w3-section">
					<div class="w3-col" style="width:50px"></div>
	    			<div class="w3-rest">
	    				<textarea class="w3-input w3-border" name="cc_content"> </textarea>
	    			</div>
				</div>
	
				<p class="w3-center">
					<button type="button" onclick="goto_url('centerReplyAction.bo?cc_id=${center.cc_id}&page=${page }')" class="w3-button w3-section w3-blue w3-ripple">답변하기</button>
				</p>
	
			</form>
		
	
	</c:if>
<br><br><br>
</body>
</html>