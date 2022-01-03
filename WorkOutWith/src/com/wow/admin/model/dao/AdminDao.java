package com.wow.admin.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wow.admin.model.vo.AdminVo;
import static com.wow.common.JDBCTemplate.*;

public class AdminDao {

	//2. admin 계정 생성, 생성했으면 result = 1;
	public int insertAdmin(Connection conn, AdminVo a) {
//		String sql = "INSERT INTO admin(admin_num, admin_power_code, admin_id, admin_pwd, "
//				+ "admin_name, admin_nik, admin_email) "
		String sql = "INSERT INTO admin "
				+ "VALUES(SEQ_ADMIN.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, a.getAdmin_power_code());
			pstmt.setString(2, a.getAdmin_id());
			pstmt.setString(3, a.getAdmin_pwd());
			pstmt.setString(4, a.getAdmin_name());
			pstmt.setString(5, a.getAdmin_nik());
			pstmt.setString(6, a.getAdmin_email());
			pstmt.setInt(7, -1);
			pstmt.setInt(8, -1);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("insertAdmin에서 실패");
		} finally {
			close(pstmt);			
		}
		
		return result;

	}
	
	//1. admin 로그인, admin멤버 조회
	public AdminVo selectAdmin(Connection conn, AdminVo a) {
//		String sql = "SELECT * FROM admin WHERE admin_id = ?";
		String sql = "SELECT a.*, ap.admin_power_name "
				+ "FROM admin a "
				+ "LEFT JOIN admin_power ap ON(a.admin_power_code = ap.admin_power_code) "
				+ "WHERE admin_id = ?";
		
		PreparedStatement pstmt = null;
		AdminVo selectedAdmin = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, a.getAdmin_id());
//			System.out.println(pstmt);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int admin_num = rs.getInt("admin_num");
				String admin_power_code = rs.getString("admin_power_code");
				String admin_id = rs.getString("admin_id");
				String admin_pwd = rs.getString("admin_pwd");
				String admin_name = rs.getString("admin_name");
				String admin_nik = rs.getString("admin_nik");
				String admin_email = rs.getString("admin_email");
				int answer_talkto_admin_num = rs.getInt("answer_talkto_admin_num");
				int answer_danger_num = rs.getInt("answer_danger_num");
				String admin_power_name = rs.getString("admin_power_name");
				
				System.out.println(rs.getInt("admin_num"));
				selectedAdmin = new AdminVo();
				selectedAdmin.setAdmin_num(admin_num);
				selectedAdmin.setAdmin_power_code(admin_power_code);
				selectedAdmin.setAdmin_id(admin_id);
				selectedAdmin.setAdmin_pwd(admin_pwd);
				selectedAdmin.setAdmin_name(admin_name);
				selectedAdmin.setAdmin_nik(admin_nik);
				selectedAdmin.setAdmin_email(admin_email);
				selectedAdmin.setAnswer_talkto_admin_num(answer_talkto_admin_num);
				selectedAdmin.setAnswer_danger_num(answer_danger_num);
				selectedAdmin.setAdmin_power_name(admin_power_name);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return selectedAdmin;
	}

	
	//3. 어드민 id 찾기
	//데베에서 어드민id찾으면 result==중복수  -> id 중복체크
	public int selectAdminById(Connection conn, String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "SELECT COUNT (*) FROM admin WHERE admin_id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			rs.next();
			result = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return result;
	}
	
	
	//5. 모든 어드민 조회, 모든 어드민을 담은 list 반환
	public List<AdminVo> selectAdminAll(Connection conn, int startNo, int endNo) {
		String sql = "SELECT *"
				+ "FROM "
				+ "( "
				+ "SELECT ROWNUM AS RNUM, admin_num, admin_id, admin_name, admin_power_name, admin_nik, admin_email "
				+ "FROM admin "
				+ "INNER JOIN admin_power USING(admin_power_code) "
				+ ") "
				+ "WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<AdminVo> list = new ArrayList<AdminVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNo);
			pstmt.setInt(2, endNo);
			rs = pstmt.executeQuery();
			AdminVo selectedAdmin = null;
			
			while(rs.next()) {
				int admin_num = rs.getInt("admin_num");
				String admin_id = rs.getString("admin_id");
				String admin_name = rs.getString("admin_name");
				String admin_power_name = rs.getString("admin_power_name");
				String admin_nik = rs.getString("admin_nik");
				String admin_email = rs.getString("admin_email");
				
				//만들고
				selectedAdmin = new AdminVo();
				selectedAdmin.setAdmin_num(admin_num);
				selectedAdmin.setAdmin_id(admin_id);
				selectedAdmin.setAdmin_name(admin_name);
				selectedAdmin.setAdmin_power_name(admin_power_name);
				selectedAdmin.setAdmin_nik(admin_nik);
				selectedAdmin.setAdmin_email(admin_email);
				
				//담아주고
				list.add(selectedAdmin);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	//5. 어드민 총 인원 세기
	public int countAdminAll(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT COUNT (admin_num) FROM admin";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}		
		return result;
	}
	
	//5. 타입별조회(예: 아이디, 이름...)
	public List<AdminVo> selectAdminBySearch(Connection conn, String type, String value){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT a.*, ap.admin_power_name "
				+ "FROM admin a"
				+ "LEFT JOIN admin_power ap ON(a.admin_power_code = ap.admin_power_code) "
				+ "WHERE %s LIKE ?";
		sql = String.format(sql, type);
		//%s : 타입
		
		List<AdminVo> list = new ArrayList<AdminVo>();
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+value+"%");
			
			AdminVo selectedAdmin = null;
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int admin_num = rs.getInt("admin_num");
				String admin_id = rs.getString("admin_id");
				String admin_name = rs.getString("admin_name");
				String admin_nik = rs.getString("admin_nik");
				String admin_email = rs.getString("admin_email");
				int answer_talkto_admin_num = rs.getInt("answer_talkto_admin_num");
				int answer_danger_num = rs.getInt("answer_danger_num");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	

}
