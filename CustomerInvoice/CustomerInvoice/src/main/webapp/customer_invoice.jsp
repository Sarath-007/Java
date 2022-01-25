<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,java.sql.Statement, java.sql.Connection, java.sql.ResultSet,java.sql.DriverManager"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Class.forName("com.mysql.jdbc.Driver");
Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sarath", "root", "root");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from Store"); %>
<h1> CUSTOMER INVOICE</h1>
<form action='invoice.jsp' method='post'>

Customer name:<input type="text" name="name"><br> <br>
Customer address:<input  type="text" name="cadd"><br> <br>
Seller name:<input type="text" name="sname"><br> <br>
Seller address:<input type="text" name="sadd"><br> <br>
Invoice number:<input type="number" name="number"><br> <br>
Invoice date:<input type ="date"><br><br>
Payment due:<input type ="date"><br><br>

<table style=width:75%>
  <tr>
    
    <th id="i">Item Name</th>
    <th id="q">Quantity</th>

  </tr>
  <tr>
    
    <td style="text-align:center " ><select name="items" id="items" >
<%


while(rs.next())
{
	%>
	<option> <%=rs.getString("ItemName") %></option>
	<% 
}
%>

</select>
<br><br>
  
    <td style="text-align:center"><input type ="text" name="qty"></td>
  
    
  </tr>
 
<tr>
    
    <td style="text-align:center"><select name="items1" id="items1" >
    <option> Good Day</option>
    <option> Hide and Seek </option>
    <option> Bourbon</option>
    <option> Arrowroot</option>

</select></td>
    <td style="text-align:center"><input type ="text" name="q2"></td>
   
    
  </tr>

</table><br>

<input type="submit" value="invoice">
</form>








</body>
</html>