package web.mvc.bean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class modifyBean implements SuperBean{

	
	public String actionBean(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		return "/member/modify.jsp";
	}
	

}