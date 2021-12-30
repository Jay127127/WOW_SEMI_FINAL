
//팝업창 열기

function openArmEdit(){
   window.open('rutin_Arm.html','Arm','width=720,height=310,resizable=no');
}
function openABSEdit(){
 window.open('rutin_ABS.html','ABS','width=720,height=310,resizable=no ');
}
function openChestEdit(){
window.open('rutin_Chest.html','Chest','width=720,height=310,resizable=no ');
}
function openLegEdit(){
window.open('rutin_Leg.html','Leg','width=720,height=310,resizable=no ');
}

//팝업에서 값 가져오기


//setArmText

function sAT1(){
    opener.document.getElementById("aPart1").value = document.getElementById("aP1").value
}
function sAT2(){
    opener.document.getElementById("aPart2").value = document.getElementById("aP2").value
}
function sAT3(){
    opener.document.getElementById("aPart3").value = document.getElementById("aP3").value
}
function sAT4(){
    opener.document.getElementById("aNum1").value = document.getElementById("aN1").value
}
function sAT5(){
    opener.document.getElementById("aNum2").value = document.getElementById("aN2").value
}
function sAT6(){
    opener.document.getElementById("aNum3").value = document.getElementById("aN3").value
}
function sAT7(){
    opener.document.getElementById("aIn1").value = document.getElementById("aI1").value
}
function sAT8(){
    opener.document.getElementById("aIn2").value = document.getElementById("aI2").value
}
function sAT9(){
    opener.document.getElementById("aIn3").value = document.getElementById("aI3").value
}

//setLegText

function sLT1(){
  opener.document.getElementById("lPart1").value = document.getElementById("lP1").value
}
function sLT2(){
  opener.document.getElementById("lPart2").value = document.getElementById("lP2").value
}
function sLT3(){
  opener.document.getElementById("lPart3").value = document.getElementById("lP3").value
}
function sLT4(){
  opener.document.getElementById("lNum1").value = document.getElementById("lN1").value
}
function sLT5(){
  opener.document.getElementById("lNum2").value = document.getElementById("lN2").value
}
function sLT6(){
  opener.document.getElementById("lNum3").value = document.getElementById("lN3").value
}
function sLT7(){
  opener.document.getElementById("lIn1").value = document.getElementById("lI1").value
}
function sLT8(){
  opener.document.getElementById("lIn2").value = document.getElementById("lI2").value
}
function sLT9(){
  opener.document.getElementById("lIn3").value = document.getElementById("lI3").value
}