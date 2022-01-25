<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.time.*,com.itextpdf.text.*,java.io.*,com.itextpdf.text.pdf.PdfWriter,com.itextpdf.text.pdf.PdfPTable,com.itextpdf.text.pdf.PdfPCell"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success</title>
</head>
<body>
<%
HttpSession s1=request.getSession();
String cname= (String)s1.getAttribute("name");
String cadd= (String)s1.getAttribute("cadd");
String sname= (String)s1.getAttribute("sname");
String sadd= (String)s1.getAttribute("sadd");
String s=(String)s1.getAttribute("item");
LocalDateTime myObj=LocalDateTime.now();
int price=(int)s1.getAttribute("price");
int qty=(int)s1.getAttribute("qty");
int invoice=(int)s1.getAttribute("invoice");

// TO PDF

try {
            Document document=new Document();
            PdfWriter.getInstance(document,new FileOutputStream("D:\\Invoice.pdf"));
            document.open(); 
           Image img=Image.getInstance("C:\\Users\\DELL\\Downloads\\images.png");
           img.setAbsolutePosition(200, 400);
           document.add(img);
            document.addTitle("CUSTOMER INVOICE");
            document.add(new Paragraph("Invoice Number:"+ invoice));
            document.add(new Paragraph("Date and Time:"+""+ myObj));
            document.add(new Paragraph("Seller name :"+" "+ sname));
            document.add(new Paragraph("Seller address :"+""+sadd));
            document.add(new Paragraph("Customer name:"+ cname));
            document.add(new Paragraph("Customer address: "+cadd));
            document.add(new Paragraph("Item name:"+ s));
            document.add(new Paragraph("Net Quantity:"+ qty));
            document.add(new Paragraph("Net Price:"+ price +" Rupees Only"));
            
                    
           
            document.close();
        } catch (Exception e) {
            System.out.println("error"+e.getMessage());
        }


%>
<img alt="logo" src="C:\\Users\\DELL\\Downloads\\download.png">

<h1> INVOICE </h1>
		<br>
		Date and Time: <%=myObj %>
		<br>
		Seller name: ABC stores
		<br> 
		<br>
		
		       Customer name : <%=cname %>
		       <br>
		       <br>
		
		       Item : <%=s %></td>
		       <br>
		       <br>
		       Net Quantity:<%=qty %>
		       <br>
		       <br>
		 
		        Price : <%=price %>
		
		<br>
		<br>
		The PDF has been downloaded in your system.
		


</body>
</html>