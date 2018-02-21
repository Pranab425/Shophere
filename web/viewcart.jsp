 <%-- 
    Document   : viewcart
    Created on : 24 Oct, 2017, 8:02:37 PM
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
        <form action="updatecart" method="get">
<%
    String name = (String)session.getAttribute("username"); 
%> 
<BR><center><TABLE BORDER="1">
        <TR>        <TH>SELECT </TH>
               <TH>PRODUCT NAME</TH>
               <TH>PRODUCT DETAILS</TH>
               <TH>QUANTITY</TH>
               <TH>PRICE PER QUANTITY</TH>
               <TH>TOTAL PRICE</TH>
            </TR>
           
<%
    List<Cartdata> cartdata = (ArrayList)session.getAttribute("cartdata");
    Iterator it = cartdata.iterator();
    while(it.hasNext())
    {
        Cartdata ct = (Cartdata)it.next();
        %>
        <tr><td><input type="checkbox" name="check" value=""></td>
        <td><input type="hidden" name="name" value="<%= ct.CartNAME %>" > <%= ct.CartNAME %> </td>
        <td><input type="hidden" name="details" value="<%= ct.CartDETAILS %>" > <%= ct.CartDETAILS %> </td>
        <td><input type="number" step="1" value="1" id="quan" min="1" name="quan"> </td>
        <td><input type="hidden" name="price" id="price" value="<%= ct.CartPRICE %>" > <%= ct.CartPRICE %> </td></tr>
    <%
} 
%>
</TABLE>
<br>
<input type="submit" value="Submit">
</center>
        </form>
<jsp:include page="footer.html" />
    </body>
</html>
