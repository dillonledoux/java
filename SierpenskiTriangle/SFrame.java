import javax.swing.*;
import java.awt.*;

public class SFrame extends JFrame{

    public SFrame(){
        setTitle("Sierpinski's Triangle");
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        setSize(screenSize.width/2, screenSize.height/2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new SPanel());
        setVisible(true);         
    }

}