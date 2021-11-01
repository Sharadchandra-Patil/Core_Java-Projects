package utils;

import static com.app.customers.Customer.sdf;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import com.app.customers.Customer;
import com.app.customers.Plan;

import custom_exception.CustomerHandlingException;

/*
 * 4.3 Create in "utils" package : ValidationRules
Rules 
email must contain "@" & should be from ".com" domain
password must be min 4 max 10 chars long
reg amount should be multiples of 500
dob should be before 1st Jan 1995
no duplicate registrations.
*/

public class ValidationRules {

	private static Date threshHoldDate;
	public static StringBuilder sb;
	
	static {
		try {
			threshHoldDate = sdf.parse("1-1-1995");
			sb= new StringBuilder("\n  Supported plans are::\n");
			for (Plan p : Plan.values())
				sb.append("    " + p + "(Fee : "+p.getPlanFee()+")\n");

		} catch (ParseException e) {
			System.out.println("Error in static init block " + e);
		}
	}
	

	public static boolean emailValidationAndDuplicateChecking(String email, ArrayList<Customer> customers)
			throws CustomerHandlingException {
		if (email.contains("@") && email.endsWith(".com")) {
			Customer temp = new Customer(email);
			if (customers.contains(temp)) {
				//throw new CustomerHandlingException(
					//	"This email is already registered. Please register with other email...");
				System.out.println("    ** This email is already registered. Please register with other email...");
				return false;
			}
			return true;
		} else {
			//throw new CustomerHandlingException("Invalid email Format!! Please enter in legal format");
			System.out.println("    ** Invalid email format. Please enter in valid format...");
			return false;
		}
	}

	public static void validatePassword(String password) throws CustomerHandlingException {
		if (password.length() >= 4 && password.length() <= 10)
			return;
		else
			throw new CustomerHandlingException("Password length is invalid !!!");
	}

	public static void validateRegiAmount(double amt) throws CustomerHandlingException {
		if (amt % 500 != 0)
			throw new CustomerHandlingException("Invalid amount!!! Amount should be multiple of 500...");
		return;
	}

	public static Plan validatePlan(String plan) throws CustomerHandlingException {

		try {
			return Plan.valueOf(plan.toUpperCase());
		} catch (IllegalArgumentException e) {
			
			throw new CustomerHandlingException("Invalid Catagory!! \n"+ sb.toString());
		}
	}

	public static Date validateDoB(String dt) throws ParseException, CustomerHandlingException {
		Date date = sdf.parse(dt);
		
		if(date.after(threshHoldDate))
			throw new CustomerHandlingException("Date must be before 01-01-1995...");
		return date;
		
	}
	
	public static void validateAdhar(String number) throws CustomerHandlingException {
		if(number.length() != 12)
			throw new CustomerHandlingException("Invalid Adhar number!!!");
		return;
	}
	
}
