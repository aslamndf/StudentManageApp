package com.besant.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ViewService {
	public void view(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;

}
