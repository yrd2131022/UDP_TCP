package com.yrd.tcp_practice01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
 * @Description:发送数据，接收服务器端反馈
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
		OutputStream os = sk.getOutputStream();
		os.write("hello ,tcp,我来了".getBytes());
		
		//2.1接收服务器反馈
		InputStream is = sk.getInputStream();
		byte[] bys = new byte[1024];
		int len = is.read(bys);
		String data = new String(bys,0,len);
		System.out.println("客户端：服务端反馈,"+data);
				
		
		//3.释放资源
//		is.close();//可以不写，sk.close();就可以了因为is，os,来自于sk
//		os.close();
		sk.close();
	}

}
