import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
	public static Connection getConnection(){
		Connection connection=null;
		String drivername="com.mysql.jdbc.Driver";
		try{
			Class.forName(drivername);
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}
			String dbURL="jdbc:mysql://localhost:3306/crud";
			String userid="root";
			String password="root";
			try {
				connection=DriverManager.getConnection(dbURL,userid,password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(connection != null){
				System.out.println("connection created...");
			}
			return connection;
			
	}
	public static int save(Employee emp){
		int status=0;
		try{  
            Connection con=EmployeeDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into user(name,password,email,country) values (?,?,?,?)");  
            ps.setString(1,emp.getName());  
            ps.setString(2,emp.getPassword());  
            ps.setString(3,emp.getEmail());  
            ps.setString(4,emp.getCountry());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    } 
	public static int update(Employee emp){
		
		  int status=0;  
	        try{  
	            Connection con=EmployeeDAO.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "update user set name=?,password=?,email=?,country=? where id=?");  
	            ps.setString(1,emp.getName());  
	            ps.setString(2,emp.getPassword());  
	            ps.setString(3,emp.getEmail());  
	            ps.setString(4,emp.getCountry());  
	            ps.setInt(5,emp.getId());  
	              
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
	 public static int delete(int id){  
	        int status=0;  
	        try{  
	            Connection con=EmployeeDAO.getConnection();  
	            PreparedStatement ps=con.prepareStatement("delete from user where id=?");  
	            ps.setInt(1,id);  
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return status;  
	    } 
	 public static Employee getEmployeeById(int id){  
	        Employee emp=new Employee();  
	          
	        try{  
	            Connection con=EmployeeDAO.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from user where id=?");  
	            ps.setInt(1,id);  
	            ResultSet rs=ps.executeQuery();  
	            if(rs.next()){  
	                emp.setId(rs.getInt(1));  
	                emp.setName(rs.getString(2));  
	                emp.setPassword(rs.getString(3));  
	                emp.setEmail(rs.getString(4));  
	                emp.setCountry(rs.getString(5));  
	            }  
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return emp;  
	    }  
	    public static List<Employee> getAllEmployees(){  
	        List<Employee> list=new ArrayList<Employee>();  
	          
	        try{  
	            Connection con=EmployeeDAO.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from user");  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	                Employee emp=new Employee();  
	                emp.setId(rs.getInt(1));  
	                emp.setName(rs.getString(2));  
	                emp.setPassword(rs.getString(3));  
	                emp.setEmail(rs.getString(4));  
	                emp.setCountry(rs.getString(5));  
	                list.add(emp);  
	            }  
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    } 

	
}


