import javax.swing.*;
import javax.swing.JButton;

public class GridSpace extends JButton {
    private int xCoor;
    private int yCoor;
       
    public GridSpace(String text, int x, int y){
        super.setText(text);
        xCoor = x;
        yCoor = y; 
    }

    // ACCESSORS

    public int getXCoor(){
        return xCoor;
    }
    public int getYCoor(){
        return yCoor;
    }
}