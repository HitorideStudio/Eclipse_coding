package web.filter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
public class URIFilter implements Filter{
	PrintWriter writer = null;
	
	public void init(FilterConfig filterConfig) throws ServletException {
		try {
			writer = 
			new PrintWriter(new FileWriter("D:\\app\\log"),true);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sdf = sf.format(new Date());
		writer.println(req.getRequestURI()+"\t"+sdf);
		
		
		chain.doFilter(request, response);
	}
	public void destroy() {	
		writer.close();
	}
	
}
