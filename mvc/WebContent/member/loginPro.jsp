<%@ page contentType="text/html;charset=euc-kr" %>
<%@ page import = "ch11.logon.LogonDBBean" %>

<% request.setCharacterEncoding("euc-kr");%>

<%
    int check =(Integer)request.getAttribute("check");

	if(check==1){
		//session.setAttribute("memId",id);
		response.sendRedirect("/mvc/main.do");
	}else if(check==0){%>
	<script> 
	  alert("��й�ȣ�� ���� �ʽ��ϴ�.");
      history.go(-1);
	</script>
<%	}else{ %>
	<script>
	  alert("���̵� ���� �ʽ��ϴ�..");
	  history.go(-1);
	</script>
<%}	%>	