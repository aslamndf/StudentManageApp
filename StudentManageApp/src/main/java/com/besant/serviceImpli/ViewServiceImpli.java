package com.besant.serviceImpli;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.model.Student;
import com.besant.service.ViewService;
import com.besant.utils.JDBC;

public class ViewServiceImpli implements ViewService {

	@Override
	public void view(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 //TODO Auto-generated method stub
		List<Student> students = new ArrayList<>();
		try {
			JDBC.jdbc();
			PreparedStatement pre = JDBC.con.prepareStatement("SELECT * FROM student.studentinfo");
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {

				Student student = new Student();

				student.setId(rs.getInt("Sid"));
				student.setName(rs.getString("name"));
				student.setDob(rs.getString("DOB"));
				student.setPhone(rs.getString("phone"));
				student.setEmail(rs.getString("email"));
				student.setAddress(rs.getString("address"));
				student.setDept(rs.getString("dept"));
				student.setPassout(rs.getString("passout"));
				student.setCreator_id(rs.getInt("creator_id"));
				student.setCreated_at(rs.getTimestamp("created_at"));
				
//				student.setStudentId(rs.getString("student_id"));
//				student.setCourse(rs.getString("course"));
//				student.setPassout(rs.getString("passout"));
//				student.setCreatorId(rs.getInt("creator_id"));
//				student.setCreatedAt(rs.getTimestamp("created_at"));
				students.add(student);
				System.out.println(students);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("students", students);
		System.out.println(students);
		req.getRequestDispatcher("viewStudent.jsp").forward(req, res);

	}

}
