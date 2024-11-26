package com.demo.servlete;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.demo.beans.Product;
import com.demo.services.ProductServices;
import com.demo.services.ProductServicesImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateProduct extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		   int pid=Integer.parseInt(req.getParameter("pid"));
		   String pname=req.getParameter("pname");
		   int qty=Integer.parseInt(req.getParameter("qty"));
		   double price=Double.parseDouble(req.getParameter("price")); 
		   String dt=req.getParameter("date");
		  
		LocalDate ldt=LocalDate.parse(dt,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		int cid=Integer.parseInt(req.getParameter("cid"));
		Product p=new Product(pid,pname,qty,price,ldt,cid);
		ProductServices ps=new ProductServicesImpl();
		boolean status=ps.updateProduct(p);
		RequestDispatcher rd=req.getRequestDispatcher("showprod");
		rd.forward(req, res);
		
		
	}
}
