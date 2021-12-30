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
        <!-- 테이블 -->

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
                                    <div class="col-sm-3">
                                            <div class="align-self-center">
                                                <img src="assets/img/flower1.PNG" alt="" class="" width="100%" height="308px" style="background-position: center;">
                                            </div>
                                            <!-- <div class="align-self-center"></div> -->
                                            <div class="align-self-end">
                                                <input type="file" class="form-control-file border mt-3 w-100" name="" id="">
                                            </div>
                                        </div>

                                    <div class="col-sm-9">
                                        <form action="" method="post">
                                            <table class="table">
                                                <thead>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <th class="th-light" style="width:20%">아이디</th>
                                                        <td>adminSp</td>
                                                    </tr>
                                                    <tr>
                                                        <th>비밀번호</th>
                                                        <td>
                                                            <input type="password" name="" id="">
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <th>비밀번호 확인</th>
                                                        <td>
                                                            <input type="password" name="" id="">
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <th>이름</th>
                                                        <td>Dooley</td>
                                                    </tr>
                                                    <tr>
                                                        <th>닉네임</th>
                                                        <td>
                                                            <input type="text" name="" id="" value="호이호이">
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <th>담당</th>
                                                        <td>총책임자</td>
                                                    </tr>
                                                    <tr>
                                                        <th>이메일</th>
                                                        <td>Dooley@gmail.com</td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                            <button type="submit" class="btn bg-custom">수정하기</button>
                                        </form>
                                    </div>
                                </div>
                                <!-- <div class="row">

                                </div> -->
                            </div>
                        </div>
                    </div>
                </main>

	<%@ include file="footer_admin.jsp"%>  
</body>
</html>