package web.mvc.bean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ch11.logon.LogonDBBean;

public class loginProBean implements SuperBean{

	@Override
	public String actionBean(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		String id = request.getParameter("id");
		String passwd  = request.getParameter("passwd");
		
		LogonDBBean manager = LogonDBBean.getInstance();
		try {
		int check= manager.userCheck(id,passwd);
		if(check==1){
			HttpSession session = request.getSession();
			session.setAttribute("memId", id);
			
		}
			request.setAttribute("check", check);
		}catch(Exception e){
			e.printStackTrace();
		}
	
		return "/member/loginPro.jsp";
	}
}