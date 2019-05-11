<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="test.bean.dao.MemberDAO" %>
<% request.setCharacterEncoding("UTF-8"); %>
<h1>insertPro.jsp</h1>    
   
<jsp:useBean id="vo" class="test.bean.vo.MemberVo"/>
<jsp:setProperty property="*" name="vo"/>

<%

	MemberDAO dao = MemberDAO.getInstance();
	dao.insertMember(vo);


%>
<h1><jsp:getProperty property="name" name="vo"/>님 가입 되었습니다.</h1>
