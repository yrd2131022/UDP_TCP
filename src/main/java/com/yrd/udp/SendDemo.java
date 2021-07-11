package com.yrd.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 
 * @ClassName:SendDemo
 * @Description:UDP发送数据的步骤
 * 1.创建发送端的Socket对象（DatagramSocket）
 * 2.创建数据，并把数据打包
 * 3.调用DatagramSocket对象的方法发送数据
 * 4.关闭发送端
 *
 * @author:Yrd
 * @date:2021-6-11 8:43:01
 *
 */

public class SendDemo {

	public static void main(String[] args) throws IOException {
		
		//DatagramSocket() 构造数据报套接字并将其绑定到本地主机上的任何可用端口
		//1.创建发送端的Socket对象（DatagramSocket）
		DatagramSocket ds = new DatagramSocket();
		
		//2.创建数据，并把数据打包
		//DatagramPacket(byte[] buf, int length, InetAddress address, int port) 
		//构造用于发送长度为length的分组的数据报包， 指定主机上到指定的端口号。 
		byte[] bys = "hello,udp,我来了".getBytes();
		int length = bys.length;
		InetAddress address = InetAddress.getByName("192.168.0.104");
		int port = 10086;
		
		DatagramPacket dp = new DatagramPacket(bys, length, address, port);
		
		
		//3.调用DatagramSocket对象的方法发送数据
		//void send(DatagramPacket p)  从此套接字发送数据报包
		
		ds.send(dp);
		
		//4.关闭发送端
		ds.close();

	}

}
