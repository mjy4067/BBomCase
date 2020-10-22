<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<style>
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
	#zip_code{
		width : 90px;
		display:inline-block;
	}
	#zip{
		width: 90px;
		display:inline-block;
	}
	.w3-container{
	width: 400px;
	align: center;
	margin: auto;
}
h2{
	text-align: center;
}

.idCheck{
	width:40px;
}
</style>

<script>
	var chkId=false;

	function inputEmail(ie){
		var choiceText = ie.options[ie.selectedIndex].text;
		
		if(choiceText == '직접입력'){
			document.getElementById("emailform").innerHTML="<td><input type='text' name='emailArea' id='emailArea'/></td>";
		}
	}
	
	function checkMember(c) {    	
		var form=document.joinform;
		
//아이디
		var id=c.mem_id.value;
		var reg_id = /^[a-zA-Z0-9]*$/;
		
		if(id.trim() == ""){
			alert("아이디를 입력하세요");
			c.mem_id.focus();
			return false;
		}	
		if(!chkId){
			alert("아이디 중복체크를 하세요");  //나중에 중복 수정 
			return false;
		}
		if(!reg_id.test(id)){
			alert("아이디는 영문자 또는 영문자 + 숫자 만 입력하세요");
			c.mem_id.focus();
			return false;
		}
		
		
//비밀번호
		var pass=c.mem_pass.value;
	
		if(pass.trim() == ""){
			alert("패스워드를 입력하세요");
			c.mem_pass.focus();
			return false;
		}
		if(c.mem_pass.value.length < 4){
			alert("패스워드는 4자리 이상 입력하세요");
			c.mem_pass.focus();
			return false;
		}
		
//이름
		var name=c.mem_name.value;
	
		if(name.trim() == ""){
			alert("이름을 입력하세요");
			c.mem_name.focus();
			return false;
		}
		
//생년월일		
		var birth=c.mem_birth.value;

		if(birth.trim() == ""){
			alert("생년월일을 입력하세요");
			c.mem_birth.focus();
			return false;
		}
		
//연락처		
		var tel1=c.mem_tel1.value;
		var tel2=c.mem_tel2.value;
		var reg_tel = /^[0-9]{10,11}$/;
		
		if(tel1.trim() == ""){
			alert("연락처를 입력하세요");
			c.mem_tel1.focus();
			return false;
		}
		if(isNaN(form.mem_tel1.value)){
			alert("숫자만 입력하세요");
			c.mem_tel1.focus();
			return false;
		}
		if(tel2.trim() == ""){
			alert("연락처를 입력하세요");
			c.mem_tel2.focus();
			return false;
		}
		if(isNaN(form.mem_tel2.value)){
			alert("숫자만 입력하세요");
			c.mem_tel2.focus();
			return false;
		}
			
//이메일		
		var email=c.mem_email.value;
		var emailArea=c.emailArea.value;
		var reg_email = /^[a-zA-Z0-9]*$/;
		var reg_emailArea = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])+$/i;
		
		if(email.trim() == ""){
			alert("이메일을 입력하세요");
			c.mem_email.focus();
			return false;
		}
		if(!reg_email.test(email)){
			alert("영문자 또는 영문자 + 숫자 만 입력하세요");
			c.mem_email.focus();
			return false;
		}
		if(emailArea.trim() == ""){
			alert("이메일을 주소를 입력하세요");
			c.emailArea.focus();
			return false;
		}
		
		if(!reg_emailArea.test(emailArea)){
			alert("이메일주소를 올바르게 입력하세요");
			c.emailArea.focus();
			return false;
		}
		
//주소
		var zip=c.zip_code.value;
		var addr1=c.addr1.value;
		var addr2=c.addr2.valud;
		
		if(zip.trim() == ""){
			alert("우편번호를 입력하세요");
			c.zip_code.focus();
			return false;
		}
		
		if(addr1.trim() == ""){
			alert("주소를 입력하세요");
			c.addr1.focus();
			return false;
		}
		if(addr2.trim() == ""){
			alert("상세주소를 입력하세요");
			c.addr2.focus();
			return false;
		} 
		
	}

	
	
