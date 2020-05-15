package com.gfxy.tcp0;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) {
		try {
			Socket socket= new Socket(InetAddress.getLocalHost(),9999);
			DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
			DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			while(true) {
				String msgString = reader.readLine();
				dataOutputStream.writeUTF(msgString);
				dataOutputStream.flush();
				String string =dataInputStream.readUTF();
				System.out.println(string);
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
