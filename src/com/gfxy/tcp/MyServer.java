package com.gfxy.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.events.StartDocument;

public class MyServer{
	
	//保持与所有客户端建立的通道
	private List<MyChannel> allChannel = new ArrayList<MyChannel>();
	
	public static void main(String[] args) {
		try {
			new MyServer().start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void start() throws IOException {
		System.out.println("服务器");
		ServerSocket serverSocket =  new ServerSocket(8888);
		
		while(true) {
			try {
				Socket socket = serverSocket.accept();
				MyChannel channel = new MyChannel(socket);
				allChannel.add(channel); //与客户端建立的通道加入容器统一管理
				new Thread(channel).start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}
	
	
	/**
	 * һ���Ϳͻ��˵�ͨ·
	 * @author Administrator
	 *
	 */
	class MyChannel implements Runnable {
		// ������
		private DataInputStream dis;
		//������
		private DataOutputStream dos;
		
		private boolean isRunning = true;
		
		public MyChannel(Socket socket) {
			try {
				dis = new DataInputStream(socket.getInputStream());
				dos = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				isRunning = false;
			}
			
		}
		
		public String receiveMsg() {
			String msgString = null;
			try {
				msgString = dis.readUTF();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				// �����е�ͨ�����Ƴ� ������쳣��ͨ·
				allChannel.remove(this);
			}
			
			return msgString;
		}
		
		public void sendMsg(String msg) {
			if(null == msg || msg.equals("")) {
				return;
			}
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/**
		 * ����Ϣ���͸������ͻ���
		 */
		void sendMsgToOthers() {
			String msg = this.receiveMsg();
			for(MyChannel c:allChannel) {
				if(c == this) {
					continue;
				}else {
					c.sendMsg("�������������ݣ�"+msg);
				}
				
			}
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(isRunning) {
				sendMsgToOthers();
			}
		}
		
	}
}
	

