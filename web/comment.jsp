<%-- 
    Document   : comment
    Created on : Apr 5, 2018, 11:32:41 AM
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
    </head>
    <body style="text-align: center">
<BR><center><TABLE BORDER="1">
        <h1>Previous Comments:-</h1>
        <tr>   
<%
      String id = request.getParameter("id"); 
          String q="select cus_name,comment from comment where pid = '"+id+"';";
            ResultSet resultset = shophere.Daolayer.selectData(q);
 try{
                
            while(resultset.next())
            {
        %>
         <TR>
             <TD><h3> <%= resultset.getString(1) %> </h3></TD><TD>~~~~~~></TD>
               <TD><h3> <%= resultset.getString(2) %> </h3></TD>
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
    </body>
</html>

