/*
 * ���ܣ��Ƿ�������ĳ���ͻ��˵�ͨ���߳�
 */

package com.qq.server.model;

import java.util.*;
import java.net.*;
import java.io.*;
import com.qq.common.*;
public class SerConClientThread extends Thread{
	
	Socket s;
	
	public SerConClientThread(Socket s)
	{
		//�ѷ�������ÿͻ��˵����Ӹ���s
		this.s=s;
	}
	
	//�ø��߳�ȥ֪ͨ�������û�
	
	public void notifyOther(String iam)
	{
		//�õ����е����ߵ���
		HashMap hm=ManageClientThread.hm;
		Iterator it=hm.keySet().iterator();
		
		while(it.hasNext())
		{
			Message m=new Message();
			m.setConn(iam);
			m.setMessType(MessageType.message_ret_onLineFriend);
			
			//ȡ�������˵�Id
			String onLineUserId=it.next().toString();
			try {
				ObjectOutputStream oos=new ObjectOutputStream(ManageClientThread.getClientThread(onLineUserId).s.getOutputStream());
				m.setGetter(onLineUserId);
				oos.writeObject(m);
			
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	public void run()
	{
		while(true)
		{
			//������߳̾Ϳ��Խ��տͻ��˵���Ϣ
			try {
				
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				Message m=(Message)ois.readObject();
				
				
				//�Դӿͻ���ȡ�õ���Ϣ���������жϣ��ú�����Ӧ�Ĵ���
				if(m.getMessType().equals(MessageType.message_comm_mes))
				{
					//ȡ�ý����˵�ͨ���߳�
					SerConClientThread sc=ManageClientThread.getClientThread(m.getGetter());
					ObjectOutputStream oos=new ObjectOutputStream(sc.s.getOutputStream());
					oos.writeObject(m);
				}else if(m.getMessType().equals(MessageType.message_get_onLineFriend))
				{
					//���ڷ������ĺ��Ѹ��ÿͻ��˷���
					String res=ManageClientThread.getAllOnLineUserid();
					Message m2=new Message();
					m2.setMessType(MessageType.message_ret_onLineFriend);
					m2.setConn(res);
					m2.setGetter(m.getSender());
					ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
					oos.writeObject(m2);	
				}
			} catch (Exception e) {
				// TODO: handle exception
				
			}
		}
	}
}
