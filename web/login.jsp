<%-- 
    Document   : login
    Created on : 27 Feb, 2017, 11:24:13 PM
    Author     : 1406450
--%>
<jsp:include page="userheader.jsp" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body class="text-center"><table class="text-center" style="width: 80%">
<th style="text-align: center">Already Member</th><th style="text-align:  center">New Member</th>
<tr>
<td>
    <jsp:include page="login.html" />
</td>
<td>
    <jsp:include page="signup.html" />
</td>
<tr>
<a href="addseller.jsp">IF YOU ARE A SELLER AND WANT TO SELL YOUR PRODUCT THEN FILL THIS FORM</a>
</table>
        
        </body>
    <jsp:include page="footer.html" />
                      <%
                    if (session.getAttribute("message")!=null)
                        out.println(session.getAttribute("message"));
                    %>
</html>
