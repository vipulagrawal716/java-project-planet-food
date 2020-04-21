
package planetfood.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class DBConnection {
    private static Connection conn; 
    static
    {
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-JBL308M:1521/XE","system","vipul");
            System.out.println("Connection opened");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"connection not done","Error!",JOptionPane.ERROR_MESSAGE); 
                   e.printStackTrace();
        }
         }
        public static Connection getConnection()
        {
            return conn;
        }
        public static void closeConnection()
        {
            try
            {
                conn.close();
                System.out.println("Connection closed");
                
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"DB error in closing connection","Error!",JOptionPane.ERROR_MESSAGE); 
                   e.printStackTrace();
                
            }
        }
    }
    

