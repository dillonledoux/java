import java.util.*;

public class Permutations<E>{

    public static void main(String[] args){
        int counter = 0;
    
        ArrayList<Integer> test = new ArrayList<>();
        
        int numberOfElements = 3;
        
        for(int i = 0; i<numberOfElements; i++){
            test.add(i);
        }
        
        Permutations<Integer> testPerm = new Permutations<Integer>(test);
        
        while(testPerm.hasNext()){
            System.out.println(testPerm.next();
            counter++;
        }    
    }

    boolean hasNext = true;
    Integer elementC;
    Permutations<E> newPermP;
    ArrayList<Integer> firstPermL = new ArrayList<Integer>();
    int counterI = 0;
    ArrayList<Integer> copy = new ArrayList<Integer>();
    
	public Permutations(ArrayList<Integer> list){

	    copy.addAll(list);
	    if(list.size() == 0){
	        hasNext = false;
	    }
	    else{
	        elementC = copy.remove(0);
	        newPermP = new Permutations<E>(copy);
	        
	        if(newPermP.hasNext()){
	            firstPermL = newPermP.next();
	        }
	    }
	}
		
	public boolean hasNext(){
	    return hasNext;
	}
	
	public ArrayList<Integer> next(){
	
	    ArrayList<Integer> toReturn = new ArrayList<Integer>();
	    
	    if(hasNext == false){
	        return null;
	        
	    } else if((newPermP.hasNext()==false) && (counterI==firstPermL.size())){
	        hasNext = false;
	    }
	    
	    if(counterI <= firstPermL.size()){
	        toReturn.addAll(firstPermL);
	        toReturn.add(counterI, elementC);
	        counterI++;
	    
	    } 
	    else {
	        counterI = 0;
	        firstPermL = newPermP.next();
	        toReturn = this.next();  
	        
	    }
	    return toReturn;
	}
}