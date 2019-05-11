<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form align ="center">

 <table border ="0"  width ="550" align ="center" >
	<tr height ="80" bgcolor ="333F48">
		<th colspan ="3"><font color ="white">회원가입</font></th>
	</tr> 



	<tr height ="50">
		<th >이름</th>
		<th><input type ="text" autofocus /></th>
	</tr> 

	<tr height ="50">
		<th>이메일</th>
		<th><input type ="text" placeholder = "admin@seoul.co.kr"  /></th>
	</tr> 

	<tr height ="50">
		<th>전화번호</th>
		<th><input type ="text" name ="number"/></th>
		<th><select>
		<option>SKT</option>
		<option>KT</option>
		<option>LG U+</option>
	</select></th>
	</tr> 

	<tr height ="50">
		<th>아이디</th>
		<th><input type ="text" name = "id" />
		<th><input type ="button" value ="중복확인"/></th>
		</th>
	</tr> 

	<tr height ="50">
		<th>비밀번호</th>
		<th><input type ="password" name ="pw" /></th>
	</tr> 

	<tr height ="50">
		<th>비밀번호확인</th>
		<th><input type ="password" name ="pw" /></th>
	</tr> 
	<br/>
	
	
	

</table>
<br/>
<br/>
<input type ="submit" value ="Sign Up"  />
<input type ="reset" value ="Cancel"/><br/>

</form>

</body>
</html>
