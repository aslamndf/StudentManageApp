package com.besant.serviceImpli;

import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.besant.model.Student;
import com.besant.model.User;
import com.besant.service.StudentinfoService;
import com.besant.utils.JDBC;

public class StudentinfoServiceImpli implements StudentinfoService {

	public void studentinfo(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		System.out.println("Service code");
		System.out.println("name:");
		System.out.println(req.getParameter("name"));
		System.out.println(req.getParameter("dob"));
		System.out.println(req.getParameter("phone"));
		System.out.println(req.getParameter("email"));
		System.out.println(req.getParameter("address"));
		System.out.println(req.getParameter("dept"));
		System.out.println(req.getParameter("passout"));

		try {
			JDBC.jdbc(); // Ensure the connection is established
			String insertQuery = "INSERT INTO student.studentinfo (name,dob,phone,email,address,dept,passout,creator_id) VALUES (?,?,?,?,?,?,?,?);";
			PreparedStatement pre = JDBC.con.prepareStatement(insertQuery);
			PrintWriter out = res.getWriter();

			Student student = new Student();
			student.setName(req.getParameter("name"));
			student.setDob(req.getParameter("dob"));
			student.setPhone(req.getParameter("phone"));
			student.setEmail(req.getParameter("email"));
			student.setAddress(req.getParameter("address"));
			student.setDept(req.getParameter("dept"));
			student.setPassout(req.getParameter("passout"));
//			student.setPassout(req.getParameter("creator_id"));
			
			HttpSession session = req.getSession();
			int id = (int) session.getAttribute("userid");
			System.out.println(id);

//			String name = req.getParameter("name");
//			String dob = req.getParameter("dob");
//			String phone = req.getParameter("phone");
//			String email = req.getParameter("email");
//			String address = req.getParameter("address");
//			String dept = req.getParameter("dept");
//			String passout = req.getParameter("passout");

			// System.out.println(name);
			// System.out.println(email);
			// System.out.println(password);

			pre.setString(1, student.getName());
			pre.setString(2, student.getDob());
			pre.setString(3, student.getPhone());
			pre.setString(4, student.getEmail());
			pre.setString(5, student.getAddress());
			pre.setString(6, student.getDept());
			pre.setString(7, student.getPassout());
			pre.setInt(8, id);

			int rowsAffected = pre.executeUpdate();

			if (rowsAffected > 0) {
				res.sendRedirect("dashboard.html");
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
