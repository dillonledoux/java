public class Minesweeper{ 
    public static void main(String[] args){
        MineField2 fieldModel = new MineField2(10, 10, 10);
        MFrame2 frame = new MFrame2(fieldModel);
        
        // tester
        fieldModel.drawField();     
    }
}