import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 * This class contains methods that fill,print and perform calculations on
 * the Property and Vehicle classes and their subclasses.
 * 
 */

public class BnbProcessor 
{
	//Constructor
	
	/**
	 * Empty constructor
	 */
	BnbProcessor(){}
	
	
	//Methods
	
	/**
	 * This method will scan the input file and fill in the appropriate ArrayLists.
	 * Replace FillInProperties method.
	 * 
	 * @param fileName,apartments,houses,villas
	 */
	public static void ReadInputPropertyFile(String fileName, ArrayList<BnbApartment> apartments, ArrayList<BnbHouse> houses, ArrayList<BnbVilla> villas)
	{	
		try
		{
			int propertyType = 0;
			String currentLine = "";
			FileReader readmyFile = new FileReader(fileName);
			Scanner scanMyFile = new Scanner(readmyFile);
				
			//Apartment variables
			int storeyNum = 0, numBeds = 0;
				
			//Houses variables
			int  clearing_Fees = 0, totalNumStoreys = 0;
				
			//Villas variables
			int totalNumRooms = 0, roomServiceCostPerDay = 0, luxuryTaxPerDay = 0; 
				
			//Common to all
			int initialRentalCostPerDay = 0, intitialTotalNumberOfSeasonsRentalDays = 0;
			String AnOwnersName = "", aPostalAddress = "";				
				
			//Reading each line in the file.
			while(scanMyFile.hasNextLine())
			{
				currentLine = scanMyFile.nextLine();
				String[] currentLineParts = currentLine.split(" ");//Split the line into tokens.
					
				//Determining the property type.
				if(isInt(currentLineParts[0]))
				{
					propertyType = Integer.parseInt(currentLineParts[0]);
				}
					
				//apartments
				if(propertyType == 1)
				{
					//Filling in apartment details.
					storeyNum = Integer.parseInt(currentLineParts[1]);
					numBeds = Integer.parseInt(currentLineParts[2]);
					initialRentalCostPerDay = Integer.parseInt(currentLineParts[3]);
					intitialTotalNumberOfSeasonsRentalDays = Integer.parseInt(currentLineParts[4]);
					AnOwnersName = currentLineParts[5];
					aPostalAddress = currentLineParts[6];
						
					//Calling Bnbapartment constructor and adding BnbApartment object to apartments arraylist.
					apartments.add(new BnbApartment(storeyNum, numBeds, AnOwnersName, aPostalAddress, initialRentalCostPerDay,intitialTotalNumberOfSeasonsRentalDays));
				}
					
				//houses
				else if(propertyType == 2)
				{
					//Filling in houses details
					totalNumStoreys = Integer.parseInt(currentLineParts[1]);
					clearing_Fees = Integer.parseInt(currentLineParts[2]);
					initialRentalCostPerDay = Integer.parseInt(currentLineParts[3]);
					intitialTotalNumberOfSeasonsRentalDays = Integer.parseInt(currentLineParts[4]);
					AnOwnersName = currentLineParts[5];
					aPostalAddress = currentLineParts[6];
						
					//Calling BnbHouse constructor and adding BnbHouse object to houses arraylist.
					houses.add(new BnbHouse(totalNumStoreys, clearing_Fees, AnOwnersName, aPostalAddress, initialRentalCostPerDay, intitialTotalNumberOfSeasonsRentalDays));					
				}
					
				//villas
				else if(propertyType == 3)
				{
					//Filling in villas details
					totalNumRooms = Integer.parseInt(currentLineParts[1]);
					intitialTotalNumberOfSeasonsRentalDays = Integer.parseInt(currentLineParts[2]);
					luxuryTaxPerDay = Integer.parseInt(currentLineParts[3]);
					roomServiceCostPerDay = Integer.parseInt(currentLineParts[4]);
					initialRentalCostPerDay = Integer.parseInt(currentLineParts[5]);
					AnOwnersName = currentLineParts[6];
					aPostalAddress = currentLineParts[7];
						
					//Calling villas constructor and adding BnbVilla object to villas arraylist.
					villas.add(new BnbVilla(totalNumRooms, roomServiceCostPerDay, luxuryTaxPerDay, AnOwnersName, aPostalAddress, initialRentalCostPerDay, intitialTotalNumberOfSeasonsRentalDays));					
				}
			}
				
				scanMyFile.close();
		}
			
		catch(Exception ex)
		{
			System.out.println("exception " + ex.getMessage() + " caught");
		}
			
			
			
			/* Hard-coded array list entries in case user does not want to input or for testing. 
			 * 
			 * apartments.add(new BnbApartment(0,2,"Darren Shan","3 Cirque Du Frique Rd.",20,100));
			 * apartments.add(new BnbApartment(1,3,"Terry Pratchett","2 Ring Rd.",20,90));
	         * apartments.add(new BnbApartment(2,4,"Agatha Christie","64 ABC Lane",20,162));
	         * 
	         * houses.add(new BnbHouse(3,150,"Izaya Orihara","70 Dollarville Lane",20,111));
	         * houses.add(new BnbHouse(4,200,"Jane Doe","78 Horton avenue",20,14));
	         * houses.add(new BnbHouse(2,100,"Rocket","12 Sandy drive",20,45));
	         * 
	         * villas.add(new BnbVilla(1,100,200,"James Bond","007 Baker Street",20,26));
	         * villas.add(new BnbVilla(3,300,200,"Dr. Halsey","2558 Oni Drive",20,57));
	         * villas.add(new BnbVilla(7,700,200,"John Sierra","117 Requiem Rd.",20,365));
	         * 
	         */
			
			
	}
		
		
	/**
	 * This method outputs the contents of all Property ArrayLists into an output file.
	 * @param apartments,houses,villas
	 */
	public static void PrintAllProperties(String fileName, ArrayList<BnbApartment> apartments, ArrayList<BnbHouse> houses, ArrayList<BnbVilla> villas)
	{
		int i = 0;
		String welcomeString = "", newLines = "\n\n\n", outputString = ""; 
		String apartmentHeader = "", apartmentAttributes = "", apartmentString = ""; 
		String houseHeader = "", houseAttributes = "", houseString = ""; 
		String villaHeader = "", villaAttributes = "", villaString = ""; 
					
		welcomeString = String.format("%s","----------------------------------------------------------------------------------MyBnb2 : Properties------------------------------------------------------------------------------------------------------------------\n\n\n");

		/*apartments*/
		apartmentHeader = String.format("%s","_____________________________________________________________________________________Apartments______________________________________________________________________________________\n\n");

		apartmentAttributes = String.format("%25s %25s %25s %25s %25s %25s %25s \n", "UniqueReg no.","Owner","Address","Total Days rented","Rent-Cost-Per-Day","Storey no.","no. beds");

		for(i = 0;i < apartments.size();i++)
		{		
			apartmentString += String.format("%25s %25s %25s %25s %25s %25s %25s \n", apartments.get(i).getUniqueRegNum(),apartments.get(i).getOwnerName(),apartments.get(i).getPostalAddress(),
			apartments.get(i).getTotalNumberOfSeasonsRentalDays(), apartments.get(i).getRentalCostPerDay(), apartments.get(i).getStoreyNumber(), apartments.get(i).getNumberOfBeds());
		}
			
		outputString += welcomeString + apartmentHeader + apartmentAttributes + apartmentString + newLines;
			
		/*--------------------------------------------------------------------------------------------*/	

			
		/*houses*/
		houseHeader = String.format("%s","_______________________________________________________________________________________Houses________________________________________________________________________________________\n\n");

		houseAttributes = String.format("%25s %25s %25s %25s %25s %25s %25s \n", "UniqueReg no.","Owner","Address","Total Days rented","Rent-Cost-Per-Day","no. stories","Clearing fees");

		for(i = 0;i < houses.size();i++)
		{		
			houseString += String.format("%25s %25s %25s %25s %25s %25s %25s \n", houses.get(i).getUniqueRegNum(),houses.get(i).getOwnerName(),houses.get(i).getPostalAddress(),
			houses.get(i).getTotalNumberOfSeasonsRentalDays(), houses.get(i).getRentalCostPerDay(), houses.get(i).getTotalNumberOfStoreys(), houses.get(i).getClearingFees());
		}
			
		outputString += houseHeader + houseAttributes + houseString + newLines;
			
		/*--------------------------------------------------------------------------------------------*/	

			
		/*villas*/
		villaHeader = String.format("%s","_______________________________________________________________________________________Villas__________________________________________________________________________________________________________________\n\n");

		villaAttributes = String.format("%25s %25s %25s %25s %25s %25s %25s %25s \n", "UniqueReg no.","Owner","Address","Total Days rented","Rent-Cost-Per-Day","Total no. rooms","Daily room service cost","Luxury tax per day");

		for(i = 0;i < villas.size();i++)
		{		
			villaString += String.format("%25s %25s %25s %25s %25s %25s %25s %25s \n", villas.get(i).getUniqueRegNum(),villas.get(i).getOwnerName(),villas.get(i).getPostalAddress(),
			villas.get(i).getTotalNumberOfSeasonsRentalDays(),villas.get(i).getRentalCostPerDay(), villas.get(i).getTotalNumberOfRooms(), villas.get(i).getRoomServiceCostPerDay(),
			villas.get(i).getLuxuryTaxPerDay());
		}
			
		outputString += villaHeader + villaAttributes + villaString + newLines;
		
		//Calculating total Income for all properties
		outputString += "Total property rental income is " + BnbProcessor.CalculateTotallIncome(apartments, houses, villas) + newLines;

		/*--------------------------------------------------------------------------------------------*/	
							
		//Writing to output file.
		try
		{
			PrintWriter out = new PrintWriter(fileName);
			out.write(outputString);
			out.close();
		}
			
		catch(Exception ex)
		{
			System.out.println("exception " + ex.getMessage() + " caught");
		}
					
	}
		
		
	/**
	 * This method will calculate the total income from all properties including the additional costs and taxes .
	 * @param apartments,houses,villas
	 */
	public static int CalculateTotallIncome(ArrayList<BnbApartment> apartments, ArrayList<BnbHouse> houses, ArrayList<BnbVilla> villas)
	{
	   	int TotalRentalIncome = 0, i;
	    	
	    for(i = 0;i < apartments.size();i++)
	      TotalRentalIncome += apartments.get(i).getTotalNumberOfSeasonsRentalDays() * apartments.get(i).getRentalCostPerDay();
	        
	    for(i = 0;i < houses.size();i++)
	      TotalRentalIncome += houses.get(i).getTotalNumberOfSeasonsRentalDays() * houses.get(i).getRentalCostPerDay()+houses.get(i).getClearingFees();
	       
	    for(i = 0;i < villas.size();i++)
	      TotalRentalIncome += (villas.get(i).getRentalCostPerDay() + villas.get(i).getRoomServiceCostPerDay() + villas.get(i).getLuxuryTaxPerDay()) * villas.get(i).getTotalNumberOfSeasonsRentalDays();
	       
	    return TotalRentalIncome;
	}
		
		
	/**
	 * This method displays a frame (using swing packet) and the user can 
	 * insert a new rental transaction by giving the Property ID and the rental days.
	 * 
	 * @param apartments,houses,villas
	 */
	public static void GiveRentalProperty(ArrayList<BnbApartment> apartments, ArrayList<BnbHouse> houses, ArrayList<BnbVilla> villas)
	{
		//Creating the frame for GiveRentalProperty
		JFrame GiveRentalPropertyFrame = new JFrame("MYBnB2 - GiveRentalProperty");
		GiveRentalPropertyFrame.setLayout(new GridLayout(1, 4));
		GiveRentalPropertyFrame.setSize(800, 100);
			
		//Creating propertyID JTextArea
		GiveRentalPropertyFrame.getContentPane().add(new JLabel("PropertyID"));
	    JTextArea propertyID_text = new JTextArea(20,10);//This will contain the uniqueRegNum
	    propertyID_text.setLineWrap(true);
	    GiveRentalPropertyFrame.getContentPane().add(propertyID_text);
	        
	    //Creating rentalDays JTextArea
	    GiveRentalPropertyFrame.getContentPane().add(new JLabel("Rental Days"));
	    JTextArea rentalDays_text = new JTextArea(20,10);//This will contain the no. rental days to increase by for the property.
	    rentalDays_text.setLineWrap(true);
	    GiveRentalPropertyFrame.getContentPane().add(rentalDays_text);
			
	    /**************************************************************************************************************/	
	        	        
	    /* Creating the OK buttons*/
		JButton okButton = new JButton("OK");
			
		//Inner class to implement ActionListener interface and perform action when Ok button is clicked
		class AddOkListener implements ActionListener
		{
			/**
			 * This method searches for the uniqueRegNum in the three ArrayLists.
			 * 
			 * @param event
			 */
			public void actionPerformed(ActionEvent event)
			{
				int uniqueRegNum = 0, rentalDays = 0;
					
				//set the unique register number
				if(isInt(propertyID_text.getText()))
				{
					uniqueRegNum = Integer.parseInt(propertyID_text.getText());
				}
					
				//set the rental days
				if(isInt(rentalDays_text.getText()))
				{
					rentalDays = Integer.parseInt(rentalDays_text.getText());					
				}
					
				//Find the register number in all properties
				for(int i = 0;i < apartments.size() + houses.size() + villas.size();i++)
				{					
					//if i is still in the range of apartments
					if(i < apartments.size())
					{
						if(uniqueRegNum == apartments.get(i).getUniqueRegNum())
						{							
							apartments.get(i).RentAnItem(rentalDays);
						}
					}
						
					//if i is still in the range of houses
					if(i < houses.size())
					{
						if(uniqueRegNum == houses.get(i).getUniqueRegNum())
						{							
							houses.get(i).RentAnItem(rentalDays);
						}
					}
						
					//if i is still in the range of villas
					if(i < villas.size())
					{
						if(uniqueRegNum == villas.get(i).getUniqueRegNum())
						{							
							villas.get(i).RentAnItem(rentalDays);							
						}
					}
				}
					
				//Close and dispose of the frame.
				GiveRentalPropertyFrame.getDefaultCloseOperation();
				GiveRentalPropertyFrame.dispose();
					
				//Print details for all properties
				BnbProcessor.PrintAllProperties("OutputProperty.txt", apartments, houses, villas);
					
									
			}
				
		}
			
		//Add okListener to the okButton
		ActionListener oklistener = new AddOkListener();
		okButton.addActionListener(oklistener);
			
		/**************************************************************************************************************/	
			
		/* Creating cancel button. */
		JButton cancelButton = new JButton("Cancel");
			
		//Inner class to implement ActionListener interface and perform action when cancel button is clicked
		class AddCancelListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				//Close and dispose of the frame.
				GiveRentalPropertyFrame.getDefaultCloseOperation();
				GiveRentalPropertyFrame.dispose();
					
				//Print details for all properties
				BnbProcessor.PrintAllProperties("OutputProperty.txt", apartments, houses, villas);
			}
		}
			
		//Add cancelListener to the cancelButton
		ActionListener cancelListener = new AddCancelListener();
		cancelButton.addActionListener(cancelListener);
			
		/**************************************************************************************************************/	
			
		//Adding to frame
		GiveRentalPropertyFrame.getContentPane().add(okButton);  	
		GiveRentalPropertyFrame.getContentPane().add(cancelButton);  	   
		GiveRentalPropertyFrame.setVisible(true);
		GiveRentalPropertyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
		
		
	/**
	 * This method checks to see if a string is an integer. 
	 * 
	 * @param strNum
	 * @return
	 */
	public static boolean isInt(String charNum) 
	{
		 boolean ret = true;
		    
		 try 
		 {
		     Integer.parseInt(charNum);
		 }
		    
		 catch(NumberFormatException e)
		 {
		     ret = false;
		 }
		    
		 return ret;
	}

	
	/**
	 * This method will scan the input file and fill in the appropriate ArrayLists.
	 * 
	 * @param fileName,bnbCars,bnbTrucks
	 */
	public static void ReadInputVehicleFile(String fileName, ArrayList<Car> bnbCars, ArrayList<Truck> bnbTrucks)
	{	
		try
		{
			int vehicleType = 0;
			String currentLine = "";
			FileReader readmyFile = new FileReader(fileName);
			Scanner scanMyFile = new Scanner(readmyFile);
			
			//Car variable
			int  passengersNumber = 0;
			
			//Truck variable
			int cargoWeight = 0; 
			
			//Common to all
			int initialRentalCostPerDay = 0, intitialTotalRentalDays = 0;
			String anOwner = "", aPostalAddress = "";
			
			
			//Reading each line in the file.
			while(scanMyFile.hasNextLine())
			{
				currentLine = scanMyFile.nextLine();
				String[] currentLineParts = currentLine.split(" ");//Split the line into tokens.
				
				//Determining the property type.
				if(isInt(currentLineParts[0]))
				{
					vehicleType = Integer.parseInt(currentLineParts[0]);
				}
				
				//bnbCars
				if(vehicleType == 1)
				{
					//Filling in bnbCars details.
					passengersNumber = Integer.parseInt(currentLineParts[1]);
					anOwner = currentLineParts[2];
					aPostalAddress = currentLineParts[3];
					initialRentalCostPerDay = Integer.parseInt(currentLineParts[4]);
					intitialTotalRentalDays = Integer.parseInt(currentLineParts[5]);

					//Calling Car constructor and adding Cart object to bnbCar arraylist.
					bnbCars.add(new Car(passengersNumber, anOwner, aPostalAddress, initialRentalCostPerDay,intitialTotalRentalDays));
				}
				
				//bnbTrucks
				else if(vehicleType == 2)
				{
					//Filling in bnbTrucks details
					cargoWeight = Integer.parseInt(currentLineParts[1]);
					anOwner = currentLineParts[2];
					aPostalAddress = currentLineParts[3];
					initialRentalCostPerDay = Integer.parseInt(currentLineParts[4]);
					intitialTotalRentalDays = Integer.parseInt(currentLineParts[5]);

					//Calling Car constructor and adding Car object to bnbTrucks arraylist.
					bnbTrucks.add(new Truck(cargoWeight, anOwner, aPostalAddress, initialRentalCostPerDay, intitialTotalRentalDays));					
				}				
			}
			
			//Calling RentAnItem method from RentalItem interface for each element in bnbCars and bnbTrucks
			for(Car element : bnbCars)
			{
				element.RentAnItem(10);
			}
			
			for(Truck element : bnbTrucks)
			{
				element.RentAnItem(10);
			}
			
			scanMyFile.close();
		}
		
		catch(Exception ex)
		{
			System.out.println("exception " + ex.getMessage() + " caught");
		}
		
		
		
		/* Hard-coded array list entries in case user does not want to input or for testing. 
		 * 
		 * bnbCars.add(new Car(2,"Darren Shan","3 Cirque Du Frique Rd.",20,100));
		 * bnbCars.add(new Car(1,"Terry Pratchett","2 Ring Rd.",20,90));
         * bnbCars.add(new Car(4,"Agatha Christie","64 ABC Lane",20,162));
         * 
         * bnbTrucks.add(new Truck(150,"Izaya Orihara","70 Dollarville Lane",20,111));
         * bnbTrucks.add(new Truck(200,"Jane Doe","78 Horton avenue",20,14));
         * bnbTrucks.add(new Truck(100,"Rocket","12 Sandy drive",20,45));
         * 
         */
		
		
	}
	
	
	/**
	 * This method outputs the contents of all Vehicle ArrayLists into an output file.
	 * @param bnbCars,bnbTrucks
	 */
	public static void PrintAllVehicles(String fileName, ArrayList<Car> bnbCars, ArrayList<Truck> bnbTrucks)
	{
		int i = 0;
		String welcomeString = "", newLines = "\n\n\n", outputString = ""; 
		String bnbCarsHeader = "", bnbCarsAttributes = "", bnbCarsString = ""; 
		String bnbTrucksHeader = "", bnbTrucksAttributes = "", bnbTrucksString = "";  
				
		welcomeString = String.format("%s","-------------------------------------------------------------------------------MyBnb2 : Vehicles------------------------------------------------------------------------------------------------\n\n\n");

		/*bnbCars*/
		bnbCarsHeader = String.format("%s","_____________________________________________________________________________________Cars_____________________________________________________________________________________\n\n");

		bnbCarsAttributes = String.format("%25s %25s %25s %25s %25s %25s \n", "UniqueReg no.","Owner","Address","Total Days rented","Rent-Cost-Per-Day","Passengers no.");

		for(i = 0;i < bnbCars.size();i++)
		{		
			bnbCarsString += String.format("%25s %25s %25s %25s %25s %25s \n", bnbCars.get(i).getUniqueRegNum(),bnbCars.get(i).getOwner(),bnbCars.get(i).getPostalAddress(),
			bnbCars.get(i).getTotalRentalDays(), bnbCars.get(i).getRentalCostPerDay(), bnbCars.get(i).getPassengersNumber());
		}
		
		outputString += welcomeString + bnbCarsHeader + bnbCarsAttributes + bnbCarsString + newLines;
		
		/*--------------------------------------------------------------------------------------------*/	

		
		/*bnbTrucks*/
		bnbTrucksHeader = String.format("%s","____________________________________________________________________________________Trucks____________________________________________________________________________________\n\n");

		bnbTrucksAttributes = String.format("%25s %25s %25s %25s %25s %25s \n", "UniqueReg no.","Owner","Address","Total Days rented","Rent-Cost-Per-Day","no. stories","Cargo weight");

		for(i = 0;i < bnbTrucks.size();i++)
		{		
			bnbTrucksString += String.format("%25s %25s %25s %25s %25s %25s \n", bnbTrucks.get(i).getUniqueRegNum(),bnbTrucks.get(i).getOwner(),bnbTrucks.get(i).getPostalAddress(),
			bnbTrucks.get(i).getTotalRentalDays(), bnbTrucks.get(i).getRentalCostPerDay(), bnbTrucks.get(i).getCargoWeight());
		}
		
		outputString += bnbTrucksHeader + bnbTrucksAttributes + bnbTrucksString + newLines;
		
		//Calculating total Income for all vehicles
		outputString += "Total vehicle rental income is " + BnbProcessor.CalculateVehicleTotallIncome(bnbCars, bnbTrucks) + newLines;

		
		/*--------------------------------------------------------------------------------------------*/		
						
		//Writing to output file.
		try
		{
			PrintWriter out = new PrintWriter(fileName);
			out.write(outputString);
			out.close();
		}
		
		catch(Exception ex)
		{
			System.out.println("exception " + ex.getMessage() + " caught");
		}
				
	}
	
	
	/**
	 * This method will calculate the total income from all Vehicles including the additional costs and taxes .
	 * @param bnbCars,bnbTrucks
	 */
	public static int CalculateVehicleTotallIncome(ArrayList<Car> bnbCars, ArrayList<Truck> bnbTrucks)
	{
    	int TotalVehicleIncome = 0, i;
    	
        for(i = 0;i < bnbCars.size();i++)
        	TotalVehicleIncome += bnbCars.get(i).getTotalRentalDays() * bnbCars.get(i).getRentalCostPerDay();
        
        for(i = 0;i < bnbTrucks.size();i++)
        	TotalVehicleIncome += bnbTrucks.get(i).getTotalRentalDays() * bnbTrucks.get(i).getRentalCostPerDay() + bnbTrucks.get(i).getCargoWeight();
               
        return TotalVehicleIncome;
    }

}
