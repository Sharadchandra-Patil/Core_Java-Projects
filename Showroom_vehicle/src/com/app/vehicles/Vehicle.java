package com.app.vehicles;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Vehicle's  state(attributes) --chasisNo : String , color : String ,
 * category:string, price : double , manufactureDate(Date)
 */
public class Vehicle implements Comparable<Vehicle> {// outer class
	private String chasisNo;
	private Color color;
	private double price;
	private Date manufactureDate;
	private Category category;
	// establish HAS-A relationship between Vehicle n DeliveryAddress
	private DeliveryAddress address;

	// SDF : for parsing + formatting
	public static SimpleDateFormat sdf;
	static {
		sdf = new SimpleDateFormat("yyyy-MM-dd");
	}

	public Vehicle(String chasisNo, Color color, double price, Date manufactureDate, Category category) {
		super();
		this.chasisNo = chasisNo;
		this.color = color;
		this.price = price;
		this.manufactureDate = manufactureDate;
		this.category = category;
	}

	// add overloaded constr to init chasis no of a vehicle
	public Vehicle(String chasisNo) {
		this.chasisNo = chasisNo;
	}

	@Override
	public String toString() {
		String adr = address == null ? "Address not yet assigned" : address.toString();
		return "Vehicle [chasisNo=" + chasisNo + ", color=" + color + ", price=" + price + " manufactured on "
				+ sdf.format(manufactureDate) + " category " + category + " " + adr;
	}

	@Override
	public boolean equals(Object o) {
		System.out.println("in vehicle's equals method");
		if (o instanceof Vehicle)
			return this.chasisNo.equals(((Vehicle) o).chasisNo);// String's equals method for : checking content
																// equality
		return false;// => incompatible types !!!!!
	}

	@Override
	public int compareTo(Vehicle anotherVehicle) {
		System.out.println("in compare to");
		return chasisNo.compareTo(anotherVehicle.chasisNo);// < 0 OR 0 or > 0
	}

	// add a non static method to assign delivery address to the vehicle
	public void assignDeliveryAddress(String city, String state, String country, String zipCode) {
		this.address = new DeliveryAddress(city, state, country, zipCode);
	}

	public DeliveryAddress getAddress() {
		return address;
	}

	// setter for price : added in the outer class
	public void setPrice(double price) {
		this.price = price;
	}

	// getter for chasis no

	public String getChasisNo() {
		return chasisNo;
	}

	public Color getColor() {
		return color;
	}

	public double getPrice() {
		return price;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public Category getCategory() {
		return category;
	}

	// non static nested class : inner class
	public class DeliveryAddress {
		private String city, state, country, zipCode;

		public DeliveryAddress(String city, String state, String country, String zipCode) {
			super();
			this.city = city;
			this.state = state;
			this.country = country;
			this.zipCode = zipCode;
		}

		@Override
		public String toString() {
			return "DeliveryAddress [city=" + city + ", state=" + state + ", country=" + country + ", zipCode="
					+ zipCode + "]";
		}
		// getter for city

		public String getCity() {
			return city;
		}

	}// inner class over

}
