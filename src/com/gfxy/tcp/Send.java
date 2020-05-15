package com.gfxy.tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * �����߳�
 * @author Administrator
 *
 */
public class Send implements Runnable {
	
	private Socket socket;
	//��ȡ����̨��Ϣ
	private BufferedReader console;
	//���������������
	private DataOutputStream outputStream;
	
	//�߳��Ƿ�����������
	boolean isRunning = true;
	public Send() {
		console = new BufferedReader(new InputStreamReader(System.in));		
	}
	
	public Send(Socket socket) {
		this();
		try {
			outputStream = new DataOutputStream(socket.getOutputStream());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			isRunning = false; // �����쳣 ֹͣ�߳�
			try {
				console.close();
				outputStream.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			e.printStackTrace();
		}
	}
	
	
	public String getMsgFromConsole() {
		try {
			return console.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void sendMsg() {
		String msg = getMsgFromConsole();
		if(null != msg && !msg.equals("")) {
			try {
				outputStream.writeUTF(msg);
				outputStream.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				isRunning = false;
			}
		}
		
	}
	 @Override
	public void run() {
		// TODO Auto-generated method stub
		while(isRunning) {
			sendMsg();
		}
	}
}
