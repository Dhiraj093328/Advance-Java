<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bean Example</title>
</head>
<body>

<jsp:useBean id="obj1" class="test.User" />

<%
    String name = "Dhiraj";
	String password = "Dhiraj@123";
	String  email= "Dhiraj@gmail.com";

%>

<jsp:setProperty name="obj1" property="name" value="<%= name %>" />
<jsp:setProperty name="obj1" property="password" value="<%= password %>" />
<jsp:setProperty name="obj1" property="email" value="<%= email %>" />

Record:<br>
<jsp:getProperty name="obj1" property="name" /><br>
<jsp:getProperty name="obj1" property="password" /><br>
<jsp:getProperty name="obj1" property="email" /><br>

</body>
</html>
