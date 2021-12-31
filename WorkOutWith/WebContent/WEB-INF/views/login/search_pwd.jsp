<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기 페이지</title>
<link rel="stylesheet" href="./assets/CSS/search_pwd.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<form name="search_pwd_form" id="search_pwd_form">
		<div class="search_pwd_wrap">
			<div class="search_pwd_head">
				<div class="search_pwd_text">
					<img src="./assets/login_img/logo_text.png" alt="">
				</div>
			</div>
			<div class="search_pwd_body">
				<div class="lb_title">비밀번호찾기</div>
				<div class="lb_text">회원가입시 입력하신 정보를 입력하세요.</div>
				<div class="lb_search_pwd">
					<input type="eamil" name="member_email" maxlength="25" required="">
					<label>이메일</label>
				</div>
				<div class="lb_search_pwd">
					<label class="member_question"> &nbsp;질문&nbsp;&nbsp;&nbsp;|
						<select name="member_question" id="member_question"	class="minimal">
							<option value="place">기억에 남는 추억의 장소는?</option>
							<option value="treasure">나의 보물 1호는?</option>
							<option value="school">나의 출신 초등학교는?</option>
							<option value="hometown">나의 출신 고향은?</option>
							<option value="mother">어머니 성함은?</option>
							<option value="father">아버님 성함은?</option>
							<option value="color">가장 좋아하는 색깔은?</option>
							<option value="food">가장 좋아하는 음식은?</option>
						</select>
					</label>
				</div>
				<div class="lb_search_pwd">
					<input type="text" name="member_answer" required=""> 
					<label>질문 답변</label>
				</div>
				<div class="lb_btn">
					<button class="search_btn">찾기</button>
				</div>
				<div class="lb_search_join">
					<a href="./search_id" id="search_id">아이디 찾기</a>
				</div>
				<div class="lb_exit">
					<a href="./login" class="cancle" id="exit">
					<img src="./assets/login_img/xbtn.png"> 나가기</a>
				</div>
			</div> <!-- search_pwd_body -->
		</div> <!-- search_pwd_wrap -->
	</form>
</body>
</html>