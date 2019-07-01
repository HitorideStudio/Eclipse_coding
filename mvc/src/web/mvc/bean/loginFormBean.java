package web.mvc.bean;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

public class loginFormBean implements SuperBean{
	public String actionBean(HttpServletRequest request, HttpServletResponse response)
			throws SerialException, IOException{
		return "/0701/loginForm.jsp";
	}
	
}
