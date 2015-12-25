import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class BrowserFrame extends JFrame{

    private JTextField addressBar;
    private JTextArea display;
    private String title = "Dilzilla FireDog";
    
    //constructor
    public BrowserFrame(BrowserEngine engine){
        super();
        setTitle(title);
    
        addressBar = new JTextField("cs.okstate.edu");
        addressBar.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    String text = event.getActionCommand();
                    display.setText("");
                    engine.loadPage(text);
                    addressBar.setText(text);
                }
            }
        );
        
        add(addressBar, BorderLayout.NORTH);
        display = new JTextArea();
        display.setEditable(false);
        add(new JScrollPane(display), BorderLayout.CENTER);
        setSize(600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
      
    public void bodyWrite(String text){
        display.append(text+ "\n");
    }  
}