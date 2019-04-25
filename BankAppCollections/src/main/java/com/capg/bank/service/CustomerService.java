package com.capg.bank.service;

import com.capg.bank.bean.Customer;
import com.capg.bank.bean.Transaction;

public interface CustomerService {
	Customer register(Customer customer);
	Customer login(long acc, String pswd);
	Transaction fundTransfer(Transaction transaction);

}
