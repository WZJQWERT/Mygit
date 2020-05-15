package Server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


/**
1����������� DatagramSocket  ָ���˿�
2��׼�����������ֽ����� ��װDatagramPacket
3���� ��������
4������
5���ͷ���Դ

 * @author Administrator
 *
 */
public class Server {
    public static void main(String[] args) throws Exception {
        DatagramSocket server = new DatagramSocket(9999);
        byte[] date = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(date, date.length);
        
        
        
        while(true) {
        	server.receive(receivePacket);
        	System.out.println(new String(receivePacket.getData()));
        	
        	byte[] sendData= new String("���������յ������Ϣ��").getBytes();
        	DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,
        			receivePacket.getAddress(),receivePacket.getPort());
        	
        	server.send(sendPacket);
        }
        
    }
}