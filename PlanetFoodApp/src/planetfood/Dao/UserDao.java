
package planetfood.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import planetfood.dbutil.DBConnection;
import planetfood.pojo.User;


public class UserDao {
    public static String validateUser(User user) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        String qry="select username from users where userid=? and password=? and usertype=?";
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1,user.getUserid());
        ps.setString(2,user.getPassword());
        ps.setString(3,user.getUsertype());
        ResultSet rs=ps.executeQuery();
        String username=null;
        if(rs.next()){
            username=rs.getString(1);
        }
        return username;
    }
    public static boolean registerCashier(User u) throws SQLException
    {
        Connection conn=DBConnection.getConnection(); 
        PreparedStatement ps=conn.prepareStatement("insert into users values(?,?,?,?,?)");
        ps.setString(1,u.getUserid());
        ps.setString(2,u.getUserName());
        ps.setString(3,u.getEmpId());
        ps.setString(4,u.getUsertype());
        ps.setString(5,u.getPassword());
        int x=ps.executeUpdate();
        return (x>0);
    }
    public static User getUserIdDetails(String userId) throws SQLException
    {
     Connection conn=DBConnection.getConnection(); 
        PreparedStatement ps=conn.prepareStatement("Select username,empid from users where userid=?");
        ps.setString(1,userId);
        ResultSet rs=ps.executeQuery();
        User u=new User();
       
        while(rs.next())
        {
            
            u.setUserid(userId);
            u.setUserName(rs.getString("username"));
            u.setEmpId(rs.getString("empid"));
        }
        return u;
        }
    public static boolean removeCahier(String userId) throws SQLException
    {
        Connection conn=DBConnection.getConnection(); 
        PreparedStatement ps=conn.prepareStatement("delete from users where userid=?");
        ps.setString(1,userId);
        int x=ps.executeUpdate();
        return (x>0);
        
        
    }
    }

