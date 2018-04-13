<%-- 
    Document   : sellerhome
    Created on : Apr 4, 2018, 8:57:17 AM
    Author     : 1406425
--%>
<%-- 
    Document   : adminhome
    Created on : 27 Feb, 2017, 11:40:47 PM
    Author     : 1406450
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Shophere</title>
    
    <!-- Google Fonts -->
  
    <!-- Bootstrap -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    
    <!-- Font Awesome -->
    <link rel="stylesheet" href="css/font-awesome.min.css">
    
    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/owl.carousel.css">
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="css/responsive.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <jsp:include page="adminheader.jsp" />
  </head>
  <body>
<marquee> WELCOME SELLER  </marquee>
<body allign="center" bgcolor="f0e68c" style="text-align: center">
 
   <table><tr>
           <td><a href='seller.jsp'>ADD NEW PRODUCT</a></td></tr></table>
    
    <jsp:include page="productstatus.jsp" />
    
    UPDATE YOUR PERSONAL INFO HERE:-
    Address:- <input type="textarea" name="address">
    Mobile No.:- <input type="number" name="phoneno">
  </body>
</html>