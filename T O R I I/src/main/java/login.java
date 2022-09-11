import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	    String rusername = request.getParameter("rusername");
	    String rdob = request.getParameter("rdob"); 
	    String rmail = request.getParameter("rmail"); 
	    String rpassword = request.getParameter("rpassword");
	    
	    try 
	    {
		    Class.forName("com.mysql.jdbc.Driver");  
/*----*/    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/torii","root","");    
/*----*/    Statement stmt=con.createStatement();
/*----*/    String query=String.format("insert into reglog (`username`,`password`,`email`,`dob`) values('%s','%s','%s','%s')", rusername, rpassword, rmail, rdob);
/*----*/    stmt.execute(query);  
			Thread.sleep(4000);
			response.sendRedirect("login.html");
			
		} 
	    catch (Exception e) 
	    {
			System.out.println(e);
			out.println("Failed");
		}
	}

}



