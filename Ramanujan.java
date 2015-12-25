public class Ramanujan{

	public static void main(String[] args){
	
        int givenNumber = Integer.parseInt(args[0]); //k = number provided
        double oneOverPi = calcRama(givenNumber);
        double calcPi = 1/oneOverPi;
        System.out.println(calcPi);
        
        double percentError = ((Math.abs(calcPi-Math.PI))/Math.PI)*100;
        System.out.println("The percent error from Java's value is " +percentError+ "");
		
			
		
		
	}

    public static double calcRama(int givenNumber){ // calculates 1/pi
         
		double numer;
		double denom;
		double summation = 0;
		
		for (int k=0; k<=givenNumber; k++){
		
		    numer = (Factorial.calculate(4*k))*(1103+(26390*k));
            denom = (Math.pow(Factorial.calculate(k), 4))*(Math.pow(396, (4*k)));
        
            summation += (numer/denom);
		
		}
		
        
        return summation*((2*Math.sqrt(2))/9801);
    
    
        
    
    }



}