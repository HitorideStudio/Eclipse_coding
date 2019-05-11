<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import ="com.oreilly.servlet.MultipartRequest" %>
<%@ page import ="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import ="java.io.File" %>
<h1> 전달된 파일 처리</h1>
	<%
		String saveDir = request.getRealPath("save");//파일 저장경로
		int max =1024*1024*10;//10m 업로드 최대크기
		String enc = "UTF-8";//파일명 한글 인코딩
		DefaultFileRenamePolicy dp = new DefaultFileRenamePolicy();//파일명 중복방지
		MultipartRequest mr = new MultipartRequest(request,saveDir,max,enc,dp);
		
		String title = mr.getParameter("title");
		
		String sysName = mr.getFilesystemName("save");//업로드 파일명
		String orgName = mr.getOriginalFileName("save");//원본 파일명
		File f = mr.getFile("save");
		
	%>
	
<h2>realPath : <%=saveDir %></h2>	

<h2>title : <%=title %></h2>
<h2>sys : <%=sysName %></h2>
<h2>org : <%=orgName %></h2>
<h2>파일크기 : <%=f.length() %></h2>
<h2>저장경로 : <%=f.getAbsolutePath() %></h2>
<h2>파일타입 : <%= mr.getContentType("save") %></h2>