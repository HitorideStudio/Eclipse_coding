<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="pro01.jsp" method ="get">
	<!--  get방식은 보안에 취약하다 http://localhost:8080/web/0426/pro01.jsp?msg=jkjk -->
		<input type ="text" name ="msg" placeholder ="내용입력"/><br/>
		<input type ="submit" value ="전송"/>
	
	</form>

</body>
</html>