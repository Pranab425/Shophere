<%-- 
    Document   : waddp
    Created on : 2 Mar, 2017, 12:24:04 AM
    Author     : 1406450
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <jsp:include page="adminheader.jsp" />
        
        <b>
           <center>
    <pre>
<form method="post" action="newproduct" enctype="multipart/form-data">
            Enter  Id   : <input type="number" name="wid"/>

            Enter Item Name : <input type="text" name="wname"/>


            Enter Model No.: <input type="text" name="wno"/>


            Enter Details  : <input type="text" name="wdet"/>

              Enter Price : <input type="number" name="wpri"/>

               Upload Pic      <input type="file" name="photo" size="50"/>
              
              Select Category   <select name="categ">
  <option value="men">Men</option>
  <option value="women">Women</option>
  <option value="teenage">Teenage</option>
  <option value="gadget">Gadget</option>
  <option value="sports">Sports</option>
  <option value="home">Home and Furniture</option>
  <option value="books">Books and more</option>
</select>

                         <input type="submit" class="color gblue" value="SUBMIT"/>



                         <INPUT TYPE="RESET" VALUE="RESET"/>
</form>
    </pre>
           </center>
    </body>
</html>

