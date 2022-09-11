import java.sql.*;

import javax.servlet.AdminLoginDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class adminlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public adminlogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	    String adminuser = request.getParameter("adminuser");
	    HttpSession session=request.getSession();
		session.setAttribute("adminuser",adminuser);
	    String adminpass = request.getParameter("adminpass"); 
	    
	   if(adminuser.equals("Aoi Mizuhara") && adminpass.equals("aoi_sora_suki")) {
		   try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		   response.sendRedirect("admininterface.jsp");
	   }
		   else
			   response.sendRedirect("adminlogin.html");
	   }
	  
	  }


