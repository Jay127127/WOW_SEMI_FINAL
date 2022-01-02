<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
<link rel="stylesheet" href="./assets/CSS/join.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<form name="join_form" id="join_form" action="join" method="post">
		<div class="join_bg">
			<div class="join_wrap">
				<div class="join_left">
					<div class="logo_text">
						<img src="./assets/login_img/logo_text.png" alt="">
					</div>
					<h2 class="join_title">회원가입</h2>
					<p class="join_text">기본 정보</p>
					<table>
						<colgroup>
							<col width="30%" />
							<col width="auto" />
						</colgroup>
						<tbody>
							<tr>
                                <th><span>아이디</span></th>
                                <td><input type="text" id="login_id" name="id" placeholder="아이디를 입력하세요.">
                                    <span class="condition"><button class="btn_Dup">중복확인</button> 영문 소문자/숫자, 4~16자</span></td>
                            </tr>
                            <tr>
                                <th><span>비밀번호</span></th>
                                <td><input type="password" id="login_pwd1" name="pwd1"  placeholder="비밀번호를 입력하세요.">
                                    <span class="condition">영문 대소문자/숫자, 4~16자</span></td>
                            </tr>
                            <tr>
                                <th><span>비밀번호 확인</span></th>
                                <td><input type="password" id="login_pwd2" name="pwd2"  placeholder="비밀번호를 입력하세요."></td>
                            </tr>
                            <tr>
                                <th><span>비밀번호 확인 질문</span></th>
                                <td>
                                    <select name="join_question" id="join_question" class="mini">
                                        <option value="place">기억에 남는 추억의 장소는?</option>
                                        <option value="treasure">나의 보물 1호는?</option>
                                        <option value="school">나의 출신 초등학교는?</option>
                                        <option value="hometown">나의 출신 고향은?</option>
                                        <option value="mother">어머니 성함은?</option>
                                        <option value="father">아버님 성함은?</option>
                                        <option value="color">가장 좋아하는 색깔은?</option>
                                        <option value="food">가장 좋아하는 음식은?</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <th><span>비밀번호 확인 답변</span></th>
                                <td><input type="text" placeholder="질문 답변을 입력하세요."></td>
                            </tr> 
                            <tr>
                                <th><span>이름</span></th>
                                <td><input type="text" name="name" placeholder="이름을 입력하세요."></td>
                            </tr>
                            <tr>
                                <th><span>주소</span></th>
                                <td><input type="text" name="address"  placeholder="주소를 입력하세요.">
                                <input type="text" name="detail_address"  placeholder="상세주소를 입력하세요."></td>
                            </tr>
                            <tr>
                                <th><span>이메일</span></th>
                                <td><input type="email" name="email"  placeholder="이메일을 입력하세요.">
                                <a href="javascript;;" class="btn_confirm">인증번호 발송</a></td>
                            </tr>
                            <tr>
                                <th><span>인증번호 확인</span></th>
                                <td><input type="text" class="send_number" placeholder="10:00"></td>
                            </tr>
                            <tr>
                                <th><span>닉네임</span></th>
                                <td><input type="text" name="nickname"  placeholder="닉네임을 입력하세요."></td>
                            </tr>
						</tbody>
					</table>
					<div class="require_txt">
						<span>표시는 필수적으로 입력해주셔야 가입이 가능합니다.&nbsp;</span>
					</div>
				</div>
				<div class="join_right">
					<h2 class="join_title">설문 조사</h2>
					<p class="join_text">추가 정보</p>
					<table>
						<colgroup>
							<col width="30%" />
							<col width="auto" />
						</colgroup>
						<tr>
                            <th><span>성별</span></th>
                            <td style="word-spacing: 50px;">
                                <label><input type="radio" name="question1" id="question1_1">남성</label>
                                <label><input type="radio" name="question1" id="question1_2">여성</label>
                            </td>
                        </tr>
                        <tr>
                            <th style="height: 93px; line-height: 75px;"><span>운동 경력</span></th>
                            <td>
                                <label><input type="radio" name="question3" id="question3_1">입문 - 이제 막 운동을 시작했어요</label><br>
                                <label><input type="radio" name="question3" id="question3_2">초급 - 운동을 조금은 해봤지만 잘은 몰라요</label><br>
                                <label><input type="radio" name="question3" id="question3_3">중급 - 1년이상 꾸준히 운동하고 있어요</label><br>
                                <label><input type="radio" name="question3" id="question3_4">고급 - 2~3년 이상 운동한 실력자에요</label><br>
                                <label><input type="radio" name="question3" id="question3_5">전문가 - 헬스장 관장님 or 프로 보디빌더에요</label>
                            </td>
                        </tr>
                        <tr>
                            <th><span>일주일 운동횟수</span></th>
                            <td>
                                <label><input type="radio" name="question4" id="question4_1">1회</label>
                                <label><input type="radio" name="question4" id="question4_2">2회</label>
                                <label><input type="radio" name="question4" id="question4_3">3회</label>
                                <label><input type="radio" name="question4" id="question4_4">4회</label>
                                <label><input type="radio" name="question4" id="question4_5">5회</label>
                                <label><input type="radio" name="question4" id="question4_6">6회</label>
                                <label><input type="radio" name="question4" id="question4_7">7회</label>
                            </td>
                        </tr>
                        <tr>
                            <th><span>선호하는 운동장소</span></th>
                            <td style="word-spacing: 50px;">
                                <label><input type="radio" name="question2" id="question2_1">헬스장</label>
                                <label><input type="radio" name="question2" id="question2_2">집</label>
                                <label><input type="radio" name="question2" id="question2_3">실외</label>
                            </td>
                        </tr>
                        <tr>
                            <th class="bb_question1"><span>선호하는 운동인원</span></th>
                            <td class="bb_question2" style="word-spacing: 50px;">
                                <label><input type="radio" name="question5" id="question2_1">개인</label>
                                <label><input type="radio" name="question5" id="question2_2">그룹</label>
                            </td>
                        </tr>
					</table>
					<div class="btn_wrap">
						<input type="submit" class="submit" value="가입하기">
					</div>
					<div class="lb_exit">
						<a href="./login" class="cancle" id="exit">
						<img src="./assets/login_img/xbtn.png"> 나가기</a>
					</div>
				</div>
			</div> <!-- join_wrap -->
		</div> <!-- join_bg -->
	</form>
</body>
</html>