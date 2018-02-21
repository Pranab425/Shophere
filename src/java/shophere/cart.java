/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shophere;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "cart", urlPatterns = {"/cart"})
public class cart extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            HttpSession session = request.getSession();
            if ((session.getAttribute("username") == null) || (session.getAttribute("username") == "")) {
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }
        else{
                String pid = request.getParameter("id");
                String q = "select id,name,details,price from product where id="+pid;
                ResultSet rs = shophere.Daolayer.selectData(q);
            //    ArrayList<Cartdata> cartdata = new ArrayList<Cartdata>();
            List<Cartdata> cartdata = (ArrayList)session.getAttribute("cartvalue");
            if(cartdata.isEmpty()){
                while(rs.next()){
                    Cartdata c = new Cartdata();
                    c.CartID = rs.getInt(1);
                    c.CartNAME = rs.getString(2);
                    c.CartDETAILS =  rs.getString(3);
                    c.CartPRICE =  rs.getInt(4);
                    cartdata.add(c);
                }
                session.setAttribute("cartdata", cartdata);
                RequestDispatcher rd=request.getRequestDispatcher("viewcart.jsp");
                rd.forward(request, response);
            }
            else{
                while(rs.next()){
                 Cartdata ci = new Cartdata();
                    ci.CartID = rs.getInt(1);
                    ci.CartNAME = rs.getString(2);
                    ci.CartDETAILS =  rs.getString(3);
                    ci.CartPRICE =  rs.getInt(4);
                    cartdata.add(ci);                       
                }
                session.setAttribute("cartdata", cartdata);
                RequestDispatcher rd=request.getRequestDispatcher("viewcart.jsp");
                rd.forward(request, response);
            }
            }
        }
        catch(SQLException e){
            out.println("Error is:-"+e);
        }
        finally{
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(cart.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(cart.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(cart.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(cart.class.getName()).log(Level.SEVERE, null, ex);
        }
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
