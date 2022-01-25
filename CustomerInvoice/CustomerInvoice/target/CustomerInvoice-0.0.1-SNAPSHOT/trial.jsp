<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
String [] s=request.getParameterValues("item");
int count=0;
for (String p:s){
	out.println(s[1]);
}


%>
</body>
</html>