package com.capg.bank.daotest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capg.bank.bean.Customer;
import com.capg.bank.bean.Transaction;
import com.capg.bank.dao.CustomerDao;
import com.capg.bank.dao.CustomerDaoImpl;

class BankDaoTest {

	static CustomerDao dao;
	 
 	@BeforeAll
 	public static void init() {
 		dao=new CustomerDaoImpl();
 	}

 	@Test
	public void testLogin() {
		Customer customer=dao.login(71234788, "po");
		assertEquals(-1, customer.getAccountNo());
	}
@Test
void testRegistration() {
	Customer customer=new Customer();
	customer.setFirstName("Manasa");
	customer.setLastName("Tejaswi");
	customer.setAadhaarNo(123412391);
	customer.setAddress("Hyderabad");
	customer.setBalance(500);
	customer.setEmailId("manasa23@gmil.com");
	customer.setMobileNo(75123456);
	customer.setPancardNo(123456);
	customer.setPassword("manasa");
	customer=null;
	assertEquals(-1,dao.register(customer));
}

@Test
void testValidation() {
	assertEquals(true, dao.login(0, "12356788"));
}


	@Test
void testFundTransfer() {
	Transaction transaction=new Transaction();
	transaction.setFromAccountNo(123456789);
	transaction.setToAccountNo(123456787);
	transaction.setAmountTransferred(1000);
	assertEquals(100,dao.fundTransfer(transaction));
}

}
