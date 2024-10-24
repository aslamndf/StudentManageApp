package com.besant.controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.serviceImpli.SignupServiceImpli;
import com.besant.utils.JDBC;

@WebServlet("/signup")
public class SignupController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) {

		SignupServiceImpli signupServiceImpl = new SignupServiceImpli();
		signupServiceImpl.signup(req, res);

	}
}
