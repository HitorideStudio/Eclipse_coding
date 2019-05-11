<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="test.bean.dao.MemberDAO" %>
<%@ page import="test.bean.vo.MemberVo" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.Timestamp" %>

<h1>test2 all data</h1>
<%
		
	MemberDAO dao = MemberDAO.getInstance();
	ArrayList<MemberVo>list = dao.getAllMember();
	for(MemberVo vo :list){%>
		
		<h2>
		<%=vo.getId()%>
		<%=vo.getPw()%>
		<%=vo.getName()%> 
		<%=vo.getAge()%>
		<%=vo.getReg()%>
		</h2>
		
	<% }%>




