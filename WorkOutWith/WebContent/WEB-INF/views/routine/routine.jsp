<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<title>Routine Page</title>
    <link rel="stylesheet" href="assets/css/routine.css"/>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="assets/CSS/styles.css" rel="stylesheet" />
        <link href="assets/CSS/routine.css" rel="stylesheet" />
        <link href="assets/CSS/index.css" rel="stylesheet" />
        
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
    <style>
        body {
            background-image: url(assets/img/routineBack.jpg);
            background-repeat : no-repeat;
            background-attachment : fixed;
            background-position : center;
           
        }
        .cover {
		height: 100vh;
		position: center;
		}
		.ruHead{	
			font-size:19px;
			color: rgb(130, 236, 144);
			position:absolute;
			top:200px;
			left:11px;
					
		}
		#testImg{
			position: relative;
			width: 180px;
			height: 354px;
			top:-700px;
			left:11px;
		}
		button.btn1{
			position: absolute;
			width: 30px;
			top: -90px;
			left: 11px; 
			background-color: rgba(0,0,0,0);
			border: rgba(0,0,0,0);
		}
		button.btn2{
			position: absolute;
			width: 30px;
			top: 30px;
			left: 90px;
			background-color: rgba(0,0,0,0);
			border: rgba(0,0,0,0);
		}
		button.btn3{
			position: absolute;
			width: 80px;
			top: -97px;
			left:50px;
			background-color: rgba(0,0,0,0);
			border: rgba(0,0,0,0);
		}
		button.btn4{
			position: absolute;
			width: 40px;
			top: -37px;
			left: 67px;
			background-color: rgba(0,0,0,0);
			border: rgba(0,0,0,0);
		}
		button.btn5{
			position: absolute;
			width: 30px;
			top: -90px;
			left: 135px;
			background-color: rgba(0,0,0,0);
			border: rgba(0,0,0,0);
		}
		.tbDiv{
			position: absolute;
			top: 300px;
			left: 500px;
			width: 500px;
			height: 300px;
			opacity: 0.92;
			
		}
		#ExrTb{
			width: 100%;
			height: 100%;
			border-width: 1.5px;
			background-color: rgb(60, 183, 199);
			border-color: rgb(188, 255, 133);
			border-style: solid;
			text-align: center;
		}
		
		th{
			width: 80px ;
			height: 30px;
		}
		
		tr td input{
			width: 80px;
			height: 30px;
			text-align: center;
		}
	
		.insertF1{
			background-color: blueviolet;
			font-weight: bolder;
			color: white;
			width: 980px;
			position: absolute;
			top: 300px;
			right: 30px;
			border-radius: 5%;
		}
		.insertF2{
			background-color: blueviolet;
			font-weight: bolder;
			color: white;
			width: 980px;
			position: absolute;
			top: 400px;
			right: 30px;
			border-radius: 5%;
		}
		.insertF3{
			background-color: blueviolet;
			font-weight: bolder;
			color: white;
			width: 980px;
			position: absolute;
			top: 500px;
			right: 30px;
			border-radius: 5%;
		}
		.insertF4{
			background-color: blueviolet;
			font-weight: bolder;
			color: white;
			width: 980px;
			position: absolute;
			top: 600px;
			right: 30px;
			border-radius: 5%;
		}

    </style>   
</head>
<body>

