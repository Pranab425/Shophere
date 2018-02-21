<%-- 
    Document   : newrequest
    Created on : 7 Dec, 2017, 4:18:57 PM
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
        
        <form action="copy2product" method="post">
<BR><center><TABLE BORDER="1">
   
        <tr>   
<%
      
          String q="select * from temp";
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
               <TD> <%= resultset.getString(4) %> </TD>
               <TD> <%= resultset.getString(5) %> </TD>
               <TD> <%= resultset.getString(7) %> </TD>
               <TD> <button type='submit' name='id' value='<%= resultset.getString(1) %>'>ADD THIS PRODUCT</button> </TD>
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
