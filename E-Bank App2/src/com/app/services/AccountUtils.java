package com.app.services;

import java.util.HashMap;
import java.util.Scanner;

import com.app.account.Account;
import com.app.exceptions.AccountHandlingException;

public class AccountUtils implements Operations {

	// Add account into database
	public void addAccount(HashMap<Integer, Account> map, Account account) throws AccountHandlingException {
		if (account != null) {
			map.put(account.getAccNumber(), account);
		} else
			throw new AccountHandlingException("System error ...");

		System.out.println(account.getAcccType() + " Account having account number " + account.getAccNumber()
				+ " added successfully to bank database !!!");
	}

	// display all accounts
	public void displayAllAccounts(HashMap<Integer, Account> map) {
		for (Account account : map.values())
			System.out.println(account);
	}

	// display indivisual account
	public void displayAccount(HashMap<Integer, Account> map, int accNumber) throws AccountHandlingException {
		System.out.println("********************************************************");
		Account acc = map.get(accNumber);
		if (acc != null)
			System.out.println("Account information is : \n" + acc);
		else
			throw new AccountHandlingException("Account not found with this account number!!!");
	}

	// delete account using key
	public Account deleteAccount(HashMap<Integer, Account> map, int accNumber) throws AccountHandlingException {
		System.out.println("********************************************************");
		Account account = map.get(accNumber);
		if (account != null) {
			return map.remove(accNumber);
		}
		throw new AccountHandlingException("Invalid account Number");

	}

	// Remove account using email a non key value
	public void removeAccountByEmail(HashMap<Integer, Account> map, String email) throws AccountHandlingException {
		System.out.println("********************************************************");
		Account acc = getAccountByEmail(map, email);
		System.out.println("Account removed is :" + map.remove(acc.getAccNumber()));
	}

	// Retrieving record
	public Account getAccountByAccNumber(HashMap<Integer, Account> map, int accNumber) throws AccountHandlingException {
		System.out.println("********************************************************");
		Account acc = map.get(accNumber);
		if (acc != null)
			return acc;
		throw new AccountHandlingException("Invalid account number !!!");
	}

	// getting account by name
	public Account getAccountByName(HashMap<Integer, Account> map, String Name) throws AccountHandlingException {
		System.out.println("********************************************************");
		for (Account acc : map.values()) {
			if (acc.getName().equals(Name)) {
				return acc;
			}
		}
		throw new AccountHandlingException("No account found with this name...");
	}

	// get account by email
	public Account getAccountByEmail(HashMap<Integer, Account> map, String email) throws AccountHandlingException {

		System.out.println("********************************************************");
		int count = 0;
		Account account = null;
		for (Account acc : map.values()) {
			if (acc.getEmail().equals(email) && acc.getAcccType().equals("SAVING")) {
				System.out.println("Customer name : " + acc.getName() + " Account Number : " + acc.getAccNumber());
				account = acc;
				count++;
			}
			if (acc.getEmail().equals(email) && acc.getAcccType().equals("CURRENT")) {
				System.out.println("Customer name : " + acc.getName() + " Account Number : " + acc.getAccNumber());
				account = acc;
				count++;
			}
		}
		if (count == 1)
			return account;
		if (count ==2) {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			System.out.println("You have " + count + " accounts with this email !!!");
			System.out
					.print("\nSelect one of the option :\n  1. Display account info. \n  2. Remove account\n  3. Exit \nChoice :");
			int choice = sc.nextInt();
			if (choice == 1) {
				System.out.println("Enter account number...from above records");
				System.out.print("***********************************************************************************************************************\nAccount number :");
				System.out.println(map.get(sc.nextInt()));
				System.out.println("***********************************************************************************************************************");
			}
			if (choice == 2) {
				System.out.println("Enter account number... from above records");
				System.out.print("***********************************************************************************************************************\nAccount Number :");
				System.out.println("Account removed is : \n" + map.remove(sc.nextInt()));
				System.out.println("***********************************************************************************************************************");
				
			}
			throw new AccountHandlingException(" ");
		} else
			throw new AccountHandlingException("No account found with this email...");

	}

	// getting account by phone number
	public Account getAccountByPhone(HashMap<Integer, Account> map, String phone) throws AccountHandlingException {
		System.out.println("********************************************************");
		for (Account acc : map.values()) {
			if (acc.getPhone().equals(phone)) {
				return acc;
			}
		}
		throw new AccountHandlingException("No account found with this phone number...");
	}

//withdraw
	public void withDrawBalance(HashMap<Integer, Account> map, int accNum, double withDrawAmount)
			throws AccountHandlingException {
		Account acc = map.get(accNum);
		if (acc != null) {
			double balance = acc.getBalance();
			if (balance < 100 || ((balance - withDrawAmount) < 100))
				throw new AccountHandlingException("Insufficient balance !!!");

			System.out.println("********************************************************");
			System.out.println("Before withdrawal Account Balance = " + acc.getBalance());
			acc.setBalance(acc.getBalance() - withDrawAmount);
			System.out.println("After withdrawal \nUpdated balance for account number " + acc.getAccNumber() + " is :"
					+ acc.getBalance());
			return;
		}

		throw new AccountHandlingException("Invalid account number !!!");
	}

	// deposit
	public void depositAmount(HashMap<Integer, Account> map, int accNum, double depositAmt)
			throws AccountHandlingException {
		Account acc = map.get(accNum);
		if (acc != null) {
			System.out.println("********************************************************");
			System.out.println("Before deposit Account Balance = " + acc.getBalance());
			acc.setBalance(acc.getBalance() + depositAmt);
			System.out.println("After deposit Updated balance for account number " + acc.getAccNumber() + " is :"
					+ acc.getBalance());
		} else
			throw new AccountHandlingException("Invalid account number !!!");
	}

	// transfer
	public void transferAmount(HashMap<Integer, Account> map, double transferAmt, int accNum1, int accNum2)
			throws AccountHandlingException {
		AccountUtils obj = new AccountUtils();
		System.out.println("********************************************************");
		System.out.println("For account Number " + accNum1 + " ::");
		obj.withDrawBalance(map, accNum1, transferAmt);
		System.out.println("********************************************************");
		System.out.println("For account Number " + accNum2 + " ::");
		obj.depositAmount(map, accNum2, transferAmt);
	}
	
	//find acc by email and accType
	public static boolean getAccountByEmail_AccType(HashMap<Integer, Account> map, String email, String accType) throws AccountHandlingException {
		for(Account acc : map.values()) {
			if(acc.getEmail().equals(email)  && acc.getAcccType().equals(accType.toUpperCase())) {
				throw new AccountHandlingException("Customer "+ acc.getName()+ " already has " + acc.getAcccType()+ " account. Please choose other account type!!!");
			}
		}
		return true;
	}

}
