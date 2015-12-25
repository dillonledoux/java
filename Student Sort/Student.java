public class Student{
	
	private String idNum, year, gpa, firstName, lastName;
	
	Student(String idNum, String firstName, String lastName, String year, String gpa){
		this.idNum = idNum;
		this.year = year;
		this.gpa = gpa;
		this.firstName = firstName;
		this.lastName = lastName;
	}
		
	public String getIdnum(){
		return idNum;
	}
	
	public String getYear(){
		return year;
	}
	
	public String getGpa(){
		return gpa;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}	
	
}