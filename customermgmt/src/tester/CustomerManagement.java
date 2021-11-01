package tester;

import static utils.CustomerServices.*;
import static utils.CollectionUtils.readySampleData;

import java.util.ArrayList;
import java.util.Scanner;

import com.app.customers.Customer;

public class CustomerManagement {
	
	public static ArrayList<Customer> customers = new ArrayList<>();
	
	public static void main(String[] args) {
		System.out.println("\n***************  Welcome to Customer Management Portal  ******************");

		// try with resources block
		try (Scanner sc = new Scanner(System.in)) {
			
			customers = readySampleData();

			while (true) {

				System.out.print("\n Please choose one of the following options...\r\n"
						+ "  1 :: Register new customer\r\n" + "  2 :: Customer Login\r\n"
						+ "  3 :: Change Password(For Admin only)\n" + "  4 :: Link adhar card \r\n"
						+ "  5 :: Un-Subscribe customer\r\n" + "  6 :: Display all customers\r\n"
						+ "  7 :: Display all customer names , who have taken a specific plan\r\n"
						+ "  8 :: Display all customer details , born after specific date\r\n"
						+ "  9 :: Display all customer details , with specified adhar card location\r\n"
						+ "  10 :: Exit\n "
						+ "\n Your option :: ");
				try {
					switch (sc.nextInt()) {
					case 1:
						registerCustomer();
						break;
					case 2:
						customerLogin();
						break;
					case 3:
						//changeAdminPassword()
						break;
					case 4:
						linkAdharToCustomerAccount();
						break;
					case 5:
						unSubscribeCustomer();
						break;
					case 6:
						displayAllCustomers();
						break;
					case 7:
						displayAllCustomerNamesWithSpecificPlan();
						break;
					case 8:
						displayAllCustomersBornAfterGivenDate();
						break;
					case 9:
						displayAllCustomersAtGivenLocation();
						break;
					case 10:
						System.exit(0);
						break;

					default:
						System.out.println("Invalid choice !!!!");
						break;
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				sc.nextLine(); // To empty scanner buffer if run time exception occurs
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			// e.printStackTrace();
		}

	}

}
