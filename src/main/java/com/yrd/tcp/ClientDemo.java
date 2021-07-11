package com.yrd.tcp;

import java.io.IOException;
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
 * @Description:
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
		
		//3.释放资源
		sk.close();
	}

}
