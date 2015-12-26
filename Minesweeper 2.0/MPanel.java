import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MPanel extends JPanel{
    protected int numberOfRows = 0;
    protected int numberOfColumns = 0;
    protected int numberOfMines = 0;
    protected GridSpace[][] gridSpaces = null;
    protected MineField field = null;
    protected MFrame mainFrame;
    private boolean gamePlayable = true;

    ImageIcon gameOver = new ImageIcon("images/boom.png", "game over boom graphic");
        
    public MPanel(MineField fieldFromModel, MFrame frame){
        
        field = fieldFromModel;
        numberOfRows = field.getNumberOfRows();
        numberOfColumns = field.getNumberOfColumns();
        numberOfMines = field.getNumberOfMines();
        mainFrame = frame;
        gridSpaces = new GridSpace[numberOfRows][numberOfColumns];
        
        this.setLayout(new GridLayout(numberOfRows, numberOfColumns, 2, 2));
    
        //Populates the layout with JLabels(GridSpace)
        for(int i = 0; i<numberOfRows; i++){
            for(int k = 0; k<numberOfColumns; k++){
                gridSpaces[i][k] = new GridSpace("?", i, k);
                this.add(gridSpaces[i][k]);
                //Integer.toString(field.getSpaceValue(i, k)), gridSpaces[i][k]);
                gridSpaces[i][k].addMouseListener(new MouseSensor(this));   
            }
        }
    } 
    
    // -----METHODS-----
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }      
   
   /*
    public void revealSurroundingZeros(int x, int y){
       
        if(field.getSpaceValue(x, y)==0){
        
            for(int i = 0; i<gridSpaces.length; i++){
                    for(int k = 0; k<gridSpaces.length; k++){
                        if((gridSpaces[i][k].getXCoor() == x) && (gridSpaces[i][k].getYCoor() == y)) {
                            gridSpaces[i][k].setText("0");  
                        } 
                    }
                }
            
            //x-1, y-1
            try{
                
                for(int i = 0; i<gridSpaces.length; i++){
                    for(int k = 0; k<gridSpaces.length; k++){
                        if((gridSpaces[i][k].getXCoor() == x-1) && (gridSpaces[i][k].getYCoor() == y-1)) {
                            gridSpaces[i][k].setText(Integer.toString(field.getSpaceValue(x-1, y-1)));  
                        } 
                    }
                }
                if(field.getSpaceValue(x-1, y-1)==0){
                    revealSurroundingZeros(x-1, y-1);
                }
            }
            catch(Exception outBounds){
                //System.out.println("NW Bound reached");
            }
            //x, y-1
            try{
                for(int i = 0; i<gridSpaces.length; i++){
                    for(int k = 0; k<gridSpaces.length; k++){
                        if((gridSpaces[i][k].getXCoor() == x) && (gridSpaces[i][k].getYCoor() == y-1)) {
                            gridSpaces[i][k].setText(Integer.toString(field.getSpaceValue(x, y-1)));  
                        } 
                    }
                }
                if(field.getSpaceValue(x, y-1)==0){
                    revealSurroundingZeros(x, y-1);
                }
            
            }
            catch(Exception outBounds){
               // System.out.println("N Bound reached");
            }
            //x+1, y-1
            try{
                for(int i = 0; i<gridSpaces.length; i++){
                    for(int k = 0; k<gridSpaces.length; k++){
                        if((gridSpaces[i][k].getXCoor() == x+1) && (gridSpaces[i][k].getYCoor() == y-1)) {
                            gridSpaces[i][k].setText(Integer.toString(field.getSpaceValue(x+1, y-1)));  
                        } 
                    }
                }
                if(field.getSpaceValue(x+1, y-1)==0){
                    revealSurroundingZeros(x+1, y-1);
                }
            
            }
            catch(Exception outBounds){
               // System.out.println("NE Bound reached");
            }
            // x-1, y
            try{
                for(int i = 0; i<gridSpaces.length; i++){
                    for(int k = 0; k<gridSpaces.length; k++){
                        if((gridSpaces[i][k].getXCoor() == x-1) && (gridSpaces[i][k].getYCoor() == y)) {
                            gridSpaces[i][k].setText(Integer.toString(field.getSpaceValue(x-1, y)));  
                        } 
                    }
                }
                if(field.getSpaceValue(x-1, y)==0){
                    revealSurroundingZeros(x-1, y);
                }
            
            }
            catch(Exception outBounds){
               // System.out.println("W Bound reached");
            }
            // x+1, y
            try{
                for(int i = 0; i<gridSpaces.length; i++){
                    for(int k = 0; k<gridSpaces.length; k++){
                        if((gridSpaces[i][k].getXCoor() == x+1) && (gridSpaces[i][k].getYCoor() == y)) {
                            gridSpaces[i][k].setText(Integer.toString(field.getSpaceValue(x+1, y)));  
                        } 
                    }
                }
                if(field.getSpaceValue(x+1, y)==0){
                    revealSurroundingZeros(x+1, y);
                }
            
            }
            catch(Exception outBounds){
               // System.out.println("E Bound reached");
            }
            // x-1, y+1
            try{
                for(int i = 0; i<gridSpaces.length; i++){
                    for(int k = 0; k<gridSpaces.length; k++){
                        if((gridSpaces[i][k].getXCoor() == x-1) && (gridSpaces[i][k].getYCoor() == y+1)) {
                            gridSpaces[i][k].setText(Integer.toString(field.getSpaceValue(x-1, y+1)));  
                        } 
                    }
                }
                if(field.getSpaceValue(x-1, y+1)==0){
                    revealSurroundingZeros(x-1, y+1);
                }
            
            }
            catch(Exception outBounds){
               // System.out.println("SW Bound reached");
            }
            //x, y+1
            try{
                for(int i = 0; i<gridSpaces.length; i++){
                    for(int k = 0; k<gridSpaces.length; k++){
                        if((gridSpaces[i][k].getXCoor() == x) && (gridSpaces[i][k].getYCoor() == y+1)) {
                            gridSpaces[i][k].setText(Integer.toString(field.getSpaceValue(x, y+1)));  
                        } 
                    }
                }
                if(field.getSpaceValue(x, y+1)==0){
                    revealSurroundingZeros(x, y+1);
                }
            
            }
            catch(Exception outBounds){
               // System.out.println("S Bound reached");
            }
            
            //x+1, y+1
            try{
                for(int i = 0; i<gridSpaces.length; i++){
                    for(int k = 0; k<gridSpaces.length; k++){
                        if((gridSpaces[i][k].getXCoor() == x+1) && (gridSpaces[i][k].getYCoor() == y+1)) {
                            gridSpaces[i][k].setText(Integer.toString(field.getSpaceValue(x+1, y+1)));  
                        } 
                    }
                }
                if(field.getSpaceValue(x+1, y+1)==0){
                    revealSurroundingZeros(x+1, y+1);
                }
            
            }
            catch(Exception outBounds){
              //  System.out.println("SE Bound reached");
            }
        
        }
        
        
        
    
    
    
    
    }
   
   */
    // ACCESSORS
    
    public GridSpace[][] getGridSpaces() {
        return gridSpaces;
    }
    public MineField getField(){
        return field;
    }
    public MFrame getFrame(){
        return mainFrame;
    }
    public boolean isPlayable(){
        return gamePlayable;
    }
    public ImageIcon getGameOverIcon(){
        return gameOver;
    }
    
        
    // MUTATORS
    
    public void setFlag(int x, int y){
        if(field.isFlagged(x, y)){
            for(int i = 0; i<gridSpaces.length; i++){
                for(int k = 0; k<gridSpaces.length; k++){  
                    if((gridSpaces[i][k].getXCoor() == x) && (gridSpaces[i][k].getYCoor() == y)){
                        gridSpaces[i][k].setText("?");
                    }
                }
            }        
        }
        else{
            for(int i = 0; i<gridSpaces.length; i++){
                for(int k = 0; k<gridSpaces.length; k++){  
                    if((gridSpaces[i][k].getXCoor() == x) && (gridSpaces[i][k].getYCoor() == y)){
                        gridSpaces[i][k].setText("F");
                    }
                }
            }        
        }
    } 
    public void setNotPlayable(){
       gamePlayable = false; 
    }     
    public void resetVisuals(){
        for(int i = 0; i<gridSpaces.length; i++){
            for(int k = 0; k<gridSpaces.length; k++){
                gridSpaces[i][k].setText(Integer.toString(field.getSpaceValue(i, k)));
                if(field.getViewedValue(i, k)==0){
                    gridSpaces[i][k].setText("?");
                }
                if(field.getFlagValue(i, k)==1){
                    gridSpaces[i][k].setText("F");
                }
                gridSpaces[i][k].setEnabled(true);
            }
        }              
    }
    public void lockSpaces(){
        for(int i = 0; i<gridSpaces.length; i++){
            for(int k = 0; k<gridSpaces.length; k++){
                gridSpaces[i][k].setEnabled(false);   
            }
        }
    }

}

