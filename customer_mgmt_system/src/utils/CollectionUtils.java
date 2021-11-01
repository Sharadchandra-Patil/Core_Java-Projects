package utils;

import static utils.ValidationRules.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import com.app.customers.Customer;
import com.app.customers.Plan;

import custom_exception.CustomerHandlingException;

public class CollectionUtils 
{
	public static ArrayList<Customer> readySampleData() throws ParseException, CustomerHandlingException
	{
		ArrayList<Customer> list = new ArrayList<>();
		
      //String customerName, String email, String password, double regiAmount, Date date, Plan plan) {
				
		list.add(new Customer("Sharad", "sharad.6030@gmail.com", "Sharad", 25000, validateDoB("4-9-1994"),validatePlan("gold")));
		
		list.add(new Customer("kaustubh", "kstbh@gmail.com", "kaustubh", 35000, validateDoB("19-11-1988"), validatePlan("diamond")));
		
		list.add(new Customer("komal", "komal@gmail.com", "komal", 45000, validateDoB("21-8-1969"), validatePlan("platinum")));
		
		list.add(new Customer("kamlakar", "kkm@gmail.com", "kamlakar", 55000, validateDoB("2-4-1959"), validatePlan("diamond")));
		
		list.add(new Customer("kisan", "kisan@gmail.com", "kisan", 65000, validateDoB("8-2-1938"), validatePlan("gold")));
		
		return list;
	}

}
