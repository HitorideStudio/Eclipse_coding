<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="test.bean.dao.MemberDAO" %>
<%@ page import="test.bean.vo.MemberVo" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.Timestamp" %>

<h1>test2 login data</h1>
<%
	String id = (String)session.getAttribute("loginId");	
	MemberDAO dao = MemberDAO.getInstance();
	MemberVo vo = dao.getloginMember(id);
	
	%>
	
	<h2>회원정보
	<%=vo.getId()%>
	<%=vo.getPw()%>
	<%=vo.getName()%> 
	<%=vo.getAge()%>
	
	</h2>
	

		
