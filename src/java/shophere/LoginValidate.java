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
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author 1406450
 */
@WebServlet(name = "LoginValidate", urlPatterns = {"/LoginValidate"})
public class LoginValidate extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           String u = request.getParameter("username");
            String p = request.getParameter("password");
            String enc = DatatypeConverter.printBase64Binary(p.getBytes());
             Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://:3306/shophere","root","1406425");
             Statement st = (Statement) con.createStatement();
           ResultSet rs = st.executeQuery("select * from login where username='" + u + "' and password='" + enc+ "'");
    
        
    if (rs.next()) {
        HttpSession s=request.getSession();
      s.setAttribute("username", u);
      ArrayList<Cartdata> cartdata = new ArrayList<Cartdata>();
      s.setAttribute("cartvalue", cartdata);
        //out.println("welcome " + userid);
        //out.println("<a href='logout.jsp'>Log out</a>");s
       // response.sendRedirect("adminhome.jsp");
        String sa=rs.getString(5);
        {
            if(sa.equals("admin"))
            {
                RequestDispatcher rd=request.getRequestDispatcher("adminhome.jsp");
                rd.forward(request, response);
            }
            if(sa.equals("user"))
            {
                RequestDispatcher rd=request.getRequestDispatcher("userhome.jsp");
                rd.forward(request, response); 
            }
           
        }
    } else {
          RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
        out.println("Invalid user<a href='login.jsp'>try again</a>");
    }
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
           
          
         finally {
            out.close();
        }
    }

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
