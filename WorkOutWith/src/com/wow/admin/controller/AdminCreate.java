package com.wow.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import com.wow.admin.model.service.AdminCreateService;
import com.wow.admin.model.vo.AdminVo;

@WebServlet("/admin_create")
public class AdminCreate extends HttpServlet {
//JoinController

	//회원가입 화면 보여줌
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("WEB-INF/views/admin/admin_create.jsp").forward(request, response);
	}

	//회원가입 진행
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String aId = request.getParameter("aId");
		String aPwd = request.getParameter("aPwd");
		String aName = request.getParameter("aName");
		String aNick = request.getParameter("aNick");
		String aEmail = request.getParameter("aEmail");
		String aPower = request.getParameter("aPower");
	
		
		AdminVo a = new AdminVo();
		a.setAdmin_id(aId);
		a.setAdmin_pwd(aPwd);
		a.setAdmin_name(aName);
		a.setAdmin_nik(aNick);
		a.setAdmin_email(aEmail);
		a.setAdmin_power_code(aPower);
		
		int result = new AdminCreateService().create(a);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		//계정 생성 됐으면
		if(result > 0) {
			//success
			out.println("<script>alert('관리자 계정 생성 성공'); location.href='admin_create';</script>");
//			out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>");
//			out.println("<script>swal('Good job!', '관리자 계정 생성 성공!', 'success'); location.href='admin_create'</script>");
			System.out.println("성공");
		} else {
			//error
			request.getRequestDispatcher("WEB-INF/views/admin/admin_create.jsp").forward(request, response);
			System.out.println("실패");
		}
	}

}
