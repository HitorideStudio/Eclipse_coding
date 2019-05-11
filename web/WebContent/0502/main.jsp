<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	log(request.getRequestURI()+"page run..!!");
	application.log("tttttttt");
	application.log("예외", new Exception());//catch 사용

%>

<h1>main페이지</h1>