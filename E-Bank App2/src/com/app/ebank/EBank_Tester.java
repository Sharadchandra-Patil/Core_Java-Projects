package com.app.ebank;

import static com.app.utils.CollectionUtils.populateSampleData;
import static com.app.utils.ValidationRules.validateAllInputs;
import static customer_tester.CustomerManagement.customerManagement;

import java.util.HashMap;
import java.util.Scanner;

import com.app.account.Account;
import com.app.services.AccountUtils;

public class EBank_Tester {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			AccountUtils accUtil = new AccountUtils();
			HashMap<Integer, Account> accounts = new HashMap<Integer, Account>();
			accounts = populateSampleData();
			System.out.println("*************************************************************************");
			System.out.println("\n#####################  Welcome to your own EBank  #######################");
			System.out.println("\n## Bank Administrator services ## ");

			while (true) {
				try {

					System.out.println("\nPress one of the Menus to avail service : \n" 
							+ "  1. Add Account\r\n"
							+ "  2. Display an Account\r\n" 
							+ "  3. Display All Accounts\r\n"
							+ "  4. Remove an Account by email\r\n" 
							+ "  5. Withdraw\r\n" 
							+ "  6. Deposit\r\n"
							+ "  7. Transfer\r\n" 
							+ "  8. Search account using name\r\n"
							+ "  9. Search account using email\r\n" 
							+ " 10. Search account using phone\r\n"
							+ " 11. Searching account using account number\r\n" 
							+ " 12. Credit Card services and Insurance Services \n"
							+ " 13. Exit. ");
					System.out.print("\nYour choice : ");

					switch (sc.nextInt()) {
					case 1:
						System.out.println(
								"\nPlease ask customer to enter information in following order ::\n[Name(>than 5 char) email(@ & .com format)  phone(10 digit) deposit(>100 Rs) accType]");
						// validating and creating account object
						Account newAcc = validateAllInputs(accounts,sc.next(), sc.next(), sc.next(), sc.nextDouble(), sc.next());

						// calling addAccount method using AccountUtils object accUtil
						System.out.println("********************************************************");
						System.out.println("Congrats " + newAcc.getName().toUpperCase() + " your "
								+ newAcc.getAcccType().toUpperCase() + " Account created successfully!!!\n");
						accUtil.addAccount(accounts, newAcc);
						System.out.println("********************************************************");
						break;

					case 2:
						System.out.print("\nEnter account number :");
						int accNum = sc.nextInt();
						accUtil.displayAccount(accounts, accNum);
						System.out.println("********************************************************");
						break;

					case 3:
						System.out.println("\nAll accounts information :");
						System.out.println("***********************************************************************************************************************");
						accUtil.displayAllAccounts(accounts);
						System.out.println("***********************************************************************************************************************");
						break;

					case 4:
						System.out.print("\nEnter email :");
						accUtil.removeAccountByEmail(accounts, sc.next());
						System.out.println("********************************************************");
						break;

					case 5: // withdraw
						System.out.print("\nEnter account number and withdraw amount :");
						accUtil.withDrawBalance(accounts, sc.nextInt(), sc.nextDouble());
						System.out.println("********************************************************");
						break;

					case 6:// deposit
						System.out.print("\nEnter account number and deposit amount :");
						accUtil.depositAmount(accounts, sc.nextInt(), sc.nextDouble());
						System.out.println("********************************************************");
						break;

					case 7: // transfer
						System.out.print(
								"\nEnter two  account numbers from to transfer amount : amount accNum1 accNum2 ");
						accUtil.transferAmount(accounts, sc.nextDouble(), sc.nextInt(), sc.nextInt());
						System.out.println("@@Transfer successful !!!!!");
						System.out.println("********************************************************");
						break;

					case 8: // Search account using name
						System.out.print("\nEnter name for finding account : ");
						Account account = accUtil.getAccountByName(accounts, sc.next());
						System.out.println("Account details are : " + account);
						System.out.println("********************************************************");
						break;

					case 9: // Search account using email
						System.out.print("\nEnter email for finding account : ");
						Account account1 = accUtil.getAccountByEmail(accounts, sc.next());
						System.out.println("Account details are : " + account1);
						System.out.println("********************************************************");
						break;

					case 10: // Search account using phone
						System.out.print("\nEnter phone for finding account : ");
						Account account2 = accUtil.getAccountByPhone(accounts, sc.next());
						System.out.println("Account details are : " + account2);
						System.out.println("********************************************************");
						break;

					case 11: // Search account using accountNum
						System.out.print("\nEnter account number  for finding account : ");
						Account account3 = accUtil.getAccountByAccNumber(accounts, sc.nextInt());
						System.out.println("Account details are : " + account3);
						System.out.println("********************************************************");
						break;

					case 12: // credit card services
						customerManagement();
						break;
					
					case 13: // Exit
						System.out.println("\n********* Thank you for using application ********** \n");
						System.exit(0);
						break;
					default:
						System.out.println("\nInvalid choice !!!");
						break;
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				sc.nextLine(); // to empty scanner buffer after exception cought
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
