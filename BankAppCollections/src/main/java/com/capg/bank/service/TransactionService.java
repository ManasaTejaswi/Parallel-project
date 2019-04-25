package com.capg.bank.service;

import com.capg.bank.bean.Customer;

public interface TransactionService {

	long deposit(Customer customer,long amt);

	long withdrawl(Customer customer,long amt);

	long dispBal(Customer customer,long amt);

}
