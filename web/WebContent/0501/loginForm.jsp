<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<h1>loginForm 유효성 검사</h1>
<html>
<script type ="text/javascript">

	function checkForm(){
		form = document.form;
		}
		if(form.id.value.length < 4 || form.id.value.length >12){
			alert("아이디는 4~12자 이내로 입력가능합니다");
			form.id.focus();
			return;
		}
		
		if(form.pw.value.length < 4){
			alert("비밀번호는 4자 이상");
			form.pw.select();
			return;
			
		}
		
		form.submit("loginPro.jsp");
		}
		
	
	

</script>
<!-- Id/Pw중 하나라도 입력 안되면 이동금지  -->
<!-- 아이디를 4~12 이내로 입력가능 -->
<!-- 비밀번호 4글자 이상 -->
<body>
<form name ="form" action = "loginPro.jsp" method="post"  >
	id :<input type="text" name="id"/><br/>
	pw :<input type="password" name="pw"/><br/>
		<input type="button" value="로그인" onclick="checkForm()"/><br/>




</form>
</body>
</html>