package utils;

import static tester.CustomerManagement.*;
import static utils.ValidationRules.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.app.customers.Customer;
import com.app.customers.Plan;

import custom_exception.CustomerHandlingException;

public class CustomerServices {
	public static Scanner sc = new Scanner(System.in);

	//Adding customer ******************************
	
	public static void registerCustomer() throws CustomerHandlingException, ParseException {

		double regAmt;
		String name, email = null, password, date, plan;
		int reEnterChance = 1;

		System.out.print(" Please enter customer details::\n  Customer Name : ");
		name = sc.next();

		while (true && reEnterChance++ < 4) {
			System.out.print("\n  Customer e-mail : ");
			email = sc.next();
			if (emailValidationAndDuplicateChecking(email, customers))
				break;
			if (reEnterChance == 4) {
				System.out.println(
						"\n********* I think you are not legal user. Can't continue. Closing application. Bye Bye...");
				System.exit(0);
			}
			continue;
		}

		System.out.print("\n  Password (Length min=4 max=10) : ");
		password = sc.next();
		validatePassword(password);

		System.out.print("\n Please choose plan from following list ::");
		System.out.print(sb.toString());
		System.out.print("  Plan : ");
		plan = sc.next();
		Plan p = validatePlan(plan);

		System.out.print("\n  Registration Amount(Multiple of Rs. 500) : ");
		regAmt = sc.nextDouble();
		validateRegiAmount(regAmt);

		System.out.print("\n  Date of Birth (dd-MM-yyyy) : ");
		date = sc.next();
		Date dt = validateDoB(date);
		Customer c = new Customer(name, email, password, regAmt, dt, p);
		customers.add(c);
		System.out.println("\n Customer registered and added successfully...");
		System.out.println("\n*******************************************************************************");

	}

	
	//Customer login **************************************
	
	public static void customerLogin() throws CustomerHandlingException {
		System.out.print(" Enter email and password for login :: \n  Email Id : ");
		String email = sc.next();
		System.out.print("  Password :");
		String password = sc.next();

		Customer c1 = findByEmail(email);
		if (c1.getPassword().equals(password))
			;
		System.out.println("You logged in successfully.");
		while (true) {
			System.out.println(
					"\n Choose one of the options :\n  1.Display account information \n  2.Change login password \n  3.Exit");
			switch (sc.nextInt()) {
			case 1:
				System.out.println("  Customer Information :\n" + c1.toString());
				break;
			case 2:
				System.out.println("  Enter new password :");
				validatePassword(sc.next());
				c1.changePassword(password);
				System.out.println(" Password changed successfully.");
				break;
			case 3:
				String[] args = null;
				main(args);
				break;

			default:
				System.out.println(" Invalid choice!!!!");
				break;
			}
		}

	}

	
	// finding customer using PK email **************************
	
	public static Customer findByEmail(String email) throws CustomerHandlingException {
		Customer temp = new Customer(email);
		for (Customer cust : customers) {
			System.out.println(cust);
			if (cust != null)
				if (temp.equals(cust))
					return cust;
		}
		throw new CustomerHandlingException("Customer with this email id does not exist!!!");
	}
	
	
	//adhar linking  **********************************
	
	public static void linkAdharToCustomerAccount() throws CustomerHandlingException {
		System.out.print("Ask customer email id : \n  Email-Id :: ");
		String email = sc.next();
		Customer cust = findByEmail(email);
		System.out.print(" Ask user adhar number and location : \n  Adhar Number :: ");
		String number = sc.next();
		System.out.print("  Location :: ");
		String location = sc.next();
		cust.linkAdharNumber(number, location);
		System.out.println(" Adhaar linked successfully...");
	}
	
	
	//un-subscribe customer ***********************************
	
	public static void unSubscribeCustomer() throws CustomerHandlingException {
		System.out.print(" Ask user email: \n  E-mail : ");
		String email = sc.next();
		Customer cust = findByEmail(email);
		customers.remove(cust);
		System.out.println(" Customer named "+ cust.getCustomerName() +" removed successfully from list..");
	}
	

	//	displayAllCustomers ******************************

	public static void 	displayAllCustomers() {
		for(Customer cust : customers) {
			System.out.println(cust);
		}
	}
	
	//displayAllCustomerNamesWithSpecificPlan *************************
	
	public static void displayAllCustomerNamesWithSpecificPlan() throws CustomerHandlingException{
		System.out.print("Plese enter plan : \n  Plan :: ");
		String p = sc.next();
		Plan plan = validatePlan(p);
		System.out.println("\n Customer names are :");
		for(Customer cust : customers) {
			if(cust.getPlan().name().equals(plan.name()))
				System.out.println("  "+cust.getCustomerName());
		}
	}
	
	//displayAllCustomerBornAfterGivenDate() ****************************
	
	public static void displayAllCustomersBornAfterGivenDate() throws ParseException, CustomerHandlingException {
		
		System.out.print("Enter date(dd-MM-yyyy) format. \n Date :  ");
		String dt_str = sc.next();
		Date date = validateDoB(dt_str);
		System.out.println("\n List of customers is :");
		for(Customer cust : customers)
			if(cust.getDate().after(date))
				System.out.println("  " + cust);
				
	}
	
	//displayAllCustomersAtGivenLocation() ********************************
	
	public static void displayAllCustomersAtGivenLocation() {
		System.out.print("Enter location \n Location : ");
		String location =  sc.next();
		System.out.println("\n List of customers at location "+ location + " is :");
		for(Customer cust : customers)
			if(location.equals(cust.getAdharLocation()))
				System.out.println("  "+ cust);
	}

}
