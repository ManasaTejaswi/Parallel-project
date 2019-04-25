package com.capg.bank.bean;

public class Customer {
	private long accountNo;
	private long balance;
	private String firstName;
	private String lastName;
	private String emailId;
	private String password;
	private long pancardNo;
	private String address;
	private long aadhaarNo;
	private long mobileNo;
	
	public Customer() {
		super();
		
	}
	public Customer(long accountNo, long balance, String firstName, String lastName, String emailId, String password,
			long pancardNo, String address, long aadhaarNo, long mobileNo) {
		super();
		this.accountNo = accountNo;
		this.balance = balance;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
		this.pancardNo = pancardNo;
		this.address = address;
		this.aadhaarNo = aadhaarNo;
		this.mobileNo = mobileNo;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getPancardNo() {
		return pancardNo;
	}
	public void setPancardNo(long pancardNo) {
		this.pancardNo = pancardNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getAadhaarNo() {
		return aadhaarNo;
	}
	public void setAadhaarNo(long aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	
}
