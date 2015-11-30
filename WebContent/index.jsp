<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
	<head>
		<title>PhD admission</title>
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	</head>
	<body>
		<nav class="navbar navbar-inverse navbar-fixed-top" style="border">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#"><img src="logo.jpg" height="25" width="50"></a>
    </div>
  </div>
  </nav>
  <br><br><br>
  <div class="container-fluid">
  <ul class="nav nav-tabs">
  <li id ="tab1"><a>Personal Information</a></form></li>
  <li id="tab2"><a>Education Information</a></li>
  <li id="tab3"><a>Payment Information</a></li>
  <li id="tab4"><a>FeedBack</a></li>
  <li id="tab5"><a>Submit</a></li>
</ul>
</div>
<br>

<div class="col-lg-offset-1" id="t1" display="none">
  <%@ include file="/page1.jsp"%>
</div>

<div class="col-lg-offset-1" id="t2" display="none">
<%@ include file="/page2.jsp"%>
</div></div>

<div class="col-lg-offset-1" id="t3" display="none">
<%@ include file="/page3.jsp"%>
</div>

<div class="col-lg-offset-1" id="t4" display="none">
<%@ include file="/page4.jsp"%>
</div>

<div class="col-lg-offset-1" id="t5" display="block">
<%@ include file="/page5.jsp"%>
</div>

</body>
<script type="text/javascript">
  function makeActive(i){
    switch(i){
      case 1:
        $(tab1).addClass("active");
      break;
      case 2:
        $(tab2).addClass("active");
      break;
      case 3:
        $(tab3).addClass("active");
      break;
      case 4:
        $(tab4).addClass("active");
      break;
      case 5:
        $(tab5).addClass("active");
      break;
      default:
        consol.log("sorry bro!!!");
    }
  }
  function removeActive(i){
    switch(i){
      case 1:
        $(tab1).removeClass("active");
      break;
      case 2:
        $(tab2).removeClass("active");
      break;
      case 3:
        $(tab3).removeClass("active");
      break;
      case 4:
        $(tab4).removeClass("active");
      break;
      case 5:
        $(tab5).removeClass("active");
      break;
      default:
        consol.log("sorry bro!!!");
    }
  }
  function removeTab(i){
    switch(i){
      case 1:
        $("#t1").hide();
      break;
      case 2:
        $("#t2").hide();
      break;
      case 3:
        $("#t3").hide();
      break;
      case 4:
        $("#t4").hide();
      break;
      case 5:
        $("#t5").hide();
      break;
      default:
        consol.log("sorry bro!!!");
      }
  }
  function showTab(i){
    switch(i){
      case 1:
        $("#t1").show();
      break;
      case 2:
        $("#t2").show();
      break;
      case 3:
        $("#t3").show();
      break;
      case 4:
        $("#t4").show();
      break;
      case 5:
        $("#t5").show();
      break;
      default:
        consol.log("sorry bro!!!");
      }
  }
  var i=1;
  $(document).ready(function(){
    makeActive(1);

    i = 1;
    var tab1 = $("#tab1");
    var tab2 = $("#tab2");
    var tab3 = $("#tab3");
    var tab4 = $("#tab4");
    var tab5 = $("#tab5");
    var xhttp = new XMLHttpRequest();
    for(var j=1;j<6;j++)
      removeTab(j);
    showTab(i);
    $(tab1).click(function(){
      removeActive(i);
      removeTab(i);
      makeActive(1);
      showTab(1);
      i=1;
    });
    $(tab2).click(function(){
      removeActive(i);
      removeTab(i);
      makeActive(2);
      showTab(2);
      i=2;
    });
    $(tab3).click(function(){
      removeActive(i);
      removeTab(i);
      showTab(3);
      makeActive(3);
      i=3;
    });
    $(tab4).click(function(){
      removeActive(i);
      removeTab(i);
      showTab(4);
      makeActive(4);
      i=4;
    });
    $(tab5).click(function(){
      removeActive(i);
      removeTab(i);
      showTab(5);
      makeActive(5);
      i=5;
    });
    $("#chk1").click(function(){
      $("#chkDiv1").toggle();
    });
    $("#chk2").click(function(){
      $("#chkDiv2").toggle();
    });
    $("#chk3").click(function(){
      $("#chkDiv3").toggle();
    });
    $("#chk4").click(function(){
      $("#chkDiv4").toggle();
    });


  });
</script>
</html>