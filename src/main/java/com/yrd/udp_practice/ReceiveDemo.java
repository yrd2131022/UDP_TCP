package com.yrd.udp_practice;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * .因为接收端不知道发送端什么时候停止发送，故采用死循环接收
 * 
 * @ClassName:ReceiveDemo
 * @Description:UDP接收数据的步骤: 1.创建接收端的Socket对象（DatagramSocket） 2.创建一个数据包，用于接收数据
 *                          3.调用DatagramSocket对象的方法接收数据 4.解析数据包，并把数据在控制台显示
 *                          5.关闭接收端
 *
 * @author:Yrd
 * @date:2021-6-11 9:49:09
 *
 */

public class ReceiveDemo {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// 1.创建接收端的Socket对象（DatagramSocket）
		DatagramSocket ds = new DatagramSocket(12345);

		while (true) {
			// 2.创建一个数据包，用于接收数据
			byte[] bys = new byte[1024];
			DatagramPacket dp = new DatagramPacket(bys, bys.length);

			// 3.调用DatagramSocket对象的方法接收数据
			ds.receive(dp);

			// 4.解析数据包，并把数据在控制台显示
			byte[] datas = dp.getData();
			// int getLength()返回要发送的数据的长度或接收到的数据的长度
			int len = dp.getLength();

			String dataString = new String(datas, 0, len);

			System.out.println("数据是：" + dataString);
		}

		// 5.关闭接收端
//		ds.close();

	}

}
