import javax.swing.*;
import java.awt.*;

public class MFrame2 extends JFrame{
    public MFrame2(MineField2 field){
        setTitle("Minesweeper");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MPanel2 panel = new MPanel2(field, this);
        add(panel);
        setVisible(true);  
    }
}