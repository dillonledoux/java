import java.io.*;

public class Caesar{

	public static void main(String[] args){
		
		String line;
	    char charValue;
	    int unicodeNumber;
	    int shiftNumber = 0;
	    File inFile = null;
	    File outFile = null;
	    BufferedWriter bw = null;
	    
	    try{
	        shiftNumber = Integer.parseInt(args[0]);
	    }
	    catch(IndexOutOfBoundsException e){
	            System.out.println("Please input a valid key.");
	            System.exit(0);
	    }
	    try{
	        inFile = new File(args[1]);
	    }
	    catch(Exception e){
	        System.out.println("Please provide a valid input file.");
	        System.exit(0);
	    }
	    try{
	        outFile = new File(args[2]);
	        if(!outFile.exists()){
	            outFile.createNewFile();
	        }
	        bw = new BufferedWriter(new FileWriter(outFile));
	    }
	    catch(Exception e){
	        System.out.println("Please provide a valid output file.");
	        System.exit(0);
	    }
	      
	    try{
	        BufferedReader in = new BufferedReader(new FileReader(inFile));
	        while((line = in.readLine()) != null){
            
                for(int i=0; i<line.length(); i++){
                    charValue = line.charAt(i);
                    unicodeNumber = charValue;
                    unicodeNumber = unicodeNumber + shiftNumber;
                    charValue = (char)unicodeNumber;
                    bw.write(charValue+ "");
                }
	        bw.newLine();         
	        }
	    }
	    catch(Exception e){
	        System.out.println("There was an error writing the file");
	        e.printStackTrace();
	    }
	    
	    try{ 
	        bw.close();
	    }
	    catch(IOException e){
	        e.printStackTrace();
	    } 
	}
}