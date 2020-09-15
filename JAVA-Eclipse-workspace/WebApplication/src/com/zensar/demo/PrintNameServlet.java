package com.zensar.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrintNameServlet extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String fname = req.getParameter("name1");
		String lname = req.getParameter("name2");

		PrintWriter writer = res.getWriter();
		writer.print("The Name is: " + fname + " " + lname);
	}

}
