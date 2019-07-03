<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix ="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="utf-8"/>

<fmt:formatDate value="${day }" type="date"/><br/>
<fmt:formatDate value="${day }" type="time"/><br/>
<fmt:formatDate value="${day }" type="both"/><br/> 

<fmt:formatDate value="${day }" type="both" dateStyle="short"/><br/> 
<fmt:formatDate value="${day }" type="both" dateStyle="medium"/><br/> 
<fmt:formatDate value="${day }" type="both" dateStyle="long"/><br/> 
<fmt:formatDate value="${day }" type="both" dateStyle="full"/><br/> 

<fmt:formatDate value="${day }" pattern="yyyy년 MM월 dd일 "  /><br/> 

<fmt:formatNumber value="10000000" groupingUsed="true" /> 
<fmt:formatNumber value="10000000" groupingUsed="false" /> 
<fmt:formatNumber value="1500.25" type="currency" currencySymbol="\\" /><br/> 
<fmt:formatNumber value="1500.25" type="currency" currencySymbol="$" /><br/> 

<fmt:formatNumber value="0.3" type="percent" /><br/> 
<fmt:formatNumber value="1500.255" pattern=".0" /><br/> 

<fmt:timeZone value="GMT">
	GMT:<fmt:formatDate value="${day }" type="both"/><br/>
</fmt:timeZone>








<%-- 
<c:set var="a" value="korea"/>
${a}<br/>

<c:url var="a" value="member/main.jsp">
	<c:param name="id" value="java"/>
	<c:param name="pw" value="1234"/>
</c:url>
<c:import url="/member/main.jsp" var="ma"/>
${ma }
	
<c:redirect url="/member/main.do"/>

<c:if test ="${num>100 }">
		<h1>100보다 크가</h1>
	</c:if>
	<c:if test ="${num<100 }">
		<h1>100보다 작다</h1>
	</c:if>
	<hr>
	<c:forEach items= "${arr}" var="a">
		<h2>${a}</h2>
	</c:forEach>
	
	<c:forEach begin="2" end="9" step="1" var="a">
		<c:forEach begin="1" end="9" step="1" var="b">
			${a }X${b } =${a*b }<br>
		</c:forEach>	
	</c:forEach>

	<c:forTokens items="a,b,c,d,e,f,g" delims="," var="a">
		${a}
	</c:forTokens>

    	<h1>num=<%=request.getAttribute("num") %></h1>
    	<h1>id=<%=request.getAttribute("id") %></h1>
    	<h1>data=<%=request.getAttribute("data") %></h1>
    	<h1>age=<%=(String)request.getAttribute("age")+10 %></h1>
    	<br/><br/><hr>
    	
    	<h1>num =${num}</h1>
    	<h1>id = ${id}</h1>
    	<h1>data = ${data}</h1>
    	<h1>age = ${age+10}</h1>
    	<br/><hr>
    	
    	<h1>num = ${num}</h1>
    	<h1>memId = ${memId}</h1>
    	<h1>num = ${sessionScope.num}</h1>
    	<h1>memId = ${sessionScope.memId}</h1>
    	<br/>
    	
    	<hr>
    	<h1>arr = ${arr[0]}</h1>
    	<h1>list = ${list}</h1>
    	<h1>list = ${list[0]}</h1>
    	
    	<hr>
    	<h1>vo = ${vo }</h1>
    	<h1>vo = ${vo.id }</h1>
    	<h1>vo = ${vo.age }</h1>
    	<h1>vo = ${vo.name }</h1>
   --%> 	
    	
    	
    