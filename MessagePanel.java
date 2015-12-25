import javax.swing.*;
import java.awt.*;

public class MessagePanel extends JPanel{
    
    
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawOval(150, 50, 100, 75);
       
        g.drawLine(150, 84, 150, 140);
        g.drawLine(250, 84, 250, 140);
       
        g.drawLine(75, 175, 100, 175);
        g.drawLine(300, 175, 325, 175);
        
        g.drawLine(150, 140, 100, 175);
        g.drawLine(250, 140, 300, 175);
        
        g.drawLine(75, 175, 75, 400);
        g.drawLine(325, 175, 325, 400);
       
        g.drawLine(75, 400, 325, 400);
        
        g.drawString("Goodbye world! I'm drowning in code..", 80, 320);
        Toolkit kit = Toolkit.getDefaultToolkit();
        setVisible(true);
        
    }


}