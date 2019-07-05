package web.board.bean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDBBean;
import board.BoardDataBean;

public class updateProBean implements SuperBean{

	@Override
	public String actionBean(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("euc-kr");
		String pageNum = request.getParameter("pageNum");
		int num = Integer.parseInt(request.getParameter("num"));
		BoardDBBean dbPro = BoardDBBean.getInstance();
		BoardDataBean article = new BoardDataBean();
	    try {
	    	
			article.setWriter(request.getParameter("writer"));
			article.setEmail(request.getParameter("email"));
			article.setSubject(request.getParameter("subject"));
			article.setPasswd(request.getParameter("passwd"));
			article.setContent(request.getParameter("content"));
			article.setNum(num);
			
			
			int check = dbPro.updateArticle(article);
			
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("check", check);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		return "/board/updatePro.jsp";
	}

}
