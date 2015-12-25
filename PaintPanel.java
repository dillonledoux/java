import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class PaintPanel extends JPanel
{

    private int height;
	private int width;
	
	private Color colorOval;
	private Color colorRect;
	private Color colorText;
	private Color colorSurp;
	
	private boolean rectangle = false;
	private boolean oval = false;
	private boolean text = false;
	private boolean surp = false;
	
	public void setRect(boolean rectangle) {this.rectangle = rectangle;}
	public void setOval(boolean oval) {this.oval = oval;}
	public void setText(boolean text) {this.text = text;}
	public void setSurp(boolean surp) {this.surp = surp;}
	
	public boolean getRect() {return rectangle;}
	public boolean getOval() {return oval;}
	public boolean getText() {return text;}
	public boolean getSurp() {return surp;}
		

	public void setHeight(int h) {height = h;}
	public void setWidth(int w) {width = w;}
	
	public void setColorOval(Color a) {colorOval = a;}
    public void setColorRect(Color b) {colorRect = b;}
    public void setColorText(Color c) {colorText = c;}
    public void setColorSurp(Color d) {colorSurp = d;}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

        int w = getWidth();
        int h = getHeight();
            
		if(text)
		{
            int x = w/30 ;
            int y = w/20 ;

            g.setColor(colorText);
            g.drawString("Dillon LeDoux", x, y);
		}
		
		if(oval)
		{
            int x = w/2 - width/2;
            int y = (int) Math.round(h/2) - height/2;

            g.setColor(colorOval);
            g.fillOval(x, y, width, height);
		}
		
		if(rectangle)
		{    
            int x = w/2 - width/2;
            int y = (int) Math.round(h/6) - height/2;

            g.setColor(colorRect);
            g.fillRect(x, y, width, height);
		}
	    
	    if(surp)
	    {
	        int x = w-50;
	        int y = h-20;
	        
	        g.setColor(colorSurp);
	        g.drawString("¡Poof!", x, y);
	    }
	}
	

}
