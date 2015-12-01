<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.iiitd.Entry" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<%
ArrayList<Entry> finalList = (ArrayList<Entry>)request.getAttribute("finalList");
%>
    <div class="container-fluid">
    <form action="admin" method="get">
            <h4>
                <button type="submit">Back</button>
            </h4>
    </form>
            <h1>
                <center>Filtered Result</center>
            </h1>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Enrollment Id</th>
                        <th>Name</th>
                        <th>Link to Data</th>
                    </tr>
                </thead>
                <% for(Entry e:finalList){ %>
                <tbody>
                    <tr>
                        <td><%= e.enrollmentNumber %></td>
                        <td><%= e.name %></td>
                        <td><button name="show" class="show" value=<%= e.email %>>Show File</button></td>
                    </tr>
                </tbody>
                <% } %>
            </table>
    </div>
</body>
<script>
    $(document).ready(function(){
        $(".show").click(function(){
            var a = $(this).attr("value");
            console.log("coming click "+a);
             $.post("show",{email:a},function(data,status){alert(data);});
        });
    });
</script>
</html>