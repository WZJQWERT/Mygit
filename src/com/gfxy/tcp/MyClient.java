package com.gfxy.tcp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class MyClient {
	public static void main(String[] args) {
		try {
			
			System.out.println("¿Í»§¶Ë");
			Socket socket = new Socket("localhost", 8888);
			System.out.println(socket.getPort());
			System.out.println(socket.getLocalPort());
			
			new Thread(new Send(socket)).start();
			new Thread(new Receive(socket)).start();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
