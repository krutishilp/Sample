package com.zensar.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AppServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		String fname = req.getParameter("name1");
		String lname = req.getParameter("name2");
		req.setAttribute("fname", fname);
		req.setAttribute("lname", lname);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("showData");
		requestDispatcher.forward(req, res);

	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

		String fname = req.getParameter("name1");
		String lname = req.getParameter("name2");

		PrintWriter pw = res.getWriter();
		pw.print("<h1>Name is: " + fname + " " + lname + "</h1>");

	}

}
