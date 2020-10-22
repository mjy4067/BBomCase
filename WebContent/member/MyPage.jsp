<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	.w3-container{
		width: 800px;
		align: center;
		margin: auto;
	}
	
	.simple_table {
    width: 100%;
    border: none;
    border-collapse: separate;
    border-spacing: 2px;
}
 
.simple_table th {
    padding: 15px;
    border: none;
    border-left: 5px solid #C03;
    border-bottom: 1px solid #DDD;
    background: #FCF0F3;
    font-weight: normal;
    text-align:center;
    text-shadow: 0 1px #FFF;
    vertical-align: middle;
}
 
.simple_table td {
    padding: 15px;
    border: none;
    border-bottom: 1px solid #DDD;
    text-align: left;
    vertical-align: baseline;
}
	form{
		width : 70%;
		margin : auto;
	}

</style>

	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

</head>
<body>

	 <h2 align="center">My Page</h2><p style="float: right; font-size: 12px; margin-right:100px;"><a href="goodsMainAction.go">홈</a> > 마이페이지</p>
	<hr><br>
	<form class="w3-container">
		
		<table class="simple_table">
		    <tbody>
		        <tr>
		        	<th >아이디</th>
		        	<td> ${memberInfoResult.mem_id} </td>
		        </tr>
		        <tr>
		            <th >비밀번호</th>
		            <td>${memberInfoResult.mem_pass }</td>
		        </tr>
		        <tr>
		            <th >이름</th>
		            <td>${memberInfoResult.mem_name }</td>
		        </tr>
		         <tr>
		            <th >생년월일</th>
		            <td>${memberInfoResult.mem_birth }</td>
		        </tr>
		         <tr>
		            <th >연락처</th>
		            <td>${memberInfoResult.mem_tel }</td>
		        </tr>
		         <tr>
		            <th >이메일</th>
		            <td>${memberInfoResult.mem_email }</td>
		        </tr>
		         <tr>
		            <th >주소</th>
		            <td>
		            	${memberInfoResult.zip_code }<br>
						${memberInfoResult.addr1 }<br>
						${memberInfoResult.addr2 }
					</td>
		        </tr>
		         <tr>
		            <th >등급</th>
		            <td>${memberInfoResult.mem_grade }</td>
		        </tr>
		         <tr>
		            <th >가입일자</th>
		            <td>${memberInfoResult.mem_date }</td>
		        </tr>
		     	<tr>
		     	<td colspan = "2">
      
        		<p class="w3-right"><button class="w3-button w3-black" type="button" onclick="location.href='memberMyDeleteAction.me'" id="myBtn"><b> 회원탈퇴 </b> </button></p>
        
        	 	<p class="w3-right"><button class="w3-button w3-black" type="button" onclick="location.href='memberMyModifyFormAction.me'" id="myBtn"><b>회원정보수정  </b> </button></p>
			
			</td>
		     	</tr>
		     	
		     	
		    </tbody>
			
		</table>
		
	
	</form>
	

</body>
</html>