
package com.besant.serviceImpli;


import java.io.PrintWriter;
import java.sql.PreparedStatement;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.utils.JDBC;



public class DeleteStudentRecordServiceImpl {
	public void deleteStudentRecord(HttpServletRequest req, HttpServletResponse res) {
		System.out.println(req.getParameter("id"));


		try {
			JDBC.jdbc(); // Ensure the connection is established
			String insertQuery = "DELETE FROM student.studentinfo WHERE Sid=?;";
			PreparedStatement pre = JDBC.con.prepareStatement(insertQuery);
			PrintWriter out = res.getWriter();
			int id = Integer.parseInt(req.getParameter("id"));
			pre.setInt(1, id);
			int rowsAffected = pre.executeUpdate();
			if (rowsAffected > 0) {		
//				res.sendRedirect("dashboard.html");
				req.getRequestDispatcher("viewStudent.jsp").forward(req, res);
			} else {
				out.println("<h2>Error: No rows deleted. The record might not exist.</h2>");
			}
			pre.close();
//			 // Fetch the updated student list from the database
//            List<Student> updatedStudents = fetchAllStudents(); // Assuming you have this method
//            req.setAttribute("students", updatedStudents);
//
//            // Forward the request back to the JSP page
//            req.getRequestDispatcher("StudentView.jsp").forward(req, res);
//
//			
		} catch (Exception e) {
			System.out.println(e);
		}


	}
}