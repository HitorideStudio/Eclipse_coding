<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import ="htt.HttDBBean"%>
<% request.setCharacterEncoding("UTF-8");%>

<jsp:useBean id="htt" scope="page" class="htt.HttDataBean">
   <jsp:setProperty name="htt" property="*"/>
</jsp:useBean>

<%

	HttDBBean vo = HttDBBean.getInstance();
	System.out.println("===============================");
    vo.insertHtt(htt);
    
    
 %>
 <script>

	alert("등록완료.");
</script>
<META http-equiv=refresh content="0; url=/newTaja/tajaTest.jsp">