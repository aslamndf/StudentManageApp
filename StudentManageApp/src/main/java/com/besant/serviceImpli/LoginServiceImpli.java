package com.besant.serviceImpli;

import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.besant.model.User;
import com.besant.service.LoginService;
import com.besant.utils.JDBC;

public class LoginServiceImpli implements LoginService {

	public void login(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		try {
			JDBC.jdbc(); // Ensure the connection is established
			String insertQuery = "SELECT id, email FROM student.users_infom WHERE email = ? AND password = ?;";
			PreparedStatement pre = JDBC.con.prepareStatement(insertQuery);
			PrintWriter out = res.getWriter();
			
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			
			pre.setString(1, email);
			pre.setString(2, password);
			
			ResultSet resultSet = pre.executeQuery();
			if (resultSet.next()) {
				User user= new User();
				
				user.setId(resultSet.getInt("id"));
				HttpSession session = req.getSession();
				session.setAttribute("userid", resultSet.getInt("id"));
				
				System.out.println(user.getId());
				user.setEmail(resultSet.getString("email"));
				System.out.println(user.getEmail());
				res.sendRedirect("dashboard.html");
				out.println("logged in success");
			} else {
				out.println("logged in failed");
			}
			// Close resources
			pre.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
