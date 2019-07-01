package web.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginProController extends HttpServlet {

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		//MemberDAO dao  = MemberDAO.getInstance();
		//int result = dao.userCheck(id,pw); //1,0
		int result = 1;
		request.setAttribute("result", result);
		
		RequestDispatcher ad = request.getRequestDispatcher("/0701/loginPro.jsp");
		ad.forward(request, response);
	}
	

}
