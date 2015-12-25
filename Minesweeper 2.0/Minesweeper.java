public class Minesweeper{ 
    
    private static MFrame mainFrame;
    
    public static void main(String[] args){
        MineField fieldModel = new MineField(10, 10, 5);
        MFrame frame = new MFrame(fieldModel);
        mainFrame = frame;
        // tester
        fieldModel.drawField();     
    }
    
    public static MFrame getFrame(){
        return mainFrame;
    }
}