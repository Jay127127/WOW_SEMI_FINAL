<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Document</title>
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
		integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">

	<!-- jQuery -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


	<link rel="stylesheet" href="assets/CSS/index.css">
	
<style>

.s-cus-flex {
    display: flex;
}

/* --- viewAllChall --- */

.viewAllChall img {
    width: 50%;
}

/* --- carousel --- */

/* Make the image fully responsive */
.carousel-inner img {
    top: 0;
    left: 0;
    width: 100%;
    min-width: 100%;
    /* height: 100%; */
    /* min-height: 200px; */
    max-height: 233px;
    /* height: 100% */
}

.car0 {
    /* display: flex; */
    width: 40vw;
    min-width: 300px;
    max-width: 350px;
    /* height: 27vh; */
    align-self: end;
    /* margin-left: 30px; */
    margin-bottom: 50px;
    /* position: fixed;*/
    /* bottom: 50%; */
    /* left: 30px; */
    /* top: 5%; */
}


</style>
	
	

</head>
<body>


<footer>

	<div class="section s-cus-flex">

		<div class="car0">

			<div class="viewAllChall mb-3">
				<a href="#">
					<img src="assets/img/viewAllChall.png" alt="">
				</a>
			</div>

			<div id="demo" class="carousel slide" data-ride="carousel">
				<!-- Indicators -->
				<ul class="carousel-indicators">
					<li data-target="#demo" data-slide-to="0" class="active"></li>
					<li data-target="#demo" data-slide-to="1"></li>
					<li data-target="#demo" data-slide-to="2"></li>
				</ul>

				<!-- The slideshow -->
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="../resources/image/flower1.PNG" alt="Los Angeles" width="1100" height="500">
					</div>
					<div class="carousel-item">
						<img src="../resources/image/flower2.PNG" alt="Chicago" width="1100" height="500">
					</div>
					<div class="carousel-item">
						<img src="../resources/image/flower3.PNG" alt="New York" width="1100" height="500">
					</div>
				</div>

				<!-- Left and right controls -->
				<a class="carousel-control-prev" href="#demo" data-slide="prev">
					<span class="carousel-control-prev-icon"></span>
				</a>
				<a class="carousel-control-next" href="#demo" data-slide="next">
					<span class="carousel-control-next-icon"></span>
				</a>
			</div>
		</div>

</footer>


</body>
</html>