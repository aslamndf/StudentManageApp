package com.besant.serviceImpli;

import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.service.SignupService;
import com.besant.utils.JDBC;

public class SignupServiceImpli implements SignupService{
 
  
  @Override
  public void signup(HttpServletRequest req, HttpServletResponse res) {
   // TODO Auto-generated method stub
   System.out.println("Service code");
   System.out.println("name:");
   System.out.println(req.getParameter("email"));
   System.out.println(req.getParameter("password"));
   
  
  
 
  try {
   JDBC.jdbc(); // Ensure the connection is established
	String insertQuery = "INSERT INTO student.users_infom (name,email,password) VALUES (?,?,?);";
   PreparedStatement pre = JDBC.con.prepareStatement(insertQuery);
   PrintWriter out = res.getWriter();
   
   String name = req.getParameter("name");
   String email = req.getParameter("email");
   String password = req.getParameter("password");
   
//   System.out.println(name);
//   System.out.println(email);
//   System.out.println(password);
   
   pre.setString(1, name);
   pre.setString(2, email);
   pre.setString(3, password);
   
   int rowsAffected = pre.executeUpdate();
   
   if (rowsAffected > 0) {
	   res.sendRedirect("login.html");
    out.println("<h2>Success: Data successfully inserted into the database.</h2>");
   } else {
    out.println("<h2>Error: No rows inserted.</h2>");
   }
   out.println("<p>This is a basic servlet example in Java EE.</p>");
   out.println("</body></html>");
   
   // Close resources
   pre.close();
  } catch (Exception e) {
   System.out.println(e);
  }
  }
  

}
