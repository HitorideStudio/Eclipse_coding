package web.mvc.bean;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch11.logon.LogonDBBean;
import ch11.logon.LogonDataBean;

public class inputProBean implements SuperBean{


	public String actionBean(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		LogonDBBean manager = LogonDBBean.getInstance();
		try {
		LogonDataBean member = new LogonDataBean();
		member.setId(request.getParameter("id"));
		member.setPasswd(request.getParameter("passwd"));
		member.setName(request.getParameter("name"));
		member.setJumin1(request.getParameter("jumin1"));
		member.setJumin2(request.getParameter("jumin2"));
		member.setEmail(request.getParameter("email"));
		member.setBlog(request.getParameter("blog"));
		member.setReg_date(new Timestamp(System.currentTimeMillis()));
		
		manager.insertMember(member);
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	
		return "/member/inputPro.jsp";
	}
	

}
