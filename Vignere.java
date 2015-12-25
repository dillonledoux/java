 //This is the extra credit portion of part 1 of assignment 4. 
 //Please run the program with the "usage" option for use instructions

import java.io.*;

public class Vignere{

	public static void main(String[] args){
		
		boolean decode = false;
		String line;
	    char charValue;
	    int unicodeNumber;
	    String shiftKey = "";
	    int[] shiftValuesArray = null;
	    File inFile = null;
	    File outFile = null;
	    BufferedWriter bw = null;
	    
	    try{
	        if(args[0].equals("-e")){
	            decode = false;  
	        }
	        else if(args[0].equals("-d")){
	            decode = true;
	        }
	        else if(args[0].equals("usage")){
	            System.out.println("Please use the following command order:");
	            System.out.println("Vignere -e(or -d) key infile outfile");
	            System.out.println("-e encodes a file while -d decodes a file");
	        }
	        else{
	            System.out.println("Please use either -e for encode or -d for decode as an instruction followed by the key.");
	            System.exit(0);
	        }
	    
	    }
	    catch(Exception e){
	        System.out.println("Please provide a valid encoding or decoding key");
	        System.exit(0);
	        
	    }
	     
	    try{
            shiftKey = args[1];
            shiftValuesArray = new int[(shiftKey.length())];
            for(int i=0; i<shiftKey.length(); i++){
                charValue = shiftKey.charAt(i);
                unicodeNumber = charValue;
                if(decode){
                    unicodeNumber = unicodeNumber * (-1);
                }
                shiftValuesArray[i] = unicodeNumber;
            }
	        
	    }
	    catch(IndexOutOfBoundsException e){
	            System.out.println("Please input a valid key.");
	            System.exit(0);
	    }
	    try{
	        inFile = new File(args[2]);
	    }
	    catch(Exception e){
	        System.out.println("Please provide a valid input file.");
	        System.exit(0);
	    }
	    try{
	        outFile = new File(args[3]);
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
                int indexCounter = 0;
                for(int i=0; i<line.length(); i++){
                    charValue = line.charAt(i);
                    unicodeNumber = charValue;
                    unicodeNumber = unicodeNumber + shiftValuesArray[indexCounter];
                    charValue = (char)unicodeNumber;
                    bw.write(charValue+ "");
                    indexCounter++;
                    if(indexCounter==shiftKey.length()){
                        indexCounter = 0;
                    }   
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