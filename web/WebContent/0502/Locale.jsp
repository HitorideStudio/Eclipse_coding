<%@page import="java.text.DateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import ="java.util.Locale" %>
<%@ page import ="java.util.Date" %>

<%@ page import ="java.text.DateFormat" %>

<h1>다국어 지원 가능 Locale 클래스 활용</h1>
<%
	
	Locale locale = request.getLocale();
	Date day = new Date();
	DateFormat df = DateFormat.getDateInstance(DateFormat.FULL,locale);
	

%>
<h2>국가 : <%=locale.getDisplayCountry() %></h2>    
<h2>언어 : <%=locale.getDisplayLanguage() %></h2>
<h2>언어(국가) :<%=locale.getDisplayName() %></h2>
<h2>국가(영문코드) :<%=locale.getCountry() %></h2>
<h2>날짜 시간 :<%=df.format(day) %></h2>


