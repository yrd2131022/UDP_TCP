package com.yrd.tcp_practice06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * TCP发送数据的步骤:
 *    1.创建客户端的Socket对象
 *    2.获取输出流，写数据
 *    3.释放资源
 *    
 * @ClassName:ClientDemo
 * @Description:数据来自于文本文件，发送数据，接收服务器反馈
 *
 * @author:Yrd
 * @date:2021-6-13 11:02:26
 *
 */
public class ClientDemo {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		//1.创建客户端的Socket对象
		Socket sk = new Socket(InetAddress.getByName("127.0.0.1"), 10000);
		
		//2.获取输出流，写数据
		//数据来自于键盘录入，直到输入的数据是886
		BufferedReader br = new BufferedReader(new FileReader("./tcpdemo.txt"));
		//封装输出流对象
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(sk.getOutputStream()));
		String line;
		while((line=br.readLine()) != null) {
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		
		//结束发送数据
		sk.shutdownOutput();
	
		//接收反馈
		BufferedReader brClient = new BufferedReader(new InputStreamReader(sk.getInputStream()));
		String data = brClient.readLine();//等待读取数据
		System.out.println("服务器的反馈："+data);
		
		//3.释放资源
//		is.close();//可以不写，sk.close();就可以了因为is，os,来自于sk
//		os.close();
		br.close();
		sk.close();
	}

}
