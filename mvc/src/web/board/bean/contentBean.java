package web.board.bean;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDBBean;
import board.BoardDataBean;

public class contentBean implements SuperBean {

	@Override
	public String actionBean(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		   int num = Integer.parseInt(request.getParameter("num"));
		   String pageNum = request.getParameter("pageNum");

		   SimpleDateFormat sdf = 
		        new SimpleDateFormat("yyyy-MM-dd HH:mm");

		   try{
		      BoardDBBean dbPro = BoardDBBean.getInstance();
		      BoardDataBean article =  dbPro.getArticle(num);
		  
			  int ref=article.getRef();
			  int re_step=article.getRe_step();
			  int re_level=article.getRe_level();
			  
			  request.setAttribute("num", num);
			  request.setAttribute("pageNum", pageNum);
			  request.setAttribute("sdf", sdf);
			  request.setAttribute("ref", ref);
			  request.setAttribute("re_step", re_step);
			  request.setAttribute("re_level", re_level);
			  request.setAttribute("article", article);
			  

		
		   }catch(Exception e) {
			   e.printStackTrace();
		   }
		   return "/board/content.jsp";
	}
}
