<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> 
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>T O R I I</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
      crossorigin="anonymous"
    />
    <!-- External CSS -->
    <link rel="stylesheet" href="css/login.css" />
    <!-- Include Favicon -->
    <link rel="icon" href="assets/favicon2.ico" />
    <!-- To include Fontawesome -->
    
    <style>
table {
  border-collapse: collapse;
  width: 100%;
}
th {
color: white;
background-color: black;
}
th, td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px solid #f1f1f1;
  border-right:1px solid #f1f1f1;
  border-left:1px solid #f1f1f1;
  text-align: center;
}

tr:hover {background-color: #f1f1f1;}
</style>


    <script
      src="https://kit.fontawesome.com/8e66b110d2.js"
      crossorigin="anonymous"
    ></script>
  </head>
  <body style="background-image: url(assets/Adminback.jpg);">
 

    <!-- Intro -->
    <div class="container-fluid pt-5  welcome1" align="center">
      <div class="row justify-content-evenly px-2 py-2">
        <div class="col-md-12 col-sm-12 mx-1">
          <h1 class="h1">
            Welcome to
            <img
              class="mx-3"
              src="https://cdn-icons-png.flaticon.com/512/619/619044.png"
              width="34px"
              alt=""
            /><span class="text-dark">T O R I I</span>
          </h1>
          <p class="text-white">- your gateway to a getaway -</p>
        </div>
      </div>
    </div>

    <div class="container-fluid p-0 m-0">
      <!-- the actual content -->
      <br />
      <div class="container-fluid details bg-dark">
        <div class="row justify-content-evenly">
          
          <div class="col-md-12 col-sm-12 my-3 bg-white rounded mx-0 px-0 rounded" align="center">
           <h3 class="display-6 text-secondary bg-dark pb-2">User Details</h3>
            <%
try
{
       
	 Class.forName("com.mysql.jdbc.Driver");  
	 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/torii","root","");  
	 //Statement stmt1=con.createStatement();
	 String query2=String.format("SELECT * FROM booking JOIN carddetails;");
        PreparedStatement stmt = conn.prepareStatement(query2);
        ResultSet rs = stmt.executeQuery();
        if(rs.next()==false)
        {
            out.println("No Records in the table");
        }
        else
        {%>
			<div style="overflow-x:auto;">
            <table border="1" cellpadding="6" cellspacing="15" class="rounded py-0 my-0">
                <tr><th>ID</th><th>Name</th><th>Phone no</th><th>Date</th><th>Time</th><th>Package</th><th>Pincode</th><th>Type</th><th>Nationality</th><th>Card Holder Name</th><th>Card no</th><th>Expiry Month</th><th>CVV</th></tr>

                <%
                do
                {%>

                    <tr><td><%= rs.getString(1)%></td><td><%= rs.getString(2)%></td><td><%= rs.getString(3)%></td><td><%= rs.getString(4)%></td><td><%= rs.getString(5)%></td><td><%= rs.getString(6)%></td><td><%= rs.getString(7)%></td><td><%= rs.getString(8)%></td><td><%= rs.getString(9)%></td><td><%= rs.getString(11)%></td><td><%= rs.getString(12)%></td><td><%= rs.getString(13)%></td><td><%= rs.getString(14)%></td></tr>

                    <%}while(rs.next());
                }
               
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            e.getStackTrace();
        }
        %>

    </table>
	</div>


          </div>
          <!-- 2nd table -->
          <div class="col-md-12 col-sm-12 my-3 bg-white rounded mx-0 px-0 rounded" align="center">
           <h3 class="display-6 text-secondary bg-dark pb-2">User Feedback</h3>
            <%
try
{
       
	 Class.forName("com.mysql.jdbc.Driver");  
	 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/torii","root","");  
	 //Statement stmt1=con.createStatement();
	 String query3=String.format("SELECT * FROM feedback;");
        PreparedStatement stmt1 = conn.prepareStatement(query3);
        ResultSet rs1 = stmt1.executeQuery();
        if(rs1.next()==false)
        {
            out.println("No Records in the table");
        }
        else
        {%>
			<div style="overflow-x:auto;">
            <table border="1" cellpadding="8" cellspacing="15" class="rounded py-0 my-0"">
                <tr><th>Name</th><th>Mail</th><th>Satisfaction Level</th><th>Improvement Range</th><th>Comments</th></tr>

                <%
                do
                {%>

                    <tr><td><%= rs1.getString(2)%></td><td><%= rs1.getString(3)%></td><td><%= rs1.getString(4)%></td><td><%= rs1.getString(5)%></td><td><%= rs1.getString(6)%></td></tr>

                    <%}while(rs1.next());
                }
               
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            e.getStackTrace();
        }
        %>

    </table>
	</div>


          </div>
        </div>
      </div>

    
    </div>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
