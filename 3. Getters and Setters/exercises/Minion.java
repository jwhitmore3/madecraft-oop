package exercises;

public class Minion {

	private String name;
	private int eyes;
	private String color;
	private String master;
	
	//constructor
	Minion(String name,int eyes,String color,String master)
	{
		this.name=name;
		this.eyes=eyes;
		this.color=color;
		this.master=master;
	}
	//getters
	String getName()
	{
		return this.name;
	}

	String getColor() {
		return this.color;
	}
	
	int getEyes() {
		return this.eyes;
		
	}
	
	String getMaster() {
		return this.master;
		
	}
	
	void  setMaster(String master) {
			this.master=master;
	}
	
	
	
	
	
}
