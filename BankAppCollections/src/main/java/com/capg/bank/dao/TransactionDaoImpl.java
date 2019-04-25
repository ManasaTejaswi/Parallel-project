package com.capg.bank.dao;

import com.capg.bank.bean.Customer;

public class TransactionDaoImpl implements TransactionDao {
	public long deposit(Customer customer, long amt) {

		
		customer.setBalance(customer.getBalance() + amt);
		return customer.getBalance();

	}

	public long withdrawl(Customer customer, long amt) {
		//System.out.println(customer.getAccountNo());
		int c = 0;
		if (amt < customer.getBalance()) {
			customer.setBalance(customer.getBalance() + amt);
			c++;
		}
		if (c == 0)
			return 0;
		else
			return customer.getBalance();
	}

	public long showBal(Customer customer, long amt) {

		return customer.getBalance();
	}

}