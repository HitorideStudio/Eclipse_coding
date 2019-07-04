package web.board.bean;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDBBean;

public class listBean implements SuperBean {


	public String actionBean(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int pageSize = 10;
	       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	       String pageNum = request.getParameter("pageNum");
	       if (pageNum == null) {
	              pageNum = "1";
	          }
	       System.out.println(pageNum);
	        int currentPage = Integer.parseInt(pageNum);
	          int startRow = (currentPage - 1) * pageSize + 1;
	          int endRow = currentPage * pageSize;
	          int count = 0;
	          int number=0;
	          int wid=0; 
	          
	          int pageCount = count / pageSize + ( count % pageSize == 0 ? 0 : 1);

	           int startPage = (int)(currentPage/10)*10+1;
	         int pageBlock=10;
	           int endPage = startPage + pageBlock-1;
	           if (endPage > pageCount) endPage = pageCount;
	          
	          List articleList = null;
	      
	          BoardDBBean dbPro = BoardDBBean.getInstance();
	          
	          try {
	             count = dbPro.getArticleCount();
	             if (count > 0) {
	                 articleList = dbPro.getArticles(startRow, pageSize);
	             }
	             number=count-(currentPage-1)*pageSize;
	             
	            System.out.println(count);
	             
	             request.setAttribute("count",count);
	             request.setAttribute("articleList", articleList);
	             request.setAttribute("number", number);
	             request.setAttribute("currentPage", currentPage);
	             request.setAttribute("pageCount",pageCount );
	             request.setAttribute("startPage",startPage );
	             request.setAttribute("pageBlock", pageBlock);
	             request.setAttribute("endPage", endPage);
	          }catch (Exception e) {
	            // TODO: handle exception
	         }
	    
		return "/board/list.jsp";
	}
	

}
