import java.util.*;
import java.io.*;

public class SortStudents 
{
	public static void main(String[] args){
		System.out.println();
		System.out.println("Student sorting program by Dillon LeDoux");
	
		if (args.length < 2){
			System.out.println("Please give a valid sorting parameters.");
			System.out.println();
			System.exit(1);
		}
		Scanner scan = new Scanner(System.in);
		
		
		try {
		scan = new Scanner(new File(args[0]));
		}
		catch (FileNotFoundException e)
		{
		   System.out.println("Error: Cannot find the file.");
		   System.exit(0);
		}

		List<Student> list = new ArrayList<Student>(); //Creates ArrayList to hold the objects Student
		
		//Fills arraylist with the student objects
		while (scan.hasNext() != false){
			String tempIdnum = scan.next();
			String tempFirstName = scan.next();
			String tempLastName = scan.next();
			String tempYear = scan.next();
			String tempGpa = scan.next();
			
			//Removes the comma from the end of the first four strings in the list	
			tempIdnum = tempIdnum.substring(0, tempIdnum.length()-1);
			tempFirstName = tempFirstName.substring(0, tempFirstName.length()-1);
			tempLastName = tempLastName.substring(0, tempLastName.length()-1);
			tempYear = tempYear.substring(0, tempYear.length()-1);
			
			//populates the arraylist list	
			list.add(new Student(tempIdnum, tempFirstName, tempLastName, tempYear, tempGpa));
		}
		
		if (args[1].equals("idNum")){
			Collections.sort(list, new IdnumComparator());
		}
		else if (args[1].equals("firstName")){
			Collections.sort(list, new FirstNameComparator());
		}
		else if (args[1].equals("lastName")){	
			Collections.sort(list, new LastNameComparator());
		}	
		else if (args[1].equals("year")){
			Collections.sort(list, new YearComparator());
		}	
		else if (args[1].equals("gpa")){
			Collections.sort(list, new GpaComparator());
		}	
		else{
			System.out.println("Pleases provide a valid argument.");
			System.exit(0);
		}						
		
		//Begin formatted printing...
		
		System.out.printf("%3s %-10s %-12s %1s %3s", "ID", "  First", " Last", "Year", "  GPA");
		System.out.println();
		System.out.println();
	
		for (int i = 0; i<11; i++)
		{
			System.out.printf("%3s   ", list.get(i).getIdnum());
			System.out.printf("%-10s", list.get(i).getFirstName());
			System.out.printf("%-10s", list.get(i).getLastName());
			System.out.printf("%6s", list.get(i).getYear());
			System.out.printf("%6s", list.get(i).getGpa());
			System.out.println();
		}

		}
}

class IdnumComparator implements Comparator<Student> {

	public int compare(Student id1, Student id2) {
	
		int num1 = Integer.parseInt(id1.getIdnum());
		int num2 = Integer.parseInt(id2.getIdnum());
	
		if (num1 > num2){
			return 1;
		}
		else if (num1 < num2){
			return -1;
		}
		return 0;
		}
}

class YearComparator implements Comparator<Student> {

	public int compare (Student y1, Student y2) {
		
		int year1 = Integer.parseInt(y1.getYear());
		int year2 = Integer.parseInt(y2.getYear());
		
		if (year1 > year2){
			return 1;
		}
		else if (year1 < year2){
			return -1;
		}
		return 0;
		}		
}

class GpaComparator implements Comparator<Student> {

	public int compare(Student g1, Student g2) {
		
		double gpa1 = Double.parseDouble(g1.getGpa());
		double gpa2 = Double.parseDouble(g2.getGpa());
		
		if (gpa1 > gpa2){
			return 1;
		}
		else if (gpa1 < gpa2){
			return -1;
		}
		return 0;
		}		
}	

class FirstNameComparator implements Comparator<Student>{
	
	public int compare(Student fn1, Student fn2) {

		return fn1.getFirstName().compareTo(fn2.getFirstName());
		}
}

class LastNameComparator implements Comparator<Student>{
	
	public int compare(Student ln1, Student ln2) {

		return ln1.getLastName().compareTo(ln2.getLastName());
		}
}
