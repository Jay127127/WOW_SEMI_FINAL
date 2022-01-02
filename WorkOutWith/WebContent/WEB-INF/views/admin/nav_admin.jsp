<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>AdminWOW</title>
        <!-- 테이블 -->
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="assets/CSS/styles.css" rel="stylesheet" />
        
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
		<!-- jQuery -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <style>
        body {
            background-color: rgba(245, 247, 247, 1);
        }

        .card-header {
            background-color: rgba(237, 181, 24, .6);
            font-weight: bold;
        }

        /* PAGER */

.dataTable-pagination a {
	border: 1px solid transparent;
	float: left;
	margin-left: 2px;
	padding: 6px 12px;
	position: relative;
	text-decoration: none;
	color: #333;
}

.dataTable-pagination a:hover {
	background-color: rgba(121, 3, 29, 1);
}

.dataTable-pagination .active a,
.dataTable-pagination .active a:focus,
.dataTable-pagination .active a:hover {
	background-color: rgba(121, 3, 29, 1);
	cursor: default;
}


    /* table th */
    .table th{
        background-color:rgba(245, 247, 247, 1);
        text-align: center;
    }

    .bg-custom {
    background-color: rgba(121, 3, 29, 0.8) !important;
    border-color: rgba(121, 3, 29, 0.8);
    color: #fff;
}

.bg-custom:hover,
.navbar .bg-custom:focus {
    background-color: rgb(121, 3, 29) !important;
    color: #fff;
}
    </style>
</head>
<body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="home">
                <img src="assets/img/logoWith.png" alt="" style="width:90%">
            </a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
                <div class="">
                    <!-- <input class="form-control" type="text" placeholder="Search for..." aria-label="Search for..." aria-describedby="btnNavbarSearch" />
                    <button class="btn btn-primary" id="btnNavbarSearch" type="button"><i class="fas fa-search"></i></button> -->
                </div>
            </form>
            <!-- Navbar-->
            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="admin_info">Profile</a></li>
                        <li><hr class="dropdown-divider" /></li>
                        <li><a class="dropdown-item" href="logout">Logout</a></li>
                    </ul>
                </li>
            </ul>
        </nav>

        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">대시보드</div>
                            <a class="nav-link" href="admin">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                대시보드
                            </a>

                            <div class="sb-sidenav-menu-heading">관리자</div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                관리자 계정 관리
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="admin_create">관리자 생성</a>
                                    <a class="nav-link" href="admin_list">관리자 목록</a>
                                </nav>
                            </div>
                            <a class="nav-link" href="admin_info">
                                <div class="sb-nav-link-icon"><i class="fas fa-user-circle"></i></div>
                                관리자 정보 수정
                            </a>

                            <div class="sb-sidenav-menu-heading">회원</div>
                            <a class="nav-link" href="user_list">
                                <div class="sb-nav-link-icon"><i class="fas fa-box"></i></div>
                                회원 목록
                            </a>

                            <a class="nav-link" href="deal_req">
                                <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                                문의 관리
                            </a>

                            <a class="nav-link" href="deal_112">
                                <div class="sb-nav-link-icon"><i class="fas fa-exclamation-circle"></i></div>
                                신고 관리
                            </a>                           
                            
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">환영합니다</div>
                        <div style="font-weight: bold;">${loginAdmin.admin_name} 님!</div>
                    </div>
                </nav>
            </div>
            
            
            
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="assets/JS/scripts.js"></script>
 
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="assets/JS/datatables-simple-demo.js"></script>

        <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
        <!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
            crossorigin="anonymous"></script> -->
</body>
</html>