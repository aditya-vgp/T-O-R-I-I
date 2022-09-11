import java.sql.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class passlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public passlogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	    String passuser = request.getParameter("passuser");
	    HttpSession session=request.getSession();
		session.setAttribute("passuser",passuser);
	    String passpassword = request.getParameter("passpassword"); 
	    
	    String flag="false";
	   
	    if(LoginDao.validate(passuser, passpassword)){  
	    	try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	 HttpSession sess=request.getSession();
	 		sess.setAttribute("passuser",passuser);
	        RequestDispatcher rd=request.getRequestDispatcher("user.html");  
	        rd.forward(request,response);  
	    }  
	    else{  
	        out.print("Sorry username or password error");  
	        RequestDispatcher rd=request.getRequestDispatcher("login.html");  
	        rd.include(request,response);  
	    }  
	          
	    out.close();  
	  
	   
	    
	 }

}
