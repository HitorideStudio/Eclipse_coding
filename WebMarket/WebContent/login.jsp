<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<jsp:include page="menu.jsp" /><br/><br/>

	<form action="logincheck.jsp" method ="post" align ="center">
	
		<input type ="text" name = "id" placeholder = "아이디"/><br/>
		<input type ="password" name ="pw" placeholder = "비밀번호" /><br/><br/>
		<input type ="submit" value ="login"/>
	
		
		
	</form>

</body>
</html>