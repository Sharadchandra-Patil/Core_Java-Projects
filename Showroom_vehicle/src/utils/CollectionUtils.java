package utils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import com.app.vehicles.Category;
import com.app.vehicles.Color;
import com.app.vehicles.Vehicle;

import custom_exceptions.VehicleHandlingException;

import static utils.ValidationRules.*;

public class CollectionUtils {
//add a static method to return populated list of vehicles
	public static ArrayList<Vehicle> populateSampleData() throws ParseException, VehicleHandlingException {
		ArrayList<Vehicle> list = new ArrayList<>();//size=0, capa=10
		// chasisNo, Color color, double price, Date manufactureDate, Category category
		list.add(new Vehicle("abc", parseAndValidateColor("red"), 456242,
				parseAndValidateManufactureDate("2021-5-6"), parseAndValidateCategory("diesel")));
		list.add(new Vehicle("ABC", parseAndValidateColor("white"), 566242,
				parseAndValidateManufactureDate("2021-10-16"), parseAndValidateCategory("petrol")));
		list.add(new Vehicle("nac", parseAndValidateColor("black"), 1562425,
				parseAndValidateManufactureDate("2021-5-9"), parseAndValidateCategory("diesel")));

		list.add(new Vehicle("dac", parseAndValidateColor("red"), 3962425,
				parseAndValidateManufactureDate("2021-5-6"), parseAndValidateCategory("petrol")));

		list.add(new Vehicle("asd", parseAndValidateColor("red"), 296242,
				parseAndValidateManufactureDate("2021-5-6"), parseAndValidateCategory("diesel")));

		return list;
	}
}
