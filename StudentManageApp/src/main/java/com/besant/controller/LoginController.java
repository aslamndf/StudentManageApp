package com.besant.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.serviceImpli.LoginServiceImpli;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) {

		LoginServiceImpli loginServiceImpli = new LoginServiceImpli();
		loginServiceImpli.login(req, res);
	}
}
