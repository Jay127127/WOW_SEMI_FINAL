package com.wow.admin.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wow.admin.model.vo.AdminVo;
import static com.wow.common.JDBCTemplate.*;

public class AdminDao {

//	public int insertAdmin(Connection conn, AdminVo a) {
//		
//	}
	
	//로그인, admin멤버 조회
	public AdminVo selectAdmin(Connection conn, AdminVo a) {
		String sql = "SELECT * FROM admin WHERE admin_id = ?";
		
		PreparedStatement pstmt = null;
		AdminVo selectedAdmin = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, a.getAdmin_id());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int admin_num = rs.getInt("admin_num");
				int admin_power_code = rs.getInt("admin_power_code");
				String admin_id = rs.getString("admin_id");
				String admin_pwd = rs.getString("admin_pwd");
				String admin_name = rs.getString("admin_name");
				String admin_nik = rs.getString("admin_nik");
				String admin_email = rs.getString("admin_email");
				int admin_talkto_admin_num = rs.getInt("admin_talkto_admin_num");
				int admin_danger_num = rs.getInt("admin_danger_num");
				
				selectedAdmin = new AdminVo();
				selectedAdmin.setAdmin_num(admin_num);
				selectedAdmin.setAdmin_power_code(admin_power_code);
				selectedAdmin.setAdmin_id(admin_id);
				selectedAdmin.setAdmin_pwd(admin_pwd);
				selectedAdmin.setAdmin_name(admin_name);
				selectedAdmin.setAdmin_nik(admin_nik);
				selectedAdmin.setAdmin_email(admin_email);
				selectedAdmin.setAnswer_talkto_admin_num(admin_talkto_admin_num);
				selectedAdmin.setAnswer_danger_num(admin_danger_num);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return selectedAdmin;
	}
}
