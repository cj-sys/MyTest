package com.example.mvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import com.example.model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MvcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	// response)

	// version1
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("MVC Select<br>");
		String color = request.getParameter("color");
		out.println("MVC color =" + color);
	}

	//version2
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//		String color = request.getParameter("color");
//		MvcModel model = new MvcModel();
//		ArrayList result = model.getColor(color);	
//		
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.println("MVC Select<br>");
//		
//		Iterator iterator = result.iterator();
//		while(iterator.hasNext()) {
//			out.print("<br>your choice: "+iterator.next());
//		}
//	}
	
	
	
//	// version3
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String color = request.getParameter("color");
//		MvcModel model = new MvcModel();
//		ArrayList result = result = model.getColor(color);
//
//		request.setAttribute("list", result);
//		RequestDispatcher view = request.getRequestDispatcher("result.jsp");
//		view.forward(request, response);
//
//	}
	
}
