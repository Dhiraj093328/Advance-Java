<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String name = request.getParameter("uname");
String pass = request.getParameter("upass");
out.print("Welcome " + name);
out.println(" Password " + pass);
%>
</body>
</html>
