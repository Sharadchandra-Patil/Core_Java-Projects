package com.app.customers;

import java.text.SimpleDateFormat;
import java.util.Date;

import custom_exception.CustomerHandlingException;

/*
 * 4.1 Customer : name(string),email(string),password(string),registrationAmount(double),dob(Date),plan(enum : SILVER ,GOLD,DIAMOND,PLATUNUM)
Unique id : customer email
Create a composition between Customer & AdharCard
Adhar Card details : card number, location.
Only after  successful customer registration , adhar card details can be linked to the customer.
*/

public class Customer implements Comparable<Customer>{
	// Customer :
	// name(string),email(string),password(string),registrationAmount(double),dob(Date),plan(enum
	// : SILVER ,GOLD,DIAMOND,PLATUNUM)
	private String customerName;
	private String email;
	private String password;
	private double regiAmount;
	private Date date;
	private Plan plan;

	private AdharCard adhar;

	public static SimpleDateFormat sdf; // for formatting date

	// static ini block
	static {
		sdf = new SimpleDateFormat("dd-MM-yyyy");
	}

	// constr
	public Customer(String customerName, String email, String password, double regiAmount, Date date, Plan plan) {
		super();
		this.customerName = customerName;
		this.email = email;
		this.password = password;
		this.regiAmount = regiAmount;
		this.date = date;
		this.plan = plan;
	}

	public Customer(String email) {
		super();
		this.email = email;
	}

	//compareTo method of string class  *****************************
	
	public int compareTo(Customer temp) {
		
		//return this.getEmail().compareTo(temp.getEmail());   //asc
		
		return temp.getEmail().compareTo(this.getEmail());   //desc
	}
	
	
	
	// adharlinking method ***************************

	public void linkAdharNumber(String number, String location) throws CustomerHandlingException {
		if (number.length() == 12)
			this.adhar = new AdharCard(number, location);
		else
			throw new CustomerHandlingException("Your adhar number is not of 12 digit. Please check digits..");
	}

	// get adhar location from outer class *************************
	public String getAdharLocation() {
		return this.adhar.getLocation();
	}

	// getters and setters *************************

	public String getCustomerName() {
		return customerName;
	}

	public Date getDate() {
		return date;
	}

	public Plan getPlan() {
		return plan;
	}

	public AdharCard getAdhar() {
		return adhar;
	}

	

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public double getRegiAmount() {
		return regiAmount;
	}


	public String getPassword() {
		return password;
	}

	public void changePassword(String password) {
		this.password = password;
	}

	
	public String getEmail() {
		return email;
	}

	

	// equals method ***************************
	@Override
	public boolean equals(Object o) throws ClassCastException {
		if (o instanceof Customer) {
			return this.email.equals(((Customer) o).email);
		} else
			throw new ClassCastException();
	}

	@Override
	public String toString() {
		String adh = adhar == null ? "Adhar is not linked yet " : adhar.toString();
		return "Customers [customerName=" + customerName + ", email=" + email + ", regiAmount=" + regiAmount + ", date="
				+ sdf.format(date) + ", plan=" + plan + " " + adh + "]";
	}

//****************************************************************

	// Inner class
	public class AdharCard {
		private String cardNumber;
		private String location;

		public AdharCard(String cardNumber, String location) {
			super();
			this.cardNumber = cardNumber;
			this.location = location;
		}

		@Override
		public String toString() {
			return "AdharCard [cardNumber=" + cardNumber + ", location=" + location + "]";
		}

		public String getLocation() {
			return location;
		}

	}

}
