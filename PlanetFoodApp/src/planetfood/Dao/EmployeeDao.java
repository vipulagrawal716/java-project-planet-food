
package planetfood.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import planetfood.dbutil.DBConnection;
import planetfood.pojo.Category;
import planetfood.pojo.Employee;
import planetfood.pojo.User;


public class EmployeeDao {
    public static String getNewEmployeeId() throws SQLException
    {
        Connection conn=DBConnection.getConnection();
       Statement st=conn.createStatement();
       int id=101;
       ResultSet rs=st.executeQuery("select count(*) from Employee");
       while(rs.next())
       {
           id=id+rs.getInt(1);
       }
       return "E"+id;
    }
    public static ArrayList<String> getJobList() throws SQLException
    {
        Connection conn=DBConnection.getConnection();
       Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select distinct job from Employee");
        ArrayList<String> jobList=new ArrayList<String>();
       while(rs.next())
       {
           jobList.add(rs.getString(1));
       }
       return jobList;
    }
    public static boolean addEmployee(Employee e) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into employee values(?,?,?,?)");
        ps.setString(1,e.getEmpId());
        ps.setString(2,e.getEmpName());
        ps.setString(3,e.getJob());
        ps.setInt(4,e.getSalary());
        int x=ps.executeUpdate();
        return(x>0);
        
    }
    public static Employee getEmployeeDetails(String empId) throws SQLException
    {
    Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select ename,job,sal from employee where empid=?");
        ps.setString(1, empId);
        ResultSet rs=ps.executeQuery();
        Employee e=new Employee();
        while(rs.next())
        {
             
            e.setEmpName(rs.getString("ename"));
            e.setJob(rs.getString("job"));
            e.setSalary(rs.getInt("sal"));
            
        }
        return e;
    }
     public static boolean updateEmployee(Employee e1) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("update employee set ename=?,job=?,sal=? where empid=?");
        ps.setString(4,e1.getEmpId());
        ps.setString(1,e1.getEmpName());
        ps.setString(2,e1.getJob());
        ps.setInt(3,e1.getSalary());
        int x=ps.executeUpdate();
        return(x>0);
    
    }
    public static HashMap<String,String> getEmpIdList() throws SQLException
    {
      Connection conn=DBConnection.getConnection();
      Statement st=conn.createStatement();
      ResultSet rs=st.executeQuery("select empid,ename from employee");
      HashMap<String,String> empIdList=new HashMap<String,String>();
      
      while(rs.next())
      {
       String empid=rs.getString(1);
       String ename=rs.getString(2);
       empIdList.put(empid,ename);   
      }
      return empIdList;
      
    }
    public static Employee getEmpIdDetails(String empId) throws SQLException
    {
        Connection conn=DBConnection.getConnection(); 
        PreparedStatement ps=conn.prepareStatement("Select ename,job,sal from employee where empid=?");
        ps.setString(1,empId);
        ResultSet rs=ps.executeQuery();
        Employee e=new Employee();
       
        while(rs.next())
        {
            
            e.setEmpId(empId);
            e.setEmpName(rs.getString("ename"));
            e.setJob(rs.getString("job"));
            e.setSalary(rs.getInt("sal"));
            
            
        }
        return e;
        }
    public static boolean removeEmployee(String empId) throws SQLException
    {
        Connection conn=DBConnection.getConnection(); 
        PreparedStatement ps=conn.prepareStatement("delete from employee where empid=?");
        ps.setString(1,empId);
        int x=ps.executeUpdate();
        return (x>0);
    }
     public static ArrayList<Employee> getAllData() throws SQLException{
    Connection conn=DBConnection.getConnection();
    String qry="Select * from employee";
    Statement st=conn.createStatement();
    ResultSet rs=st.executeQuery(qry);
    ArrayList<Employee> empList=new ArrayList<Employee>();
    while(rs.next())
    {
        Employee e=new Employee();
        e.setEmpId(rs.getString("empid"));
        e.setEmpName(rs.getString("ename"));
        e.setJob(rs.getString("job"));
        e.setSalary(rs.getInt("sal"));
        
        empList.add(e);
    }
    return empList;
}
}
