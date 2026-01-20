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
out.print("Welcome, Your fun fact is "+request.getParameter("funfact"));
String data="admin";
session.setAttribute("user", data);

pageContext.setAttribute("user1","Dhiraj" , PageContext.SESSION_SCOPE);

%>

<a href="welcome.jsp">Welcome.jsp</a>

</body>
</html>