<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<% 
	
		//get방식 한글처리 sever.xml  line63<connect>속성 추가 URIEncodig="UTF-8"
		//post방식 한글인코딩 방식
		request.setCharacterEncoding("UTF-8");
		String msg = request.getParameter("msg"); %>
		
	<%=msg %>
	
</body>
</html>