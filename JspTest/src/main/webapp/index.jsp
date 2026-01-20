<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<br>
<b>Write With Expression Method (=) :</b>
<br>
<br>

<%="Welcome to JSP Page" %>
<%="Welcome "+request.getParameter("uname")+
" Password: "+request.getParameter("upass")+" Age :"+age %>
<br>
<br>
<br>

<b>Write With Scriplet Method :</b>
<br>
<br>
<%
String name = request.getParameter("uname");
String pass = request.getParameter("upass");
out.print("Welcome " + name);
out.println(" Password " + pass);

out.println(2*5);

%>

<br>
<br>
<b>Write with Declaration Tag:</b>

<%!int age=50; %>
<%! int cube(int n){
	return n*n*n;
}%>
<br>
<br>

<%="Cube of 3 : "+cube(3) %>
</body>
</html>
