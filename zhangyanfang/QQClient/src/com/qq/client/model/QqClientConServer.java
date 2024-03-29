/*
 * 这是客户端，连接服务器的后台
 */
package com.qq.client.model;

import com.qq.client.tools.*;
import java.util.*;
import java.net.*;
import java.io.*;
import com.qq.common.*;
public class QqClientConServer {

	public Socket s;
	
	//发送第一次请求
	public boolean SendLoginfoToServer(Object o)
	{
		boolean b=false;
		try {
			s=new Socket("127.0.0.1",9999);
			ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(o);
			
			ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
			
			Message ms=(Message)ois.readObject();
	
			//这里就是验证用户登录的地方
			if(ms.getMessType().equals("1"))
			{
				//就创建一个该qq号和服务器保持通讯连接的线程
				ClientConServerThread ccst=new ClientConServerThread(s);
				//启动该通信线程
				ccst.start();
				ManageClientConServerThread.addClientConServerThread
				(((User)o).getQum(), ccst);
				b=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return b;
	}
	
	public boolean SendSqlInfoToServer(Object o) // 传递Sql查询语句
	{

		boolean b=false;
		try {
			s=new Socket("127.0.0.1",9999);
			ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(o);
			
			ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
			
			Message ms=(Message)ois.readObject();
			if(ms.getMessType().equals("1"))
			{
				b=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return b;
	}
	
	
	public String[] SendSqlInfoToServer2(Object o)//传递查询好友，并显示在列表中
	{
		String []friend=new String[50];
		try {
			s=new Socket("127.0.0.1",9999);
			ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(o);
			
			ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
			
			Message ms=(Message)ois.readObject();
			friend=ms.getFriend();
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return friend;
	}
}
