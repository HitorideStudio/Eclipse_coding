package web.mvc.member;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;



import web.mvc.bean.SuperBean;
import web.mvc.bean.loginFormBean;

public class MemberController extends HttpServlet {
	
	private Map command = new HashMap();

	public void init(ServletConfig config) throws ServletException {
		String path = config.getInitParameter("propertiesPath");
		Properties p = null;
		InputStream is = null;
		try {
			is = new FileInputStream(path);
			p = new Properties();
			p.load(is);
			System.out.println(p);//테스트
			Iterator it =p.keySet().iterator();//반복해서 읽어들이겠다
			while(it.hasNext()) {
				String key = (String)it.next();//form.do
				String value =  p.getProperty(key);//FormBean
				Class c = Class.forName(value);//class load
				Object obj = c.newInstance();// new FormBean();
				command.put(key, obj);
			}
			System.out.println(command);
	}catch(Exception e) {
		e.printStackTrace();
		}
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
			//http://localhost:8080/mvc/loginForm.do
			String uri  = request.getRequestURI();// /mvc/loginForm.do
			Object obj = command.get(uri);// loginFormBean
			SuperBean sb = null;
			String view = "/member/main.jsp";
			if(obj instanceof SuperBean) {
				sb = (SuperBean)obj;
				view = sb.actionBean(request, response);
			}
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}	
}
