<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>WOW - ���̵� ã��</title>
<link rel="stylesheet" href="./assets/CSS/search_id.css">
</head>
<body>
	<form name="search_id_form" id="search_id_form">
		<div class="search_id_wrap">
			<div class="search_id_head">
				<div class="search_id_text">
					<a href="home"><img src="./assets/login_img/logo_text.png" alt=""></a>
				</div>
			</div>
			<div class="search_id_body">
				<div class="lb_title">���̵�ã��</div>
				<div class="lb_text">ȸ�����Խ� �Է��Ͻ� ������ �Է��ϼ���.</div>
				<div class="lb_search_id">
					<input type="text" name="member_name" maxlength="20" required="">
					<label>�̸�</label>
				</div>
				<div class="lb_search_id">
					<input type="email" name="member_email" maxlength="25" required="">
					<label>�̸���</label>
					<button type="button" class="code_btn" onclick="location.href='email'">������ȣ ����</button>

				</div>
				<div class="lb_search_id">
					<input type="text" name="member_emailcode" maxlength="6" required=""> 
					<label>������ȣ 6�ڸ� ���� �Է�</label>
				</div>
				<div class="lb_btn">
					<button class="search_btn">ã��</button>
				</div>
				<div class="lb_search_join">
					<a href="./search_pwd" id="search_pwd">��й�ȣ ã��</a>
				</div>
				<div class="lb_exit">
					<a href="./login" class="cancle" id="exit">
					<img src="./assets/login_img/xbtn.png"> ������</a>
				</div>
			</div> <!-- search_id_body -->
		</div> <!-- search_id_wrap -->
	</form>
	
</body>
</html>