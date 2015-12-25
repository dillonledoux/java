import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class RoboPanel extends JPanel implements ActionListener{
    
    private JButton zALeft;
    private JButton zARight;
    private JButton xForward;
    private JButton xBackward;
    private JButton yLeft;
    private JButton yRight;
    private JButton zLUp;
    private JButton zLDown;
    private JButton takeOff;
    private JButton land;
    private JButton reset;
    private RoboLogic logic;
    
    
    private int buttonSizeX = 100;
    private int buttonSizeY = 80;
	
	public RoboPanel(RoboLogic rLogic){
	
	    logic = rLogic;
	
        this.setLayout(null);	    

        zLUp = new JButton("Up");
        zLUp.setBounds(100, 0, buttonSizeX, buttonSizeY);
        zLUp.addActionListener(this);
        this.add(zLUp);
        
        zLDown = new JButton("Down");
        zLDown.setBounds(100, 320, buttonSizeX, buttonSizeY);
        zLDown.addActionListener(this);
        this.add(zLDown);
        
        xForward = new JButton("Forward");
        xForward.setBounds(100, 100, buttonSizeX, buttonSizeY);
        xForward.addActionListener(this);
        this.add(xForward);
        
        xBackward = new JButton("Backward");
        xBackward.setBounds(100, 220, buttonSizeX, buttonSizeY);
        xBackward.addActionListener(this);
        this.add(xBackward);
        
        yLeft = new JButton("Left");
        yLeft.setBounds(0, 160, buttonSizeX, buttonSizeY);
        yLeft.addActionListener(this);
        this.add(yLeft);
        
        yRight = new JButton("Right");
        yRight.setBounds(200, 160, buttonSizeX, buttonSizeY);
        yRight.addActionListener(this);
        this.add(yRight);
        
        zALeft = new JButton("Rotate Left");
        zALeft.setBounds(0, 320, buttonSizeX, buttonSizeY);
        zALeft.addActionListener(this);
        this.add(zALeft);
        
        zARight = new JButton("Rotate Right");
        zARight.setBounds(200, 320, buttonSizeX, buttonSizeY);
        zARight.addActionListener(this);
        this.add(zARight);
        
        takeOff = new JButton("Take Off");
        takeOff.setBounds(200, 0, buttonSizeX, buttonSizeY);
        takeOff.addActionListener(this);
        this.add(takeOff);
        
        land = new JButton("Land");
        land.setBounds(200, 80, buttonSizeX, buttonSizeY);
        land.addActionListener(this);
        this.add(land);
        
        reset = new JButton("Reset");
        reset.setBounds(0, 0, buttonSizeX, buttonSizeY);
        reset.addActionListener(this);
        this.add(reset);
	}
    
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == zLUp){
            logic.incZLin();
        }
        else if(e.getSource() == zLDown){
            logic.decZLin();
        }
        else if(e.getSource() == xForward){
            logic.incX();
        }
        else if(e.getSource() == xBackward){
            logic.decX();
        }
        else if(e.getSource() == yLeft){
            logic.incY();
        }
        else if(e.getSource() == yRight){
            logic.decY();
        }
        else if(e.getSource() == zALeft){
            logic.incZAng();
        }
        else if(e.getSource() == zARight){
            logic.decZAng();
        }
        else if(e.getSource() == takeOff){
            logic.takeOff();
        }
        else if(e.getSource() == land){
            logic.land();
        }
        else if(e.getSource() == reset){
            logic.reset();
        }  
    }
}