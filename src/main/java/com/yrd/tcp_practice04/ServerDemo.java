package com.yrd.tcp_practice04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Tcp接收数据的步骤：
 *   1.创建服务器端的Socket对象
 *   2.获取输入流，读数据，并把数据显示在控制台
 *   3.释放资源
 * @ClassName:ServerDemo
 * @Description:接收数据,写入文本文件
 *
 * @author:Yrd
 * @date:2021-6-13 11:12:18
 *
 */
public class ServerDemo {

	public static void main(String[] args) throws IOException {
		// 1.创建服务器端的Socket对象
		ServerSocket ssk = new ServerSocket(10000);
		
		//Socket accept() 侦听要连接到此套接字并接受它(监听客户端的连接，返回一个对应的Socket对象)
		Socket sk = ssk.accept();
		
		//2.获取输入流，读数据，并把数据显示在控制台
		InputStream is = sk.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("./src/main/java/com/yrd/tcp_practice04/s04.txt",true));
		
		String line;
		while((line=br.readLine())!=null) {
//			System.out.println("数据是:"+line);
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		
		//3.释放资源
		bw.close();
		sk.close();
		ssk.close();

	}

}
