import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class payment1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public payment1() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	    String pname=request.getParameter("pname");
	    String pcard=request.getParameter("pcard"); 
	    String pmonth=request.getParameter("pmonth"); 
	    String pcvv=request.getParameter("pcvv");
	    
	    try 
	    {
		    Class.forName("com.mysql.jdbc.Driver");  
/*----*/    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/torii","root","");    
/*----*/    Statement stmt=con.createStatement();
/*----*/    String query=String.format("insert into carddetails (`name`,`cardno`,`cmonth`,`cvv`) values('%s','%s','%s','%s')", pname, pcard, pmonth, pcvv);
/*----*/    stmt.execute(query);  
			Thread.sleep(4000);
			response.sendRedirect("success.html");
			
		} 
	    catch (Exception e) 
	    {
			System.out.println(e);
			out.println("Failed");
		}
	}

}



