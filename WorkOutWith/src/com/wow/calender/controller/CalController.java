package com.wow.calender.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wow.common.JDBCTemplate;

@WebServlet("/calender")
public class CalController extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
			Connection conn = JDBCTemplate.getConnection();
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "SELECT*FROM ROUTINE";
			CalVo c = null;
			
			//쿼리 날리기
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					
					int rouNo = rs.getInt("ROU_NO");
					String rouName = rs.getString("ROU_NAME");
					int exerNo = rs.getInt("EXER_NO");
					int interv = rs.getInt("INTERV");	
					
					c = new CalVo();
					c.setRouNo(rouNo);
					c.setRouName(rouName);
					c.setExerNo(exerNo);
					c.setInterv(interv);
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			
			
			//조회한 데이터 jsp에 넘겨줌
			
			req.setAttribute("data", c);
			req.getRequestDispatcher("/WEB-INF/views/calender/calender.jsp").forward(req, resp);
		}

}