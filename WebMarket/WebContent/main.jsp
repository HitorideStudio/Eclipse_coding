<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<jsp:include page="menu.jsp" /><br/><br/>
<%
	if(session.getAttribute("loginId")==null){
		response.sendRedirect("login.jsp");
	}
%>
	<h2><%=session.getAttribute("loginId") %>
	님 로그인 되셨습니다.</h2>
	<button onclick="window.location='logout.jsp'">로그아웃</button>