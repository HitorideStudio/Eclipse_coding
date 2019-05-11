<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>logout</h1>

<%
	session.invalidate();
	
	%><script>
	alert("로그아웃 되셨습니다");
	</script>
	<META http-equiv=refresh content="0;url=welcome.jsp"><%
	
%>