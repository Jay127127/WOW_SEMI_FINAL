<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>City List</title>
</head>
<body>
<%
// POST 방식의 한글처리
request.setCharacterEncoding("UTF-8");

// 파라미터 정보 가져오기

String rouName = request.getParameter("rouName");
String exerNum = request.getParameter("exerNum");
String interv = request.getParameter("interv");


int lexerNum = Integer.parseInt(exerNum);
int linterv = Integer.parseInt(interv);


// JDBC 참조 변수 준비
Connection conn = null; 
PreparedStatement pstmt = null; 
String url = "jdbc:oracle:thin:@localhost:1521:xe";
String user = "wow", pw = "wow";

// 1) JDBC 드라이버 로딩
Class.forName("oracle.jdbc.OracleDriver");

// 2) DB연결(DB url, DB id, DB pw)
conn = DriverManager.getConnection(url, user, pw);

// 3) SQL문 준비
String sql = "INSERT INTO ROUTINE (ROU_NAME, EXER_NO, INTERV) VALUES (?, ?, ?)";

pstmt = conn.prepareStatement(sql);

pstmt.setString(1, rouName);
pstmt.setInt(2, lexerNum);
pstmt.setInt(3, linterv);


// 4) 실행
pstmt.executeUpdate();

// JDBC 자원 닫기
pstmt.close();
conn.close();
%>
<script>
alert("저장 성공!");
location.href = '/wow/routine';
</script>
</body>
</html>