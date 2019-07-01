package web.mvc.bean;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

public interface SuperBean {
	public String actionBean(HttpServletRequest request,HttpServletResponse response) throws SerialException, IOException;
	

}
