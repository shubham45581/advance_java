

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/editServlet2")
public class editServlet2 extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        String name=request.getParameter("name");  
        String password=request.getParameter("password");  
        String email=request.getParameter("email");  
        String country=request.getParameter("country");  
          
        Employee emp=new Employee();  
        emp.setId(id);  
        emp.setName(name);  
        emp.setPassword(password);  
        emp.setEmail(email);  
        emp.setCountry(country);  
          
        int status=EmployeeDAO.update(emp);  
        if(status>0){  
            response.sendRedirect("viewServlet");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close(); 
	}

}
