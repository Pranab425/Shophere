/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shophere;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 1406425
 */
@WebServlet(name = "viewdesc", urlPatterns = {"/viewdesc"})
public class viewdesc extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
    String a = request.getParameter("id");
            Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shophere","root","1406425");
PreparedStatement pst = con.prepareStatement("select * from product where id = '"+a+"'");
ResultSet rs = pst.executeQuery();
            /* TODO output your page here. You may use following sample code. */
               out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title></title>");            
            out.println("</head>");
            out.println("<center>");
            out.println("<table><center>");
              out.println("<tr><td rowspan=2>");
            while(rs.next())
            {
               String id = rs.getString(1);
               out.println("<img src='getpic?id="+id+"' width='400' height='300' /></a><br>");
               out.println("<div style=\"width:400px;\">\n<div style=\"float: left; \">");
               out.println("<form action='wishlist'><button type='submit' name='wid' value='"+id+"'>ADD TO WISHLIST</button></form>");
               out.println("</div><div style=\"float: right; \">");
               out.println("<form action='cart' method='post'><button type='submit' name='id' value='"+id+"'>ADD TO CART</button>");
               out.println("</div></div></td>");
               out.println("<td><h1><b>"+rs.getString(2)+"</b></h1><br><br><br><br>");
               out.println("<h3><b>Product ID:-</b>"+rs.getString(3)+"</h3><br>");
               out.println("<h3><b>Product Description:-</b>"+rs.getString(4)+"</h3><br>");
               out.println("<h2><b>PRICE:-</b>"+rs.getString(5)+"</h2>");
               out.println("</center><br></td></form>");
            }
              RequestDispatcher rd=request.getRequestDispatcher("userheader.jsp");
           rd.include(request, response);
              out.println("</form>");
            out.println("<h1> </h1>");
            RequestDispatcher rdi=request.getRequestDispatcher("footer.html");
           rdi.include(request, response);
            out.println("</body>");
            out.println("</html>");
            
        }
catch(ClassNotFoundException e)
            {
                System.out.println("error Caught"+e);
            
        } catch (SQLException e) {
            System.out.println("error Caught"+e);
        } finally {
            out.close();
        }}
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
