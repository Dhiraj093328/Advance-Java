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
out.print("welcome "+request.getParameter("uname"));
String driver = config.getInitParameter("admin");
out.print(" Driver is: "+driver);
	
%>

<br>

<%
String cparamname = application.getInitParameter("cpara");
out.print(" project Level info is: "+cparamname);
	
%>

</body>
</html>