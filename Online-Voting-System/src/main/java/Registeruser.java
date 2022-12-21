/*

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class Registeruser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
		
		try{
			PrintWriter out=  response.getWriter();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinevotingDB","root","12345678");
			
	           String name = request.getParameter("fullname");
	           String ID_number = request.getParameter("IDnumber");
	           String password = request.getParameter("password");
	           String gender = request.getParameter("gender");
	           String contact = request.getParameter("phonenumber");
	           String email = request.getParameter("email");
	           
	    
			   
	          PreparedStatement ps = con.prepareStatement("insert into Register (full_name,ID,Email,Phone_Number,Password,Gender)values('"+name+"','"+ID_number+"','"+email+"','"+contact+"','"+password+"','"+gender+"')");
			  ps.executeUpdate();
			  ResultSet rs = ps.executeQuery();
			  if(rs.next())
				{
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
				}
//			  response.sendRedirect("index.jsp");
        
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}*/

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class RegisterUser
 */
public class Registeruser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String name = request.getParameter("fullname");
        String ID_number = request.getParameter("IDnumber");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String contact = request.getParameter("phonenumber");
        String email = request.getParameter("email");
        RequestDispatcher dispatcher = null;
        Connection con = null;
       try {
    	   Class.forName("com.mysql.cj.jdbc.Driver");
    	   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinevotingDB","root","12345678");
    	   PreparedStatement ps = con.prepareStatement("insert into Register (Full_name,ID,Email,Phone_Number,Password,Gender)values(?,?,?,?,?,?)");
    	   ps.setString(1,name);  
    	   ps.setString(2,ID_number);
    	   ps.setString(3,email);
    	   ps.setString(4,contact);
    	   ps.setString(5,password);  
    	   ps.setString(6,gender);  
    	   
    	   int rowcnt = ps.executeUpdate();
    	   dispatcher = request.getRequestDispatcher("register.jsp");
    	   if(rowcnt > 0) {
    		   request.setAttribute("status", "success"); 
    		   dispatcher = request.getRequestDispatcher("index.jsp");
    	   }else {
    		   request.setAttribute("status", "failed");
    	   }
    	     dispatcher.forward(request, response);
    	    
       }catch (Exception e) {
    	   e.printStackTrace();
       }finally {
    	   try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       }
 
	}
}



