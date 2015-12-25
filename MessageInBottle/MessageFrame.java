import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;


public class MessageFrame extends JFrame{

    public MessageFrame(){
        setTitle("Message in a Bottle");
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new MessagePanel());
        setVisible(true);
        
    }

}