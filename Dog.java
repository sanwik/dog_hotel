package dog_hotel;

public class Dog {
	
	private String name;
	private int age;
	private boolean isDirty;
	private boolean doesBite;
	private int days;
	
	public Dog(String name, int age, boolean isDirty, boolean doesBite, int days) {
		
		this.name = name;
		this.age = age;
		this.isDirty = isDirty;
		this.doesBite = doesBite;
		this.days = days;
		
	
	}

    public String getName() {
        
        return name;
        
    }

    public int getAge() {
        
        return age;
        
    }
	
    public boolean getIsDirty() {
        
        return isDirty;
        
    }
    
    public boolean getDoesBite() {
        
        return doesBite;
        
    }
    
    public int getDays() {
        
        return days;
        
    }
    
    public void setDays (int amount) {
    	
	his.days = amount;
    	   
    }
    
    public void clean() {
        
        this.isDirty = false;
        
    }
	

}
