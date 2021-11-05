package com.app.account;

public class Account {

	// data fields --tight encapsulation
	// Account [accNumber,name,email, phone,balance]
	private int accNumber;
	private String name;
	private String email;
	private String phone;
	private double balance;
	private String accType;

	// constructor
	public Account(int accNumber, String name, String email, String phone, double balance, String accType) {
		super();
		this.accNumber = accNumber;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.balance = balance;
		this.accType = accType;
	}

	// getters and setters
	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getBalance() {
		return balance;
	}

	public int getAccNumber() {
		return accNumber;
	}

	public String getAcccType() {
		return accType;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	// toString method--display format
	@Override
	public String toString() {
		return " accNumber=" + accNumber + ", name=" + name + ", email=" + email + ", phone=" + phone + ", balance="
				+ balance;
	}

}
