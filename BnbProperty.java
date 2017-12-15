
/**
 * This is the superclass from which the BnbHouse,BnbVilla and BnbApartment classes will be derived.
 *
 * */
public class BnbProperty implements RentalItem
{
	//Constructors
	
	/**
	 * Constructs a property with all attributes initialized to zero or empty.
	 */
	
	public BnbProperty()
	{
		this.uniqueRegisterNumber = counter++;
		this.ownersName = "";
		this.postalAddress = "";
		this.rentalCostPerDay = 0;
		this.totalNumberOfSeasonsRentalDays = 0;
	}
	
	
	/**
	 * Constructs a property with given parameters.
	 * @param AnOwnersName:
	 * @param aPostalAddress:
	 * @param initialRentalCostPerDay:
	 * @param initialTotalNumberOfSeasonsRentalDays:
	 * 
	 */
	
	public BnbProperty(String AnOwnersName, String aPostalAddress, int initialRentalCostPerDay, int initialTotalNumberOfSeasonsRentalDays)
	{
		this.uniqueRegisterNumber = counter++;//postincrement.Don't need to put this in parameter list,should be set by programmer.
		this.ownersName = AnOwnersName;
		this.postalAddress = aPostalAddress;
		this.rentalCostPerDay = initialRentalCostPerDay;
		this.totalNumberOfSeasonsRentalDays = initialTotalNumberOfSeasonsRentalDays;
	}
	
	
	//Accessors
	
	/**
	 * Gets the register number for the property.
	 * @return: uniqueRegisterNumber
	 */
	public int getUniqueRegNum()
	{
		return uniqueRegisterNumber;
	}
	
	
	/**
	 * Gets the name of the property owner.
	 * @return: ownersname
	 */
	public String getOwnerName()
	{
		return ownersName;
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
	 * Gets the total number of seasons rental days.
	 * @return: The total number of days that the property is being rented for.
	 */
	public int getTotalNumberOfSeasonsRentalDays()
	{
		return totalNumberOfSeasonsRentalDays;
	}
	
	//Mutators
	
	/*Unnecessary to set a unique register number since constructor takes care of this.
	 * Unless the user demands a specific number in which case,luser.*/
	
	
	/**
	 * Mutator that sets the name of the property owner.
	 * @param anOwnersName name of the (new) owner.
	 */
	public void setOwnerName(String AnOwnersName)
	{
		ownersName = AnOwnersName;
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
	 * @param: The new total number of days that the property is being rented for.
	 */
	public void setTotalNumberOfSeasonsRentalDays(int newTotalNumberOfSeasonsRentalDays)
	{
		totalNumberOfSeasonsRentalDays = newTotalNumberOfSeasonsRentalDays;
	}
	
	
	//Additional method
		
	/**
	 * This is an implementation of the RentalItem interface.
	 * This method increases the total number of rental days for a BnbProperty.
	 * @param RentalDays number of additional days
	 */
	public void RentAnItem(int RentalDays)
	{
		this.totalNumberOfSeasonsRentalDays += RentalDays;
	}
	
	
	//Attributes
	private static int counter;//Automatically initialized to 0 in Java.
	protected int uniqueRegisterNumber;
	protected String ownersName;
	protected String postalAddress;
	protected int rentalCostPerDay;
	protected int totalNumberOfSeasonsRentalDays;
}