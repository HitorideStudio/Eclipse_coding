package test.bean.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import test.bean.vo.MemberVo;

import java.sql.DriverManager;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	public static MemberDAO getInstance() {
		return instance;
	}
	private MemberDAO() {}//다른클래스에서 new못한다
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private Connection getConnection() {
		try {
		/*	Class.forName("oracle.jdbc.driver.OracleDriver");
			String user ="class04" , pass ="class04";
			String url ="jdbc:oracle:thin:@nullmaster.iptime.org:1521:xe";
			conn = DriverManager.getConnection(url,user,pass);*/
			
			Context ctx = new InitialContext();//Context.xml정보획득
			Context env = (Context)ctx.lookup("java:comp/env");
			DataSource ds = (DataSource)env.lookup("jdbc/xe");
			conn = ds.getConnection();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public boolean logincheck(String id, String pw) {
		boolean result = false;
		try {
			conn = getConnection();
			String sql = "select * from test2 where id = ? and pw =?";
		    pstmt = conn.prepareStatement(sql);
		    pstmt.setString(1, id);
		    pstmt.setString(2, pw);
		    rs = pstmt.executeQuery();
		    if(rs.next()) {
		    	result = true;
		    }
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {try {rs.close();}catch(SQLException s) {}}
			if(pstmt !=null) {try {pstmt.close();}catch(SQLException s) {}}
			if(conn!=null) {try {conn.close();}catch(SQLException s) {}}
			
		}
		return result;
	}
	
	public void insertMember(MemberVo vo) {
		try {
			conn = getConnection();
			String sql="insert into test2 values(?,?,?,?,sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,vo.getId());
			pstmt.setString(2,vo.getPw());
			pstmt.setString(3,vo.getName());
			pstmt.setInt(4,vo.getAge());
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {try {pstmt.close();}catch(SQLException s) {}}
			if(conn != null) {try {conn.close();}catch(SQLException s) {}}
		}
	}
	
	public ArrayList<MemberVo>getAllMember(){
		ArrayList<MemberVo> list = null;
		try {
			conn = getConnection();
			String sql = "select * from test2";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<MemberVo>();
			while(rs.next()) {
				MemberVo vo = new MemberVo();
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setReg(rs.getTimestamp("reg"));
				list.add(vo);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {try {pstmt.close();}catch(SQLException s) {}}
			if(conn != null) {try {conn.close();}catch(SQLException s) {}}
		}
	
	
	return list;
	
	}
	public MemberVo getloginMember(String id){
		
		
		MemberVo vo = null;
	
		try {
			conn = getConnection();
			String sql = "select * from test2 where id =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new MemberVo();
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setReg(rs.getTimestamp("reg"));
				
				}
			
			
			}catch(Exception e) {
					e.printStackTrace();
				
			}finally {
					if(pstmt != null) {try {pstmt.close();}catch(SQLException s) {}}
					if(conn != null) {try {conn.close();}catch(SQLException s) {}}
					}
			return vo;
				}
	
			}

	

