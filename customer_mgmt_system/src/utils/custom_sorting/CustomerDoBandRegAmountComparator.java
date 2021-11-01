package utils.custom_sorting;

import java.util.Comparator;

import com.app.customers.Customer;

public class CustomerDoBandRegAmountComparator implements Comparator<Customer> {
	
	@Override
	public int compare(Customer c1, Customer c2) {
	
		int ret = c1.getDate().compareTo(c2.getDate()); //date class compareTo m/t called
		
		if(ret == 0)
			return ((Double)c1.getRegiAmount()).compareTo(c2.getRegiAmount());
		
		return ret;
	}
}
