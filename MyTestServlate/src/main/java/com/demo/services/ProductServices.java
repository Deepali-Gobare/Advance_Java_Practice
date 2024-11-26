package com.demo.services;

import java.util.List;

import com.demo.beans.Product;

public interface ProductServices {

	List<Product> getAllData();

	boolean insertData(Product p);

	boolean deleteById(int pid);

	Product getById(int pid);

	boolean updateProduct(Product p);

}
