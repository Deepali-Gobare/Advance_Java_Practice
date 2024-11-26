package com.demo.services;

import com.demo.beans.MyUser;
import com.demo.beans.Person;
import com.demo.dao.LoginDao;
import com.demo.dao.LoginDaoImpl;

public class LoginServicesImpl implements LoginService {
	LoginDao ldao;
	public LoginServicesImpl() {
		super();
		this.ldao = new LoginDaoImpl();
	}

	@Override
	public MyUser validateUser(String uname, String passwd) {
		
		return ldao.authenticateUSer(uname,passwd);
	}

	@Override
	public boolean registerdetails(Person p1, MyUser u1) {
		// TODO Auto-generated method stub
		return ldao.savedetails(p1,u1);
	}

}
