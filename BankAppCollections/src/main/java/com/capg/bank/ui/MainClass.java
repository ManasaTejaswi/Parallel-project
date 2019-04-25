package com.capg.bank.ui;

import java.util.Scanner;

import com.capg.bank.bean.Customer;
import com.capg.bank.bean.Transaction;
import com.capg.bank.exception.InvalidIDException;
import com.capg.bank.exception.InvalidInputException;
import com.capg.bank.exception.TransactionException;
import com.capg.bank.exception.WithDrawlException;
import com.capg.bank.service.CustomerService;
import com.capg.bank.service.CustomerServiceImpl;
import com.capg.bank.service.TransactionService;
import com.capg.bank.service.TransactionServiceImpl;


public class MainClass{
	static Transaction transaction = new Transaction(); //transaction pojo class object
	static CustomerService custService = new CustomerServiceImpl(); //customer service object
	static TransactionService transactionService = new TransactionServiceImpl(); // transaction service object

	public static Scanner sc = new Scanner(System.in);

	public void transaction(Customer customer) {
		
		TransactionService transactionService = new TransactionServiceImpl(); //Transaction service object
	long amount = 0, res = 0;
		System.out.println("Enter your choice\n 1. Deposit\n 2. Withdraw\n 3. Show balance\n 4.Fund Transfer");
		int i = sc.nextInt();
		switch (i) {
		case 1:
			System.out.println("enter the amount you want to deposit");
			amount = sc.nextLong();
			res = transactionService.deposit(customer,amount);
			System.out.println("available Balance is : " + res);
			break;
			
		case 2:
			System.out.println("enter amount to debit");
			amount = sc.nextLong();
			res = transactionService.withdrawl(customer,amount);
			if (res != 0)
				System.out.println("Balance is" + res);
			else
				try {
					throw new WithDrawlException();
				} catch (WithDrawlException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			break;
		case 3:
			res = transactionService.dispBal(customer,amount);
			System.out.println("Balance is" + res);
			break;

		case 4:
			
			transaction.setFromAccountNo(customer.getAccountNo());
			System.out.println("enter destination account no");
			transaction.setToAccountNo(sc.nextLong());
			System.out.println("enter amount to be transferred");
			transaction.setAmountTransferred(sc.nextLong());
			transaction = custService.fundTransfer(transaction);
			if (transaction != null) {
				System.out.println(transaction.getAmountTransferred() + " is transferred from "
						+ transaction.getFromAccountNo() + " to " + transaction.getToAccountNo());
			System.out.println("Transaction Id is"+transaction.getTransactionId());
			}
			else
				try {
					throw new TransactionException();
				} catch (TransactionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	public static void main(String[] args) {
		
		MainClass main = new MainClass();
		Customer customer = new Customer();
		Customer customer1 = new Customer();
		Scanner sc = new Scanner(System.in);
		do {
		System.out.println("Enter your choice\n 1. Registration\n 2. Login\n 3.Exit");
		int ch = sc.nextInt();
		switch (ch) {
		case 1:
			System.out.println("Enter first name");
			customer.setFirstName(sc.next());
			System.out.println("Enter last name");
			customer.setLastName(sc.next());
			System.out.println("Enter email");
			customer.setEmailId(sc.next());
			System.out.println("Enter password");
			customer.setPassword(sc.next());
			System.out.println("Enter pancard no ");
			customer.setPancardNo(sc.nextLong());
			System.out.println("Enter aadhaar no");
			customer.setAadhaarNo(sc.nextLong());
			System.out.println("Enter address");
			customer.setAddress(sc.next());
			System.out.println("Enter mobile number");
			customer.setMobileNo(sc.nextLong());
			customer.setBalance(0);
			
			customer1 = custService.register(customer);
			
			if (customer1 == null) {
				try {
					throw new InvalidInputException();
				} catch (InvalidInputException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				System.out.println("Welcome "+customer1.getFirstName());
				System.out.println("Account No is " +customer1.getAccountNo());
			}
			break;
		case 2:
			System.out.println("enter account no");
			long acc = sc.nextLong();
			System.out.println("enter password");
			String pswd = sc.next();
			customer1 = custService.login(acc, pswd);
			if (customer1 != null) {
				System.out.println("welcome " + customer1.getFirstName());
				main.transaction(customer1);
			} else
				try {
					throw new InvalidIDException();
				} catch (InvalidIDException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			break;
		case 3:System.exit(0);

		}
		}while(true);
	}

}
