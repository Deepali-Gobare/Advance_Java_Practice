package com.demo.servlete;

import java.io.IOException;
import java.io.PrintWriter;

import com.demo.beans.MyUser;
import com.demo.beans.Person;
import com.demo.services.LoginService;
import com.demo.services.LoginServicesImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String uname=request.getParameter("uname");
		String password=request.getParameter("passwd");
		String gender=request.getParameter("gender");
		String degree=request.getParameter("degree");
		String city=request.getParameter("city");
		String[] skills=request.getParameterValues("skills");
		LoginService ls=new LoginServicesImpl();
		Person p1=new Person(fname,lname,gender,degree,skills,city);
		MyUser u1=new MyUser(uname,password,"user");
		boolean status=ls.registerdetails(p1,u1);
		if(status) {
			//if registration is successful
			out.println("<h3>Registeration successfully done, Pls login</h3>");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request, response);
			
		}else {
			//registration is unsuccessful
			out.println("<h3>Registeration not done, Pls re-register</h3>");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request, response);
		
		}
		
	}

}
