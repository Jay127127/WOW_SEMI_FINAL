<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>WorkOut With</title>

	<style>



header video {
  position: absolute;
  top: 50%;
  left: 50%;
  min-width: 100%;
  min-height: 100%;
  width: auto;
  height: auto;
  z-index: 0;
  -ms-transform: translateX(-50%) translateY(-50%);
  -moz-transform: translateX(-50%) translateY(-50%);
  -webkit-transform: translateX(-50%) translateY(-50%);
  transform: translateX(-50%) translateY(-50%);
}

#sec0{
  position: relative;
  z-index: 2;
  height:75%
}

header .overlay {
  position: absolute;
  top: 0;
  left: 0;
  height: 100%;
  width: 100%;
  background-color: black;
  opacity: 0.4;
  z-index: 2;
}

.loginDiv {
	z-index: 4;
}

/* Media Query for devices withi coarse pointers and no hover functionality */

/* This will use a fallback image instead of a video for devices that commonly do not support the HTML5 video element */

@media (pointer: coarse) and (hover: none) {

  header video {
    display: none;
  }
}

	</style>
</head>
<body>


<!-- ================ header ================ -->


<header>

	<!-- This div is  intentionally blank. It creates the transparent black overlay over the video which you can modify in the CSS -->
	<div class="overlay">

	</div>



	<!-- The HTML5 video element that will create the background video on the header -->
	<video playsinline="playsinline" autoplay="autoplay" muted="muted" loop="loop">
		<!-- <source src="https://storage.googleapis.com/coverr-main/mp4/Mt_Baker.mp4" type="video/mp4"> -->
		<source src="assets/img/indexpage.mp4" type="video/mp4">
	</video>


	<!-- -------------- navbar -------------- -->

	<%@ include file="common/header_nav.jsp"%>

	<!-- ------------ The header content ------------ -->

	<div class="container" id="sec0">
		<div class="d-flex h-100 text-center align-items-center" id="sec1">
			<div class="w-100 text-white">
				<p class="lead mb-0">Need any exercise buddy? </p>
				<h1 class="display-3">WorkOut With</h1>
				</div>
			</div>
		</div>
	</div>

</header>

<%-- <footer>

	<%@ include file="common/footer_home.jsp"%>

</footer> --%>

<!-- Page section example for content below the video header -->
<!-- <section class="my-5">
	<div class="container">
		<div class="row">
			<div class="col-md-8 mx-auto">
				<p>The HTML5 video element uses an mp4 video as a source. Change the source video to add in your own
					background! The header text is vertically centered using flex utilities that are built into
					Bootstrap.</p>
				<p>The overlay color and opacity can be changed by modifying the <code>background-color</code> and
					<code>opacity</code> properties of the <code>.overlay</code> class in the CSS.</p>
				<p>Set the mobile fallback image in the CSS by changing the background image of the header element
					within the media query at the bottom of the CSS snippet.</p>
				<p class="mb-0">
					Created by <a href="https://startbootstrap.com">Start Bootstrap</a>
				</p>
			</div>
		</div>
	</div>
</section> -->




<!-- === section === -->

</body>
</html>
