<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.sql.Connection"%>
<%@ page import ="java.sql.PreparedStatement"%>
<%@ page import ="java.sql.DriverManager"%>
<%@ page import ="java.sql.ResultSet" %> 

<%@ page import ="test.bean.dao.MemberDAO" %>
<h1>loginpro</h1>
<%
    
    String id = request.getParameter("id");
    String pw = request.getParameter("pw");
    
    MemberDAO dao = MemberDAO.getInstance();
    boolean result = dao.logincheck(id,pw);
    
    //JDBC를 통해 아이디 패스워드 확인 절차 
    
    //Class.forName("oracle.jdbc.driver.OracleDriver");
	//String user ="class04" , pass ="class04";
	//String url ="jdbc:oracle:thin:@nullmaster.iptime.org:1521:xe";
    //Connection conn = DriverManager.getConnection(url, user, pass);
    
    //String sql = "select * from register where id = ? and pw =?";
    //PreparedStatement pstmt = conn.prepareStatement(sql);
    //pstmt.setString(1, id);
    //pstmt.setString(2, pw);
    //ResultSet rs = pstmt.executeQuery();
    
    if(result){
    	//id,pw확인
    	session.setAttribute("loginId",id);
    	response.sendRedirect("main.jsp");
    }else{%>
 
        <script>
        	alert("id/pw를 확인하세요!");
        	history.go(-1);
        </script>  
    <%}%>
    
    
    
  
    
    
    