<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>WOW - 로그인</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!-- alert 디자인 -->
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<title>로그인 페이지</title>
<link rel="stylesheet" href="./assets/CSS/login.css">
</head>
<body>
	<form action="login" method="post" name="login_form" id="login_form">
		<div class="login_wrap" id="login_wrap">
			<div class="login_head">
				<div class="login_text">
					<a href="home"><img src="./assets/login_img/logo_text.png" alt=""></a>
				</div>
			</div>
			<div class="login_body">
				<div class="lb_title">LOGIN</div>
				<div class="lb_text">로그인 후 이용하세요.</div>
				<div class="lb_login">
					<input type="text" name="id" maxlength="20" required="">
					<label>아이디</label>
				</div>
				<div class="lb_login">
					<input type="password" name="pwd1" maxlength="20" required="">
					<label>비밀번호</label>
				</div>
				<div class="lb_btn">
					<input type="submit" class="login_btn" value="로그인">
				</div>
				<div class="lb_search_join">
					<a href="./search_id" id="search_id">아이디 찾기</a> <span>|</span> 
					<a href="./search_pwd" id="search_pwd">비밀번호 찾기</a> <span>|</span> 
					<a href="./join" id="join" style="color: red;">회원가입</a>
				</div>
				<div class="lb_exit">
					<a href="./home" class="cancle">
					<img src="./assets/login_img/xbtn.png"> 나가기</a>
				</div>
			</div> <!-- login_body -->
		</div> <!-- login_wrap -->
	</form>
	
	<c:set var="ok" value="${ok}"/>
	<c:if test="${ok eq '1'}">
	<script type = "text/javascript">
		var message = "${msg}";
		swal(message, "아이디, 비밀번호를 다시 입력해주세요", "warning");
    </script>
    <c:set var="ok" value="2"/>
    </c:if>
    
</body>
</html>