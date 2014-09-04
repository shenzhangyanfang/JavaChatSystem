/*
 * ���ǿͻ��ˣ����ӷ������ĺ�̨
 */
package com.qq.client.model;

import com.qq.client.tools.*;
import java.util.*;
import java.net.*;
import java.io.*;
import com.qq.common.*;
public class QqClientConServer {

	public Socket s;
	
	//���͵�һ������
	public boolean SendLoginfoToServer(Object o)
	{
		boolean b=false;
		try {
			s=new Socket("127.0.0.1",9999);
			ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(o);
			
			ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
			
			Message ms=(Message)ois.readObject();
	
			//���������֤�û���¼�ĵط�
			if(ms.getMessType().equals("1"))
			{
				//�ʹ���һ����qq�źͷ���������ͨѶ���ӵ��߳�
				ClientConServerThread ccst=new ClientConServerThread(s);
				//������ͨ���߳�
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
	
	public boolean SendSqlInfoToServer(Object o) // ����Sql��ѯ���
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
	
	
	public String[] SendSqlInfoToServer2(Object o)//���ݲ�ѯ���ѣ�����ʾ���б���
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
