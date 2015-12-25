import java.io.*;
import java.net.*;
import java.text.DecimalFormat;
import java.awt.*;
import javax.swing.*;

public class RoboLogic{

	private static final int port = 9095;
    private static final String address = "lear.cs.okstate.edu";
    private double zAng = 0;
    private String zAngString = "0";
    private double x = 0;
    private String xString = "0";
    private double y = 0;
    private String yString = "0";
    private double zLin = 0;
    private String zLinString = "0";
    private static DecimalFormat decFormat = new DecimalFormat("0.00");
    private Socket socket; 
    private PrintWriter dataOut;
    private double speedLimit = 0.25;
    private double aSpeedLimit = 1.0;
    private double rateSpeedChange = 0.05;
    private double aRateSpeedChange = 0.20;
       
	public RoboLogic(){
        
        try{
            socket = new Socket(address, port);
            dataOut = new PrintWriter(socket.getOutputStream());
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Cannot Connect to Robot Server", "An Error Has Occurred", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
	}
	
	public void incZAng(){
	    if(zAng < aSpeedLimit){
	        zAng = zAng + aRateSpeedChange;
	    }
	    zAngString = "" + decFormat.format(zAng);
	    dataOut.print("{\"op\":\"publish\",\"topic\":\"/cmd_vel\",\"msg\":{\"linear\":{\"x\":" +xString+ ",\"y\":" +yString+ ",\"z\":" +zLinString+ "},\"angular\":{\"x\":0,\"y\":0,\"z\":" +zAngString+"}}}");
	    System.out.println("{\"op\":\"publish\",\"topic\":\"/cmd_vel\",\"msg\":{\"linear\":{\"x\":" +xString+ ",\"y\":" +yString+ ",\"z\":" +zLinString+ "},\"angular\":{\"x\":0,\"y\":0,\"z\":" +zAngString+"}}}");
	    dataOut.flush();
	}
	public void decZAng(){
	    if(zAng > (-1*aSpeedLimit)){
	        zAng = zAng - aRateSpeedChange;
	    }
	    zAngString = "" + decFormat.format(zAng);
	    dataOut.print("{\"op\":\"publish\",\"topic\":\"/cmd_vel\",\"msg\":{\"linear\":{\"x\":" +xString+ ",\"y\":" +yString+ ",\"z\":" +zLinString+ "},\"angular\":{\"x\":0,\"y\":0,\"z\":" +zAngString+"}}}");
        System.out.println("{\"op\":\"publish\",\"topic\":\"/cmd_vel\",\"msg\":{\"linear\":{\"x\":" +xString+ ",\"y\":" +yString+ ",\"z\":" +zLinString+ "},\"angular\":{\"x\":0,\"y\":0,\"z\":" +zAngString+"}}}");
        dataOut.flush();
	}
	public void incX(){
	    if(x < speedLimit){
	        x = x + rateSpeedChange;
	    }
	    xString = "" + decFormat.format(x);
	    dataOut.print("{\"op\":\"publish\",\"topic\":\"/cmd_vel\",\"msg\":{\"linear\":{\"x\":" +xString+ ",\"y\":" +yString+ ",\"z\":" +zLinString+ "},\"angular\":{\"x\":0,\"y\":0,\"z\":" +zAngString+"}}}");
	    System.out.println("{\"op\":\"publish\",\"topic\":\"/cmd_vel\",\"msg\":{\"linear\":{\"x\":" +xString+ ",\"y\":" +yString+ ",\"z\":" +zLinString+ "},\"angular\":{\"x\":0,\"y\":0,\"z\":" +zAngString+"}}}");
	    dataOut.flush();
	}
	public void decX(){
	   if(x > (-1*speedLimit)){
	        x = x - rateSpeedChange;
	    }
	    xString = "" + decFormat.format(x);
	    dataOut.print("{\"op\":\"publish\",\"topic\":\"/cmd_vel\",\"msg\":{\"linear\":{\"x\":" +xString+ ",\"y\":" +yString+ ",\"z\":" +zLinString+ "},\"angular\":{\"x\":0,\"y\":0,\"z\":" +zAngString+"}}}");
	    System.out.println("{\"op\":\"publish\",\"topic\":\"/cmd_vel\",\"msg\":{\"linear\":{\"x\":" +xString+ ",\"y\":" +yString+ ",\"z\":" +zLinString+ "},\"angular\":{\"x\":0,\"y\":0,\"z\":" +zAngString+"}}}");
	    dataOut.flush();
	}
	public void incY(){
	    if(y < speedLimit){
	        y = y + rateSpeedChange;
	    }
	    yString = "" + decFormat.format(y);
	    dataOut.print("{\"op\":\"publish\",\"topic\":\"/cmd_vel\",\"msg\":{\"linear\":{\"x\":" +xString+ ",\"y\":" +yString+ ",\"z\":" +zLinString+ "},\"angular\":{\"x\":0,\"y\":0,\"z\":" +zAngString+"}}}");
	    System.out.println("{\"op\":\"publish\",\"topic\":\"/cmd_vel\",\"msg\":{\"linear\":{\"x\":" +xString+ ",\"y\":" +yString+ ",\"z\":" +zLinString+ "},\"angular\":{\"x\":0,\"y\":0,\"z\":" +zAngString+"}}}");
	    dataOut.flush();
	}
	public void decY(){
	    if(y > (-1*speedLimit)){
	        y = y - rateSpeedChange;
	    }
	    yString = "" + decFormat.format(y);
	    dataOut.print("{\"op\":\"publish\",\"topic\":\"/cmd_vel\",\"msg\":{\"linear\":{\"x\":" +xString+ ",\"y\":" +yString+ ",\"z\":" +zLinString+ "},\"angular\":{\"x\":0,\"y\":0,\"z\":" +zAngString+"}}}");
	    System.out.println("{\"op\":\"publish\",\"topic\":\"/cmd_vel\",\"msg\":{\"linear\":{\"x\":" +xString+ ",\"y\":" +yString+ ",\"z\":" +zLinString+ "},\"angular\":{\"x\":0,\"y\":0,\"z\":" +zAngString+"}}}");
	    dataOut.flush();
	}
	public void incZLin(){
	    if(zLin < speedLimit){
	        zLin = zLin + rateSpeedChange;
	    }
	    zLinString = "" + decFormat.format(zLin);
	    dataOut.print("{\"op\":\"publish\",\"topic\":\"/cmd_vel\",\"msg\":{\"linear\":{\"x\":" +xString+ ",\"y\":" +yString+ ",\"z\":" +zLinString+ "},\"angular\":{\"x\":0,\"y\":0,\"z\":" +zAngString+"}}}");
	    System.out.println("{\"op\":\"publish\",\"topic\":\"/cmd_vel\",\"msg\":{\"linear\":{\"x\":" +xString+ ",\"y\":" +yString+ ",\"z\":" +zLinString+ "},\"angular\":{\"x\":0,\"y\":0,\"z\":" +zAngString+"}}}");
	    dataOut.flush();
	}
	public void decZLin(){
	    if(zLin > (-1*speedLimit)){
	        zLin = zLin - rateSpeedChange;
	    }
	    zLinString = "" + decFormat.format(zLin);
	    dataOut.print("{\"op\":\"publish\",\"topic\":\"/cmd_vel\",\"msg\":{\"linear\":{\"x\":" +xString+ ",\"y\":" +yString+ ",\"z\":" +zLinString+ "},\"angular\":{\"x\":0,\"y\":0,\"z\":" +zAngString+"}}}");
	    System.out.println("{\"op\":\"publish\",\"topic\":\"/cmd_vel\",\"msg\":{\"linear\":{\"x\":" +xString+ ",\"y\":" +yString+ ",\"z\":" +zLinString+ "},\"angular\":{\"x\":0,\"y\":0,\"z\":" +zAngString+"}}}");
	    dataOut.flush();
	}
    public void takeOff(){
        dataOut.print("{\"op\":\"publish\",\"topic\":\"/ardrone/takeoff\",\"msg\":{}}");
        System.out.println("{\"op\":\"publish\",\"topic\":\"/ardrone/takeoff\",\"msg\":{}}");
        dataOut.flush();
    }
    public void land(){
        dataOut.print("{\"op\":\"publish\",\"topic\":\"/ardrone/land\",\"msg\":{}}");
        dataOut.flush();
    }
    public void reset(){
 	    xString = "0";
 	    yString = "0";
 	    zLinString = "0";
 	    zAngString = "0";
 	    dataOut.print("{\"op\":\"publish\",\"topic\":\"/cmd_vel\",\"msg\":{\"linear\":{\"x\":" +xString+ ",\"y\":" +yString+ ",\"z\":" +zLinString+ "},\"angular\":{\"x\":0,\"y\":0,\"z\":" +zAngString+"}}}");       
        dataOut.flush();
    }
}