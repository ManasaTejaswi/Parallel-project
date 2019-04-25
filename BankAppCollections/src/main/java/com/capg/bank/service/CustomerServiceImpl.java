package com.capg.bank.service;

import com.capg.bank.bean.Customer;
import com.capg.bank.bean.Transaction;
import com.capg.bank.dao.CustomerDao;
import com.capg.bank.dao.CustomerDaoImpl;

public class CustomerServiceImpl implements CustomerService {

	CustomerDao custDao = new CustomerDaoImpl(); //Customer dao object
	Customer customer = new Customer(); //Customer pojo class object
	
	boolean validateUserInput(Customer customer) {
		boolean b=false;
	
		long number=customer.getMobileNo();
		String num=String.valueOf(number);
		if (num.length() == 10) {
			if (String.valueOf(customer.getAadhaarNo()).length() == 12) {
				b=true;
			} else
				b=false;
		} else
			b=false;
		
		return b;
		
	}

	public Customer register(Customer customer) {
		boolean b= validateUserInput(customer);
		if(b) {
			customer = custDao.register(customer);
			return customer;
		}
		else
			return null;

	}

	public Customer login(long acc, String pswd) {
		customer = custDao.login(acc, pswd);
		return customer;

	}

	public Transaction fundTransfer(Transaction transaction) {
		transaction=custDao.fundTransfer(transaction);
		return transaction;
	}

}
