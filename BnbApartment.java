
/**
 * BnbApartment: This is a subclass of the BnbProperty class.
 * 
 */
public class BnbApartment extends BnbProperty
{
	//Constructors
	
	/**
	 * Constructs an apartment with the additional attributes.
	 * @param storeyNum the storey number of the apartment?
	 * @param numBeds the number of beds to rent out?
	 * @param AnOwnersName 
	 * @param aPostalAddress
	 * @param initialRentalCostPerDay
	 * @param initialTotalNumberOfSeasonsRentalDays Total no. days that customer will be residing here
	 */
	public BnbApartment(int storeyNum, int numBeds, String AnOwnersName, String aPostalAddress, int initialRentalCostPerDay, int initialTotalNumberOfSeasonsRentalDays)//One number or an amount??
	{
		//Initializing BnbProperty instance variables by calling BnbProperty constructor
		super(AnOwnersName, aPostalAddress, initialRentalCostPerDay, initialTotalNumberOfSeasonsRentalDays);
		
		this.storeyNumber = storeyNum;
		this.numberOfBeds = numBeds;
	}
	
	//Accessors
	
	/**
	 * Gets the storey(floor) that the apartment is on.
	 * @return storeyNumber 
	 */
	public int getStoreyNumber()
	{
		return storeyNumber;
	}
	
	/**
	 * Gets the number of beds being rented out.
	 * @return numberOfBeds 
	 */
	public int getNumberOfBeds()
	{
		return numberOfBeds;
	}
		
	//Mutators
		
	/**
	 * Sets the storey(floor) that the apartment is on? or number of storeys in apartment.
	 * @param numStoreys 
	 */
	public void setStoreyNumber(int numStoreys)
	{
		storeyNumber = numStoreys;
	}
	
	/**
	 * Sets the number of beds being rented out.
	 * @param numberOfBeds 
	 */
	public void setNumberOfBeds(int numBeds)
	{
		numberOfBeds = numBeds;
	}
	
	//Attributes
	private int storeyNumber;//Floor number
	private int numberOfBeds;
}
