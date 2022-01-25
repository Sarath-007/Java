<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.time.*,java.io.*,com.itextpdf.text.pdf.PdfWriter,com.itextpdf.text.*,com.itextpdf.text.pdf.PdfPTable,com.itextpdf.text.pdf.PdfPCell,java.time.format.DateTimeFormatter"%>
    
<!DOCTYPE html>
<html lang='en'>
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
String item=(String)s1.getAttribute("item1");
LocalDateTime myObj=LocalDateTime.now();
int price1=(int)s1.getAttribute("price1");
int price2=(int)s1.getAttribute("price2");
int price=(int)s1.getAttribute("price");
int qty=(int)s1.getAttribute("qty");
int q=(int)s1.getAttribute("qty1");
int invoice=(int)s1.getAttribute("invoice");
DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss"); 
String formatted=myObj.format(myFormatObj);

// TO PDF

try {
            Document document=new Document();
           PdfWriter.getInstance(document,new FileOutputStream("D:\\Invoice.pdf"));
           PdfPTable table = new PdfPTable(3);
           document.open(); 
          Image img=Image.getInstance("C:\\Users\\DELL\\Downloads\\images.png");
          img.setAbsolutePosition(200, 400);
          document.add(img);
           document.addTitle("CUSTOMER INVOICE");
           document.add(new Paragraph("Invoice Number:"+ invoice));
            document.add(new Paragraph("Date and Time:"+""+ formatted));
           document.add(new Paragraph("Seller name :"+" "+ sname));
            document.add(new Paragraph("Seller address :"+""+sadd));
           document.add(new Paragraph("Customer name:"+ cname));
           document.add(new Paragraph("Customer address: "+cadd));
           table.addCell("Item Name");
			table.addCell("Quantity");
			table.addCell("Cost");
			// datas
			table.addCell(s);
			table.addCell(Integer.toString(qty));
			table.addCell(Integer.toString(price1));
			//row 2
			table.addCell(item);
			table.addCell(Integer.toString(q));
			table.addCell(Integer.toString(price2));
			
			document.add(table);
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
		<br><br>
		Seller name: <%=sname %>
		<br> 
		<br>
		Seller Address:<%=sadd %><br><br>
		
		       Customer name : <%=cname %>
		       <br>
		       <br>
		       Customer address:<%=cadd %><br><br>
		
		      
		    <table style=width:75%>
  <tr>
    
    <th id="h">Item Name</th>
    <th id="l">Quantity</th>
    <th id="m">Item Price</th>

  </tr>
  <tr>
    
    <td style="text-align:center"><%=s %></td>
 
    <td style="text-align:center"><%=qty %></td>
    <td style="text-align:center"><%=price1 %></td>
    
  </tr>
 
<tr>
    
    <td style="text-align:center"><%=item %></td>
 
    <td style="text-align:center"><%=q %></td>
    <td style="text-align:center"><%=price2 %></td>
    
  </tr>

</table>
		
		<br>
		<br>
		<h4>The Total Price: <%=price %> Rupees Only</h4><br><br>
		<a href="FileDownload"> Download </a>
		
		
		

</body>
</html>