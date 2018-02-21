/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shophere;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author 1406450
 */
public class dao {
     static Connection con;
    public static  Connection dbConnection ()
    {
      try{
          Class.forName("con.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shophere","root","root");

      }
      catch(ClassNotFoundException e)
      {
          System.out.println(e);
      } catch (SQLException e) {
          System.out.println(e);
        }
      return con;
    }
    

    
}
