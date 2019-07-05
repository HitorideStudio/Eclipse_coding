package web.board.bean;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDBBean;
import board.BoardDataBean;

public class writeProBean implements SuperBean {

	@Override
	public String actionBean(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");
		int num = Integer.parseInt(request.getParameter("num"));
		int ref = Integer.parseInt(request.getParameter("ref"));
		int re_step = Integer.parseInt(request.getParameter("re_step"));
		int re_level= Integer.parseInt(request.getParameter("re_level"));
		
	    BoardDBBean dbPro = BoardDBBean.getInstance();
	    try {
	    BoardDataBean article = new BoardDataBean();
	    article.setNum(num);
	    article.setWriter(request.getParameter("writer"));
	    article.setSubject(request.getParameter("subject"));
	    article.setEmail(request.getParameter("email"));
	    article.setContent(request.getParameter("content"));
	    article.setPasswd(request.getParameter("passwd"));
	    article.setRef(ref);
	    article.setRe_level(re_level);
	    article.setRe_step(re_step);
	    article.setReg_date(new Timestamp(System.currentTimeMillis()));
	    article.setIp(request.getRemoteAddr());
	    
	    
	    
	    dbPro.insertArticle(article);
	   
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
		
		
		return "/board/writePro.jsp";
	}

}
