<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
<jsp:include page="menu.jsp" /><br/>
<script type="text/javascript">
	
	function checkReg(){
		var member = document.member;
		var regPhone=/^\d{3}-\d{3,4}-\d{4}$/;
		var regId1 =/^[a-z]+[a-z0-9]{5,12}$/g;
	
		//var regId2= /^[0-9]*$/;

		
		var regPw = member.pw.value;
		var regPwcheck = member.pwcheck.value;
		
		
		if(!regPhone.test(member.phone.value)){
			alert("000-0000-0000형식으로 입력하세요");
			member.phone.focus();
			return false;
			}
		if(!regId1.test(member.id.value)){
			alert("영어,숫자 조합으로 4~12자로 입력하세요!  ");
			member.id.focus();
			return false;
			}
		else if(regId1.test(member.id.value.length<4)||regId1.test(member.id.value.length>13)){
			alert("4~12자 까지 입력하세요 ");
			member.id.focus();
			return false;
			}
		
		
		if(regPw!=regPwcheck){
			alert("비밀번호를 다시 입력하세요");
			member.pwcheck.focus();
			return false;
			}
	
		
		}
	


</script>

<form  action ="register_process.jsp" name="member" method ="post" align ="center" >

 <table border ="0"  width ="550" align ="center" >
	<tr height ="80" bgcolor ="333F48">
		<th colspan ="3"><font color ="white">회원가입</font></th>
	</tr> 



	<tr height ="50">
		<th >이름</th>
		<th><input type ="text" autofocus name="name"required/></th>
	</tr> 

	<tr height ="50">
		<th>이메일</th>
		<th><input type ="text" placeholder = "admin@seoul.co.kr"
		name ="email" required/></th>
	</tr> 

	<tr height ="50">
		<th>전화번호</th>
		<th><input type ="text" 
		placeholder = "000-0000-0000" name ="phone" required/></th>
		
	</tr> 

	<tr height ="50">
		<th>아이디</th>
		<th><input type ="text" name = "id" required/>
		<th><input type ="button" value ="중복확인"/></th>
		
	</tr> 

	<tr height ="50">
		<th>비밀번호</th>
		<th><input type ="password" name ="pw" required/></th>
	</tr>
	<tr height ="50">
		<th>비밀번호 확인</th>
		<th><input type ="password" name ="pwcheck" required /></th>
	</tr>  


</table>

<br/>
<input type ="submit" value ="Sign Up" onclick = " return checkReg()"/>
<input type ="reset" value ="Cancel"/><br/>

</form>

</body>
</html>