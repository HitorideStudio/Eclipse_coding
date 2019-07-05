<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%@ page import ="htt.HttDBBean"%>
<%@ page import ="htt.HttDataBean"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>

<%
	double random = Math.random();
	int count = 0;
	HttDBBean dbPro = HttDBBean.getInstance();
	count = dbPro.getCount();
	int i = (int)(random * count)+1;
	String str = dbPro.getValue(i);
%>
<%--
create table bible(
    exnum number primary key,
    exstring varchar2(4000)
);
create sequence bible_seq nocache;


 --%>

<html>
<head>
<meta charset="EUC-KR">
<title>타자연습 출력창</title>
</head>

<script type="text/javascript">

function enterkey(){
	
	if(window.event.keyCode==13){
		location.href='tajaTest.jsp';
	}
}


</script>
<body>
<textarea id="exstring" rows="2" cols="150"><%=str%></textarea><br/>
<textarea id="exstring" autofocus  rows="2" cols="150" onkeyup="enterkey()"></textarea><br/>

 <%-- 
  <%for(int i=0;i<bibletList.size(); i++){
		HttDataBean vo = (HttDataBean)bibletList.get(i);%>
		
		<%=vo.getExstring() %>
	<%}%>

 --%>
<a href="input.jsp">Go input</a>
</body>
</html>