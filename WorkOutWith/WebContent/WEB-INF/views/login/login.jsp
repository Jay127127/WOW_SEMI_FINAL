<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>WOW - �α���</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!-- alert ������ -->
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<title>�α��� ������</title>
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
				<div class="lb_text">�α��� �� �̿��ϼ���.</div>
				<div class="lb_login">
					<input type="text" name="id" maxlength="20" required="">
					<label>���̵�</label>
				</div>
				<div class="lb_login">
					<input type="password" name="pwd1" maxlength="20" required="">
					<label>��й�ȣ</label>
				</div>
				<div class="lb_btn">
					<input type="submit" class="login_btn" value="�α���">
				</div>
				<div class="lb_search_join">
					<a href="./search_id" id="search_id">���̵� ã��</a> <span>|</span> 
					<a href="./search_pwd" id="search_pwd">��й�ȣ ã��</a> <span>|</span> 
					<a href="./join" id="join" style="color: red;">ȸ������</a>
				</div>
				<div class="lb_exit">
					<a href="./home" class="cancle">
					<img src="./assets/login_img/xbtn.png"> ������</a>
				</div>
			</div> <!-- login_body -->
		</div> <!-- login_wrap -->
	</form>
	
	<c:set var="ok" value="${ok}"/>
	<c:if test="${ok eq '1'}">
	<script type = "text/javascript">
		var message = "${msg}";
		swal(message, "���̵�, ��й�ȣ�� �ٽ� �Է����ּ���", "warning");
    </script>
    <c:set var="ok" value="2"/>
    </c:if>
    
</body>
</html>