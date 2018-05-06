package dog_hotel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
	  
	    try {
			
			DogHotel dogHotel = new DogHotel();
			
			BufferedReader reader = new BufferedReader(new FileReader("doggys.txt"));
		    
			String line = "";
			
		    while (line != null) {
		    	
			    	if (line.length() < 4 || !line.substring(0, 4).equals("Name")) {
						
			    		line = reader.readLine();
			    		
			    		continue;
			    		
			    	} else {
			    	
			    		String name = line.split(": ")[1];
			    		int age = Integer.parseInt(reader.readLine().split(": ")[1]);
			    		boolean dirty = reader.readLine().split(": ")[1].equals("Yes");
			    		boolean bites = reader.readLine().split(": ")[1].equals("Yes");
			    		int days = Integer.parseInt(reader.readLine().split(": ")[1]);
			    		
			    		dogHotel.addDog(new Dog(name, age, dirty, bites, days));
				
			    	}
		    	
		    	line = reader.readLine();
		    	
		    }
		    
		    reader.close();
		    System.out.println("\nWelcome to Byrackan Dog Hotel!\n");
		    
		    
		    
		    while(true) {
		    	
		    		for(int i = 0; i < 3; i++) {
		    		
			    		if (Math.random() > 0.8) {
			    			
			    			dogHotel.addRandomDog();
			    	
			    		}
			    		
		    		}
		    		
		    		if (Math.random() > 0.8) {
		    			
		    			dogHotel.cleanAllDogs();
		    			System.out.println("The dogs in the hotel were finally washed!");
		    			
		    		}
		    
			    System.out.println("\n"+dogHotel.howManyBites() + " dogs bite.");
			    System.out.println(dogHotel.howManyDirty() + " dogs are dirty.\n");
			    
			    dogHotel.printDogs();
			    
			    try {
			    
			    		Thread.sleep(4_000);
			    
			    } catch (Exception e) {
			    	
			    		System.out.println("Something went wrong.");
			    		return;
			    	
			    }
			   
	    			System.out.println("\n--------------------\n");
			    
			    dogHotel.nextDay();
		    
		    }
			
		} catch (FileNotFoundException f) {
			
			System.out.println("Could not find file.");
			f.toString();
			
		} catch(IOException i) {
			
			System.out.println("Could not read correctly from file.");
			i.toString();
			
		} catch(Exception e) {
			
			System.out.println("Something wrong happened!");
			e.printStackTrace();
			
		}
	    	
	}

}
