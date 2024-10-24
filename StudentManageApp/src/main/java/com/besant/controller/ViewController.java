package com.besant.controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.model.Student;
import com.besant.serviceImpli.LoginServiceImpli;
import com.besant.serviceImpli.ViewServiceImpli;
import com.besant.utils.JDBC;

@WebServlet("/view")
public class ViewController extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		ViewServiceImpli viewServiceImpli = new ViewServiceImpli();
		viewServiceImpli.view(req, res);
	}
}
