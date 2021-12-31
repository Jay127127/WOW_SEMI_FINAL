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
        <title>AdminLogin</title>
        <!-- 테이블 -->
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="assets/CSS/styles.css" rel="stylesheet" />
        <link rel="stylesheet" href="assets/CSS/index.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
    <style>

        .auth-wrapper{
            min-height: 100vh;
            position: relative;
        }

        .auth-wrapper .auth-box{
            background-color: #fff;
            padding: 20px;
            max-width: 400px;
            width: 90%;
            margin: 10% 0;
        }

        .input-group-prepend{
            margin-right: -1px;
            display:flex;
        }

        .bg-custom:hover, .bg-custom:focus {
            background-color: rgb(121, 3, 29) !important;
        }

        .bg-custom, .bg-custom:focus, .bg-custom:hover{
            color: #fff;
        }

        .bg-cus-yellow{
            background-color: rgba(237, 181, 24);
        }


    </style>

</head>
<body>

    <div class="main-wrapper">
        <div class="auth-wrapper d-flex no-block justify-content-center align-items-center bg-dark">
            <div class="auth-box bg-dark border-top border-secondary">
                <div id="loginform">
                    <div class="text-center pb-4 pt-4">
                        <span class="db"><img src="assets/img/logoWith.png" alt="logo" width="60%" /></span>
                    </div>
                    <!-- Form -->
                    <form class="form-horizontal mt-3" id="loginform" action="admin_login" method="post">
                        <div class="row pb-4">
                            <div class="col-12">
                                <div class="input-group mb-4">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text bg-success text-white" id="basic-addon1">
                                            <i class="fas fa-user-circle"></i></span>
                                    </div>
                                    <input type="text" name="admin_id" class="form-control form-control-lg" placeholder="AdminId"
                                        aria-label="Username" aria-describedby="basic-addon1" required="">
                                </div>
                                <div class="input-group mb-4">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text bg-cus-yellow text-white" id="basic-addon2">
                                            <i class="fas fa-pencil-alt"></i></span>
                                    </div>
                                    <input type="text" name="admin_pwd" class="form-control form-control-lg" placeholder="Password"
                                        aria-label="Password" aria-describedby="basic-addon1" required="">
                                </div>
                            </div>
                        </div>
                        <div class="row border-top border-secondary">
                            <div class="col-12">
                                <div class="form-group">
                                    <div class="pt-4 text-center">
                                        <button class="btn bg-custom" type="submit">Login</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>

            </div>
        </div>

	</div>




        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="JS/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="assets/demo/chart-area-demo.js"></script>
        <script src="assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="JS/datatables-simple-demo.js"></script>

        <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
        <!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
            crossorigin="anonymous"></script> -->
</body>
</html>
    