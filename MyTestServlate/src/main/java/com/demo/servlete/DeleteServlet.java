package com.demo.servlete;

import java.io.IOException;

import com.demo.services.ProductServices;
import com.demo.services.ProductServicesImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		 int pid=Integer.parseInt(req.getParameter("pid"));
		ProductServices ps=new ProductServicesImpl();
		boolean status=ps.deleteById(pid);
		RequestDispatcher rd=req.getRequestDispatcher("showprod");
		rd.forward(req, res);
	}

}
