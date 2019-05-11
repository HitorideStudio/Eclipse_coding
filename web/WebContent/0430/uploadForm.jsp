<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>파일업로드 처리</h1>

<form action ="imageUpload.jsp" method="post" enctype="multipart/form-data">
	title :<input type ="text" name ="title"/><br/>
	file :<input type ="file" name ="save"/><br/>
		<input type ="submit" value="전송" /><br/>


</form>