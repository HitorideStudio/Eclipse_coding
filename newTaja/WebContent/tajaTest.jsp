<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%@ page import ="htt.HttDBBean"%>
<%@ page import ="htt.HttDataBean"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<%

	
	int count = 0;
	int	startRow =0;
	int endRow =0;
	List bibletList = null;
	HttDBBean dbPro = HttDBBean.getInstance();
	count = dbPro.getCount();
	if (count > 0) { bibletList = dbPro.getHtt(startRow, endRow); }

%>
<html>
<head>
<meta charset="EUC-KR">
<title>타자연습 출력창</title>
</head>
<body>
 
  <%for(int i=0;i<bibletList.size(); i++){
		HttDataBean vo = (HttDataBean)bibletList.get(i);%>
		
		<%=vo.getExstring() %>
	<%}%>



</body>
</html>