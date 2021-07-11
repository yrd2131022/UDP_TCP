package com.yrd.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Tcp接收数据的步骤：
 *   1.创建服务器端的Socket对象
 *   2.获取输入流，读数据，并把数据显示在控制台
 *   3.释放资源
 * @ClassName:ServerDemo
 * @Description:
 *
 * @author:Yrd
 * @date:2021-6-13 11:12:18
 *
 */
public class ServerDemo {

	public static void main(String[] args) throws IOException {
		// 1.创建服务器端的Socket对象
		ServerSocket ssk = new ServerSocket(10000);
		
		//Socket accept() 侦听要连接到此套接字并接受它
		Socket socket = ssk.accept();
		
		//2.获取输入流，读数据，并把数据显示在控制台
		InputStream is = socket.getInputStream();
		
		byte[] bys = new byte[1024];
		int len = is.read(bys);
		String data = new String(bys, 0, len);
		
		System.out.println("数据是:"+data);
		
		//3.释放资源
		socket.close();
		ssk.close();

	}

}
