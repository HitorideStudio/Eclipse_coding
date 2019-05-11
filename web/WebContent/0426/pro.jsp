<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<title>pro</title>
</head>

<body>   
   <h1>Pro Page~</h1>
   <%
     //  String msg = request.getParameter("msg");//return형 String
    //  int age = Integer.parseInt(request.getParameter("age"));//return형 String
      
     // String ch1 = request.getParameter("ch1");
     // String ch2 = request.getParameter("ch2");
     // String ch3 = request.getParameter("ch3");
     // String [] chs = request.getParameterValues("ch");
      Enumeration enu = request.getParameterNames();
      // key /value 출력하는 코드 작성 
      while(enu.hasMoreElements()){
    	   String key = (String)enu.nextElement();
    	   String value = request.getParameter(key);
    	   out.println(key+"="+value+"<br/>");
      }
    		  
    		  
    %>
  <%--  <h3>msg--><%=msg %></h3>
   <h3>age--><%=age+10 %></h3>
   <h3>ch1--><%=chs[0] %></h3>
   <h3>ch2--><%=chs[1]%></h3> --%>
   

</body>
</html>