package web.board.bean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDBBean;

public class deleteProBean implements SuperBean{

	@Override
	public String actionBean(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");
		
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		String passwd = request.getParameter("passwd");
		BoardDBBean dbPro = BoardDBBean.getInstance();
		try {
			int check = dbPro.deleteArticle(num, passwd);
			request.setAttribute("check", check);
			request.setAttribute("pageNum", pageNum);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return "/board/deletePro.jsp";
	}
	
	
}
