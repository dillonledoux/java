import java.awt.*;
import javax.swing.*;

public class RoboFrame extends JFrame{    
    public RoboFrame(RoboLogic logic){
        setTitle("Robot Controller");
        setSize(300, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        RoboPanel panel = new RoboPanel(logic);
        add(panel);
        setVisible(true);       
    }
}