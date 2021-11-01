package utils.custom_sorting;

import java.util.Collections;
import java.util.Comparator;

import com.app.customers.Customer;
import static tester.CustomerManagement.customers;
import static utils.custom_sorting.CustomerSorting.sortAllCustomersByEmail;
public class CustomerSorting {
	
	public static void sortAllCustomersByDoBandRegAmount() {
		Collections.sort(customers, new CustomerDoBandRegAmountComparator());
	}
	
	public static void sortAllCustomersByEmail() {
		
		Collections.sort(customers);
	}
	
	public static void sortAllCustomersByDoBandRegAmount_annonymousInner_class(){
		
		Collections.sort(customers, new Comparator<Customer>() {
			@Override
			public int compare(Customer c1, Customer c2) {
				int ret = c1.getDate().compareTo(c2.getDate());
				
				if(ret ==0)
					return ((Double)c1.getRegiAmount()).compareTo(c2.getRegiAmount());
				
				return ret;
			}
		});
	}

}
