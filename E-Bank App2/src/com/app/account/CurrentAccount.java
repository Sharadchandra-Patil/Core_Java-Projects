package com.app.account;

public class CurrentAccount extends Account {

	// fields

	public static double interestRate;
	public static int accountOpeningFee;
	public static double accountMinBalance;

	// static initializer block
	static {
		interestRate = 7.5;
		accountOpeningFee = 500;
		accountMinBalance = 5000;
	}

	// constructor
	public CurrentAccount(int accNumber, String name, String email, String phone, double balance, String accType) {
		super(accNumber, name, email, phone, balance, accType); // calling superclass constructor
	}

	public static void setInterestRate(double interestRate) {
		CurrentAccount.interestRate = interestRate;
	}

	public static void setAccountOpeningFee(int accountOpeningFee) {
		CurrentAccount.accountOpeningFee = accountOpeningFee;
	}

	public static void setAccountMinBalance(double accountMinBalance) {
		CurrentAccount.accountMinBalance = accountMinBalance;
	}

	@Override
	public String toString() {
		return "Current Account [" + super.toString() + "]";
	}

}
