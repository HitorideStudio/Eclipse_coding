package web.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.mvc.bean.testVO;

public class testController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("num", 99);
		request.setAttribute("id", "java");
		request.setAttribute("data", null);
		request.setAttribute("age", "20");
		
		HttpSession session = request.getSession();
		session.setAttribute("num", 777);
		session.setAttribute("memId", "korea");
		
		int [] arr = {10,20,30,40,50};
		request.setAttribute("arr", arr);
		
		ArrayList list = new ArrayList();
		list.add("java");
		list.add("jsp");
		list.add("test");
		request.setAttribute("list", list);
		
		testVO vo = new testVO();
		vo.setId("git"); vo.setAge(10); vo.setName("academy");
		request.setAttribute("vo", vo);
		
		request.setAttribute("day", new Date());
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/0703/test.jsp");
		rd.forward(request,response);
	}
	

}
