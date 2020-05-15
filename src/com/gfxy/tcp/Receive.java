package com.gfxy.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receive implements Runnable {
	private DataInputStream dis;
	
	private boolean isRunning = true;
	
	public Receive(Socket socket) {
		try {
			dis = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			isRunning = false;
			e.printStackTrace();
		}
	}
	public String receiveMsg() {
		String msgString = null;
		try {
			msgString = dis.readUTF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			isRunning = false;
		}
		return msgString;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(isRunning) {
			System.out.println(receiveMsg());
		}
	}
}
