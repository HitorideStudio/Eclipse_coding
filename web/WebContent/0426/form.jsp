<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <body>
      <h1>사용자 입력 폼</h1>
      <form action="pro.jsp">
			msg: <input type="text" name="msg"/><br/>             
			age: <input type="text" name="age"/><br/>
			
			채널1: <input type="checkbox" name="ch" value="aa"/><br/>
			채널2: <input type="checkbox" name="ch" value="bb"/><br/>
			채널3: <input type="checkbox" name="ch" value="cc"/><br/>
			
			라디오1: <input type="radio" name="ra" value="aa"/><br/>
			라디오2: <input type="radio" name="ra" value="bb"/><br/>
			라디오3: <input type="radio" name="ra" value="cc"/><br/>
		         통신사 : <select name ="tel">
		         	<option value ="에스케이">SKT</option>
		         	<option >KT</option>
		         	<option >U+</option>         	
        			</select><br/>
        	textArea: <textarea rows="10" cols="40" name ="board"></textarea>
        			
        			
             <input type="submit" value="전송"/>
      </form>
   </body>
</html>