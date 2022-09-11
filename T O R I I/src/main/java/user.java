

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class user extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public user() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter out=response.getWriter();
	        String fname = request.getParameter("fname");
	        String mail = request.getParameter("mail");
	        String satisfaction = request.getParameter("satisfaction");
	        String range = request.getParameter("range");
	        String usertextarea = request.getParameter("usertextarea");
	   
			
	        try 
		    {
			    Class.forName("com.mysql.jdbc.Driver");  
	/*----*/    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/torii","root","");    
	/*----*/    Statement stmt3=con.createStatement();
	/*----*/    String query2=String.format("insert into feedback (`fname`,`mail`,`satisfaction`,`frange`,`comments`) values('%s','%s','%s','%s','%s')", fname, mail, satisfaction, range, usertextarea);
	/*----*/    stmt3.execute(query2);  
				Thread.sleep(2000);
				response.sendRedirect("user.html");				
				
			} 
		    catch (Exception e) 
		    {
				System.out.println(e);
			}
			}
			
	}


