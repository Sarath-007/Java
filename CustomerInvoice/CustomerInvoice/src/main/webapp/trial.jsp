<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,java.sql.Statement, java.sql.Connection, java.sql.ResultSet,java.sql.DriverManager"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="trial2.jsp">
<select name="items" id="items" >
<%

Class.forName("com.mysql.jdbc.Driver");
Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sarath", "root", "root");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from Store");
while(rs.next())
{
	%>
	<option> <%=rs.getString("ItemName") %></option>
	<% 
}
%>

</select>
<br><br>
  <input type="submit" value="Choose Item">
</body>
</html>