</script>

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-light-blue.css">

</head>
<body>

<div class="w3-container">

	<a href="goodsMainAction.go"><img src="./images/logo.jpg"></a>
      <form class="w3-container" action="memberJoinAction.me" method="post" name="joinform" onsubmit="return checkMember(this)">
        <div class="w3-section">
          <label for="mem_id"><b>아이디</b></label>
          <input class="w3-input w3-border w3-margin-bottom" type="text" placeholder="중복검사를 누르시오"  name="mem_id" id="mem_id" readonly>
          <button class="w3-button w3-block w3-theme-l3 w3-section w3-padding" type="button" name="idCheck" id="idCheck" onclick="window.open('dupliForm.me?openInit=true','','width=500, height=300')" >중복검사</button>
          
          
   
          <label for="mem_pass"><b>비밀번호</b></label>
          <input class="w3-input w3-border w3-margin-bottom" type="password" placeholder="4자리 이상" name="mem_pass" id="mem_pass" >
   
   
          
          <label for="mem_name"><b>이름</b></label>
          <input class="w3-input w3-border w3-margin-bottom" type="text" placeholder="이름" name="mem_name" id="mem_name" >
          
          
          
          
          <label for="mem_birth"><b>생년월일</b></label>
          <input class="w3-input w3-border w3-margin-bottom" type="date" name="mem_birth" id="mem_birth">
  
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
 
       		<p>
            <label for="addr"><b>주소</b></label>
 			</p>
 			<p>
 			<input class="w3-input w3-border w3-margin-bottom" type="text" name="zip_code" id="zip_code" placeholder="우편번호" style="width:270px;">          
			<button class="w3-button w3-block w3-green w3-section w3-padding" type="button" id="zip" onclick="sample6_execDaumPostcode()">주소검색</button>                 
 			</p>
 			<input class="w3-input w3-border w3-margin-bottom" type="text" name="addr1" id="addr1" placeholder="주소">  
 
			<input class="w3-input w3-border w3-margin-bottom" type="text" name="addr2" id="addr2" placeholder="상세주소">  
            <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
						<script>
						    function sample6_execDaumPostcode() {
						        new daum.Postcode({
						            oncomplete: function(data) {
						                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
						
						                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
						                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						                var fullAddr = ''; // 최종 주소 변수
						                var extraAddr = ''; // 조합형 주소 변수
						
						                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
						                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
						                    fullAddr = data.roadAddress;
						
						                } else { // 사용자가 지번 주소를 선택했을 경우(J)
						                    fullAddr = data.jibunAddress;
						                }
						
						                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
						                if(data.userSelectedType === 'R'){
						                    //법정동명이 있을 경우 추가한다.
						                    if(data.bname !== ''){
						                        extraAddr += data.bname;
						                    }
						                    // 건물명이 있을 경우 추가한다.
						                    if(data.buildingName !== ''){
						                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
						                    }
						                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
						                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
						                }
						                // 우편번호와 주소 정보를 해당 필드에 넣는다.
						                document.getElementById('zip_code').value = data.zonecode; //5자리 새우편번호 사용
						                document.getElementById('addr1').value = fullAddr;
			
						                // 커서를 상세주소 필드로 이동한다.
						                document.getElementById('addr2').focus();
						            }
						        }).open();
						    }
						</script>	     
  
           				<button class="w3-button w3-block w3-theme-l3 w3-section w3-padding" type="submit"  onclick="checkMember(c)">회원가입</button>
 						<button class="w3-button w3-block w3-green w3-section w3-padding" type="button" onclick="history.back()">뒤로가기</button>

        </div>
      </form>

  </div>


</body>
</html>





