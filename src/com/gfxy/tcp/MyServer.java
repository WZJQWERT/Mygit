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
	
	//保存所有与客户端建立的通道
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
				allChannel.add(channel); //与客户端建立的通道加入容器同一管理
				new Thread(channel).start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}
	
	
	/**
	 * 一条和客户端的通路
	 * @author Administrator
	 *
	 */
	class MyChannel implements Runnable {
		// 接收流
		private DataInputStream dis;
		//发送流
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
				
				// 从所有的通道中移除 这个出异常的通路
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
		 * 把信息发送给其他客户端
		 */
		void sendMsgToOthers() {
			String msg = this.receiveMsg();
			for(MyChannel c:allChannel) {
				if(c == this) {
					continue;
				}else {
					c.sendMsg("服务器返回数据："+msg);
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
	

