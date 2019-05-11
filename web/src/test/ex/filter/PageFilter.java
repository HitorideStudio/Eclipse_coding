package test.ex.filter;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

public class PageFilter implements Filter{
	

	@Override //최초 실행시 한번
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Filter int");
	
	}

	@Override//지정된 페이지가 실행될 때 마다
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		/*
		System.out.println("Filter doFilter......before");
		arg2.doFilter(arg0, arg1);//다음 흐름으로 이동
		System.out.println("Filter doFilter......after");
		*/
		HttpServletRequest request = null;
		if(arg0 instanceof HttpServletRequest) {
			request = (HttpServletRequest)arg0;
			System.out.println(request.getRequestURI()+" run!!");
		}
		request.getRequestDispatcher("/0502/test.jsp").forward(request, arg1);
		//arg2.doFilter(arg0, arg1); //다음흐름으로 이동
		
		
	}
	@Override
	public void destroy() {
		System.out.println("Filter destory");
		
	}

}
