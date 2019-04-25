package com.capg.bank.service;

import com.capg.bank.bean.Customer;
import com.capg.bank.dao.TransactionDao;
import com.capg.bank.dao.TransactionDaoImpl;

public class TransactionServiceImpl implements TransactionService{
	
	TransactionDao transactionDao=new TransactionDaoImpl(); // Transaction dao object

	public long deposit(Customer customer,long amt) {
		long res=transactionDao.deposit(customer,amt);
		return res;
	}

	public long withdrawl(Customer customer,long amt) {
		long res=transactionDao.withdrawl(customer,amt);
		return res;
	}

	public long dispBal(Customer customer,long amt) {
		long res=transactionDao.showBal(customer,amt);
		return res;
		
	}

}
