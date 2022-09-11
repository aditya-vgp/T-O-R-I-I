import java.sql.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class payment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public payment() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
	        String pname=request.getParameter("pname");
	        String pcard=request.getParameter("pcard");
	        String pmonth=request.getParameter("pmonth");
	        String pcvv=request.getParameter("pcvv");
	        
	        try 
		    {
			    Class.forName("com.mysql.jdbc.Driver");  
	/*----*/    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/torii","root","");    
	/*----*/    Statement stmt=conn.createStatement();
	/*----*/    String query=String.format("insert into carddetails (`name`,`cardno`,`cmonth`,`cvv`) values('%s','%s','%s','%s')", pname, pcard, pmonth, pcvv);
	/*----*/    stmt.execute(query);  
				Thread.sleep(4000);
				RequestDispatcher dispatcher = request.getRequestDispatcher("success.html");
				dispatcher.forward(request, response);
				
			} 
		    catch (Exception e) 
		    {
				System.out.println(e);
			}
	}

}
