<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="obj1" class="test.User" scope="session"/>
<jsp:setProperty property="*" name="obj1"/>

Record:<br>
<jsp:getProperty property="name" name="obj1"/><br>
<jsp:getProperty property="password" name="obj1"/><br>
<jsp:getProperty property="email" name="obj1"/><br>

<a href="second.jsp">Visit Second.jsp</a>
</body>
</html>