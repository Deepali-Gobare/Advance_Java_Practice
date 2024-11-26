package com.demo.servlete;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.demo.beans.Product;
import com.demo.services.ProductServices;
import com.demo.services.ProductServicesImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class productServlate extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		ProductServices ps=new ProductServicesImpl();
		List<Product> plist=ps.getAllData();
		if(plist!=null) {
			out.println("<table><tr><th>Product id</th><th>Product name</th><th>Qty</th><th>Price</th><th>Expriy Date</th><th>CatId</th><th>Action</th></tr>");
		  for(Product p:plist) {
			  out.println("<tr><td>"+p.getPid()+"</td><td>"+p.getPname()+"</td><td>"+p.getQty()+"</td><td>"+p.getPrice()+"</td>");
			  String dt=p.getExpDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			  out.println("<td>"+dt+"</td><td>"+p.getCid()+"</td>");
			  out.println("<td><a href='editprod?pid="+p.getPid()+"'>edit</a>/<a href='deleteProd?pid="+p.getPid()+"'>delete</a></td></tr>");
		  }
		  out.print("</table>");
			out.println("<form action='addProduct.html'>");
			  out.println("<button type='submit' name='btn' id='btn' value='add'>Add new Product</button>");
			out.println("</form>");
		}
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		doPost(request,response);
	}

}
