<%-- 
    Document   : userheader
    Created on : 29 Mar, 2017, 11:48:25 AM
    Author     : 1406450
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
  </head>
<body allign="center" bgcolor="f0e68c">
<div class="header-area">
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <div class="user-menu">
                        <ul>
                            <li><a href="#"><i class="fa fa-user"></i> 24 x 7 Customer Care</a></li>
                            <li><a href="#"><i class="fa fa-heart"></i> Wishlist</a></li>
                            <li><a href="cart.html"><i class="fa fa-user"></i> My Cart</a></li>
                                                <%
    if ((session.getAttribute("username") == null) || (session.getAttribute("username") == "")) {
        
%>

<li><a href="login.jsp"><i class="fa fa-user"></i>Login/Signup</a></li>

<%} else {
    }
%>
Welcome <%=session.getAttribute("username")%>
<li><a href="logout"><i class="fa fa-user"></i>Logout</a></li>
  
                            </ul>
                    </div>
                </div>
            </div>
        </div>
        </div>
        <a href="./"><img src="img/logo.png" height="80px" width="80px"></a>
        <input type="text" placeholder="What Do You Want?" style="width: 80%; height: 45px"><button type="submit">SEARCH</button>
        <!-- Latest jQuery form server -->
    <script src="https://code.jquery.com/jquery.min.js"></script>
    
    <!-- Bootstrap JS form CDN -->
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    
    <!-- jQuery sticky menu -->
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/jquery.sticky.js"></script>
    
    <!-- jQuery easing -->
    <script src="js/jquery.easing.1.3.min.js"></script>
    
    <!-- Main Script -->
    <script src="js/main.js"></script>
    
    <!-- Slider -->
    <script type="text/javascript" src="js/bxslider.min.js"></script>
	<script type="text/javascript" src="js/script.slider.js"></script>
  </body>
</html>    