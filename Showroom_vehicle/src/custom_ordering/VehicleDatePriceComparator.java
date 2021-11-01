package custom_ordering;

import java.util.Comparator;

import com.app.vehicles.Vehicle;

public class VehicleDatePriceComparator implements Comparator<Vehicle> {
	@Override
	public int compare(Vehicle v1, Vehicle v2) {
		System.out.println("in compare : dt n price");
		// date based comparison
		int ret = v1.getManufactureDate().compareTo(v2.getManufactureDate());
		if (ret == 0) // =>same manu. date : compare by price
			return ((Double) v1.getPrice()).compareTo(v2.getPrice());//asc
		return ret;//as per date based comparison

	}

}
