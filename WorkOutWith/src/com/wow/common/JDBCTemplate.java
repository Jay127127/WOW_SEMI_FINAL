package com.wow.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {
	
	//커넥션 가져오기
	public static Connection getConnection() {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521/xe";
//		String url = "jdbc:oracle:thin:@128.168.25.30:1521/xe";
		String id = "wow";
		String pwd = "wow";
		
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(url, id, pwd);
			conn.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	
	//커밋
	public static void commit(Connection conn) {
		try {
			//null체크, isClosed 체크
			if(conn != null && !conn.isClosed())
				conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//롤백
	public static void rollback(Connection conn) {
		try {
			//null체크, isClosed 체크
			if(conn != null && !conn.isClosed())
				conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//close 들(Connection, Statement, ResultSet)
	public static void close(Connection conn) {
		try {
			//null체크, isClosed 체크
			if(conn != null && !conn.isClosed())
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void close(Statement stmt) {
		try {
			//null체크, isClosed 체크
			if(stmt != null && !stmt.isClosed())
				stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs) {
		try {
			//null체크, isClosed 체크
			if(rs != null && !rs.isClosed())
				rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
