<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
try{
String st = session.getAttribute("admin").toString();
if(st == null){
}
if(st.equals("1")){
	request.getRequestDispatcher("/admin.jsp").forward(request, response);
}
}catch(Exception e){
}
%>
<body>
<form action="cred" method="post">
	<input type="text" name="user">
	<br>
	<input type="password" name="password">
	<br>
	<button type="submit">LogIn</button>
</form>
</body>
</html>