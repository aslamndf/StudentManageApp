package com.besant.controller;


import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.serviceImpli.DeleteStudentRecordServiceImpl;





@WebServlet("/delete")
public class DeleteStudentRecordController extends HttpServlet  {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get the student ID from the request URI or parameters
		String idParam = request.getParameter("id");
		System.out.println(idParam);
		
		DeleteStudentRecordServiceImpl deleteStudentRecordServiceImpl = new DeleteStudentRecordServiceImpl();
		deleteStudentRecordServiceImpl.deleteStudentRecord(request, response);
	}
}







