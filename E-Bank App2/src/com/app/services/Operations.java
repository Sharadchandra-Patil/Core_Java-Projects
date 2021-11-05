package com.app.services;

import java.util.HashMap;

import com.app.account.Account;
import com.app.exceptions.AccountHandlingException;

public interface Operations {

	// only method declaration

	void addAccount(HashMap<Integer, Account> map, Account account) throws AccountHandlingException;

	void displayAllAccounts(HashMap<Integer, Account> map);

	void displayAccount(HashMap<Integer, Account> map, int accNumber) throws AccountHandlingException;

	Account getAccountByEmail(HashMap<Integer, Account> map, String email) throws AccountHandlingException;

	void removeAccountByEmail(HashMap<Integer, Account> map, String email) throws AccountHandlingException;

	Account getAccountByAccNumber(HashMap<Integer, Account> map, int accNumber) throws AccountHandlingException;

	Account getAccountByName(HashMap<Integer, Account> map, String Name) throws AccountHandlingException;

	Account getAccountByPhone(HashMap<Integer, Account> map, String phone) throws AccountHandlingException;

	void withDrawBalance(HashMap<Integer, Account> map, int accNum, double withDrawAmount)
			throws AccountHandlingException;

	void depositAmount(HashMap<Integer, Account> map, int accNum, double depositDrawAmt)
			throws AccountHandlingException;

	void transferAmount(HashMap<Integer, Account> map, double transferAmt, int accNum1, int accNum2)
			throws AccountHandlingException;

}
