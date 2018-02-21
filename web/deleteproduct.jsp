<%-- 
    Document   : wishlist
    Created on : 29 Oct, 2017, 5:06:18 AM
    Author     : 1406425
--%>
<%@page import="java.util.Iterator"%>
<%@page import="shophere.Cartdata"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css">
        <title>CART</title>
    </head>
    <body style="text-align: center">
        <jsp:include page="userheader.jsp" />
        <H1>ALL PRODUCT</h1>
        <form action="delete" method="get">
<BR><center><TABLE BORDER="1">
    <TR>
               <TH>PIC</TH>
               <TH>ID</TH>
               <TH>NAME</TH>
               <TH>MODEL NO.</TH>
               <TH>DELETE</TH>
            </TR>
        <tr>   
<%
          String q="select *from product;";
            ResultSet resultset = shophere.Daolayer.selectData(q);
 try{
                
            while(resultset.next())
            {
               
        %>
         <TR>
             <TD> <IMG src="getpic?id='<%= resultset.getString(1) %>'" width="100" height="100"> </TD>
               <TD> <%= resultset.getString(1) %> </TD>
               <TD> <%= resultset.getString(2) %> </TD>
               <TD> <%= resultset.getString(3) %> </TD>
               <TD> <button type='submit' name='id' value='<%= resultset.getString(1) %>'>DELETE</button> </TD>
           </TR>
           
    <%
} 
}
catch(Exception e){
            out.print("Some Exception Occoured"+e);
            
        }
%>
        </TABLE>
<br>
</center></form>
        <jsp:include page="footer.html" />
    </body>
</html>
