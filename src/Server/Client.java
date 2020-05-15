package Server;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args) throws Exception {
       DatagramSocket client = new DatagramSocket(8888);
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       
       while(true) {
    	   String string = reader.readLine();
    	   DatagramPacket sendPacket = new DatagramPacket(string.getBytes(), 
    			   string.getBytes().length,
    			   InetAddress.getLocalHost(),9999);
    	   client.send(sendPacket);
    	   byte[] data = new byte[1024];
    	   DatagramPacket receivePacket = new DatagramPacket(data, 
    			   data.length);
    	   client.receive(receivePacket);
    	   
    	   System.out.println(new String(receivePacket.getData()));
    	   
       }
       
        
    }
}
