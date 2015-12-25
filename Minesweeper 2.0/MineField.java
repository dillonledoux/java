import java.util.*;
import java.io.Serializable;

public class MineField implements Serializable{
    private int numberOfRows = 0;
    private int numberOfColumns = 0;
    private int numberOfMines = 0;
    private int[][][] fieldGrid = null;
    private Random randomNumber = new Random();
    private int mineXCoor, mineYCoor;
    
        /*
        fieldGrid[][][] info:
        numberOfRows = x component, number of rows in the mine field
        numberOfColumns = y component, number of columns in the mine filed
        [3] -   [0] holds the value of the space, (probability number or bombed)
                [1] holds whether the space has been viewed by the user
                [2] holds whether the space has been flagged for a bomb by the user
        */ 
        
    public MineField(int rows, int columns, int mines){
        int mineXCoor, mineYCoor;
        numberOfRows = rows;
        numberOfColumns = columns;
        numberOfMines = mines;
        fieldGrid = new int[numberOfRows][numberOfColumns][3];
	    
	    this.resetField(numberOfMines);
	}
	
//	-----METHODS-----
	
	// ACCESSORS
	public int getNumberOfRows(){
	    return numberOfRows;
	}
	public int getNumberOfColumns(){
	    return numberOfColumns;
	}
	public int getNumberOfMines(){
	    return numberOfMines;
	}
	public int getSpaceValue(int x, int y){
	    return fieldGrid[x][y][0];
	}
	public int getViewedValue(int x, int y){
	    return fieldGrid[x][y][1];
	}
	public int getFlagValue(int x, int y){
	    return fieldGrid[x][y][2];
	}
	public boolean isFlagged(int x, int y){
	    if(fieldGrid[x][y][2] == 1){
	        return true;
	    }
	    else{
	        return false;
	    }
	}
	public boolean isViewed(int x, int y){
	    if(fieldGrid[x][y][1] == 1){
	        return true;
	    }
	    else{
	        return false;
	    }
	}
	public boolean isMinedSpace(int x, int y){
        if(fieldGrid[x][y][0]==9){
            return true;    
        }
        else{
            return false;
        }
    }
	
	// MUTATORS
	public void setFlagValue(int x, int y){
	    if(fieldGrid[x][y][2] == 0){
	        fieldGrid[x][y][2]=1;
	    }
	    else{
	        fieldGrid[x][y][2]=0;
	    }
	    System.out.println("Flag? - " +fieldGrid[x][y][2]);
	}
	public void setToViewed(int x, int y){
	    fieldGrid[x][y][1] = 1;   
	}
	
	public void setField(MineField newField){
        for(int i=0; i<numberOfRows; i++){
            for(int k=0; k<numberOfColumns; k++){	    
                fieldGrid[i][k][0] = newField.getSpaceValue(i, k);
                fieldGrid[i][k][1] = newField.getViewedValue(i, k);
                fieldGrid[i][k][2] = newField.getFlagValue(i, k);
            }
        }
	}
	
	public void resetField(int amountOfMines){
        // populates the cells with all zero values      
	    for(int i=0; i<numberOfRows; i++){
	        for(int k=0; k<numberOfColumns; k++){	    
	    	    fieldGrid[i][k][0] = 0;
	    	    fieldGrid[i][k][1] = 0;
	            fieldGrid[i][k][2] = 0;
	        }
	    }
        //populates with bombs (9)
        for(int i=0; i<amountOfMines; i++){
            mineXCoor = randomNumber.nextInt(numberOfRows-1);
            mineYCoor = randomNumber.nextInt(numberOfColumns-1);
            
            if(fieldGrid[mineXCoor][mineYCoor][0]==9){
                i--;
            }
            else{
                fieldGrid[mineXCoor][mineYCoor][0]=9; 
            }
        } 
	    //populates with the probability numbers
	    for(int i=0; i<numberOfRows; i++){
	        for(int k=0; k<numberOfColumns; k++){
	            if(fieldGrid[i][k][0]==9){
	                if(i>0){
	                    if(fieldGrid[i-1][k][0]!=9){
	                        fieldGrid[i-1][k][0] = fieldGrid[i-1][k][0] + 1;
	                    }
	                }
	                if(k<numberOfColumns-1){
	                    if(fieldGrid[i][k+1][0]!=9){
	                        fieldGrid[i][k+1][0] = fieldGrid[i][k+1][0] + 1;
	                    }
	                }
	                if(i<numberOfRows-1 && k<numberOfColumns-1){
	                    if(fieldGrid[i+1][k+1][0]!=9){
	                        fieldGrid[i+1][k+1][0] = fieldGrid[i+1][k+1][0] + 1;
	                    }
	                }
	                if(i<numberOfRows-1){
	                    if(fieldGrid[i+1][k][0]!=9){
	                        fieldGrid[i+1][k][0] = fieldGrid[i+1][k][0] + 1;
	                    }
	                }
                    if(i>0 && k>0){
                        if(fieldGrid[i-1][k-1][0]!=9){
                            fieldGrid[i-1][k-1][0] = fieldGrid[i-1][k-1][0] + 1;
                        }
                    }
                    if(k>0){
                        if(fieldGrid[i][k-1][0]!=9){
                            fieldGrid[i][k-1][0] = fieldGrid[i][k-1][0] + 1;
                        }
                    }
                    if(i>0 && k<numberOfColumns-1){
                        if(fieldGrid[i-1][k+1][0]!=9){
                            fieldGrid[i-1][k+1][0] = fieldGrid[i-1][k+1][0] + 1;
                        }
                    }
                    if(k>0 && i<numberOfRows-1){
                        if(fieldGrid[i+1][k-1][0]!=9){
                            fieldGrid[i+1][k-1][0] = fieldGrid[i+1][k-1][0] + 1;
                        }
                    }
	            }
	        }    	    
	    }
	}
	
	// TESTING FUCTIONS
	public void drawField(){
	    for(int i=0; i<numberOfColumns; i++){
	        for(int k=0; k<numberOfRows; k++){
	            System.out.print(""+fieldGrid[i][k][0]+" ");
	        }
	        System.out.println();
	    }
	    System.out.println();
	    
	}  
}    