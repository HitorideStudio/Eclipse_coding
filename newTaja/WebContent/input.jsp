<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="newTaja.board.TajaWork" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>타자연습창</title>
</head>
<h1>타자연습</h1>


<body>
	<applet code="newTaja.board.TajaWork.class" width="1000" height="800"></applet>

	<form method="post" action="inputPro.jsp" name="userinput">
		
		<tr>
			<textarea name="exstring" rows="2" cols="100"></textarea>
		</tr>
		<input type="submit" name="confirm" value="등   록" >
	</form>

</body>
</html>