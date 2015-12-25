// Program 4: Compress
// Dillon LeDoux
// CS-1113-004

import java.util.*;

public class Compress {

	
	public static String starterData;
	public static int starterLength;
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		if (args.length==0){
			usage();
			System.exit(0);
		}
		
		if (!scan.hasNext()){
			System.out.println("Please supply a valid input file.");
			System.exit(0);
		}
		starterData = scan.next();
		starterLength = starterData.length(); //gets total length of starting string and stores it in variable
		String[] mode = {"-c", "-d"};
		if (mode[1].equals(args[0])){
			decode();
		}
		else if (mode[0].equals(args[0])){
			encode();
		}
		else {
		usage();
		}
		System.out.println();
		}
	public static void encode(){
		String letter = "";
		int j = 0;
		int k = 0; 
		while (k< starterLength){
			letter = starterData.charAt(j)+"";
			int y = 0;
			while (k<starterLength && starterData.charAt(j)==starterData.charAt(k) && y<61){
				y++;
				k++;
								}
			j = k;
			System.out.print(letter);
			if (y<=9){
				System.out.print(y);
			}
			else if (y>9 && y<36){
				y = y+55;
				System.out.print((char)y);		
			}
			else {
				y = y+61;
				System.out.print((char)y);
			}
			}
			}
	
	
	
	public static void usage() {
		System.out.println("");
		System.out.println("Compress program by Dillon LeDoux");
		System.out.println("usage: java Compress [-c, -d] < inputFile > outputFile");
		System.out.println("");
	}

	public static void decode() {
	
		int vloc;
		int qloc;
		int decimal = 0;
		char quantity;
		String character;
		
		
		for (vloc =0;  vloc <= starterLength-2; vloc = vloc+2) {
			character = starterData.substring(vloc, vloc+1);
			qloc = vloc+1;
			quantity = starterData.charAt(qloc);
			
			
			if (quantity > 48 && quantity < 58){
				decimal = quantity-48;
				}
			else if (quantity > 64 && quantity < 91){
				decimal = 10;
				for (int i = 65; i <= 90; i++){
					if (i == quantity){
						break;
					}
					decimal++;
				}
			}
			else if (quantity > 96 && quantity < 123){
				decimal = 36;
				for (int i = 97; i < 123; i++){
					if (i == quantity){
						break;
					}
					decimal++;
				}
			}
			else {
			System.out.println(quantity);
					System.out.println("Something went wrong, please try again please.");
					System.exit(0);
				}
				
			for (int i = 0; i < decimal; i++ ){
			
				System.out.print(character+"");
				
			}
		}
			
		}		
	}