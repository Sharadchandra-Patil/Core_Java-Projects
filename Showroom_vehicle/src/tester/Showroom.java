package tester;

import static utils.ValidationRules.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

import com.app.vehicles.Category;
import com.app.vehicles.Vehicle;

import custom_exceptions.VehicleHandlingException;
import custom_ordering.VehicleDatePriceComparator;
import custom_ordering.VehiclePriceDescComparator;

import static utils.CollectionUtils.populateSampleData;

public class Showroom {

	public static void main(String... args) {

		try (Scanner sc = new Scanner(System.in)) {
			// init phase of the app
			// create suitable empty collection (AL) to store vehicle info in the showroom
			ArrayList<Vehicle> vehicles = populateSampleData();

			boolean exit = false;
			while (!exit) {
				System.out.println("1. Add Vehicle 2.Display all vehicles 3.Get a particular vehicle's details "
						+ "4.Update Price  5. Delete Vehicle details 6. Update Price "
						+ "7.Purchase  8.Display using criteria 9.Sort vehicles by chasis no(N.O) "
						+ "10. Sort vehicles by price (C.O) 11. Sort vehicles by date n price (C.O)"
						+ "12. Sort vehicles as per category 100.Exit");
				try {
					switch (sc.nextInt()) {
					case 1:// add the vehicle : upon validations

						System.out.println("Enter vehicle details : chasisNo,  color,  price,  "
								+ "manufactureDate(yr-mon-day),  category");
						Vehicle v1 = validateAllInputs(sc.next(), vehicles, sc.next(), sc.nextDouble(), sc.next(),
								sc.next());
						// => success : add the ref to the collection
						vehicles.add(v1);
						System.out.println("Vehicle added to the showroom");

						break;

					case 2: // display
						System.out.println("Vehicles in the showroom");
						for (Vehicle v : vehicles)// for -each
							System.out.println(v);
						break;
					case 3: // find the vehicle by its' PK : chasis no
						System.out.println("Enter chasis no");
						System.out.println(findByChasisNo(sc.next(), vehicles));
						break;
					case 4:
						System.out.println("Enter chasis no for price updation");
						v1 = findByChasisNo(sc.next(), vehicles);
						// => vehicle found
						System.out.println("Enter new price for the vehicle");
						v1.setPrice(sc.nextDouble());
						System.out.println("price updated for a vehicle with chasis no " + v1.getChasisNo());
						break;
					case 5: // Delete vehicle details : i/p : chasis no
						System.out.println("Enter chasis no");
						// Working one! System.out.println("Removed
						// "+vehicles.remove(findByChasisNo(sc.next(), vehicles)));
						System.out.println("Removed " + vehicles.remove(new Vehicle(sc.next())));
						break;
					case 6: // Apply discount to all vehicles manufactured before a specific date n category
						// i/p : date n category n discount : for-each
						System.out.println("Enter date n category n discount");
						Date d1 = parseAndValidateManufactureDate(sc.next());
						Category c = parseAndValidateCategory(sc.next());
						double discount = sc.nextDouble();
						for (Vehicle v : vehicles)
							if (v.getManufactureDate().before(d1) && v.getCategory() == c)
								v.setPrice(v.getPrice() - discount);
						System.out.println("discount applied ...");
						break;

					case 7:// purchase
						System.out.println("Enter chasis no , to purchase a vehicle");
						// invoke the method
						Vehicle vehicle = findByChasisNo(sc.next(), vehicles);
						// chk if it's already sold ?
						if (vehicle.getAddress() != null)
							throw new VehicleHandlingException("Vehicle already sold!!!!");
						// =>not yet sold : available
						System.out.println("Enter delivery address : city, state, country, zipCode");
						vehicle.assignDeliveryAddress(sc.next(), sc.next(), sc.next(), sc.next());
						System.out.println("vehicle ready for delivery....");

						break;
					case 8:
						// 1.3 Display vehicle chasis no n price , of all the vehicles dispatched to a
						// specific city
						// i/p : city
						System.out.println("Enter city of dispatch");
						String city = sc.next();
						for (Vehicle v : vehicles)
							if (v.getAddress() != null)
								if (v.getAddress().getCity().equals(city))
									System.out.println("Chasis No " + v.getChasisNo() + " Price " + v.getPrice());
						break;
					case 9:
						System.out.println("Vehicles sorted as per chasis no");
						Collections.sort(vehicles);
						// invokes internally : Vehicle's compareTo
						for (Vehicle v : vehicles)
							System.out.println(v);
						break;
					case 10:
						System.out.println("Vehicles sorted as per desc price");
						// Method : Collections.sort(List<T> list,Comparator<T> comp)
						// list : list of elements(AL/LL/Vector)
						// comp : Comparator ref ---> imple class instance
						// Collections.sort(vehicles, new VehiclePriceDescComparator());
						Collections.sort(vehicles, new Comparator<Vehicle>() {

							@Override
							public int compare(Vehicle o1, Vehicle o2) {
								System.out.println("in ano inner cls : price");
								return ((Double)o2.getPrice()).compareTo(o1.getPrice());
							}
							
						});
						// what will JVM call internally ? VehiclePriceDescComparator's compare :
						// comparison func
						for (Vehicle v : vehicles)
							System.out.println(v);
						break;
					case 11:
						System.out.println("Vehicles sorted as per asc date n asc price");
						Collections.sort(vehicles, new VehicleDatePriceComparator());
						// sort : will invoke : VehicleDatePriceComparator 's compare
						for (Vehicle v : vehicles)
							System.out.println(v);
						break;
					case 12:
						System.out.println("Vehicles sorted as per category");
						Collections.sort(vehicles, new Comparator<Vehicle>() {// inner cls begin
							@Override
							public int compare(Vehicle v1, Vehicle v2) {// method begin
								System.out.println("in ano inner : category");
								return v1.getCategory().compareTo(v2.getCategory());
							}// method over
						}// inner cls end
						);
						for (Vehicle v : vehicles)
							System.out.println(v);
						break;
					case 100:
						exit = true;
						break;
					}
				} // catch :
				catch (Exception e) {
					// e.printStackTrace();
					System.out.println(e.getMessage());
				}
				// to clear off pending tokens from the buffer of a scanner : till new line
				sc.nextLine();
			} // end of while
		} // end of try-with-res : sc.close();
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
