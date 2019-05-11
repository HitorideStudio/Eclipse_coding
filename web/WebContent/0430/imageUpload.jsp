<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="com.oreilly.servlet.MultipartRequest" %>
<%@ page import ="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import ="java.io.File" %>
<%@ page import ="java.util.*" %>
<h1>사진파일만 업로드 처리</h1>

<%
		String saveDir = request.getRealPath("save");
		int max =1024*1024*10;
		int imgMax =1024*1024*10;
		String enc = "UTF-8";
		DefaultFileRenamePolicy dp = new DefaultFileRenamePolicy();
		MultipartRequest mr = new MultipartRequest(request,saveDir,max,enc,dp);
		//jpeg,png만 업로드 가능(지원되는 형식이 아닙니다.)
		//파일크기 3M 이하만 업로드 가능(경고:파일크기초과)
		List<String> exeList = new ArrayList<String>();
   		exeList.add("jpeg");exeList.add("gif");
   		exeList.add("png");exeList.add("taga");
   		exeList.add("tiff");
   		// jpeg , png , gif , taga , tiff 만 업로드가능  (경고 : 지원되는 형식아닙니다.)
   	   	// 파일 크기 3M 이하만 업로드 가능(경고 : 파일크기 초과 )
		String type = mr.getContentType("save"); // image/jpg
		String [] format = type.split("/");// [image][jpeg]
		File f = mr.getFile("save"); // d://save// 
		int imageMax = 1024*1024*3;
		if( imgMax <=  f.length()){%>
			f.delete();
		
			<script>
				alert("파일크기초과 3M이하만 가능");
				history.go(-1);
			</script>
		<%}else{
      if(exeList.contains(format[1])){%>   
            <img src="/web/save/<%=mr.getFilesystemName("save") %>" />
       <%}else{
          f.delete();%>
          <script>
             alert("지원되지않는 파일입니다.");
             history.go(-1);
          </script>
       <%}
    }%>
		
		
		
		
		
		
		
		
		
		
		
	
		
		



