/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shophere;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet(name = "wishlist", urlPatterns = {"/wishlist"})
public class wishlist extends HttpServlet {

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
        PrintWriter out = response.getWriter();
         out.println("sbjs");
        try{
            HttpSession session = request.getSession();
            if ((session.getAttribute("username") == null) || (session.getAttribute("username") == "")) {
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }
        else{
                out.println("sbjs");
                String wid=" ",wname=" ",wprice=" ",wmodel_no=" ";
                String pid = request.getParameter("wid");
                String username = (String)session.getAttribute("username");
                String q = "select id,name,price,model_no from product where id="+pid;
                ResultSet rs = shophere.Daolayer.selectData(q);
                out.println("sbjs");
                while(rs.next()){
                    wid = rs.getString(1);
                    wname = rs.getString(2);
                    wprice = rs.getString(3);
                    wmodel_no = rs.getString(4);
                    
                }
                String uq = "insert into wishlist values('"+wid+"','"+wname+"','"+wmodel_no+"','"+wprice+"','"+username+"');";
                int z = Daolayer.updateData(uq);
                if(z>0){
                  RequestDispatcher rd=request.getRequestDispatcher("wishlist.jsp");
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
