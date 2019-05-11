<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import ="java.sql.Connection"%>
<%@ page import ="java.sql.PreparedStatement"%>
<%@ page import ="java.sql.DriverManager"%>
<%@ page import ="java.sql.ResultSet" %>
<h1>JDBC insert</h1>
<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String phone = request.getParameter("phone");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String user ="class04" , pass ="class04";
	String url ="jdbc:oracle:thin:@nullmaster.iptime.org:1521:xe";
	//DB연결
	Connection conn = DriverManager.getConnection(url,user,pass);
	String sql = "insert into register(name,email,phone,id,pw) values(?,?,?,?,?)";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, name);
	pstmt.setString(2, email);
	pstmt.setString(3, phone);
	pstmt.setString(4, id);
	pstmt.setString(5, pw);
	
	pstmt.executeUpdate();
	out.println("<h2>추가 되었습니다.</h2>");
	
	pstmt.close();
	conn.close();
	
%>
