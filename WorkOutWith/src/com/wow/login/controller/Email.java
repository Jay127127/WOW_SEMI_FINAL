package com.wow.login.controller;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wow.login.model.service.MemberService;
import com.wow.login.model.vo.MemberVo;

@WebServlet("/email")
public class Email extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		//먼저 아이디로 회원정보를 받아오고 가져온 데이터에서 email값을 비교하여 존재하지 않으면 인증메일 보내지 못함
		 MemberVo m = new MemberService().login(name);
		 System.out.println(m);
	        if(m==null || !m.getEmail().equals(email))
	        {
	            request.setAttribute("msg", "아이디나 이메일 정보가 맞지 않습니다");
	            request.setAttribute("loc", "/member/searchPw");
	            request.getRequestDispatcher("WEB-INF/views/common/msg.jsp").forward(request, response);
	            return;
	        }
	      //mail server 설정
            String host = "smtp.naver.com";
            String user = "semiwow2022"; //자신의 네이버 계정
            String password = "semiwow2022!";//자신의 네이버 패스워드
            
            //메일 받을 주소
            String to_email = m.getEmail();
            
            //SMTP 서버 정보를 설정한다.
            Properties props = new Properties();
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", 465);
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.ssl.enable", "true");
            
          //인증 번호 생성기
            StringBuffer temp =new StringBuffer();
            Random rnd = new Random();
            for(int i=0;i<10;i++)
            {
                int rIndex = rnd.nextInt(3);
                switch (rIndex) {
                case 0:
                    // a-z
                    temp.append((char) ((int) (rnd.nextInt(26)) + 97));
                    break;
                case 1:
                    // A-Z
                    temp.append((char) ((int) (rnd.nextInt(26)) + 65));
                    break;
                case 2:
                    // 0-9
                    temp.append((rnd.nextInt(10)));
                    break;
                }
            }
            String AuthenticationKey = temp.toString();
            System.out.println(AuthenticationKey);
            
            Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(user,password);
                }
            });
          //email 전송
            try {
                MimeMessage msg = new MimeMessage(session);
                msg.setFrom(new InternetAddress(user, "KH Books"));
                msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to_email));
                
                //메일 제목
                msg.setSubject("안녕하세요 KH BOOKS 인증 메일입니다.");
                //메일 내용
                msg.setText("인증 번호는 :"+temp);
                
                Transport.send(msg);
                System.out.println("이메일 전송");
                
            }catch (Exception e) {
                e.printStackTrace();// TODO: handle exception
            }
            HttpSession saveKey = request.getSession();
            saveKey.setAttribute("AuthenticationKey", AuthenticationKey);
            //패스워드 바꿀때 뭘 바꿀지 조건에 들어가는 id
            request.setAttribute("name", name);
            request.getRequestDispatcher("WEB-INF/views/login_myPage/searchPasswordEnd.jsp").forward(request, response);
	}
	
}
