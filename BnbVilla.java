/**
 * 
 * BnbVilla: This is a subclass of class BnbProperty.
 *
 */
public class BnbVilla extends BnbProperty
{
	//Constructor
	/**
	 * Constructs a villa with the additional attributes.
	 * @param totalNumRooms no. rooms being rented out
	 * @param roomServiceCostPerDay
	 * @param luxuryTaxPerDay tax on residents living in villa 
	 * @param AnOwnersName 
	 * @param aPostalAddress
	 * @param initialRentalCostPerDay
	 * @param intitialTotalNumberOfSeasonsRentalDays Total no. days that customer will be residing here
	 */
	public BnbVilla(int totalNumRooms, int roomServiceCostPerDay, int luxuryTaxPerDay, String AnOwnersName, String aPostalAddress, int initialRentalCostPerDay, int intitialTotalNumberOfSeasonsRentalDays)
	{
		//Initializing BnbProperty instance variables by calling BnbProperty constructor
		super(AnOwnersName, aPostalAddress, initialRentalCostPerDay, intitialTotalNumberOfSeasonsRentalDays);
		
		this.totalNumberOfRooms = totalNumRooms;
		this.roomServiceCostPerDay = roomServiceCostPerDay;
		this.luxuryTaxPerDay = luxuryTaxPerDay;
		 
	}

	
	//Accessors
	
	/**
	 * Gets the total number of rooms to be rented out.
	 * @return totalNumberOfRooms
	 */
	public int getTotalNumberOfRooms()
	{
		return totalNumberOfRooms;
	}
	
	/**
	 * Gets the daily cost of room service.
	 * @return roomServiceCostPerDay
	 */
	public int getRoomServiceCostPerDay()
	{
		return roomServiceCostPerDay;
	}
	
	/**
	 * Gets the total daily cost of luxury tax.
	 * @return luxuryTaxPerDay
	 */
	public int getLuxuryTaxPerDay()
	{
		return luxuryTaxPerDay;
	}
	
		
	//Mutators
	/**
	 * Sets the total number of rooms to be rented out.
	 * @param totalNumRooms
	 */
	public void setTotalNumberOfRooms(int totalNumRooms)
	{
		totalNumberOfRooms = totalNumRooms;
	}
	
	/**
	 * Sets the daily cost of room service.
	 * @param roomServiceCostPerDay
	 */
	public void setRoomServiceCostPerDay(int roomServiceCostPerDay)
	{
		this.roomServiceCostPerDay = roomServiceCostPerDay;
	}
	
	/**
	 * Sets the total daily cost of luxury tax.
	 * @param luxuryTaxPerDay
	 */
	public void setLuxuryTaxPerDay(int luxuryTaxPerDay)
	{
		this.luxuryTaxPerDay = luxuryTaxPerDay;
	}
		
	//Attributes
	private int totalNumberOfRooms;
	private int roomServiceCostPerDay;
	private int luxuryTaxPerDay;
	
}
