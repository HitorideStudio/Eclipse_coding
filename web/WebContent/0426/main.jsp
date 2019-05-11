<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<jsp:include page="a.jsp"/>
    
    <hr color="red"/>
    <h1>main page..!</h1>
    <hr color ="red"/>
    
    <jsp:include page="c.jsp">
    	<jsp:param value="test" name="msg"/>
    	<jsp:param value="java" name="id"/>
    </jsp:include>