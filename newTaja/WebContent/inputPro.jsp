<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import ="htt.HttDBBean"%>
<% request.setCharacterEncoding("UTF-8");%>

<jsp:useBean id="htt" scope="page" class="htt.HttDataBean">
   <jsp:setProperty name="htt" property="*"/>
</jsp:useBean>

<%

	HttDBBean dbPro = HttDBBean.getInstance();
    dbPro.insertHtt(htt);
    
    
 %>