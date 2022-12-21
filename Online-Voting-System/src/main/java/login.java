

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

/**
 * Servlet implementation class login
 */
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out=  response.getWriter();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinevotingDB","root","12345678");
			String n= request.getParameter("adminName");
			String p= request.getParameter("password");
			PreparedStatement ps = con.prepareStatement("select adminName from Admin where adminName=? and adminPass=?");
			ps.setString(1, n);
			ps.setString(2,p);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				RequestDispatcher rd = request.getRequestDispatcher("adminWelcome.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("ERROR", "INVALID CREDENTIALS");
				RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
				rd.include(request, response);
//				out.println("<font color=red size =18> Login failed!!<br>");
//				out.println("<a href=admin.jsp> Try Again!!</a>");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
