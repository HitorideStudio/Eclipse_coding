<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   String logbarName;
   String logURL;
   String msg="님 환영합니다.";
   
   if(session.getAttribute("loginId")==null){
      logbarName="로그인";
      logURL="login.jsp";
    
   }else{
      logbarName="로그아웃";
      logURL="logout.jsp";
      
   }
 
%>    
	<nav class="navbar navbar-expand  navbar-dark bg-dark">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="./welcome.jsp">Home</a>
				<a class="navbar-brand" href="./products.jsp">Product</a>
				<%if(session.getAttribute("loginId")!=null){ %>
				<a class="navbar-brand" href="./addProduct.jsp">상품등록</a><%} %>
				
				<%if(session.getAttribute("loginId")==null){ %>
				
				<a class="navbar-brand" href="./register.jsp">회원가입</a> <%} %>
				
				<%if(session.getAttribute("loginId")!=null){ %>
				<a class="navbar-brand" href="./memberInfo.jsp">회원정보</a><%} %>
				 
				<a class="navbar-brand" href="<%=logURL%>"><%=logbarName%></a>
				
		 <%if(session.getAttribute("loginId")==null){%>
            
         <%}%>
				
			</div>
		</div>
		<%if(session.getAttribute("loginId")!=null){%>
      <p id="welcomeMSG"><%=session.getAttribute("loginId")%><%=msg%></p>
   <%}%>
		
	</nav>
	
	<style>
   	#welcomeMSG{ color : white ; font-weight : bold ; margin:5px;}
	</style>
	
	
	
	