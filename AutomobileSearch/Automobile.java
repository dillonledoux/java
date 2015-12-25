public class Automobile{

	private String make;
	private String model;
	private int year;
	private int mileage;
	private double price;
	
// template class for automobiles
	public Automobile(String make, String model, int year, int mileage, double price)
	{
		this.make = make;
		this.model = model;
		this.year = year;
		this.mileage = mileage;
		this.price = price; 
	}
	
//Beginning of setter methods
	public void addMake(String newMake)
	{
		make = newMake;
	}
	
	public void addModel(String newModel)
	{
		model = newModel;
	}
	
	public void addYear(int newYear)
	{
		year = newYear;
	}

	public void addMileage(int newMileage)
	{
		mileage = newMileage;
	}
	
	public void addPrice(double newPrice)
	{
		price = newPrice;
	}
	
//Beginning of getter methods
	public String getMake()
	{
		return make;
	}
	
	public String getModel()
	{
		return model;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public int getMileage()
	{
		return mileage;
	}
	
	public double getPrice()
	{
		return price;
	}
}