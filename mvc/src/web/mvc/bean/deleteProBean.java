package web.mvc.bean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ch11.logon.LogonDBBean;

public class deleteProBean implements SuperBean {

	
	public String actionBean(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("memId");
		String passwd  = request.getParameter("passwd");
		
		LogonDBBean manager = LogonDBBean.getInstance();
		try {
			int check = manager.deleteMember(id,passwd);
			request.setAttribute("check", check);			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		
		return "/member/deletePro.jsp";
	}
	

}
