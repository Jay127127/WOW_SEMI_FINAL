<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WOW - 비밀번호 찾기</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="./assets/CSS/search_pwd.css">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<form action="search_pwd" method="post" name="search_pwd_form" id="search_pwd_form">
		<div class="search_pwd_wrap">
			<div class="search_pwd_head">
				<div class="search_pwd_text">
					<a href="home"><img src="./assets/login_img/logo_text.png" alt=""></a>
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
						<select name="join_question" id="member_question"	class="minimal">
							<option value="1">기억에 남는 추억의 장소는?</option>
							<option value="2">나의 보물 1호는?</option>
							<option value="3">나의 출신 초등학교는?</option>
							<option value="4">나의 출신 고향은?</option>
							<option value="5">어머니 성함은?</option>
							<option value="6">아버님 성함은?</option>
							<option value="7">가장 좋아하는 색깔은?</option>
							<option value="8">가장 좋아하는 음식은?</option>
						</select>
					</label>
				</div>
				<div class="lb_search_pwd">
					<input type="text" name="join_answer" required=""> 
					<label>질문 답변</label>
				</div>
				<div class="lb_btn">
					<button type="submit" class="search_btn">찾기</button>
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
	
	<c:if test="${ok eq '1'}">
	<script type = "text/javascript">
		var message = "${pwd}";
		swal("비밀번호찾기성공", "비밀번호 : " + message, "success");
    </script>
    </c:if>
    <c:if test="${ok eq '2'}">
	<script type = "text/javascript">
		var message = "${pwd}";
		swal(message, "다시 입력해주세요", "warning");
    </script>
    </c:if>
</body>
</html>