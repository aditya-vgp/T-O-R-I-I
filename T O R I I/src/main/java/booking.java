import java.sql.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class booking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public booking() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter out = response.getWriter();  
		String ufullname = request.getParameter("ufullname");
		String uphone = request.getParameter("uphone"); 
		String uarivaldate = request.getParameter("uarivaldate"); 
		String utime = request.getParameter("utime");
		String upackage = request.getParameter("upackage");
		String upincode = request.getParameter("upincode"); 
		String utype = request.getParameter("utype"); /*This is where  want the value to be shared to the next servlet page*/
		String unationality = request.getParameter("unationality");
		
		
		
//	    
	    try 
	    {
		    Class.forName("com.mysql.jdbc.Driver");  
/*----*/    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/torii","root","");    
/*----*/    Statement stmt=con.createStatement();
/*----*/    String query=String.format("insert into booking (`name`,`phoneno`,`date`,`time`,`package`,`pincode`,`packagetype`,`nationality`) values('%s','%s','%s','%s','%s','%s','%s','%s')", ufullname, uphone, uarivaldate, utime, upackage, upincode, utype, unationality);
/*----*/    stmt.execute(query);  
			Thread.sleep(4000);
			response.sendRedirect("payment1.jsp");
			
			
		} 
	    catch (Exception e) 
	    {
			System.out.println(e);
			out.println("Failed");
		}
	}

}

