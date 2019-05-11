<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.sql.Connection"%>
<%@ page import ="java.sql.PreparedStatement"%>
<%@ page import ="java.sql.DriverManager"%>
<%@ page import ="java.sql.ResultSet" %> 

	<%
	request.setCharacterEncoding("UTF-8");
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String user ="class04" , pass ="class04";
	String url ="jdbc:oracle:thin:@nullmaster.iptime.org:1521:xe";
	Connection conn = DriverManager.getConnection(url,user,pass);
	
	 String sql = "select * from register where id = ? and pw =?";
	 PreparedStatement pstmt = conn.prepareStatement(sql);
	 pstmt.setString(1, id);
	 pstmt.setString(2, pw);
	 ResultSet rs = pstmt.executeQuery();
	    
	    if(rs.next()){
	    	//id,pw확인
	    	session.setAttribute("loginId",id);
	    	%><script>
	    	alert("환영합니다!");
	    	</script>
	    	<META http-equiv=refresh content="0;url=welcome.jsp"><% 

	    
			
	    	
    		}else{%>
				<script>alert("id/pw를 확인하세요!");
	        	history.go(-1);
	        	</script> 
	       
			<%}
			   rs.close();
			   pstmt.close();
			   conn.close();  
			%>
			    
