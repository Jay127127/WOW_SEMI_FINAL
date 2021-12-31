<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>로그인 페이지</title>
<link rel="stylesheet" href="./assets/CSS/login.css">
</head>
<body>
	<form name="login_form" id="login_form">
		<div class="login_wrap" id="login_wrap">
			<div class="login_head">
				<div class="login_text">
					<img src="./assets/login_img/logo_text.png" alt="">
				</div>
			</div>
			<div class="login_body">
				<div class="lb_title">LOGIN</div>
				<div class="lb_text">로그인 후 이용하세요.</div>
				<div class="lb_login">
					<input type="text" name="member_id" maxlength="20" required="">
					<label>아이디</label>
				</div>
				<div class="lb_login">
					<input type="password" name="member_pwd" maxlength="20" required="">
					<label>비밀번호</label>
				</div>
				<div class="lb_btn">
					<button class="login_btn">로그인</button>
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

	<script>
    </script>
</body>
</html>