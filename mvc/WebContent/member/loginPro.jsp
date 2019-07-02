<%@ page contentType="text/html;charset=euc-kr" %>
<%@ page import = "ch11.logon.LogonDBBean" %>

<% request.setCharacterEncoding("euc-kr");%>

<%
    int check =(Integer)request.getAttribute("check");

	if(check==1){
		//session.setAttribute("memId",id);
		response.sendRedirect("main.jsp");
	}else if(check==0){%>
	<script> 
	  alert("비밀번호가 맞지 않습니다.");
      history.go(-1);
	</script>
<%	}else{ %>
	<script>
	  alert("아이디가 맞지 않습니다..");
	  history.go(-1);
	</script>
<%}	%>	