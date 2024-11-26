package com.demo.servlete;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;

import com.demo.beans.Product;
import com.demo.services.ProductServices;
import com.demo.services.ProductServicesImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditProductServlet extends HttpServlet  {
  public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
	  res.setContentType("text/html");
		PrintWriter out=res.getWriter();
	    int pid=Integer.parseInt(req.getParameter("pid"));
	    ProductServices ps=new ProductServicesImpl();
	    Product p=ps.getById(pid);
	    if(p!=null) {
	    	out.println("<form action='updateProd'>");
	    	out.println("Product id:<input type='text' name='pid' id='pid' value='"+p.getPid()+"' readonly><br>");
	    	out.println("Product name:<input type='text' name='pname' id='pname' value='"+p.getPname()+"'><br>");
	    	out.println("Product Quantity:<input type='text' name='qty' id='qty' value='"+p.getQty()+"'><br>");
	    	out.println("Product Price:<input type='text' name='price' id='price' value='"+p.getPrice()+"'><br>");
	    	String dt=p.getExpDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	    	out.println("Expriry date:<input type='text' name='date' id='date' value='"+dt+"'><br>");
	    	out.println("catagory id:<input type='text' name='cid' id='cid' value='"+p.getCid()+"'><br>");
	    	out.print("<button type='submit' name='btn' id='btn' value='update'>Update product</button>");
	    	out.println("</form><br>");
	    	
	    }else {
	    	RequestDispatcher rd=req.getRequestDispatcher("showprod");
	    	rd.forward(req, res);
	    }
  }
}
