import javax.swing.*;
import javax.swing.JComponent;
import java.awt.*;
import java.io.*;
import java.awt.event.*;

public class MFrame extends JFrame{

        static boolean easy = true;

        static boolean medium = false;

        static boolean hard = false;


    public MFrame(MineField field){
        setTitle("Minesweeper - " +getGameDiff());
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        MPanel panel = new MPanel(field, this);
        
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenu newGameDiff = new JMenu("New Game");
        menuBar.add(menu);
        
        
        JMenuItem loadGame = new JMenuItem("Load Game");
        JMenuItem saveGame = new JMenuItem("Save Game");
        JMenuItem quitGame = new JMenuItem("Quit");
        
        JMenuItem diffEasy = new JMenuItem("Easy");
        JMenuItem diffMedium = new JMenuItem("Medium");
        JMenuItem diffHard = new JMenuItem("Hard");
        
        newGameDiff.add(diffEasy);
        newGameDiff.add(diffMedium);
        newGameDiff.add(diffHard);
        
        
        diffEasy.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e){
                 MFrame.isEasy();
                 panel.getField().resetField(5);
                 panel.resetVisuals();
                 setTitle("Minesweeper - " +getGameDiff());
                 panel.getField().drawField();  
            }
        });
        
        diffMedium.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e){
                 MFrame.isMedium();
                 panel.getField().resetField(10);
                 panel.resetVisuals();
                 setTitle("Minesweeper - " +getGameDiff());
                 panel.getField().drawField();  
            }
        });
        
        diffHard.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e){
                 MFrame.isHard();
                 panel.getField().resetField(20);
                 panel.resetVisuals();
                 setTitle("Minesweeper - " +getGameDiff());
                 panel.getField().drawField();  
            }
        });
        
        
        loadGame.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e){
                System.out.println("Load");
                
                try{
                        JFileChooser fileChooser = new JFileChooser();
                        int returnedValue = fileChooser.showOpenDialog(null);
                        if(returnedValue == JFileChooser.APPROVE_OPTION){
                            FileInputStream fileIn = new FileInputStream(fileChooser.getSelectedFile() );
                            ObjectInputStream modelToLoad = new ObjectInputStream(fileIn);
                            MineField newField = (MineField)modelToLoad.readObject();
                            modelToLoad.close();
                            
                            panel.getField().setField(newField);
                            panel.resetVisuals();
                            panel.getField().drawField();
                        }
                    }
                    catch(Exception exc){
                        exc.printStackTrace();
                        System.out.println("File problems encountered");
                    }
            }    
        });
        saveGame.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                        JFileChooser fileChooser = new JFileChooser();
                        int returnedValue = fileChooser.showSaveDialog(null);
                        if(returnedValue == JFileChooser.APPROVE_OPTION){
                            FileOutputStream fileOut = new FileOutputStream(fileChooser.getSelectedFile() );
                            ObjectOutputStream modelToSave = new ObjectOutputStream(fileOut);
                            modelToSave.writeObject(panel.getField());
                            modelToSave.close();
                        }
                    }
                    catch(Exception exc){
                        exc.printStackTrace();
                        System.out.println("File problems encountered");
                    }
            }
        
        });
        quitGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.out.println("Quitting...");
                System.exit(0);
            }
        });
        
        menu.add(newGameDiff);
        menu.add(loadGame);
        menu.add(saveGame);
        menu.add(quitGame);
        
        this.setJMenuBar(menuBar);
       
        add(panel);
        setVisible(true);  
    }
    
    public static void isEasy(){
        easy = true;
        medium = false;
        hard = false;
    }
    public static void isMedium(){
        easy = false;
        medium = true;
        hard = false;
    }
    public static void isHard(){
        easy = false;
        medium = false;
        hard = false;
    }
    public String getGameDiff(){
        if(easy){
            return "Easy";
        }
        else if(medium){
            return "Medium";
        }
        else{
            return "Hard";
        }
    }
    public static int getMineNumber(){
        if(easy){
            return 5;
        }
        else if(medium){ 
            return 10;
        }
        else{
            return 20;
        }
    }
    public void setFrameTitle(){
        setTitle("Minesweeper - " +getGameDiff());
    }
        
} /*
class MenuActionListener implements ActionListener{
    public MenuActionListener(MPanel panel){
        panel = panel;
    }
}
*/