<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WOW - 회원가입</title>
<link rel="stylesheet" href="./assets/CSS/join.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<link rel="stylesheet" href="https://paged.kr/theme/paged/skin/member/basic/style.css?v2"> <!-- 전체선택버튼 -->
</head>
<body>
	<form name="join_form" id="join_form" action="join" method="post" onsubmit="return fregister_submit(this)" autocomplete="off">
		<div class="join_bg">
			<div class="join_wrap">
				<div class="join_left">
					<div class="logo_text">
						<a href="home"><img src="./assets/login_img/logo_text.png" alt=""></a>
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
								<!-- 중복체크 여부 확인 -->
								<input type="hidden" id="check" name="check" value="f">
                                <th><span>아이디</span></th>
                                <td><input type="text" id="login_id" name="id" placeholder="아이디를 입력하세요.">
                                    <span class="condition">
                                    	<button type="button" id="dupCheck" class="btn_Dup">중복확인</button> 
                                    	영문 소문자/숫자, 4~16자</span></td>
                            </tr>
                            <tr>
                                <th><span>비밀번호</span></th>
                                <td><input type="password" id="login_pwd1" name="pwd1"  placeholder="비밀번호를 입력하세요.">
                                    <span class="condition">영문 대소문자/숫자/특수문자, 4~16자</span></td>
                            </tr>
                            <tr>
                                <th><span>비밀번호 확인</span></th>
                                <td><input type="password" id="login_pwd2" name="pwd2"  placeholder="비밀번호를 입력하세요."></td>
                            </tr>
                            <tr>
                                <th><span>비밀번호 확인 질문</span></th>
                                <td>
                                    <select name="join_question" id="join_question" class="mini">
                                        <option value="1">기억에 남는 추억의 장소는?</option>
                                        <option value="2">나의 보물 1호는?</option>
                                        <option value="3">나의 출신 초등학교는?</option>
                                        <option value="4">나의 출신 고향은?</option>
                                        <option value="5">어머니 성함은?</option>
                                        <option value="6">아버님 성함은?</option>
                                        <option value="7">가장 좋아하는 색깔은?</option>
                                        <option value="8">가장 좋아하는 음식은?</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <th><span>비밀번호 확인 답변</span></th>
                                <td><input type="text" name="join_answer" placeholder="질문 답변을 입력하세요."></td>
                            </tr> 
                            <tr>
                                <th><span>이름</span></th>
                                <td><input type="text" name="name" placeholder="이름을 입력하세요."></td>
                            </tr>
                            <tr>
                                <th><span>주소</span></th>
                                <td>
                                	<input type="text" id="postcode" name="postcode"  placeholder="우편번호">
                                		<span id="dupSpan"><button type="button" class="btn_Address" onclick="DaumPostcode()">주소찾기</button></span>
                                	<input type="text" id="address" name="address"  placeholder="주소">
                                	<input type="text" id="detail_address" name="detail_address"  placeholder="상세주소">
                                	<input type="text" id="extra_address" name="extra_address"  placeholder="참고항목">
                                </td>
                            </tr>
                            <tr>
                                <th><span>이메일</span></th>
                                <td><input type="email" name="email" id="email" placeholder="이메일을 입력하세요.">
                                <input type="button" name="btnEmailAuthNo" id="btnEmailAuthNo" class="btn_ct" value="인증번호 발송" onclick="sendAuthNoForEmailAuth();"></td>
                            </tr>
                            <tr>
                                <th><span>인증번호 확인</span></th>
                                <td>
                                	<input type="text" name="mailAuthNo" id="emailAuthNo" class="send_number" maxlength="6" placeholder="10:00" ><!--disabled -->
									<input type="button" id="certificationBtn" onClick="" value="인증하기" >                                
                                </td>
                                <input type="hidden" id="certificationYn" value="false">
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
                                <label><input type="radio" name="question1" value="남성">남성</label>
                                <label><input type="radio" name="question1" value="여성">여성</label>
                            </td>
                        </tr>
                        <tr>
                            <th style="height: 93px; line-height: 75px;"><span>운동 경력</span></th>
                            <td>
                                <label><input type="radio" name="question2" value="입문">입문 - 이제 막 운동을 시작했어요</label><br>
                                <label><input type="radio" name="question2" value="초급">초급 - 운동을 조금은 해봤지만 잘은 몰라요</label><br>
                                <label><input type="radio" name="question2" value="중급">중급 - 1년이상 꾸준히 운동하고 있어요</label><br>
                                <label><input type="radio" name="question2" value="고급">고급 - 2~3년 이상 운동한 실력자에요</label><br>
                                <label><input type="radio" name="question2" value="전문가">전문가 - 헬스장 관장님 or 프로 보디빌더에요</label>
                            </td>
                        </tr>
                        <tr>
                            <th><span>일주일 운동횟수</span></th>
                            <td>
                                <label><input type="radio" name="question3" value="1">1회</label>
                                <label><input type="radio" name="question3" value="2">2회</label>
                                <label><input type="radio" name="question3" value="3">3회</label>
                                <label><input type="radio" name="question3" value="4">4회</label>
                                <label><input type="radio" name="question3" value="5">5회</label>
                                <label><input type="radio" name="question3" value="6">6회</label>
                                <label><input type="radio" name="question3" value="7">매일</label>
                            </td>
                        </tr>
                        <tr>
                            <th><span>선호하는 운동장소</span></th>
                            <td style="word-spacing: 50px;">
                                <label><input type="radio" name="question4" value="gym">헬스장</label>
                                <label><input type="radio" name="question4" value="home">집</label>
                                <label><input type="radio" name="question4" value="outdoor">실외</label>
                            </td>
                        </tr>
                        <tr>
                            <th class="bb_question1"><span>선호하는 운동인원</span></th>
                            <td class="bb_question2" style="word-spacing: 50px;">
                                <label><input type="radio" name="question5" value="solo">개인</label>
                                <label><input type="radio" name="question5" value="group">그룹</label>
                            </td>
                        </tr>
					</table>
					<section id="fregister_term">
						<h2 style="font-size: 13px; text-align: left; padding-left:25px;">회원가입약관</h2>
						<textarea rows="5" cols="77" readonly>
