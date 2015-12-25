import java.io.*;
import java.net.*;
import java.awt.*;
import javax.swing.*;

public class BrowserEngine{

    private String line;
    private boolean titleFound = false;
    private boolean bodyFound = false;
    private int counter;
    private BrowserFrame currentFrame;
   
	public BrowserEngine(){
	    BrowserFrame frame = new BrowserFrame(this);
	    currentFrame = frame;
	}
		
	public void loadPage(String userTxt){
        
        try{
            Socket socket = new Socket(userTxt, 80);
            PrintWriter dataOut = new PrintWriter(socket.getOutputStream());
            BufferedReader dataIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            dataOut.print("GET / HTTP/1.1\r\n");
            dataOut.print("host: "+userTxt+ "\r\n\r\n");
            dataOut.flush();
            while((line = dataIn.readLine()) != null){
                int closingTagLocation;
                int openingTagLocation;
                for(counter=0; counter<line.length(); counter++){
                    //title
                    if(line.contains("<title")){
                        closingTagLocation = line.lastIndexOf("<");
                        openingTagLocation = line.indexOf(">") + 1;
                        line = line.substring(openingTagLocation, closingTagLocation);
                        currentFrame.setTitle(line);
                    }
                    if(line.contains("<body>")){
                        bodyFound = true;
                    }
                }
                if(bodyFound=true){
                    if(line.contains("</body>")){
                        currentFrame.bodyWrite(line.substring(0, line.lastIndexOf("<")));
                        break;
                    }
                    currentFrame.bodyWrite(line);                    
                }   
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Please Provide a Valid URL", "An Error Has Occurred", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); 
        }
    }
}