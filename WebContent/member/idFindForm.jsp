<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<style>






.w3-container{
		width: 400px;
		align: center;
		margin: auto;
	}
	#telArea{
		width : 70px;
		display:inline-block;
	}
	#mem_tel{
		width : 80px;
		display:inline-block;
	}
	#mem_email{
		width : 110px;
		display:inline-block;
	}
	#emailArea{
		width : 150px;
		display:inline-block;
	}
	#login{
		width : 180px;
		display:inline-block;
	}
	#password{
		width : 180px;
		display:inline-block;
	}





</style>


	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-light-blue.css">



<script>
	function inputEmail(ie) {
		var choiceText = ie.options[ie.selectedIndex].text;

		if(choiceText == '직접입력'){
			document.getElementById("emailform").innerHTML="<input type='text' name='emailArea' id='emailArea'/>";
		}	
	}
	
	function inputCheck(i){
		var name = i.mem_name.value;
		
		if(name.trim() == ""){
			alert("이름을 입력하세요");	
			i.mem_name.focus();
			return false;
		}
		
		
		var tel1 = i.mem_tel1.value;
		var tel2 = i.mem_tel2.value;
		var form = document.findform;
		
		if(tel1.trim() == ""){
			alert("전화번호를 입력하세요");
			i.mem_tel1.focus();
			return false;
		}
		if(isNaN(form.mem_tel1.value)){
			alert("숫자만 입력하세요");
			i.mem_tel1.focus();
			return false;
		}
		if(tel2.trim() == ""){
			alert("전화번호를 입력하세요");
			i.mem_tel2.focus();
			return false;
		}
		if(isNaN(form.mem_tel2.value)){
			alert("숫자만 입력하세요");
			i.mem_tel2.focus();
			return false;
		}
		
		var email = i.mem_email.value;
		var emailArea = i.emailArea.value;
		var reg_email = /^[a-zA-Z0-9]*$/;
		var reg_emailArea = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])+$/i;
		
		if(email.trim() == ""){
			alert("이메일을 입력하세요");
			i.mem_email.focus();
			return false;
		}
		if(!reg_email.test(email)){
			alert("영문자 또는 영문자 + 숫자 만 입력하세요");
			i.mem_email.focus();
			return false;
		}
		if(emailArea.trim() == ""){
			alert("이메일 주소를 입력하세요");
			i.emailArea.focus();
			return false;
		}
		if(!reg_emailArea.test(emailArea)){
			alert("이메일 주소를 올바르게 입력하세요");
			i.emailArea.focus();
			return false;
		}
	}

</script>
</head>
<body>

	<div class="w3-container">
		<a href="goodsMainAction.go"><img src="./images/logo.jpg"></a>
	 	<form class="w3-container" name="findform" action="memberIdFindAction.me" method="post" onsubmit="return inputCheck(this)">
	 		<label for="mem_name"><b>이름</b></label>
         	<input class="w3-input w3-border w3-margin-bottom" type="text" placeholder="이름" name="mem_name" id="mem_name" >

	 		<p>
         		<label for="mem_tel"><b>연락처</b></label>
        	</p>
        	
        	<p>
	          	<select class="w3-input w3-border w3-margin-bottom" name="telArea" id="telArea" style="width:110px;">
								<option value="010">010</option>
								<option value="011">011</option>
								<option value="016">016</option>
								<option value="018">018</option>
				</select> -
				<input class="w3-input w3-border w3-margin-bottom" type="text" name="mem_tel1" id="mem_tel" maxlength="4" style="width:110px;"> -
	            <input class="w3-input w3-border w3-margin-bottom" type="text" name="mem_tel2" id="mem_tel" maxlength="4" style="width:110px;">
          	</p>     
	 		
	 		<p>      
            	<label for="mem_email"><b>이메일</b></label>
      		</p>
      		
      		<p>
	      		<input class="w3-input w3-border w3-margin-bottom" type="text" name="mem_email" id="mem_email" style="width:170px;"> @
	      		
	      		<span id="emailform">
		      		<select class="w3-input w3-border w3-margin-bottom" name="emailArea" id="emailArea" onchange="inputEmail(this)" style="width:170px;">
										<option value="gmail.com">gmail.com</option>
										<option value="naver.com">naver.com</option>
										<option value="daum.net">daum.net</option>
										<option value="null">직접입력</option>
					</select>
	       		</span>
			</p>
	
	 		<button class="w3-button w3-block w3-theme-l3 w3-section w3-padding" type="submit">아이디 찾기</button>
	 		<button class="w3-button w3-block w3-theme-l3 w3-section w3-padding" type="button" id="login" onclick="location.href='memberLogin.me'">로그인</button>
	 		<button class="w3-button w3-block w3-theme-l3 w3-section w3-padding" type="button" id="password" onclick="location.href='memberPassFind.me'">비밀번호 찾기</button>

		</form>

	</div>

</body>
</html>