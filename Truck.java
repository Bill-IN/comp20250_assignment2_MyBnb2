/**
 * Car: This is a subclass of the Vehicle class.
 */
public class Truck extends Vehicle 
{
	//Contructor
	
	/**
	 * Constructs a truck with given parameters.
	 * @param anOwner:
	 * @param aPostalAddress:
	 * @param initialRentalCostPerDay:
	 * @param initialTotalRentalDays:
	 * @param aCargoWeight
	 * 
	 */
	public Truck(int aCargoWeight, String anOwner, String aPostalAddress, int initialRentalCostPerDay, int initialTotalRentalDays)//One number or an amount??
	{
		//Initializing Car instance variables by calling Car constructor
		super(anOwner, aPostalAddress, initialRentalCostPerDay, initialTotalRentalDays);
		
		this.cargoWeight = aCargoWeight;
	}
	
	
	//Accessor
	
	/**
	 * Gets the passenger number
	 * @return passengersNumber 
	 */
	public int getCargoWeight()
	{
		return cargoWeight;
	}
		
		
	//Mutator
		
	/**
	 * Sets a new cargo weight 
	 */
	public void setCargoWeightr(int aCargoWeight)
	{
		cargoWeight = aCargoWeight;
	}

	
	//Attributes
	private int cargoWeight;
}