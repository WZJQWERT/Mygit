package com.gfxy.tcp0;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(9999);
			Socket socket =serverSocket.accept();// ����ʽ����
			DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
			DataOutputStream dataoutoutStream = new DataOutputStream(socket.getOutputStream());
			while(true) {
				String msg= dataInputStream.readUTF();// ����ʽ����
				System.out.println("�ͻ��˷�����Ϣ��" + msg);
				
				String str = "�������ѽ��յ���������Ϣ��" + msg;
				dataoutoutStream.writeUTF(str);
				dataoutoutStream.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
