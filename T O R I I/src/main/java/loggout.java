

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


public class loggout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public loggout() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		
		response.setHeader("Progma","no-cache");
		response.setHeader("Cache-Control","no-store, must-revalidate");
		response.setHeader("Expires","0");
		response.setDateHeader("Expires", 0);
		session.invalidate();
		
		
		try {
			Thread.sleep(3000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		response.sendRedirect("index.html");
		
		out.close();
		
	}

}
