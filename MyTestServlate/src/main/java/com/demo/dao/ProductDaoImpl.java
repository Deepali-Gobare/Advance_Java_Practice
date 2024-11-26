package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Product;
import com.mysql.cj.protocol.Resultset;

public class ProductDaoImpl implements ProductDao{
	
	static private Connection conn;
	static private PreparedStatement ps,addProduct,delpro,getid,updpro;
	static {
		conn=DBUtil.getMyConnection();
		try {
			ps=conn.prepareStatement("select * from product");
			addProduct=conn.prepareStatement("insert into product values(?,?,?,?,?,?)");
			delpro=conn.prepareStatement("Delete from product where pid=?");
			getid=conn.prepareStatement("select * from product where pid=?");
			updpro=conn.prepareStatement("update product set pname=?,qty=?,price=?,expdate=?,cid=? where pid=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Product> saveData() {
		List<Product> plist=new ArrayList<>();
		try {
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				plist.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getDate(5).toLocalDate(),rs.getInt(6)));
			}
			if(plist.size()>0) {
				return plist;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean saveProduct(Product p) {
         try {
			addProduct.setInt(1,p.getPid());
			addProduct.setString(2,p.getPname());
			addProduct.setInt(3,p.getQty());
			addProduct.setDouble(4,p.getPrice());
			addProduct.setDate(5,java.sql.Date.valueOf(p.getExpDate()));
			addProduct.setInt(6,p.getCid());
			int n=addProduct.executeUpdate();
			if(n>0) {
				return true;
			}
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		return false;
	}



	@Override
	public boolean removeById(int pid) {
	   try {
		delpro.setInt(1, pid);
		int n=delpro.executeUpdate();
		if(n>0) {
			return true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return false;
	}

	@Override
	public Product findById(int pid) {
	     try {
			getid.setInt(1, pid);
			ResultSet rs=getid.executeQuery();
			if(rs.next()) {
				return new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getDate(5).toLocalDate(),rs.getInt(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean modifyProduct(Product p) {
		
		try {
			updpro.setString(1, p.getPname());
			updpro.setInt(2, p.getQty());
			updpro.setDouble(3, p.getPrice());
			updpro.setDate(4, java.sql.Date.valueOf(p.getExpDate()));
			updpro.setInt(5, p.getCid());
			updpro.setInt(6, p.getPid());
			int n=updpro.executeUpdate();
			if (n>0) {
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

}
