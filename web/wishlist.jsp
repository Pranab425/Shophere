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
        <H1>MY WISHLIST</h1>
        <form action="updatecart" method="post">
<BR><center><TABLE BORDER="1">
    <TR>
               <TH>ID</TH>
               <TH>NAME</TH>
               <TH>PRICE</TH>
               <TH>MODEL NO.</TH>
            </TR>
        <tr>   
<%
      String name = (String)session.getAttribute("username"); 
          String q="select * from wishlist where username = '"+name+"';";
            ResultSet resultset = shophere.Daolayer.selectData(q);
 try{
                
            while(resultset.next())
            {
        %>
         <TR>
               <TD> <%= resultset.getString(1) %> </TD>
               <TD> <%= resultset.getString(2) %> </TD>
               <TD> <%= resultset.getString(3) %> </TD>
               <TD> <%= resultset.getString(4) %> </TD>
           </TR>
           
    <%
} 
}
catch(Exception e){
            out.print("Some Exception Occoured"+e);
            
        }
%>
</tr>
 </TABLE>
<br>
</center>
        </form>
        <jsp:include page="footer.html" />
    </body>
</html>
