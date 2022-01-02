<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>아이디 찾기 페이지</title>
<link rel="stylesheet" href="./assets/CSS/search_id.css">
</head>
<body>
	<form name="search_id_form" id="search_id_form">
		<div class="search_id_wrap">
			<div class="search_id_head">
				<div class="search_id_text">
					<img src="./assets/login_img/logo_text.png" alt="">
				</div>
			</div>
			<div class="search_id_body">
				<div class="lb_title">아이디찾기</div>
				<div class="lb_text">회원가입시 입력하신 정보를 입력하세요.</div>
				<div class="lb_search_id">
					<input type="text" name="member_name" maxlength="20" required="">
					<label>이름</label>
				</div>
				<div class="lb_search_id">
					<input type="email" name="member_email" maxlength="25" required="">
					<label>이메일</label>
					<button class="code_btn">인증번호 전송</button>

				</div>
				<div class="lb_search_id">
					<input type="text" name="member_emailcode" maxlength="6" required=""> 
					<label>인증번호 6자리 숫자 입력</label>
				</div>
				<div class="lb_btn">
					<button class="search_btn">찾기</button>
				</div>
				<div class="lb_search_join">
					<a href="./search_pwd" id="search_pwd">비밀번호 찾기</a>
				</div>
				<div class="lb_exit">
					<a href="./login" class="cancle" id="exit">
					<img src="./assets/login_img/xbtn.png"> 나가기</a>
				</div>
			</div> <!-- search_id_body -->
		</div> <!-- search_id_wrap -->
	</form>
	
</body>
</html>