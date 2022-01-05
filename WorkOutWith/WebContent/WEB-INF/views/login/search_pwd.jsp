<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WOW - ��й�ȣ ã��</title>
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
				<div class="lb_title">��й�ȣã��</div>
				<div class="lb_text">ȸ�����Խ� �Է��Ͻ� ������ �Է��ϼ���.</div>
				<div class="lb_search_pwd">
					<input type="eamil" name="member_email" maxlength="25" required="">
					<label>�̸���</label>
				</div>
				<div class="lb_search_pwd">
					<label class="member_question"> &nbsp;����&nbsp;&nbsp;&nbsp;|
						<select name="join_question" id="member_question"	class="minimal">
							<option value="1">��￡ ���� �߾��� ��Ҵ�?</option>
							<option value="2">���� ���� 1ȣ��?</option>
							<option value="3">���� ��� �ʵ��б���?</option>
							<option value="4">���� ��� ������?</option>
							<option value="5">��Ӵ� ������?</option>
							<option value="6">�ƹ��� ������?</option>
							<option value="7">���� �����ϴ� ������?</option>
							<option value="8">���� �����ϴ� ������?</option>
						</select>
					</label>
				</div>
				<div class="lb_search_pwd">
					<input type="text" name="join_answer" required=""> 
					<label>���� �亯</label>
				</div>
				<div class="lb_btn">
					<button type="submit" class="search_btn">ã��</button>
				</div>
				<div class="lb_search_join">
					<a href="./search_id" id="search_id">���̵� ã��</a>
				</div>
				<div class="lb_exit">
					<a href="./login" class="cancle" id="exit">
					<img src="./assets/login_img/xbtn.png"> ������</a>
				</div>
			</div> <!-- search_pwd_body -->
		</div> <!-- search_pwd_wrap -->
	</form>
	
	<c:if test="${ok eq '1'}">
	<script type = "text/javascript">
		var message = "${pwd}";
		swal("��й�ȣã�⼺��", "��й�ȣ : " + message, "success");
    </script>
    </c:if>
    <c:if test="${ok eq '2'}">
	<script type = "text/javascript">
		var message = "${pwd}";
		swal(message, "�ٽ� �Է����ּ���", "warning");
    </script>
    </c:if>
</body>
</html>