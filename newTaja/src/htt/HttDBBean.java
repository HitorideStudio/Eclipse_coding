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
		
			sql = "insert into bible values(bible_seq.nextval,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, htt.getExstring());
			pstmt.executeUpdate();
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
	}
	public int getCount() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x=0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) from bible");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				x= rs.getInt(1); //0���ƴϰ� 1������ ����
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		return x; 
	}
	public List getHtt(int start, int end)throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List bibletList=null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(
					"select * from bible order by  exnum asc");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bibletList = new ArrayList(end); 
				do{ 
					HttDataBean vo = new HttDataBean();
					vo.setExstring(rs.getString("exstring"));
					bibletList.add(vo);
				}while(rs.next());
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		return bibletList;
	}
	public String getValue(int i) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String str=null;
		
		try {
			conn = getConnection();
			String sql = "select exstring from bible where exnum=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, i);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				str = rs.getString(1);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return str;
	}
}
