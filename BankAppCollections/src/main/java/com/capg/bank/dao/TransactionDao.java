package com.capg.bank.dao;

import com.capg.bank.bean.Customer;

public interface TransactionDao {

	long deposit(Customer customer,long amt);
	long withdrawl(Customer customer,long amt);
	long showBal(Customer customer,long amt);

}
