<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>AdminWOW</title>

    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

    <style>
    .form-label{
        font-weight: bold;
    }

    </style>

</head>
<body class="sb-nav-fixed">
	<%@ include file="nav_admin.jsp"%>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">관리자 생성</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active"> </li>
                        </ol>
                        <div class="row">
                        </div>

                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                계정 생성
                            </div>
                            <div class="card-body">
                                <div class="row px-3 pb-4">
                                    <form method="post" action="admin_create">
                                        <fieldset>
                                            <legend></legend>
                                            <div class="form-group">
                                                <label for="inputId" class="form-label mt-4">아이디</label>
                                                <input type="text" name="aId" class="form-control" id="inputId" aria-describedby="idHelp"
                                                    placeholder="Wowadmin + 숫자4자리" required>
                                                <small id="idHelp" class="form-text">Wowadmin + 숫자4자리로 입력하시오.</small>
                                                <div class="mt-2">
                                                    <button type="button" id="dupCheck" class="btn btn-sm bg-custom rqFill">중복확인</button>
                                                    <small id="dupHelp" class="form-text"></small>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="inputPwd1" class="form-label mt-4">비밀번호</label>
                                                <input type="password" name="aPwd" class="form-control rqFill" id="inputPwd1" placeholder="영문자, 숫자, 특수문자 모두 포함 총 8~12자" required>
                                                <small id="pwdHelp1" class="form-text">영문자, 숫자, 특수문자 모두 포함하여 총 8~12자로 입력하시오.</small>
                                            </div>
                                            <div class="form-group">
                                                <label for="inputPwd2" class="form-label mt-4">비밀번호 확인</label>
                                                <input type="password" name="" class="form-control rqFill" id="inputPwd2" placeholder="위의 비밀번호와 일치하게 입력하시오." required>
                                                <small id="pwdHelp2" class="form-text">위의 비밀번호와 일치하게 입력하시오.</small>
                                            </div>
                                            <div class="form-group">
                                                <label for="inputName" class="form-label mt-4">이름</label>
                                                <input type="text" name="aName" class="form-control rqFill" id="inputName"
                                                    placeholder="한글로 2글자 이상" required>
                                                <small id="namelHelp" class="form-text">한글로만 이루어져야 되며 2~6자를 입력하시오.</small>
                                            </div>
                                            <div class="form-group">
                                                <label for="inputNick" class="form-label mt-4">닉네임</label>
                                                <input type="text" name="aNick" class="form-control rqFill" id="inputNick"
                                                    placeholder="공백 제외 모든 문자 최대 8자" required>
                                                <small id="nickHelp" class="form-text ">공백을 제외한 모든 문자 최대 8자를 입력하시오.</small>
                                            </div>
                                            <div class="form-group">
                                                <label for="inputEmail" class="form-label mt-4">이메일</label>
                                                <input type="email" name="aEmail" class="form-control rqFill" id="inputEmail" aria-describedby="emailHelp"
                                                    placeholder="예) dooley@gmail.com" required>
                                                <small id="emailHelp" class="form-text">이메일 형식에 맞춰서 입력하시오.</small>
                                            </div>
                                            <div class="form-group">
                                                <label for="selectPow" class="form-label mt-4">담당</label>
                                                <select class="form-select" name="aPower" id="selectPow" required>
                                                    <%-- <option value="S0">슈퍼 관리자</option> --%>
                                                    <option value="" selected >-----담당을 선택하세요.-----</option>
                                                    <option value="D0">DB 관리</option>
                                                    <option value="C1">CS1</option>
                                                    <option value="C2">CS2</option>
                                                    <option value="MR">유지보수</option>
                                                </select>
                                                <%-- <small id="powHelp" class="form-text"></small> --%>
                                            </div>
                                            <div>
                                                <br>
                                                <button type="submit" id="createBtn" class="btn bg-custom" onclick="return validate();">생성하기</button>
                                            </div>
                                        </fieldset>
                                    </form>
                                </div>

                            </div>
                        </div>
                    </div>
                </main>


    <%-- 유효성 검사 --%>
	<script type="text/javascript" src="assets/JS/admin_create.js"></script>

    <%-- 어드민 id 중복 검사 --%>
    <script type="text/javascript">
    $('#dupCheck').on('click', function(){
        if($('#idHelp').html() != "유효한 아이디입니다."){
            swal("Nope!", "유효한 아이디를 입력하세요.", "error");
            $('#dupHelp').html("");
        } else{
            $.ajax({
                url: '/wow/adminDupCheck',
                type: 'get',
            //서버측에 전달할 데이터
                data: {
                    id: $('#inputId').val()
                },
            }).done(function(msg){
                if(msg == "사용가능한 계정입니다."){
                    swal("Good job!", msg, "success");
                    $('#dupHelp').html("사용가능한 계정입니다.");
                    $('#dupHelp').css('color', '#008d62');
                } else{
                    swal("Nope!", msg, "error");
                    $('#dupHelp').html("중복된 계정입니다.");
                    $('#dupHelp').css('color', '#dc143c');
                }
            }).fail(function(err) {
                swal("Error!", "서버 에러입니다.", "error");
            })
            $('#inputId').focus();
        }
    })

    // 담당 선택해야함
    // ** 모든 곳을 만족해야 넘어가게
    function validate() {
        let powHelp = document.getElementById("powHelp");
        let check = $(".rqFill").siblings("small").text();
        if ($("#selectPow option:selected").val() == "") {
            swal("Nope!", "담당을 선택하세요.", "error");
            return false;
        } else {
            if (
                check !=
                "사용가능한 계정입니다.유효한 비밀번호입니다.위의 비밀번호와 일치합니다.유효한 이름입니다.유효한 이름입니다.유효한 이메일입니다."
                )
            {
                swal("Nope!", "사용가능한 값을 입력하시오.", "error");
                return false;
            } else{
                // swal("Good job!", "계정 생성 성공!!!!", "success");
                return true;
            }
        }
    }

    </script>


	<%@ include file="footer_admin.jsp"%>
</body>
</html>
