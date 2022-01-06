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
<style type="text/css">
.form-select{
	display: inline !important;
}

.pagination *{
	color: #333 !important;
}

.pagination *:hover{
	color: #fff !important;
	background-color: rgba(121, 3, 29, 0.8) !important;
}

.pagination> .active *{
    background-color: rgba(121, 3, 29, 0.8) !important;
    border-color: rgba(121, 3, 29, 0.8) !important;
    color: #fff !important;
}

.bg-custom {
    background-color: rgba(121, 3, 29, 0.8) !important;
    border-color: rgba(121, 3, 29, 0.8);
    color: #fff;
}

.bg-custom:hover,
.navbar .bg-custom:focus,
.pagination> .active *:hover
{
    background-color: rgb(121, 3, 29) !important;
    color: #fff;
}
</style>
</head>
<body class="sb-nav-fixed">


	<%@ include file="nav_admin.jsp"%>

            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">대시보드</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active"> </li>
                        </ol>
                        <div class="row">

                        </div>
                       <%--  <div class="mb-4">
                            <div class="card mb-4">
                                <div class="card-header">
                                    <i class="fas fa-chart-area me-1"></i> 주간 방문자
                                </div>
                                <div class="card-body row">
                                    <div class="col-lg-8">

                                    <div>

                                    	<form id="todo-form">
                                        <input type="text" placeholder="Write a To Do and Press Enter" required>
                                        </form>
                                        <ul id="todo-list"></ul>
                                    </div>



                                        <canvas id="myAreaChart" width="100%" height="50"></canvas>
                                    </div>
                                    <!-- 옆에 아이콘들 -->
                                    <div class="col-lg-4">
                                            <div class="row">
                                                <div class="col-6">
                                                    <div class="bg-dark p-3 text-white text-center">
                                                        <i class="fa fa-plus mb-1 fs-2"></i>
                                                        <h5 class="mb-3 mt-3">12</h5>
                                                        <small class="font-light">오늘<br> 신규회원</small>
                                                    </div>
                                                </div>
                                                <div class="col-6">
                                                    <div class="bg-dark p-3 text-white text-center">
                                                        <i class="fa fa-users mb-1 fs-2"></i>
                                                        <h5 class="mb-3 mt-3">${c}</h5>
                                                        <small class="font-light">총<br> 회원</small>
                                                    </div>
                                                </div>
                                                <div class="col-6 mt-4">
                                                    <div class="bg-dark p-3 text-white text-center">
                                                        <i class="fa fa-coffee mb-1 fs-2"></i>
                                                        <h5 class="mb-3 mt-3">120</h5>
                                                        <small class="font-light">오늘<br>방문자</small>
                                                    </div>
                                                </div>
                                                <div class="col-6 mt-4">
                                                    <div class="bg-dark p-3 text-white text-center">
                                                        <i class="fa fa-comments mb-1 fs-2"></i>
                                                        <h5 class="mb-3 mt-3">120</h5>
                                                        <small class="font-light">주간<br>트래픽</small>
                                                    </div>
                                                </div>
                                            </div>
                                    </div>
                                </div>
                            </div>
                        </div> --%>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                문의 처리 목록
                            </div>
                            <div class="card-body">

		                        <div class="container-fluid px-4"><br>

		                        <form method="get" action="deal_req">
		                        <div class="">
		                        <select class="form-select" name="searchType" style="width:150px">
		                            <option value="boardNo">문의번호</option>
		                            <option value="boardDate">날짜</option>
		                            <option value="userId">아이디</option>
		                            <option value="boardTitle">제목</option>
		                            <%-- <option value="admin_power_name">담당자</option> --%>
		                            <option value="dealEnq">처리여부</option>
		                        </select>

		                        <input type="text" name="searchValue" id="">
		                        <input type="submit" class="btn bg-custom btn-sm" value="검색">
		                        </div>
		                        </form><br>

		                        <table class="table table-hover table-bordered">
		                        <thead>
		                        <tr align="left">
		                            <th>#</th>
		                            <th>문의번호</th>
		                            <th>아이디</th>
		                            <th>제목</th>
		                            <th>날짜</th>
		                            <th>링크</th>
		                            <%-- <th>담당자</th> --%>
		                            <th>처리여부(Y/N)</th>
		                        </tr>
		                        </thead>
		                        <tbody>
		                        <c:forEach items="${boardList}" var="a">
		                            <tr>
		                                <td align="center">${a.rNum}</td>
		                                <td align="center" class="bn">${a.boardNo}</td>
		                                <td>${a.userId}</td>
		                                <td>${a.boardTitle}</td>
		                                <td>${a.boardDate}</td>
										<td align="center"><a class="fas fa-link"></a></td>
			                            <td align="center" class="ud">
											${a.dealEnq} &ensp;
											<a class="upEn"><i class="fas fa-pen-square"></i></a>
										</td>
		                            </tr>
		                        </c:forEach>
		                        </tbody>
		                        </table>


		                    <ul class="pagination justify-content-center">
				                <c:choose>
				                    <c:when test="${!empty type && !empty value}">
					                    <li class="page-item" id=""><a class="page-link" id="pp" href="deal_req?searchType=${type}&searchValue=${value}&currentPage=${prevPage}">prev</a></li>
					                        <c:forEach var='i' begin="${startPage}" end="${maxPage}">
					                        	<c:if test="${i le maxPage}">
					                        	<li class="page-item liPi" id=""><a class="page-link iPi" id="" href="deal_req?searchType=${type}&searchValue=${value}&currentPage=${i}">${i}</a></li>
					                        	</c:if>
					                        </c:forEach>
					                    <li class="page-item" id=""><a class="page-link" id="np" href="deal_req?searchType=${type}&searchValue=${value}&currentPage=${nextPage}">next</a></li>
				                    </c:when>
				                    <c:otherwise>
					                    <li class="page-item" id=""><a class="page-link" id="pp" href="deal_req?currentPage=${prevPage}">prev</a></li>
					                        <c:forEach var='i' begin="${startPage}" end="${maxPage}">
					                        	<c:if test="${i le maxPage}">
					                        	<li class="page-item liPi" id=""><a class="page-link iPi" id="" href="deal_req?currentPage=${i}">${i}</a></li>
					                        	</c:if>
					                        </c:forEach>
					                    <li class="page-item" id=""><a class="page-link" id="np" href="deal_req?currentPage=${nextPage}">next</a></li>
				                    </c:otherwise>
				                </c:choose>
				            </ul>

		                         </div>
                        	</div>
                    	</div>
                    </div>
                </main>
	<%@ include file="footer_admin.jsp"%>

            </div>
        </div>
<!--    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="assets/demo/chart-area-demo.js"></script>
        <script src="assets/demo/chart-bar-demo.js"></script> -->
</body>
</html>