■ 제 1조 (목적) 
이 약관은 전기통신 사업법 및 동 법 시행령에 의하여 웹사이팅(이하 &#034;회사&#034; 라 합니다.)이 제공하는 인터넷 홈페이지 서비스 페이지디 홈페이지 제작 서비스(이하 &#034;서비스&#034; 라 합니다.)의 이용조건 및 절차에 관한 사항, 회사와 이용자의 권리와 의무 및 책임사항을 규정함을 목적으로 합니다.
 

■ 제 2조 (약관의 효력과 개정) 
1. 이 약관은 전기통신사업법 제 31 조, 동 법 시행규칙 제 21조의 2에 따라 공시절차를 거친 후 홈페이지를 통하여 이를 공지하거나 전자우편 기타의 방법으로 이용자에게 통지함으로써 효력을 발생합니다.
2. 회사는 본 약관을 사전 고지 없이 개정할 수 있으며, 개정된 약관은 제9조에 정한 방법으로 공지합니다. 회원은 개정된 약관에 동의하지 아니하는 경우 본인의 회원등록을 취소(회원탈퇴)할 수 있으며, 계속 사용의 경우는 약관 개정에 대한 동의로 간주됩니다. 개정된 약관은 공지와 동시에 그 효력이 발생됩니다.
  

■ 제 3조 (약관이외의 준칙) 
이 약관에 명시되어 있지 않은 사항은 전기통신 기본법, 전기통신 사업법, 기타 관련법령의 규정에 따릅니다.
 
■ 제 4조 (용어의 정의) 
이 약관에서 사용하는 용어의 정의는 다음과 같습니다.
1. 회원 : 서비스에 개인정보를 제공하여 회원등록을 한 자로서, 서비스의 정보를 지속적으로 제공받으며, 이용할 수 있는 자를 말합니다. 
2. 이용자 : 본 약관에 따라 회사가 제공하는 서비스를 받는 회원 및 비회원을 말합니다.
3. 아이디 (ID) : 회원 식별과 회원의 서비스 이용을 위하여 회원이 선정하고 회사가 승인하는 문자와 숫자의 조합을 말합니다.  
4. 비밀번호 : 회원이 통신상의 자신의 비밀을 보호하기 위해 선정한 문자와 숫자의 조합을 말합니다.  
5. 전자우편 (E-mail) : 인터넷을 통한 우편입니다.  
6. 해지 : 회사 또는 회원이 서비스 이용 이후 그 이용계약을 종료 시키는 의사표시를 말합니다.  
7. 홈페이지 : 회사가 이용자에게 서비스를 제공하기 위하여 컴퓨터 등 정보통신설비를 이용하여 이용자가 열람 및 이용할 수 있도록 설정한 가상의 서비스 공간을 말합니다.
  

■ 제 5조 (서비스의 제공 및 변경)
1. 회사가 제공하는 서비스는 다음과 같습니다.
	① 회사에 대한 홍보 내용
	② 회사가 판매하는 제품 안내
	③ 기타 회사가 제공하는 각종 정보
	④ 고객 상담 서비스
	⑤ 회원 이용 서비스
2. 회사는 필요한 경우 서비스의 내용을 추가 또는 변경하여 제공할 수 있습니다.
  

■ 제 6조 (서비스의 중단) 
1. 회사는 컴퓨터 등 정보통신설비의 보수점검/교체 및 고장, 통신의 두절 등의 사유가 발생한 경우에는 서비스의 제공을 일시적으로 중단할 수 있습니다.
2. 제 1항에 의한 서비스 중단의 경우에는 제 9조에 정한 방법으로 이용자에게 통지합니다.
3. 회사는 제1항의 사유로 서비스의 제공이 일시적으로 중단됨으로 인하여 이용자 또는 제3자가 입은 손해에 대하여 배상하지 아니합니다. 단, 회사에 고의 또는 중과실이 있는 경우에는 그러하지 아니합니다.
  

■ 제 7조 (회원가입) 
1. 이용자는 회사가 정한 가입양식에 따라 회원정보를 기입한 후 이 약관에 동의한다는 의사표시를 함으로서 회원가입을 신청합니다.
2. 이용자는 반드시 실명으로 회원가입을 하여야 하며, 1개의 실명에 대해 1건의 회원가입신청을 할 수 있습니다.
3. 회사는 제 1항과 같이 회원으로 가입할 것을 신청한 이용자 중 다음 각 호에 해당하지 않는 한 회원으로 등록합니다.
	① 이름이 실명이 아닌 경우
	② 등록 내용에 허위, 기재누락, 오기가 있는 경우
	③ 타인의 명의를 사용하여 신청한 경우
	④ 가입신청자가 이 약관 제 8조 3항에 의하여 이전에 회원자격을 상실한 적이 있는 경우(단, 제 8조 3항에 의한 회원자격 상실 후 3년이 경과한 자로서 회사의 회원 재가입 승낙을 얻은 경우는 예외로 합니다.)
	⑤ 만 14세 미만의 아동
	⑥ 기타 회원으로 회사 소정의 이용신청요건을 충족하지 못하는 경우
4. 회원가입계약의 성립시기는 회사의 승낙이 이용자에게 도달한 시점으로 합니다.
5. 회원은 제 10조 1항에 의한 등록사항에 변경이 있는 경우 회원정보변경 항목을 통해 직접 변경사항을 수정, 등록하여야 합니다.
  

■ 제 8조 (회원탈퇴 및 자격 상실 등)
1. 회원은 언제든지 회원의 탈퇴를 홈페이지에 요청할 수 있으며, 홈페이지는 즉시 이에 응합니다.
2. 회원이 다음 각 호의 사유에 해당하는 경우, 회사는 회원자격을 제한 및 정지시킬 수 있습니다.
	① 가입 신청 시에 허위 내용을 등록한 경우 
	② 타인의 서비스 이용을 방해하거나 그 정보를 도용하는 등 서비스 운영질서를 위협하는 경우
	③ 서비스를 이용하여 법령과 이 약관이 금지하거나, 공서양속에 반하는 행위를 하는 경우
	④ 제 13조 에 명기된 회원의 의무사항을 준수하지 못할 경우
3. 회사가 회원자격을 제한/정지시킨 후, 동일한 행위가 2회 이상 반복되거나 30일 이내에 그 사유가 시정되지 아니하는 경우 회사는 회원자격을 상실 시킬 수 있습니다.
4. 회사가 회원자격을 상실 시키는 경우 회원에게 이를 통지하고 탈퇴를 처리합니다. 이 경우 회원에게 이를 통지하고, 탈퇴 전에 소명할 기회를 부여합니다.
 
 
■ 제 9조 (이용자에 대한 통지) 
1. 회사가 이용자에 대한 통지를 하는 경우, 이용자가 서비스에 제출한 전자우편 주소로 할 수 있습니다.
2. 회사가 불특정 다수 이용자에 대한 통지의 경우 1주일 이상 서비스 게시판에 게시함으로써 개별 통지에 갈음할 수 있습니다.
 
 
■ 제 10조 (개인 정보 보호) 
1. 회사는 이용자 정보 수집 시 회사측이 필요한 최소한의 정보를 수집합니다.
다음 사항을 필수사항으로 하며 그 외 사항은 선택사항으로 합니다.
	① 성명
	② 희망 ID
	③ 비밀번호
	④ E-mail
	⑤ 전화번호
	⑥ 이메일 구독 여부
2. 회사가 이용자의 개인식별이 가능한 개인정보를 수집하는 때에는 반드시 당해 이용자의 동의를 받습니다.
3. 제공된 개인정보는 당해 이용자의 동의 없이 제 3자에게 제공할 수 없으며, 이에 대한 모든 책임은 회사가 집니다. 다만 다음의 경우에는 예외로 합니다.
	① 회사는 관련법령 및 회사의 개인정보취급방침에 따라 회원의 개인정보를 수집 및 관리합니다.
	② 회원은 회사가 정하는 바에 따라 서비스 이용에 필요한 정보(개인정보 포함)를 사실에 부합하게 제공할 의무가 있으며, 허위의 사실을 기재하거나 타인명의를 도용하여 서비스를 신청한 경우 서비스 이용이 중단되거나 이용계약이 해지될 수 있습니다.
	③ 회사는 관련법률 규정에 의거 수사상 목적 등으로 국가기관의 요구가 있거나 방송통신위원회 및 한국인터넷진흥원 등의 요청이 있는 경우 관련 정보를 법률이 규정하는 범위 내에서 개인정보 등을 제공할 수 있습니다.
4. 이용자는 언제든지 회사가 가지고 있는 자신의 개인정보에 대해 열람 및 오류정정을 할 수 있습니다.
5. 회사로부터 개인정보를 제공받은 제 3자는 개인정보를 제공받은 목적을 달성한 때에는 당해 개인정보를 지체 없이 파기합니다.
 
 
■ 제 11조 (회사의 의무) 
1. 회사는 이 약관에서 정한 바에 따라 계속적, 안정적으로 서비스를 제공할 수 있도록 최선의 노력을 다하여야만 합니다.
2. 회사는 서비스에 관련된 설비를 항상 운용할 수 있는 상태로 유지/보수하고, 장애가 발생하는 경우 지체 없이 이를 수리/복구할 수 있도록 최선의 노력을 다하여야 합니다.
3. 회사는 이용자가 안전하게 서비스를 이용할 수 있도록 이용자의 개인정보보호를 위한 보안시스템을 갖추어야 합니다.
4. 회사는 이용자가 원하지 않는 영리목적의 광고성 전자우편을 발송하지 않습니다.
 
 
■ 제 12조 (회원의 ID 및 비밀번호에 대한 의무)
1. 회원에게 부여된 아이디(ID)와 비밀번호의 관리책임은 회원에게 있으며 관리 소홀, 부정사용에 의하여 발생하는 모든 결과에 대한 책임은 회원에게 있습니다.
 
2. 회원이 자신의 ID 및 비밀번호를 도난 당하거나 제 3자가 사용하고 있음을 인지한 경우에는 바로 회사에 통보하고 회사의 안내가 있는 경우에는 그에 따라야 합니다.
 
 
■ 제 13조 (회원의 의무) 
1. 회원은 관계법령, 본 약관의 규정, 이용안내 및 주의사항 등 회사가 통지하는 사항을 준수하여야 하며, 기타 회사의 업무에 방해되는 행위를 하여서는 안됩니다.
2. 회원은 회사의 사전승낙 없이 서비스를 이용하여 어떠한 영리행위도 할 수 없습니다.
3. 회원은 서비스를 이용하여 얻은 정보를 회사의 사전승낙 없이 복사, 복제, 변경, 번역, 출판/방송 기타의 방법으로 사용하거나 이를 타인에게 제공할 수 없습니다.
4. 회원은 자기 신상정보의 변경사항 발생시 즉각 변경하여야 합니다. 회원정보를 수정하지 않아 발생하는 모든 결과에 대한 책임은 회원에게 있습니다.
5. 회원은 서비스 이용과 관련하여 다음 각 호의 행위를 하지 않아야 하며, 다음 행위를 함으로 발생하는 모든 결과에 대한 책임은 회원에게 있습니다.
	① 다른 회원의 아이디(ID)를 부정하게 사용하는 행위
	② 다른 회원의 E-mail 주소를 취득하여 스팸메일을 발송하는 행위
	③ 범죄행위를 목적으로 하거나 기타 범죄행위와 관련된 행위
	④ 선량한 풍속, 기타 사회질서를 해하는 행위
	⑤ 회사 및 타인의 명예를 훼손하거나 모욕하는 행위
	⑥ 회사 및 타인의 지적재산권 등의 권리를 침해하는 행위
	⑦ 해킹행위 또는 컴퓨터 바이러스의 유포행위
	⑧ 타인의 의사에 반하여 광고성 정보 등 일정한 내용을 지속적으로 전송하는 행위
	⑨ 서비스의 안정적인 운영에 지장을 주거나 줄 우려가 있는 일체의 행위
	⑩ 회사가 제공하는 서비스의 내용을 변경하는 행위
	⑪ 기타 관계법령에 위배되는 행위
 

■ 제 14조 (게시물 삭제) 
1. 회사는 이용자가 게시하거나 등록하는 서비스내의 게시물이 제 13조의 규정에 위반되거나, 다음 각 호에 해당한다고 판단되는 경우 사전통지 없이 게시물을 삭제할 수 있습니다.
	① 다른 이용자 또는 제 3자를 비방하거나 중상모략으로 명예를 손상시키는 내용
	② 공공질서 또는 미풍양속에 위반되는 내용
	③ 범죄적 행위에 결부된다고 인정되는 내용
	④ 제 3자의 저작권 등 기타 권리를 침해하는 내용
	⑤ 서비스의 안정적인 운영에 지장을 주거나 줄 우려가 있는 내용
	⑥ 근거나 확인절차 없이 회사를 비난하거나 유언비어를 유포한 내용용
	⑦ 기타 관계법령에 의거하여 위반된다고 판단되는 내용
단, 독자게시판의 경우 다음과 같이 예외를 둔다.
용량이 큰 데이터의 경우 업로드 된 게시물의 수를 제한하며 그 수를 넘을 때에는 서버의 원활한 운영을 위해 가장 오래된 게시물부터 삭제할 수 있다.
2. 회사는 이용자가 게시하거나 등록하는 서비스내의 게시물이 제 13조의 규정에 위반되거나 동 조 제1항 각 호에 해당한다고 판단되는 정보를 링크하고 있을 경우 사전통지 없이 게시물을 삭제할 수 있습니다.
 
 
■ 제 15조 (게시물에 대한 권리 / 의무) 
게시물에 대한 저작권을 포함한 모든 권리 및 책임은 이를 게시한 이용자에게 있습니다.
 

■ 제 16조 (연결 &#034;홈페이지&#034;와 피연결 &#034;홈페이지&#034;간의 관계)
1. 상위 &#034;홈페이지&#034;와 하위 &#034;홈페이지&#034;가 하이퍼 링크(예:하이퍼 링크의 대상에는 문자, 그림 및 동화상 등이 포함됨) 방식 등으로 연결된 경우, 전자를 연결 &#034;홈페이지&#034;라고 하고 후자를 피연결 &#034;홈페이지(웹사이트)&#034;라고 합니다.
2. 연결 &#034;홈페이지&#034;는 피연결 &#034;홈페이지&#034;가 독자적으로 제공하는 재화ㆍ용역에 의하여 이용자와 행하는 거래에 대해서 보증책임을 지지 않습니다.
 
 
■ 제 17조 (저작권의 귀속 및 이용제한)
1. 회사가 작성한 저작물에 대한 저작권 및 기타 지적재산권은 회사에 귀속합니다.
2. 이용자는 서비스를 이용함으로써 얻은 정보를 회사의 사전승낙 없이 복제, 송신, 출판, 배포, 방송, 기타 방법에 의하여 영리목적으로 이용하거나 제 3자에게 이용하게 하여서는 안됩니다.
 
 
■ 제 18조 (양도금지) 
회원이 서비스의 이용권한, 기타 이용 계약상 지위를 타인에게 양도, 증여할 수 없으며, 이를 담보로 제공할 수 없습니다.
 

■ 제 19조 (손해배상) 
회사는 무료로 제공되는 서비스와 관련하여 이용자에게 어떠한 손해가 발생하더라도 동 손해가 회사의 중대한 과실에 의한 경우를 제외하고 이에 대하여 책임을 부여하지 아니합니다.
 

■ 제 20조 (면책 / 배상) 
1. 회사는 이용자가 서비스에 게재한 정보, 자료, 사실의 정확성, 신뢰성 등 그 내용에 관하여는 어떠한 책임을 부담하지 아니하고, 이용자는 자신의 책임아래 서비스를 이용하며, 서비스를 이용하여 게시 또는 전송한 자료 등에 관하여 손해가 발생하거나 자료의 취사선택, 기타 서비스 이용과 관련하여 어떠한 불이익이 발생하더라도 이에 대한 모든 책임은 이용자에게 있습니다.
2. 회사는 제 13조의 규정에 위반하여 이용자간 또는 이용자와 제 3자간에 서비스를 매개로 한 물품거래 등과 관련하여 어떠한 책임도 부담하지 아니하고, 이용자가 서비스의 이용과 관련하여 기대하는 이익에 관하여 책임을 부담하지 않습니다.
3. 이용자가 제 13조, 기타 이 약관의 규정을 위반함으로 인하여 회사가 이용자 또는 제 3자에 대하여 책임을 부담하게 되고, 이로써 회사에게 손해가 발생하게 되는 경우, 이 약관을 위반한 이용자는 회사에게 발생하는 모든 손해를 배상하여야 하며, 동 손해로부터 회사를 면책시켜야 합니다.
 
 
■ 제 21조 (분쟁의 해결) 
1. 회사와 이용자는 서비스와 관련하여 발생한 분쟁을 원만하게 해결하기 위하여 필요한 모든 노력을 하여야 합니다.
2. 제 1항의 규정에도 불구하고, 동 분쟁으로 인하여 소송이 제기될 경우 동 소송은 서울지방법원을 관할로 합니다.
3. 동 소송에는 대한민국 법을 적용합니다.

 
부칙 
(시행일) 이 약관은 2018년 2월 26일부터 시행됩니다.
2012 년 6 월 15일부터 시행되던 종래 약관은 본 약관으로 대체됩니다.</textarea>
						<fieldset class="fregister_agree" style="text-align: right; font-weight: bold; font-size: 14px; border: none; ">
							<label for="agree11">회원가입약관의 내용에 동의합니다.</label>
							<input type="checkbox" name="agree" value="1" id="agree11">
						</fieldset>
					</section>
					<section id="fregister_private">
						<h2 style="font-size: 13px; text-align: left; padding-left:25px; margin: 0;">개인정보처리방침안내</h2>
						<div style="padding: 8px 15px 0 15px;">
				            <table style="font-size: 12px;">
				                <thead>
									<tr style="border: 1px solid red; background-color: gray; color: white; font-weight: bold;">
										<td>목적</td>
										<td>항목</td>
										<td>보유기간</td>
									</tr>
				                </thead>
				                <tbody>
									<tr>
										<td>이용자 식별 및 본인여부 확인</td>
										<td>아이디, 이름, 비밀번호</td>
										<td>회원 탈퇴 시까지</td>
									</tr>
									<tr>
										<td>고객서비스 이용에 관한 통지,<br>CS대응을 위한 이용자 식별</td>
										<td>연락처 (이메일, 휴대전화번호)</td>
										<td>회원 탈퇴 시까지</td>
									</tr>
				                </tbody>
				            </table>
				        </div>
				        <fieldset class="fregister_agree" style="text-align: right; font-weight: bold; font-size: 14px; border: none;">
				            <label for="agree21">개인정보처리방침안내의 내용에 동의합니다.</label>
				            <input type="checkbox" name="agree2" value="1" id="agree21">
				        </fieldset>
					</section>
					<div id="fregister_chkall" style="padding-right: 15px; font-size: 12px;">
						<label><b>전체선택</b><input type="checkbox" name="chk_all" value="1" id="chk_all"></label>
					</div>					
					<div class="btn_wrap" style="margin-top: 0; margin-bottom: 0;">
						<input type="submit" class="submit" onclick="return validate();" value="가입하기">
					</div>
					<div class="lb_exit">
						<a href="./login" class="cancle" id="exit">
						<img src="./assets/login_img/xbtn.png"> 나가기</a>
					</div>
				</div>
			</div> <!-- join_wrap -->
		</div> <!-- join_bg -->
	</form>
	
	<!-- 회원가입 실패시 경고창 -->
	<c:if test="${ok eq '1'}">
	<script type = "text/javascript">
		var message = "${msg}";
		swal(message, "회원정보를 다시 입력해주세요", "warning");
    </script>
    </c:if>
	
	<script>
		// 중복체크 버튼
		$('#dupCheck').on('click', function(){
			$.ajax({
				url : '/wow/memberDupCheck',
				type : 'get',
				data : {
					id : $("#login_id").val()
				},
				success : function(data){
					swal("중복확인",data);
					$('#check').val('t');
					//아이디 정규표현식
					let regExp1 = /^[a-z0-9]{4,16}$/g;
					if(!(regExp1.test(document.join_form.id.value))){ 
						swal("중복확인 실패", "(영문 소문자/숫자, 4~16자)\n아이디를 정상적으로 입력해주세요.");
						document.join_form.id.focus();
						return false;
					}
				},
				error : function(err){
					swal("중복체크 오류");
					$('#check').val('f');
				}
			})
		})
		
		function fregister_submit(f)
	    {
			let regExp1 = /^[a-z0-9]{4,16}$/g;
			
			//아이디 체크
			if(!(regExp1.test(document.join_form.id.value))){ 
				swal("회원가입 실패", "(영문 소문자/숫자, 4~16자)\n아이디를 정상적으로 입력해주세요.");
				document.join_form.id.focus();
				return false;
			}
			//아이디 중복 체크
			if(document.join_form.check.value == "f"){
				swal("회원가입 실패", "아이디 중복확인을 해주세요.");
				document.join_form.id.focus();
				return false;
			}
			//비밀번호 체크
			let userPwd1 = document.join_form.pwd1.value;
			let userPwd2 = document.join_form.pwd2.value;
			let regExp2 = /^[\w!@#$%^&*-]{4,16}$/;
			
			if(!(regExp2.test(userPwd1))){ 
				swal("회원가입 실패", "(영문 대소문자/숫자/특수문자, 4~16자)\n비밀번호를 정상적으로 입력해주세요.");
				document.join_form.pwd1.focus();
				return false;
			} else if(userPwd1 !== userPwd2){
				//비밀번호 확인 체크
					swal("회원가입 실패", "비밀번호가 일치하지 않습니다.");
					document.join_form.pwd1.value = '';
					document.join_form.pwd2.value = '';
					document.join_form.pwd2.focus();
					return false;
			}
			//비밀번호 확인 질문,답변 체크
			if(document.join_form.join_answer.value == "" || document.join_form.join_answer.value.length < 0){ 
				swal("회원가입 실패", "비밀번호 확인 답변을 입력해주세요.");
				// history.back()
				document.join_form.join_answer.focus();
				return false;
			}
			//이름 체크
			let userName = document.join_form.name.value;
			let regExp3 = /^[가-힣]{2,}$/g;
			
			if(!(regExp3.test(userName))){ 
				swal("회원가입 실패", "이름을 정상적으로 입력해주세요.");
				document.join_form.name.focus();
				return false;
			}
			//주소 체크
			if(document.join_form.address.value == "" || document.join_form.address.value.length < 0){ 
				swal("회원가입 실패", "주소를 입력해주세요.");
				document.join_form.address.focus();
				return false;
			}
			//이메일 체크
			let email = document.join_form.email.value;
			let regExp4 = /^[\w]+@[\w]+\.[a-zA-Z\.]{2,6}$/;
			if(!(regExp4.test(email))){ 
				swal("회원가입 실패", "이메일을 정상적으로 입력해주세요.");
				document.join_form.email.focus();
				return false;
			}
			//이메일 인증번호 체크
			if(document.join_form.mailAuthNo.value == "" || document.join_form.mailAuthNo.value.length < 0){ 
				swal("회원가입 실패", "이메일 인증번호를 입력해주세요.");
				// history.back()
				document.join_form.mailAuthNo.focus();
				return false;
			}
			//닉네임 체크
			if(document.join_form.nickname.value == "" || document.join_form.nickname.value.length < 0){ 
				swal("회원가입 실패", "닉네임을 입력해주세요.");
				document.join_form.nickname.focus();
				return false;
			}
			if(!$('input:radio[name=question1]').is(":checked")){
				swal("회원가입 실패", "성별 항목을 선택해주세요.");
				return false;
			}
			if(!$('input:radio[name=question2]').is(":checked")){
				swal("회원가입 실패", "운동경력 항목을 선택해주세요.");
				return false;
			}
			if(!$('input:radio[name=question3]').is(":checked")){
				swal("회원가입 실패", "운동횟수 항목을 선택해주세요.");
				return false;
			}
			if(!$('input:radio[name=question4]').is(":checked")){
				swal("회원가입 실패", "운동장소 항목을 선택해주세요.");
				return false;
			}
			if(!$('input:radio[name=question5]').is(":checked")){
				swal("회원가입 실패", "운동인원 항목을 선택해주세요.");
				return false;
			}
			
	        if (!f.agree.checked) {
	            swal("회원가입 실패", "회원가입약관 내용에 동의해주세요.");
	            f.agree.focus();
	            return false;
	        }
	
	        if (!f.agree2.checked) {
	            swal("회원가입 실패", "개인정보처리방침안내 내용에 동의해주세요.");
	            f.agree2.focus();
	            return false;
	        }
	
	        return true;
	    }
	    
	    jQuery(function($){
	        // 약관 동의 모두선택
	        $("input[name=chk_all]").click(function() {
	            if ($(this).prop('checked')) {
	                $("input[name^=agree]").prop('checked', true);
	            } else {
	                $("input[name^=agree]").prop("checked", false);
	            }
	        });
	    });
	    
	    // 주소찾기 API
	    function DaumPostcode() {
	        new daum.Postcode({
	            oncomplete: function(data) {
	                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

	                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
	                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	                var addr = ''; // 주소 변수
	                var extraAddr = ''; // 참고항목 변수

	                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
	                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
	                    addr = data.roadAddress;
	                } else { // 사용자가 지번 주소를 선택했을 경우(J)
	                    addr = data.jibunAddress;
	                }

	                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
	                if(data.userSelectedType === 'R'){
	                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                        extraAddr += data.bname;
	                    }
	                    // 건물명이 있고, 공동주택일 경우 추가한다.
	                    if(data.buildingName !== '' && data.apartment === 'Y'){
	                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                    }
	                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	                    if(extraAddr !== ''){
	                        extraAddr = ' (' + extraAddr + ')';
	                    }
	                    // 조합된 참고항목을 해당 필드에 넣는다.
	                    document.getElementById("extra_address").value = extraAddr;
	                
	                } else {
	                    document.getElementById("extra_address").value = '';
	                }

	                // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                document.getElementById('postcode').value = data.zonecode;
	                document.getElementById("address").value = addr;
	                // 커서를 상세주소 필드로 이동한다.
	                document.getElementById("detail_address").focus();
	            }
	        }).open();
	    }
	</script>
</body>
</html>