<script type="text/javascript">
	function openArm(){
		window.open("<%= request.getContextPath()%>/routineArm.jsp","Arm","width=410,height=240")
	}
	function openLeg(){
		window.open("<%= request.getContextPath()%>/routineLeg.jsp","Arm","width=410,height=240")
	}
	function openABS(){
		window.open("<%= request.getContextPath()%>/routineABS.jsp","Arm","width=410,height=240")
	}
	function openChest(){
		window.open("<%= request.getContextPath()%>/routineChest.jsp","Arm","width=410,height=240")
	}
	function sAT1(){
	     opener.document.getElementById("ah1").value = document.getElementById("a1").value
	   }
	   function sAT2(){
	     opener.document.getElementById("ah2").value = document.getElementById("a2").value
	   }
	   function sAT3(){
	     opener.document.getElementById("ah3").value = document.getElementById("a3").value
	   }

	function sCT1(){
	     opener.document.getElementById("ch1").value = document.getElementById("c1").value
	   }
	   function sCT2(){
	     opener.document.getElementById("ch2").value = document.getElementById("c2").value
	   }
	   function sCT3(){
	     opener.document.getElementById("ch3").value = document.getElementById("c3").value
	   }


	function sLT1(){
	     opener.document.getElementById("lh1").value = document.getElementById("l1").value
	   }
	   function sLT2(){
	     opener.document.getElementById("lh2").value = document.getElementById("l2").value
	   }
	   function sLT3(){
	     opener.document.getElementById("lh3").value = document.getElementById("l3").value
	   }

	function sABT1(){
	     opener.document.getElementById("abh1").value = document.getElementById("ab1").value
	   }
	   function sABT2(){
	     opener.document.getElementById("abh2").value = document.getElementById("ab2").value
	   }
	   function sABT3(){
	     opener.document.getElementById("abh3").value = document.getElementById("ab3").value
	   }

	

</script>
	<header>

	<%@ include file="../common/header_nav.jsp"%>


	</header>
<div>
	<br>
	<br>
	<div>
	</div>
	<br>
	<div class="ruHead" style=>
		<dl>
			<dt>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;????????? ????????? ???????????????</dt>
			<dd>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;-?????? ????????? ???????????? ?????? </dd>
		</dl>
	</div>
	</div>
<div>
	<br>
	<br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<span id="testImg">
		<img src="assets/img/human.png">
		<!-- ?????? -->
		<button class="btn1" onclick="openArm()">&nbsp;</button>
		<!-- ????????? -->
		<button class="btn2" onclick="openLeg()">&nbsp;</button>
		<!-- ????????? -->
		<button class="btn3" onclick="openChest()">&nbsp;</button>
		<!-- ????????? -->
		<button class="btn4" onclick="openABS()">&nbsp;</button>
		<!-- ???2??? -->
		<button class="btn5" onclick="openArm()">&nbsp;</button>
	</span>
	
	<form action="rouInsert.jsp" class="insertF1" method="post">
		<b style="font-style: italic; font-size: 1.5em; color:rgb(207, 252, 47);" >????????? ????????????</b>
		<br>
		?????? ??????: <input type="text" name="rouName" id="ah1">
		??????: <input type="text" name="exerNum" id="ah2">
		?????????(???): <input type="text" name="interv" id="ah3">
		
		<button class="btn btn-success" type="submit" id="goMyp">?????????????????? ??????</button>
		
	
	</form>


	<form action="rouInsert.jsp" class="insertF2" method="post">
		
		<b style="font-style: italic; font-size: 1.5em; color:rgb(207, 252, 47);" >???????????? ????????????</b>
		<br>
		?????? ??????: <input type="text" name="rouName" id="abh1">
		??????: <input type="text" name="exerNum" id="abh2">
		?????????(???): <input type="text" name="interv" id="abh3">
		
		<button class="btn btn-success" type="submit" id="goMyp">?????????????????? ??????</button>
		
	
	</form>


	<form action="rouInsert.jsp" class="insertF3" method="post">
		
		<b style="font-style: italic; font-size: 1.5em; color:rgb(207, 252, 47);" >???????????? ????????????</b>
		<br>
		?????? ??????: <input type="text" name="rouName" id="ch1">
		??????: <input type="text" name="exerNum" id="ch2">
		?????????(???): <input type="text" name="interv" id="ch3">
		
		<button class="btn btn-success" type="submit" id="goMyp">?????????????????? ??????</button>
		
	
	</form>


	<form action="rouInsert.jsp" class="insertF4" method="post">
		
		<b style="font-style: italic; font-size: 1.5em; color:rgb(207, 252, 47);" >???????????? ????????????</b>
		<br>
		?????? ??????: <input type="text" name="rouName" id="lh1">
		??????: <input type="text" name="exerNum" id="lh2">
		?????????(???): <input type="text" name="interv" id="lh3">
	
		<button class="btn btn-success" type="submit" id="goMyp">?????????????????? ??????</button>
		
	
	</form>
	





</div>
</div>
	<script src="assets/JS/routine.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
 	<script src="http://mattstow.com/experiment/responsive-image-maps/jquery.rwdImageMaps.min.js"></script>
 	
</body>
</html>