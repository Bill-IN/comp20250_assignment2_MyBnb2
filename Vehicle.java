/**
 * This is the superclass from which the Car
 * and Truck classes will be derived.
 */
public class Vehicle implements RentalItem
{
	//Constructors
	
	/**
	 * Constructs a vehicle with all attributes initialized to zero or empty.
	 */
	Vehicle()
	{
		this.uniqueRegisterNumber = counter++;
		this.owner = "";
		this.postalAddress = "";
		this.rentalCostPerDay = 0;
		this.totalRentalDays = 0;		
	}
	
	
	/**
	 * Constructs a vehicle with given parameters.
	 * @param anOwner:
	 * @param aPostalAddress:
	 * @param initialRentalCostPerDay:
	 * @param initialTotalRentalDays:
	 * 
	 */
	public Vehicle(String AnOwner, String aPostalAddress, int initialRentalCostPerDay, int initialTotalRentalDays)
	{
		this.uniqueRegisterNumber = counter++;//postincrement.Don't need to put this in parameter list,should be set by programmer.
		this.owner = AnOwner;
		this.postalAddress = aPostalAddress;
		this.rentalCostPerDay = initialRentalCostPerDay;
		this.totalRentalDays = initialTotalRentalDays;
	}
	
	
	//Accessors
	
	/**
	 * Gets the register number for the vehicle.
	 * @return: uniqueRegisterNumber
	 */
	public int getUniqueRegNum()
	{
		return uniqueRegisterNumber;
	}
	
	
	/**
	 * Gets the name of the vehicle owner.
	 * @return: owner
	 */
	public String getOwner()
	{
		return owner;
	}
	
	
	/**
	 * Gets the postal address.
	 * @return: postalAddress
	 */
	public String getPostalAddress()
	{
		return postalAddress;
	}
	
	
	/**
	 * Gets the rental cost per day.
	 * @return: Cost of rent per day.
	 */
	public int getRentalCostPerDay()
	{
		return rentalCostPerDay;
	}
	
	
	/**
	 * Gets the total number of rental days.
	 * @return: The total number of days that the vehicle is being rented for.
	 */
	public int getTotalRentalDays()
	{
		return totalRentalDays;
	}
	
	//Mutators
	
	/*Unnecessary to set a unique register number since constructor takes care of this.
	 * Unless the user demands a specific number in which case,luser.*/
	
	
	/**
	 * Mutator that sets the name of the vehicle owner.
	 * @param anOwner name of the (new) owner.
	 */
	public void setOwner(String anOwner)
	{
		owner = anOwner;
	}
	

	/**
	 * Mutator that sets a new postal address.
	 * @param aPostalAddress the new postal address
	 */
	public void setPostalAddress(String aPostalAddress)
	{
		postalAddress = aPostalAddress;
	}
	
	
	/**
	 * Mutator that sets a new rental cost per day.
	 * @param newRentalCostPerDay the new cost of rent per day
	 */
	public void getRentalCostPerDay(int newRentalCostPerDay)
	{
		rentalCostPerDay = newRentalCostPerDay;
	}
	
	
	/**
	 * Mutator that sets the new total number of seasons rental days.
	 * @param: newTotalRentalDays The new total number of days that the property is being rented for.
	 */
	public void setTotalRentalDays(int newTotalRentalDays)
	{
		totalRentalDays = newTotalRentalDays;
	}
	
	
	//Additional method
		
	/**
	 * This is an implementation of the RentalItem interface.
	 * This method increases the total number of rental days for a Vehicle.
	 * @param RentalDays number of additional days
	 */
	public void RentAnItem(int RentalDays)
	{
		this.totalRentalDays += RentalDays - 1;
		//this.totalRentalDays -= 1;//Special offer
	}
		
	//Attributes
	private static int counter;//Automatically initialized to 0 in Java.
	protected int uniqueRegisterNumber;
	protected String owner;
	protected String postalAddress;
	protected int rentalCostPerDay;
	protected int totalRentalDays;
}
