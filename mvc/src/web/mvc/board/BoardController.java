package web.mvc.board;

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

import web.mvc.bean.SuperBean;

public class BoardController extends HttpServlet {
	private Map command = new HashMap();
	
	public void init(ServletConfig config)throws ServletException{
		String path = config.getInitParameter("propertiesBoradPath");
		Properties p = null;
		InputStream is = null;
		try {
			is = new FileInputStream(path);
			p = new Properties();
			p.load(is);
			System.out.println(p);
			Iterator it = p.keySet().iterator();
			while(it.hasNext()) {
				String key = (String)it.next();
				String value = p.getProperty(key);
				Class c = Class.forName(value);
				Object obj = c.newInstance();
				command.put(key, obj);
			}
			System.out.println(command);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	protected void service(HttpServletRequest request, HttpServletResponse response)throws
	ServletException, IOException{
		String uri = request.getRequestURI();
		Object obj = command.get(uri);
		SuperBean sb = null;
		String view = "/board/error.jsp";
		if(obj instanceof SuperBean) {
			sb = (SuperBean)obj;
			view = sb.actionBean(request, response);
		}
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request,response);
		}
		
	}
			
			
			
			
			
			
			
			
			
			
			
			

