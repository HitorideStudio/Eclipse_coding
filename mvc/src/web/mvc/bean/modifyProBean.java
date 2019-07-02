package web.mvc.bean;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ch11.logon.LogonDBBean;
import ch11.logon.LogonDataBean;

public class modifyProBean implements SuperBean{

	
	public String actionBean(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("memId");
		
		
		LogonDBBean manager = LogonDBBean.getInstance();
		try {
			LogonDataBean member = new LogonDataBean();
			member.setId(id);
			member.setPasswd(request.getParameter("passwd"));
			member.setName(request.getParameter("name"));
			member.setEmail(request.getParameter("email"));
			member.setBlog(request.getParameter("blog"));
			manager.updateMember(member);
			
			}catch(Exception e){
				e.printStackTrace();
			}
		
		return "/member/modifyPro.jsp";
	}
	

}
