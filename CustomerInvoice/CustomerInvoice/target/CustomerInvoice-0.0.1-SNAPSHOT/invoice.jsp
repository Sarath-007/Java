<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.Statement, java.sql.Connection, java.sql.ResultSet,java.sql.DriverManager,java.time.*,java.util.*"%>
    <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Invoice </title>
</head>
<body>

<% 
       String s=request.getParameter("item");
      String s2=request.getParameter("item2");
	int qty=Integer.parseInt(request.getParameter("qty"));
	int qty1=Integer.parseInt(request.getParameter("q2"));
       String cname=request.getParameter("name");
       String cadd=request.getParameter("cadd");
       String sname=request.getParameter("sname");
       String sadd=request.getParameter("sadd");
       LocalDateTime myObj = LocalDateTime.now();
       
       int invoice=Integer.parseInt(request.getParameter("number"));
       int price1=0,price2=0, totalprice=0;
       // database
       Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sarath", "root", "root");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from Store");
		while(rs.next())
		{
			String name=rs.getString("ItemName");
			
			if(name.equalsIgnoreCase(s))
			{
				
				int r=rs.getInt("Rate");
				price1=r*qty;
				
			}
			if(name.equalsIgnoreCase(s2))
			{
				
				int r=rs.getInt("Rate");
				price2=r*qty;
				
			}
			
			
		}
		totalprice=price1+price2;
		// success.jsp redirect
		HttpSession s1=request.getSession();
		s1.setAttribute("item",s);
		s1.setAttribute("time",myObj);
		s1.setAttribute("name",cname);
		s1.setAttribute("cadd",cadd);
		s1.setAttribute("sname",sname);
		s1.setAttribute("sadd",sadd);
		s1.setAttribute("price",totalprice);
		s1.setAttribute("qty",qty);
		s1.setAttribute("invoice",invoice);
		
		
		if(totalprice==0||price1==0||price2==0){
			response.sendRedirect("error.jsp");
		}
		else{
			response.sendRedirect("success.jsp");
		}
	
		st.close();
		con.close();

		%>


</body>
</html>