class MouseSensor extends MouseAdapter {
   private MPanel panel;
   
   public MouseSensor(MPanel p) {
        panel = p;
    }

    public void mouseClicked(MouseEvent e){
        if(panel.isPlayable()){
            
            GridSpace spaceClicked = (GridSpace)e.getSource();
            int x = spaceClicked.getXCoor();
            int y = spaceClicked.getYCoor();
        
            if(e.getButton() == 1){          
                for(int i = 0; i<panel.getGridSpaces().length; i++){
                    for(int k = 0; k<panel.getGridSpaces().length; k++){
                        if((panel.getGridSpaces()[i][k].getXCoor() == x) && (panel.getGridSpaces()[i][k].getYCoor() == y)) {
                            if(panel.getField().isMinedSpace(x, y)){
                                panel.getGridSpaces()[i][k].setText("BOMB");
                                panel.getGridSpaces()[i][k].setBackground(Color.red);
                                panel.getGridSpaces()[i][k].setOpaque(true);
                                panel.getGridSpaces()[i][k].setBorderPainted(false);
                            }
                             else{
                                panel.getGridSpaces()[i][k].setText(Integer.toString(panel.getField().getSpaceValue(x, y)));
                               // panel.revealSurroundingZeros(x, y);
                            }
                        } 
                    }
                }
                panel.getField().setToViewed(x, y);
                if(panel.getField().isMinedSpace(x, y)){
                    for(int i = 0; i<panel.getGridSpaces().length; i++){
                        for(int k = 0; k<panel.getGridSpaces().length; k++){
                            if(panel.getField().isMinedSpace(i, k)){
                                panel.getGridSpaces()[i][k].setText("BOMB");
                                panel.getGridSpaces()[i][k].setBackground(Color.red);
                                panel.getGridSpaces()[i][k].setOpaque(true);
                                panel.getGridSpaces()[i][k].setBorderPainted(true);
                                }
                            else{
                               panel.getGridSpaces()[i][k].setText(Integer.toString(panel.getField().getSpaceValue(i, k))); 
                            }
                        }
                    }
                    int response = JOptionPane.showConfirmDialog(null, "You hit a bomb. Would you like to play again?", "Game Over", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, panel.getGameOverIcon());
                    
                    if(response == JOptionPane.NO_OPTION){
                        System.out.println("User has chosen to exit");
                        System.exit(0);
                    }
                    else if(response == JOptionPane.YES_OPTION){
                        panel.getField().resetField(MFrame.getMineNumber());
                        panel.resetVisuals();
                        panel.getField().drawField();
                    }
                    else if(response == JOptionPane.CLOSED_OPTION){
                        panel.lockSpaces();
                        panel.setNotPlayable(); 
                    }
                } 
            } 
            else if(e.getButton() == 3) {
                if(!panel.field.isViewed(x, y)){
                    for(int i = 0; i<panel.getGridSpaces().length; i++){
                        for(int k = 0; k<panel.getGridSpaces().length; k++){
                            panel.setFlag(x, y);
                        }
                    }
                    panel.getField().setFlagValue(x, y);
                }
            }
        }
        boolean allMinesFlagged = true;
        boolean allSpacesVisible = true;      
    }
}

