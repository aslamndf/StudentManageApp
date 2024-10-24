package com.besant.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.serviceImpli.SignupServiceImpli;
import com.besant.serviceImpli.StudentinfoServiceImpli;

@WebServlet("/studentinfo")
public class StudentinfoController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) {

		StudentinfoServiceImpli studentinfoServiceImpli = new StudentinfoServiceImpli();
		studentinfoServiceImpli.studentinfo(req, res);

	}
}


