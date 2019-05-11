<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<h1>request get정보확인</h1>
<h2>IP주소: <%=request.getRemoteAddr() %></h2>
<h2>콘텐트 유형: <%=request.getContentType() %></h2>
<h2>프로토콜: <%=request.getProtocol() %></h2>
<h2>전송방식: <%=request.getMethod() %></h2>
<h2>요청경로: <%=request.getRequestURI() %></h2>
<h2>서버포트: <%=request.getServerPort() %></h2>
<h2>루트이름: <%=request.getContextPath() %></h2>