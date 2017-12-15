/**
 * Car: This is a subclass of the Vehicle class.
 */
public class Car extends Vehicle 
{
	//Constructor
	
	/**
	 * Constructs a car with given parameters.
	 * @param anOwner:
	 * @param aPostalAddress:
	 * @param initialRentalCostPerDay:
	 * @param initialTotalRentalDays:
	 * @param aPassengersNumber
	 */
	public Car(int aPassengersNumber, String anOwner, String aPostalAddress, int initialRentalCostPerDay, int initialTotalRentalDays)
	{
		//Initializing Car instance variables by calling Car constructor
		super(anOwner, aPostalAddress, initialRentalCostPerDay, initialTotalRentalDays);
		
		this.passengersNumber = aPassengersNumber;
	}
	
	
	//Accessor
	
	/**
	 * Gets the passenger number
	 * @return passengersNumber 
	 */
	public int getPassengersNumber()
	{
		return passengersNumber;
	}
	
	
	//Mutator
	
	/**
	 * Sets a new passenger number 
	 */
	public void setPassengersNumber(int aPassengersNumber)
	{
		passengersNumber = aPassengersNumber;
	}
	
	
	//Attributes
	private int passengersNumber;
}
