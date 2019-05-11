<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<h1>정규표현식을 활용한 유효성 검사</h1>

<script type="text/javascript">
                             // ^시작문자 *반복 $마지막문자
	function checkReg(){
		var regId =/^[a-z|A-Z]/;//대소문자 a~z까지만 허용
		var regName=/^[가-힣]/; //모든한글만 허용
		var regAge=/^[0-9]*$/;//숫자만 허용
		var regPhone=/^\d{3}-\d{3,4}-\d{4}$/;  //숫자3개, 숫자3~4개 , 숫자4개
		
		var my = document.my;
		if(!regId.test(my.id.value)){
			alert("대소문자 a~z까지만 가능합니다  ");
		}
		if(!regName.test(my.name.value)){
			alert("이름은 한글만 가능합니다");
		}
		if(!regAge.test(my.age.value)){
			alert("나이는 숫자만 가능합니다");
		}
		if(!regPhone.test(my.phone.value)){
			alert("000-0000-0000형식으로 입력하세요");
		}
	}

	
</script>

<form name ="my" action ="#">
	id : <input type ="text" name="id" required/><br/>
	pw :<input type="password" name="pw"required/><br/>
	name :<input type="text" name="name"required/><br/>
	age :<input type="text" name="age"required/><br/>
	phone :<input type="text" name="phone"required/><br/>
		<input type="button" value="전송" onclick="checkReg()"required/><br/>
	



</form>