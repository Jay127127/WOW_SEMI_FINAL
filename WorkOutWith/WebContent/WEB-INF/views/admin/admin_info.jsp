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

</head>
<body class="sb-nav-fixed">
	<%@ include file="nav_admin.jsp"%>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">관리자 정보 수정</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active"> </li>
                        </ol>
                        <div class="row">
                        </div>

                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                나의 정보
                            </div>
                            <div class="card-body">
                                <div class="row">

                                    <div class="col-sm-12">
                                        <form action="admin_info" method="post">
                                            <table class="table">
                                                <thead>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <th class="th-light" style="width:20%">아이디</th>
                                                        <td>${loginAdmin.admin_id}</td>
                                                    </tr>
                                                    <tr>
                                                        <th>비밀번호</th>
                                                        <td>
                                                            <input type="password" class="rqFill" name="admin_pwd1" id="inputPwd1">
                                                            <small id="pwdHelp1" class="form-text">영문자, 숫자, 특수문자 모두 포함하여 총 8~12자로 입력하시오.</small>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <th>비밀번호 확인</th>
                                                        <td>
                                                            <input type="password" class="rqFill" name="admin_pwd2" id="inputPwd2">
                                                            <small id="pwdHelp2" class="form-text">위의 비밀번호와 일치하게 입력하시오.</small>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <th>이름</th>
                                                        <td>${loginAdmin.admin_name}</td>
                                                    </tr>
                                                    <tr>
                                                        <th>닉네임</th>
                                                        <td>
                                                            <input type="text" class="rqFill" name="admin_nik" id="inputNick" value="${loginAdmin.admin_nik}">
                                                            <small id="nickHelp" class="form-text ">공백을 제외한 모든 문자 최대 8자를 입력하시오.</small>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <th>담당</th>
                                                        <td>${loginAdmin.admin_power_name}</td>
                                                    </tr>
                                                    <tr>
                                                        <th>이메일</th>
                                                        <td>
                                                        <input type="text" class="rqFill" name="admin_email" id="inputEmail" value="${loginAdmin.admin_email}">
                                                        <small id="emailHelp" class="form-text">이메일 형식에 맞춰서 입력하시오.</small>
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                            <button type="submit" id="updateBtn" class="btn bg-custom" onclick="return valid();">수정하기</button>
                                            <%-- location.href='/' --%>
                                            <%-- onclick="return valid();" --%>
                                        </form>
                                    </div>
                                </div>
                                <!-- <div class="row">

                                </div> -->
                            </div>
                        </div>
                    </div>
                </main>

    <%-- 유효성 검사 --%>
	<script type="text/javascript" src="assets/JS/admin_update.js"></script>

    <%-- 비밀번호 일치 검사 후 --%>
    <script type="text/javascript">

    let a= '유효한 비밀번호입니다.위의 비밀번호와 일치합니다.';
    let b = '유효한 이름입니다.유효한 이메일입니다.';
    let b1 = '공백을 제외한 모든 문자 최대 8자를 입력하시오.유효한 이메일입니다.';
    let b2 = '유효한 이름입니다.이메일 형식에 맞춰서 입력하시오.';
    let b3 = '공백을 제외한 모든 문자 최대 8자를 입력하시오.이메일 형식에 맞춰서 입력하시오.';
    // $('#updateBtn').on('click', function(){
    //     let err = false;
    //     $.ajax({
    //         url: 'wow/admin_info',
    //         type: 'post',
    //         async: false,
    //         traditional: true,
    //         data:{
    //             admin_pwd1: $('#admin_pwd1').val(),
    //             admin_pwd2: $('#admin_pwd2').val(),
    //             admin_nik: $('#admin_nik').val(),
    //             admin_email: $('#admin_email').val(),
    //         },
    //         success : function(msg){
    //             if(check == a+b || check == a+b1 || check == a+b2){
    //                 if(msg == "나의 정보가 수정되었습니다."){
    //                     swal("Good job!", msg, "success");
    //                     err = false;
    //                 }else{
    //                     swal("Nope!", msg, "error");
    //                     err = true;
    //             }
    //             }
    //         },
    //         error : function(err){
    //             swal("Error!", "서버 에러입니다.", "error");
    //         }
    //     });
    //     if(err){
    //         return false;
    //     }
    // })

    // $('#updateBtn').on('click', function(){

    // })
    // let check = "";
    function valid() {
        let check = $('.rqFill').siblings("small").text();
        if(check == a+b || check == a+b1 || check == a+b2 || check == a+b3){
            swal("Good job!", "나의 정보가 수정되었습니다.", "success");
            return true;
        } else{
            swal("Nope!", "사용가능한 값을 입력하시오.", "error");
            return false;
        }
    }


    </script>

	<%@ include file="footer_admin.jsp"%>
</body>
</html>
