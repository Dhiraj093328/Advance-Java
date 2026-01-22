<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UseBean Demo</title>
</head>
<body>

<jsp:useBean id="obj" class="test.Calculator" />
<jsp:useBean id="obj1" class="test.Square" />

<%
int a=obj.cube(5);
out.print("Cube of no :" +a);
%><br><br>
<% 
int b=obj1.Square(5);
out.print("Square of no : "+b);
%>

</body>
</html>
