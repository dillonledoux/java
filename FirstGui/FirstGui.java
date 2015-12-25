// Dillon LeDoux
// CS 1113-004
// Program 8 - First Gui

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FirstGui extends JFrame
	implements ActionListener
{
	private JButton button1; //Name
	private JButton button2; //Oval
	private JButton button3; //Rectangle
	private JButton button4; //poof
	private PaintPanel myPaintPanel;
	private boolean displayText = false;
	private boolean displayOval = false;
	private boolean displayRect = false;
	private boolean displaySurp = false;


	public FirstGui(String title)
	{
		super(title);

		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 4));
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
		
		button1 = new JButton("Name");
		button1.addActionListener(this);
		buttonPanel.add(button1);

		button2 = new JButton("Oval");
		button2.addActionListener(this);
		buttonPanel.add(button2);

		button3 = new JButton("Rectangle");
		button3.addActionListener(this);
		buttonPanel.add(button3);

		button4 = new JButton("Get Ready..");
		button4.addActionListener(this);
		buttonPanel.add(button4);
		
		myPaintPanel = new PaintPanel();
		contentPane.add(myPaintPanel, BorderLayout.CENTER);

		//	 N
		//W	 C	E
		//	 S
	}

	public void actionPerformed(ActionEvent e)
	{
		//myPaintPanel.setText(false);
		//myPaintPanel.setOval(false);
		//myPaintPanel.setRect(false);
		
		
		if (e.getSource() == button1)
		{
		    
    		displayText = myPaintPanel.getText();
    		myPaintPanel.setText(!displayText);
			
                System.out.println("Name");
                myPaintPanel.setColorText(Color.BLACK);
                displayText = !displayText;
                repaint();
		}
		else if (e.getSource() == button2)
		{
			displayOval = myPaintPanel.getOval();
			myPaintPanel.setOval(!displayOval);

                System.out.println("Oval");
                myPaintPanel.setHeight(75);
                myPaintPanel.setWidth(100);
                myPaintPanel.setColorOval(Color.ORANGE);
                repaint();
            
		}
		else if (e.getSource() == button3)
		{
			displayRect = myPaintPanel.getRect();
			myPaintPanel.setRect(!displayRect);
			
                System.out.println("Rectangle");
                myPaintPanel.setHeight(75);
                myPaintPanel.setWidth(100);
                myPaintPanel.setColorRect(Color.BLUE);
                repaint();
			
		}
		else if (e.getSource() == button4)
		{
		    displaySurp = myPaintPanel.getSurp();
		    myPaintPanel.setSurp(!displaySurp);
		    
		    System.out.println("Poof");
		    myPaintPanel.setColorSurp(Color.getHSBColor((float)Math.random(), 1.0F, 1.0F));
		    displaySurp = !displaySurp;
		    repaint();
		}

	}

	public static void main(String[] args)
	{
		FirstGui myGui = new FirstGui("Dillon LeDoux");
		myGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myGui.setSize(500,500);

		myGui.setVisible(true);
	}
}
