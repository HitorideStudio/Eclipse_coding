<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" session = "true" buffer ="8kb" %>
<%!
	//���� - Ŭ���� ����
	static int x = 10; //Ŭ��������
			int y= 20; //�ν��Ͻ� ����
	public void add(){
		}
%>

<%       
	// �ڹ��ڵ� �ۼ�
	//public void doGet(httpServletRequest request,HttpServletResponse response){}
	//��Ʈ��Ʈ�� -�ڹ��� �ν��Ͻ� �޼��� ����
	int x =100; //��������
	String bg ="skyblue";
	System.out.println("System.out.println(�̰� �������� ��� �ȵȴ�)");
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