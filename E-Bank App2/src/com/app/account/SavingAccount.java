package com.app.account;

public class SavingAccount extends Account {

	// fields
	public static double interestRate;
	public static int accountOpeningFee;
	public static double accountMinBalance;

	// static initializer block
	static {
		interestRate = 3.5;
		accountOpeningFee = 500;
		accountMinBalance = 1000;
	}

	// getters and setters

	public static void setInterestRate(double interestRate) {
		SavingAccount.interestRate = interestRate;
	}

	public static void setAccountOpeningFee(int accountOpeningFee) {
		SavingAccount.accountOpeningFee = accountOpeningFee;
	}

	public static void setAccountMinBalance(double accountMinBalance) {
		SavingAccount.accountMinBalance = accountMinBalance;
	}

	// constructor
	public SavingAccount(int accNumber, String name, String email, String phone, double balance, String accType) {
		super(accNumber, name, email, phone, balance, accType); // calling superclass constructor
	}

	@Override
	public String toString() {
		return "Saving Account [" + super.toString() + "]";
	}

}
