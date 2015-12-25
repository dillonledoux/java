//	Dillon LeDoux
//	Program 7 - AutoSearch.java
//	CS 1113-004

import java.util.*;
import java.io.*;

public class AutoSearch{

	static ArrayList<Automobile> displayList = new ArrayList<>();
	static ArrayList<Automobile> carList = new ArrayList<>();
	static ArrayList<String> inputList = new ArrayList<>();
		
	public static void main(String[] args){
	    System.out.println("Automobile Search program by Dillon LeDoux");
		Scanner scan = new Scanner(System.in);
		
		while(true){
            System.out.print("% ");	
            Scanner newScan = new Scanner(scan.nextLine());	
		//	Loads whatever is input by the user into the inputList arraylist
            inputList.clear();
			while(newScan.hasNext())
			{
				String next = newScan.next();
				inputList.add(next);				
			}

			    commandCheck(inputList);						    
		}
	}	

	public static void commandCheck(ArrayList<String> list)
	{
		try
		{
			if(list.get(0).equals("quit"))
			{
				System.exit(0);
			}
			else if(list.get(0).equals("help"))
			{
				System.out.println("      Accepted commands;");
				System.out.println("      quit");
				System.out.println("      help");
				System.out.println("      load [filename]");
				System.out.println("      display all");
				System.out.println("      make = [make]");
				System.out.println("      model = [model]");
				System.out.println("      year range [low] [high]");
				System.out.println("      price range [low] [high]");
			}
			else if(list.get(0).equals("load"))
			{
				carList.clear();
				try
				{
					Scanner importdata = new Scanner(new File(list.get(1)));
					
					while(importdata.hasNext())
					{
                        String tempMake = importdata.next();
                        String tempModel = importdata.next();
                        String tempYear = importdata.next();
                        String tempMileage = importdata.next();
                        String tempPrice = importdata.next();
                        int tempYearInt;
                        int tempMileageInt;
                        double tempPriceDouble;
                    
                        //Remove the comma from the token
                        tempMake = tempMake.substring(0, tempMake.length()-1);
                        tempModel = tempModel.substring(0, tempModel.length()-1);
                        tempYear = tempYear.substring(0, tempYear.length()-1);
                        tempMileage = tempMileage.substring(0, tempMileage.length()-1);
                        tempPrice = tempPrice.substring(0, tempPrice.length()-1);
                    
                        try
                        {
                            tempYearInt = Integer.parseInt(tempYear);
                            tempMileageInt = Integer.parseInt(tempMileage);
                            tempPriceDouble = Double.parseDouble(tempPrice);
                        
                            carList.add(new Automobile(tempMake, tempModel, tempYearInt, tempMileageInt, tempPriceDouble));
                        }
                        catch(Exception c)
                        {
                            System.out.println("There was an error in the database syntax, " +list.get(1)+ " may not have loaded correctly.");
                            break;
                        }
					}
					System.out.println("loaded");					
				}
				catch(FileNotFoundException b)
				{
					System.out.println("The file" +list.get(1)+ "was not found.");
				}
			
			}
			else if(list.get(0).equals("display")&&list.get(1).equals("all"))
			{
			    displayAll(carList);
			}
		    
		    else if(list.get(0).equals("make")||list.get(0).equals("model"))
		    {
		        sortNoRange(list.get(0), list.get(2));
		    }
		
		    else if(list.get(0).equals("year")||list.get(0).equals("mileage")||list.get(0).equals("price"))
		    {
		        sortWithRange(list.get(0), list.get(2), list.get(3));
		    }
		    else
		    {
		        System.out.println("Not a valid input.");
		    }
		}
		catch(Exception a)
		{
			System.out.println("Sorry, that is not a valid input.  Please type help to view the options.");
		}	
	}

        public static void displayAll(ArrayList<Automobile> list)
        {
            System.out.printf("%-8s %11s %6s %1s %3s", "Make  ", "  Model   ", " Year ", "Mileage    ", "   Price");
            System.out.println();
    
            for (int i = 0; i<list.size(); i++)
            {
                System.out.printf("%-10s  ", list.get(i).getMake());
                System.out.printf("%-8s  ", list.get(i).getModel());
                System.out.printf("%4s  ", list.get(i).getYear());
                System.out.printf("%7s  ", list.get(i).getMileage());
                System.out.printf("%2s", " $ ");
                System.out.printf("%8s", list.get(i).getPrice());
                System.out.println();
            }
        }

        public static void sortNoRange(String parameter, String value)
        {
            displayList.clear();
            
            if(parameter.equals("make"))
            {
                for(int i=0; i<carList.size(); i++)
                {
                    if(carList.get(i).getMake().equals(value))
                    {
                        displayList.add(carList.get(i));
                    }
                }
            }
            
            else if(parameter.equals("model"))
            {
                for(int i=0; i<carList.size(); i++)
                {
                    if(carList.get(i).getModel().equals(value))
                    {
                        displayList.add(carList.get(i));
                    }
                }
            }
            
            displayAll(displayList);
        }
        
        public static void sortWithRange(String parameter, String lowStr, String highStr)
        {
            displayList.clear();
            
            if(parameter.equals("year"))
            {
                for(int i=0; i<carList.size(); i++)
                {
                        displayList.add(carList.get(i));             
                }
                try
                {
                    int low = Integer.parseInt(lowStr);
                    int high = Integer.parseInt(highStr);
                
                    for(int i=0; i<displayList.size(); i++)
                    {
                        int number = displayList.get(i).getYear();
                        if(number > high || number < low)
                        {
                            displayList.remove(i);
                            i--;
                        }
                    }
                }
                catch(Exception c)
                {
                    System.out.println("Invalid range.  Please try again.");
                }
            
            }
                      
            else if(parameter.equals("mileage")||parameter.equals("Mileage"))
            {
                for(int i=0; i<carList.size(); i++)
                {
                    displayList.add(carList.get(i));
                }
                try
                {
                    int low = Integer.parseInt(lowStr);
                    int high = Integer.parseInt(highStr);
                
                    for(int i=0; i<displayList.size(); i++)
                    {
                        int number = displayList.get(i).getMileage();
                        if(number > high || number < low)
                        {
                            displayList.remove(i);
                            i--;
                        }
                    }
                }
                catch(Exception c)
                {
                    System.out.println("Invalid range.  Please try again.");
                }
            }                       
           
            else if(parameter.equals("price")||parameter.equals("Price"))
            {
                for(int i=0; i<carList.size(); i++)
                {
                   displayList.add(carList.get(i));
                }
                try
                {
                    double low = Double.parseDouble(lowStr);
                    double high = Double.parseDouble(highStr);
                
                    for(int i=0; i<displayList.size(); i++)
                    {
                        double number = displayList.get(i).getPrice();
                        if(number<low||number>high)
                        {
                            displayList.remove(i);
                            i--;
                        }
                    }
                }
                catch(Exception c)
                {
                    System.out.println("Invalid range.  Please try again.");
                }
            }
            else
            {
                System.out.println("Please input a valid argument.");
            }
                       
        try
        {
           if(displayList.isEmpty())
           {
                System.out.println("There was none found in the given range.");
           }
           else
           {
            displayAll(displayList);
            }
        }
        catch(Exception d)
        {
            System.out.println("There was an error while printing the displayList");
        }
    }
        
        


}