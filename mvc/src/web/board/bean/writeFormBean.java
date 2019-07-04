package web.board.bean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class writeFormBean implements SuperBean{

	@Override
	public String actionBean(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int num=0,ref=1,re_step=0,re_level=0;
		  try{  
		    if(request.getParameter("num")!=null){
			num=Integer.parseInt(request.getParameter("num"));
			ref=Integer.parseInt(request.getParameter("ref"));
			re_step=Integer.parseInt(request.getParameter("re_step"));
			re_level=Integer.parseInt(request.getParameter("re_level"));
		    }
		    request.setAttribute("num", num);
		    request.setAttribute("ref", ref);
		    request.setAttribute("re_step", re_step);
		    request.setAttribute("re_level", re_level);
		    
		  	}catch(Exception e){
		    	
		    }
		    
		return "/board/writeForm.jsp";
	}
	

}
