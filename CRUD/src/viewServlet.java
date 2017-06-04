

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/viewServlet")
public class viewServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        out.println("<a href='index.html'>Add New Employee</a>");  
	        out.println("<h1>Employees List</h1>");  
	          
	        List<Employee> list=EmployeeDAO.getAllEmployees();  
	          
	        out.print("<table border='1' width='100%'");  
	        out.print("<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Country</th><th>Edit</th><th>Delete</th></tr>");  
	        for(Employee emp:list){  
	         out.print("<tr><td>"+emp.getId()+"</td><td>"+emp.getName()+"</td><td>"+emp.getPassword()+"</td><td>"+emp.getEmail()+"</td><td>"+emp.getCountry()+"</td><td><a href='editServlet?id="+emp.getId()+"'>edit</a></td>  <td><a href='deleteServlet?id="+emp.getId()+"'>delete</a></td></tr>");  
	        }  
	        out.print("</table>");  
	          
	        out.close();  
	}

	
}
