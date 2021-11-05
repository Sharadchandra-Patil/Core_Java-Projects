package com.app.utils;

import static com.app.utils.UniqueAccountNumberGenerator.uniqueAccountNumberGenerator;

import java.util.HashMap;

import com.app.account.Account;
import com.app.account.CurrentAccount;
import com.app.account.SavingAccount;
import com.app.exceptions.AccountHandlingException;
import com.app.services.AccountUtils;

public class ValidationRules {

	// validate all inputs
	public static Account validateAllInputs(HashMap<Integer, Account> map,String name, String email, String phone, double deposit, String accType)
			throws AccountHandlingException {
		Account account = null;
		if(AccountUtils.getAccountByEmail_AccType(map, email, accType)) {
		if (accType.toUpperCase().equals("SAVING")) {
			account = new SavingAccount(uniqueAccountNumberGenerator(), validateName(name), validateEmail(email),
					validatePhone(phone), validateBalance(deposit), accType.toUpperCase());
			return account;
		}
		if (accType.toUpperCase().equals("CURRENT")) {
			account = new CurrentAccount(uniqueAccountNumberGenerator(), validateName(name), validateEmail(email),
					validatePhone(phone), validateBalance(deposit), accType.toUpperCase());
			return account;
		}
		throw new AccountHandlingException("Invalid account type");
		}
		throw new AccountHandlingException(" ");
	}

	// name validation
	public static String validateName(String name) throws AccountHandlingException {
		if (name.length() < 5)
			throw new AccountHandlingException("Name must have more than five characters!!!");
		return name;
	}

	// balance validation
	public static double validateBalance(double balance) throws AccountHandlingException {
		if (balance <= 100)
			throw new AccountHandlingException(
					"Insufficient balance. Please ensure balance more than 100 to avoid mimimum balance charges!!!");
		return balance;
	}

	// email validation
	public static String validateEmail(String email) throws AccountHandlingException {
		if (email.contains("@") && email.endsWith(".com"))
			return email;
		throw new AccountHandlingException("Invaild email format!!!");
	}

	// phone number validation
	public static String validatePhone(String phone) throws AccountHandlingException {
		if (phone.length() < 10)
			throw new AccountHandlingException("Check phone numbers digit!!!");
		return phone;
	}

}
