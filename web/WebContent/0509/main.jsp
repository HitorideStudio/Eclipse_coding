<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>main</h1>

<%
	if(session.getAttribute("loginId")==null){
		response.sendRedirect("form.jsp");
		
	}


%>
	<h2><%=session.getAttribute("loginId") %>
	님 로그인 되셨습니다.</h2>
	<button onclick ="window.location= 'loginMember.jsp'">회원정보</button>
	<button onclick ="window.location= 'logout.jsp'">로그아웃</button>
	
	<!-- 로그아웃페이지를 만들어서 세션 지우는 프로세스 생성 -->