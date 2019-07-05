package web.board.bean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDBBean;
import board.BoardDataBean;

public class updateFormBean implements SuperBean{

	@Override
	public String actionBean(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
			int num = Integer.parseInt(request.getParameter("num"));
			String pageNum = request.getParameter("pageNum");
		  try{
		      BoardDBBean dbPro = BoardDBBean.getInstance();
		      BoardDataBean article = dbPro.updateGetArticle(num);
		      
		      request.setAttribute("num", num);
		      request.setAttribute("pageNum", pageNum);
		      request.setAttribute("article", article);
		    
		      
		      
		      
		  }catch(Exception e){
	    	  e.printStackTrace();
	
		  	}
		  return "/board/updateForm.jsp";
		}
	}