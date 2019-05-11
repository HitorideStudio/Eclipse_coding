<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" session = "true" buffer ="8kb" %>
<%!
	//선언문 - 클래스 영역
	static int x = 10; //클래스변수
			int y= 20; //인스턴스 변수
	public void add(){
		}
%>

<%       
	// 자바코드 작성
	//public void doGet(httpServletRequest request,HttpServletResponse response){}
	//스트립트릿 -자바의 인스턴스 메서드 영역
	int x =100; //지역변수
	String bg ="skyblue";
	System.out.println("System.out.println(이건 브라우저에 출력 안된다)");
%>
<h1><%= x %></h1> 

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body bgcolor ="<%=bg%>">
	<h1>hello JSP..!!</h1>
	

</body>
</html>