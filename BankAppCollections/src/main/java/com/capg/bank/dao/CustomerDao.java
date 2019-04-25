package com.capg.bank.dao;

import com.capg.bank.bean.Customer;
import com.capg.bank.bean.Transaction;

public interface CustomerDao {
	Customer register(Customer customer);
	Customer login(long acc,String pswd);
	Transaction fundTransfer(Transaction transaction);

}
