<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <h2>logout</h2>
    
   <%
   		session.invalidate();//현재ip와 관련된 세션 전체 삭제
   		//session.removeAttribute("loginId");//하나의 세션 삭제
   		response.sendRedirect("main.jsp");
   %>