/**
 * 
 * BnbHouse: This is a subclass of class BnbProperty.
 *
 */
public class BnbHouse extends BnbProperty
{
	/**
	 * Constructs a house with the additional attributes.
	 * @param totalNumStoreys number of storeys in the house.
	 * @param clearing_Fees cost of clearing the house for the next resident
	 * @param AnOwnersName 
	 * @param aPostalAddress
	 * @param initialRentalCostPerDay
	 * @param initialTotalNumberOfSeasonsRentalDays Total no. days that customer will be residing here
	 */
	//Constructor
	public BnbHouse(int totalNumStoreys, int clearing_Fees, String AnOwnersName, String aPostalAddress, int initialRentalCostPerDay, int initialTotalNumberOfSeasonsRentalDays)
	{
		//Initializing BnbProperty instance variables by calling BnbProperty constructor
		super(AnOwnersName, aPostalAddress, initialRentalCostPerDay, initialTotalNumberOfSeasonsRentalDays);		
		
		this.totalNumberOfStoreys = totalNumStoreys; 
	    this.clearingFees = clearing_Fees;		
	}
	
	//Accessors
	
	/**
	 * Gets the number of storeys in the house.
	 * @return totalNumberOfStoreys
	 */
	public int getTotalNumberOfStoreys()
	{
		return totalNumberOfStoreys;
	}
	
	/**
	 * Gets the clearing fees for the house.
	 * @return clearingFees
	 */
	public int getClearingFees()
	{
		return clearingFees;
	}
		
	//Mutators
	/**
	 * Sets the number of storeys in the house.
	 * @param totalNumberOfStoreys
	 */
	public void setTotalNumberOfStoreys(int totalNumStoreys)
	{
		totalNumberOfStoreys = totalNumStoreys;
	}
	
	/**
	 * Sets the clearing fees for the house.
	 * @param clearing_Fees
	 */
	public void setClearingFees(int clearing_Fees)
	{
		clearingFees = clearing_Fees;
	}
	
		
	//Attributes
	private int totalNumberOfStoreys;//Number of storeys in house
	private int clearingFees;
}
