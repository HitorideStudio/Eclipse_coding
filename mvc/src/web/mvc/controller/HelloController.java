package web.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//httpServelet클래스 상속
//doGet/doPost/service메서드 중 한가지를 오버라이딩한다

public class HelloController extends HttpServlet {


	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("service");
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/0701/hello.jsp");
		rd.forward(request, response);
	
		
	}

	
}
