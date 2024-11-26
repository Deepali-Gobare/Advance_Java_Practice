package com.demo.servlete;

import java.io.IOException;
import java.io.PrintWriter;

import com.demo.beans.MyUser;
import com.demo.services.LoginService;
import com.demo.services.LoginServicesImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("uname");
		String passwd=request.getParameter("passwd");
		LoginService ls=new LoginServicesImpl();
		MyUser user=ls.validateUser(uname,passwd);
		if(user!=null && user.getRole().equals("admin")) {
//			out.println("<h1>Login successful!!!</h1>");
			RequestDispatcher rd=request.getRequestDispatcher("showprod");
			rd.forward(request, response);
			
				
		}else {
			out.println("<h1>Wong Pass Or UserName</h1>");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request, response);
			out.println("text below Form");
		}
		
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		doGet(request,response);
	}
	
}
