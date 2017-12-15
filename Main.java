/**
 * Main class to run MyBnb program.
 */

import java.util.ArrayList;

public class Main
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		//Variables
		ArrayList<BnbApartment> Apartments = new ArrayList<BnbApartment>();
		ArrayList<BnbHouse> Houses = new ArrayList<BnbHouse>(); 
		ArrayList<BnbVilla> Villas = new ArrayList<BnbVilla>();
		ArrayList<Car> BnbCars = new ArrayList<Car>();
		ArrayList<Truck> BnbTrucks = new ArrayList<Truck>();

			
		//Initializing property ArrayLists by reading data from a file.
		BnbProcessor.ReadInputPropertyFile("InputProperty.txt", Apartments, Houses, Villas);
		
		//Initializing Vehicle ArrayLists by reading data from a file.
		BnbProcessor.ReadInputVehicleFile("InputVehicle.txt", BnbCars, BnbTrucks);
		
		//Printing all vehicle data to an output file.
		BnbProcessor.PrintAllVehicles("OutputVehicle.txt", BnbCars, BnbTrucks);
		
		//Increasing rental days for properties(Print properties and calculate income after all buttons are pressed.)******
		BnbProcessor.GiveRentalProperty(Apartments, Houses, Villas);
		
	}

}
