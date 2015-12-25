import javax.swing.*;
import java.awt.*;

public class SPanel extends JPanel{

    public int getSideLength(){
        int sideLength = 0;
        if(getHeight()>getWidth()){
            sideLength = getWidth();
        }
        else{
            sideLength = getHeight();
        }
        System.out.println("Square Area: "+sideLength); //test
        return sideLength;
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        triangle(0, getSideLength(), getSideLength(), getSideLength(), g);
        }
        
    public void triangle(int x, int y, int width, int height, Graphics g){
        if(width <= 1 && height <= 1 ){
            g.drawRect(x, y, 1, 1);
        }
        else{
            triangle(x+(width/4), y-(height/2), width/2, height/2, g); //a
            triangle(x, y, width/2, height/2, g); //b
            triangle(x+(width/2), y, width/2, height/2, g); //c
        }
    }
}