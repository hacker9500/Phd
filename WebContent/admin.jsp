<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
    <head>
        <title>
            Welcome to Admin-Portal
        </title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    </head>
    <body>
        <h1>Filter Enteries</h1>
         <div class="container-fluid">
             <ul class="nav nav-tabs">
                 <li id="t1"><a>Personal Information</a></li>
                 <li id="t2"><a>Education Information</a></li>
                 <li id="t3"><a>Submit</a></li>
            </ul>
        </div>
        <br>
    <form action="filter" method="post">
    <div id="tab1" style="display:none">
        <%@ include file="/admin1.jsp" %>
    </div>
    <div id="tab2" style="display:none">
        <%@ include file="/admin2.jsp" %>
    </div>
    <div id="tab3" style="display:none">
        <%@ include file="/admin3.jsp" %>
    </div>
    </form>
    </body>
    <script type="text/javascript">
        function showTab(i){
            switch(i){
                case 1:
                    $("#tab1").show();
                break;
                case 2:
                    $("#tab2").show();
                break;
                case 3:
                    $("#tab3").show();
                break;
                default:
            }
        }
        function removeTab(i){
            switch(i){
                case 1:
                    $("#tab1").hide();
                break;
                case 2:
                    $("#tab2").hide();
                break;
                case 3:
                    $("#tab3").hide();
                break;
                default:
            }
        }
        function addActive(i){
            switch(i){
                case 1:
                    $("#t1").addClass("active");
                break;
                case 2:
                    $("#t2").addClass("active");
                break;
                case 3:
                    $("#t3").addClass("active");
                break;
                default:
            }
        }
        function removeActive(i){
            switch(i){
                case 1:
                    $("#t1").removeClass("active");
                break;
                case 2:
                    $("#t2").removeClass("active");
                break;
                case 3:
                    $("#t3").removeClass("active");
                break;
                default:
            }
        }

        $(document).ready(function(){
            var selectedTab = 1;
            for(var j=1;j<4;j++){
                removeTab(j);
                removeActive(j);
            }
            addActive(1);
            showTab(1);

            $("#t1").click(function(){
                removeTab(selectedTab);
                removeActive(selectedTab);
                addActive(1);
                showTab(1);
                selectedTab = 1;
            });
            $("#t2").click(function(){
                removeTab(selectedTab);
                removeActive(selectedTab);
                addActive(2);
                showTab(2);
                selectedTab = 2;
            });
            $("#t3").click(function(){
                removeTab(selectedTab);
                removeActive(selectedTab);
                addActive(3);
                showTab(3);
                selectedTab = 3;
            });


        });
    </script>
</html>