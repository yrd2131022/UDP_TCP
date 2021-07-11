package com.yrd.tcp_practice06;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Tcp接收数据的步骤： 1.创建服务器端的Socket对象 2.获取输入流，读数据，并把数据显示在控制台 3.释放资源
 * 
 * @ClassName:ServerDemo
 * @Description:接收数据,写入文本文件，给出反馈
 *
 * @author:Yrd
 * @date:2021-6-13 11:12:18
 *
 */
public class ServerDemo {

	public static void main(String[] args) throws IOException {
		// 1.创建服务器端的Socket对象
		@SuppressWarnings("resource")
		ServerSocket ssk = new ServerSocket(10000);

		while (true) {
			// Socket accept() 侦听要连接到此套接字并接受它(监听客户端的连接，返回一个对应的Socket对象)
			Socket sk = ssk.accept();

			// 为每一个客户端开启一个线程
			new Thread(new ServerThread(sk)).start();
		}
		
		// 3.释放资源
//		ssk.close();

	}

}


