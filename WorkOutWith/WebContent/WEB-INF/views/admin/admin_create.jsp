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
                                <div class="row">
                                    <form method="post" action="">
                                        <fieldset>
                                            <legend></legend>
                                            <div class="form-group">
                                                <label for="exampleInputEmail1" class="form-label mt-4">아이디</label>
                                                <input type="text" class="form-control" id="input_id" aria-describedby="idHelp"
                                                    placeholder="알파벳맨처음+알파벳+숫자 몇자??">
                                                <small id="emailHelp" class="form-text text-muted">알파벳맨처음+알파벳+숫자 몇자??</small>
                                            </div>
                                            <div class="form-group">
                                                <label for="exampleInputPassword1" class="form-label mt-4">비밀번호</label>
                                                <input type="password" class="form-control" id="input_pwd1" placeholder="알파벳+숫자">
                                                <small id="pwdHelp" class="form-text text-muted">알파벳+숫자 몇자??</small>
                                            </div>
                                            <div class="form-group">
                                                <label for="exampleInputPassword1" class="form-label mt-4">비밀번호 확인</label>
                                                <input type="password" class="form-control" id="input_pwd2" placeholder="알파벳+숫자">
                                                <small id="pwdHelp" class="form-text text-muted">알파벳+숫자 몇자??</small>
                                            </div>
                                            <div class="form-group">
                                                <label for="exampleInputEmail1" class="form-label mt-4">이름</label>
                                                <input type="email" class="form-control" id="exampleInputEmail1"
                                                    placeholder="이름">
                                                <small id="emailHelp" class="form-text text-muted">한글</small>
                                            </div>
                                            <div class="form-group">
                                                <label for="exampleInputEmail1" class="form-label mt-4">닉네임</label>
                                                <input type="email" class="form-control" id="exampleInputEmail1"
                                                    placeholder="닉네임">
                                                <small id="emailHelp" class="form-text text-muted">한글||알파벳||숫자 몇자??</small>
                                            </div>
                                            <div class="form-group">
                                                <label for="exampleInputEmail1" class="form-label mt-4">이메일</label>
                                                <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                                                    placeholder="Enter email">
                                                <small id="emailHelp" class="form-text text-muted"></small>
                                            </div>
                                            <div class="form-group">
                                                <label for="exampleSelect1" class="form-label mt-4">담당</label>
                                                <select class="form-select" id="exampleSelect1">
                                                    <option>슈퍼 관리자</option>
                                                    <option>DB 관리자</option>
                                                    <option>형상 관리자</option>
                                                    <option>이슈 관리자</option>
                                                    <option>QA 관리자</option>
                                                </select>
                                            </div>
                                            <div class="form-group">
                                                <label for="formFile" class="form-label mt-4">프로필 사진</label>
                                                <input class="form-control" type="file" id="formFile">
                                            </div>
                                            <div>
                                                <br>
                                                <button type="submit" class="btn bg-custom">생성하기</button>
                                            </div>
                                        </fieldset>
                                    </form>
                                </div>

                            </div>
                        </div>
                    </div>
                </main>

	<%@ include file="footer_admin.jsp"%>  
</body>
</html>