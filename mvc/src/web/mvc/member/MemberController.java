package web.mvc.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import web.mvc.bean.SuperBean;
import web.mvc.bean.loginFormBean;

public class MemberController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String view ="";
		//요청 URL분석 http://localhost:8080/mvc/loginPro.mem
		System.out.println("uri");
		String uri = request.getRequestURI();
		
		SuperBean sb = null;
		if(uri.equals("/mvc/loginForm.mem")) {
			sb = new loginFormBean();
			view = sb.actionBean(request, response);
		
			
		}else if(uri.equals("/mvc/loginPro.mem")) {
			request.setAttribute("result", 1);
			view="/0701/loginPro.jsp";
		}
		
		RequestDispatcher ad = request.getRequestDispatcher(view);
		ad.forward(request, response);
	}
	

	
	
	
	
	
	
	
	
	
	
}
