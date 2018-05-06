package dog_hotel;

import java.util.ArrayList;
import java.util.Random;

public class DogHotel {
	
	private ArrayList<Dog> dogs;
	private int nDogs;
	private final int maxDogs = 10;
	private int nDay;
	
	private final String[] dogNames = {"Åsne", "Goldfish", "Lee", "Snati", "Brandur", "Depill", 
			"Pricken", "Åttan", "Sokkur", "Virvel", "Kungen", "Donut", "Peanut", "Sigmundur"};
	
	public DogHotel() {
		
		nDay = 0;
		dogs = new ArrayList<Dog>(maxDogs);

	}
	
	public void addDog(Dog d) {
		
		if (dogLimitReached()) {
			
			System.out.println("");
			
			System.out.println("Unfortunately the hotel is fully booked.");
			
		}
		
		else {
		
		dogs.add(d);
		
		nDogs++;
		
		System.out.println(d.getName() + " has checked in.");
		
		}
	
	}
	
	public void addRandomDog() {
		
		String dogName = "";
		
		outerloop:
		for (String name : dogNames) {
			
			for (Dog dog : dogs) {
				
				if (name.equals(dog.getName())) {
					
					 continue outerloop;
					
				}
				
			}
			
			dogName = name;
			break;
			
		}
		
		if (dogName.equals("")) {
			
			System.out.println("We did not find a dog name for you.");
			return;
			
		}
		
		int age = (int) (Math.random() * 10) + 2;
		
		boolean dirty = Math.random() < 0.3;
		
		boolean bites = Math.random() < 0.1;
		
		int days = (int) (Math.random() * 16) + 1;
		
		addDog(new Dog(dogName, age, dirty, bites, days));
		
		
		
		
	}
	
	public boolean dogLimitReached() {
		
		return (maxDogs <= nDogs);
		
	}
	
	public void cleanAllDogs() {
		
		System.out.println("");
		
		System.out.println("ALL THE DOGS ARE GETTING CLEANED.");
		
		System.out.println("");
		
		for (Dog dog : dogs) {
			
			dog.clean();
			
		}
		
	}
	
	public void printDogs() {
		
		for (Dog dog : dogs) {
			
			System.out.println(dog.getName() + "\t\tis " + dog.getAge() + " years old" + ", does " + (dog.getDoesBite() ? "" : "not ")
					+ "bite, is " + (dog.getIsDirty() ? "not " : "") + "dirty and will stay for " + dog.getDays() + " days more.");
			
			/*System.out.println("Name: " + dog.getName());
			
			
			System.out.println("Age: " + dog.getAge());
			
			System.out.println("Dirty: " + dog.getIsDirty());
			
			System.out.println("Bites: " + dog.getDoesBite());
			
			System.out.println("Days to stay: " + dog.getDays());
			
			System.out.println(""); */
			
		}
		
	}
	
	public int howManyBites() {
		
		int amount = 0;
		
		for (Dog dog : dogs) {
			
			if (dog.getDoesBite()) {
				
				amount++;
				
			}
			
		}
		
		return amount;
		
	}
	
	public int howManyDirty() {
		
		int amount = 0;
		
		for (Dog dog : dogs) {
			
			if (dog.getIsDirty()) {
				
				amount++;
				
			}
			
		}
		
		return amount;
		
	}
	
	public void nextDay() {
		
		nDay++;
		
		System.out.println("DAY " + nDay);
		
		System.out.println("");
		
		for (int i = 0; i < dogs.size(); i++) {
			
			Dog dog = dogs.get(i);
			
			dog.setDays(dog.getDays() - 1); 
			
			if (dog.getDays() == 0) {
				
				System.out.println(dog.getName() + " checked out.");
				
				dogs.remove(dog);
				
				nDogs--;
				
				i--;
				
			}
			
		}
		
	}
	

}
