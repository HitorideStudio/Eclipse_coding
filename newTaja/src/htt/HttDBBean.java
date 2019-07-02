package htt;
import java.sql.*;
import javax.sql.*; 
import javax.naming.*;
import htt.HttDataBean;
import java.util.*; 



public class HttDBBean {
	
	private static HttDBBean instance = new HttDBBean();
	
	public static HttDBBean getInstance() {return instance; }
	
	private HttDBBean() {}
	
	private Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/xe");
		return ds.getConnection();

}
	
	public void insertHtt(HttDataBean htt) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
	
		String sql="";
		
		try {
			conn = getConnection();
			
 
			sql = "insert into htt(exTestament,exString)values(?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, htt.getExTestament());
			pstmt.setString(2, htt.getExString());
			
			pstmt.executeUpdate();
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
	}

}
