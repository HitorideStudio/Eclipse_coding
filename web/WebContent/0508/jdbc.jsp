<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import ="java.sql.Connection"%>
<%@ page import ="java.sql.PreparedStatement"%>
<%@ page import ="java.sql.DriverManager"%>
<%@ page import ="java.sql.ResultSet" %>



<h1>JDBC Oracle Database Connection</h1>

<%
	//드라이버 로딩
	//jsp -jdbc 현재동작중
	//DriverManager 클래스에 자동 등록
	Class.forName("oracle.jdbc.driver.OracleDriver");

	
	String user ="class04" , pass ="class04";
	String url ="jdbc:oracle:thin:@nullmaster.iptime.org:1521:xe";
	//DB연결
	Connection conn = DriverManager.getConnection(url,user,pass);
	
	
	//Query 작성
	String sql = "select * from register";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery(); //select문 실행시 사용
	//pstmt.executeUpdate(); // 그 외 나머지 사용
	
	while(rs.next()){
		String name = rs.getString("name");
		String phone = rs.getString("phone");
		//숫자형식이 있을 경우 출력시
		//int age = rs.getInt("age")
		out.println("<h2>"+name+" : "+phone+"</h2>");	
		}
	rs.close(); //필수작업 ,연결을 끊어야한다.
	pstmt.close(); //필수작업
	conn.close(); //필수작업

%>

	<h2>conn :<%=conn %></h2>
	
<% conn.close();%>