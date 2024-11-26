package com.demo.services;

import java.util.List;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServicesImpl implements ProductServices{
	ProductDao pdao;
	

	public ProductServicesImpl() {
		super();
		this.pdao = new ProductDaoImpl();
	}


	@Override
	public List<Product> getAllData() {
		// TODO Auto-generated method stub
		return pdao.saveData();
	}


	@Override
	public boolean insertData(Product p) {
		// TODO Auto-generated method stub
		return pdao.saveProduct(p);
	}


	


	@Override
	public boolean deleteById(int pid) {
		// TODO Auto-generated method stub
		return pdao.removeById(pid);
	}


	@Override
	public Product getById(int pid) {
		// TODO Auto-generated method stub
		return pdao.findById(pid);
	}


	@Override
	public boolean updateProduct(Product p) {
		// TODO Auto-generated method stub
		return pdao.modifyProduct(p);
	}

}
