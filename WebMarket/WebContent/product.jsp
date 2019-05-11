<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="web.bean.vo.Product"%>
<%@ page import="web.bean.dao.ProductRepository"%>


<% ProductRepository productDAO = ProductRepository.getInstance(); %>

<%-- 
<jsp:useBean id="productDAO" class="web.bean.dao.ProductRepository" scope="session" />
--%>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

</head>
<body>

	
<jsp:include page="menu.jsp" />
	<%
		int index = Integer.parseInt(request.getParameter("index"));
		Product vo = productDAO.getAllProducts().get(index);
	%>
	
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">상세정보</h1>
		</div>
	</div>
	
	<div class="container">
		<div class="text-center">
		<img src ="resources/images/<%=vo.getFilename() %>" width ="300"/>
		 <h3><%=vo.getPname()%></h3>
         <p><%=vo.getDescription() %></p>
         <p>제조사:<%=vo.getManufacturer() %></p>
         <p>분류:<%=vo.getCategory() %></p>
         <p>재고 수량:<%=vo.getUnitsInStock() %></p>
         <p>가격:<%=vo.getUnitPrice() %></p>		
			
			
		</div>
		
		<hr>
	</div>

	<jsp:include page="footer.jsp" />

</body>
</html>