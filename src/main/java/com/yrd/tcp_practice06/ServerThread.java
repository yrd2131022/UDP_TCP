package com.yrd.tcp_practice06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ServerThread implements Runnable {

	private Socket sk;

	public ServerThread(Socket sk) {
		this.sk = sk;
	}

	@Override
	public void run() {
		// 2.获取输入流，读数据，并把数据显示在控制台
		try {
			int count = 0;
			File file = new File("./src/main/java/com/yrd/tcp_practice06/s" + count + ".txt");
			while (file.exists()) {
				count++;
				file = new File("./src/main/java/com/yrd/tcp_practice06/s" + count + ".txt");
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
			BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));

			String line;
			// 等待读取数据,是阻塞的。读取结束时，需要客户端发送shutdownOutput()方法
			while ((line = br.readLine()) != null) {
				bw.write(line);
				bw.newLine();
				bw.flush();
			}

			// 给出反馈
			BufferedWriter bwServer = new BufferedWriter(new OutputStreamWriter(sk.getOutputStream()));
			bwServer.write("文件上传成功");
			bwServer.newLine();
			bwServer.flush();

			// 释放资源
			bw.close();
			sk.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
