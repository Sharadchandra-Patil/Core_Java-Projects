package tester;

import static utils.ValidationRules.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.app.vehicles.Category;
import com.app.vehicles.Vehicle;

import custom_exceptions.VehicleHandlingException;
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
						+ "4.Update Price  5. Delete Vehicle details 6. Update Price 10.Exit");
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
					case 10:
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
